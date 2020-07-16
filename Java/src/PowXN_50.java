public class PowXN_50 {
    public double myPow(double x, int n) {
        if (n == Integer.MIN_VALUE) {
            return (1 / x) * myPow(x, n + 1);
        }
        if (n < 0) {
            x = 1 / x;
        }
        n = Math.abs(n);
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return x;
        } else if (n % 2 == 0) {
            return myPow(x * x, n / 2);
        } else {
            return myPow(x * x, (n - 1) / 2) * x;
        }
    }
}
