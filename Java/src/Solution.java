class Solution {
    public int myAtoi(String str) {
        double result = 0;
        int index;
        int len = str.length();
        int sign = 1;
        
        // Eliminate beginning whitespace
        for (index = 0; index < len; index++) {
            if (str.charAt(index) != ' ') {
                break;
            }
        }
        
        if (index == len) return 0;
        
        if (str.charAt(index) == '-') {
            sign = -1;
            ++index;
        } else if (str.charAt(index) == '+') {
            ++index;
        }
        
        if (index == len) return 0;
        
        while (index <= len - 1 && (str.charAt(index) >= '0' && str.charAt(index) <= '9')) {
            result *= 10;
            result += str.charAt(index) - '0';
            index++;
        }
        
        result *= sign;
        
        // Cap result to int range
        result = (result > Integer.MAX_VALUE) ? Integer.MAX_VALUE : result;
        result = (result < Integer.MIN_VALUE) ? Integer.MIN_VALUE : result;
        return (int) result;
    }
}