package homework;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String args[]) throws SQLException {
        try {
            //var artists = new ArtistDAO();
            ConnectionPool connectionPool = new ConnectionPool();
            Database database = new Database(connectionPool);

            List<Album> albums = new ArrayList<>();
            List<Artist> artists = new ArrayList<>();
            List<Genre> genres = new ArrayList<>();

            BufferedReader reader = new BufferedReader(new FileReader("albumlist.csv"));
            String line;
            line=reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                int id = Integer.parseInt(fields[0]);
                int  year = Integer.parseInt(fields[1]);
                String title = fields[2];
                String artist = fields[3];
                String genre = fields[4];
                //System.out.println(artist);
                //System.out.println(id +" " +year +" " +title+" "+artist+" "+genre);

                Album album = new Album(id, year, title, artist);
                albums.add(album);

                //verificare artist
                boolean addArtist = true;
                for(Artist artist1 : artists) {
                    if (artist1.getName().equals(artist)) {
                        addArtist =false;
                        break;
                    }
                }
                if(addArtist){
                    Artist artist1 = new Artist(artists.size() + 1, artist);
                    artists.add(artist1);
                }

                //verificare gen muzical
                boolean addGenre = true;
                for(Genre genre1 : genres) {
                    if (genre1.getName().equals(genre)) {
                        addGenre =false;
                        break;
                    }
                }
                if(addGenre){
                    Genre genre1 = new Genre(genres.size() + 1, genre);
                    genres.add(genre1);
                }
            }
            reader.close();

            var artistDao = new ArtistDAO(database);
            var albumDao = new AlbumDAO(database);
            var genreDao = new GenreDAO(database);

            //add data in dataBase
            for(Artist artist : artists){
                artistDao.create(artist.getId(),artist.getName());
            }

            for (Album album : albums){
                albumDao.create(album.getId(),album.getReleaseYear(),album.getTitle(), album.getArtist());
            }

            for(Genre genre : genres){
                //System.out.println(genre.getId() + " " + genre.getName() );
                genreDao.create(genre.getId(),genre.getName());
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

}


