class ReverseInteger_7 {
    public int reverse(int x) {
        long reversed = 0;
        boolean negative = (x < 0);
        x = Math.abs(x);

        while (x > 0) {
            reversed = reversed * 10;
            reversed += x % 10;
            x = x / 10;
        }

        if (negative) {
            reversed = -reversed;
            if (reversed < Integer.MIN_VALUE) {
                reversed = 0;
            }
        }
        if (reversed > Integer.MAX_VALUE) {
            reversed = 0;
        }

        return (int) reversed;
    }
}
