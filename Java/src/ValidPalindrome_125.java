public class ValidPalindrome_125 {
    public boolean isPalindrome(String s) {
        int i1 = 0;
        int i2 = s.length() - 1;
        char char1, char2;

        while (i1 <= i2) {
            char1 = s.charAt(i1);
            char2 = s.charAt(i2);
            if (!isAlphaNum(char1)) {
                i1++;
                continue;
            } else if (!isAlphaNum(char2)) {
                i2--;
                continue;
            } else if (Character.toLowerCase(char1) != Character.toLowerCase(char2)) {
                return false;
            }
            i1++;
            i2--;
        }

        return true;
    }

    public boolean isAlphaNum(char c) {
        if ((c >= 48 && c <= 57) || (c >= 65 && c <= 90) || (c >= 97 && c <= 122)) {
            return true;
        }
        return false;
    }
}
