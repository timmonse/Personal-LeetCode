class rotateArray_189 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        int[] result;
        result = rotate(nums, k);
        System.out.println(result[0]);
    }

    public static int[] rotate(int[] nums, int k) {
        int[] result = new int[nums.length];
        int shiftedPosition;

        for(int i = 0; i < k; i++) {
            shiftedPosition = (k + i) % nums.length;
            result[i] = nums[shiftedPosition];
        }

        return result;
    }
}
