package chapter08.practice1.command;

public class Main {
    public static void main(String[] args) {

        HardDisc hd = new HardDisc();
        Sequence sequence = new Sequence();

        //oop
        sequence.loadSequence(new CopyCommand(hd));
        sequence.loadSequence(new DeleteCommand(hd));
        sequence.loadSequence(new MoveCommand(hd));

        sequence.runSequence();
        sequence.clearSequence();

        //lambda
        sequence.loadSequence(hd::copy);
        sequence.loadSequence(hd::move);
        sequence.loadSequence(hd::delete);
        sequence.runSequence();
    }
}
