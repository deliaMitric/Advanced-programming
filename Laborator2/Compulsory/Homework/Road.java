package newP;
/**
 * Road class represents a road that has a name, a type, a length, a speedLimit and connects two locations.
 *
 * @author Delia
 */
public  class Road {
    private StringBuffer name = new StringBuffer(256);
    private Location locA, locB;
    private double length;

    private RoadsEnum type;
    private int speedLimit;

    /**
     * Allocates memory and initializes a Road type object
     *
     * @param name       represents a string, the name of the Road
     * @param locA       represents a Location object, the first Location connected by this Road to the second Location
     * @param locB       represents a Location object, the second Location connected by this Road to the first Locaton
     * @param length     represents a double, the length of the Road. If The value is negative, the variable wouldn't be initialized
     * @param speedLimit represents an int, the speedLimit of the Road. If The value is negative, the variable wouldn't be initialized
     * @param type       represents an enum object, the type of the Road
     */
    public Road(String name, Location locA, Location locB, double length, int speedLimit, RoadsEnum type) {
        this.name.replace(0, 256, name);
        this.locA = locA;
        this.locB = locB;
        if (length > 0)
            this.length = length;
        else {
            System.out.println("Invalid value for length!");
        }
        if (speedLimit > 0)
            this.speedLimit = speedLimit;
        else {
            System.out.println("Invalid value for speedLimit! ");
        }
        this.type = type;
    }

    /**
     * Sets the name of the instance
     *
     * @param name represents a string, the name of the instance
     */
    public void setName(String name) {
        this.name.replace(0, 256, name);
    }

    /**
     * Sets the first location of the instance
     *
     * @param locA represents a Location object
     */
    public void setLoc1(Location locA) {
        this.locA = locA;
    }

    /**
     * Sets the second location of the instance
     *
     * @param locB represents a Location object
     */
    public void setLoc2(Location locB) {
        this.locB = locB;
    }

    /**
     * Sets the length of the instance
     *
     * @param length represents a double,the length of the instance
     */
    public void setLength(double length) {
        this.length = length;
    }

    /**
     * Sets the speedLimit of the instance
     *
     * @param speedLimit represents an int, the speedLimit of the instance
     */
    public void setSpeedLimit(int speedLimit) {
        this.speedLimit = speedLimit;
    }

    /**
     * Sets the type of the instance
     *
     * @param type represents an enum object, the type of the instance
     */
    public void setType(RoadsEnum type) {
        this.type = type;
    }

    /**
     * Gives the name of the instance
     *
     * @return a string, the name of the instance
     */
    public StringBuffer getName() {
        return this.name;
    }

    /**
     * Gives the first Location of the instance
     *
     * @return a Location object, the first location of the instance
     */
    public Location getLoc1() {
        return this.locA;
    }

    /**
     * Gives the first Location of the instance
     *
     * @return a Location object, the second location of the instance
     */
    public Location getLoc2() {
        return this.locB;
    }

    /**
     * gives the length of the instance
     *
     * @return a double, the length of the instance
     */
    public double getLength() {
        return this.length;
    }

    /**
     * gives the speedLimit of the instance
     *
     * @return an int, the speedLiit of the instance
     */
    public int getSpeedLimit() {
        return this.speedLimit;
    }

    /**
     * Gives the type of the instance
     *
     * @return an enum object, the type of the instance
     */
    public RoadsEnum getType() {
        return this.type;
    }

    /**
     * Compares two roads in terms of name, length, type, speedLimit and the locations that is connected
     *
     * @param obj represents an object that can be a Road
     * @return a boolean response true/false.
     * The method verifies if the object obj is null. If it is null, the method will return false.
     * If these two roads have the same name, length, type, speedLimit and connect the same locations, the method will return true.
     * In other case, it will return false.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        Road other = (Road) obj;

        if (name.equals(other.name))
            if (length == other.length)
                if (other.type == type)
                    if (other.speedLimit == speedLimit)
                        if (locA.equals(other.locA))
                            if (locB.equals(other.locB))
                                return true;
        return false;

    }

    /**
     * Concats informations about a Road
     *
     * @return a string contains the informations (name,locA,locB,length,type,speedLimit) about a Road
     */
    @Override
    public String toString() {
        return "Road{" +
                "name=" + name +
                ", locA=" + locA +
                ", locB=" + locB +
                ", length=" + length +
                ", type=" + type +
                ", speedLimit=" + speedLimit +
                '}';
    }
}