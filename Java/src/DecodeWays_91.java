public class DecodeWays_91 {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) - '0' > 0 ? 1 : 0;

        for (int i = 2; i < s.length() + 1; ++i) {
            if (s.charAt(i-1) - '0' > 0) {
                dp[i] += dp[i-1];
            }
            int i1 = Integer.parseInt(s.substring(i - 2, i));
            if (i1 <= 26 && i1 >= 10) {
                dp[i] += dp[i-2];
            }
        }
        return dp[dp.length-1];
    }
}
