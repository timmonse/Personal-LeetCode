import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SingleNumber_136 {
    public int singleNumber(int[] nums) {
        Set<Integer> appeared = new HashSet<>();

        for (int num : nums) {
            if (appeared.contains(num)) {
                appeared.remove(num);
            } else {
                appeared.add(num);
            }
        }

        Iterator iter = appeared.iterator();
        return (int) iter.next();
    }
}
