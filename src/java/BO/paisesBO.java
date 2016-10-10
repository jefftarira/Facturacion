package BO;
import DAO.paisesDAO;
import general.paises;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.JSONArray;


public class paisesBO {

    private paisesDAO db;

    public paisesBO() throws ClassNotFoundException, SQLException {
        db = new paisesDAO();        
    }

    public String cargarPaises(int pagina) throws SQLException, ClassNotFoundException, JSONException {
        String json = "";

        ArrayList<paises> aPaises = null;
        paises p = null;
        int totalregistros = db.totalPaises();
        int totalpaginas = Math.round(totalregistros / 20);
        
        if(pagina < 1){
          pagina = 1;
        }
        
        if(pagina>totalpaginas){
          pagina = totalpaginas;          
        }
        
        pagina -=1;
        pagina = 20 * pagina;
        
        aPaises = db.getPaises(pagina);
        
        JSONObject obj = new JSONObject();
        obj.put("err", false);
        obj.put("total", totalregistros);
        obj.put("totalpaginas",totalpaginas);
        
        JSONArray aP = new JSONArray();        
        
        for (int i = 0; i < aPaises.size(); i++) {  
          JSONObject jsonD= new JSONObject();
          p = aPaises.get(i);
          jsonD.put("id", p.getId());
          jsonD.put("iso",p.getIso());
          jsonD.put("nombre",p.getNombre());
          aP.add(jsonD);
        }
        
        obj.put("data", aP);
        
        System.out.print(obj);
                
        return obj.toString();
    }
}
