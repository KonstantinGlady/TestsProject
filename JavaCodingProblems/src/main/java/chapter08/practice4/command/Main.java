package chapter08.practice4.command;

public class Main {

    public static void main(String[] args) {

        HardDisk hd = new HardDisk();
        Sequence sequence = new Sequence();
        sequence.recordSequence(new DeleteCommand(hd));
        sequence.recordSequence(new MoveCommand(hd));
        sequence.recordSequence(new CopyCommand(hd));
        sequence.runSequence();
        sequence.clearSequence();

        //lambda
        sequence.recordSequence(hd::copy);
        sequence.recordSequence(hd::delete);
        sequence.recordSequence(hd::move);
        sequence.runSequence();
    }
}
