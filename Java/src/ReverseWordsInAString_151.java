public class ReverseWordsInAString_151 {
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        String r;
        if (arr.length > 0) {
            r = arr[arr.length - 1];
        } else {
            return "";
        }
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i].length() > 0) {
                r = r + " " + arr[i];
            }
        }
        return r;
    }
}
