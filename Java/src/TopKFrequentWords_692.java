import java.util.*;

public class TopKFrequentWords_692 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < words.length; ++i) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }

        List<String> result = new ArrayList<>(map.keySet());

        Comparator<String> comp = new Comparator<>() {
            @Override
            public int compare(String s1, String s2) {
                int count1 = map.get(s1);
                int count2 = map.get(s2);
                if (count1 != count2) return count2 - count1;
                else return s1.compareTo(s2);
            }
        };

        Collections.sort(result, comp);

        return result.subList(0,k);
    }
}
