package tershane;
//Arbeiter Class
/*
@author Zeynep Sena Karabacak
*/

public class arbeiter {
    private int id;
    private String name;
    private String nachname;
    private String passwort;
    private String berichtigung;
    
    public arbeiter(int i, String n, String nn, String p, String b){
        this.id = i;
        this.name = n;
        this.nachname = nn;
        this.passwort = p;
        this.berichtigung = b;
    }
    
    int getId(){
        return this.id;
    }
    
    String getName(){
        return this.name;
    }
    
    String getNachname(){
        return this.nachname;
    }
    
    String getPasswort(){
        return this.passwort;
    }
   
    String getBerichtigung(){
        return this.berichtigung;
    }
   
}
