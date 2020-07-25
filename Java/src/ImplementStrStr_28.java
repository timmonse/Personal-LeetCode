public class ImplementStrStr_28 {
    public int strStr(String haystack, String needle) {
        int len = haystack.length();
        int nLen = needle.length();
        if (nLen == 0) return 0;
        if (nLen > len) return -1;
        int index = 0;
        int nIndex = 0;
        for (int i = 0; i < len; i++) {
            index = i;
            while (index < len && nIndex < nLen && (haystack.charAt(index) == needle.charAt(nIndex))) {
                if (nIndex == nLen - 1) {
                    return i;
                }
                index++;
                nIndex++;
            }
            nIndex = 0;
        }
        return -1;
    }
}


