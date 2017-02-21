/**
 * <H1>Clase Mr</H1>
 * 
 * Esta clase es la encargada del almacenamiento del conjunto ordenado de 
 * datos.
 * 
 * Para más información contacte con el usuario vía e-mail:
 * alu0100881622@ull.edu.es
 * 
 * @author Ernesto Echeverría González
 * @since 20-02-2017
 * @version 1.0.0
 */

import java.util.ArrayList;

public class Mr {
  private ArrayList<Integer> memoryRegister;
  
  public Mr() {
    memoryRegister = new ArrayList<Integer>();
    memoryRegister.add(0);
  }
  
  //Añade un dato al final del ArrayList
  public void insert(Integer entero) {
    memoryRegister.add(entero);
  }
  
  //Coloca un dato en la posición dada
  public void set(int index, Integer entero) {
    while(index >= memoryRegister.size()) {
      memoryRegister.add(0);
    }
    memoryRegister.set(index, entero);
  }
  
  //Devuelve el dato de la posición dada
  public Integer get(int index) {
    while(index >= memoryRegister.size()) {
      memoryRegister.add(0);
    }
    return memoryRegister.get(index);
  }
  
  //Método toString
  public String toString() {
    String cad = new String();
    for(Integer i: memoryRegister) {
      cad = (cad + " " + i);
    }
    return cad;
  }
}