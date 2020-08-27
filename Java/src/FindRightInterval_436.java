
import java.util.Map;
import java.util.TreeMap;

public class FindRightInterval_436 {
    public int[] findRightInterval(int[][] intervals) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int[] result = new int[intervals.length];
        for (int i = 0; i < intervals.length; ++i) {
            treeMap.put(intervals[i][0], i);
        }
        for (int i = 0; i < intervals.length; ++i) {
            Map.Entry<Integer, Integer> entry = treeMap.ceilingEntry(intervals[i][1]);
            result[i] = (entry != null) ? entry.getValue() : -1;
        }
        return result;
    }
}
