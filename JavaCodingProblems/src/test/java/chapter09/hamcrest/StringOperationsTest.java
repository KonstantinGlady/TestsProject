package chapter09.hamcrest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;


import static chapter09.hamcrest.StringOperations.extractCharacter;
import static chapter09.hamcrest.StringOperations.firstAndLastChar;

class StringOperationsTest {

    @Test
    void testFirstAndLastCharacter() {

        String str = "Lambda";
        String result = firstAndLastChar.apply(str);

        Assertions.assertEquals("La", result);
    }

    @Test
    void testExtractCharacter() {

        String str1 = "Some";
        String str2 = "random";
        String str3 = "strings";

        String result1 = extractCharacter(str1);
        String result2 = extractCharacter(str2);
        String result3 = extractCharacter(str3);

        assertThat(str1, containsString(result1));
        assertThat(str2, containsString(result2));
        assertThat(str3, containsString(result3));
    }
}