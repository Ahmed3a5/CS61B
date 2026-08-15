package lecture5;

public class IntListme {
    public int first;
    public IntListme rest;

    public IntListme(int f , IntListme r){
        this.first = f;
        this.rest = r;

    }

    public int getFirst(){
        return this.first;
    }
    
    public IntListme getrest(){
        return this.rest;
    }

    public int getsize(){
        if (this.rest == null){
            return 1;
        }
        else{
            return 1 + this.rest.getsize();
        }
    }

    
    public int size(){
        IntListme p = this;
        int totalsize = 0;
        while(p !=null){
            totalsize ++;
            p = p.rest;
        }
        return totalsize;
    }
    
    public int get(int i){
        int iter = 0;
        IntListme p = this;
        if (i == iter){
            return this.first;
        }
        else{
            while(p != null){
                if(i == iter){
                    return p.first;
                }
                iter ++;
                p = p.rest;
            }
        }
        return 0;
    }
    
    public int recurget(int i){
        if(i == 0){
            return this.first;

        }
        return rest.recurget(i-1);
    }
    
    public static IntListme copyList( IntListme old){
        IntListme N = new IntListme(old.first , old.rest);
        return N;
    }

    public IntListme copy(){
        IntListme N = new IntListme(this.first , this.rest);
        return N;
    }

    public static IntListme incrRecursiveDestructive(IntListme L, int x) {
        L.first = L.first + x;
        if(L.rest != null){
            incrRecursiveDestructive(L.rest, x);
        }
        return L;
    }
    
    public static void main(String[] args){
        // IntList L = new IntList(5 , null);
        // L.rest = new IntList(4,null);
        // L.rest.rest = new IntList(7 , null);
        // L.rest.rest.rest = new IntList(10 , null);

        // System.out.println(L.getsize());
        // System.out.println(L.recurget(2));
        // IntList n = copyList(L);
        // System.out.println(n.get(0));

        IntListme L = new IntListme(5, null);
        L.rest = new IntListme(7, null);
        L.rest.rest = new IntListme(9, null);

        IntListme M = incrRecursiveDestructive(L, 3);

        System.out.println(M.size());




    }
}
