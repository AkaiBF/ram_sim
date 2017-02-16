import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Principal {
  public static void readInstructions(String fileIn, Ir instructionRegister) {
    File input = new File(fileIn);
    try {
      Scanner lector = new Scanner(input);
      int linea = 0;
      while(lector.hasNextLine()) {
        String firstString = new String(lector.nextLine());
        // Eliminamos los comentarios
        if(!firstString.startsWith("#")) {
          String[] tokens = firstString.split("[ ]+");
          // El HALT es el único comando que no requiere nada más
          if(!(tokens[0].equals("HALT")) && !(tokens[0].equals("halt"))) {
            Instruction testInstruction = new Instruction(tokens[0], "=0");
            if(testInstruction.getType() == -2) {
              System.out.println(tokens[0] + " es una etiqueta.");
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
    
    Instruction instruction1 = new Instruction("WRITE", "=45");
    Instruction instruction2 = new Instruction("LOAD", "=45");
    instructionRegister.insert(instruction1);
    System.out.println(instruction2);
    
    System.out.println(instructionRegister.get(0));
    //InputVector pruebaEntrada = new InputVector("Input.in");
    //System.out.println(pruebaEntrada);
    readInstructions("memory.pg", instructionRegister);
    System.out.println(instructionRegister);
  }
}