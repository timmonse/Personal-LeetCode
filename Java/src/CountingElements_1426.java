import java.util.HashSet;

public class CountingElements_1426 {
    public int countElements(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        int total = 0;
        for (int num : arr) {
            set.add(num-1);
        }

        for (int num : arr) {
            if (set.contains(num)) {
                total++;
            }
        }
        return total;
    }
}
