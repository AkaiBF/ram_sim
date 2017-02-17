import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Principal {
  public static void readInstructions(String fileIn, Ir instructionRegister, ArrayList<Etiqueta> setEtiquetas) {
    File input = new File(fileIn);
    try {
      Scanner lector = new Scanner(input);
      int linea = 0;
      int etiquetaContador = 0;
      while(lector.hasNextLine()) {
        String firstString = new String(lector.nextLine());
        // Eliminamos los comentarios
        if(!firstString.startsWith("#")) {
          String[] tokens = firstString.split("[ ]+");
          // El HALT es el único comando que no requiere nada más
          if(!(tokens[0].equals("HALT")) && !(tokens[0].equals("halt"))) {
            Instruction testInstruction = new Instruction(tokens[0], "=0");
            if(testInstruction.getType() == -2) {
              Etiqueta newEtiqueta = new Etiqueta(tokens[0], etiquetaContador, linea);
              setEtiquetas.add(newEtiqueta);
              etiquetaContador++;
            } 
            else {
              if(tokens[0].equals("JUMP") || tokens[0].equals("jump") ||tokens[0].equals("JZERO")
              || tokens[0].equals("jzero") || tokens[0].equals("JGTZ") || tokens[0].equals("jgtz")) {
                int codeEtiqueta = 0;
                for(int i = 0; i < setEtiquetas.size(); i++) {
                  if(setEtiquetas.get(i).getNombre().equals(tokens[1]))
                  codeEtiqueta = setEtiquetas.get(i).getCode();
                }
                Instruction instruccionDeSalto = new Instruction(tokens[0], String.valueOf(codeEtiqueta));
                instructionRegister.add(instruccionDeSalto);
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
    }catch (FileNotFoundException e) {
      System.out.println("ERROR: No se detecta entrada de instrucciones");
    }
  }
  
  public static void main(String[] args) {
    Ir instructionRegister = new Ir();
    ArrayList<Etiqueta> setEtiquetas = new ArrayList<Etiqueta>();
    
    Instruction instruction1 = new Instruction("WRITE", "=45");
    Instruction instruction2 = new Instruction("LOAD", "=45");
    instructionRegister.insert(instruction1);
   
   
    //InputVector pruebaEntrada = new InputVector("Input.in");
    //System.out.println(pruebaEntrada);
    readInstructions("memory.pg", instructionRegister, setEtiquetas);
    System.out.println(instructionRegister);
  }
}