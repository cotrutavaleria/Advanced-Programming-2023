package Homework;

import java.util.*;

public abstract class Person implements Node, Comparable<Person> {
    public HashMap<String, List<String>> adjacencyList;
    protected String name;
    protected Date birthDate;
    protected Map<Node, String> relationships;

    public Person() {
    }

    @Override
    public abstract String getName();

    public abstract void setName(String name);

    @Override
    public abstract int compareTo(Person person);

    public abstract Date getBirthDate();

    public abstract void setBirthDate(int year, int month, int date);

    public abstract void addRelationship(Node node, String relationshipType);

    public abstract int getConnectionNumber();

    public abstract HashMap<String, List<String>> getRelationships();

    @Override
    public abstract String toString();

}
