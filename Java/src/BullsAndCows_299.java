import java.util.HashMap;

public class BullsAndCows_299 {
    public String getHint(String secret, String guess) {
        HashMap<Character, Integer> hm = new HashMap<>();

        char[] guessArr = guess.toCharArray();

        int bullCount = 0;
        int cowCount = 0;

        char currSecret, currGuess;
        int currCount = 0;
        // Store chars and their counts in the map
        // Do not store bulls, instead count and skip
        for (int i = 0; i < secret.length(); ++i) {
            currSecret = secret.charAt(i);
            currGuess = guessArr[i];
            if (currSecret == currGuess) {
                guessArr[i] = '#';
                bullCount++;
                continue;
            }
            hm.put(currSecret, hm.getOrDefault(currSecret, 0) + 1);
        }

        currCount = 0;
        // Count cows
        for (char curr : guessArr) {
            if (curr == '#') continue;
            currCount = hm.getOrDefault(curr, 0);
            if (currCount > 0) {
                cowCount++;
                currCount--;
                hm.put(curr, currCount);
            }
        }

        // Print result
        return bullCount + "A" + cowCount + "B";

    }
}
