package command;

public class Programmer implements Command {
    @Override
    public void execute() {
        System.out.println("Programmer fixed the bugs");
    }
}
