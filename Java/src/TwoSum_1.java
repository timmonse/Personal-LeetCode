import java.util.*;

class TwoSum_1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> locationValueMap = new HashMap<>();
        int currentNum;
        for (int i = 0; i < nums.length; i++) {
            currentNum = nums[i];
            if (locationValueMap.containsKey(target - currentNum)) {
                return new int[]{locationValueMap.get(target - currentNum), i};
            }
            locationValueMap.put(currentNum, i);
        }
        return null;
    }
}
