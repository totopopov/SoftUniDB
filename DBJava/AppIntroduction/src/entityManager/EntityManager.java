package entityManager;


import connection.ConnectionManager;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.SQLException;

public class EntityManager implements DBContext{
    private Connection conn;


    public EntityManager() throws SQLException {
      this.conn=ConnectionManager.getConnection();
    }

    @Override
    public <E> boolean persist(E entity) {
        String tableName=entity.getClass().getSimpleName().toLowerCase();

        Field[] declaredFields = entity.getClass().getDeclaredFields();

        StringBuilder sb=new StringBuilder();

        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            String simpleName = declaredField.getType().getSimpleName();
        }

        String query="CREATE TABLE IF NOT EXIST " + tableName+"("+
                "";

        return false;
    }

    @Override
    public void close() throws Exception {
            this.conn.close();
    }
}
