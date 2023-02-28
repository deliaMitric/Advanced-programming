import java.util.Arrays;

public class Location {
    private StringBuffer name = new StringBuffer(256);
    private Locations type;
    private int x_coord, y_coord;

    public Location(String name, Locations type, int x, int y)
    {
        this.name.replace(0,256,name);
        this.type=type;
        this.x_coord=x;
        this.y_coord=y;
    }

    public void setName(String newName)
    {
        this.name.replace(0,256, newName);
    }
    public void setType(Locations type)
    {
        this.type=type;
    }
    public void setX_coord(int x)
    {
        this.x_coord=x;
    }
    public void setY_coord(int y)
    {
        this.y_coord=y;
    }

    public StringBuffer getName() {
        return this.name;
    }

    public int getX_coord() {
        return this.x_coord;
    }

    public int getY_coord() {
        return this.y_coord;
    }

    @Override
    public String toString() {
        return "Functia toString() din Location";
    }
}