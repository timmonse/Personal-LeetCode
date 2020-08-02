import java.util.LinkedList;

public class DesignHashSet_705 {
    class MyHashSet {
        LinkedList<Integer>[] arr;
        int numBuckets = 10000;
        double load = 0.75;
        int count;

        /** Initialize your data structure here. */
        public MyHashSet() {
            arr = new LinkedList[numBuckets];
            count = 0;
        }

        public void add(int key) {
            if (contains(key)) return;
            count++;

            // Resize and rehash because of loadfactor
            if (((double) count / numBuckets) >= load) {
                resizeTo(numBuckets * 2);
            }

            if (arr[hash(key, numBuckets)] == null) arr[hash(key, numBuckets)] = new LinkedList<Integer>();
            arr[hash(key, numBuckets)].add(key);
        }

        public void remove(int key) {
            if (!contains(key)) return;
            int index = arr[hash(key, numBuckets)].indexOf(key);
            if (index != -1) {
                arr[hash(key, numBuckets)].remove(index);
                count--;
            }
        }

        /** Returns true if this set contains the specified element */
        public boolean contains(int key) {
            if (hash(key, numBuckets) >= arr.length) return false;
            LinkedList<Integer> list = arr[hash(key, numBuckets)];
            if (list == null) {
                return false;
            }
            for (int num : list) {
                if (num == key) {
                    return true;
                }
            }
            return false;
        }

        // Added by Evan Timmons
        public void resizeTo(int newSize) {
            numBuckets = newSize;
            LinkedList<Integer>[] copyOld = arr;
            arr = new LinkedList[numBuckets];
            for (int i = 0; i < copyOld.length; i++) {
                LinkedList<Integer> list = copyOld[i];
                if (list == null) continue;
                for (int num : list) {
                    add(num);
                }
            }
        }

        // Added by Evan Timmons
        public int hash(int key, int numBuckets) {
            return key % numBuckets;
        }
    }

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
}


