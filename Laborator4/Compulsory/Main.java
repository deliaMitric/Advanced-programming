package org.example.compulsory;

import javax.swing.plaf.synth.SynthDesktopIconUI;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        var students = IntStream.rangeClosed(0, 9)
                .mapToObj(i -> new Student("student"+ i ))
                .toArray(Student[]::new);

        var projects = IntStream.rangeClosed(0,4)
                .mapToObj(j -> new Project("project"+ j))
                .toArray(Project[]::new);

        //linked list for students
        List<Student> studentList = new ArrayList<>();

        for(Student i : students)
            studentList.add(i);

        //tree set for projects
        Set<Project> projectSet = new TreeSet<Project>();

        for(Project j : projects)
            projectSet.add(j);

        //sorting
        Collections.sort(studentList);

        //print on the screen
        System.out.println("-----------STUDENTS:");
        for(Student s : studentList)
            System.out.println(s.getName());

        System.out.println("-----------PROJECTS:");
        for(Project p : projectSet)
            System.out.println(p.getName());





    }
}