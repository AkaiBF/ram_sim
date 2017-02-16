import java.util.ArrayList;

public class Mr {
  private ArrayList<Integer> memoryRegister;
  
  public Mr() {
    memoryRegister = new ArrayList<Integer>();
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
}