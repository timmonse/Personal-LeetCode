public class BuddyStrings_859 {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) return false;
        char aSwap = ' ';
        char bSwap = ' ';
        boolean firstSwap = false;
        boolean swapped = false;
        boolean twoChars = false;
        int[] chars = new int[26];

        for (int i = 0; i < A.length(); ++i) {
            char currA = A.charAt(i);
            char currB = B.charAt(i);

            chars[currA-'a']++;
            if (chars[currA-'a'] > 1) twoChars = true;

            if (currA != currB) {
                if (swapped) return false; // Mis placed char after swap already found
                if (!firstSwap) {
                    aSwap = currA;
                    bSwap = currB;
                    firstSwap = true;
                } else {
                    if (currB != aSwap || currA != bSwap) {
                        return false;
                    }
                    swapped = true;
                }
            }
        }
        return swapped || (twoChars && !(firstSwap && !swapped));
    }
}
