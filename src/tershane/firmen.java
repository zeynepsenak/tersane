package tershane;
import java.util.*;
//Firmen Class
/*
@author Zeynep Sena Karabacak
*/
public class firmen {
    private int id;
    private String name;
    private String location;
    //private int[] jobord = new int[100];
    private String jobord;
    //private String[] offno = new String[100];
    private String offno;
    
    public firmen(int i, String n, String l, String j, String o){
        this.id = i;
        this.name = n;
        this.location = l;
        this.jobord = j;
        this.offno = o;
    }
    int getId(){
        return this.id;
    }
    String getName(){
        return this.name;
    }
    String getLoc(){
        return this.location;
    }
    String getJobord(){
        return this.jobord;
    }
    String getOffno(){
        return this.offno;
    }
}
