import java.util.Arrays;

class TaskScheduler_621 {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) return tasks.length;
        int max = 0;
        int maxCount = 1;
        int[] alpha = new int[26];
        int pos;

        for (char c : tasks) {
            pos = c - 'A';
            alpha[pos]++;
            if (alpha[pos] == max) maxCount++;
            if (alpha[pos] > max) {
                max = alpha[pos];
                maxCount = 1;
            }
        }

        return Math.max((max - 1) * n + max + (maxCount - 1), tasks.length);
    }
}
