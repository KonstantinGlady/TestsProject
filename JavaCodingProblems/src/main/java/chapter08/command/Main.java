package chapter08.command;

public class Main {

    public static void main(String[] args) {

        System.out.println("OOP approach");
        HardDisc hd = new HardDisc();
        Sequence sequence = new Sequence();

        sequence.recordSequence(new CopyCommand(hd));
        sequence.recordSequence(new MoveCommand(hd));
        sequence.recordSequence(new DeleteCommand(hd));

        sequence.runSequence();
        sequence.clearSequence();

        System.out.println("\n Lambda");
        sequence.recordSequence(hd::copy);
        sequence.recordSequence(hd::move);
        sequence.recordSequence(hd::delete);
        sequence.runSequence();
    }
}
