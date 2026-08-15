package array;
import sun.misc.Unsafe;
import java.lang.reflect.Field;

public class staticarray {
    private static Unsafe unsafe;
    private  long memoryaddress;
    private  int capacity;
    private static final int element_size_bytes = 4;
    

    static{
        try{
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
        }catch (Exception e){
            throw new RuntimeException("Could not initialize Unsafe" , e);
        }

    }

    public staticarray(int capacity){
        this.capacity = capacity;
        long totalbytes = (long) capacity * element_size_bytes;
        this.memoryaddress = unsafe.allocateMemory(totalbytes);

        unsafe.setMemory(memoryaddress, totalbytes,(byte) 0);
    }

    public void set(int index , int value){
        checkbounds(index);
        long targetadress = memoryaddress + ((long) index * element_size_bytes);
        unsafe.putInt(targetadress , value);
    }

    private void checkbounds(int index){
        if(index < 0 || index >= capacity ){
            throw new IndexOutOfBoundsException("Index" + index + "Out of bounds");
        }
    }

    public int get(int index){
        checkbounds(index);
        long targetadress = memoryaddress + ((long) index * element_size_bytes);
        return unsafe.getInt(targetadress);
    }

    public void free(){
        unsafe.freeMemory(memoryaddress);
    }

}
