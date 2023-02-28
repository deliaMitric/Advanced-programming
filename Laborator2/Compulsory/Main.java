public class Main {
    public static void main(String[] args) {

        Location l1=new Location("LOC1",Locations.city,12,14);
        Location l2=new Location("LOC2",Locations.airport,24,30);

        Road r=new Road(l1,l2,45.78,Roads.express,23);

        System.out.println(r.toString());
        System.out.println(l1.toString());


    }
}