import java.util.*;

public class ReorderDataInLogFiles_937 {
    public String[] reorderLogFiles(String[] logs) {

        Comparator<String> comp = (s1, s2) -> {
            boolean is1Alph;
            boolean is2Alph;
            int idx1 = s1.indexOf(' ');
            int idx2 = s2.indexOf(' ');
            is1Alph = Character.isLowerCase(s1.charAt(idx1+1));
            is2Alph = Character.isLowerCase(s2.charAt(idx2+1));

            if (!is1Alph) {
                if(!is2Alph) {
                    return 0; // If both num, do nothing
                }
                return 1; // Num goes after alph
            }

            if (!is2Alph) {
                return -1;
            }

            int compared = s1.substring(idx1+1).compareTo(s2.substring(idx2+1));

            // This case is a tie so revert to first code
            if (compared == 0) {
                return s1.compareTo(s2);
            } else {
                return compared;
            }
        };


        Arrays.sort(logs, comp);
        return logs;
    }
}
