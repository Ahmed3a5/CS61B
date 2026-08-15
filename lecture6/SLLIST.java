package lecture6;

public class SLLIST {
    private IntNode sentinel;
    private int size ; 

    private class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i , IntNode n ){
            item = i ;
            next = n ;  
        
        }

    }


    public SLLIST(){
        sentinel = new IntNode(-1 , null);
        size = 0;
    }

    public SLLIST(int x){
        sentinel  = new IntNode(-1, null);
        sentinel.next = new IntNode(x , null);
        size++;

    }

    public void addfirst(int x){
        IntNode n = new IntNode(x,null);
        n.next = sentinel.next;
        sentinel.next = n;
        size++;
    }

    public int getfirst(){
        return sentinel.next.item;
    }

    public void addlast(int x){
        IntNode p = sentinel.next;

        while(p.next != null){
            p = p.next;
        }

        p.next = new IntNode(x , null);
        size++;
    }

    public int getlast(){
        IntNode p = sentinel.next;

        while(p.next != null){
            p = p.next;
        }

        return p.item;
    }

    public int size(){
        return size;
    }

    public void insert(int x , int index){
        IntNode n = new IntNode(x , null);
        IntNode curr = sentinel.next.next;
        IntNode prev = sentinel.next;
        if(index < 0){
            this.addfirst(x);
        }
        else if(index > this.size()){
            this.addlast(x);
        }
        else{
            for(int i = 1 ; i < this.size() ; i++){
                if(i == index){
                    n.next = curr;
                    prev.next = n;
                    size++;
                    return;

                }
                else{
                    prev = curr;
                    curr = curr.next;
                }
            }
        }
    }

    public void insert_2(int x  , int index){
        IntNode n = new IntNode(x , null);
        IntNode p = sentinel;
        if(index < 0){
            this.addfirst(x);
        }
        else if(index > this.size()){
            this.addlast(x);
        }
        else{
            for(int i = 1 ; i <= index ; i++){
                p = p.next;
            }

            n.next = p.next;
            p.next = n;
            size++;
        }

    }

    public int get(int index){
        int res = 0;
        IntNode curr = sentinel.next;
        for(int i = 0 ; i < this.size() ; i++){
            if(i == index){
                res =  curr.item;
            }
            curr = curr.next;
        }
        return res ; 
    }

    
}
