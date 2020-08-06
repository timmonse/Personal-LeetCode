import java.util.HashSet;
import java.util.Set;

public class HappyNumber_202 {
    public boolean isHappy(int n) {
        Set<Integer> seenNums = new HashSet<>();
        return isOneEnd(seenNums, n);
    }

    boolean isOneEnd(Set<Integer> set, int n) {
        int newNum = 0;
        int temp;
        while (n > 0) {
            temp = n % 10;
            newNum += temp * temp;
            n /= 10;
        }
        if (set.contains(newNum)) {
            return false;
        } else {
            set.add(newNum);
        }
        if (newNum == 1) {
            return true;
        } else {
            return isOneEnd(set, newNum);
        }
    }
}
