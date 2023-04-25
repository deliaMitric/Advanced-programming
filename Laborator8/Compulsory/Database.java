package org.example.compulsory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Database {
    private static final String URL =
            "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "java";
    private static final String PASSWORD = "java";
    private static Connection connection = null;
    private Database() {}
    public static Connection getConnection() throws SQLException {

        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return connection;
    }
    private static void createConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    public static void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
            connection = null;
        }}
    public static void rollback() throws SQLException {
        try (
                PreparedStatement pstmt = connection.prepareStatement(
                        "rollback;")){
            pstmt.execute("rollback;");
        }
    }
}

/*try {
    Connection conn = DatabaseManager.getInstance().getConnection();
    // use the connection
} catch (SQLException e) {
    // handle the exception
}*/

/*try {
    Connection conn = DatabaseManager.getInstance().getConnection();
    // use the connection
} catch (SQLException e) {
    // handle the exception
} finally {
    try {
        DatabaseManager.getInstance().closeConnection();
    } catch (SQLException e) {
        // handle the exception
    }
}
*/

