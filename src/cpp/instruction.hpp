#include <iostream>

class instruction{
  private:
    int type;
    int addr_type;
    int addr;
    
  public:
    instruction();
    ~instruction();
    
    void print();
};