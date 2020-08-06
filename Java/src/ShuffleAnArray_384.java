import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShuffleAnArray_384 {
    class Solution {
        int[] main;

        public Solution(int[] nums) {
            main = nums;
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            return main;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            List<Integer> list = new ArrayList<>();
            int[] result = new int[main.length];

            for (int i = 0; i < main.length; ++i) {
                list.add(main[i]);
            }

            Random rand = new Random();

            for (int i = 0; i < main.length; ++i) {
                int n = rand.nextInt(list.size());
                result[i] = list.get(n);
                list.remove(n);
            }

            return result;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
}
