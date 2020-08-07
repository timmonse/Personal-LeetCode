import java.util.ArrayList;
import java.util.List;

class GenerateParentheses_22 {
    List<String> main = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        rec("", n, 0);
        return main;
    }

    public void rec(String curr, int openCount, int closeCount) {
        if (openCount < 0 || closeCount < 0) return;
        if (openCount == 0 && closeCount == 0) {
            main.add(curr);
            return;
        }
        rec(curr + "(", openCount - 1, closeCount + 1);
        rec(curr + ")", openCount, closeCount - 1);
    }
}
