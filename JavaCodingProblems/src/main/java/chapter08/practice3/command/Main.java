package chapter08.practice3.command;

public class Main {
    public static void main(String[] args) {

        HardDisc hd = new HardDisc();
        Sequence sequence = new Sequence();
        //oop
        sequence.recordSequence(new CopyCommand(hd));
        sequence.recordSequence(new DeleteCommand(hd));
        sequence.recordSequence(new MoveCommand(hd));
        sequence.runSequence();
        sequence.clearSequence();

        //lambda
        sequence.recordSequence(hd::copy);
        sequence.recordSequence(hd::move);
        sequence.recordSequence(hd::delete);
        sequence.runSequence();

    }
}
