package chapter08.practice3.command;


public class DeleteCommand implements Command {
    private final IODevice action;

    public DeleteCommand(IODevice action) {
        this.action = action;
    }

    @Override
    public void execute() {

        action.delete();
    }
}
