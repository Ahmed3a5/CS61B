import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
   public boolean[][] colrowbool;
   public WeightedQuickUnionUF perc;
   public int numberofopensites;

    public Percolation(int N) {
        colrowbool = new boolean[N][N];
        perc = new WeightedQuickUnionUF(N*N+2);  // add 2 extra boxes to make a virual top box and virtual botton box 
                                                 // and this when we open a top box we union it to the virtual top which is N*N box N is the number of boxes
                                                 // and if we open the bottom bo we union it to the virtual bottom which is the N*N+1 box
    }

    public void open(int row, int col) {
        if(colrowbool[row][col] == true){
            return;
        }
        
        colrowbool[row][col] = true;
        numberofopensites++;
        
        // N is the numbers of rows in the 2D array and it is a square so row == column 
        int N = colrowbool.length;
        // the formula for make the (row , col) box as a number flat box 
        int box = (N*row)+col;
        // the box above the target box equals to the location of the box in the set minus the number of columns 
        int upbox = box-N;
        // the box below the target box 
        int downbox = box+N;
        int leftbox = box-1;
        int rightbox = box +1;

        // if we open box in the row 0 top row we connect it to the N*N box which we appear to be the virtual top connection for constant time
        if(row == 0){
            perc.union(box, N*N);
        }

        // if we open box in the row N-1 the bottom row we connect it to the N*N+1 box last box in the set which represent the connction of the bottom row 
        // but lead to backwash 

        // if(row == N-1){
        //     perc.union(box , N*N+1);
        // }

        // this if statment for wrap around the boxes so is we at the last column did not unnion it to the first column 
        // we should check is the adjacent boxes to target box is also open or not so we union them together to make a path 
        if(row > 0 && isOpen(row-1, col) ){
            perc.union(box, upbox);
        }
        if(row < N-1 && isOpen(row+1, col)){
            perc.union(box, downbox);
        }
        if(col < N-1&& isOpen(row, col+1)){
            perc.union(box, rightbox);
        }
        if(col > 0  && isOpen(row, col-1)){
            perc.union(box, leftbox);
        }
       
    }

    public boolean isOpen(int row, int col) {
        if(colrowbool[row][col] == true){
            return true;
        }
        return false;
    }

    public boolean isFull(int row, int col) {
        if(!isOpen(row, col)){
            return false;
        }
        int N = colrowbool.length;
        int box = row*N +col;

        /*
          the use of slow for loop the old way
        */
    
        // for(int i = 0; i < N ; i++){
        //     if(isOpen(0, i)){
        //         return perc.find(i) == perc.find(box);
        //     }
        // }
        // return false;


        /*
            the use of the constant time comparison 
        */

        if(perc.find(N*N) == perc.find(box)){
            return true;
        }
        return false;
    }

    public int numberOfOpenSites() {
        return numberofopensites;
    }

    public boolean percolates() {

        /*\

            the nested for loop for the comarison of every top box to every bottom box so the system percolates if two is connected
        */

        // int top = colrowbool.length;
        // int bottom = top*top;
        // for(int i = 0 ; i < top ; i++){
        //     for(int j = bottom-1 ; j >= bottom-top ; j--){
        //         if(perc.find(i) == perc.find(j)){
        //             return true;
        //         }
        //     }
        // }
        // return false;


        /*
            use the constant time comparison for is the top and the bottom connected or not so the system percolates but there is backwash
        */
        // int N = colrowbool.length;
        // if(perc.find(N*N) == perc.find(N*N+1)){
        //     return true;
        // }
        // return false;

        // no backwash
        int N = colrowbool.length;
        int bottom = N*N-1;
        for(int i = bottom ; i >= bottom-N ; i--){
            if(perc.find(N*N) == perc.find(i)){
                return true;
            }
        }
        return false;
    }
}
