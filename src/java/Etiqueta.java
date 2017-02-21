/**
 * <H1>Clase Etiqueta</H1>
 * 
 * Esta clase es la encargada del almacenamiento de todas las etiquetas registradas
 * a lo largo del fichero programa. Se rellena durante la lectura en la clase Principal
 * y se utiliza para saber a qué dirección señala cada etiqueta a la par que facilita
 * su almacenamiento en la clase Instrucción
 * 
 * Para más información contacte con el usuario vía e-mail:
 * alu0100881622@ull.edu.es
 * 
 * @author Ernesto Echeverría González
 * @since 20-02-2017
 * @version 1.0.0
 */

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
  
  /*Esta función devuelve true si la cadena nombre de la etiqueta es igual
  * al parámetro
  */
  public boolean nameIs(String name) {
    return (name == nombre);
  }
  
  //Getters
  public int getLine() {
    return line;
  }
  
  public String getNombre() {
    return nombre;
  }
  
  public int getCode() {
    return code;
  }
  
  //Método toString
  public String toString() {
    String cadena = new String(nombre + " " + code + " " + line);
    return cadena;
  }
  
  //Setter
  public void setLine (int line){
    this.line = line;
  }
}