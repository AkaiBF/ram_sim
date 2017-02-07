#include "input_vector.hpp"

input_vector::input_vector(){
    
}
input_vector::~input_vector(){
    
}
    
int input_vector::get_length(){
    return lista.size();
}
    
int input_vector::get(int i){
    return lista[i];
}
int input_vector::set(int i, int data){
    lista[i] = data;
}