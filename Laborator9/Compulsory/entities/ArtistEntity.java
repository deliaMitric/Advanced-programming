package org.example.entities;

import javax.persistence.*;

@Entity
@Table(name = "artists")
@NamedQueries({
        @NamedQuery(name = "Artist.findAll",
        query = "select e from Artists e order by e.name"),
        @NamedQuery(name = "Artist.findById",
        query = "select e from Artists e where e.id = ?1"),
        @NamedQuery(name = "Artist.findByName",
                query = "SELECT a FROM Artists a WHERE LOWER(a.name) LIKE LOWER(:name)")})
public class ArtistEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;

    public ArtistEntity(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ArtistEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
