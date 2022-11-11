package chapter04;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UnmodifiableImmutable {

    private static final MutableMelon melon1 = new MutableMelon("one", 1);
    private static final MutableMelon melon2 = new MutableMelon("one", 2);


    public static void main(String[] args) {


        //unmodifiable but mutable
        // final List<MutableMelon> list = List.of(melon1, melon2); Set.of, Map.of, etc.
        final List<MutableMelon> list = Collections.unmodifiableList(
                Arrays.asList(new MutableMelon("one", 1), new MutableMelon("two", 2)));// same as List.of()
        MutableMelon m = list.get(0);
        System.out.println(m);
        m.setWeight(222);
        System.out.println(m);

        //immutable
        final List<ImmutableMelon> list1 = List.of(
                new ImmutableMelon("one", 1), new ImmutableMelon("two", 2));
        ImmutableMelon m1 = list1.get(0);
        System.out.println(m1);
        //m1.setWeight(222); there is no setters, field final

        //immutable array
        ImmutableArray<String> strings = ImmutableArray.from(new String[]{"a", "b", "c"});
        System.out.println(strings);
        System.out.println(strings.get(0));

    }
}
