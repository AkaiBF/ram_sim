#include "output_vector.hpp"

output_vector::output_vector(){
    
}
output_vector::~output_vector(){
    
}
    
int output_vector::get_length(){
    return lista.size();
}
    
int output_vector::get(int i){
    return lista[i];
}
int output_vector::set(int i, int data){
    lista[i] = data;
}