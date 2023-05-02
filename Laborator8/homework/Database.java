package homework;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Database {
    private  static Connection connection = null;
    private static ConnectionPool connectionPool;

    public Database(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    public Connection getConnection() throws SQLException {

        if (connection == null || connection.isClosed()) {
            connection = connectionPool.getConnection();
        }
        return connection;
    }
    private void createConnection() {
        try {
            connection = connectionPool.getConnection();
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    public  void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
            connection = null;
        }}
    public  void rollback() throws SQLException {
        try (
                PreparedStatement pstmt = connection.prepareStatement(
                        "rollback;")){
            pstmt.execute("rollback");
        }
    }

    public static void setConnection(Connection connection) {
        Database.connection = connection;
    }

    public static ConnectionPool getConnectionPool() {
        return connectionPool;
    }

    public static void setConnectionPool(ConnectionPool connectionPool) {
        Database.connectionPool = connectionPool;
    }
}
