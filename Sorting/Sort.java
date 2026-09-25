package Sorting;

public class Sort {

    public static void selectionSort(int[] arr){
        for(int i = 0 ; i < arr.length ; i++){
            int smallestindex = findSmallestIndex(arr , i);
            if(less(arr[smallestindex] ,arr[i])){
                exch(arr, smallestindex, i);
            }
        }
    }

    public static void insertionSort(int[] arr){
        for(int i = 1 ; i <arr.length; i++){
            for(int j = i ; j > 0 ; j--){
                if(less(arr[j] , arr[j-1])){
                    exch(arr, j, j-1);
                }
            }
           
        }
    }

    public static int[] mergSort(int[] arr){
        int n = arr.length;
        if(n <=1){return arr;}
        int[] a = new int[n/2];
        int[] b = new int[n-(n/2)];
        for(int i = 0 ; i < a.length ; i++){a[i] = arr[i];}
        for(int i = 0 ; i < b.length ; i++){b[i] = arr[i+(n/2)];}
        return merge(mergSort(a) , mergSort(b));
    }

    public static int[] merge(int[] a , int[] b){
        int[] arr = new int[a.length + b.length];
        int i = 0 ; int j = 0;
        for(int k = 0 ; k < arr.length; k++){
            if(i >= a.length){arr[k] = b[j]; j++;}
            else if(j >= b.length){arr[k] = a[i]; i++;}
            else if(less(a[i] , b[j])){arr[k] = a[i]; i++;}
            else{arr[k] = b[j]; j++;}
        }
        return arr;
    }

    public static boolean less(int v , int y){
        if(v < y){return true;}
        return false;
    }

    public static void exch(int[] arr ,int x , int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static int findSmallestIndex(int[] arr , int index){
        int smallestindex = index ;
        for(int i = index ; i < arr.length ; i++){
            if(arr[smallestindex] > arr[i]){smallestindex = i;}
        }
        return smallestindex;
    }

    public static void main(String[] args){
        int[] arr = new int[]{ 5 , 4 , 3 ,2 , 1 , 10 , 9 , 6 , 7 , 8};
        // selectionSort(arr);
        // insertionSort(arr);
        int[] sortarr = mergSort(arr);
        
        // for(int i = 0 ; i < arr.length ; i++){
        //     System.out.println(arr[i]);
        // }

        for(int i = 0 ; i < arr.length ; i++){
            System.out.println(sortarr[i]);
        }
    }
}
