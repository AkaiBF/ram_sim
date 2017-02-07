#include <iostream>
using namespace std;

class instruction{
  
  friend ostream &operator<<(std::ostream &, const instruction &);
  private:
    int type;
    int addr_type;
    int addr;
    
  public:
    instruction();
    instruction(int, int, int);
    ~instruction();
    
    int get_type() const;
    int get_addrtype() const;
    int get_addr() const;
};