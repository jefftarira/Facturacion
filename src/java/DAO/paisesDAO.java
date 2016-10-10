package DAO;

import general.Conexion;
import general.paises;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class paisesDAO {
    
    private Conexion con;
    private String sTotal = "SELECT count(*) as cuantos FROM paises";
    private String sPaises = "select id,iso,nombre from paises limit ?,20";
    
    public paisesDAO() throws ClassNotFoundException, SQLException {
        con = new Conexion();
        con.conectar();
    }   
    
    public int totalPaises() throws SQLException {
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
    
    public ArrayList getPaises(int page) throws SQLException {
        ArrayList<paises> aPaises = new ArrayList<paises>();
        PreparedStatement ps;
        ps = con.prepareStatement(sPaises);
        ps.setInt(1, page);
        ResultSet rs;
        rs = ps.executeQuery();
        paises p;        
        while (rs.next()) {
            p = new paises(rs.getInt("id"),
                    rs.getString("iso"),
                    rs.getString("nombre"));
            aPaises.add(p);
        }
        rs.close();
        con.cerrar();
        return aPaises;
    }
}
