import java.util.Arrays;

public class PlusOne_66 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{100})));
    }

    // Could be improved speed wise by only making a new array if necessary
    public static int[] plusOne(int[] digits) {
        int arrayToInt = 0;

        for (int digit : digits) {
            arrayToInt *= 10;
            arrayToInt += digit;
        }

        arrayToInt += 1;

        String stringNum = Integer.toString(arrayToInt);
        int[] result = new int[stringNum.length()];
        for(int j = 0; j < stringNum.length(); j++) {
            result[j] = Character.getNumericValue(stringNum.charAt(j));
        }

        return result;
    }
}
