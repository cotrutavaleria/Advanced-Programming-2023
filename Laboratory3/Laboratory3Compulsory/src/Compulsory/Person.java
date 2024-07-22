package Compulsory;

import java.util.ArrayList;
import java.util.List;

public class Person implements Node, Comparable<Person> {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int compareTo(Person person) {
        if (this.name != null && person.name != null) {
            return this.name.compareTo(person.name);
        }
        return -1;
    }

}
