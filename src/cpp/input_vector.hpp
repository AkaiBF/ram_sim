#include <iostream>
#include <vector>

class input_vector {
  private:
    vector<int> lista;
    
  public:
    input_vector();
    ~input_vector();
    
    int get_length();
    
    int get(int i);
    int set(int i, int data);
};