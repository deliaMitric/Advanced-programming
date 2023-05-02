package homework;


import java.sql.*;

public class AlbumDAO {
    private Database database;

    public AlbumDAO(Database database) {
        this.database = database;
    }

    public void create(int id, int year, String title, String nameArtist ) throws SQLException {
        Connection con = database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into albums values (?,?,?,?)")) {
            pstmt.setInt(1,id);
            pstmt.setInt(2, year);
            pstmt.setString(3,title);
            pstmt.setString(4,nameArtist);
            pstmt.executeUpdate();


        } catch (Exception e){
            System.err.println("Something went wrong");
        }
        finally {
            con.close();
        }
    }
    public Integer findByTitle(String title) throws SQLException {
        Connection con = database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from albums where title='" + title + "'")) {
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
             ResultSet rs = stmt.executeQuery("select name from albums where id='" + id + "'")) {
            return rs.next() ? rs.getString(1) : null;
        }
        catch (SQLException e){
            System.err.println("Something went wrong");
        }
        finally{
            con.close();
        }
        return null;
    }

    public void deleteByDId(int id) throws SQLException
    {
        Connection con = database.getConnection();
        try(PreparedStatement pstmt =  con.prepareStatement("delete from albums where id=?")){
            pstmt.setInt(1,id);
            pstmt.executeUpdate();
        }
        catch (SQLException e){
            System.err.println("Something went wrong");
        }
        finally {
            con.close();
        }

    }
    public Database getDatabase() {
        return database;
    }
    public void setDatabase(Database database) {
        this.database = database;
    }
}
