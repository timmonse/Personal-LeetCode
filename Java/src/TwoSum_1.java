import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class TwoSum_1 {
    class Element implements Comparable<Element> {
        int index, value;

        Element(int index, int value) {
            this.index = index;
            this.value = value;
        }

        public int compareTo(Element e) {
            return this.value - e.value;
        }
    }

    public int[] twoSum(int[] nums, int target) {
        List<Element> elementList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            elementList.add(new Element(i, nums[i]));
        }
        Collections.sort(elementList);
        int index1 = 0;
        int index2 = nums.length - 1;

        while (index1 != index2) {
            int currentSum = elementList.get(index1).value + elementList.get(index2).value;
            if (currentSum == target) {
                break;
            } else if (currentSum > target) {
                index2--;
            } else {
                index1++;
            }
        }

        return new int[]{elementList.get(index1).index, elementList.get(index2).index};
    }
}
