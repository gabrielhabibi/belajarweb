package miniproject;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class koneksi {
    private String url="jdbc:mysql://localhost/saladmoy";
    private String username="root";
    private String password="";
    Connection conDB;
    
    public void Connect(){
        try {
            conDB=DriverManager.getConnection(url,username,password);
            System.out.println("koneksi berhasil");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    public Connection getCon(){
        return conDB;
        
    }
}
