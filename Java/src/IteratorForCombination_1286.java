import java.util.LinkedList;

public class IteratorForCombination_1286 {
    LinkedList<String> list;

    public IteratorForCombination_1286(String characters, int combinationLength) {
        list = new LinkedList<>();
        char[] charArr = characters.toCharArray();
        createList(charArr, 0, "", combinationLength);
    }

    public void createList(char[] chars, int index, String curr, int length) {
        if (chars.length - index < length) return; // Not enough room for another combination
        if (length == 0) {
            list.add(curr);
        }
        for (int i = index; i < chars.length; ++i) {
            createList(chars, i + 1, curr + chars[i], length - 1);
        }
    }

    public String next() {
        String next = list.getFirst();
        list.remove(0);
        return next;
    }

    public boolean hasNext() {
        return list.size() > 0;
    }
}
