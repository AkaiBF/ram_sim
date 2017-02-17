import java.util.ArrayList;

public class Mr {
  private ArrayList<Integer> memoryRegister;
  
  public Mr() {
    memoryRegister = new ArrayList<Integer>();
    memoryRegister.add(0);
  }
  
  public void insert(Integer entero) {
    memoryRegister.add(entero);
  }
  
  public void set(int index, Integer entero) {
    memoryRegister.set(index, entero);
  }
  
  public Integer get(int index) {
    return memoryRegister.get(index);
  }
  
  public void addOrder(Integer numero) {
    memoryRegister.set(0, memoryRegister.get(0) + numero);
  }
}