public class Arraydemo {

    public static void main(String[] args){
        int[] x = new int[3];
        x[0] = 3;
        x[1] = 5;
        x[2] = 5;
        // System.out.println(x[0]);

        int[] z = {1,2,3,4,5};
        System.out.println(z.getClass().isArray());
        System.out.println(z.length);


    }
   

}
