package Homework;


import java.text.CompactNumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Company class implements interfaces Node and Comparable and represents a company identified unique by name
 * and defined by an adress, a ceo and the number of employee
 *
 * @author Delia
 */
public class Company implements Node, Comparable {
    private StringBuffer name=new StringBuffer(100);
    private StringBuffer adress=new StringBuffer(100);
    private StringBuffer ceo=new StringBuffer(100);
    private int numberOfEmployee;
    private int importance;

    /**
     * Allocates memory and initializes a Person object
     *
     * @param name represents the name of this company
     * @param adress represents the adress of this company
     * @param ceo represents the ceo of this company
     * @param numberOfEmployee represents the number of employee of this company
     */
    public Company(String name, String adress, String ceo, int numberOfEmployee) {
        this.name.replace(0,100,name);
        this.adress.replace(0,100,adress);
        this.ceo.replace(0,100,ceo);
        this.numberOfEmployee = numberOfEmployee;
    }

    public int getImportance() {
        return importance;
    }

    public void setImportance(int importance) {
        this.importance = importance;
    }

    /**
     * Sets the name of this company
     *
     * @param name represents the name of this company
     */
    public void setName(String name) {
        this.name.replace(0,100,name);
    }

    /**
     * Gives the address of this company
     *
     * @return a string, the address of this company
     */
    public StringBuffer getAdress() {
        return adress;
    }

    /**
     * Sets the address of this company
     *
     * @param adress represents the address of this company
     */
    public void setAdress(String adress) {
        this.adress.replace(0,100,adress);
    }

    /**
     * Gives the name of the ceo of this company
     *
     * @return a string, the name of the ceo of this company
     */
    public StringBuffer getCeo() {
        return ceo;
    }

    /**
     * Sets the name of the ceo of this company
     *
     * @param ceo represents the name of this company
     */
    public void setCeo(String ceo) {
        this.ceo.replace(0,100,ceo);
    }

    /**
     *Gives the number of employee of this company
     *
     * @return an int, the number of employee of this company
     */
    public int getNumberOfEmployee() {
        return numberOfEmployee;
    }

    /**
     * Sets the number of employee of this company
     *
     * @param numberOfEmployee the number of employee of this company
     */
    public void setNumberOfEmployee(int numberOfEmployee) {
        this.numberOfEmployee = numberOfEmployee;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name=" + name +
                ", adress=" + adress +
                ", ceo=" + ceo +
                ", numberOfEmployee=" + numberOfEmployee +
                ", importance=" + importance +
                '}';
    }

    /**
     * Compare two Company object by their names.
     *
     * @param o represents an object
     * @return an int (0 if the names of the Company objects are equals,
     * >0 if the first name is comparably bigger than the second one,
     * <0 if the second name is comparably bigger than the first one
     */
    @Override
    public int compareTo(Object o) {
        if (o == null )
            throw new NullPointerException();
        if (!( o instanceof Compulsory.Company))
            throw new ClassCastException ("Uncomparable objects!");

        Compulsory.Company company = (Compulsory.Company) o;
        return this.name.compareTo((company.getName()));
    }

    /**
     * Gives the name of this company
     *
     * @return a string, the name of this company
     */
    @Override
    public StringBuffer getName() {
        return this.name;
    }
}

