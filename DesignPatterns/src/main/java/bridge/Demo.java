package bridge;

import java.util.Random;

public class Demo {
    public static void main(String[] args) {

        StackArray[] stacks = {new StackArray(), new StackFIFO(), new StackHanoi()};
        StackList list = new StackList();

        Random rn = new Random();
        for (int i = 1; i < 15; i++) {
            stacks[0].push(i);
            list.push(i);
            stacks[1].push(i);
            stacks[2].push(rn.nextInt(20));
        }

        while (!stacks[0].isEmpty()) {
            System.out.print(stacks[0].pop() + " ");
        }

        System.out.println();
        while (!list.isEmpty()) {
            System.out.print(list.pop() + " ");
        }

        System.out.println();
        while (!stacks[1].isEmpty()) {
            System.out.print(stacks[1].pop() + " ");
        }

        System.out.println();
        System.out.print(" rejected: " + ((StackHanoi) stacks[2]).getTotalRejected());
        System.out.println();
        while (!stacks[2].isEmpty()) {
            System.out.print(stacks[2].pop() + " ");
        }
    }
}
