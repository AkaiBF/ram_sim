#include "ir.hpp"

ir::ir(){}
ir::~ir(){
  while(list.size() > 0){
    list.pop_back();
  }
}
    
void ir::insert(string cadena_instruccion){
  instruction instruccion_aux(cadena_instruccion);
  list.push_back(instruccion_aux);
}
instruction ir::get(int i){
  instruction error(-1, 0, 0);
  if(i >= list.size()) return error;
  else return list[i];
}
    
void ir::load_file(string nombre_fich){
  FILE * filepointer;
  filepointer = fopen(nombre_fich, "r");
  if(filepointer == NULL) perror ("Error abriendo fichero");
  else{
    while(!feof(filepointer)){
      
    }
  }
}
