package worksheet2;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class club {
    public Map<student , country> countrymap;

    public class student{}
    public class country{}

    public static Map<country , Integer> countbycountry(List<club> clubs){

        Map<country , Integer> counts = new HashMap<>();
        List<student> names = new ArrayList<>();

        for(club oneclub : clubs){
            for(student s : oneclub.countrymap.keySet()){
                country c = oneclub.countrymap.get(s);
                if(!names.contains(s)){
                    if(!counts.containsKey(c)){
                        counts.put(c , 1);
                    }
                    else{
                        counts.put(c , counts.get(c)+1);
                    }
                }
                names.add(s);
                
            }
        }
        return counts;


    }
}
