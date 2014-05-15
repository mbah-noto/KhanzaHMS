/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fungsi;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import uz.ncipro.calendar.JDateTimePicker;

/**
 *
 * @author Owner
 */
public final class sekuel {
    private javax.swing.ImageIcon icon = null;
    private javax.swing.ImageIcon iconThumbnail = null;
    private String folder;    
    private final Connection connect=koneksiDB.condb();
    private Statement statement;
    private PreparedStatement ps;
    private ResultSet rs;
    public sekuel(){
        super();
    }


    public void menyimpan(String table,String value,String sama){
        try{  
            ps=connect.prepareStatement("insert into "+table+" values("+value+")");
            ps.executeUpdate();
            //statement.close(); 
        }catch(SQLException e){
            System.out.println("Pesan Error : "+e);            
            JOptionPane.showMessageDialog(null,"Maaf, gagal menyimpan data. Kemungkinan ada "+sama+" yang sama dimasukkan sebelumnya...!");
        }
    }
    
    public void menyimpan(String table,String isisimpan,String isiedit,String acuan_field){
        try{            
            statement=connect.createStatement();
            statement.executeUpdate("insert into "+table+" values("+isisimpan+")");
            //statement.close();               
        }catch(SQLException e){
            System.out.println("Pesan Error Simpan : "+e);
            try {
                statement=connect.createStatement();
                statement.executeUpdate("update "+table+" set "+isiedit+" where "+acuan_field);
                //statement.close();
            } catch (SQLException ex) {
                System.out.println("Pesan Error Edit : "+ex);
            }
        }
    }

    public void menyimpan(String table,String value,String sama,JTextField AlmGb){
        try{            
            String sql="insert into "+table+" values("+value+",?)";
            ps = connect.prepareStatement(sql);
            ps.setBinaryStream(1, new FileInputStream(AlmGb.getText()), new File(AlmGb.getText()).length());
            ps.executeUpdate();
            //ps.close();
        }catch(SQLException | FileNotFoundException e){
            System.out.println("Pesan Error : "+e);
            JOptionPane.showMessageDialog(null,"Maaf, gagal menyimpan data. Kemungkinan ada "+sama+" yang sama dimasukkan sebelumnya...!");
        }
    }
    

    public void meghapus(String table,String field,String nilai_field) {
        try{         
            ps=connect.prepareStatement("delete from "+table+" where "+field+"='"+nilai_field+"'");
            ps.executeUpdate();
            //statement.close();   
         }catch(SQLException e){
            System.out.println("Pesan Error : "+e);
            JOptionPane.showMessageDialog(null,"Maaf, data gagal dihapus. Kemungkinan data tersebut masih dipakai di table lain...!!!!");
         }
    }
    

    public void mengedit(String table,String acuan_field,String update){
        try{            
            ps=connect.prepareStatement("update "+table+" set "+update+" where "+acuan_field);
            ps.executeUpdate();
            //statement.close();         
         }catch(SQLException e){
            System.out.println("Pesan Error : "+e);
            JOptionPane.showMessageDialog(null,"Maaf, Gagal Mengedit. Mungkin kode sudah digunakan sebelumnya...!!!!");
         }
    }
    

    public void mengedit(String table,String acuan_field,String update,JTextField AlmGb){
        try{            
            String sql="update "+table+" set "+update+" where "+acuan_field;
            ps = connect.prepareStatement(sql);
            ps.setBinaryStream(1, new FileInputStream(AlmGb.getText()), new File(AlmGb.getText()).length());
            ps.executeUpdate();
            //ps.close();  
         }catch(SQLException | FileNotFoundException e){
            System.out.println("Pesan Error : "+e);
            JOptionPane.showMessageDialog(null,"Maaf, Pilih dulu data yang mau anda edit...\n Klik data pada table untuk memilih...!!!!");
         }
    }

