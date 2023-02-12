package chapter11.forkjoinrecursiv;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.logging.Logger;

public class SumRecursiveTask extends RecursiveTask<Integer> {

    private static final Logger logger = Logger.getLogger(SumRecursiveTask.class.getName());
    private static final int THRESHOLD = 10;

    private final List<Integer> workList;

    public SumRecursiveTask(List<Integer> workList) {
        this.workList = workList;
    }

    @Override
    protected Integer compute() {

        if (workList.size() <= THRESHOLD) {
            return partialSum(workList);
        }

        return ForkJoinTask.invokeAll(createSubtasks())
                .stream()
                .mapToInt(ForkJoinTask::join)
                .sum();

    }

    private List<SumRecursiveTask> createSubtasks() {
        List<SumRecursiveTask> subTasks = new ArrayList<>();

        int size = workList.size();

        List<Integer> workListLeft = workList.subList(0, (size + 1) / 2);
        List<Integer> workListRight = workList.subList((size + 1) / 2, size);

        subTasks.add(new SumRecursiveTask(workListLeft));
        subTasks.add(new SumRecursiveTask(workListRight));

        return subTasks;
    }

    private Integer partialSum(List<Integer> workList) {

        int sum = workList.stream()
                .mapToInt(e -> e)
                .sum();

        logger.info(() -> " sum: " + sum + " Thread: " + Thread.currentThread().getName());

        return sum;
    }
}
