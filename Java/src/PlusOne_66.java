import java.util.ArrayList;
import java.util.Arrays;

public class PlusOne_66 {
    public static void main(String[] args) {
        //System.out.println(Arrays.toString(plusOne(new int[]{9,8,7,6,5,4,3,2,1,0})));
        System.out.println(Arrays.toString(plusOne(new int[]
                {9})));
    }

    public static int[] plusOne(int[] digits) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int temp = 0;
        int isTen = 0;

        for (int i = digits.length - 1; i >= 0; i--) {
            if(i == digits.length - 1) {
                temp = digits[i] + isTen + 1;
            } else {
                temp = digits[i] + isTen;
            }
            if (temp == 10) {
                isTen = 1;
                temp = 0;
            } else {
                isTen = 0;
            }
            result.add(0, temp);
        }
        if (isTen > 0) {
            result.add(0, 1);
        }

        int[] resultArray = new int[result.size()];
        for (int j = 0; j < result.size(); j++) {
            resultArray[j] = result.get(j);
        }

        return resultArray;
    }
}
