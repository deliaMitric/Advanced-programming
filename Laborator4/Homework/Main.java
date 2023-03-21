package Homework;

import com.github.javafaker.Faker;

import javax.swing.plaf.synth.SynthDesktopIconUI;
import java.util.*;
import java.util.stream.IntStream;


public class Main {


    public static void main(String[] args) {
        Faker generateNames =  new Faker();

        //generare nume pt studenti si proiecte
        var students = IntStream.rangeClosed(0, 4)
                .mapToObj(i -> new Student(generateNames.name().fullName()))
                .toArray(Student[]::new);

        var projects = IntStream.rangeClosed(0,4)
                .mapToObj(j -> new Project(generateNames.name().title()))
                .toArray(Project[]::new);

        List<Student> studentList = new ArrayList<>();

        for(Student student : students)
            studentList.add(student);


        Problem problem=new Problem(1);

        //adaugare in Map ul din problema  a studentilor impreuna  cu preferintele lor
        problem.addInMap(students[0], Arrays.asList(projects[3],projects[1]));
        problem.addInMap(students[1], Arrays.asList(projects[0]));
        problem.addInMap(students[2], Arrays.asList(projects[3],projects[1],projects[0]));
        problem.addInMap(students[3], Arrays.asList(projects[2],projects[1]));
        problem.addInMap(students[4], Arrays.asList(projects[2]));

        //afisarea studentilor care au nr de preferinte mai mic decat media preferintelor (prin stream)
        studentList.stream()
                .filter(s -> problem.getNumberOfPreferences(s) <= problem.getAverageOfPreferences())
                        .forEach(System.out::println);

        //apelarea Greedy + afisarea perechilor(Student, Proiect)
        System.out.println("Greedy:");
        System.out.println(problem.greedyAlg().size() + "perechi");
        System.out.println(problem.greedyAlg().toString());


    }
}