package newP;
/**
 * Problem is a class that represents a problem consisting of an array of Location objects and an array of Road objets.
 * @author Delia
 */
public class Problem {
    private Location[] locations;
    private int numberOfLocations;
    private int maxLoc;
    private Road[] roads;
    private int numberOfRoads;
    private int maxroad;

    /**
     * Allocates memory and initializes a Problem type object
     *
     * @param maxLoc represents the maxim value of Location objects that can be included in the Problem
     * @param maxRoad represents the maxim value of Road objects that can be included in the Problem
     */
    public Problem(int maxLoc,int maxRoad){
        if(maxLoc>0 && maxRoad>0) {
            locations = new Location[maxLoc];
            roads = new Road[maxRoad];
            this.maxLoc = maxLoc;
            this.maxroad = maxRoad;
        }
        else
        {
            System.out.println("Invalid numbers!");
        }
        numberOfLocations=0;
        numberOfRoads=0;
    }

    /**
     * Includes a Road object in the Problem if there is enough space
     *
     * @param road represents a Road object
     */
    public void addRoad(Road road){
        if(this.numberOfRoads<maxroad)
        {
            boolean gasit=false;

            for(int i=0;i<this.numberOfRoads;i++)
                if(road.equals(roads[i])==true)
                {
                    System.out.println("Road already added.");
                    gasit=true;
                }
            if(gasit==false)
                roads[this.numberOfRoads++] = road;

        }
        else
            System.out.println("The number of roads is exceeded!");

    }
    /**
     * Includes a Location object in the Problem if there is enough space
     *
     * @param location represents a Location object
     */
    public void addLocation(Location location){
        if(this.numberOfLocations<maxLoc)
        {
            boolean gasit=false;

            for(int i=0;i<this.numberOfLocations;i++)
                if(location.equals(locations[i]))
                {
                    System.out.println("Location already added.");
                    gasit=true;
                }

            if(gasit==false)
                {
                    locations[this.numberOfLocations++] = location;
                }
        }
        else
            System.out.println("The number of locations is exceeded!");

    }

    /**
     * Deletes a Road object from problem
     *
     * @param position represents the position of the Road that will be deleted
     */
    private void deleteRoad(int position)
    {
        int i, j;
        for(i=position;i<this.numberOfRoads-1;i++)
            roads[i]=roads[i+1];
        this.numberOfRoads--;
    }

    /**
     * Searches in the array of the Road objects the position of the Road given as parameter and gives it to the delete method
     *
     * @param road represents a Road object that will be deleted if it is found in the Problem
     */
    public void removeRoad(Road road){
        boolean gasit=false;

        for(int i=0;i<this.numberOfRoads;i++)
        {
            if(road.equals(roads[i])==true)//am gasit dtrada pe care dorim sa o stergem
            {
                deleteRoad(i);
                gasit=true;
            }

        }
        if(gasit==false)
            System.out.println("The road you want to delete isn't added in the problem!");
    }
    /**
     * Deletes a Location object from problem
     *
     * @param position represents the position of the Location that will be deleted
     */
    private void deleteLocation(int position)
    {
        int i, j;
        for(i=position;i<this.numberOfLocations-1;i++)
            locations[i]=locations[i+1];
        this.numberOfLocations--;
    }
    /**
     * Searches in the array of the Location objects the position of the Location given as parameter and gives it to the delete method
     *
     * @param location represents a Location object that will be deleted if it is found in the Problem
     */
    public void removeLocation(Location location){
        boolean gasit=false;

        for(int i=0;i<this.numberOfLocations;i++)
        {
            if(location.equals(roads[i])==true)//am gasit locatia pe care dorim sa o stergem
            {
                deleteLocation(i);
                gasit=true;
            }

        }
        if(gasit==false)
            System.out.println("The location you want to delete isn't added in the problem!");
    }

    /**
     * Verifies if the Problem instance is valid.
     *
     * @return a boolean result true/false
     * If there are locations that have the same coordinates, the method willl return false.
     * If there are roads that have the same characteristics, the method will return false.
     */
    public boolean problemValidation()
    {
        if(numberOfLocations>0 && numberOfRoads>0)
        {
            int i, j;
            for(i=0;i<this.numberOfLocations-1;i++) {
                for (j = i + 1; j < this.numberOfLocations; j++) {
                    //locatii "egale"
                    if(locations[i].equals(locations[j]))
                        return false;

                    else
                        //locatii cu nume diferit, dar aceleasi coordonate
                        if(!locations[i].getName().equals(locations[j].getName()))
                            if(locations[i].getY_coord()==locations[j].getY_coord() && locations[i].getX_coord()==locations[j].getX_coord())
                                return false;

                }
            }

            for(i=0;i<this.numberOfRoads-1;i++)
            {
                for(j=i+1;j<this.numberOfRoads;j++)
                    if(roads[i].equals(roads[j]))
                        return false;

                    else
                    {
                        //strazi cu acelasi nume, tip, lungime, limita de viteza si cu aceleasi locatii->dar inversate
                        if(roads[i].getName().equals(roads[j].getName()))
                            if(roads[i].getLength()==roads[j].getLength() && roads[i].getType()==roads[j].getType() && roads[i].getSpeedLimit()==roads[j].getSpeedLimit())
                                if(roads[i].getLoc1().equals(roads[j].getLoc2()) && roads[i].getLoc2().equals(roads[j].getLoc1()))
                                    return false;
                    }
            }
            return true;
        }
        System.out.println("Functie");
        return false;

    }

    /**
     * Verifies if a given Location object is found in the instance
     *
     * @param l represents a Location object
     * @return an int, the position of the Location object in the array
     */
    public int  haveLocation(Location l)
    {
        for(int i=0;i<numberOfLocations;i++)
            if(locations[i].equals(l))
                return i;
        return -1;
    }

    /**
     * Gives the position (in the array) of the given Location object
     *
     * @param l represents a Location object
     * @return an int, the position of the Location object in the array
     */
    public int getIndexOfLoc(Location l)
    {
        for(int i=0;i<numberOfLocations;i++)
            if(locations[i].equals(l))
                return i;
        return -1;
    }

    /**
     * Gives the array of Location objects of the instance
     *
     * @return the array of Location objects of the instance
     */
    public Location[] getLocations() {
        return locations;
    }

    /**
     * Gives the number of Location objects in the instance
     *
     * @return the number of Location objects in the instance
     */
    public int getNumberOfLocations() {
        return numberOfLocations;
    }
    /**
     * Gives the array of Road objects of the instance
     *
     * @return the array of Road objects of the instance
     */

    public Road[] getRoads() {
        return roads;
    }

    /**
     * Gives the number of Road objects in the instance
     *
     * @return the number of Road objects in the instance
     */
    public int getNumberOfRoads() {
        return numberOfRoads;
    }
}
