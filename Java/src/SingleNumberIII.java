import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        Set<Integer> singleNums = new HashSet<Integer>();

        for (int num : nums) {
            if (singleNums.contains(num)) {
                singleNums.remove(num);
            } else {
                singleNums.add(num);
            }
        }

        int[] result = new int[2];
        Iterator<Integer> it = singleNums.iterator();
        result[0] = it.next();
        result[1] = it.next();
        return result;
    }
}
