package chapter08.practice4.command;

import java.util.ArrayList;
import java.util.List;

public class Sequence {

    private final List<Command> commands = new ArrayList<>();

    public void recordSequence(Command c) {
        if (c != null) commands.add(c);
    }

    public void runSequence() {
        commands.forEach(Command::execute);
    }

    public void clearSequence() {
        commands.clear();
    }
}
