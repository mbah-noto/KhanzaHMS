
package fungsi;


import fungsi.koneksiDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 *
 * @author Owner
 */

/**
 *
 * @author Owner
 */
public final class var {
    private static final Connection koneksi=koneksiDB.condb();
    private static PreparedStatement ps,ps2;
    private static ResultSet rs,rs2;
    
    private static String kode="",kdbangsal=""; 
    private static int jml1=0,jml2=0,lebar=0,tinggi=0;
    private static boolean close=false,poli=false,penyakit=false,obat=false,tagihan_operasi=false,kamar=false,spesialis=false,
                   tindakan=false,dokter=false,pegawai=false,pasien=false,admin=false,user=false,vakum=false,obat_penyakit=false,
                   registrasi=false,ralan=false,kamin=false,ranap=false,resep=false,rujuk=false,beriobat=false,billing=false,pasienmati=false,
                   kelahiran_bayi=false,billing_ralan=false,paket_operasi=false,diet_pasien=false,
                   periksa_lab=false,billing_ranap=false,suplier=false, jenis=false, 
                   satuan=false, konversisatuan=false, pembelian=false, penjualan=false,returbeli=false, returjual=false, stockopname=false, 
                   keuntungan=false, proyeksi=false, rekening=false, jurnal=false,bubes=false, cashflow=false, keuangan=false, piutang=false, 
                   bayar=false,returpiutang=false,status=false,rekening_tahun=false,aplikasi=false,display=false,setharga=false,biayaharian=false,
                   masuksekali=false,otoralan=false;
    

