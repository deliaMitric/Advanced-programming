package org.example.compulsory;

import java.sql.SQLException;

    public class Main {
        public static void main(String args[]) throws SQLException {
            try {
                var artists = new ArtistDAO();
                //Database.rollback();
                //artists.create("Delia",10);
                //artists.create("Michael Jackson",6);
                System.out.println(artists.findById(6));
                System.out.println(artists.findById(10));
                //System.out.println(artists.findByName("Pink_Floyd"));

                Database.closeConnection();

            } catch (SQLException e) {
                System.err.println(e);
                Database.rollback();
            }
        }

    }


