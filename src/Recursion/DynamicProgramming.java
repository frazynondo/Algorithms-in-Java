package Recursion;

public class DynamicProgramming {

    public static void main(String[] args){
//        FibNum_Dynamic(6);
        int size = 7;
        int[] test = new int[size];
        int [] tem = {2, 3, 4, 1, 2, 4, 5, 6, 7, 7, 8, 5, 3, 2};

        for(int I=0; I<test.length; I++){
            test[I] = tem[I];
        }
        System.out.println(" Size is "+ size);
        System.out.println(" Length is "+ test.length);
        System.out.println(" Index is "+ test[test.length-1]);
    }
    /**
     * BOTTOM UP APPROACH
     *  We try to solve smaller sub-problems first, use their solution
     *  to build on and arrive at solutions to bigger sub-problems.
     *  It is also called a Tabulation method.
     *  The solution is build in a tabular form by using solutions
     *  of smaller sub-problems iterately and generating solutions to bigger sub problems
     *
     * */
    public static int FibNum_Dynamic(int n){
        //We put n+1 because our array will store the results
        // from etc n = 5 meaning n+1 store from 1 to 5
        int[] temp = new int[n+1];
        //n=5, n+1 = 6
        temp[0] = 0;
        temp[1] = 1;
        System.out.printf("Fib --> %s \n", temp[0]);
        System.out.printf("Fib --> %s \n", temp[1]);
        for(int I = 2; I<=n; I++){
           temp[I] = temp[I-1] + temp[I-2];
            System.out.printf("temp[I-1]-> %s \n", temp[I-1]);
            System.out.printf("temp[I-2]-> %s \n", temp[I-2]);
           System.out.printf("Fib --> %s \n", temp[I]);
        }
        return temp[n-1];
    }

    /**
     * TOP DOWN APPROACH
     * It is also called as memoization
     * We break the large problem into multiple sub-problems
     * Each of the sub-problems are solved and solutions are remembered
     * If the sub-problem is solved already, reuse the answer
     * **/

    public static int FibNum_DynamicToDown(int [] memorize, int n){
        if(memorize[0] == 0){
            if(n < 2){
                memorize[n] = n;
            }else {

                int left = FibNum_DynamicToDown(memorize, n-1);
                int right = FibNum_DynamicToDown(memorize, n-2);
                memorize[n] = left + right;
            }
        }
        return memorize[n];
    }
}
