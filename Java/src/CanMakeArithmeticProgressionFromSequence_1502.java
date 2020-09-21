import java.util.Arrays;

public class CanMakeArithmeticProgressionFromSequence_1502 {
    public boolean canMakeArithmeticProgression(int[] arr) {
        if (arr.length < 3) return true;

        Arrays.sort(arr);
        int difference = arr[1] - arr[0];

        for (int i = 1; i < arr.length - 1; ++i) {
            if (arr[i+1] - arr[i] != difference) return false;
        }

        return true;
    }
}
