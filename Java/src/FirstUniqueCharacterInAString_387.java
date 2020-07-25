import java.util.HashMap;

class FirstUniqueCharacterInAString_387 {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int len = s.length();
        char c;
        for (int j = 0; j < len; ++j) {
            c = s.charAt(j);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < len; ++i) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
