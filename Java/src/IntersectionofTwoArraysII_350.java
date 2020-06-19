import java.util.ArrayList;
import java.util.Arrays;

public class IntersectionofTwoArraysII_350 {
    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> resultList = new ArrayList<Integer>();
        int[] resultArray;
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int oneCount = 0;
        int twoCount = 0;
        int num1, num2;

        while (twoCount < nums2.length && oneCount < nums1.length) {
            num1 = nums1[oneCount];
            num2 = nums2[twoCount];
            if (num1 == num2) {
                resultList.add(nums1[oneCount]);
                oneCount++;
                twoCount++;
            } else if (num1 > num2) {
                twoCount++;
            } else {
                oneCount++;
            }
        }

        resultArray = new int[resultList.size()];
        for(int i = 0; i < resultList.size(); i++) {
            resultArray[i] = resultList.get(i);
        }
        return resultArray;
    }
}
