package Compulsory;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        Person p1 =new Person("Paul",20,"paul123@gmail.com","071234565");
        Person p2 =new Person("Andrei",22,"andrei123@gmail.com","071545699");
        Company c1=new Company("Company1","Iasi","Dany",120);
        Company c2=new Company("Company13","Bucuresti","Gabriel",50);
        List<Object> nodeList=new LinkedList<Object>();
        nodeList.add(p1);
        nodeList.add(p2);
        nodeList.add(c1);
        nodeList.add(c2);

        for(int i=0;i<nodeList.size();i++)
        {
            if(nodeList.get(i) instanceof Person)
                System.out.println("Person: " + ((Person) nodeList.get(i)).getName());
            if(nodeList.get(i) instanceof Company)
                System.out.println("Company: " + (((Company) nodeList.get(i)).getName()));
        }


    }
}