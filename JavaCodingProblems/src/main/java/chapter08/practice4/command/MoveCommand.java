package chapter08.practice4.command;

public class MoveCommand implements Command {

    private IODevice action;

    public MoveCommand(IODevice action) {
        this.action = action;
    }

    @Override
    public void execute() {
        action.move();
    }
}
