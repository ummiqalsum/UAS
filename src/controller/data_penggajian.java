/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author acer
 */
public class data_penggajian {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    private String sql;
    public String nama;
    public String jumlah_jam_kerja;
    public String golongan_jabatan;
    public String tunjangan_jabatan;
    public String honor_lembur;
    public String gaji_pokok;
    public String total_honor;
    
    public void simpan()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "INSERT INTO penggajian(nama,jumlah_jam_kerja,golongan_jabatan,tunjangan_jabatan,honor_lembur,gaji_pokok,total_honor)VALUE(?,?,?,?,?,?,?)";
        pst = conn.prepareStatement(sql);
        pst.setString(1,nama);
        pst.setString(2,jumlah_jam_kerja);
        pst.setString(3,golongan_jabatan);
        pst.setString(4,tunjangan_jabatan);
        pst.setString(5,honor_lembur);
        pst.setString(6,gaji_pokok);
        pst.setString(7,total_honor);
        pst.execute();
        pst.close();
    }
    
    public void edit()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "UPDATE penggajian set jumlah_jam_kerja=?, golongan_jabatan=?, tunjangan_jabatan=?, honor_lembur=?, gaji_pokok=?, total_honor=? where nama=?";
        pst = conn.prepareStatement(sql);
        pst.setString(1,jumlah_jam_kerja);
        pst.setString(2,golongan_jabatan);
        pst.setString(3,tunjangan_jabatan);
        pst.setString(4,honor_lembur);
        pst.setString(5,gaji_pokok);
        pst.setString(6,total_honor);
        pst.setString(7,nama);
        pst.execute();
        pst.close();
    }
    
    public void hapus() throws SQLException{
        conn=Koneksi.getKoneksi();
        String sql="DELETE from penggajian where nama=?";
        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1, nama);
            pst.execute();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public ResultSet UpdatepenggajianT()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "select nama,jumlah_jam_kerja,golongan_jabatan,tunjangan_jabatan,honor_lembur,gaji_pokok,total_honor from penggajian";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        return rs;
    }
}
