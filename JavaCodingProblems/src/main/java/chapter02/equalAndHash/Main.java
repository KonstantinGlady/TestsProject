package chapter02.equalAndHash;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Douglas Adams", 55);
        Person p2 = new Person("Douglas Adams", 55);

        //before overriding equals it's false because by default equals take address of references in memory. After by value name and age
        System.out.println(p2.equals(p1));

        //before overriding hashCode() it takes address in memory as int by default
        System.out.println(p1.hashCode()); //41903949
        System.out.println(p2.hashCode()); //488970385

        //HashMap, HashTable
        Set<Person> set = new HashSet<>();
        set.add(p1);
        set.add(p2);
        set.forEach(System.out::println); //2 slots in Set cause equals too slow and Set keeps meanings of objects
        // in buckets according its hashCode and it's different

        //we have after overriding hashCode()
     /*   -303951374
         - 303951374
        name Douglas Adams age 55*/
    }
}