    public void query(String qry){
        try{            
            ps=connect.prepareStatement(qry);
            ps.executeQuery();
            //statement.close();  
         }catch(SQLException e){
            System.out.println("Pesan Error : "+e);
            JOptionPane.showMessageDialog(null,"Maaf, Query tidak bisa dijalankan...!!!!");
         }
    }

    public void queryu(String qry){
        try{            
            ps=connect.prepareStatement(qry);
            ps.executeUpdate();
            //statement.close();  
         }catch(SQLException e){
            System.out.println("Pesan Error : "+e);
            JOptionPane.showMessageDialog(null,"Maaf, Query tidak bisa dijalankan...!!!!");
         }
    }
    
    public void queryu(String qry,String parameter){
        try{            
            ps=connect.prepareStatement(qry);
            ps.setString(1,parameter);
            ps.executeUpdate();
            //statement.close();  
         }catch(SQLException e){
            System.out.println("Pesan Error : "+e);
            JOptionPane.showMessageDialog(null,"Maaf, Query tidak bisa dijalankan...!!!!");
         }
    }
    
    
    public void queryu2(String qry){
        try{            
            ps=connect.prepareStatement(qry);
            ps.executeUpdate();
            //statement.close();  
         }catch(SQLException e){
            System.out.println("Pesan Error : "+e);
         }
    }

    public void cariIsi(String sql,JComboBox cmb){
        try{  
            rs=connect.createStatement().executeQuery(sql);
            if(rs.next()){
                String dicari=rs.getString(1);
                cmb.setSelectedItem(dicari);
            }else{
                cmb.setSelectedItem("");
            }
            //rs.close();
            //statement.close();     
        }catch(SQLException e){
            System.out.println("Error : "+e);
        }
    }

    public void cariIsi(String sql,JDateTimePicker dtp){
        try{            
            rs=connect.createStatement().executeQuery(sql);
            if(rs.next()){
                String dicari=rs.getString(1);
                try {
                    dtp.setDisplayFormat("yyyy-MM-dd");
                    Date dtpa = new SimpleDateFormat("yyyy-MM-dd").parse(dicari);
                    dtp.setDate(dtpa);
                    dtp.setDisplayFormat("dd-MM-yyyy");
                } catch (ParseException ex) {
                    System.out.println(ex);
                }
            }
            //rs.close();
            //statement.close();       
        }catch(SQLException e){
            System.out.println("Error : "+e);
        }
    }

    public void cariIsi(String sql,JTextField txt){
        try{            
            rs=connect.prepareStatement(sql).executeQuery();
            if(rs.next()){
                String dicari=rs.getString(1);
                txt.setText(dicari);
            }else{
                txt.setText("");
            }
            //rs.close();   
        }catch(SQLException e){
            System.out.println("Error : "+e);
        }
    }
    
    public void cariIsi(String sql,JTextField txt,String kunci){
        try{      
            ps=connect.prepareStatement(sql);
            ps.setString(1,kunci);
            rs=ps.executeQuery();
            if(rs.next()){
                String dicari=rs.getString(1);
                txt.setText(dicari);
            }else{
                txt.setText("");
            }
            //rs.close();   
        }catch(SQLException e){
            System.out.println("Error : "+e);
        }
    }    
    

    public void cariIsi(String sql,JLabel txt){
        try{            
            statement=connect.createStatement();
            rs=statement.executeQuery(sql);
            if(rs.next()){
                String dicari=rs.getString(1);
                txt.setText(dicari);
            }else{
                txt.setText("");
            }
            //rs.close();
            //statement.close();  
        }catch(SQLException e){
            System.out.println("Error : "+e);
        }
    }
    
    public String cariIsi(String sql){
        String a="";
        try{            
            rs=connect.createStatement().executeQuery(sql);            
            if(rs.next()){
                a=rs.getString(1);
            }else{
                a="";
            }
            //rs.close();    
        }catch(SQLException e){
            System.out.println("Error : "+e);
        }
        return a;
    }
    
