package org.example.compulsory;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Document implements Serializable {
    private int id ;
    private StringBuffer title = new StringBuffer(100);
    private StringBuffer location = new StringBuffer(250);
    private Map<String,Object> tags = new HashMap<>();

    public Document(int id, String title, String location) {
        this.id = id;
        this.title.replace(0,100,title);
        this.location.replace(0,250,location);
    }
    public void addTag(String key, Object obj){
        tags.put(key,obj);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public StringBuffer getTitle() {
        return title;
    }

    public void setTitle(StringBuffer title) {
        this.title = title;
    }

    public StringBuffer getLocation() {
        return location;
    }

    public void setLocation(StringBuffer location) {
        this.location = location;
    }

    public Map<String, Object> getTags() {
        return tags;
    }

    public void setTags(Map<String, Object> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", title=" + title +
                ", location=" + location +
                ", tags=" + tags +
                '}';
    }
}