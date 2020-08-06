public class DetectCapital_520 {
    public boolean detectCapitalUse(String word) {
        boolean firstUpper = Character.isUpperCase(word.charAt(0));
        boolean fullUpper = true;
        boolean fullLower = true;
        for (int i = 1; i < word.length(); ++i) {
            if (Character.isUpperCase(word.charAt(i))) {
                fullLower = false;
            } else {
                fullUpper = false;
            }
        }
        return fullUpper && firstUpper || fullLower && firstUpper || fullLower && !firstUpper;
    }
}
