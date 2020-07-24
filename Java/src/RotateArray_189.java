class RotateArray_189 {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        if (k == 0 || k % len == 0) {
            return;
        }

        int i = 0;
        int old = nums[0];
        int newNum;
        int count = 0;
        int cautionValue = 0;
        while (count < len) {
            int newPos = (i + k) % len;
            newNum = nums[newPos];
            nums[newPos] = old;
            old = newNum;
            i = newPos;
            count++;
            if (i == cautionValue) {
                i += 1;
                old = nums[i];
                cautionValue = i;
            }
        }
    }
}
