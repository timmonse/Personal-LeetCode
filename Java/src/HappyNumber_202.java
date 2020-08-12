import java.util.HashSet;
import java.util.Set;

public class HappyNumber_202 {
    Set<Integer> seen = new HashSet<>();
    public boolean isHappy(int n) {
        int result = 0;
        if (seen.contains(n)) return false; // Will loop
        seen.add(n);

        while (n > 0) {
            result += (n % 10) * (n % 10);
            n = n / 10;
        }

        if (result == 1)
            return true;
        else
            return isHappy(result);
    }
}
