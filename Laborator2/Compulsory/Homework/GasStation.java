package newP;
/**
 * GasStation is a class that extends the abstract class Location
 * Has a specific proper: the price of the gas
 *
 * @author Delia
 */
public class GasStation extends Location{
    private double gasPrice;

    /**
     * Allocates memory and initializes a GasStation type object
     *
     * @param name represents the name of GasStation
     * @param x represents the x coordinate
     * @param y represents the y coordinate
     * @param gasPrice represents the price of the gas
     */
    GasStation(String name, int x, int y, double gasPrice)
    {
        this.name.replace(0,256,name);
        this.x_coord=x;
        this.y_coord=y;
        this.gasPrice=gasPrice;
    }

    /**
     * Sets the gasPrice with a given value
     *
     * @param gasPrice represents the price of the gas
     */
    public void setGasPrice(double gasPrice) {
        this.gasPrice = gasPrice;
    }

    /**
     * Gives the price of the gas of the instance
     *
     * @return a double that represents the price of the gas
     */
    public double getGasPrice() {
        return this.gasPrice;
    }

    /**
     * Prints the name of the instance
     */
    public void printName() {
        System.out.println("Afisam din interiorul clasei numele benzinariei-> " + this.name);
    }

    /**
     * Gives the type of the instance
     *
     * @return a string that represents the type of the instance
     */
    public String getType()
    {
        return "GasStation";
    }
}
