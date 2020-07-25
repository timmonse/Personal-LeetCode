import java.util.*;

class TwoSum_1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int currNum;
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            currNum = nums[i];
            if (map.containsKey(currNum)) {
                return new int[]{map.get(currNum), i};
            }
            map.put(target - currNum, i);
        }
        return null;
    }
}
