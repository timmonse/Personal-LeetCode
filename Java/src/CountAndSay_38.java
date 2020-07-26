public class CountAndSay_38 {
    public String countAndSay(int n) {
        return build(Integer.toString(n));
    }

    public String build(String s) {
        if (s.equals("1")) return s;
        String past = build(Integer.toString(Integer.parseInt(s) - 1));

        StringBuilder sb = new StringBuilder();

        int index;
        int count = 1;
        for (int i = 0; i < past.length(); ++i) {
            index = i + 1;
            while (index < past.length() && past.charAt(i) == past.charAt(index)) {
                count++;
                index++;
            }
            sb.append(count);
            sb.append(past.charAt(i));
            i = (index > i+1) ? index - 1 : i;
            count = 1;
        }
        String result = sb.toString();

        return result;
    }
}
