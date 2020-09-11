import java.util.ArrayList;

public class ZigZagConversion_6 {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) return s;
        ArrayList<Character>[] listArr = new ArrayList[numRows];

        char curr;
        ArrayList<Character> currList;
        int rowCounter = -1; // So that the row starts at 0
        boolean isDown = true;
        for (int i = 0; i < s.length(); ++i) {
            curr = s.charAt(i);
            if (isDown) rowCounter++; // Headed "down" the rows
            else rowCounter--; // Headed "up" the rows
            if (rowCounter < 0) {
                rowCounter = 1;
                isDown = true;
            } else if (rowCounter >= numRows) {
                rowCounter = numRows - 2;
                isDown = false;
            }
            currList = (listArr[rowCounter] != null) ? listArr[rowCounter] : new ArrayList<>();
            currList.add(curr);
            listArr[rowCounter] = currList;
        }
        StringBuilder sb = new StringBuilder();
        for (ArrayList<Character> list : listArr) {
            for (char c : list) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
