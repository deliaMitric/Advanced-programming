package Homework;

/**
 *
 *
 * @author Delia
 */
public class Programmer extends Person{
    private StringBuffer favoriteLanguage=new StringBuffer(20);
    private int knownPromLanguages;

   public Programmer(String name, String emailAddress, String telephone, String favoriteLanguage, int age,int knownPromLanguages )
   {
       this.setName(name);
       this.setEmailAdress(emailAddress);
       this.setTelephone(telephone);
       this.setAge(age);
       this.favoriteLanguage.replace(0,20,favoriteLanguage);
       this.knownPromLanguages=knownPromLanguages;
   }

    public StringBuffer getFavoriteLanguage() {
        return favoriteLanguage;
    }

    public void setFavoriteLanguage(StringBuffer favoriteLanguage) {
        this.favoriteLanguage = favoriteLanguage;
    }

    public int getKnownPromLanguages() {
        return knownPromLanguages;
    }

    public void setKnownPromLanguages(int knownPromLanguages) {
        this.knownPromLanguages = knownPromLanguages;
    }
}
