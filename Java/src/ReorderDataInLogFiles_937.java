import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReorderDataInLogFiles_937 {
    public String[] reorderLogFiles(String[] logs) {
        List<String> numberList = new ArrayList<>();
        List<String> letterList = new ArrayList<>();

        for (String log : logs) {
            String movedOrEmpty = moveOrNumber(log);
            if (movedOrEmpty.length() > 0) {
                //letter
                // Add altered log
                letterList.add(movedOrEmpty);
            } else {
                //Number
                // Add original log
                numberList.add(log);
            }
        }

        Collections.sort(letterList);

        // Reorder
        for (int i = 0; i < letterList.size(); ++i) {
            letterList.set(i, moveToFront(letterList.get(i)));
        }

        String[] result = new String[logs.length];
        int i;
        for (i = 0; i < letterList.size(); ++i) {
            result[i] = letterList.get(i);
        }
        for (int j = i; j - i < numberList.size(); ++j) {
            result[j] = numberList.get(j-i);
        }

        return result;
    }

    // If a number, move code to back
    // Otherwise return empty String
    public String moveOrNumber(String log) {
        char c = log.charAt(0);
        int i;
        for (i = 0; c != ' '; ++i) {
            c = log.charAt(i);
        }
        c = log.charAt(i);
        // If number, return empty String
        if (!Character.isLowerCase(c)) {
            return "";
        }
        return log.substring(i) + " " + log.substring(0,i-1);
    }

    // Return a String with the last value moved to the front
    public String moveToFront(String log) {
        char c = log.charAt(0);
        int i;
        for (i = log.length() - 1; c != ' '; --i) {
            c = log.charAt(i);
        }
        return log.substring(i+2) + " " + log.substring(0,i+1);
    }
}
