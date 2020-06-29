import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

class GroupAnagrams_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> resultList = new ArrayList<>();
        LinkedHashMap<String, List<String>> sortedMap = new LinkedHashMap<>();

        char[] strArray;
        String sortedString;
        List<String> anagramList;
        for (String str: strs) {
            strArray = str.toCharArray();
            Arrays.sort(strArray);
            sortedString = new String(strArray);

            if (!sortedMap.containsKey(sortedString)) {
                anagramList = new ArrayList<String>();
            } else {
                anagramList = sortedMap.get(sortedString);
            }

            anagramList.add(str);
            sortedMap.put(sortedString, anagramList);
        }

        for (String key: sortedMap.keySet()) {
            resultList.add(sortedMap.get(key));
        }

        return resultList;
    }
}
