import java.util.ArrayList;
import java.util.List;

class GenerateParentheses_22 {
    public List<String> generateParenthesis(int n) {
        List<String> main = new ArrayList<String>();
        listBuilder(main, "", 0, 0, n);
        return main;
    }

    void listBuilder(List<String> main, String currString, int openNum, int closedNum, int n) {
        if (currString.length() == n * 2) {
            main.add(currString);
            return;
        }
        if (openNum < n) {
            listBuilder(main, currString + "(", openNum + 1, closedNum, n);
        }
        if (closedNum < openNum) {
            listBuilder(main, currString + ")", openNum, closedNum + 1, n);
        }
    }
}