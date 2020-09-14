public class LongestPalindromicSubstring_5 {
    String longest = "";

    public String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); ++i) {
            palindromeLength(s, i, i, s.substring(i, i+1));
        }
        return longest;
    }

    public void palindromeLength(String s, int left, int right, String sub) {
        if (left < 0 || right >= s.length()) {
            updateLongest(sub);
            return;
        }
        char leftChar = s.charAt(left);
        char rightChar = s.charAt(right);
        if (leftChar != rightChar) {
            updateLongest(sub);
            return;
        }
        if (left == right) {
            palindromeLength(s, left-1, right, sub);
            palindromeLength(s, left-1, right+1, sub);
            palindromeLength(s, left, right+1, sub);
        }
        // leftChar and rightChar must be equal at this point
        palindromeLength(s, left-1, right+1, s.substring(left, right+1));
    }

    public void updateLongest(String substring) {
        longest = (longest.length() < substring.length()) ? substring : longest;
    }
}
