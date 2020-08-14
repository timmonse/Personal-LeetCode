public class LongestPalindrome_409 {
    public int longestPalindrome(String s) {
        int[] main = new int[128];
        char[] charArr = s.toCharArray();

        int singleCount = 0;

        for (char c : charArr) {
            main[c]++;
        }

        for (int count : main) {
            if (count % 2 != 0){
                singleCount++;
            }
        }

        return (singleCount > 0) ? charArr.length - singleCount + 1 : charArr.length;
    }
}
