import java.util.HashMap;
import java.util.Map;

class LongestSubStirngWithoutRepeatingCharacters_3 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charLocMap = new HashMap<>();
        int longestSubString = 0;
        int startingPos = 0;

        int sLength = s.length();
        for (int i = 0; i < sLength; i++) {
            char currentChar = s.charAt(i);
            int existingPos = charLocMap.getOrDefault(currentChar, -1);
            if (existingPos != -1 && existingPos >= startingPos) {
                startingPos = charLocMap.get(currentChar) + 1;
                charLocMap.put(currentChar, i);
            } else {
                charLocMap.put(currentChar, i);
                if (i - startingPos + 1 > longestSubString) {
                    longestSubString = i - startingPos + 1;
                }
            }
        }

        return longestSubString;
    }
}
