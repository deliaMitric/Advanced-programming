package Homework;

import java.util.ArrayList;
import java.util.List;

public class Student implements Comparable<Student>{

    private StringBuffer name = new StringBuffer(100);

    public Student(String name) {
        this.name.replace(0,100,name);

    }
    public StringBuffer getName() {
        return name;
    }

    public void setName(String name) {
        this.name.replace(0,100, name);
    }


    @Override
    public int compareTo(Student obj)
    {
        return this.name.compareTo(obj.getName());
    }

    @Override
    public String toString() {
        return "Student{" +
                "name=" + name +
                '}';
    }
}
