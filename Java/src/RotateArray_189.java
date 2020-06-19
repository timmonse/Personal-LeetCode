class RotateArray_189 {
    public static void rotate(int[] nums, int k) {
        int[] result = new int[nums.length];
        int shiftedPosition;

        for(int i = 0; i < nums.length; i++) {
            shiftedPosition = (k + i) % nums.length;
            result[shiftedPosition] = nums[i];
        }

        System.arraycopy(result, 0, nums, 0, nums.length);
    }
}
