import edu.princeton.cs.introcs.StdRandom; //imported for the purposes of shuffling the array

public class ThreeWayQuick {
    private static boolean median = false;
    private static int cutoff;
    public ThreeWayQuick(boolean median, int cut){
        ThreeWayQuick.median = median;
        cutoff = cut;
    }

    public static void sort(Comparable[] a){
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi){
        if(hi <= lo) return;
        if(hi - lo <= cutoff){
            insertionSort(a, lo, hi);
            return;
        }
        int lt = lo, i  = lo+1, gt=hi;
        exchange(a, getPivot(a, lo, hi), lo);
        Comparable v = a[lo];
        while(i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) exchange(a, lt++, i++);
            else if (cmp > 0) exchange(a, i, gt--);
            else i++;
        }
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }

    private static int getPivot(Comparable[] a, int lo, int hi) {
        int mid = (lo + hi) / 2;
        if(median){
            return getMedian(a, lo, mid, hi);
        } else{
            //returns a random value as the pivot
            return (int) (lo + (Math.random() * ((hi - lo) + 1)));
        }
    }

    private static int getMedian(Comparable[] a, int lo, int mid, int hi){
        if(a[lo].compareTo(a[mid]) > 0){
            if(a[mid].compareTo(a[hi]) > 0){
                return mid;
            } else if(a[lo].compareTo(a[hi]) > 0){
                return hi;
            } else{
                return lo;
            }
        } else{
            if (a[lo].compareTo(a[hi]) > 0) {
                return lo;
            } else if (a[mid].compareTo(a[hi]) > 0) {
                return hi;
            } else {
                return mid;
            }
        }
    }
    public static void insertionSort(Comparable[] a, int lo, int hi){
        for(int i = lo + 1; i <= hi; i++){
            for(int j = i; j > lo && (a[j].compareTo(a[j-1]) < 0); j--){
                exchange(a, j, j-1);
            }
        }
    }

    public static void exchange(Comparable[] a, int i, int j){
        Comparable t = a[i]; a[i] = a[j]; a[j] = t;
    }

}

