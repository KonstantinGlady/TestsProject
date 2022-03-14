package com.gik.testsProject.gik.lambda;

import java.util.*;
class PhbookTest{
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        List<PhoneNumber> claraPhoneNumbers = new ArrayList<>();
        claraPhoneNumbers.add(new PhoneNumber(PhoneNumberType.HOME, "723324324"));
        phoneBook.addNewPhoneNumbers("Clara", claraPhoneNumbers);

        List<PhoneNumber> kevinPhoneNumbers = new ArrayList<>();
        kevinPhoneNumbers.add(new PhoneNumber(PhoneNumberType.WORK, "1231"));
        phoneBook.addNewPhoneNumbers("Kevin", kevinPhoneNumbers);

        phoneBook.addNewPhoneNumbers("Clara", List.of(new PhoneNumber(PhoneNumberType.MOBILE, "23424279")));
        phoneBook.addNewPhoneNumbers("Paul", List.of(new PhoneNumber(PhoneNumberType.WORK, "56756335")));

        phoneBook.printPhoneBook();
    }
}
class PhoneBook {
    private final Map<String, Collection<PhoneNumber>> nameToPhoneNumbersMap = new HashMap<>();

    public void addNewPhoneNumbers(String name, Collection<PhoneNumber> numbers) {
        // write your code here
        nameToPhoneNumbersMap.compute(name, (s, phNumbers) -> {

            Collection<PhoneNumber> tmp;
            if (Objects.nonNull(phNumbers)) {
                tmp = phNumbers;
                tmp.addAll(numbers);
            } else {
                tmp = numbers;
            }
            return tmp;
        });
    }

    public void printPhoneBook() {
        // write your code here
        nameToPhoneNumbersMap.forEach((x, y) -> {
            System.out.println(x);
            y.forEach(t -> System.out.printf("%s: %s\n",t.getType().name(), t.getNumber()));
        });
    }
}

enum PhoneNumberType {
    MOBILE, HOME, WORK,
}

class PhoneNumber {

    private PhoneNumberType type;
    private String number;

    public PhoneNumber(PhoneNumberType type, String number) {
        this.type = type;
        this.number = number;
    }

    public PhoneNumberType getType() {
        return type;
    }

    public String getNumber() {
        return number;
    }
}
