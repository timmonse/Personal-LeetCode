import java.lang.reflect.Array;
import java.util.*;

public class MoveZeroes_283 {

    public static void moveZeroes(int[] nums) {
        int nonZeroCount = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                nums[nonZeroCount] = nums[i];
                if (i != nonZeroCount) nums[i] = 0;
                nonZeroCount++;
            }
        }
    }
}
