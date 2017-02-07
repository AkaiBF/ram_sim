#include "instruction.hpp"

instruction::instruction(){
  type = -1;
  addr_type = 0;
  addr = 0;
}
instruction::instruction(int tipo, int tipodir, int dir){
  type = tipo;
  addr_type = tipodir;
  addr = dir;
}
instruction::~instruction(){
  type = -1;
  addr_type = 0;
  addr = 0;
}

int instruction::get_type() const{
  return type;
}

int instruction::get_addrtype() const{
  return addr_type;
}

int instruction::get_addr() const{
  return addr;
}
    
std::ostream &operator<<(ostream &output, const instruction &instruccion){
  if(instruccion.get_type() == -1)
    output << "INVALID";
  else if(instruccion.get_type() == 12){
    output << "HALT";
  }else{
    switch(instruccion.get_type()) {
      case 0: 
        output << "LOAD ";
        break;
      case 1:
        output << "STORE ";
        break;
      case 2:
        output << "ADD ";
        break;
      case 3:
        output << "SUB ";
        break;
      case 4:
        output << "MUL ";
        break;
      case 5:
        output << "DIV ";
        break;
      case 6:
        output << "READ ";
        break;
      case 7:
        output << "WRITE ";
        break;
      case 8:
        output << "JUMP ";
        break;
      case 9:
        output << "JZERO ";
        break;
      case 10:
        output << "JGTZ ";
        break;
      case 11:
        output << "HALT";
        break;
    }
    switch(instruccion.get_addrtype()){
      case 0:
        output << "=";
        break;
      case 1:
        break;
      case 2:
        output << "*";
        break;
    }
    output << instruccion.get_addr();
  }
  return output;
}