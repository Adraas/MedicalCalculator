package dao;

import java.sql.SQLException;
import java.util.List;

public interface IDao<Entity> {

    /**create*/
    void add(Entity entity) throws SQLException;

    /**read*/
    List<Entity> getAll() throws SQLException;

    Entity getById(String id) throws SQLException;

    /**update*/
    void update(Entity entity) throws SQLException;

    /**delete*/
    void remove(Entity entity) throws SQLException;
}
