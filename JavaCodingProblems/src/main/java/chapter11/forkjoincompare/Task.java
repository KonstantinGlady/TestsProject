package chapter11.forkjoincompare;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.RecursiveTask;
import java.util.logging.Logger;

public class Task<Integer> extends RecursiveTask<Integer> {

    private static final Logger logger = Logger.getLogger(Task.class.getName());
    private static final short UNVISITED = 0;
    private static final short VISITED = 1;

    private final String name;
    private final Callable<Integer> callable;
    private Set<Task<Integer>> dependencies = new HashSet<>();

    @SafeVarargs
    public Task(String name, Callable<Integer> callable, Task<Integer>... dependencies) {
        this.name = name;
        this.callable = callable;
        this.dependencies = Set.of(dependencies);
    }

    @Override
    protected Integer compute() {

        dependencies.stream()
                .filter((task) -> task.updateTasksAsVisited())
                .forEachOrdered((task) -> {
                    logger.info("tagged " + task + "(" + task.getForkJoinTaskTag() + ")");
                    task.fork();
                });

        for (Task<Integer> task : dependencies) {
            task.join();
        }

        try {
            return callable.call();
        } catch (Exception ex) {
            logger.severe(() -> "Exception " + ex);
        }

        return null;
    }

    private boolean updateTasksAsVisited() {
        return compareAndSetForkJoinTaskTag(UNVISITED, VISITED);
    }

    public String toString() {
        return name;
    }
}
