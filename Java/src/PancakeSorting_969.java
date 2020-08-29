import java.util.ArrayList;
import java.util.List;

public class PancakeSorting_969 {
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> result = new ArrayList<>();
        for (int i = A.length; i > 0; --i) {
            //Find index of i and store at pos
            int pos = 0;
            for (int j = i-1; j >= 0; --j) {
                if (A[j] == i) pos = j;
            }

            // Flip pos+1 elements
            if (pos != 0) {
                flip(A, pos+1);
                result.add(pos+1);
            }
            //Flip i elements
            if (i != 1) {
                flip(A, i);
                result.add(i);
            }
        }
        return result;
    }

    //Flip first k elements of array in place
    public void flip(int[] arr, int numToFlip) {
        int pos = numToFlip - 1;
        for (int i = 0; i < numToFlip/2; ++i) {
            int temp = arr[i];
            arr[i] = arr[pos-i];
            arr[pos-i] = temp;
        }
    }
}
