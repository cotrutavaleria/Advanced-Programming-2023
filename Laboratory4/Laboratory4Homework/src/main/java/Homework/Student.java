package Homework;

public class Student implements Comparable<Student> {
    private String name;

    public Student(String name) {
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    @Override
    public int compareTo(Student other) {
        if (other == null) throw new NullPointerException();
        if (!(other instanceof Student))
            throw new ClassCastException("Uncomparable objects!");
        Student student = (Student) other;
        return this.name.compareTo(student.name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}