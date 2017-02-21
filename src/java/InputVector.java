/**
 * <H1>Clase InputVector</H1>
 * 
 * Esta clase almacena en un ArrayList los datos recogidos en el fichero de entrada.
 * 
 * Para más información contacte con el usuario vía e-mail:
 * alu0100881622@ull.edu.es
 * 
 * @author Ernesto Echeverría González
 * @since 20-02-2017
 * @version 1.0.0
 */

import java.io.File;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.util.Scanner;

class InputVector {
  private ArrayList<Integer> entrada;
  
  public InputVector() {
    entrada = new ArrayList<Integer>();
  }
  
  //Inicialización con carga del fichero
  public InputVector(String fichero) {
    entrada = new ArrayList<Integer>();
    File input = new File(fichero);
    try {
      Scanner lector = new Scanner(input);
      while(lector.hasNextLine()) {
        Integer entero = new Integer(0);
        entero = lector.nextInt();
        entrada.add(entero);
      }
      
    }
    catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }
  
  // Método toString
  public String toString() {
    String salida = new String();
    for(int i = 0; i < entrada.size(); i++) {
      salida = salida + (entrada.get(i) + " ");
    }
    return salida;
  }
  
  //Getter
  public Integer get(int index) {
    return entrada.get(index);
  }
}