public class AngleBetweenHandsOfAClock_1344 {
    public double angleClock(int hour, int minutes) {
        double bigDeg = 0;
        double smallDeg = (double) minutes * 6.0; //(360.0 / 60.0) = 6.0
        double hourRatio = minutes / 60.0;
        double extraDeg = 30 * hourRatio;
        bigDeg = (double) hour * 30.0 + extraDeg; //(360.0 / 12.0) = 30.0
        bigDeg = (bigDeg > 360.0) ? bigDeg - 360.0 : bigDeg;

        double angle = Math.max(smallDeg, bigDeg) - Math.min(smallDeg, bigDeg);
        angle = (angle > 180) ? 360 - angle : angle;
        return angle;
    }
}
