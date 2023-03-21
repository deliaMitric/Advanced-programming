package Homework;

import java.lang.Boolean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem {
    private List<Student> students = new ArrayList<>();
    private List<Project> projects = new ArrayList<>();

    Map<Student,List<Project>> prefMap = new HashMap<>();
    private int id;

    public Problem(){

    }
    public Problem(int id){
        this.id = id;
    }
    public Problem(List<Student> students, List<Project> projects, int id) {
        this.students = students;
        this.projects = projects;
        this.id = id;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addProject(Project p){
        if(!projects.contains(p)){
            projects.add(p);
        } else{
            throw new ClassCastException("Proiect deja adaugat in problema!");
        }
    }
    public void removeProject(Project p)
    {
        if(projects.contains(p)){
            projects.remove(p);
        } else {
            throw new ClassCastException("Proiectul nu este adaugat in problema!");
        }
    }
    public void addStudent(Student s){
        if(!students.contains(s)){
            students.add(s);
        } else{
            throw new ClassCastException("Student deja adaugat in problema!");
        }
    }
    public void removeStudent(Student s)
    {
        if(students.contains(s)){
            students.remove(s);
        } else {
            throw new ClassCastException("Studentul nu este adaugat in problema!");
        }
    }
    //adauga un student cu lista de preferinte
    public void addInMap(Student s, List<Project> lista)
    {
        if(!prefMap.containsKey(s)) {
            prefMap.put(s, lista);
        }
        else{
            throw new ClassCastException("Student deja adaugat!");
        }
    }
    //scoate un student din map
    public void removeInMap(Student s)
    {
        if(prefMap.containsKey(s)){
            prefMap.remove(s);
        }
        else{
            throw new ClassCastException("studentul nu este in map!");
        }
    }
    //metoda ce returneaza numarul de preferinte ale unui student s
    public int getNumberOfPreferences(Student student)//preferintele unui student
    {
        if(prefMap.containsKey(student)){
            return prefMap.get(student).size();
        }
        return 0;
    }
    //metoda ce returneaza media preferintelor din problema
    public double getAverageOfPreferences()
    {
        double sumOfNumberOfPreferences = 0;
        for(Student student : prefMap.keySet()){
            sumOfNumberOfPreferences += prefMap.get(student).size();
        }

        double average = sumOfNumberOfPreferences/prefMap.size();
        return average;
    }
    public Map<Student,List<Project>> getPrefMap()
    {
        return prefMap;
    }

    //algoritmul Greedy - alegem prima obtiune din lista de pregerinte a studentilor
    public Map<Student,Project> greedyAlg()
    {
        Map<Student,Project> pairs = new HashMap<>();
        Map<Project,String> statusOfProjects = new HashMap<>();

        for(Student student : prefMap.keySet()){
            for(Project project : prefMap.get(student)){
                if(!statusOfProjects.containsKey(project)){
                    statusOfProjects.put(project,"noTaken");
                }
            }
        }

        for(Student student : prefMap.keySet()){
            for(Project project : prefMap.get(student)){
                if( (statusOfProjects.get(project)).equals((String) "noTaken")) {
                    pairs.put(student,project);
                    statusOfProjects.replace(project,"taken");
                    break;
                }
            }
        }

        return pairs;
    }


    @Override
    public String toString() {
        return "Problem{" +
                "prefMap=" + prefMap +
                ", id=" + id +
                '}';
    }
}
