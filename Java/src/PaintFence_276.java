public class PaintFence_276 {
    public int numWays(int n, int k) {
        if (n == 0) return 0;
        if (n == 1) return k;
        int[] ways = new int[n];
        ways[0] = k;
        ways[1] = k*k;


        for (int i = 2; i < n; ++i) {
            ways[i] = ways[i-1] * (k-1); // Number of ways to paint diff
            ways[i] += ways[i-2] * (k-1); // Number of ways to paint the same
        }

        return ways[n-1];
    }
}
