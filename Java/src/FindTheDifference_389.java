public class FindTheDifference_389 {
    public char findTheDifference(String s, String t) {
        int[] arr = new int[26];
        char currT, currS;
        for (int j = 0; j < s.length(); ++j) {
            currS = s.charAt(j);
            arr[currS - 'a']++;

        }
        for (int i = 0; i < t.length(); ++i) {
            currT = t.charAt(i);
            arr[currT - 'a']--;
            if (arr[currT - 'a'] < 0) return currT;
        }

        return ' ';
    }
}
