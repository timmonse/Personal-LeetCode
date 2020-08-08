public class ReverseBits_190 {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int reversed = 0;

        for (int i = 32; i > 0; --i) {
            reversed = reversed<<1;
            reversed += n&1;
            n = n>>1;
        }

        return reversed;
    }
}
