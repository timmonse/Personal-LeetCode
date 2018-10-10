class Solution {
    public int removeDuplicates(int[] nums) {
        // Counts the amount of unique numbers
        // Assumes one unique number
        int uniqueNum = 1;

        // Length of original number array
        int numLength = nums.length;

        if(numLength == 0){
            return 0;
        }

        // Iterates through array once
        for(int i = 1; i < numLength; i++){
            // Checks for a unique number
            if(nums[i] != nums[i - 1]){
                // Adds the number and increments the count
                nums[uniqueNum] = nums[i];
                uniqueNum ++;
            }
        }

        return uniqueNum;
    }
}