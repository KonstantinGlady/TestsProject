package chapter08.practice3.command;

public class MoveCommand implements Command {

    private final IODevice action;

    public MoveCommand(IODevice action) {
        this.action = action;
    }

    @Override
    public void execute() {
        action.move();
    }
}
