package newP;
public class Main {
    public static void main(String[] args) {

        Location[] l=new Location[100];

        l[0]=new City("Iasi",10,12,12000);
        l[1]=new Airport("A1",23,12,10);
        l[2]=new GasStation("G1",46,34,7.50);
        l[3]=new City("Suceava",11,12,10000);
        l[4]=new Airport("A2",23,19,15);
        l[0].setName("Brasov");

        Road r1=new Road("Strada1",l[0],l[1],23.45,60,RoadsEnum.COUNTRY);
        Road r2=new Road("Strada2",l[1],l[2],50.00,50,RoadsEnum.EXPRESS);
        Road r3=new Road("Strada3",l[0],l[2],15.00,50,RoadsEnum.HIGHWAY);
        Road r4=new Road("Strada4",l[1],l[4],45.00,70,RoadsEnum.COUNTRY);
        Road r5=new Road("Strada5",l[4],l[3],30.45,90,RoadsEnum.HIGHWAY);


        Problem p1=new Problem(100,100);

        p1.addLocation(l[0]);
        p1.addLocation(l[1]);
        p1.addLocation(l[2]);
        p1.addLocation(l[3]);
        p1.addLocation(l[4]);

        p1.addRoad(r1);
        p1.addRoad(r2);
        p1.addRoad(r3);
        p1.addRoad(r4);
        p1.addRoad(r5);

        if(p1.problemValidation())
            System.out.println("Problema corecta");
        else
            System.out.println("Problema incorecta");

        Algorithm a=new FindPath();
        Location loc1=l[0];
        Location loc2=l[4];

        if(a.algorithm(p1,loc1,loc2))
            System.out.println("Avem drum intre locatia "+loc1.toString()+" si locatia "+loc2.toString());
        else
            System.out.println("Nu avem drum intre locatia "+loc1.toString()+" si locatia "+loc2.toString());


    }
}