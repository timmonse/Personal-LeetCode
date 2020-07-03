import java.util.Arrays;

class TaskScheduler_621 {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) {
            return tasks.length;
        }

        Arrays.sort(tasks);
        int longestChain = 0;
        int currentChain = 1;
        int numLongest = 1;

        for (int i = 1; i < tasks.length; i++) {
            if (tasks[i - 1] == tasks[i]) {
                currentChain++;
            } else {
                currentChain = 1;
            }
            if (currentChain == longestChain) {
                numLongest++;
            } else if (currentChain > longestChain) {
                longestChain = currentChain;
                numLongest = 0;
            }
        }

        return longestChain + Math.max((longestChain - 1) * n + numLongest, (tasks.length - longestChain));

    }
}
