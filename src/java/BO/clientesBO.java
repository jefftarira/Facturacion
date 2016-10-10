package BO;
import DAO.clientesDAO;
import general.clientes;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.JSONArray;


public class clientesBO {

    private clientesDAO db;

    public clientesBO() throws ClassNotFoundException, SQLException {
        db = new clientesDAO();        
    }

    public String cargarClientes(int pagina) throws SQLException, ClassNotFoundException, JSONException {
        String json = "";

        ArrayList<clientes> aClientes = null;
        clientes p = null;
        
        int desde = 0 ;
        int reg_pagina= 20;
        int pag_siguiente = 0;
        int pag_anterior = 0;
        int totalregistros = 0;
        int totalpaginas = 0 ;
        
        totalregistros = db.totalClientes();
        totalpaginas = Math.round(totalregistros / 20);
        
        if(pagina < 1){
          pagina = 1;
        }
        
        if(pagina>totalpaginas){
          pagina = totalpaginas;          
        }
        
        pagina -=1;
        desde = pagina* reg_pagina;
        
        if( pagina >= totalpaginas-1)
          pag_siguiente = 1;
        else
          pag_siguiente = pagina + 2;
        
        if( pagina <1 )
          pag_anterior = totalpaginas;
        else 
          pag_anterior = pagina;
        
        aClientes = db.getClientes(desde, reg_pagina);
        
        JSONObject obj = new JSONObject();
        obj.put("err", false);
        obj.put("conteo", totalregistros);
        obj.put("pag_actual",pagina+1);
        obj.put("pag_siguiente",pag_siguiente);
        obj.put("pag_anterior",pag_anterior);
        obj.put("total_paginas",totalpaginas);
        
        JSONArray aPag = new JSONArray();
        for (int i=0; i<totalpaginas; i++){
          JSONObject jsonD= new JSONObject();
          jsonD.put("num", i+1);
          aPag.add(jsonD);
        }        
        obj.put("paginas", aPag);
        
        
        JSONArray aC = new JSONArray();                
        for (int i = 0; i < aClientes.size(); i++) {  
          JSONObject jsonD= new JSONObject();
          p = aClientes.get(i);
          jsonD.put("id", p.getId());
          jsonD.put("nombre",p.getNombre());
          jsonD.put("correo",p.getCorreo());
          jsonD.put("telefono1",p.getTelefono1());
          jsonD.put("telefono2",p.getTelefono2());
          aC.add(jsonD);
        }        
        obj.put("clientes", aC);
        
        return obj.toString();
    }
    
    public String cargarCliente(int idCliente) throws SQLException, ClassNotFoundException, JSONException {
        String json = "";        
        clientes p = null;
        
        p = db.getCliente(idCliente);       
        
        JSONObject obj = new JSONObject();
        obj.put("err", false);
        
        JSONObject jsonD= new JSONObject();
        jsonD.put("id", p.getId());
        jsonD.put("nombre",p.getNombre());       
        jsonD.put("correo",p.getCorreo());
        jsonD.put("zip",p.getZip());
        jsonD.put("telefono1",p.getTelefono1());
        jsonD.put("telefono2",p.getTelefono2());
        jsonD.put("pais",p.getPais());
        jsonD.put("direccion",p.getDireccion());
        
        obj.put("cliente", jsonD);
        
        System.out.println(obj);
        
        return obj.toString();
    }
}
