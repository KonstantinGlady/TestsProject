package chapter11.forkjoincounted;

import java.util.List;
import java.util.concurrent.CountedCompleter;
import java.util.concurrent.atomic.LongAdder;
import java.util.logging.Logger;

public class SumCountedCompleter extends CountedCompleter<Long> {

    private static final Logger logger = Logger.getLogger(SumCountedCompleter.class.getName());
    private static final LongAdder sumAll = new LongAdder();
    private static final int THRESHOLD = 10;
    private final List<Integer> workList;

    public SumCountedCompleter(CountedCompleter<Long> c, List<Integer> workList) {
        super(c);
        this.workList = workList;
    }

    @Override
    public void compute() {

        if (workList.size() <= THRESHOLD) {

            partialSum(workList);
        } else {

            int size = workList.size();

            List<Integer> workListLeft = workList.subList(0, (size + 1) / 2);
            List<Integer> workListRight = workList.subList((size + 1) / 2, size);

            addToPendingCount(2);
            SumCountedCompleter leftTask = new SumCountedCompleter(this, workListLeft);
            SumCountedCompleter rightTask = new SumCountedCompleter(this, workListRight);

            leftTask.fork();
            rightTask.fork();
        }

        tryComplete();
    }

    private void partialSum(List<Integer> workList) {

        int sum = workList.stream()
                .mapToInt(e -> e)
                .sum();

        sumAll.add(sum);

        logger.info(() -> " partial sum " + workList + " " + sum + "\tThread " + Thread.currentThread().getName());
    }

    @Override
    public Long getRawResult() {
        return sumAll.sum();
    }

    @Override
    public void onCompletion(CountedCompleter<?> caller) {
        logger.info("Thread complete " + Thread.currentThread().getName());
    }
}
