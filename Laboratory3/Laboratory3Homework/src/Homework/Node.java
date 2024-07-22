package Homework;

import java.util.HashMap;
import java.util.List;

public interface Node {
    String getName();
    int getConnectionNumber();
    HashMap<String, List<String>> getRelationships();
}
