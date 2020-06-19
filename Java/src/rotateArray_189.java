class rotateArray_189 {
    public static void rotate(int[] nums, int k) {
        int[] result = new int[nums.length];
        int shiftedPosition;

        for(int i = 0; i < nums.length; i++) {
            shiftedPosition = (k + i) % nums.length;
            result[shiftedPosition] = nums[i];
        }

        for (int j = 0; j < nums.length; j++) {
            nums[j] = result[j];
        }
    }
}
