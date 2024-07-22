/**
 * Cotruta Valeria, A1
 */

import Compulsory.Company;
import Compulsory.Node;
import Compulsory.Person;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Node> nodes = new ArrayList<>();
        Node person1 = new Person("Valeria");
        Node company1 = new Company("Forte Group");
        Node person2 = new Person("Adelina");
        nodes.add(person1);
        nodes.add(company1);
        nodes.add(person2);
        for (Node node : nodes){
            System.out.println(node.getName());
        }
    }
}