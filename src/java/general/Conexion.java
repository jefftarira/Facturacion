package general;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Conexion {
    
    private String server="192.168.0.1";
    private String dbname="udemy";
    private String port="3307";
    private String user="jeff";
    private String passw="reload";    
    private Connection con;
    
    public Conexion(){
        con=null;
    }
    
    public void conectar() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        String url="jdbc:mysql://"+server+":"+port+"/"+dbname;
        con = DriverManager.getConnection(url, user, passw);
        
    };
    
    public void cerrar() throws SQLException{
        if(con!=null)
            con.close();
    };
    
    public PreparedStatement prepareStatement(String sql) throws SQLException{
        return con.prepareStatement(sql);
    }
    
    public void autoCommit(boolean commit) throws SQLException{
        if(con!=null)
            con.setAutoCommit(commit);
    }
    
    public void Commit() throws SQLException{
        if(con!=null)
            con.commit();
    }
    
}
