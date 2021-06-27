public class PalindromNumber_9 {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x == 0) return true;

        int reverse = 0;
        int copy = x;

        while (copy > 0) {
            reverse *= 10;
            reverse += copy % 10;
            copy /= 10;
        }

        return reverse == x;
    }
}
