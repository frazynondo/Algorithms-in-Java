package SortingAlgos;

public class run_Sort {
    public static void main(String[] args){

        int [] array = {3, 4, 5, -4, 8, 11, 2, 1, -1, 6};
        int [] testing = BubbleSort(array);

        for(int k =0; k<testing.length; k++){
            System.out.println(testing[k]);
        }
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


    public static void swap(int[] arrays, int t, int p){
        int temp = arrays[t];
        arrays[t] = arrays[p];
        arrays[p] = temp;
    }
}
