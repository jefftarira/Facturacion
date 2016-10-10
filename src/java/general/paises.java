
package general;
public class paises {
    private int id;
    private String iso;
    private String nombre;
    
    public paises(int id,String iso,String nombre){
      this.setId(id);
      this.setIso(iso);
      this.setNombre(nombre);
      
    }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getIso() {
    return iso;
  }

  public void setIso(String iso) {
    this.iso = iso;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
    
}
