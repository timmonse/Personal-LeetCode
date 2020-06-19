import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;

public class MoveZeroes_283 {

    public static void main(String[] args) {
        int[] sample = new int[]{0, 0, 1, 2, 0, 3, 0, 0, 0};
        moveZeroes(sample);
        System.out.println(Arrays.toString(sample));
    }

    public static void moveZeroes(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int num : nums) {
            if (num != 0) {
                list.add(num);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if(i < list.size()) {
                nums[i] = list.get(i);
            } else {
                nums[i] = 0;
            }
        }
    }
}
