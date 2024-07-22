/**
 * Cotruta Valeria, A1
 */

import Homework.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Network network = new Network();
        Programmer person1 = new Programmer();//2 rel
        Programmer person2 = new Programmer();//3 rel
        Designer designer1 = new Designer();//2 rel
        Company company1 = new Company("Centric");//2 rel
        Company company2 = new Company("Quadcode");//1 rel

        company1.setnumberOfEmployees(4000);
        company2.setnumberOfEmployees(400);

        person1.setName("Ioana Lazar");
        person1.setBirthDate(2000 - 1900, 4, 13);
        person1.addProgrammingLanguage("Java");
        person1.addProgrammingLanguage("C++");

        person2.setName("Adela Matei");
        person2.setBirthDate(1970 - 1900, 10, 30);
        person2.addProgrammingLanguage("Java");
        person2.addProgrammingLanguage("Python");

        designer1.setName("Costache Radu");
        designer1.setBirthDate(1999 - 1900, 6, 15);
        designer1.setWebDesignArea("User interface design");

        person1.addRelationship(person2, "colleagues");
        person1.addRelationship(company1, "Junior Java Developer");
        person2.addRelationship(person1, "colleagues");
        person2.addRelationship(designer1, "best-friends");
        person2.addRelationship(company1, "Senior Java Developer");
        designer1.addRelationship(person2, "best-friends");
        designer1.addRelationship(company2, "Product Web Designer");
        network.addNode(person1);
        network.addNode(person2);
        network.addNode(designer1);
        network.addNode(company1);
        network.addNode(company2);

        network.computeImportance();
        System.out.println(network);

        List<String> articulationPoints = network.runTarjansAlgorithm();
        if (articulationPoints.isEmpty()) {
            System.out.println("There are no articulation points.");
        } else {
            System.out.println("There are some articulation points:");
            for (String vertex : articulationPoints) {
                System.out.println(vertex);
            }
        }
    }
}