package Recursion;

public class fibonacciNum {

    public static int head_Fib(int n){
        /**
         * Head Recursion Fibonacci...
         * Define the base cases F(0) = 0 and F(1) = 1*
         * */
        if(n==0) return 0;
        if(n==1) return 1;

        //Call the method recursively
        int fib1 = head_Fib(n-1);
        int fib2 = head_Fib(n-2);
        int result = fib1 + fib2;
        return result;
    }

    public static int tail_Fib(int n){
        //tail recursion
        if(n==0) return 0;
        if(n==1) return 1;
        //Define the base cases F(0) = 0 and F(1) = 1
        int results;
        return results = tail_Fib(n-1) + tail_Fib(n-2);
    }
}
