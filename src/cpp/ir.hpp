#include <iostream>
#include <vector>
#include <stdio.h>
#include <cstring>
#include "instruction.hpp"

class ir{
  private:
    vector<instruction> list;
    
  public:
    ir();
    ~ir();
    
    void insert(string cadena_instruccion);
    instruction get(int i);
    
    void load_file(string nombre_fich);
};