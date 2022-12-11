package chapter09.hamcrest;

import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringOperations {

    public static final Function<String, String> firstAndLastChar = s ->
            String.valueOf(s.charAt(0)) + String.valueOf(s.charAt(s.length() - 1));

    public List<String> rngStringFromStrings(List<String> list) {
        return list.stream()
                .map(StringOperations::extractCharacter)
                .collect(Collectors.toList());
    }

    public static String extractCharacter(String str) {

        Random rnd = new Random();
        int rn = rnd.nextInt(str.length());
        String strAsChar = String.valueOf(str.charAt(rn));

        return strAsChar;
    }
}
