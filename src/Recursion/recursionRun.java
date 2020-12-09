package Recursion;

public class recursionRun {

    public static void main(String [] args ){

     headFactorial(10);
    }

    public static int headFactorial(int n){

        System.out.println("N Before method is: " + n);
        if(n==1) return 1;
//        System.out.println("N Before method is: " + n);

        int res1 = headFactorial(n-1);
        System.out.println("Res1 Value is: " + res1);
        System.out.println("N Value is: " + n);

       System.out.println(" ");

        int result = n*res1;
       // System.out.println("Result Value is: " + result);
        System.out.println(" ");

        return result;
    }
}
