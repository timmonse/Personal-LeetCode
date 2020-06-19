import java.lang.reflect.Array;
import java.util.*;

public class MoveZeroes_283 {

    public static void main(String[] args) {
        int[] sample = new int[]{1,1};
        moveZeroes(sample);
        System.out.println(Arrays.toString(sample));
    }

    public static void moveZeroes(int[] nums) {
        Queue<Integer> numQueue = new LinkedList<>();
        Queue<Integer> replaceIndexQ = new LinkedList<>();
        int replaceIndex = 0;


        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                numQueue.add(nums[i]);
                replaceIndexQ.add(replaceIndex);
                replaceIndex++;
            }

            if (!numQueue.isEmpty()) {
                nums[i] = 0;
                nums[replaceIndexQ.poll()] = numQueue.poll();
            }
        }
    }
}
