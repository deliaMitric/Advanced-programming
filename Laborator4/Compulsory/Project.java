package org.example.compulsory;

public class Project implements Comparable<Project>{
    private StringBuffer name = new StringBuffer(100);

    public Project(String name) {
        this.name.replace(0,100,name);
    }

    public StringBuffer getName() {
        return name;
    }

    public void setName(String name) {
        this.name.replace(0,100,name);
    }

    @Override
    public int compareTo(Project o) {
        return this.name.compareTo(o.getName());
    }


}
