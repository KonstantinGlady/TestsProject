package primeFactors;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

import static primeFactors.PrimeFactors.generate;

public class PrimeFactorsTest extends TestCase {

    private List<Integer> list(int... ints) {
        List<Integer> list = new ArrayList<>();
        for (int i : ints) {
            list.add(i);
        }
        return list;
    }

    public void testOne() throws Exception {
        assertEquals(list(), generate(1));
    }

    public void testTwo() {
        assertEquals(list(2), generate(2));
    }

    public void testThree() {
        assertEquals(list(3), generate(3));
    }

    public void testFour() {
        assertEquals(list(2, 2), generate(4));
    }

    public void testSix() {
        assertEquals(list(2, 3), generate(6));
    }

    public void testEight() {
        assertEquals(list(2, 2, 2), generate(8));
    }

    public void testNine() {
        assertEquals(list(3, 3), PrimeFactors.generate(9));
    }
}
