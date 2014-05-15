/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fungsi;

/**
 *
 * @author Owner
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author Owner
 */
public final class koneksiDB {
    public koneksiDB(){}
    
    private static Connection connection=null;
    public static Connection condb(){
        Properties prop = new Properties();        
        if(connection == null){
            try{
                prop.loadFromXML(new FileInputStream("setting/database.xml"));
                String url="jdbc:mysql://"+prop.getProperty("HOST")+":"+prop.getProperty("PORT")+"/"+prop.getProperty("DATABASE")+"?zeroDateTimeBehavior=convertToNull";
                String user=prop.getProperty("USER");
                String pass=prop.getProperty("PAS");
                Class.forName("com.mysql.jdbc.Driver");
                connection=DriverManager.getConnection(url,user,pass);            
                System.out.println("panggil driver");
            }catch(IOException | ClassNotFoundException | SQLException e){
                //System.out.println("gagal di : "+e);
                JOptionPane.showMessageDialog(null,"Error : "+e);
            }
        }
        return connection;
        
    }


}