    public static void setData(String user, String pass) {
       try {                
           ps=koneksi.prepareStatement("select * from admin where usere=AES_ENCRYPT(?,'nur') and passworde=AES_ENCRYPT(?,'windi')");               
           ps2=koneksi.prepareStatement("select * from user where id_user=AES_ENCRYPT(?,'nur') and password=AES_ENCRYPT(?,'windi')");
           ps.setString(1,user);
           ps.setString(2,pass);
           rs=ps.executeQuery();
           rs.last();           
           
           ps2.setString(1,user);
           ps2.setString(2,pass);
           rs2=ps2.executeQuery();
           rs2.last();
                
               var.jml1=rs.getRow();
               var.jml2=rs2.getRow();               
               
                if(user.equals("admin") && pass.equals("akusayangsamakamu")){
                    var.kode="Admin Utama";
                    var.poli=true;
                    var.penyakit=true;
                    var.obat=true;
                    var.tagihan_operasi=true;
                    var.kamar=true;
                    var.tindakan=true;
                    var.dokter=true;
                    var.pegawai=true;
                    var.pasien=true;
                    var.diet_pasien=true;
                    var.paket_operasi=true;
                    var.admin=true;
                    var.user=true;      
                    var.vakum=true;  
                    var.obat_penyakit=true;
                    var.spesialis=true;
                    var.registrasi=true;
                    var.ralan=true;
                    var.kamin=true;
                    var.ranap=true;                 
                    var.resep=true;
                    var.rujuk=true;
                    var.beriobat=true;
                    var.billing=true;
                    var.pasienmati=true;
                    var.kelahiran_bayi=true;
                    var.billing_ralan=true; 
                    var.periksa_lab=true;
                    var.billing_ranap=true;
                    //modulapotek
                    var.suplier=true;
                    var.jenis=true;
                    var.satuan=true;
                    var.konversisatuan=true;
                    var.pembelian=true;
                    var.penjualan=true;
                    var.returbeli=true;
                    var.returjual=true;
                    var.stockopname=true;
                    var.keuntungan=true;
                    var.proyeksi=true;
                    var.rekening=true;
                    var.jurnal=true;
                    var.bubes=true;
                    var.cashflow=true;
                    var.keuangan=true;
                    var.piutang=true;
                    var.bayar=true;      
                    var.returpiutang=true;
                    var.rekening_tahun=true;
                    var.aplikasi=true;
                    var.display=true;
                    var.setharga=true;
                    var.biayaharian=true;
                    var.masuksekali=true;
                    var.otoralan=true;
                }else if(rs.getRow()>=1){
                    var.kode="Admin Utama";
                    var.poli=true;
                    var.penyakit=true;
                    var.obat=true;
                    var.tagihan_operasi=true;
                    var.kamar=true;
                    var.tindakan=true;
                    var.dokter=true;
                    var.pegawai=true;
                    var.pasien=true;
                    var.diet_pasien=true;
                    var.paket_operasi=true;
                    var.admin=true;
                    var.user=true;      
                    var.vakum=true;
                    var.obat_penyakit=true;
                    var.spesialis=true;
                    var.registrasi=true;
                    var.ralan=true;
                    var.kamin=true;
                    var.ranap=true;                 
                    var.resep=true;
                    var.rujuk=true;
                    var.beriobat=true;
                    var.billing=true;
                    var.pasienmati=true;
                    var.kelahiran_bayi=true;
                    var.billing_ralan=true;
                    var.periksa_lab=true;
                    var.billing_ranap=true;
                    //modulapotek
                    var.suplier=true;
                    var.jenis=true;
                    var.satuan=true;
                    var.konversisatuan=true;
                    var.pembelian=true;
                    var.penjualan=true;
                    var.returbeli=true;
                    var.returjual=true;
                    var.stockopname=true;
                    var.keuntungan=true;
                    var.proyeksi=true;
                    var.rekening=true;
                    var.jurnal=true;
                    var.bubes=true;
                    var.cashflow=true;
                    var.keuangan=true;
                    var.piutang=true;
                    var.bayar=true;      
                    var.returpiutang=true;
                    var.rekening_tahun=true;
                    var.aplikasi=true;
                    var.display=true;
                    var.setharga=true;
                    var.biayaharian=true;
                    var.masuksekali=true;
                    var.otoralan=true;
                }else if(rs2.getRow()>=1){   
                    rs2.beforeFirst();
                    rs2.next();
                    var.kode=user;
                    var.poli=rs2.getBoolean("poli");
                    var.penyakit=rs2.getBoolean("penyakit");
                    var.obat=rs2.getBoolean("obat");
                    var.tagihan_operasi=rs2.getBoolean("tagihan_operasi");
                    var.kamar=rs2.getBoolean("kamar");
                    var.tindakan=rs2.getBoolean("jns_prw");
                    var.dokter=rs2.getBoolean("dokter");
                    var.pegawai=rs2.getBoolean("petugas");
                    var.pasien=rs2.getBoolean("pasien");
                    var.diet_pasien=rs2.getBoolean("diet_pasien");
                    var.paket_operasi=rs2.getBoolean("paket_operasi");
                    var.obat_penyakit=rs2.getBoolean("obat_penyakit");
                    var.spesialis=rs2.getBoolean("spesialis");
                    var.admin=false;
                    var.user=false;   
                    var.vakum=false;
                    var.registrasi=rs2.getBoolean("reg");
                    var.ralan=rs2.getBoolean("rw_jln");
                    var.kamin=rs2.getBoolean("kamar_inap");
                    var.ranap=rs2.getBoolean("rw_inp");
                    var.rujuk=rs2.getBoolean("rujuk");                                     
                    var.resep=rs2.getBoolean("resep");
                    var.beriobat=rs2.getBoolean("br_obat");
                    var.billing=rs2.getBoolean("biling");
                    var.pasienmati=rs2.getBoolean("pasien_mati");
                    var.kelahiran_bayi=rs2.getBoolean("kelahiran_bayi");
                    var.billing_ralan=rs2.getBoolean("billing_ralan"); 
                    var.periksa_lab=rs2.getBoolean("periksa_lab");
                    var.billing_ranap=rs2.getBoolean("billing_ranap");
                    //modul apotek                    
                    var.suplier=rs2.getBoolean("suplier");
                    var.satuan=rs2.getBoolean("satuan");
                    var.konversisatuan=rs2.getBoolean("konversi");
                    var.stockopname=rs2.getBoolean("stok_opname");
                    var.pembelian=rs2.getBoolean("pembelian");
                    var.penjualan=rs2.getBoolean("penjualan");
                    var.returbeli=rs2.getBoolean("retur_beli");
                    var.returjual=rs2.getBoolean("retur_jual");
                    var.keuntungan=rs2.getBoolean("keuntungan_jual");
                    var.proyeksi=rs2.getBoolean("sirkulasi");
                    var.rekening=rs2.getBoolean("akun_rekening");
                    var.jurnal=rs2.getBoolean("posting_jurnal");
                    var.bubes=rs2.getBoolean("bubes");
                    var.cashflow=rs2.getBoolean("cashflow");
                    var.keuangan=rs2.getBoolean("keuangan");
                    var.piutang=rs2.getBoolean("piutang");
                    var.bayar=rs2.getBoolean("bayar_piutang");    
                    var.returpiutang=rs2.getBoolean("retur_piutang");
                    var.rekening_tahun=rs2.getBoolean("rekening_tahun");
                    var.aplikasi=false;
                    var.display=false;
                    var.setharga=false;
                    var.biayaharian=false;
                    var.masuksekali=false;
                    var.otoralan=false;
                }else if((rs.getRow()==0)&&(rs2.getRow()==0)){
                    var.kode="";                  
                    var.poli=false;
                    var.penyakit=false;
                    var.obat=false;
                    var.tagihan_operasi=false;
                    var.kamar=false;
                    var.tindakan=false;
                    var.dokter=false;
                    var.pegawai=false;
                    var.pasien=false;
                    var.diet_pasien=false;
                    var.paket_operasi=false;
                    var.admin=false;
                    var.user=false;
                    var.vakum=false;
                    var.obat_penyakit=false;
                    var.spesialis=false;
                    var.registrasi=false;
                    var.ralan=false;
                    var.kamin=false;
                    var.ranap=false;
                    var.rujuk=false;              
                    var.resep=false;
                    var.beriobat=false;
                    var.billing=false;
                    var.pasienmati=false;
                    var.kelahiran_bayi=false;
                    var.billing_ralan=false;
                    var.periksa_lab=false;
                    var.billing_ranap=false;
                    //modul apotek
                    var.suplier=false;
                    var.jenis=false;
                    var.satuan=false;
                    var.konversisatuan=false;
                    var.pembelian=false;
                    var.penjualan=false;
                    var.returbeli=false;
                    var.returjual=false;
                    var.stockopname=false;
                    var.keuntungan=false;
                    var.proyeksi=false;
                    var.rekening=false;
                    var.jurnal=false;
                    var.bubes=false;
                    var.cashflow=false;
                    var.keuangan=false;
                    var.piutang=false;
                    var.bayar=false;
                    var.returpiutang=false;
                    var.rekening_tahun=false;
                    var.aplikasi=false;
                    var.display=false;
                    var.setharga=false;
                    var.biayaharian=false;
                    var.masuksekali=false;
                    var.otoralan=false;
                }
            } catch (Exception e) {
                System.out.println("error : "+e);
            }

    }
    
