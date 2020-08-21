public class SortArrayByParity_905 {
    public int[] sortArrayByParity(int[] A) {
        int endIndex = A.length-1;
        int curr, temp;
        for (int i = 0; i < A.length; ++i) {
            curr = A[i];
            if (curr % 2 != 0) {
                while (A[endIndex] %2 != 0) {
                    if (endIndex<=i) {
                        return A;
                    }
                    --endIndex;
                }
                temp = curr;
                A[i] = A[endIndex];
                A[endIndex] = temp;
            }
        }
        return A;
    }
}
