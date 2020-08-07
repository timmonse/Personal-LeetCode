import java.util.ArrayList;
import java.util.List;

class GenerateParentheses_22 {
    public List<String> generateParenthesis(int n) {
        List<String> main = new ArrayList<>();
        rec(main, "", n, 0);
        return main;
    }

    public void rec(List<String> main, String curr, int openCount, int closeCount) {
        if (openCount < 0 || closeCount < 0) return;
        if (openCount == 0 && closeCount == 0) {
            main.add(curr);
            return;
        }
        rec(main, curr + "(", openCount - 1, closeCount + 1);
        rec(main, curr + ")", openCount, closeCount - 1);
    }
}
