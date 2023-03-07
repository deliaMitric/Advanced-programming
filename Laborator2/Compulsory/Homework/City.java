package newP;
/**
 * City is a class that estends the abstract class Location
 * Has a specific proper: the population
 *
 * @author Delia
 */
public class City extends Location{
    private int population;

    /**
     * Allocates memory and initializes a City type object
     *
     * @param name represents the name of GasStation
     * @param x represents the x coordinate
     * @param y represents the y coordinate
     * @param population represents the value of population
     */
    City(String name, int x, int y, int population)
    {
        this.name.replace(0,256,name);
        this.x_coord=x;
        this.y_coord=y;
        this.population=population;
    }

    /**
     * Sets the population with a given value
     *
     * @param population represents the population of the City
     */
    public void setPopulation(int population)
    {
        this.population = population;
    }

    /**
     * Gives the population of the instance
     *
     * @return the value of population of the instance
     */
    public int getPopulation()
    {
        return this.population;
    }

    /**
     * Prints the name of the instance
     */
    public void printName()
    {
        System.out.println("Afisam din interiorul clasei numele orasului-> " + this.name);
    }
    /**
     * Gives the type of the instance
     *
     * @return a string that represents the type of the instance
     */
    public String getType()
    {
        String type = "City";
        return type;
    }


}
