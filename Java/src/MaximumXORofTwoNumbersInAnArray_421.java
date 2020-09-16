import java.util.ArrayList;
import java.util.Arrays;

public class MaximumXORofTwoNumbersInAnArray_421 {
    public int findMaximumXOR(int[] nums) {
        if (nums.length < 2) return 0; // Need to nums to xor
        if (nums.length == 2) return nums[0] ^ nums[1];

        //Sort nums
        Arrays.sort(nums);

        int largest = nums[nums.length - 1];
        int twoPower = (int) Math.pow(2.0, (int) (Math.log(largest) / Math.log(2)));

        ArrayList<Integer> largeNums = new ArrayList<>();
        largeNums.add(largest);
        for (int i = nums.length - 2; i >= 0; --i) {
            if (nums[i] >= twoPower) largeNums.add(nums[i]);
            else break;
        }

        int xorMax = 0;

        for (int number : largeNums) {
            for (int j = nums.length - 1; j >= 0; --j) {
                int temp = number ^ nums[j];
                if (temp > xorMax) xorMax = temp;
            }
        }

        return xorMax;
    }
}
