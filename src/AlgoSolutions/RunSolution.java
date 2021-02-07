package AlgoSolutions;

import java.awt.*;
import java.time.LocalDate;
import java.util.*;
import java.util.List;

public class RunSolution <T extends Comparable> {

    public static void main(String [] args){
        String check = "AAAAAAAAAAAAABBCCCCDD";
        //"9*3*7^6$7%6!9A9A2A"
//        int temp = 9;
//        String v = String.valueOf(temp);
//        System.out.println(v);
//        String test = runLengthEncoding(check);
//        System.out.println(test);
//
//        int [] arr = {12, 3, 1, 2, -6, 5, -8, 6};
//        int target = 0;
//        threeNumberSums(arr, target);
        int [] arrayONe = {-1, 5, 10, 20, 28, 3};
        int [] arrayTwo = {26, 134, 135, 15, 17};

        int math = Math.abs(-5 - 5);
        System.out.println("Math abs ---> "+ math);
        smallestDifferenceS(arrayONe, arrayTwo);
    }



    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        // Write your code here.
        //Finding smallest absolute difference closest to zero
        int [] arr = new int[2];
//        Map<Integer, Integer>
        int temp = Integer.MAX_VALUE;
        for(int I=0; I<arrayOne.length; I++){
            for(int J = 0; J<arrayTwo.length; J++){
                if(Math.abs(arrayOne[I] - arrayTwo[J]) < temp){
                 temp = Math.abs(arrayOne[I] - arrayTwo[J]);
                 arr[0] = arrayOne[I];
                 arr[1] = arrayTwo[J];
                 System.out.println("arr[0] is --> "+arr[0]);
                 System.out.println("arr[1] is --> "+arr[1]);
                 System.out.println(" <--> ");
                }
            }
        }

        return arr;

    }

    public static int[] smallestDifferenceS(int[] arrayOne, int[] arrayTwo) {
        // Write your code here.
        //Finding smallest absolute difference closest to zero
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);
        int [] arr = new int[2];
