import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements_658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> resultList = new ArrayList<>();

        int pivotPos = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                if (x <= arr[0]) {
                    pivotPos = 0;
                    break; //pivot pos should remain 0
                }
            } else {
                if (arr[i - 1] <= x && arr[i] >= x) {
                    pivotPos = i - 1;
                    break; //pivot pos is smaller number
                }
            }
        }

        int lowerCounter = pivotPos;
        int higherCounter = pivotPos + 1;

        for (int j = 0; j < k; j++) {
            if (lowerCounter >= 0 && higherCounter <= arr.length - 1) {
                if (x - arr[lowerCounter] <= arr[higherCounter] - x) {
                    resultList.add(0, arr[lowerCounter]);
                    lowerCounter--;
                } else {
                    resultList.add(arr[higherCounter]);
                    higherCounter++;
                }
            } else if (higherCounter <= arr.length - 1) {
                resultList.add(arr[higherCounter]);
                higherCounter++;
            } else if (lowerCounter >= 0) {
                resultList.add(0, arr[lowerCounter]);
                lowerCounter--;
            }
        }

        return resultList;
    }
}
