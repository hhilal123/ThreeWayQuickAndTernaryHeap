public class TernaryHeap{ //create a class containing methods that complete a ternary heapsort

    public TernaryHeap(){ //constructor can remain empty b/c we are just creating a sort
    }

    public void sort(Comparable[] a){  //pass a Comparable array to the sort method
        int n = a.length;
        //
        for (int k = n / 3; k >= 1; k--) {
            sink(a, k, n);
        }
        n--;
        while (n > 1) {
            exchange(a, 1, n--);
            sink(a, 1, n);
//            print(a, n);
              if(a[1].compareTo(a[2]) < 0) break;
        }
    }

    private void exchange(Comparable[] a, int i, int j){
//        System.out.println();
//        System.out.println("Exchanged " + a[i] + " and " + a[j]);
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private void sink(Comparable[]a, int k, int N){
        while(3*k <= N) {
            int j = (3 * k);
            int right = (3* k) +1;
            int left = (3 * k) - 1;

            if (right <= N && less(a, j, right)) {
                j = right;
            }
            if (left <= N && less(a, j, left)) {
                j = left;
            }

            if(!less(a, k, j)) break;
            exchange(a, k, j);
            k = j;
        }
    }

    private boolean less(Comparable[] a, int i, int j){
        return a[i].compareTo(a[j]) < 0;
    }

    private void print(Comparable[] a, int n){
        for(int i = 0; i < a.length; i++) {
            System.out.print(" ");
            if(i == n + 1) System.out.print("| ");
            System.out.print(a[i]);
        }
        System.out.println();

    }
}

