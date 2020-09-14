import java.util.Arrays;
import java.util.Comparator;

public class ContainsDuplicateIII_220 {
    class Item {
        long index;
        long val;
        Item(long index, long val) {
            this.index = index;
            this.val = val;
        }
    }
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        Item[] arr = new Item[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            Item temp = new Item(i, nums[i]);
            arr[i] = temp;
        }

        Comparator<Item> comp = new Comparator<>(){
            @Override
            public int compare(Item i1, Item i2) {
                long temp = i1.val - i2.val;
                return (int) temp;
            }
        };

        Arrays.sort(arr, comp);

        for (int i = 0; i < arr.length; ++i) {
            Item item = arr[i];
            for (int j = i + 1; j < arr.length; ++j) {
                Item neigh = arr[j];
                long temp = neigh.val - item.val;
                if (temp <= t && temp <= Integer.MAX_VALUE && temp > Integer.MIN_VALUE) {
                    if (Math.abs(neigh.index - item.index) <= k) {
                        return true;
                    }
                } else {
                    break;
                }
            }
        }
        return false;
    }
}
