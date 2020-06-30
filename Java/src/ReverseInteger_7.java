class ReverseInteger_7 {
    public int reverse(int x) {
        long result = 0;
        if (x == 0) {
            return x;
        } else if (x < -2147483648 || x > 2147483647) {
            return 0;
        }

        Boolean isNegative = x < 0 ? true : false;
        if (isNegative) {
            x = x * -1;
        }

        while (x > 0) {
            result = result * 10;
            result += x % 10;
            x = x / 10;
        }

        result = isNegative ? result * -1 : result;

        if (result < -2147483648 || result > 2147483647) {
            return 0;
        }

        return (int) result;
    }
}