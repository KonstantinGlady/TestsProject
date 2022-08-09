package chapter01;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.math.BigInteger;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class WorkWithStrings {

    public static void main(String[] args) {

        String s = "asdfljasdflkjl;lkjdeisfasdfs";
        String s2 = "asdf1asdf";
        String s3 = "asdf1 asdf2 asdf3";
        String s4 = "2345";
        List<String> strings = new ArrayList<>(Arrays.asList("asdf", " zxcvasdf", "qwerwer", "osldfj"));
        String[] arr = {"asdf", "asdfsl", "zxclsdfsdf", "asdfoxlsdfjsasd", "ads"};

        countDuplicates(s);
        countDuplicatesLambda(s);

        findFirstNonrepeatedChar(s);
        findFirstNonrepeatedCharASCII(s);

        System.out.println("reversed string: " + reverseChars(s3));
        System.out.println("reversed string: " + reverseCharsLambda(s3));
        System.out.println("reverse words: " + reverseWordsLambda(s3));

        System.out.println("is string contains only digits? " + containsOnlyDigits(s4));
        System.out.println("is string contains only digits? " + containsOnlyDigitsLambda(s4));

        countingVowels(s);
        System.out.println(countVowelsAndConsonants(s));
        System.out.println(countVowelsAndConsonantsLambda(s));
        System.out.println(countVowelsAndConsonantsLambda2(s));

        occurrencesChars('a', s);
        System.out.println("count letters: " + occurrencesCharsLambda('a', s));

        convertStringToNumber(s4);

        System.out.println("remove white spaces: " + removeWhiteSpacesFromString(s3));

        System.out.println("join with delimiter: " + joinStringsWithDelimiter(strings, " "));

        System.out.println("Word is palindrome: " + isPalindrome("madam"));
        System.out.println("Word is palindrome: " + isPalindromeReverse("madam"));

        System.out.println(s3 + " remove duplicates " + removeDuplicates(s3));
        System.out.println(s3 + " remove duplicates " + removeDuplicatesBuilder(s3));
        System.out.println(s3 + " remove duplicates " + removeDuplicatesBuilder2(s3));
        System.out.println(s3 + " remove duplicates " + removeDuplicatesLambda(s3));

        System.out.println("remove char from string: " + removeCharacter('a', s3));
        System.out.println("remove char from string: " + removeCharacterLambda('a', s3));

        System.out.println("find char with the most appearances " + findCharWithMostAppearances(s3));
        System.out.println("find char with the most appearances " + findCharWithMostAppearancesLambda(s3));
        System.out.println("sort array of string " + Arrays.toString(sortArrayByLength(arr)));
        sortArrayByLength2(arr);

        System.out.println("contains substring " + stringContainsSubstring("asdf", "werolkjasdfllxnlkj"));
        System.out.println("count substring " + countSubstringInString("asdf", "werolkjasdfllxnlkjasdfxxzcvzxcasdf"));
        System.out.println("count substring " + countSubstringInString2("asdf", "werolkjasdfllxnlkjasdfxxzcvzxcasdf"));

        System.out.println("words are anagram " + isAnagram("asdf", "Dafs"));
        System.out.println("words are anagram " + isAnagram2("asdf", "Dafs"));
        System.out.println("words are anagram " + isAnagram3("asdf", "Dafs"));

        declaringMultilineStrings("asdf", "K;lkj;l", "ewrqewrr", "xcvbx");

        concatenateStringNtimes("asdf", 5);
        concatenateStringNtimes2("asdf", 5);
        concatenateStringNtimes3("asdf", 5);

        System.out.print("start");
        System.out.print(removeLeadingAndTrailingSpaces("   qwer    "));
        System.out.println("end");

        String[] str = {"abc", "abcd", "ab", "abcde"};
        String[] words = {"abclkj;", "abcqwers", "abcd.,m", "abcoertw"};
        findLongestPrefix(str, words);

        identifyText();

        transformingString("Goool!");

        computeMinAndMax(234, 56);

        summingTwoLarge(Long.MAX_VALUE, Long.MAX_VALUE);

        stringToUnsignedInt("76");
        stringToUnsignedIntLambda("76");
        intToUnsignedLong();
        BigIntIntoPrimitive();
        longIntoInt();
        computeFloorAndModule();
        nextDouble();
        multiplyOverflow();
        fma();

    }

    private static void fma() {
        float n = Math.fma(234, 345, 234);
        System.out.println("efficient way for (x * y) + z" + n);//optimized on processor level. since java 9
    }

    private static void multiplyOverflow() {
        int i = Math.multiplyExact(1234, 12340);
        System.out.println("multiply exact " + i);

        BinaryOperator<Integer> operator = Math::multiplyExact;
        int i2 = operator.apply(1234, 1234);
        System.out.println(i2);
    }

    private static void nextDouble() {
        double v = Math.nextUp(12.3);
        double v1 = Math.nextDown(14.5);
        System.out.println(v1 + " " + v);
        double v2 = Math.nextAfter(12.3, Double.NEGATIVE_INFINITY);//old , slower way
        System.out.println(v2);
    }

    private static void computeFloorAndModule() {
        int i = Math.floorDiv(-222, 14);
        int i2 = -222 / 14;
        int i1 = Math.floorMod(-222, 14);
        System.out.println("floorDiv gives: " + i + " and / gives " + i2);
        System.out.println(i1);
    }

    private static void longIntoInt() {
        long l = 1234L;
        int i = Math.toIntExact(l);//if number higher than int capacity throw ArithmeticException, both approach below give -1
        System.out.println(i);

        int i1 = Long.valueOf(12345L).intValue();
        System.out.println(i1);

        int i2 = (int) 1234L;
        System.out.println(i2);
    }

    private static void BigIntIntoPrimitive() {
        BigInteger bn = BigInteger.valueOf(Long.MAX_VALUE);
        long l = bn.longValueExact();
        System.out.println(l);
    }

    private static void intToUnsignedLong() {
        var n = Integer.toUnsignedLong(Integer.MIN_VALUE);
        System.out.println("unsigned " + n);
    }

    private static void stringToUnsignedIntLambda(String s) {
        int i = IntStream.of(Integer.parseUnsignedInt(s)) // gives exception if leading -
                .findFirst()
                .getAsInt();
        System.out.println("string to int unsigned " + i);
    }

    private static void stringToUnsignedInt(String s) {
        int n = Integer.parseUnsignedInt(s);// gives exception if leading -
        System.out.println("string to int unsigned " + n);
    }

    private static void summingTwoLarge(long x, long y) {
        var sum = x + y;//not working it gives -2
        System.out.println("sum: " + sum);
        // long l = Math.addExact(x, y);// working. gives ArithmeticException
        //System.out.println(l);
    }

    private static void computeMinAndMax(int x, int y) {
        System.out.println(Math.max(x, y));
        System.out.println(Integer.min(x, y));

        var n = BinaryOperator.maxBy(Double::compare).apply(22.5, 44.2);
        System.out.println(n);
    }

    private static void transformingString(String s) {
        String result = Stream.of(s)
                .map(String::toUpperCase)
                .map(c -> c.repeat(2))
                .map(n -> n.replaceAll("o", "ooo"))
                .findFirst()
                .get();
        System.out.println("replace " + result);
    }

    private static void identifyText() {
        String html = "<html>";
        String body = "<body>";
        String h2 = "<h2>";
        String text = "Hello World!";
        String closeH2 = "</h2>";
        String closeBody = "</body>";
        String closeHtml = "</html>";

     /*   System.out.println(html.ident(0) + body.ident(4) + h2.ident(8) + text.ident(12) //since java 12
         + closeH2.ident(8) + closeBody.ident(4) + closeHtml.ident(0));*/
    }


    private static void findLongestPrefix(String[] str, String[] words) {

        String biggest = "";
        String current = "";

        for (String s : str) {
            current = s;
            for (String word : words) {
                if (!word.contains(current)) {
                    current = "";
                    break;
                }
            }
            biggest = current.length() > biggest.length() ? current : biggest;
        }
        System.out.println("biggest prefix is: " + biggest);
    }


    private static String removeLeadingAndTrailingSpaces(String str) {
        //  return str.trim(); //doesn't work with unicode
        return str.strip();
    }

    private static void concatenateStringNtimes3(String str, int n) {
        IntStream.range(0, 4).forEach(x -> System.out.println(str));
    }

    private static void concatenateStringNtimes2(String str, int n) {
        System.out.println(str.repeat(n));
    }

    private static void concatenateStringNtimes(String str, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(str);
        }
    }

    private static void declaringMultilineStrings(String s1, String s2, String s3, String s4) {
        String LS = System.lineSeparator();
        String s = String.join(LS, s1, LS, s2, LS, s3, LS, s4);
        s.lines().forEach(System.out::println);
    }

    private static boolean isAnagram3(String str, String str2) {
        int ASCII_TABLE = 256;
        if (str == null || str2 == null || str.isBlank() || str2.isBlank()) {
            return false;
        }

        var arr = new int[ASCII_TABLE];
        var st = str.toLowerCase().replaceAll("\\s", "").toCharArray();
        var st2 = str2.toLowerCase().replaceAll("\\s", "").toCharArray();

        for (int i = 0; i < st.length; i++) {
            arr[st[i]]++;
            arr[st2[i]]--;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                return false;
            }
        }
        return true;

    }

    private static boolean isAnagram2(String str, String str2) {
        if (str == null || str2 == null || str.isBlank() || str2.isBlank()) {
            return false;
        }
        str = str.toLowerCase().replaceAll("\\s", "");
        str2 = str2.toLowerCase().replaceAll("\\s", "");

        if (str.length() != str2.length()) {
            return false;
        }
        return Arrays.equals(
                str.chars().sorted().toArray(),
                str2.chars().sorted().toArray()
        );
    }

    private static boolean isAnagram(String str, String str2) {

        if (str == null || str2 == null || str.isBlank() || str2.isBlank()) {
            return false;
        }
        var st = str.toLowerCase().replaceAll("\\s", "").toCharArray();
        var st2 = str2.toLowerCase().replaceAll("\\s", "").toCharArray();

        if (st2.length != st.length) {
            return false;
        }
        Arrays.sort(st);
        Arrays.sort(st2);

        return Arrays.equals(st, st2);
    }

    private static int countSubstringInString2(String sub, String str) {
        int position = 0;
        int n = sub.length();
        int count = 0;
        while ((position = str.indexOf(sub, position)) != -1) {
            position = position + n;
            count++;
        }
        return count;
    }

    private static int countSubstringInString(String sub, String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < sub.length(); j++) {
                if (sub.charAt(j) != str.charAt(i + j)) {
                    break;
                }
                count++;
            }
        }
        return count / sub.length();
    }

    private static boolean stringContainsSubstring(String sub, String str) {
        return str.contains(sub);
    }

    private static void sortArrayByLength2(String[] arr) {
        Arrays.sort(arr, Comparator.comparingInt(String::length));
        System.out.println(Arrays.toString(arr));
    }

    private static String[] sortArrayByLength(String[] arr) {
        return Arrays.stream(arr)
                .sorted(Comparator.comparingInt(String::length))
                .toArray(String[]::new);
    }

    private static Pair<Character, Long> findCharWithMostAppearancesLambda(String str) {
        return str.chars()
                .filter(ch -> !Character.isWhitespace(ch))
                .mapToObj(o -> (char) o)
                .collect(Collectors.groupingBy(g -> g, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(e -> Pair.of(e.getKey(), e.getValue()))
                .orElse(Pair.of(Character.MIN_VALUE, -1L));
    }

    private static String findCharWithMostAppearances(String str) {
        var v = Arrays.stream(str.split(""))
                .filter(s -> !s.equals(" "))
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
        System.out.println(v);
        return v.entrySet().stream().max(Map.Entry.comparingByValue()).get().toString();
    }

    private static String removeCharacterLambda(char c, String str) {
        return str.chars()
                .filter(ch -> ch != c)
                .mapToObj(o -> String.valueOf((char) o))
                .collect(Collectors.joining());
    }

    private static String removeCharacter(char c, String str) {
        return str.replaceAll(Pattern.quote(String.valueOf(c)), "");//pattern.quote - for removing speccial simbols like [ ]{ etc
    }

    private static String removeDuplicatesLambda(String str) {
        return Arrays.stream(str.split(""))
                .distinct()
                .collect(Collectors.joining());
    }

    private static String removeDuplicatesBuilder2(String str) {
        Set<Character> unique = new HashSet<>();
        StringBuilder stb = new StringBuilder();
        var chars = str.toCharArray();
        for (char c :
                chars) {
            if (unique.add(c)) {
                stb.append(c);
            }
        }
        return stb.toString();
    }

    private static String removeDuplicatesBuilder(String str) {
        StringBuilder stb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (stb.indexOf(String.valueOf(c)) == -1) {
                stb.append(c);
            }
        }
        return stb.toString();
    }

    private static String removeDuplicates(String str) {
        Set<Character> unique = new HashSet<>();
        for (char c : str.toCharArray()) {
            unique.add(c);
        }
        return unique.toString();
    }

    private static boolean isPalindromeLambda(String str) {
        return IntStream.range(0, str.length() / 2)
                .noneMatch(p -> str.charAt(p) != str.charAt(str.length() - p - 1));
    }

    private static boolean isPalindromeReverse(String str) {
        return str.equals(new StringBuilder(str).reverse().toString());
    }

    private static boolean isPalindrome(String str) {
        var n = str.length();
        for (int i = 0; i < n / 2; i++) {
            if (str.charAt(i) != str.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }

    private static String joinStringsWithDelimiter(List<String> strings, String delimiter) {
        // return strings.stream().collect(Collectors.joining(delimiter));

        return String.join(delimiter, strings);
    }

    private static String removeWhiteSpacesFromString(String str) {
        return str.replaceAll("\\s", "");
    }

    private static long occurrencesCharsLambda(char a, String s) {
        return s.chars()
                .mapToObj(c -> (char) c)
                .filter(ch -> ch == a).count();
    }

    private static Pair<Long, Long> countVowelsAndConsonantsLambda2(String str) {
        Set<Character> allVowels = new HashSet<>(Arrays.asList('a', 'o', 'e', 'i', 'u'));
        Map<Boolean, Long> result = str.chars()
                .mapToObj(c -> (char) c)
                .filter(ch -> ch >= 'a' && ch <= 'z')
                .collect(Collectors.partitioningBy(allVowels::contains, Collectors.counting()));
        return Pair.of(result.get(true), result.get(false));
    }

    private static Pair<Long, Long> countVowelsAndConsonantsLambda(String str) {
        Set<Character> allVowels = new HashSet<>(Arrays.asList('a', 'o', 'e', 'i', 'u'));
        str = str.toLowerCase();

        Long vowels = str.chars()
                .filter(c -> allVowels.contains((char) c))
                .count();

        Long consonants = str.chars()
                .filter(c -> !allVowels.contains((char) c))
                .filter(ch -> ch >= 'a' && ch <= 'z')
                .count();
        return Pair.of(vowels, consonants);
    }

    private static Pair<Integer, Integer> countVowelsAndConsonants(String str) {
        str = str.toLowerCase();
        int vowels = 0;
        int consonants = 0;

        HashSet<Character> allVowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (allVowels.contains(ch)) {
                vowels++;
            } else if (ch >= 'a' && ch <= 'z') {
                consonants++;
            }
        }
        return Pair.of(vowels, consonants);
    }

    private static boolean containsOnlyDigitsLambda(String str) {
        return !str.chars()
                .anyMatch(ch -> !Character.isDigit(ch));

    /*  return  str.chars()
                .allMatch(Character::isDigit);*/
    }

    private static String reverseWordsLambda(String str) {
        Pattern PATTERN = Pattern.compile(" +");
        return PATTERN.splitAsStream(str)
                .map(w -> new StringBuilder(w).reverse())
                .collect(Collectors.joining(" "));
    }

    private static String reverseCharsLambda(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    private static void findFirstNonrepeatedCharASCII(String s) {
        int asciiCodes = 256;

        int[] flags = new int[asciiCodes];

        for (int i = 0; i < asciiCodes; i++) {
            flags[i] = -1;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (flags[c] == -1) {
                flags[c] = i;
            } else {
                flags[c] = -2;
            }
        }

        int position = Integer.MAX_VALUE;
        for (int i = 0; i < asciiCodes; i++) {

            if (flags[i] >= 0) {
                position = Math.min(position, flags[i]);
            }
        }
        var n = position == Integer.MAX_VALUE ? Character.MIN_VALUE : position;
        System.out.println("unique value " + s.charAt(n));
    }

    private static void countDuplicatesLambda(String s) {
        Map<Character, Long> map = s.chars()
                .mapToObj(value -> (char) value)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        System.out.println(" counting duplicates lambda " + map);
    }

    private static void convertStringToNumber(String s4) {

        int n = Integer.parseInt(s4);
        System.out.println(n);

    }

    private static void occurrencesChars(char a, String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            var v = s.charAt(i);
            if (v == a) {
                count++;
            }
        }
        System.out.println("Character " + a + " occurrence " + count + " times.");
    }

    private static void countingVowels(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            var v = s.charAt(i);
            if (v == 'a' || v == 'e' || v == 'i' || v == 'o' || v == 'u') {
                count++;
            }
        }
        System.out.println("count vowels: " + count);
    }

    private static boolean containsOnlyDigits(String s4) {
        for (int i = 0; i < s4.length(); i++) {

            // var v = String.valueOf(s4.charAt(i));
            // if (!v.matches("\\d")) {

            if (!Character.isDigit(s4.charAt(i))) { //isDigit() - is faster the through matches()
                return false;
            }
        }
        return true;
    }


    private static String reverseChars(String s) {
        String tmp = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            tmp += s.charAt(i);
        }
        return tmp;
    }

    private static void findFirstNonrepeatedChar(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            boolean unique = true;
            for (int j = i + 1; j < s.length(); j++) {
                if (c == s.charAt(j)) {
                    unique = false;
                    break;
                }
            }
            if (unique) {
                System.out.println("unique value " + c);
                break;
            }
        }
    }

    private static void countDuplicates(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            //  map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            char ch = s.charAt(i);
            map.compute(ch, (k, v) -> v == null ? 1 : ++v);
        }
        System.out.println("count duplicates " + map);
    }
}
