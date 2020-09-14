import java.util.HashMap;
import java.util.Map;

public class DegreeOfAnArray_697 {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> startingIndex = new HashMap<>();
        int highestDegree = 0;
        int length = 0;

        int curr;
        int currLength;
        for (int i = 0; i < nums.length; ++i) {
            int num = nums[i];
            if (!startingIndex.containsKey(num)) {
                startingIndex.put(num, i);
            }
            curr = map.getOrDefault(num, 0);
            curr++;
            currLength = i - startingIndex.get(num) + 1;
            if (curr > highestDegree || (curr == highestDegree && currLength < length)) {
                highestDegree = curr;
                length = currLength;
            }
            map.put(num, curr);

        }

        return length;
    }
}
