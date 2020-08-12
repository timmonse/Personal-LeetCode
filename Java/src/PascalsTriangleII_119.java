import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII_119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        if (rowIndex == 0) return list;

        List<List<Integer>> main = new ArrayList<>();
        main.add(list);
        list = new ArrayList<>();
        list.add(1);
        list.add(1);
        main.add(list);

        for (int i = 2; i <= rowIndex; ++i) {
            list = new ArrayList<>();
            list.add(1);
            for (int j = 1; j < i; ++j) {
                list.add(main.get(i-1).get(j) + main.get(i-1).get(j-1));
            }
            list.add(1);
            main.add(list);
        }

        return list;
    }
}
