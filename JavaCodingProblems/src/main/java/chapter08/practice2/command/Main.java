package chapter08.practice2.command;

public class Main {

    public static void main(String[] args) {

        //oop
        IODevice hd = new HardDrive();
        Sequence sequence = new Sequence();
        sequence.recordSequence(new CopyCommand(hd));
        sequence.recordSequence(new DeleteCommand(hd));
        sequence.recordSequence(new MoveCommand(hd));
        sequence.runSequence();
        sequence.clearSequence();

        //lambda
        sequence.recordSequence(hd::copy);
        sequence.recordSequence(hd::delete);
        sequence.recordSequence(hd::move);
        sequence.runSequence();
    }
}
