public class Etiqueta {
  private String nombre;
  private int code;
  private int line;
  
  public Etiqueta() {
    nombre = new String();
    code = 0;
    line = 0;
  }
  
  public Etiqueta(String nombre, int code, int line) {
    this.nombre = nombre;
    this.code = code;
    this.line = line;
  }
  
  public boolean nameIs(String name) {
    return (name == nombre);
  }
  
  public int getLine() {
    return line;
  }
}