//        Map<Integer, Integer>
        int temp = Integer.MAX_VALUE;
        int Start1 = 0, Start2 = 0, end1 = arrayOne.length, end2 = arrayTwo.length;

        while(Start1 < end1 && Start2 < end2){

            if(Math.abs(arrayOne[Start1] - arrayTwo[Start2]) < temp){
                temp = Math.abs(arrayOne[Start1] - arrayTwo[Start2]);
                arr[0] = arrayOne[Start1];
                arr[1] = arrayTwo[Start2];
                System.out.println("arr[0] is --> "+arr[0]);
                System.out.println("arr[1] is --> "+arr[1]);
                System.out.println(" <--> ");

            }

            if(arrayOne[Start1] < arrayTwo[Start2]){
                Start1+=1;
            }else {
                Start2+=1;
            }
        }

        return arr;

    }


    public static List<Integer[]> threeNumberSums(int[] array, int targetSum){
        List<Integer[]> T = new ArrayList<Integer[]>();
        Integer[] temp = new Integer[3];
        Arrays.sort(array);
        //
        int right = array.length-1;

        for(int I=0; I<=array.length-1; I++){
            int left = I+1;
            while (left < right){
                int current = array[I] + array[left] + array[right];
                if(current > targetSum){
                    right--;
                }
                if(current < targetSum){
                    left++;
                }

                if (current == targetSum){
                    Integer [] ten = {array[I], array[left], array[right]};
                    T.add(ten);
                    left++;
                    right--;
                }
            }
        }

        for (Integer[] I : T) {
            System.out.println("START== ");
            for (int J = 0; J < I.length; J++) {
                System.out.println("J ---> " + I[J]);
            }
        }

        return T;
    }

    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        // Write your code here.
        List<Integer[]> T = new ArrayList<Integer[]>();
        Integer[] temp = new Integer[3];

        int A = 0, B = array.length, temps = 0, tempM = 0;
        while (A < B) {
            int mid = array.length / 2;
            if ((array[A] + array[B] + array[mid] > targetSum) && (array[A] + array[B - 1] + array[mid] > targetSum)) {
                tempM = mid;
                while(mid > A && (array[A] + array[B] + array[mid] >= targetSum)) {
                    if(array[A] + array[B] + array[mid] == targetSum) {
                        temp[0] = array[A];
                        temp[1] = array[B];
                        temp[2] = array[mid];
                        T.add(temp);
                        break;
                    }
                    mid--;
                }

                B--;
            }

            if ((array[A] + array[B] + array[mid] < targetSum) && (array[A + 1] + array[B] + array[mid] < targetSum)) {
                while (mid < B) {
                    if (array[A] + array[B] + array[mid] == targetSum) {
                        temp[0] = array[A];
                        temp[1] = array[B];
                        temp[2] = array[mid];
                        T.add(temp);
                        break;
                    }
                    mid++;
                }
                A++;

            }

            if (array[A] + array[B] + array[mid] == targetSum) {
                temp[0] = array[A];
                temp[1] = array[B];
                temp[2] = array[mid];
                T.add(temp);
                break;
            }

            for (Integer[] I : T) {
                System.out.println("START== ");
                for (int J = 0; J < I.length; J++) {
                    System.out.println("J ---> " + I[J]);
                }
            }
//        for(int I = 0; I<T.size(); I++){
//
//        }
        }

            return T;
        }


    public static String runLengthEncoding(String string) {
        // Write your code here.
        if(string != null){
            return runLengthEncodingHelps(string);
        }
        return "";
    }

    public static String runLengthEncodingHelps(String string){
        StringBuilder sb = new StringBuilder();
        int count = 1;

        for(int I = 0; I<string.length()-1; I++){
            if(string.charAt(I) == string.charAt(I+1)){
                count++;
                if(count == 9){
                    sb.append("9");
                    sb.append(string.charAt(I));
                    count = 1;
                }
            }else {
                String v = String.valueOf(count);
                sb.append(v);
                sb.append(string.charAt(I));
            }
        }

        return sb.toString();
    }

    public static String runLengthEncodingHelper(String string) {
        // Write your code here.
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> temps = new LinkedHashMap<>();

        for(char I : string.toCharArray()){
            if(temps.containsKey(I)){
                temps.computeIfPresent(I, (k, v)-> v + 1);
            }else {
                temps.put(I, 1);
            }
        }
        for(Map.Entry<Character, Integer> P : temps.entrySet()){
            if(P.getValue() > 9){
                int temp = P.getValue();
                while(temp > 9){
                  sb.append("9");
                  sb.append(P.getKey());
                  temp = temp - 9;
                }
                sb.append(temp);
                sb.append(P.getKey());
            } else{
                sb.append(P.getValue());
                sb.append(P.getKey());
            }
        }

        return sb.toString();
    }


    //Cypher
    public static String caesarCypherEncryptor(String str, int key) {
        if(key >= 0){
            str = caesarCypherEncryptorHelper(str.toLowerCase(), key);
            return str;
        } else {
            return "INVALID STRING";
        }
    }
    public  static  String caesarCypherEncryptorHelper(String str, int key){
//        String BS = "xyz}";
        StringBuilder sb = new StringBuilder();
        int counter, counterTemp = 0;
        /*** Iterate through the given string
         * -- we know that alphabet ranges from 97 = 'a' to 122 = 'z' **/
        for(int I = 0; I<str.length(); I++){

            /** Check if the given char is greater than z **/
            if((str.charAt(I) + key) > 'z'){
                //counter will keep track for when str given char is greater than z
                // int temps = 'z' - str.charAt(I);
                int temp = 'z' - str.charAt(I);
                int tempKey = tempKey(key);
                if(((tempKey - temp) - 1) >= 0){
                    counter = 'a' + ((tempKey - temp) - 1);
                }else{
                    counter = 'a' + tempKey + ((26 - temp) - 1);
                }

                sb.append((char) counter);
            }else{
                sb.append((char) (str.charAt(I) + key));
            }
        }
        return sb.toString();
    }

    public static int tempKey(int Key){
        int tempKey = Key;
        if(tempKey > 26){
            while(tempKey > 26){
                tempKey = tempKey - 26;
            }
        }
        return tempKey;
    }

    public static int[] findThreeLargestNumbers(int[] array) {
        // Write your code here.
        if(array != null && array.length >= 2){
            return findThreeLargestNumbersHelper(array);
        }
        return null;
    }

    /*
    Write a function that takes in a special array and return its product sum
    **/



    private static int[] findThreeLargestNumbersHelper(int[] array) {
        int [] temp = new int[3];
        int check = 1;
        int largest = array[0];
        int secondLarge = Integer.MIN_VALUE, thirdLarge = Integer.MIN_VALUE;
//        while(check < array.length){
//           if(array[check] >= largest){
//               thirdLarge = secondLarge;
//               secondLarge = largest;
//               largest = array[check];
//           }else if (array[check] >= secondLarge){
//               thirdLarge = secondLarge;
//               secondLarge = array[check];
//           }else if(array[check] >= thirdLarge){
//               thirdLarge = array[check];
//           }
//           check++;
//        }
        int size = array.length-1;
        while(check < size){

            check++;
        }
        temp[0] = largest;
        temp[1] = secondLarge;
        temp[2] = thirdLarge;
        return temp;

    }

