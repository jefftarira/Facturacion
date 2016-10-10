package DAO;

import general.Conexion;
import general.clientes;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class clientesDAO {
    
    private Conexion con;
    private String sTotal = "SELECT count(*) as cuantos FROM clientes";
    private String sClientes = "select id,nombre,correo,telefono1,telefono2 from clientes limit ?,?";
    private String sCliente = "select id,nombre,correo,zip,telefono1,telefono2,pais,direccion from clientes where id=?";
    
    public clientesDAO() throws ClassNotFoundException, SQLException {
        con = new Conexion();
        con.conectar();
    }   
    
    public int totalClientes() throws SQLException {
        int total=0;        
        PreparedStatement ps;
        ResultSet rs;        
        ps = con.prepareStatement(sTotal);
        rs = ps.executeQuery();        
        rs.next();
        total = rs.getInt("cuantos");
        rs.close();
        return total;
    }
    
    public ArrayList getClientes(int desde, int reg_pagina) throws SQLException {
        ArrayList<clientes> aClientes = new ArrayList<clientes>();
        PreparedStatement ps;
        ps = con.prepareStatement(sClientes);
        ps.setInt(1, desde);
        ps.setInt(2, reg_pagina);
        ResultSet rs;
        rs = ps.executeQuery();
        clientes p;        
        while (rs.next()) {
            p = new clientes(rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("correo"),
                    rs.getString("telefono1"),
                    rs.getString("telefono2"));
            aClientes.add(p);
        }
        rs.close();
        con.cerrar();
        return aClientes;
    }
    
    public clientes getCliente(int idCliente) throws SQLException {
        clientes c = null;
        PreparedStatement ps;
        ps = con.prepareStatement(sCliente);
        ps.setInt(1, idCliente);        
        ResultSet rs;
        rs = ps.executeQuery(); 
        
        
        
        if(rs.next()){
            c = new clientes(rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("correo"),
                    rs.getString("zip"),
                    rs.getString("telefono1"),
                    rs.getString("telefono2"),
                    rs.getString("pais"),
                    rs.getString("direccion"));
        } 
        
        
        rs.close();
        con.cerrar();
        return c;
    }
}
