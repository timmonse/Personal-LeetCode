public class FindPivotIndex_724 {
    public int pivotIndex(int[] nums) {
        int[] backwards = new int[nums.length];

        int sum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            backwards[i] = sum;
            sum += nums[i];
        }

        sum = 0;
        for (int j = 0; j < nums.length; j++) {
            if (sum == backwards[j]) {
                return j;
            }
            sum += nums[j];
        }

        return -1;
    }
}
