import java.util.HashMap;

public class NumberOfGoodPairs_1512 {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int goodPairs = 0;
        for (int i = 0; i < nums.length; ++i) {
            int curr = nums[i];
            int count = hm.getOrDefault(curr, 0);
            if (count > 0) {
                goodPairs += count;
            }
            hm.put(curr, count + 1);
        }

        return goodPairs;
    }
}
