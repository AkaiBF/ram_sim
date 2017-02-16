import java.util.ArrayList;

public class Ir {
  private ArrayList<Instruction> listaInstrucciones;
  
  public Ir() {
    listaInstrucciones = new ArrayList<Instruction>();
  }
    
  public void insert(Instruction instruccion) {
    listaInstrucciones.add(instruccion);
  }
  
  public void set(int index, Instruction instruccion) {
    listaInstrucciones.set(index, instruccion);
  }
  
  public Instruction get(int index) {
    return listaInstrucciones.get(index);
  }
  
  public void add(Instruction instruccion) {
    listaInstrucciones.add(instruccion);
  }
  
  public String toString() {
    String salida = new String();
    for(int i = 0; i < listaInstrucciones.size(); i++) {
      salida = salida + "\n" + listaInstrucciones.get(i);
    }
    return salida;
  }
}