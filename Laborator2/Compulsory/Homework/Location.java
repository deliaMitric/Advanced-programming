package newP;

/**
 * Location is an abstract class that represents a location described by a name, x coordinate and y coordinate in a Cartesian Coordinate System
 *
 * @author Delia
 */
public  abstract class Location {
    protected StringBuffer name = new StringBuffer(256);
    protected int x_coord, y_coord;

    /**
     * Sets the name with a new one given as parameter
     *
     * @param newName represents the given name
     */
    public void setName(String newName)
    {
        this.name.replace(0,256, newName);
    }

    /**
     * Sets the x coordinate with a given value
     *
     * @param x represents the given x coordinate
     */
    public void setX_coord(int x)
    {
        this.x_coord=x;
    }

    /**
     * Sets the y coordinate with a given value
     *
     * @param y represents the given y coordinate
     */
    public void setY_coord(int y)
    {
        this.y_coord=y;
    }

    /**
     * Gives the name of the instance
     *
     * @return the name of the instance
     */
    public StringBuffer getName() {
        return this.name;
    }

    /**
     * Gives the value of x_coord of the instance
     *
     * @return the value of the x coordinate of the instance
     */
    public int getX_coord() {
        return this.x_coord;
    }

    /**
     * Gives the value of y_coord of the instance
     *
     * @return the value of the y coordinate of the instance
     */
    public int getY_coord() {
        return this.y_coord;
    }

    public abstract void printName();
    public abstract String getType();

    /**
     * Compare two locations in terms of name and coordinates
     *
     * @param obj represents an object that can be a Location
     * @return a boolean response true/false
     * The method verifies if the object obj is null and in this case it will return false.
     * If these two locations have the same name and the same coordinates, the method will return true, else it will return false.
     *
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null ) {
            return false;
        }
        Location other = (Location) obj;
        if(name.equals(other.getName()))
            if(other.getY_coord()==y_coord)
                if(other.getX_coord()==x_coord)
                    return true;
        return false;
    }

    /**
     * Concats  informations about a location
     *
     * @return a string contains the informations (name,x_coord,y_coord) about a location
     */
    @Override
    public String toString() {
        return "Location{" +
                "name=" + name +
                ", x_coord=" + x_coord +
                ", y_coord=" + y_coord +
                '}';
    }
}