    public String cariIsi(String sql,String data){
        String a="";
        try{            
            ps=connect.prepareStatement(sql);
            ps.setString(1,data);
            rs=ps.executeQuery();            
            if(rs.next()){
                a=rs.getString(1);
            }else{
                a="";
            }
            //rs.close();    
        }catch(SQLException e){
            System.out.println("Error : "+e);
        }
        return a;
    }
    
    public Date cariIsi2(String sql){
        Date a=new Date();
        try{            
            rs=connect.prepareStatement(sql).executeQuery();            
            if(rs.next()){
                a=rs.getDate(1);
            }else{
                a=new Date();
            }
            //rs.close();   
        }catch(SQLException e){
            System.out.println("Error : "+e);
        }
        return a;
    }

    public Integer cariInteger(String sql){
        int a=0;
        try{            
            rs=connect.prepareStatement(sql).executeQuery();            
            if(rs.next()){
                a=rs.getInt(1);
            }else{
                a=0;
            }
            //rs.close();   
        }catch(SQLException e){
            System.out.println("Error : "+e);
        }
        return a;
    }
    
    public Integer cariInteger(String sql,String data){
        int a=0;
        try{       
            ps=connect.prepareStatement(sql);
            ps.setString(1,data);
            rs=ps.executeQuery();            
            if(rs.next()){
                a=rs.getInt(1);
            }else{
                a=0;
            }
            //rs.close();   
        }catch(SQLException e){
            System.out.println("Error : "+e);
        }
        return a;
    }
    
    public Integer cariInteger2(String sql){
        int a=0;
        try{            
            statement=connect.createStatement();
            rs=statement.executeQuery(sql);            
            rs.last();
            a=rs.getRow();
            if(a<1){
                a=0;
            }
            //rs.close();
            //statement.close();    
        }catch(SQLException e){
            System.out.println("Error : "+e);
        }
        return a;
    }

    public void cariIsiAngka(String sql,JTextField txt){
        DecimalFormat df2 = new DecimalFormat("####");
        try{            
            statement=connect.createStatement();
            rs=statement.executeQuery(sql);
            if(rs.next()){
                txt.setText(df2.format(rs.getDouble(1)));
            }else{
                txt.setText("0");
            }
            //rs.close();
            //statement.close();
        }catch(SQLException e){
            System.out.println("Error : "+e);
        }
    }

    public void cariIsiAngka(String sql,JLabel txt) {
        DecimalFormat df2 = new DecimalFormat("####");
        try{            
            statement=connect.createStatement();
            rs=statement.executeQuery(sql);
            if(rs.next()){
                txt.setText(df2.format(rs.getDouble(1)));
            }else{
                txt.setText("0");
            }
            //rs.close();
            //statement.close();
        }catch(SQLException e){
            System.out.println("Error : "+e);
        }
    }
    
    public double cariIsiAngka(String sql) {
        double nilai=0;
        try{            
            rs=connect.prepareStatement(sql).executeQuery();
            if(rs.next()){
                nilai=rs.getDouble(1);
            }else{
                nilai=0;
            }
            //rs.close();
        }catch(SQLException e){
            System.out.println("Error : "+e);
        }
        return nilai;
    }
    
    public double cariIsiAngka(String sql,String data) {
        double nilai=0;
        try{            
            ps=connect.prepareStatement(sql);
            ps.setString(1,data);
            rs=ps.executeQuery();
            if(rs.next()){
                nilai=rs.getDouble(1);
            }else{
                nilai=0;
            }
            //rs.close();
        }catch(SQLException e){
            System.out.println("Error : "+e);
        }
        return nilai;
    }

    public void cariGambar(String sql,JLabel txt){        
        try{            
            statement=connect.createStatement();
            rs=statement.executeQuery(sql);
            if(rs.next()){
                Blob b = rs.getBlob(1);
                icon = new javax.swing.ImageIcon(b.getBytes(1L, (int) b.length()));
                createThumbnail();
                txt.setIcon(icon);
            }else{
                txt.setText(null);
            }
            //rs.close();
            //statement.close();
        }catch(SQLException e){
            System.out.println("Error : "+e);
        }
    }

