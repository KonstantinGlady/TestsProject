package chapter02.equalAndHash;

import java.util.Objects;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null) {
            return false;
        }

        if (getClass() != this.getClass()) {
            return false;
        }

        Person p = (Person) o;

        if (p.age != this.age) {
            return false;
        }

        if (!Objects.equals(p.name, this.name)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name) ^ Objects.hashCode(age);
    }

    public String toString() {
        return "name " + name + " age " + age;
    }
}
