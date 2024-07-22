package Compulsory;

public class Project implements Comparable<Project> {
    private String name;

    public Project(String name) {
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    @Override
    public int compareTo(Project other) {
        if (other == null) throw new NullPointerException();
        if (!(other instanceof Project))
            throw new ClassCastException("Uncomparable objects!");
        Project project = (Project) other;
        return this.name.compareTo(project.name);
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                '}';
    }
}
