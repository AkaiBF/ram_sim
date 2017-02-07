#include "aluc.hpp"
aluc::aluc(){
  ir_pointer = 0;
  mr_pointer = 0;
  input_pointer = 0;
  output_pointer = 0;
}
aluc::~aluc(){
  ir_pointer = 0;
  mr_pointer = 0;
  input_pointer = 0;
  output_pointer = 0;
}
 
//Ejecuta una instrucción y sevuelve un código de aceptación, error o finalización
int run(){}