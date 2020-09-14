import java.util.HashMap;

public class WordPattern_290 {
    public boolean wordPattern(String pattern, String str) {
        HashMap<String, Character> mapToChar = new HashMap<>();
        HashMap<Character, String> mapToWord = new HashMap<>();
        String[] strArr = str.split(" ");

        if (pattern.length() != strArr.length) return false;

        for (int i = 0; i < pattern.length(); ++i) {
            char currChar = pattern.charAt(i);
            String currWord = strArr[i];

            if (mapToWord.containsKey(currChar) || mapToChar.containsKey(currWord)) {
                if (currChar != mapToChar.getOrDefault(currWord, ' ')) return false;
                if (!(currWord.equals(mapToWord.getOrDefault(currChar, "")))) return false;
            } else {
                mapToChar.put(currWord, currChar);
                mapToWord.put(currChar, currWord);
            }
        }

        return true;
    }
}
