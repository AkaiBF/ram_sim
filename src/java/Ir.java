/**
 * <H1>Clase Ir</H1>
 * 
 * Esta clase es la encargada del almacenamiento del conjunto ordenado de 
 * instrucciones.
 * 
 * Para más información contacte con el usuario vía e-mail:
 * alu0100881622@ull.edu.es
 * 
 * @author Ernesto Echeverría González
 * @since 20-02-2017
 * @version 1.0.0
 */

import java.util.ArrayList;

public class Ir {
  private ArrayList<Instruction> listaInstrucciones;
  
  public Ir() {
    listaInstrucciones = new ArrayList<Instruction>();
  }
  
  //Coloca una instrucción en la posición dada
  public void set(int index, Instruction instruccion) {
    listaInstrucciones.set(index, instruccion);
  }
  
  //Recibe una instrucción de una posición dada
  public Instruction get(int index) {
    return listaInstrucciones.get(index);
  }
  
  //Añade una instrucción al final del ArrayList
  public void add(Instruction instruccion) {
    listaInstrucciones.add(instruccion);
  }
  
  //Devuelve el tamaño del ArrayList
  public int size() {
    return listaInstrucciones.size();
  }
  
  //Método toString
  public String toString() {
    String salida = new String();
    for(int i = 0; i < listaInstrucciones.size(); i++) {
      salida = salida + listaInstrucciones.get(i) + "\n";
    }
    return salida;
  }
}