package Homework;

import com.github.javafaker.Faker;
import org.graph4j.Graph;
import org.graph4j.GraphBuilder;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Faker faker = new Faker();
        var students = IntStream.rangeClosed(0, 2).mapToObj(i -> new Student(faker.name().fullName())).toArray(Student[]::new);
        var projects = IntStream.rangeClosed(0, 2).mapToObj(i -> new Project(faker.app().name())).toArray(Project[]::new);

        List<Student> listOfStudents = new ArrayList<>();
        for (Student s : students) {
            listOfStudents.add(s);
        }
        List<Student> newSortedList = listOfStudents.stream().sorted(Comparator.comparing(Student::getName)).collect(Collectors.toList());//Lista de proiecte ordonata dupa metoda getName() din clasa Project
        System.out.println(newSortedList);

        TreeSet<Project> projectsTree = new TreeSet<>();
        for (Project p : projects) {
            projectsTree.add(p);
        }
        TreeSet<Project> newSortedTree = projectsTree.stream().sorted(Comparator.comparing(Project::getName)).collect(Collectors.toCollection(TreeSet::new));//Lista de proiecte ordonata dupa metoda getName() din clasa Project
        System.out.println(newSortedTree);

        StudentProjectAllocation allocation = new StudentProjectAllocation();
        List<Project> projectList= new ArrayList<Project>(newSortedTree);//converted the TreeSet to a List
        allocation.setPreferences(newSortedList.get(0), Arrays.asList(projectList.get(0), projectList.get(1), projectList.get(2)));
        allocation.setPreferences(newSortedList.get(1), Arrays.asList(projectList.get(0), projectList.get(1)));
        allocation.setPreferences(newSortedList.get(2), Arrays.asList(projectList.get(0)));
        System.out.println("Students that have a number of preferences lower than the average number of preferences: " + allocation.isLowerThanPreferencesAvg());
        System.out.println(allocation.allocationGreedyAlgorithm());


    }
}