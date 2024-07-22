package Compulsory;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Document implements Serializable {
    private String id;
    private String name;
    private String path;
    private Map<String, Object> tags = new HashMap<>();//name-tag value

    public Document() {
    }

    public Document(String id, String name, String path) {
        this.id = id;
        this.name = name;
        this.path = path;
    }

    public void addTag(String key, Object obj) {
        tags.put(key, obj);
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public Map<String, Object> getTags() {
        return tags;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Document doc = (Document) obj;
        if (this.id == doc.getId()) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", tags=" + tags +
                "}\n";
    }
}
