import java.util.List;
import java.util.ArrayList;
public class ListDemo {

    public static void main(String[] args){
        List<String> x =  new ArrayList<>();
        x.add("a");
        x.add("s");
        String f = x.get(0);
        System.out.println(f);
    }
}
