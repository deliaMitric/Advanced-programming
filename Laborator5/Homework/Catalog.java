package Homework;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {
    private StringBuffer name =new StringBuffer(100);
    private List<Document> docs = new ArrayList<>();

    public Catalog(String name) {
        this.name.replace(0,100,name);
    }

    public void add(Document d){
        docs.add(d);
    }
    public Document findById(int id){//cauta un document dupa id
        for (var doc : docs) {
            if (doc.getId()==id) {
                return doc;
            }
        }
        return null;

    }

    public StringBuffer getName() {
        return name;
    }

    public void setName(StringBuffer name) {
        this.name = name;
    }

    public List<Document> getDocs() {
        return docs;
    }

    public void setDocs(List<Document> docs) {
        this.docs = docs;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "name=" + name +
                ", docs=" + docs +
                '}';
    }
}