    public void cariGambar(String sql,java.awt.Canvas txt,String text){
          try {                
                statement=connect.createStatement();
                rs = statement.executeQuery(sql);
                for (int I = 0; rs.next(); I++) {
                    ((Painter) txt).setImage(gambar(text));
                    Blob blob = rs.getBlob(5);
                    ((Painter) txt).setImageIcon(new javax.swing.ImageIcon(
                        blob.getBytes(1, (int) (blob.length()))));
                }
                //hasil.close();
                //statement.close();   
            } catch (SQLException ex) {
                cetak(ex.toString());
            }
    }
    
    public String cariString(String sql){
        String a="";
        try{            
            statement=connect.createStatement();
            rs=statement.executeQuery(sql);            
            if(rs.next()){
                a=rs.getString(1);
            }else{
                a="";
            }
            
            //statement.close();    
        }catch(SQLException e){
            System.out.println("Error : "+e);
        }
        return a;
    }

    private String gambar(String id) {
        return folder + File.separator + id.trim() + ".jpg";
    }
    
    public void Tabel(javax.swing.JTable tb,int lebar[]){
      tb.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
      int kolom=tb.getColumnCount();
      for(int i=0;i < kolom;i++){
          javax.swing.table.TableColumn tbc = tb.getColumnModel().getColumn(i);
          tbc.setPreferredWidth(lebar[i]);
          //tb.setRowHeight(17);
      }
  }

    private void createThumbnail() {
        int maxDim = 150;
        try {
            Image inImage = icon.getImage();

            double scale = (double) maxDim / (double) inImage.getHeight(null);
            if (inImage.getWidth(null) > inImage.getHeight(null)) {
                scale = (double) maxDim / (double) inImage.getWidth(null);
            }

            int scaledW = (int) (scale * inImage.getWidth(null));
            int scaledH = (int) (scale * inImage.getHeight(null));

            BufferedImage outImage = new BufferedImage(scaledW, scaledH,
            BufferedImage.TYPE_INT_RGB);

            AffineTransform tx = new AffineTransform();

            if (scale < 1.0d) {
                tx.scale(scale, scale);
            }

            Graphics2D g2d = outImage.createGraphics();
            g2d.drawImage(inImage, tx, null);
            g2d.dispose();

            iconThumbnail = new javax.swing.ImageIcon(outImage);
        } catch (Exception e) {
        }
    }

    private void cetak(String str) {
        System.out.println(str);
    }



   public class Painter extends Canvas {

        Image image;

        private void setImage(String file) {
            URL url = null;
            try {
                url = new File(file).toURI().toURL();
            } catch (MalformedURLException ex) {
                cetak(ex.toString());
            }
            image = getToolkit().getImage(url);
            repaint();
        }
        private void setImageIcon(ImageIcon file) {
            image = file.getImage();
            repaint();
        }



        @Override
        public void paint(Graphics g) {
            double d = image.getHeight(this) / this.getHeight();
            double w = image.getWidth(this) / d;
            double x = this.getWidth() / 2 - w / 2;
            g.drawImage(image, (int) x, 0, (int) (w), this.getHeight(), this);
        }

        private void cetak(String str) {
            System.out.println(str);
        }
    }

   public class NIOCopier {

        public NIOCopier(String asal, String tujuan) throws IOException {
            FileOutputStream outFile;
            try (FileInputStream inFile = new FileInputStream(asal)) {
                outFile = new FileOutputStream(tujuan);
                FileChannel outChannel;
                try (FileChannel inChannel = inFile.getChannel()) {
                    outChannel = outFile.getChannel();
                    for (ByteBuffer buffer = ByteBuffer.allocate(1024 * 1024);
                            inChannel.read(buffer) != -1;
                            buffer.clear()) {
                        buffer.flip();
                        while (buffer.hasRemaining()) {
                            outChannel.write(buffer);
                        }
                    }
                }
            outChannel.close();
            }
            outFile.close();
        }
    }

}
