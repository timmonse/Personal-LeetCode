class ClimbingStairs_70 {
    public int climbStairs(int n) {
        if (n < 3) {
            return n;
        }

        int[] waysToTop = new int[n + 1];

        waysToTop[1] = 1;
        waysToTop[2] = 2;

        for (int i = 3; i <= n; i++) {
            waysToTop[i] = waysToTop[i - 1] + waysToTop[i - 2];
        }

        return waysToTop[n];
    }
}
