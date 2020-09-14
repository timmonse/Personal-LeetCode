import java.util.Arrays;

public class HouseRobber_198 {
    int[] memo;
    public int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return robRec(nums, 0);
    }

    public int robRec(int[] nums, int pos) {
        if (pos >= nums.length) return 0;
        if (memo[pos] > -1) return memo[pos];
        int max = Math.max(nums[pos] + robRec(nums, pos+2), robRec(nums, pos+1));
        memo[pos] = max;
        return max;
    }
}
