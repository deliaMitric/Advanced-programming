package newP;
/**
 * Airport is a class that extends the abstract class Location
 * Has a specific proper: the number of flies in a day
 *
 * @author Delia
 */
public class Airport extends Location {
     private int numberOfFliesPerDay;

    /**
     * Allocates memory and initializes an Airport type object
     *
     * @param name represents the name of GasStation
     * @param x represents the x coordinate
     * @param y represents the y coordinate
     * @param numberOfFliesPerDay  represents the value of number of flies in a day
     */
    Airport(String name, int x, int y, int numberOfFliesPerDay)
    {
        this.name.replace(0,256,name);
        this.x_coord=x;
        this.y_coord=y;
        this.numberOfFliesPerDay=numberOfFliesPerDay;
    }

    /**
     * Sets the number of flies per a day with a given value
     *
     * @param numberOfFliesPerDay represents the number of flies per a day
     */
    public void setNumberOfFliesPerDay(int numberOfFliesPerDay)
    {
        this.numberOfFliesPerDay=numberOfFliesPerDay;
    }

    /**
     * Gives the number of flies per a day of the instance
     *
     * @return the value of flies per a day of the instance
     */
    public int getNumberOfFliesPerDay()
    {
        return this.numberOfFliesPerDay;
    }
    /**
     * Prints the name of the instance
     */
    public void printName()
    {
        System.out.println("Afisam din interiorul clasei numele aeroportului-> " + this.name);
    }
    /**
     * Gives the type of the instance
     *
     * @return a string that represents the type of the instance
     */
    public String getType()
    {
        String type = "Airport";
        return type;
    }

}
