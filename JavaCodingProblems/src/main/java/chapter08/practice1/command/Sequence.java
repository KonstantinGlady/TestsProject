package chapter08.practice1.command;

import java.util.ArrayList;
import java.util.List;

public class Sequence {

    private List<Command> sequence = new ArrayList<>();

    public void loadSequence(Command command) {
        sequence.add(command);
    }

    public void runSequence() {
        sequence.forEach(Command::execute);
    }

    public void clearSequence() {
        sequence.clear();
    }

}
