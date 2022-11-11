package chapter04;

import java.util.Arrays;

public class Compare {
    public static void main(String[] args) {
        //lexicographically
        MelonComparable[] melons1 = {new MelonComparable("first", 11), new MelonComparable("second", 22)};
        MelonComparable[] melons2 = {new MelonComparable("first", 11), new MelonComparable("second", 22)};
        MelonComparable[] melons3 = {
                new MelonComparable("first", 11),
                new MelonComparable("second", 22),
                new MelonComparable("third", 33)
        };
        //lexicographically
        System.out.println(Arrays.compare(melons1, melons3));
        System.out.println(Arrays.compare(melons1, melons2));
    }
}
