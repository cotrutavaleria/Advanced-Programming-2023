package bonus;


import optional.Table;

public class Playlist extends Table {
    private String name, creationTimestamp;

    public Playlist(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
    }

    public String getCreationTimestamp() {
        return creationTimestamp;
    }

    public void setCreationTimestamp(String creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }

    @Override
    public String toString() {
        return "Playlist{" + "id=" + id +
                ", name='" + name + '\'' +
                ", creationTimestamp='" + creationTimestamp + '\'' +
                '}';
    }
}