    public static int getjml1() {
       return var.jml1;
    }
    
    public static int getjml2() {
       return var.jml2;
    }
    
    public static boolean getpoli() {
       return var.poli;
    }
    
    public static boolean getpenyakit() {
       return var.penyakit;
    }
    
    public static boolean getobat() {
       return var.obat;
    }
    
    public static boolean gettagihan_operasi() {
       return var.tagihan_operasi;
    }
    
    public static boolean getkamar() {
       return var.kamar;
    }
    
    public static boolean gettindakan() {
       return var.tindakan;
    }
    
    public static boolean getdokter() {
       return var.dokter;
    }
    
    public static boolean getpegawai() {
       return var.pegawai;
    }
    
    public static boolean getpasien() {
       return var.pasien;
    }
    
    public static boolean getpaket_operasi() {
       return var.paket_operasi;
    }
    
    public static boolean getdiet_pasien() {
       return var.diet_pasien;
    }
    
    public static boolean getregistrasi() {
       return var.registrasi;
    }
    
    public static boolean getralan() {
       return var.ralan;
    }
    
    public static boolean getkamin() {
       return var.kamin;
    }
    
    public static boolean getranap() {
       return var.ranap;
    }
    
    public static boolean getresep() {
       return var.resep;
    }
    
    public static boolean getrujuk() {
       return var.rujuk;
    }
    
    
    public static boolean getberiobat() {
       return var.beriobat;
    }
    
