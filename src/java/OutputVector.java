/**
 * <H1>Clase OutputVector</H1>
 * 
 * Esta clase es la encargada de almacenar la cinta de salida.
 * 
 * Para más información contacte con el usuario vía e-mail:
 * alu0100881622@ull.edu.es
 * 
 * @author Ernesto Echeverría González
 * @since 20-02-2017
 * @version 1.0.0
 */

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.io.IOException;
import java.io.PrintWriter;


class OutputVector {
  private ArrayList<Integer> salida;
  
  public OutputVector() {
    salida = new ArrayList<Integer>();
  }
  
  /*Inicializa el ArrayList y crea el fichero de salida en caso de no existir
  * o borra su contenido en caso de que si existiera.
  */
  public OutputVector(String outputFile) {
    salida = new ArrayList<Integer>();
    try {
      FileOutputStream out = new FileOutputStream(outputFile);
      out.close();
    }
    catch (IOException e) {
      System.out.println("Ha ocurrido un error al crear el fichero de salida");
    }
  }
  
  //Coloca un elemento en la posición índice
  public void set(int index, Integer elemento) {
    while(index >= salida.size())
    salida.add(0);
    salida.set(index, elemento);
  }
  
  // Hace un vaciado de su contenido al fichero en formato UTF-8
  public void print(String outputFile) {
    String outPrint = new String();
    for(int i = 0; i < salida.size(); i++) {
      outPrint = outPrint + (salida.get(i)) + " ";
    }
    try{
      PrintWriter writer = new PrintWriter(outputFile, "UTF-8");
      writer.println(outPrint);
      writer.close();
    } catch (IOException e) {
      System.out.println("Error en la escritura en fichero");
    }
  }
  
  // Método toString
  public String toString() {
    String cadena = new String();
    for(int i = 0; i < salida.size(); i++) {
      cadena = cadena + (salida.get(i) + " ");
    }
    return cadena;
  }
}