//
//
//        while (check < array.length){
//          if(array[check] > temp[0] && array[check] != temp[1] && array[check] != temp[2]){
//              temp[0] = array[check];
//          } else if(array[check] > temp[1] && array[check] != temp[0] && array[check] != temp[2]){
//              temp[1] = array[check];
//          } else if(array[check] > temp[2] && array[check] != temp[0] && array[check] != temp[1]){
//              temp[2] = array[check];
//          }
//          check++;
//        }
//        while (check < array.length){
//            if(array[check] >= temp[0]){
//                temp[0] = array[check];
//            } else if(array[check] >= temp[1]){
//                temp[1] = array[check];
//            } else if(array[check] >= temp[2]){
//                temp[2] = array[check];
//            }
//            check++;
//        }
//        while (check < array.length){
//            if(array[check] > temp[0]){
//                temp[0] = array[check];
//            } else if(array[check] > temp[1]){
//                temp[1] = array[check];
//            } else if(array[check] > temp[2]){
//                temp[2] = array[check];
//            }
//            check++;
//        }


    public static int minimumWaitingTime(int[] queries) {
        // Write your code here.
        int temp = 0, index = queries.length-2;
        if(queries != null){
            Arrays.sort(queries);
            return minimumWaitingTimeHelper(queries, temp, index);
        }
        return -1;
    }
    /* Sample imput: queries = [3, 2, 1, 2, 6]
    Output: 1 + (1+2) + (1+2+2) + (1+2+3+3)
     */

    public static int minimumWaitingTimeHelper(int[] queries, int temps, int index) {
        // Write your code here.
        int total = 0, temp = 0;
        for(int I = queries.length-2; I >= 0; I--){
            int check = 0;
          for (int j = I; j>=0; j-- ){
              check += queries[j];
          }
          temp+= check;
        }


        return temp;
    }

    //write a function that takes in a special array and return its product sum
    public static int productSum(List<Object> array) {
        // Write your code here.
        if(array != null){
            int multi = 1;
            return productSumHelper(array, multi);
        }
        return -1;
    }

    public static int productSumHelper(List<Object> array, int multiply){
        int sum = 0;
        for(Object I : array){
            if(I instanceof List){
                sum += productSumHelper((List) I, multiply + 1);
            }else {
                sum += (int) I;
            }
        }

        return sum * multiply;
    }


    /**LeetCode: 1281. Subtract the Product and Sum of Digits of an Integer
    Given an integer number n, return the difference between the product of its digits and the sum of its digits.
     Example 1:

    Input: n = 234
    Output: 15
    Explanation:
    Product of digits = 2 * 3 * 4 = 24
    Sum of digits = 2 + 3 + 4 = 9
    Result = 24 - 9 = 15
    Example 2:

    Input: n = 4421
    Output: 21
    Explanation:
    Product of digits = 4 * 4 * 2 * 1 = 32
    Sum of digits = 4 + 4 + 2 + 1 = 11
    Result = 32 - 11 = 21
     Constraints:
     1 <= n <= 10^5
    **/

    public static int getNthFib(int n){

        if(n >= 0){
          return getNthFibHelper(n);
        }
        return -1;
    }
    public static int getNthFibHelper(int n){
        if(n == 0) return n;

        return getNthFibHelper(n-1) + getNthFibHelper(n-2);
    }
    public static boolean unique(String test){
        boolean t = false;
        test.toLowerCase();
        Map<Character, Integer> check = new LinkedHashMap<>();
        int p;
        for(char i : test.toCharArray()){
            if(check.containsKey(i)){
                return false;
            } else{
                check.put(i, 1);
            }
        }
        check.forEach((key, value) -> System.out.printf("Key -> %c | value %s \n", key, value));

        return true;
    }

    public static int firstDuplicateValue(int[] array) {
        // Write your code here.
        Map<Integer, Integer> isDuplicate = new LinkedHashMap<Integer, Integer>();
        int count = -1;
        for(int I = 0; I < array.length; I++) {
            if(isDuplicate.containsKey(array[I])) {
                return array[I];
            } else {
                isDuplicate.put(array[I], 1);
            }

        }
        return count;
    }

    public static String findDay(int month, int day, int year) {
        //Return day of the week of the given date
        LocalDate C = LocalDate.of(year, month, day);

        return C.getDayOfWeek().toString();
    }

    public static boolean iterativeBinarySearch(int[] input, int value) {
        int start = 0;
        int end = input.length;

        while (start < end) {
            int midpoint = (start + end) / 2;
            System.out.println("midpoint = " + midpoint);
            if (input[midpoint] == value) {
                return true;
            }
            else if (input[midpoint] < value) {
                start = midpoint + 1;
            }
            else {
                end = midpoint;
            }
        }

        return false;
    }


    public static int[] filterDuplicates(int[] data) {
        // Write your code here
        // To debug: System.err.println("Debug messages...")
//        int end = data.length;
//        Set<Integer> set = new HashSet<Integer>();
//
//        int T = 0;
//        for(int i = 0; i < end; i++){
//            set.add(data[T++]);
//        }
//
//        int [] temp = new int[set.size()];
//        int i = 0;
//        for (Integer value : set) temp[i++] = value;

//        return temp;

        //We can also do it like this
        int P = 0, A = 0;
        Arrays.sort(data);
        for(int j = 0; j < data.length-1; j++){
            if(data[j] != data[j+1]){
               data[A++] = data[j];
            }
        }
        data[A++] = data[data.length-1];
        int[] temps = new int[A];
        System.arraycopy(data, 0, temps, 0, A);

        return temps;

        //        data.length = A;

//        Arrays.sort(data);
//        List<Integer> temp = new ArrayList<>();
//        for(int I = 0; I< data.length-1; I++){
//            if(data[I] != data[I+1]){
//             temp.add(data[I]);
//            }
//        }
//        int i = 0;
//        int [] array = new int[temp.size()];
//        for (Integer value : temp) array[i++] = value;;
//        return array;

    }

