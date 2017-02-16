import java.io.File;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.util.Scanner;

class InputVector {
  private ArrayList<Integer> entrada;
  
  public InputVector() {
    entrada = new ArrayList<Integer>();
  }
  
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
  
  public String toString() {
    String salida = new String();
    for(int i = 0; i < entrada.size(); i++) {
      salida = salida + (entrada.get(i) + " ");
    }
    return salida;
  }
}