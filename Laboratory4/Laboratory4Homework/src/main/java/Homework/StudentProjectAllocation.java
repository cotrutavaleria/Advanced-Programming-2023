package Homework;

import java.util.*;
import java.util.stream.Collectors;

public class StudentProjectAllocation {
    private Map<Student, List<Project>> preferences;
    private int average;

    public StudentProjectAllocation() {
        this.preferences = new HashMap<>();
    }

    public void setPreferences(Student student, List<Project> preferredProjects) {
        this.preferences.put(student, preferredProjects);
        this.average += preferredProjects.size();
    }

    //    Using Java Stream API, write a query that display all the students that have a number of preferences lower than the average number of preferences.
    public List<Student> isLowerThanPreferencesAvg() {
        List<Student> result = this.preferences.keySet().stream().filter(s -> this.preferences.get(s).size() < (average / this.preferences.size())).collect(Collectors.toList());
        return result;
    }

    //  Create a Greedy algorithm in order to solve the problem.
    public Map<Student, Project> allocationGreedyAlgorithm() {
        Map<Student, Project> allocation = new HashMap<>();
        Set<Project> allocatedProjects = new HashSet<>();

        //  Sort students by the number of preferred projects
        List<Map.Entry<Student, List<Project>>> sortedStudents = new ArrayList<>(this.preferences.entrySet());
        Collections.sort(sortedStudents, (student1, student2) -> student1.getValue().size() - student2.getValue().size());//lambda function ascending
        //  For each student, get the projects in order of their prefences (from 1 to ...)
        //  If a project was not allocated already then allocate it to the student
        for (Map.Entry<Student, List<Project>> student : sortedStudents) {
            for (Project project : student.getValue()) {
                if (!allocatedProjects.contains(project)) {
                    allocation.put(student.getKey(), project);
                    allocatedProjects.add(project);
                    break;
                }
            }
        }
        return allocation;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("StudentProjectAllocation:\n");
        for (Map.Entry p : this.preferences.entrySet()) {
            result.append(p + "\n");
        }
        result.append(average);
        return result.toString();
    }
}
