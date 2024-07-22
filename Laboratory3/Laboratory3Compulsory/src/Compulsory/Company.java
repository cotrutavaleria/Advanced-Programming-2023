package Compulsory;

import java.util.ArrayList;
import java.util.List;

public class Company implements Node, Comparable<Company> {
    private String name;

    public Company(String name) {
        this.name = name;
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
}
