public class LongestCommonPrefix_14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";

        char testChar;
        for (int i = 0; i < strs[0].length(); ++i) {
            testChar = strs[0].charAt(i);
            for (int j = 1; j < strs.length; ++j) {
                if (i == strs[j].length() || strs[j].charAt(i) != testChar) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
