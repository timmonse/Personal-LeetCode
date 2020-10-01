import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisitCount_811 {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> result = new ArrayList<>();
        HashMap<String, Integer> countMap = new HashMap<>();


        for (String string : cpdomains) {
            String[] split = string.split(" ");
            String domain = split[1];
            int currCount = Integer.parseInt(split[0]);

            // Put in full domain
            countMap.put(domain, countMap.getOrDefault(domain, 0) + currCount);

            while (domain.indexOf('.') > 0) {
                domain = domain.substring(domain.indexOf('.') + 1);
                countMap.put(domain, countMap.getOrDefault(domain, 0) + currCount);
            }
        }

        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            result.add(entry.getValue() + " " + entry.getKey());
        }

        return result;
    }
}
