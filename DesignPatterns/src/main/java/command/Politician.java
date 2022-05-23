package command;

public class Politician implements Command {
    @Override
    public void execute() {
        System.out.println("Politician talks a lot");
    }
}
