
package general;
public class clientes {
  private int id;
    private String nombre;
    private String correo;
    private String zip; 
    private String telefono1;
    private String telefono2;
     
    private String pais;
    private String direccion;
    
    public clientes(int id,String nombre,String correo,String telefono1,String telefono2){
      this.setId(id);
      this.setNombre(nombre);
      this.setCorreo(correo);
      this.setTelefono1(telefono1);
      this.setTelefono2(telefono2);
      
    }
    
    public clientes(int id,String nombre,String correo,String zip,String telefono1,String telefono2,String pais,String direccion){
      this.setId(id);
      this.setNombre(nombre);
      this.setCorreo(correo);
      this.setZip(zip);
      this.setTelefono1(telefono1);
      this.setTelefono2(telefono2);
      this.setPais(pais);
      this.setDireccion(direccion);      
    }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getCorreo() {
    return correo;
  }

  public void setCorreo(String correo) {
    this.correo = correo;
  }

  public String getTelefono1() {
    return telefono1;
  }

  public void setTelefono1(String telefono1) {
    this.telefono1 = telefono1;
  }

  public String getTelefono2() {
    return telefono2;
  }

  public void setTelefono2(String telefono2) {
    this.telefono2 = telefono2;
  }

  /**
   * @return the zip
   */
  public String getZip() {
    return zip;
  }

  /**
   * @param zip the zip to set
   */
  public void setZip(String zip) {
    this.zip = zip;
  }

  /**
   * @return the pais
   */
  public String getPais() {
    return pais;
  }

  /**
   * @param pais the pais to set
   */
  public void setPais(String pais) {
    this.pais = pais;
  }

  /**
   * @return the direccion
   */
  public String getDireccion() {
    return direccion;
  }

  /**
   * @param direccion the direccion to set
   */
  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }
  
}
