class RemoveDuplicatesFromSortedArray_26 {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int replacementIndex = 0;
        for(int i = 1; i < length; i++) {
            if (nums[i] != nums[replacementIndex]) {
                replacementIndex++;
                nums[replacementIndex] = nums[i];
            }
        }
        return replacementIndex + 1;
    }
}