package optional;

import java.sql.SQLException;
import java.util.List;

public interface Dao<T> {

    List<T> getAll() throws SQLException;

    void create(T t) throws SQLException;

    List<T> findById(int id) throws SQLException;

    List<T> findByName(String name) throws SQLException;

}