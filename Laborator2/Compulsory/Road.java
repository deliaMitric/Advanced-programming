
public class Road {
    private Location locA, locB;
    private double length;
    private Roads type;
    private int speedLimit;

    public Road(Location locA, Location locB, double length,Roads type, int speedLimit ){
        this.locA=locA;
        this.locB=locB;
        this.length=length;
        this.type=type;
        this.speedLimit=speedLimit;
    }

    public void setLoc1(Location locA)
    {
        this.locA=locA;
    }
    public void setLoc2(Location locB)
    {
        this.locB=locB;
    }
    public void setLength(double length)
    {
        this.length=length;
    }
    public void setType(Roads type)
    {
        this.type=type;
    }
    public void setSpeedLimit(int speedLimit)
    {
        this.speedLimit=speedLimit;
    }

    public Location getLoc1()
    {
        return this.locA;
    }
    public Location getLoc2()
    {
        return this.locB;
    }
    public double getLength()
    {
        return this.length;
    }
    public Roads getType()
    {
        return this.type;
    }
    public int getSpeedLimit()
    {
        return this.speedLimit;
    }
    @Override
    public String toString() {
        return "Functia toString() din Road";
    }
}