import java.util.HashSet;

public class singleNumber_136 {
    public int singleNumber(int[] nums) {
        HashSet<Integer> hSet = new HashSet();

        for(int i : nums) {
            if (hSet.contains(i)) {
                hSet.remove(i);
            } else {
                hSet.add(i);
            }
        }
        return hSet.iterator().next();
    }
}
