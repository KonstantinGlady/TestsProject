package patterns.strategy;

public class Main {

    public static void main(String[] args) {

        Validator numericValidator = new Validator(new isNumeric());
        boolean s = numericValidator.validate("555");
        System.out.println(s);

        Validator lowerCaseValidator = new Validator(new isAllLowerCase());
        boolean s2 = lowerCaseValidator.validate("ASdd");
        System.out.println(s2);

        //lambda variant pattern without classes
        Validator lambdaNumericValidator = new Validator((st) -> st.matches("\\d+"));
        boolean l1 = lambdaNumericValidator.validate("555");
        System.out.println(l1);

        Validator lambdaLowerCaseValidator = new Validator((st)-> st.matches("[a-z]+"));
        boolean l2 = lambdaLowerCaseValidator.validate("asdf");
        System.out.println(l2);
    }
}
