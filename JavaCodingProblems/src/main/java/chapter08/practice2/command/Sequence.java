package chapter08.practice2.command;

import java.util.ArrayList;
import java.util.List;

public class Sequence {

    private List<Command> commands = new ArrayList<>();

    public void recordSequence(Command c) {
        commands.add(c);
    }

    public void runSequence() {
        commands.forEach(Command::execute);
    }

    public void clearSequence() {
        commands.clear();
    }
}
