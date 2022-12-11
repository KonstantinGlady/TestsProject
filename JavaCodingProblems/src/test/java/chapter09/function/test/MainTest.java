package chapter09.function.test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static chapter09.function.test.Main.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MainTest {
    /**
     * Method under test: {@link Main#replace(List, Replacer)}
     */
    @Test
    void testReplaceString() {

        List<String> list = Arrays.asList("Anna is 14", "Duo el 22", "Er en 44");

        List<String> resultW = replace(list, s -> s.replaceAll("\\s", ""));
        List<String> resultD = replace(list, s -> s.replaceAll("\\d", ""));

        assertEquals(Arrays.asList("Anna is ", "Duo el ", "Er en "), resultD);
        assertEquals(Arrays.asList("Annais14", "Duoel22", "Eren44"), resultW);
    }

    /**
     * Method under test: {@link Main#reduce(Function[])}
     */
    @Test
    @SuppressWarnings("uncecked")
    void testReduce() {
        Function<String, String> f1 = s -> s.toUpperCase();
        Function<String, String> f2 = s -> s.concat(" DONE");

        Function<String, String> function = reduce(f1, f2);
        assertEquals("TEST DONE", function.apply("test"));
    }
}

