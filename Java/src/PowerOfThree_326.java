public class PowerOfThree_326 {
    public boolean isPowerOfThree(int n) {
        double result = Math.log(n) / Math.log(3);
        System.out.println(result);
        return (Math.round(result) - result) > -0.00000000000001 && (Math.round(result) - result) < 0.00000000000001;
    }
}