//    static boolean exists(int[] input, int k) {
//
//        Arrays.sort(input);
//        int start = 0;
//        int end = input.length;
//        while(start < end){
//            int mid = (start + end)/2;
//            if(input[mid] == k){
//                return true;
//            } else if(input[mid] < k){
//                start = mid+1;
//            } else {
//                end = mid;
//            }
//
//        }
//
//        return false;
//    }

    public void runs(){
        int [] test = {2, 4, 3, 5, 6, 7, 3, 7, 16};

        Duplicate(test);
    }
    //Method to find the length of the last word of a String input
    public static int lastWordLength(String T){

        String [] arr = T.split(" ");
//        for (String I : arr){
//            System.out.println("Here : " + I);
//        }
        return arr[arr.length-1].length();
    }

    public static String ReversedString(String text){

        StringBuilder reversedStrings = new StringBuilder();
        //o(n)
        for(int I=text.length()-1; I>=0; I--){
            System.out.println(text.charAt(I));
          reversedStrings.append(text.charAt(I));
        }
        return reversedStrings.toString();
    }
    //method reverses a String
    public static String reversed(String T){
        char[] ch = T.toCharArray();
        int Start = 0, End = ch.length-1;

        while(End > Start){
            swap(ch, End, Start);
            End--;
            Start++;
        }
        String S = new String(ch);


        String b, end;

//        StringBuffer String = new StringBuffer();
//
//        for(int I )


//       String temp = "", begin="", end="";
       //        Stack<String> S = new Stack<>();
//        for(int I = 0; I<ch.length; I++){
//            temp = temp + ch[ch.length-I-1];
//        }
//        int min = ch.length/2;
//        int max = ch.length-1;
//        int limit = min;
//        while(max >= limit){
//            end += ch[max--];
//            begin = begin + ch[min--];
//
//        }

//        int p = ch.length - 1;
//        for(int I =ch.length-1; I >= 0; I--){
//            end = end + ch[I];
//            begin = begin + ch[p--];
//            if(I == ch.length/2){
//                return end + begin;
//            }
//        }


//        for(int I = 0; I<ch.length/2; I++){
//            end = end + ch[ch.length-I-1];
//            begin = begin + ch[ch.length/2-I-1];
//        }


//        for(int I = 0; I<ch.length/2; I++){
//            char Temp = ch[ch.length-I-1];
//            ch[ch.length-I-1] = ch[I];
//            ch[I] = Temp;
//        }

//        for( int I = 0; I<ch.length; I++){
//            System.out.println("Checking :" + ch[I]);
//        }


        return S;
    }

    public static boolean anagramString(String Ana){
        int start = 0, End = Ana.length()-1;
        boolean isAnagram = false;
        while(End > start){
        if(Ana.charAt(End) == Ana.charAt(start)){
         isAnagram = true;
        } else {
            isAnagram = false;
        }
            End--;
            start++;
        }

     return isAnagram;
    }

    //Method to find and return a list of duplicates within a passed in array
    public static List<Integer> Duplicate(int [] array){
//        int start = 2, end = array.length;
        // Init a list to add duplicates
        List<Integer> doubles = new ArrayList<>();

        for(int I = 0; I<array.length; I++){
            /**
             *  ==> int [] arr = { 2, 3 ,4 ,5 ,6 ,7 ,8, 5, 2};
             *  ==> J = Math.abs(index 0 which is 2) - 1
             *  Value of J = 1
             *  Check if the value at index J is not negative
             *  Index of J = 3 -- 3 is not negative -- if its a negative # we add value of index J+1 to our list
             *  ==> if(arr[J]) < 0 List.add(J+1)
             *  arr[J] = -arr[J]
             * **/
            //Subtract 1 to the index value and assign the remainder to J
            int j = Math.abs(array[I]) - 1;
            //check if value at J index is negative then add I to double
            if(array[j] < 0) doubles.add(j+1);
            array[j] = -array[j];

            /** This works too depending of the size of the array and the values on  each index
             * if(array[Math.abs(array[I])] < 0) doubles.add(Math.abs(array[I]));
             * array[Math.abs(array[I])] = -array[Math.abs(array[I])];
             * **/
        }

//        while(start < end){
//
//            if(array[start].compareTo(array[start-1]) == 0){
//             doubles.add(array[start].toString());
//            }
//        start++;
//
//        }
        return doubles;
    }

    private static <T extends Comparable<T>> char[] swap(char [] data, int i1, int i2) {
        char temp = data[i1];
        data[i1] = data[i2];
        data[i2] = temp;

        return data;
    }

}
