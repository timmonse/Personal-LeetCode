import java.util.HashSet;

public class UniqueEmailAddresses_929 {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<>();
        StringBuilder sb;
        for (String curr : emails) {
            sb = new StringBuilder();
            char currChar;
            boolean hasPlus = false;
            boolean hasAt = false;
            for (int j = 0; j < curr.length(); ++j) {
                currChar = curr.charAt(j);
                if (currChar == '+') hasPlus = true;
                else if (currChar == '@') {
                    sb.append('@');
                    hasAt = true;
                } else if (!hasPlus || hasAt) {
                    if (hasAt || currChar != '.') {
                        sb.append(currChar);
                    }
                }
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}
