import java.util.*;

class oving3 {
    // Bubblesort will run if partition is smaller than this
    public static int minLength = 200;
    
    // Method that sorts one partition of an array
    public static int partition(int low, int high, int[] table) {
        swap(high, (high+low) / 2, table);
        int pivot = table[high];
        int indexLow = low - 1;
        for(int j = low; j < high; j++) {
            if (table[j] <= pivot) {
                indexLow++;
                swap(indexLow, j, table);
            }
        }
        swap(indexLow + 1, high, table);
        return indexLow + 1;
    }

    // Quicksort method that runs recursively
    public static void quickSort(int low, int high, int[] table) {
        if (low < high) {
            int partition = partition(low, high, table);
            if ((((partition-1) - low) < minLength) && ((partition-1) - low) > 0) {
                bubbleSort(table, low, partition-1);
            } else {
                quickSort(low, partition - 1, table);
            }
            if (((high - (partition+1)) < minLength) && ((high - (partition+1)) > 0)) {
                bubbleSort(table, partition+1, high);
            } else {
                quickSort(partition + 1, high, table);
            }
        }
    }

    // Bubblesort method, used in quickSort when a partition is shorter than minLength
    public static void bubbleSort(int[] table, int low, int high) {
        for(int i = high; i > low; i--) {
            for(int j = low; j < i; j++) {
                if (table[j] > table[j+1]) {
                    swap(j, j+1, table);
                }
            }  
        }
    }

    // Method for swapping two values in an array
    private static void swap(int index1, int index2, int[] table) {
        int temp = table[index2];
        table[index2] = table[index1];
        table[index1] = temp;
    }


    //////////////// MAIN METHOD ////////////////////////////
    public static void main(String[] args) {
        // Length of table
        int tableLength = 1000000;

        // Other variables
        Random rand = new Random();
        int[] test = new int[tableLength];
        int sumBefore = 0;
        boolean sorted = true;
        int sumAfter = 0;
        
        // Generates a large table
        for (int i = 0; i < tableLength; i++) {
            test[i] = rand.nextInt(10000);
            sumBefore += test[i];
        }

        // Sorting and timing
        long startTime = System.nanoTime();
        quickSort(0, test.length - 1, test);
        long endTime = System.nanoTime();
        double runTime = (endTime - startTime) / 1000000;

        // Validation loop
        for (int i = 0; i < test.length-2; i++) {
            if (test[i+1] < test[i]) {
                sorted = false;
                System.out.print("hei");
            }
            sumAfter += test[i];
        }
        sumAfter += test[test.length-1] + test[test.length-2];

        // OUTPUT
        if (sorted) {
            System.out.println("Sortering vellykket");
        }
        if (sumBefore == sumAfter) {
            System.out.println("Summene matcher");
        }
        System.out.println(runTime + " ms");

        // Checks that sorting works on a sorted table
        long startTime1 = System.nanoTime();
        quickSort(0, test.length - 1, test);
        long endTime1 = System.nanoTime();
        double runTime1 = (endTime1 - startTime1) / 1000000;
        System.out.println(runTime1 + " ms");
    }
}


// Bubblesort når partisjoner er kortere enn 2: ca. 153 ms
// Bubblesort når partisjoner er kortere enn 10: ca. 155 ms
// Bubblesort når partisjoner er kortere enn 100: ca. 105 ms // vinner
// Bubblesort når partisjoner er kortere enn 1000: ca. 945 ms
// Bubblesort når partisjoner er kortere enn 500: ca. 480 ms
// Bubblesort når partisjoner er kortere enn 200: ca. 165 ms