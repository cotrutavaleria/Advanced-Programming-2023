package Homework;

import java.util.*;

public class Company implements Node, Comparable<Company> {
    private String name;
    private int connectionNumber;
    private int numberOfEmployees;
    private HashMap<String, List<String>> adjacencyList;
    public Company(String name) {
        this.name = name;
        this.numberOfEmployees = 0;
        this.connectionNumber = 0;
        this.adjacencyList = new HashMap<>();

    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int compareTo(Company company) {
        if (this.name != null && company.name != null)
            return this.name.compareTo(company.name);
        return -1;
    }
    public void setnumberOfEmployees(int nrOfEmployees){
        this.numberOfEmployees = nrOfEmployees;
    }
    public int getnumberOfEmployees(){
        return this.numberOfEmployees;
    }

    public int getConnectionNumber(){
        return this.connectionNumber;
    }
    public void setConnectionNumber(){
        this.connectionNumber++;
    }
    public void setCompanyRelationships(String person) {
        this.adjacencyList.putIfAbsent(this.name, new ArrayList<>());
        this.adjacencyList.get(this.name).add(person);
    }
    @Override
    public HashMap<String, List<String>> getRelationships() {
        return this.adjacencyList;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + ", number of employees: " + this.numberOfEmployees + ", number of connections: " + getConnectionNumber();
    }
}
