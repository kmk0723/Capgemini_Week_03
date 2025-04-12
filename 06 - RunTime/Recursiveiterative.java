public class Recursiveiterative {
    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static int fibonacciIterative(int n) {
        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {
        int n=10;
        long s=System.nanoTime();
        fibonacciRecursive(n);
        long e=System.nanoTime();
        System.out.println("Time taken for Recursive Fibonaci: "+(e-s));
        s=System.nanoTime();
        fibonacciIterative(n);
        e=System.nanoTime();
        System.out.println("Time taken for Iterative Fibonaci: "+(e-s));



    }


}
