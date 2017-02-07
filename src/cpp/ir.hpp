#include <iostream>
#include <vector>
#include "instruction.hpp"

class ir{
  private:
    vector<instruction> list;
    
  public:
    ir();
    ~ir();
    
    void insert(string cadena_instruccion);
    instruction get(int i);
    
};