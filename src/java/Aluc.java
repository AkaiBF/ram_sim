/**
 * <H1>Clase Aluc</H1>
 * 
 * Esta clase es la encargada del correcto funcionamiento de cada instrucción,
 * así como la asignación de la siguiente ordena a ejecutar. Es teóricamente
 * una mezcla entre una ALU (unidad aritmético lógica) y una UC (unidad de control).
 * 
 * Para más información contacte con el usuario vía e-mail:
 * alu0100881622@ull.edu.es
 * 
 * @author Ernesto Echeverría González
 * @since 20-02-2017
 * @version 1.0.0
 */

import java.util.ArrayList;

class Aluc {
  private int irPointer;
  private int mrPointer;
  private int inputPointer;
  private int outputPointer;
    
  public Aluc() {
    irPointer = 0;
    mrPointer = 0;
    inputPointer = 0;
    outputPointer = 0;
  }
  
  /*
  * A continuación se describe cada una de las instrucciones del lenguaje definido  *
  */
  public void addOrder(Integer entero, Mr memoryRegister, int direccionamiento) {
    switch(direccionamiento) {
      case 0:
        memoryRegister.set(0, memoryRegister.get(0) + memoryRegister.get(entero));
      break;
      case 1:
        memoryRegister.set(0, memoryRegister.get(0) + entero);
      break;
      case 2:
        memoryRegister.set(0, memoryRegister.get(0) + memoryRegister.get(memoryRegister.get(entero)));
      break;
    }
    
  }
  
  public void subOrder(Integer entero, Mr memoryRegister, int direccionamiento) {
    switch(direccionamiento) {
      case 0:
        memoryRegister.set(0, memoryRegister.get(0) - memoryRegister.get(entero));
      break;
      case 1:
        memoryRegister.set(0, memoryRegister.get(0) - entero);
      break;
      case 2:
        memoryRegister.set(0, memoryRegister.get(0) - memoryRegister.get(memoryRegister.get(entero)));
      break;
    }
    
  }
  
  public void mulOrder(Integer entero, Mr memoryRegister, int direccionamiento) {
    switch(direccionamiento) {
      case 0:
        memoryRegister.set(0, memoryRegister.get(0) * memoryRegister.get(entero));
      break;
      case 1:
        memoryRegister.set(0, memoryRegister.get(0) * entero);
      break;
      case 2:
        memoryRegister.set(0, memoryRegister.get(0) * memoryRegister.get(memoryRegister.get(entero)));
      break;
    }
    
  }
  
  public void divOrder(Integer entero, Mr memoryRegister, int direccionamiento) {
    switch(direccionamiento) {
      case 0:
        memoryRegister.set(0, memoryRegister.get(0) / memoryRegister.get(entero));
      break;
      case 1:
        memoryRegister.set(0, memoryRegister.get(0) / entero);
      break;
      case 2:
        memoryRegister.set(0, memoryRegister.get(0) / memoryRegister.get(memoryRegister.get(entero)));
      break;
    }
    
  }
  
  public void loadOrder(Integer entero, Mr memoryRegister, int direccionamiento) {
    switch(direccionamiento) {
      case 0:
        memoryRegister.set(0, memoryRegister.get(entero));
      break;
      case 1:
        memoryRegister.set(0, entero);
      break;
      case 2:
        memoryRegister.set(0, memoryRegister.get(memoryRegister.get(entero)));
      break;
    }
  }
  
  public void storeOrder(Integer entero, Mr memoryRegister, int direccionamiento) {
    switch(direccionamiento){
      case 0: 
        memoryRegister.set(entero, memoryRegister.get(0));
      break;
      case 2:
        memoryRegister.set(memoryRegister.get(entero), memoryRegister.get(0));
      break;
    }
  }
  
  public void readOrder(InputVector vectorEntrada, int entero, int direccionamiento, Mr memoryRegister) {
    switch(direccionamiento){
      case 0:
        memoryRegister.set(entero, vectorEntrada.get(inputPointer));
      break;
      case 2:
        memoryRegister.set(memoryRegister.get(entero), vectorEntrada.get(inputPointer));
      break;
    }
    inputPointer++;
  }
  
  public void writeOrder(OutputVector vectorSalida, int entero, int direccionamiento, Mr memoryRegister) {
    switch(direccionamiento) {
      case 0:
        vectorSalida.set(outputPointer, memoryRegister.get(entero));
      break;
      case 2:
        vectorSalida.set(outputPointer, memoryRegister.get(memoryRegister.get(entero)));
      break;
    }
    outputPointer++;
  }
  
  public void jumpOrder(ArrayList<Etiqueta> setEtiqueta, int codeEtiqueta) {
    for(Etiqueta i: setEtiqueta) {
      if(i.getCode() == codeEtiqueta)
      irPointer = i.getLine();
    }
  }
  
  public void jzeroOrder(ArrayList<Etiqueta> setEtiqueta, int codeEtiqueta, Mr memoryRegister) {
    if(memoryRegister.get(0).equals(0)) {
      for(Etiqueta i: setEtiqueta) {
        if(i.getCode() == codeEtiqueta)
        irPointer = i.getLine();
      }
    } else {
      irPointer++;
    }
  }
  
  public void jgtzOrder(ArrayList<Etiqueta> setEtiqueta, int codeEtiqueta, Mr memoryRegister) {
    if(memoryRegister.get(0) > 0) {
      for(Etiqueta i: setEtiqueta) {
        if(i.getCode() == codeEtiqueta)
        irPointer = i.getLine();
      }
    }else {
      irPointer++;
    }
  }
  
  /*
  * Esta función se encarga de recibir la instrucción a ejecutar, de ejecutarla
  * y de devolver la dirección de "memoria" de la siguiente instrucción a ejecutar.
  */
  public int procesa(Instruction instruccion, Mr memoryRegister, InputVector vectorEntrada, OutputVector vectorSalida, ArrayList<Etiqueta> setEtiqueta) {
    switch(instruccion.getType()) {
      case 0:
        loadOrder(instruccion.getAddr(), memoryRegister, instruccion.getAddrType());
        irPointer++;
      break;
      case 1:
        storeOrder(instruccion.getAddr(), memoryRegister, instruccion.getAddrType());
        irPointer++;
      break;
      case 2:
        addOrder(instruccion.getAddr(), memoryRegister, instruccion.getAddrType());
        irPointer++;
      break;
      case 3:
        subOrder(instruccion.getAddr(), memoryRegister, instruccion.getAddrType());
        irPointer++;
      break;
      case 4:
        mulOrder(instruccion.getAddr(), memoryRegister, instruccion.getAddrType());
        irPointer++;
      break;
      case 5:
        divOrder(instruccion.getAddr(), memoryRegister, instruccion.getAddrType());
        irPointer++;
      break;
      case 6:
        readOrder(vectorEntrada, instruccion.getAddr(), instruccion.getAddrType(), memoryRegister);
        irPointer++;
      break;
      case 7:
        writeOrder(vectorSalida, instruccion.getAddr(), instruccion.getAddrType(), memoryRegister);
        irPointer++;
      break;
      case 8:
        jumpOrder(setEtiqueta, instruccion.getAddr());
      break;
      case 9:
        jzeroOrder(setEtiqueta, instruccion.getAddr(), memoryRegister);
      break;
      case 10:
        jgtzOrder(setEtiqueta, instruccion.getAddr(), memoryRegister);
      break;
    }
    return irPointer;
  }
}