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
public class Instruction {
  private int type;
  private int addrType;
  private int addr;
  
  
  //Prohibir READ 0 y WRITE 0;
  // Creamos la instrucción con dos Strings: el nombre del comando y su operador
  public Instruction(String code, String operator) {
    
    addrType = 0;
    if(operator.startsWith("=")) addrType = 1;
    if(operator.startsWith("*")) addrType = 2;
    
    if(addrType != 0) operator = operator.substring(1);
    
    addr = Integer.parseInt(operator);
    //Asignamos un número por instrucción
    switch(code) {
      case "LOAD":
      case "load":
        type = 0;
        break;
      case "STORE":
      case "store":
        type = 1;
        break;
      case "ADD":
      case "add":
        type = 2;
        break;
      case "SUB":
      case "sub":
        type = 3;
        break;
      case "MUL":
      case "mul":
        type = 4;
        break;
      case "DIV":
      case "div":
        type = 5;
        break;
      case "READ":
      case "read":
        type = 6;
        break;
      case "WRITE":
      case "write":
        type = 7;
        break;
      case "JUMP":
      case "jump":
        type = 8;
        break;
      case "JZERO":
      case "jzero":
        type = 9;
        break;
      case "JGTZ":
      case "jgtz":
        type = 10;
        break;
      case "HALT":
      case "halt":
        type = 11;
        break;
      default:
        type = -2;
    }
    //Limpiamos opciones no válidas
    if((type == 6 || type == 1) && addrType == 1){
      type = -1;
    }
    

  }
  
  //Getters
  public int getType() {
    return type;
  }
  
  public int getAddrType() {
    return addrType;
  }
  
  public int getAddr() {
    return addr;
  }
  
  //Setters
  public void setType(int type) {
    this.type = type;
  }
  
  public void setAddrType(int addrType) {
    this.addrType = addrType;
  }
  
  public void setAddr(int addr) {
    this.addr = addr;
  }
  
  // Método toString
  public String toString() {
    String cad = new String();
    if(type == -1) {
      cad = "Instrucción inválida.";
    }else{
      switch(type) {
        case 0: 
          cad = cad + "LOAD ";
          break;
        case 1:
          cad = cad + "STORE ";
          break;
        case 2:
          cad = cad + "ADD ";
          break;
        case 3:
          cad = cad + "SUB ";
          break;
        case 4:
          cad = cad + "MUL ";
          break;
        case 5:
          cad = cad + "DIV ";
          break;
        case 6:
          cad = cad + "READ ";
          break;
        case 7:
          cad = cad + "WRITE ";
          break;
        case 8:
          cad = cad + "JUMP ";
          break;
        case 9:
          cad = cad + "JZERO ";
          break;
        case 10:
          cad = cad + "JGTZ ";
          break;
        case 11:
          cad = cad + "HALT";
          break;
        default:
      }
      if(type != 11){
        switch(addrType) {
          case 1:
            cad = cad + "=";
            break;
          case 2:
            cad = cad + "*";
            break;
        }
      cad = cad + addr;
      }
    }
    return cad;
  }
  
  
}