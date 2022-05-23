package command;

import java.util.ArrayList;
import java.util.List;

public class CommandDemo {

    private static List createRequest() {
        List<Command> queue = new ArrayList<>();
        queue.add(new Programmer());
        queue.add(new Politician());
        queue.add(new DomesticEngineer());
        return queue;
    }

    public static void main(String[] args) {
        List<Command> queue = createRequest();

        executeRequests(queue);
    }

    private static void executeRequests(List queue) {
        for (Object c : queue) {
            ((Command) c).execute();
        }
    }
}
