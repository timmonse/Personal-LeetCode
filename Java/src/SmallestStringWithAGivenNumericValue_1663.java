public class SmallestStringWithAGivenNumericValue_1663 {
    public String getSmallestString(int n, int k) {
        int length = n;
        int value = k;

        /* There needs to be AT LEAST "length" number of a's
         * which would have the value of length added together */
        int extraVal = value - length;

        char[] result = new char[length];

        char c = 'a';
        int valToAdd = 0;
        for (int i = length-1; i >= 0; --i) {
            c = 'a';
            valToAdd = (extraVal >= 25) ? 25 : extraVal;
            c = valToChar(valToAdd);
            extraVal -= valToAdd;
            result[i] = c;
        }

        return new String(result);
    }

    // Return a char i places ahead of a
    public char valToChar(int i) {
        return (char) (i + 'a');
    }
}
