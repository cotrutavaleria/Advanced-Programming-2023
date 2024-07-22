package compulsory;

import java.sql.*;
import java.util.List;

public class Main {
    public static void main(String args[]) {
        Test test = new Test();
        test.testTheClasses();
    }
}
//TODO{
// Create a relational database using any RDBMS (Oracle, Postgres, MySql, Java DB, etc.).           DONE
// Write an SQL script that will create the following tables:
// albums: id, release year, title, artist, genre(s)                                                DONE
// artists: id, name (for example: Beatles)                                                         DONE
// genres: id, name (for example: Rock)                                                             DONE
// an associative (junction) table in order to store each album genres                              DONE
// Update pom.xml, in order to add the database driver to the project libraries.                    DONE
// Create a singleton class in order to manage a connection to the database.
// Create DAO classes that offer methods for managing artists, genres and albums (at least one).    DONE
// Implement a simple test using your classes.
// }