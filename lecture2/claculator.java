public class claculator {
    public static int subtract(int x , int y){
        int z = x -y ;
        return z;
    }
    public static int add(int x , int y){
        int z = x + y;
        return z;
    }
    public static float division(float x , float y){
        if(y < 0){
            return 0;

        }
        else{
            float z = x / y;
            return z;
        }
    } 
    public static float multiply(float x , float y){
        float z = x * y;
        return z;
    }

}
