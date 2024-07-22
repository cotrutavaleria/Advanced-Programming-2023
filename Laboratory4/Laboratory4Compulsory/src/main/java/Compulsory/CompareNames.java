package Compulsory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import Compulsory.Student;
public class CompareNames {
    private List<Student> listOfStudents = new ArrayList<>();
    public CompareNames(List<Student> list){
        this.listOfStudents = list;
    }

    public List<Student> getListOfStudents() {
        List<Student> sortedList = this.listOfStudents.stream().sorted(Comparator.comparing(Student::getName)).collect(Collectors.toList());
        return sortedList;
    }

    @Override
    public String toString() {
        return "CompareNames{" +
                "listOfStudents=" + getListOfStudents() +
                '}';
    }
}
