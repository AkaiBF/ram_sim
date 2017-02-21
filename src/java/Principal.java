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
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;


public class Principal {
  
  /*
  *Este método es el encargado de cargar las instrucciones y etiquetas leídas en
  *el fichero que hace las veces de programa.
  */
  public static void readInstructions(String fileIn, Ir instructionRegister, ArrayList<Etiqueta> setEtiquetas) {
    File input = new File(fileIn);
    try {
      Scanner lector = new Scanner(input);
      int linea = 0;
      int etiquetaContador = 0;
      int codeEtiqueta = 0;
      while(lector.hasNextLine()) {
        String firstString = new String(lector.nextLine());
        firstString = firstString.trim();
        // Eliminamos los comentarios
        if(!firstString.startsWith("#")) {
          //Tokenizamos
          String[] tokens = firstString.split("[ ]+");
          // Eliminamos líneas vacías
          if(tokens.length > 0  && !tokens[0].equals("")){
            
            
            // El HALT es el único comando que no requiere nada más
            if(!(tokens[0].equals("HALT")) && !(tokens[0].equals("halt"))) {
              Instruction testInstruction = new Instruction(tokens[0], "=0");
              // Si lee etiqueta
              if(testInstruction.getType() == -2) {
                tokens[0] = tokens[0].substring(0, tokens[0].length() - 1);
                boolean savedTag = false;
                for(Etiqueta i: setEtiquetas) {
                  if(i.getNombre().equals(tokens[0])){
                    i.setLine(linea);
                    savedTag = true;
                  }
                }
                if(!savedTag) {
                  Etiqueta newEtiqueta = new Etiqueta(tokens[0], etiquetaContador, linea);
                  setEtiquetas.add(newEtiqueta);
                  etiquetaContador++;
                }
                if(tokens[1].equals("JUMP") || tokens[1].equals("jump") ||tokens[1].equals("JZERO")
                || tokens[1].equals("jzero") || tokens[1].equals("JGTZ") || tokens[1].equals("jgtz")) {
                  
                  savedTag = false;
                  for(int i = 0; i < setEtiquetas.size(); i++) {
                    if(setEtiquetas.get(i).getNombre().equals(tokens[2])) {
                      codeEtiqueta = setEtiquetas.get(i).getCode();
                      savedTag = true;
                    }
                  }
                  if(savedTag){
                    Instruction instruccionDeSalto = new Instruction(tokens[1], String.valueOf(codeEtiqueta));
                    instructionRegister.add(instruccionDeSalto);
                  }else {
                    Etiqueta newEtiqueta = new Etiqueta(tokens[2], etiquetaContador, -1);
                    setEtiquetas.add(newEtiqueta);
                    etiquetaContador++;
                  }
                }
                else {
                  if(tokens[1].equals("HALT") || tokens[1].equals("halt")){
                    Instruction halt = new Instruction("HALT", "0");
                    instructionRegister.add(halt);
                  }else{
                    Instruction validInstructionTest = new Instruction(tokens[1], tokens[2]);
                    if(validInstructionTest.getType() == -1) {
                      System.out.println("ERROR: Instrucción inválida en la línea " + linea);
                    }
                    else{
                      instructionRegister.add(validInstructionTest);
                    }
                  }
                }  
              } 
              else {
                if(tokens[0].equals("JUMP") || tokens[0].equals("jump") ||tokens[0].equals("JZERO")
                || tokens[0].equals("jzero") || tokens[0].equals("JGTZ") || tokens[0].equals("jgtz")) {
                  
                  boolean savedTag = false;
                  for(int i = 0; i < setEtiquetas.size(); i++) {
                    if(setEtiquetas.get(i).getNombre().equals(tokens[1])){
                      codeEtiqueta = setEtiquetas.get(i).getCode();
                      savedTag = true;
                    }
                  }
                  if(savedTag){
                    Instruction instruccionDeSalto = new Instruction(tokens[0], String.valueOf(codeEtiqueta));
                    instructionRegister.add(instruccionDeSalto);
                  }else {
                    Etiqueta newEtiqueta = new Etiqueta(tokens[1], etiquetaContador, -1);
                    setEtiquetas.add(newEtiqueta);
                    
                    Instruction instruccionDeSalto = new Instruction(tokens[0], String.valueOf(etiquetaContador));
                    instructionRegister.add(instruccionDeSalto);
                    etiquetaContador++;
                  }
                }
                else {
                  Instruction validInstructionTest = new Instruction(tokens[0], tokens[1]);
                  if(validInstructionTest.getType() == -1) {
                    System.out.println("ERROR: Instrucción inválida en la línea " + linea);
                  }
                  else{
                    instructionRegister.add(validInstructionTest);
                  }
                }  
              }
            linea++;
            }
            else {
              Instruction halted = new Instruction("HALT", "0");
              instructionRegister.add(halted);
            }
          }
        }
      }
    }catch (FileNotFoundException e) {
      System.out.println("ERROR: No se detecta entrada de instrucciones");
    }
  }
  
  public static void main(String[] args) {
    
    if(args.length == 3) {
      Aluc unidadAritLogic = new Aluc();
      Ir instructionRegister = new Ir();
      ArrayList<Etiqueta> setEtiquetas = new ArrayList<Etiqueta>();
      Mr memoryRegister = new Mr();
    
    

      InputVector vectorEntrada = new InputVector(args[1]);
      OutputVector vectorSalida = new OutputVector(args[2]);
    
    
      readInstructions(args[0], instructionRegister, setEtiquetas);
      

    
      Instruction actualInstruction = instructionRegister.get(0);
      int j = 0;
      while(j < instructionRegister.size() && actualInstruction.getType() != 11) {
        j = unidadAritLogic.procesa(actualInstruction, memoryRegister, vectorEntrada, vectorSalida, setEtiquetas);
        actualInstruction = instructionRegister.get(j);
      }
      
      vectorSalida.print(args[2]);
    }
    else if(args.length == 4 && args[3].equals("debug")) {
      Aluc unidadAritLogic = new Aluc();
      Ir instructionRegister = new Ir();
      ArrayList<Etiqueta> setEtiquetas = new ArrayList<Etiqueta>();
      Mr memoryRegister = new Mr();
    
    

      InputVector vectorEntrada = new InputVector(args[1]);
      OutputVector vectorSalida = new OutputVector(args[2]);
    
    
      readInstructions(args[0], instructionRegister, setEtiquetas);
      

    
      Instruction actualInstruction = instructionRegister.get(0);
      int j = 0;
      int k = 0;
      while(j < instructionRegister.size() && actualInstruction.getType() != 11) {
        k++;
        j = unidadAritLogic.procesa(actualInstruction, memoryRegister, vectorEntrada, vectorSalida, setEtiquetas);
        actualInstruction = instructionRegister.get(j);
        System.out.println("Registro de instrucciones: " + instructionRegister);
        System.out.println("Registro de memoria: " + memoryRegister);
        System.out.println("Cinta de entrada: " + vectorEntrada);
        System.out.println("Cinta de salida: " + vectorSalida);
        System.out.println(k + " instrucciones ejecutadas.");
      }
      
      vectorSalida.print(args[2]);
    }
    else {
      System.out.println("Error en la ejecución. El formato es:");
      System.out.println("$ java Principal <programa> <fichero_entrada> <fichero_salida> [debug]");
    }
  } 
}