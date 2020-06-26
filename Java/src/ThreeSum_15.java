import java.util.*;

class ThreeSum_15 {

    public List<List<Integer>> threeSum(int[] nums) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        List<List<Integer>> resultTuples = new ArrayList<>();

        // Populate hashmap of counts
        int count;
        for (int num: nums) {
            if (countMap.containsKey(num)) {
                count = countMap.get(num);
                count++;
                countMap.put(num, count);
            } else {
                countMap.put(num, 1);
            }
        }

        HashSet<Integer> checkedNums = new HashSet<>();
        HashSet<ArrayList<Integer>> usedLists = new HashSet<>();
        ArrayList<Integer> tempList = new ArrayList<>();
        int startingNum;
        int numToFind;
        for (int i = 0; i < nums.length; i++) {
            startingNum = nums[i];

            // Ensure that no number is checked twice (for when duplicates are present)
            if (!checkedNums.contains(startingNum)) {
                // Two sum in here
                for (int j = 0; j < nums.length; j++) {
                    // Does not count if the elements are the same
                    if (i == j) {
                        continue;
                    }
                    numToFind = (nums[j] + nums[i]) * -1;
                    // Could be a valid tuple
                    if (countMap.containsKey(numToFind)) {
                        // Multiple of same number, check if count exists
                        if (nums[i] == numToFind || nums[j] == numToFind || nums[j] == nums[i]) {
                            // If all three numbers are the same
                            if (nums[i] == nums[j] && nums[i] == numToFind) {
                                // Ensure that there exists at least three of the same numbers
                                if (!(countMap.get(numToFind) >= 3)) {
                                    continue;
                                }
                            } else if (!(countMap.get(numToFind) >= 2)) {
                                continue;
                            }
                        }

                        tempList = new ArrayList<>();
                        tempList.add(nums[i]);
                        tempList.add(nums[j]);
                        tempList.add(numToFind);
                        Collections.sort(tempList);
                        if (!usedLists.contains(tempList)) {
                            usedLists.add(tempList);
                            resultTuples.add(tempList);
                        }
                    }
                }
                checkedNums.add(startingNum);
            }
        }
        return resultTuples;
    }
}
