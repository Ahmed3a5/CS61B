package array;

public class dicegame {


    public static int[] rolldice(int[] numarr){
        int [] dicearr = new int[6];

        for(int i = 0 ; i < numarr.length ; i++){
            int rollvalue = numarr[i];

            dicearr[rollvalue-1] +=1;
        }

        return dicearr;
    }

    public static int max_in_array(int[] arr){
        int max = 0;
        int maxindex = 0;
        
        for(int i =0; i < arr.length ; i++){
            if(arr[i] > max){
                max = arr[i];
                maxindex = i;
            }
        }
        return maxindex;
    }

    public static int min_in_array(int[] arr){
        int min = arr[0];
        int minindex = 0;
        
        for(int i =0; i < arr.length ; i++){
            if(arr[i] < min){
                min = arr[i];
                minindex = i;
            }
        }
        return minindex;

    }
    public static void main(String[] args){

        int[] numarr = new int[]{1 , 1 , 2 , 4 , 3 , 4 , 6 , 5 , 6 , 2 , 1 , 1 , 4 , 5 , 6 , 4 , 6 ,1, 1 , 3 ,6 , 5 , 4 , 2 , 3 , 1 , 6 , 2 };

        int[] dicearr = rolldice(numarr);

        // int maxindex = max_in_array(dicearr);
        int minindex = min_in_array(dicearr);

        // System.out.println(maxindex);
        // System.out.println(dicearr[maxindex]);

        System.out.println(minindex);
        System.out.println(dicearr[minindex]);
    }

}    
