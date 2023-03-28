package Homework;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public abstract class Document implements Serializable {
    private int id ;
    private StringBuffer title = new StringBuffer(100);
    private StringBuffer location = new StringBuffer(250);
    private Map<String,Object> tags = new HashMap<>();
    public Document(){};
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

    public void setTitle(String title) {
        this.title.replace(0,100,title);
    }

    public StringBuffer getLocation() {return  location;
    }

    public void setLocation(String location) {
        this.location.replace(0,250,location);
    }

    public Map<String, Object> getTags() {
        return tags;
    }

    public void setTags(Map<String, Object> tags) {
        this.tags = tags;
    }

    public abstract String getType();


}