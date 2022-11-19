package chapter08.command;

public class CopyCommand implements Command {

    private final IODevice action;

    public CopyCommand(IODevice action) {
        this.action = action;
    }

    @Override
    public void execute() {
        action.copy();
    }
}
