import java.util.Arrays;

public class ArrayPartitionI_561 {
    public int arrayPairSum(int[] nums) {
        int res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i+=2) {
            res += nums[i];
        }
        return res;
    }
}
