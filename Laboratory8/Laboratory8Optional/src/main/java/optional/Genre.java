package optional;

public class Genre extends Table {
    private String name;

    public Genre(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
