package tershane;
import java.util.*;
//Firmen Class
/*
@author Zeynep Sena Karabacak
*/
public class firmen {
    private String name;
    private String location;
    private int[] jobord = new int[100];
    private String[] offno = new String[100];
    
    public firmen(String n, String l, int[] j, String[] o){
        this.name = n;
        this.location = l;
        this.jobord = j;
        this.offno = o;
    }
    
    String getName(){
        return this.name;
    }
    String getLoc(){
        return this.location;
    }
    int[] getJobord(){
        return this.jobord;
    }
    String[] getOffno(){
        return this.offno;
    }
}
