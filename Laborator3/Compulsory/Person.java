package Compulsory;

/**
 *Person class implements interfaces Node and Comparable
 * and represents a person identified unique by name and defined by age, emailAdress and telephone
 *
 * @author Delia
 */
public class Person implements Node, Comparable {
    private StringBuffer name=new StringBuffer(100);
    private int age;
    private StringBuffer emailAdress=new StringBuffer(100);
    private StringBuffer telephone=new StringBuffer(11);

    /**
     * Allocates memory and initializes a Person object
     *
     * @param name represents a string, the name of this person
     * @param age represents an int, the age of this person
     * @param emailAdress represents a string, the emailAdress  of this person
     * @param telephone represents a string, the telephone number of this person
     */
    public Person(String name, int age, String emailAdress, String telephone) {
        this.name.replace(0,100,name);
        this.age = age;
        this.emailAdress.replace(0,100, emailAdress);
        this.telephone.replace(0,11,telephone);
    }

    /**
     * Sets the name of this person
     *
     * @param name represents a string, the name of this person
     */
    public void setName(String name) {
        this.name.replace(0,100,name);
    }

    /**
     * Sets the age of this person
     *
     * @param age represents an int, the age of this person
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Sets the emailAdress of this person
     *
     * @param emailAdress represents a string, the emailAdress  of this person
     */
    public void setEmailAdress(String emailAdress) {
        this.emailAdress.replace(0,100,emailAdress);
    }

    /**
     * Sets the telephone of this person
     *
     * @param telephone represents a string, the telephone number of this person
     */
    public void setTelephone(String telephone) {
        this.telephone.replace(0,11,telephone);
    }

    /**
     * Gives the age of this person
     *
     * @return an int, the age of this person
     */
    public int getAge() {
        return age;
    }

    /**
     * Gives the emailAdress of this person
     *
     * @return a string, the emailAddres of the person
     */
    public StringBuffer getEmailAdress() {
        return emailAdress;
    }

    /**
     * Gives the telephone of this person
     *
     * @return a string, the telephone number of this person
     */
    public StringBuffer getTelephone() {
        return telephone;
    }

    /**
     * Compare two Person object by their names.
     *
     * @param o represents an object
     * @return an int (0 if the names of the Person objects are equals,
     * >0 if the first name is comparably bigger than the second one,
     * <0 if the second name is comparably bigger than the first one
     */
    @Override
    public int  compareTo (Object o) {
        if (o == null )
            throw new NullPointerException();
        if (!( o instanceof Person))
            throw new ClassCastException ("Uncomparable objects!");

        Person pers = (Person) o;
        return this.name.compareTo((pers.getName()));
    }

    @Override
    public String toString() {
        return "Person{" +
                "name=" + name +
                ", age=" + age +
                ", emailAdress=" + emailAdress +
                ", telephone=" + telephone +
                '}';
    }

    /**
     * Gives the name of this person
     *
     * @return a string, the name of this person
     */
    @Override
    public StringBuffer getName() {
        return this.name;
    }
}
