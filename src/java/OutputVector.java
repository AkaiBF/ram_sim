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
  
  public OutputVector(String outputFile) {
    salida = new ArrayList<Integer>();
    try {
      FileOutputStream out = new FileOutputStream(outputFile);
      out.close();
    }
    catch (IOException e) {
      System.out.println("Ha ocurrido un error");
    }
  }
  
  public void set(int index, Integer elemento) {
    salida.set(index, elemento);
  }
  
  public void print(String outputFile) {
    String outPrint = new String();
    for(int i = 0; i < salida.size(); i++) {
      outPrint = outPrint + (salida.get(i));
    }
    try{
      PrintWriter writer = new PrintWriter(outputFile, "UTF-8");
      writer.println(outPrint);
      writer.close();
    } catch (IOException e) {
      System.out.println("Error en la escritura en fichero");
    }
  }
}