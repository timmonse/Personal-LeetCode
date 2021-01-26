import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class LongestConsecutiveSequence_128 {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, List<Integer>> beg = new HashMap<>();
        HashMap<Integer, List<Integer>> end = new HashMap<>();

        HashSet<List<Integer>> lists = new HashSet<>();

        List<Integer> l;
        for (int num : nums) {
            if (beg.containsKey(num)) {
                l = beg.get(num);
                lists.remove(l);
                l.add(0, num);
                beg.remove(num);
                beg.put(num - 1, l);
                lists.add(l);
            } else {
                l = new ArrayList<>();
                l.add(num);
                beg.put(num-1, l);
                lists.add(l);
            }
            if (end.containsKey(num)) {
                l = end.get(num);
                lists.remove(l);
                l.add(num);
                end.remove(num);
                end.put(num + 1, l);
                lists.add(l);
            } else {
                l = new ArrayList<>();
                l.add(num);
                end.put(num+1, l);
                lists.add(l);
            }
        }

        for(List<Integer> list : lists) {
            System.out.println(list);
        }

        return -1;
    }
}
