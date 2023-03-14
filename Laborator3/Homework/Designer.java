package Homework;

/**
 *
 *
 * @author Delia
 */
public class Designer extends Person{
    private int numberOfPatents;
    public Designer(String name, String emailAddress, String telephone,  int age,int numberOfPatents)
    {
        this.setName(name);
        this.setAge(age);
        this.setTelephone(telephone);
        this.setEmailAdress(emailAddress);
        this.numberOfPatents=numberOfPatents;
    }

    public int getNumberOfPatents() {
        return numberOfPatents;
    }

    public void setNumberOfPatents(int numberOfPatents) {
        this.numberOfPatents = numberOfPatents;
    }
}
