package smsservice;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author taopik ridwan <blackonta@gmail.com>
 */
public class MYSQLConnection {
    public static Connection buatKoneksi() throws Exception{
        Properties prop = new Properties();
        try {
            prop.loadFromXML(new FileInputStream("setting/database.xml"));
        } catch (IOException ex) {
            Logger.getLogger(MYSQLConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String url = "jdbc:mysql://"+prop.getProperty("HOST")+":"+prop.getProperty("PORT")+"/"+prop.getProperty("DATABASE")+"?zeroDateTimeBehavior=convertToNull";
        String user = prop.getProperty("USER");
        String pass = prop.getProperty("PAS");
        Connection koneksi = null;
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        koneksi = DriverManager.getConnection(url, user, pass);
        
        return koneksi;
    }
}
