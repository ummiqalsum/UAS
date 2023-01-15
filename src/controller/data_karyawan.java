package controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author acer
 */
public class data_karyawan {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    private String sql;
    public String nip;
    public String nama;
    public String jabatan;
    public String jenis_kelamin;
    public String telepon;
    public String status;
    public String alamat;
    
    public void simpan()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "INSERT INTO karyawan(nip,nama,jabatan,jenis_kelamin,telepon,status,alamat)VALUE(?,?,?,?,?,?,?)";
        pst = conn.prepareStatement(sql);
        pst.setString(1,nip);
        pst.setString(2,nama);
        pst.setString(3,jabatan);
        pst.setString(4,jenis_kelamin);
        pst.setString(5,telepon);
        pst.setString(6,status);
        pst.setString(7,alamat);
        pst.execute();
        pst.close();
    }
    
    public void edit()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "UPDATE karyawan set nama=?, jabatan=?, jenis_kelamin=?, telepon=?, status=?, alamat=? where nip=?";
        pst = conn.prepareStatement(sql);
        pst.setString(1,nama);
        pst.setString(2,jabatan);
        pst.setString(3,jenis_kelamin);
        pst.setString(4,telepon);
        pst.setString(5,status);
        pst.setString(6,alamat);
        pst.setString(7,nip);
        pst.execute();
        pst.close();
    }
    
    public void hapus() throws SQLException{
        conn=Koneksi.getKoneksi();
        String sql="DELETE from karyawan where nip=?";
        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1, nip);
            pst.execute();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public ResultSet UpdatekaryawanT()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "select nip,nama,jabatan,jenis_kelamin,telepon,status,alamat from karyawan";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        return rs;
    }
}
