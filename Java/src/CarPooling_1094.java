import java.util.Map;
import java.util.TreeMap;

public class CarPooling_1094 {
    public boolean carPooling(int[][] trips, int capacity) {
        TreeMap<Integer, Integer> times = new TreeMap<>();

        for (int i = 0; i < trips.length; ++i) {
            int newPeople = times.getOrDefault(trips[i][1], 0);
            newPeople += trips[i][0];
            times.put(trips[i][1], newPeople);

            int leavePeople = times.getOrDefault(trips[i][2], 0);
            leavePeople -= trips[i][0];
            times.put(trips[i][2], leavePeople);
        }

        int peopleCount = 0;
        int currCount;
        for (Map.Entry<Integer, Integer> entry : times.entrySet()) {
            currCount = entry.getValue();
            peopleCount += currCount;
            if (peopleCount > capacity) return false;
        }
        return true;
    }
}
