import edu.princeton.cs.introcs.StdRandom;

public class TernaryHeapTester {

    public static void main(String[] args){
        Integer[] arr1 = new Integer[100];
        for(int i = 0; i < arr1.length; i++){
            arr1[i] = i;
        }
        StdRandom.shuffle(arr1);
        Integer[] arr2 = new Integer[101];
        for(int i = 0; i < arr1.length; i++){
            arr2[i + 1] = arr1[i];
        }
        for(int c : arr1) {
            System.out.print(" ");
            System.out.print(c);
        }
        System.out.println();
        TernaryHeap threeHeapsort = new TernaryHeap();
        threeHeapsort.sort(arr2);
        System.out.println();
        System.out.print("Heapsorted Array: ");
        for(int i = 1; i < arr2.length; i++) {
            System.out.print(arr2[i]);
            System.out.print(" ");
        }
    }

}