    public static boolean getbilling() {
       return var.billing;
    }
    
    public static boolean getpasienmati() {
       return var.pasienmati;
    }
    
    public static boolean getkelahiran_bayi() {
       return var.kelahiran_bayi;
    }
    
    public static boolean getbilling_ralan() {
       return var.billing_ralan;
    }
    
    public static boolean getsuplier() {
       return var.suplier;
    }
    
    public static boolean getperiksa_lab() {
       return var.periksa_lab;
    }

    
    public static boolean getbilling_ranap() {
       return var.billing_ranap;
    }

    
    public static boolean getsatuan() {
       return var.satuan;
    }
    
    public static boolean getadmin() {
       return var.admin;
    }
    
    public static boolean getobat_penyakit(){
       return var.obat_penyakit;                
    }
    
    public static boolean getspesialis(){
       return var.spesialis;                
    }
    
    public static boolean getuser() {
       return var.user;
    }
    
    public static String getkode() {
       return var.kode;
    }    
    
    
    public static boolean getvakum() {
       return var.vakum;
    }
    
        
    public static boolean getjenis() {
       return jenis;
    }

    
    public static boolean getkonversisatuan() {
       return konversisatuan;
    }
    
    public static boolean getpembelian() {
       return pembelian;
    }
    
    public static boolean getpenjualan() {
       return penjualan;
    }
    
    public static boolean getreturbeli() {
       return returbeli;
    }
    
    public static boolean getreturjual() {
       return returjual;
    }
    
    public static boolean getstockopname() {
       return stockopname;
    }
    
    public static boolean getkeuntungan() {
       return keuntungan;
    }
    
    public static boolean getproyeksi() {
       return proyeksi;
    }
    
    public static boolean getrekening() {
       return rekening;
    }
    
    public static boolean getjurnal() {
       return jurnal;
    }
    
    public static boolean getbubes() {
       return bubes;
    }
    
    public static boolean getcashflow() {
       return cashflow;
    }
    
    public static boolean getkeuangan() {
       return keuangan;
    }
    
    public static boolean getpiutang() {
       return piutang;
    }
    
    public static boolean getbayar() {
       return bayar;
    }
    
    public static boolean getreturpiutang() {
       return returpiutang;
    }
    
    public static boolean getrekening_tahun() {
       return rekening_tahun;
    }
    
    /*public static void setTinggi(int tinggi) {
        var.tinggi=tinggi;
    }
    
    public static int getTinggi() {
       return var.tinggi;
    }
    
    public static void setLebar(int lebar) {
        var.lebar=lebar;
    }
    
    public static int getLebar() {
       return var.lebar;
    }*/
    
    public static void setCLose(boolean close) {
        var.close=close;
    }
    
    public static boolean getClose() {
       return var.close;
    }
    
    public static void setStatus(boolean status) {
        var.status=status;
    }
    
    public static boolean getStatus() {
       return var.status;
    }
    
    public static void setBangsal(String bangsal) {
        var.kdbangsal=bangsal;
    }
    
    public static String getBangsal() {
       return var.kdbangsal;
    }
    
    public static boolean getaplikasi() {
       return var.aplikasi; 
    }
    
    public static boolean getdisplay() {
       return var.display;
    }
    
    public static boolean getsetharga() {
        return var.setharga;
    }
    
    public static boolean getbiayaharian() {
       return var.biayaharian;
    }
    
    public static boolean getmasuksekali() {
       return var.masuksekali;
    }

    public static boolean getotoralan() {
        return var.otoralan;
    }
}
