public class CheckIfAWordOccursAsAPrefixOfAnyWordInASentence_1455 {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] split = sentence.split(" ");

        for (int i = 0; i < split.length; ++i) {
            boolean isEqual = true;
            for (int j = 0; j < searchWord.length(); ++j) {
                if (j > searchWord.length() - 1) break;
                if (j > split[i].length() - 1) {
                    isEqual = false;
                    break;
                }
                if (split[i].charAt(j) != searchWord.charAt(j)) {
                    isEqual = false;
                    break;
                }
            }
            if (isEqual) {
                return i + 1;
            }
        }
        return -1;
    }
}
