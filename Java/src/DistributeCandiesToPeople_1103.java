public class DistributeCandiesToPeople_1103 {
    class Solution {
        public int[] distributeCandies(int candies, int num_people) {
            int[] result = new int[num_people];
            int candyCount = 0;
            int totalCandies = 0;

            int index = 0;
            while(candies - totalCandies >= candyCount+1) {
                result[index] += ++candyCount;
                totalCandies += candyCount;
                index++;
                if (index == num_people) index = 0;
            }

            int remaining = candies - totalCandies;
            result[index] += remaining;

            return result;
        }
    }
}
