package Compulsory;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        var students = IntStream.rangeClosed(0,2).mapToObj(i->new Student("S"+i)).toArray(Student[]::new);
        var projects = IntStream.rangeClosed(0,2).mapToObj(i->new Project("P"+i)).toArray(Project[]::new);
        List<Student> listOfStudents = new ArrayList<>();
        for(Student s: students){
            listOfStudents.add(s);
        }
        CompareNames comparator = new CompareNames(listOfStudents);//Lista studentilor sortata
        System.out.println(comparator);

        TreeSet<Project> projectsTree = new TreeSet<>();
        for(Project p: projects){
            projectsTree.add(p);
        }
        TreeSet<Project> newSortedTree = projectsTree.stream().sorted(Comparator.comparing(Project::getName)).collect(Collectors.toCollection(TreeSet::new));//Lista de proiecte ordonata dupa metoda getName() din clasa Project
        System.out.println(newSortedTree);
    }
}