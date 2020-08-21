public class MedianOfTwoSortedArrays_4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int num1Length = nums1.length;
        int num2Length = nums2.length;
        int length = nums1.length + nums2.length;
        boolean isEven = (length) % 2 == 0;

        int i1 = 0;
        int i2 = 0;
        int value = 0, val1 = 0, val2 = 0;
        for (int i = 0; i < length/2; ++i) {
            val1 = (i1 < num1Length) ? nums1[i1] : val1;
            val2 = (i2 < num2Length) ? nums2[i2] : val2;
            if (i2 == num2Length || (val1 <= val2 && i1 != num1Length)) {
                value = nums1[i1];
                ++i1;
            } else {
                value = nums2[i2];
                ++i2;
            }
        }

        int value2;
        if (i1 == num1Length) value2 = nums2[i2];
        else if (i2 == num2Length) value2 = nums1[i1];
        else {
            val1 = nums1[i1];
            val2 = nums2[i2];
            value2 = Math.min(val1,val2);
        }
        if (!isEven) return value2;
        return ((double) value / 2) + ((double) value2 / 2);
    }
}
