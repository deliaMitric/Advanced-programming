package homework;

import javax.xml.crypto.Data;
import java.sql.*;

public class GenreDAO {
    private Database database;

    public GenreDAO(Database database) {
        this.database = database;
    }

    public void create(int id, String name) throws SQLException {
        Connection con = database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into genres (id,name) values (?,?)")) {
            pstmt.setInt(1,id);
            pstmt.setString(2, name);
            pstmt.executeUpdate();

        } catch (Exception e){
            System.err.println("Something went wrong");
        }
        finally {
            con.close();
        }
    }
    public Integer findByName(String name) throws SQLException {
        Connection con = database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from genres where name='" + name + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
        catch (Exception e){
            System.err.println("Something went wrong");
        }
        finally {
            con.close();
        }
        return -1;
    }
    public String findById(int id) throws SQLException {
        Connection con = database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select name from genres where id='" + id + "'")) {
            return rs.next() ? rs.getString(1) : null;
        }
        catch (Exception e){
            System.err.println("Something went wrong");
        }
        finally {
            con.close();
        }
        return null;
    }

    public void deleteByDId(int id) throws SQLException
    {
        Connection con = database.getConnection();
        try(PreparedStatement pstmt =  con.prepareStatement("delete from genres where id=?")){
            pstmt.setInt(1,id);
            pstmt.executeUpdate();
        }
        catch (Exception e){
            System.err.println("Something went wrong");
        }
        finally {
            con.close();
        }
    }
}
