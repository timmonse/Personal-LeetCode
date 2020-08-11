public class ExcelSheetColumnNumber_171 {
    public int titleToNumber(String s) {
        long result = 0;
        int last = s.length() - 1;
        for (int i = last; i >= 0; --i) {
            result += (s.charAt(i) - 'A' + 1) * Math.pow(26, last - i);
        }
        return (int) result;
    }
}
