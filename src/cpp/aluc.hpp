#include <iostream>

class aluc{
  private:
    int ir_pointer;
    int mr_pointer;
    int input_pointer;
    int output_pointer;
  
  public:
    aluc();
    ~aluc();
    
    //Ejecuta una instrucción y sevuelve un código de aceptación, error o finalización
    int run();
};