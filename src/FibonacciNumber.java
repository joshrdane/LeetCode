public class FibonacciNumber {
    public static int fib(int n) {
        return switch (n) {
            case 0 -> 0;
            case 1 -> 1;
            default -> fib(n - 1) + fib(n - 2);
        };
    }
}
