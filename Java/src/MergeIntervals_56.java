import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals_56 {
    public int[][] merge(int[][] intervals) {

        if (intervals == null) return null;
        if (intervals.length == 0) return new int[0][0];

        Comparator<int[]> comp = new Comparator<>(){
            @Override
            public int compare(int[] a1, int[] a2) {
                return a1[0] - a2[0];
            }
        };
        Arrays.sort(intervals, comp);

        List<int[]> result = new ArrayList<>();

        int[] curr;
        int start = intervals[0][0], end = intervals[0][1];
        for (int i = 0; i < intervals.length; ++i) {
            curr = intervals[i];
            if (curr[0] <= end) {
                end = Math.max(curr[1], end);
            } else {
                result.add(new int[]{start, end});
                start = curr[0];
                end = curr[1];
            }
            if (i == intervals.length -1) {
                result.add(new int[]{start, end});
            }
        }

        int[][] resultArr = new int[result.size()][2];
        for(int i = 0; i < result.size(); ++i) {
            int[] currArr = result.get(i);
            resultArr[i][0] = currArr[0];
            resultArr[i][1] = currArr[1];
        }
        return resultArr;
    }
}
