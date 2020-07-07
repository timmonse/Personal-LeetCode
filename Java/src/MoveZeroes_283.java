import java.lang.reflect.Array;
import java.util.*;

public class MoveZeroes_283 {

    public static void main(String[] args) {
        int[] sample = new int[]{1,1};
        moveZeroes(sample);
        System.out.println(Arrays.toString(sample));
    }

    public static void moveZeroes(int[] nums) {
        int nonZeroCount = 0;
        int zeroCount = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                nums[nonZeroCount] = nums[i];
                nonZeroCount++;
            } else {
                zeroCount++;
            }
        }
        for (int j = len - zeroCount; j < len; j++) {
            nums[j] = 0;
        }
    }
}
