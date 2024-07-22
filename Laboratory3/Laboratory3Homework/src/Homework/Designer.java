package Homework;

import java.util.*;

public class Designer extends Person {
    private String webDesignArea;

    public Designer() {
        this.webDesignArea = null;
        this.birthDate = new Date();
        this.adjacencyList = new HashMap<>();
        this.relationships = new HashMap<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Person person) {
        if (this.name != null && person.name != null)
            return this.name.compareTo(person.name);
        return -1;
    }

    public Date getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(int year, int month, int date) {
        this.birthDate.setYear(year);
        this.birthDate.setMonth(month);
        this.birthDate.setDate(date);
    }

    public void addRelationship(Node node, String relationshipType) {
        this.relationships.put(node, relationshipType);
        this.adjacencyList.putIfAbsent(this.name, new ArrayList<>());
        this.adjacencyList.get(this.name).add(node.getName());
        if (node.getClass() == Company.class) {
            ((Company) node).setConnectionNumber();
            ((Company)node).setCompanyRelationships(this.name);
        }
    }
    public String getWebDesignArea() {
        return this.webDesignArea;
    }

    public void setWebDesignArea(String area) {
        this.webDesignArea = area;
    }

    public int getConnectionNumber() {
        return relationships.entrySet().size();
    }

    @Override
    public HashMap<String, List<String>> getRelationships() {
        return this.adjacencyList;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + ", birthDate: " + this.birthDate + ", web design area: " + this.webDesignArea
                + ", number of relationships: " + getConnectionNumber();
    }

}
