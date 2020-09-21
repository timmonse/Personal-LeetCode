import java.util.Arrays;
import java.util.Comparator;

public class MostProfitAssigningWork_826 {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int maxProfit = 0;
        Arrays.sort(worker); //Sort the workers by difficulty

        int[][] profitDiff = new int[profit.length][2];

        for (int i = 0; i < profit.length; ++i) {
            profitDiff[i] = new int[]{profit[i], difficulty[i]};
        }

        Comparator<int[]> comp = new Comparator<>(){
            @Override
            public int compare(int[] one, int[] two) {
                return two[0] - one[0]; //sort by decreasing profit
            }
        };
        Arrays.sort(profitDiff, comp);

        int currWorker;
        int counter = 0;
        for (int i = worker.length - 1; i >= 0; --i) {
            currWorker = worker[i];
            while (counter < profit.length - 1 && profitDiff[counter][1] > currWorker) {
                counter++;
            }
            if (profitDiff[counter][1] <= currWorker) maxProfit += profitDiff[counter][0];
        }
        return maxProfit;
    }
}
