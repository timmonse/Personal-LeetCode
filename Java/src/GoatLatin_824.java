public class GoatLatin_824 {
    public String toGoatLatin(String S) {
        String[] strArr = S.split(" ");
        StringBuilder sbMain = new StringBuilder();
        StringBuilder sb;
        for (int i = 0; i < strArr.length; ++i) {
            sb = new StringBuilder(strArr[i]);
            sbMain.append(wordToGoat(sb));
            if (i != strArr.length - 1) sbMain.append(" ");
        }
        return sbMain.toString();
    }

    public String wordToGoat(StringBuilder sb) {
        char firstLetter = sb.charAt(0);
        if (!isVowel(firstLetter) && sb.length() != 1) {
            sb = new StringBuilder(sb.substring(1) + firstLetter);
        }
        sb.append("ma");
        return addAs(sb);
    }

    private StringBuilder a = new StringBuilder();

    public String addAs(StringBuilder sb) {
        a.append('a');
        sb.append(a);
        return sb.toString();
    }

    public boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
