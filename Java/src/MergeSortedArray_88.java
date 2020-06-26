import java.util.ArrayList;

class MergeSortedArray_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        ArrayList<Integer> mergedList = new ArrayList<Integer>();

        int oneCounter = 0;
        int twoCounter = 0;

        while (oneCounter < m || twoCounter < n) {
            if (twoCounter == n) {
                mergedList.add(nums1[oneCounter]);
                oneCounter++;
            } else if (oneCounter == m) {
                mergedList.add(nums2[twoCounter]);
                twoCounter++;
            } else {
                if (nums1[oneCounter] < nums2[twoCounter]) {
                    mergedList.add(nums1[oneCounter]);
                    oneCounter++;
                } else {
                    mergedList.add(nums2[twoCounter]);
                    twoCounter++;
                }
            }
        }

        for (int i = 0; i < mergedList.size(); i++) {
            nums1[i] = mergedList.get(i);
        }
    }
}
