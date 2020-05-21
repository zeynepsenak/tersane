package tershane;

import java.sql.*;
import java.util.*;
import java.util.logging.*;
//Datenbank Operations
/*
@author Zeynep Sena Karabacak
*/

public class fdatenbank {
    private static final String con="jdbc:mysql://localhost:3306/firmen?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static String user="root";
    private static String pas="luhan1907";
    Connection conn;
    Statement st;
    PreparedStatement ps;
    ResultSet rs;
    String query;
    
    public String fdb_con() {
        
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
        
    public ArrayList<firmen> fdb_list(){
        
        ArrayList<firmen> firma = new ArrayList <>();
        try{
            
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM firma");
            
            while(rs.next()){
                firmen a = new firmen(
                        rs.getInt("id"),
                        rs.getString("fname"),
                        rs.getString("fstandort"),
                        rs.getString("auftragnos"),
                        rs.getString("angebotnos")
                ); firma.add(a);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(datenbank.class.getName()).log(Level.SEVERE, null, ex);
        }
        return firma;
            
    }
    
    static ArrayList<firmen> getFirma(){
        ArrayList<firmen> firma = new ArrayList <firmen>();
                
        return firma;
    }
    
    
    public String fdb_add(String nm, String loc, String a, String o){
        query = " insert into firma (fname, fstandort, auftragnos, angebotnos)" + " values (?, ?, ?, ?)";
            
        try {
            ps = conn.prepareStatement(query);
            ps.setString (1, nm);
            ps.setString (2, loc);
            ps.setString (3, a);
            ps.setString (4, o);

            // execute the preparedstatement
            ps.execute();
            return "add succes";
        } catch (SQLException ex) {
            Logger.getLogger(datenbank.class.getName()).log(Level.SEVERE, null, ex);
            return "add fehler";
        }
    }
    
    public String fdb_del(int i){
        query = "delete from firma where id = ?";
                
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
    
    public String fdb_upd(int i, String n, String l, String a, String o){
        query = "update firma set fname=?, fstandort=?, auftragnos= ?, angebotnos=? where id=?";
            
            
        try {
            ps = conn.prepareStatement(query);
            ps.setInt (5, i); 
            ps.setString (1, n);
            ps.setString (2, l);
            ps.setString (3, a);
            ps.setString (4, o);

            ps.execute();
            return "upd succes";
        } catch (SQLException ex) {
            Logger.getLogger(datenbank.class.getName()).log(Level.SEVERE, null, ex);
            return "Ein Fehler ist aufgetreten!";
        }       
    }
    
    public String[] fget_info(int i){
        String[] info = new String[4];
        try{
            ps = conn.prepareStatement("SELECT * FROM firma WHERE id=?");
            ps.setInt(1, i);
            rs = ps.executeQuery();
            
            if(rs.next()){
                info[0] = rs.getString(2);
                info[1] = rs.getString(3);
                info[2] = rs.getString(4);
                info[3] = rs.getString(5);    
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(datenbank.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return info;
    }
    public String[] fget_info(String n){
        String[] info = new String[4];
        try{
            ps = conn.prepareStatement("SELECT * FROM firma WHERE fname=?");
            ps.setString(1, n);
            rs = ps.executeQuery();
            
            if(rs.next()){
                info[0] = rs.getString(1);
                info[1] = rs.getString(3);
                info[2] = rs.getString(4);
                info[3] = rs.getString(5);    
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(datenbank.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return info;
    }
    
    
}
