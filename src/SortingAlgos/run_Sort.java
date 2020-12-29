package SortingAlgos;

public class run_Sort  {

    public static void main(String[] args){

        int [] array = {3, 4, 5, -4, 8, 11, 2, 1, -1, 6};
        int [] testing =insertionSort(array);

    }

    public static int[] BubbleSort(int[]array){
//B_sort 1
        boolean sorted = false;
//            while (!sorted) {
//                sorted =true;
//                for(int i=1; i<array.length; i++){
//                if (array[i - 1] > array[i]) {
//                    swap(array, i - 1, i);
//                    sorted = false;
//                }
//               }
//
//            }
//B_sort 2
 //{3, 4, 5, -4, 8, 11, 2, 1, -1, 6}
        for(int lastUnsorted=array.length-1; lastUnsorted >0; lastUnsorted--){
            for(int i=0; i<array.length-1; i++){
                if(array[i] > array[i+1]){
                    swap(array, i, i+1);
                    //{3, 4, 5, -4, 8, 11, 2, 1, -1, 6}
                    System.out.println(" SWAP "+array[i]+ " AT INDEX "+i+" WITH "+array[i+1]+ " AT INDEX "+(i+1));
                }
            }
        }

        return array;
    }

    //SELECTION SORT
    public static int[] SelectionSort(int[] array){
        for(int i=0; i<array.length-1; i++){
            //Set the minimum value in the array to i
            int min = i;
         for (int j=i+1; j<array.length; j++){
             //Search if any value in the array is less than min
           if(array[min] > array[j]){
               //one found? Make it the new min
               min = j;
           }
           //Swap the indexes
             swap(array, i, min);
         }
        }

        return array;
    }

    public static int[] insertionSort(int [] arrays){
        int [] temparrays = arrays;
//        int T = 1;
//
//        while(T < temparrays.length){
//            int count = T;
//            while(count > 0){
//                if(temparrays[count] < temparrays[count-1]){
//                    swap(temparrays, count, count-1);
//                }
//                count--;
//            }
//            T++;
//        }

    for(int I = 1; I < temparrays.length; I++){
        int temp = I;
//        while(temp > 0){
//            if(temparrays[temp] < temparrays[temp-1]){
//              swap(temparrays, temp, temp-1);
//            }
//          temp--;
//        }

        while(temp > 0 && temparrays[temp] < temparrays[temp-1]){
            swap(temparrays, temp, temp-1);

            temp--;
        }
    }
        return temparrays;

    }

    public static void swap(int[] arrays, int t, int p){
        int temp = arrays[t];
        arrays[t] = arrays[p];
        arrays[p] = temp;
    }
}
