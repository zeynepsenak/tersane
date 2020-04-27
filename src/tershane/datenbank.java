package tershane;

import java.sql.*;
import java.util.*;
import java.util.logging.*;
//Datenbank Operations
/*
@author Zeynep Sena Karabacak
*/

public class datenbank {
    private static final String con="jdbc:mysql://localhost:3306/employees?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static String user="root";
    private static String pas="luhan1907";
    Connection conn;
    Statement st;
    PreparedStatement ps;
    ResultSet rs;
    String query;
    
    public String db_con() {
        
      try{
            conn = DriverManager.getConnection(con,user,pas);
            System.out.println("Connected");
            
            return "Connected";
        }
        catch (SQLException e){
            System.err.println(e);
            
            return "Connection Fehler";
        }  
    }
        
    public ArrayList<arbeiter> db_list(){
        
        ArrayList<arbeiter> arbeiter = new ArrayList <>();
        try{
            
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM employee");
            
            while(rs.next()){
                arbeiter a = new arbeiter(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("nachname"),
                        rs.getString("pass"),
                        rs.getString("berichtigung")
                ); arbeiter.add(a);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(datenbank.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arbeiter;
            
    }
    
    static ArrayList<arbeiter> getArbeiter(){
        ArrayList<arbeiter> arbeiter = new ArrayList <arbeiter>();
                
        return arbeiter;
    }
    
    public String login(int i, String pass){
        try {
            ps = conn.prepareStatement("SELECT berichtigung FROM employee WHERE id=? AND pass=?");
            ps.setInt(1, i);
            ps.setString(2, pass);
            rs = ps.executeQuery();

            if(rs.next()){
                System.out.println("exist");
                if(rs.getString("berichtigung").equals("Admin")){
                    return "Admin";
                }else{
                    return "Mitarbeiter";
                }
            }
            else{
                System.out.println("not exist");
                return "not exist";
            }
        } catch (SQLException ex) {
            Logger.getLogger(datenbank.class.getName()).log(Level.SEVERE, null, ex);
            return "log fehler";
        }
        
    }
    
    public String db_add(String nm, String nnm, String ber){
        query = " insert into employee (name, nachname, pass, berichtigung)" + " values (?, ?, ?, ?)";
            
        try {
            ps = conn.prepareStatement(query);
            ps.setString (1, nm);
            ps.setString (2, nnm);
            ps.setString (3, "pass");
            ps.setString (4, ber);

            // execute the preparedstatement
            ps.execute();
            return "add succes";
        } catch (SQLException ex) {
            Logger.getLogger(datenbank.class.getName()).log(Level.SEVERE, null, ex);
            return "add fehler";
        }
    }
    
    public String db_del(int i){
        query = "delete from employee where id = ?";
                
        try {
            ps = conn.prepareStatement(query);
            ps.setInt (1, i);
            ps.execute();
            return "del succes";
        } catch (SQLException ex) {
            Logger.getLogger(datenbank.class.getName()).log(Level.SEVERE, null, ex);
            return "Ein Fehler ist aufgetreten!";
        }
        
    }
    
    public String db_upd(int i, String n, String nn, String b){
        query = "update employee set name=?,nachname=?,berichtigung= ? where id =?";
            
            
        try {
            ps = conn.prepareStatement(query);
            ps.setInt (4, i); 
            ps.setString (1, n);
            ps.setString (2, nn);
            ps.setString (3, b);

            ps.execute();
            return "upd succes";
        } catch (SQLException ex) {
            Logger.getLogger(datenbank.class.getName()).log(Level.SEVERE, null, ex);
            return "Ein Fehler ist aufgetreten!";
        }       
    }
    
    public String[] get_info(int i){
        String[] info = new String[3];
        try{
            ps = conn.prepareStatement("SELECT * FROM employee WHERE id=?");
            ps.setInt(1, i);
            rs = ps.executeQuery();
            
            if(rs.next()){
                info[0] = rs.getString(2);
                info[1] = rs.getString(3);
                info[2] = rs.getString(5);    
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(datenbank.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return info;
    }
    
    
}
