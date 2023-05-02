package org.example;


import org.example.repositories.ArtistRepository;
public class Main {
    public static void main(String[] args) {
        ArtistRepository artistRepository = new ArtistRepository();
        System.out.println(artistRepository.findByName("Michael Jackson"));
    }
}