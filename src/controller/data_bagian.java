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
public class data_bagian {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    private String sql;
    public String id_bagian;
    public String nama_bagian;
    public String penempatan;
    
    public void simpan()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "INSERT INTO bagian(id_bagian,nama_bagian,penempatan)VALUE(?,?,?)";
        pst = conn.prepareStatement(sql);
        pst.setString(1,id_bagian);
        pst.setString(2,nama_bagian);
        pst.setString(3,penempatan);
        pst.execute();
        pst.close();
    }
    
    public void edit()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "UPDATE bagian set nama_bagian=?, penempatan=? where id_bagian=?";
        pst = conn.prepareStatement(sql);
        pst.setString(1,nama_bagian);
        pst.setString(2,penempatan);
        pst.setString(3,id_bagian);
        pst.execute();
        pst.close();
    }
    
    public void hapus() throws SQLException{
        conn=Koneksi.getKoneksi();
        String sql="DELETE from bagian where id_bagian=?";
        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1, id_bagian);
            pst.execute();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public ResultSet UpdatebagianT()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "select id_bagian,nama_bagian,penempatan from bagian";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        return rs;
    }
}
