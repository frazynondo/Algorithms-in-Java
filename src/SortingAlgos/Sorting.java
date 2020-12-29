package SortingAlgos;

import java.util.Arrays;

public class Sorting {

//    public static double startTime, endTime, timeDifference;
    public static int counter;

    /**
     * Sorts the specified array of integers using the selection
     * sort algorithm.
     */
    public static <T extends Comparable<T>> void selectionSort(T[] data) {
        int min;
        T temp;

//        startTime = System.nanoTime();
//        System.out.println("Start time is "+ startTime);
        for (int i = 0; i < data.length-1; i++) {
            min = i;
            for (int scan = i+1; scan < data.length; scan++){
                counter++;
                if (data[scan].compareTo(data[min])<0)
                    min = scan;
            }

            swap(data, min, i);

        }

        System.out.println("Number of compareTo comparisons in Selection Sort is " + (counter));
        printList(data);
        counter = 0;
    }
    private static <T extends Comparable<T>> void swap(T[] data, int i1, int i2) {
        T temp = data[i1];
        data[i1] = data[i2];
        data[i2] = temp;
    }

    /**
     * Sorts the specified array of objects using an insertion
     * sort algorithm.
     */
    public static <T extends Comparable<T>> void insertionSort(T[] data) {
        for (int i = 1; i < data.length; i++) {
            T key = data[i];
            int position = i;

            // shift larger values to the right
            while (position > 0 && data[position-1].compareTo(key) > 0){
                counter++;
                data[position] = data[position-1];
                position--;
            }

            data[position] = key;
        }

        printList(data);
        counter = 0;
    }

    /**
     * Sorts the specified array of objects using a bubble sort
     * algorithm.
     */
    public static <T extends Comparable<T>> void bubbleSort(T[] data) {
        int position, j;
        T temp;

        for (position =  data.length - 1; position >= 0; position--) {
            for (j = 0; j <= position - 1; j++)
            {
                if (data[j].compareTo(data[j+1]) > 0)
                    swap(data, j, j + 1);
            }
        }

        printList(data);
    }

    /**
     * Sorts the specified array of objects using the merge sort
     * algorithm.
     */
    public static <T extends Comparable<T>> void mergeSort(T[] data) {

        mergeSort(data, 0, data.length - 1);

        printList(data);
    }

    /**
     * Recursively sorts a range of objects in the specified array using the
     * merge sort algorithm.
     *
     */
    private static <T extends Comparable<T>> void mergeSort(T[] data, int min, int max) {
        if (min < max) {
            int mid = (min + max) / 2;
            mergeSort(data, min, mid);
            mergeSort(data, mid+1, max);
            merge(data, min, mid, max);
        }
    }

    /**
     * Merges two sorted subarrays of the specified array.
     */

    private static <T extends Comparable<T>> void merge(T[] data, int first, int mid, int last) {
        T[] temp = (T[])(new Comparable[data.length]);

        int first1 = first, last1 = mid;  // endpoints of first subarray
        int first2 = mid+1, last2 = last;  // endpoints of second subarray
        int index = first1;  // next index open in temp array

        //  Copy smaller item from each subarray into temp until one
        //  of the subarrays is exhausted
        while (first1 <= last1 && first2 <= last2) {
            if (data[first1].compareTo(data[first2]) < 0) {
                temp[index] = data[first1];
                first1++;
            }
            else
            {
                temp[index] = data[first2];
                first2++;
            }
            index++;
        }

        //  Copy remaining elements from first subarray, if any
        while (first1 <= last1) {
            temp[index] = data[first1];
            first1++;
            index++;
        }

        //  Copy remaining elements from second subarray, if any
        while (first2 <= last2) {
            temp[index] = data[first2];
            first2++;
            index++;
        }

        //  Copy merged data into original array
        for (index = first; index <= last; index++)
            data[index] = temp[index];
    }

    /**
     * Sorts the specified array of objects using the quick sort algorithm.
     */
    public static <T extends Comparable<T>> void quickSort(T[] data) {
        quickSort(data, 0, data.length - 1);
    }

    /**
     * Recursively sorts a range of objects in the specified array using the
     * quick sort algorithm.
     */
    private static <T extends Comparable<T>> void quickSort(T[] data, int min, int max) {
        if (min < max) {
            // create partitions
            int indexofpartition = partition(data, min, max);

            // sort the left partition (lower values)
            quickSort(data, min, indexofpartition - 1);

            // sort the right partition (higher values)
            quickSort(data, indexofpartition + 1, max);
        }

        printList(data);
    }

    /**
     * Used by the quick sort algorithm to find the partition.
     */
    private static <T extends Comparable<T>> int partition(T[] data, int min, int max) {
        T partitionelement;
        int left, right;
        int middle = (min + max) / 2;

        // use the middle data value as the partition element
        partitionelement = data[middle];
        // move it out of the way for now
        swap(data, middle, min);

        left = min;
        right = max;

        while (left < right) {
            // search for an element that is > the partition element
            while (left < right && data[left].compareTo(partitionelement) <= 0)
                left++;

            // search for an element that is < the partition element
            while (data[right].compareTo(partitionelement) > 0)
                right--;

            // swap the elements
            if (left < right)
                swap(data, left, right);
        }

        // move the partition element into place
        swap(data, min, right);

        return right;
    }

    public static < T extends Comparable<T>> void printList(T [] data){
        for(int i = 0; i <= data.length-1; i++){

            System.out.println(data[i]);

        }
    }
}

