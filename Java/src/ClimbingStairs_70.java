class ClimbingStairs_70 {
    static int[] memo = new int[45];
    public int climbStairs(int n) {
        if (n==1 || n==2) {
            return n;
        }
        memo[n-1] = (memo[n-1] == 0) ? climbStairs(n-1) + climbStairs(n-2) : memo[n-1];
        return memo[n-1];
    }
}
