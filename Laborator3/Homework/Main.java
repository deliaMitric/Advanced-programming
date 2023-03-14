package Homework;

public class Main {
    public static void main(String[] args) {
        Person p1= new Programmer("Andrew","and23@gmail.com","07123..","Java",23,4);
        Person p2 =new Programmer("Justin","justyy11@gmail.com","07998..","Python",30,10);
        Person p3 =new Designer("Mark","designMark@gmail.com","09123..",34,5);
        Person p4 = new Designer("Mary","maryM25@gmail.com","09175..",25,3);

        Company c1 = new Company("Company 1","Iasi","Iulian",40);
        Company c2 =new Company("Company 2","Bucuresti","Filip",100);
        Company c3 =new Company("Company 3","Cluj","Andreea",250);

        p1.addRelationship(p2,"friend");
        p2.addRelationship(p1,"friend");
        p1.addRelationship(c1,"employee");
        p1.addRelationship(p3,"colleague");
        p3.addRelationship(p1,"colleague");
        p3.addRelationship(c1,"employee");
        p3.addRelationship(c2,"assistant");
        p3.addRelationship(c3,"assistant");
        p4.addRelationship(c3,"employee");

        Network network =new Network();
        network.addNode(p1);
        network.addNode(p2);
        network.addNode(p3);
        network.addNode(p4);

        network.addNode(c1);
        network.addNode(c2);
        network.addNode(c3);

        for(int i=0;i<network.getSize();i++)//calculam importanta in retea pt fiecare nod din aceasta
            network.importance(network.getNode(i));

        network.sortNetworkImportance();//sortam nodurile dupa importanta

        System.out.println("Nodurile din retea in ordinea crescatoare a importantei lor in retea:");
        for(int i=0;i<network.getSize();i++)
        {
            System.out.print(i+1+": ");
            if(network.getNode(i) instanceof Person)
                System.out.println(((Person)network.getNode(i)).toString());
            if(network.getNode(i) instanceof Company)
                System.out.println(((Company)network.getNode(i)).toString());

        }



    }
}
