class MaxConsecutiveOnes_485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxOnes = 0;
        int currOnes = 0;
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 0) {
            return 0;
        }

        if(nums[0] == 1) {
            currOnes = 1;
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 1 && nums[i-1] == 1) {
                currOnes++;
            } else if (nums[i] == 1 && nums[i-1] == 0) {
                currOnes = 1;
            } else {
                if (currOnes > maxOnes) {
                    maxOnes = currOnes;
                }
                currOnes = 0;
            }
        }

        if (currOnes > maxOnes) {
            maxOnes = currOnes;
        }

        return maxOnes;
    }
}
