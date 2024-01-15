import edu.princeton.cs.introcs.StdDraw; //imported method to plot out a graph of the results

public class ThreeWayTester {
    public static void main(String[] args) {

        //testing out three-way quicksort on array
        Double[] firstArray = random(100);
        ThreeWayQuick sorter1 = new ThreeWayQuick(false, 1);
        sorter1.sort(firstArray);
        System.out.print("Three Way Quicksort Array Without Median: ");
        for (double d : firstArray) {
            System.out.print(" ");
            System.out.print(d);
        }
        System.out.println();
        System.out.print("Three Way Quicksort Array With Median: ");

        Double[] secondArray = random(100);
        ThreeWayQuick sorter2 = new ThreeWayQuick(true, 1);
        sorter2.sort(secondArray);
        for (double d : secondArray) {
            System.out.print(" ");
            System.out.print(d);
        }

        int[] arrLengths = {1000, 10000, 100000, 1000000};// creates an array to keep track of the different array lengths we want to test
        Double[] averageTimes = new Double[30]; //keeps track of the average time for each value of M
        Double[] mValues = new Double[30];// keeps an array for each M value to graph later
        double max = 0.0;// finds maximum average time for scaling on graph

        //tests each value of M on ThreeWayQuicksort
        for (int i = 0; i < 30; i++) {
            mValues[i] = (double) i;
            //specific object that changes the cutoff value from 0 to 30
            ThreeWayQuick cutoffTester = new ThreeWayQuick(true, i);
            Double averageTime = 0.0;
            //iterate through different array lengths to test
            for(int n: arrLengths) {
                //keeps track of time in nano-seconds per computation
                long startTime = System.nanoTime();
                Double[] array2 = random(n);
                cutoffTester.sort(array2);
                long endTime = System.nanoTime();
                //converts nanoseconds to centiseconds
                long totalTime = (endTime - startTime) / 10000000;
                averageTime += totalTime;
            }
            averageTime /= 4;//compute average time of computations using threeway quicksort
            averageTimes[i] = averageTime;
            if(averageTime > max) max = averageTime;
        }

        //uses StdDraw library to make a graph of the average time taken for computations for each m-value
        StdDraw.setXscale(-5, 35);
        StdDraw.setYscale(3,max + 3);
        StdDraw.setPenRadius(0.005);
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.line(-1,4,-1,max+ 3);
        StdDraw.line(-1,4,35,4);
        StdDraw.text(30, 4.5, "M");
        StdDraw.text(2, max+2.5, "Time(cs)");
        StdDraw.setPenColor(StdDraw.RED);
        double yCount = 4;
        for(int i = 0; i < 30; i++){
            if(i%5 == 0) {
                StdDraw.text(i, 3.5, String.valueOf(i));
                StdDraw.text(-3, yCount, String.valueOf(yCount));
                yCount+=2;
            }

            StdDraw.text(mValues[i], averageTimes[i], "*");
        }
   }

        public static Double[] random ( int n){ //generates a random array of doubles from 0 to 99
            Double[] arr = new Double[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Math.floor((Math.random() * 100));
            }
            return arr;
        }
}