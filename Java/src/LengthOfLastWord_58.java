public class LengthOfLastWord_58 {
    public int lengthOfLastWord(String s) {
        int len = 0;

        int startPoint = s.length() - 1;
        while (startPoint >= 0 && s.charAt(startPoint) == ' ') {
            --startPoint;
        }

        for (int i = startPoint; i >= 0; --i) {
            char curr = s.charAt(i);
            if (curr == ' ') {
                break;
            }
            len++;
        }
        return len;
    }
}
