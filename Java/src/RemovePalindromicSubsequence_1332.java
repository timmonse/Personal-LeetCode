public class RemovePalindromicSubsequence_1332 {
    public int removePalindromeSub(String s) {
        if (s.length() == 0) return 0;
        if (isPalindrome(s)) return 1;
        return 2;
    }

    public boolean isPalindrome(String s) {
        int first = 0;
        int last = s.length() - 1;
        while (first < last) {
            if (s.charAt(first) != s.charAt(last)) return false;
            ++first;
            --last;
        }
        return true;
    }
}
