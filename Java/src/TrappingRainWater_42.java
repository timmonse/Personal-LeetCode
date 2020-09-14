public class TrappingRainWater_42 {
    public int trap(int[] height) {
        int mainVolume = 0;
        int start = 0, end = 0;
        int startVal, currVal, endVal;

        boolean[] startArr = new boolean[height.length];
        boolean[] endArr = new boolean[height.length];

        for (int i = 0; i < height.length; ++i) {
            startVal = height[start];
            currVal = height[i];
            endVal = height[end];
            if (currVal >= startVal) {
                mainVolume += getVol(start, i, height, startArr, endArr);
                start = i;
            }
        }
        start = height.length-1;

        for (int j = height.length-1; j >= 0; --j) {
            // If dip
            startVal = height[start];
            currVal = height[j];
            endVal = height[end];
            if (currVal >= startVal) {
                mainVolume += getVol(j, start, height, startArr, endArr);
                start = j;
            }
        }

        return mainVolume;
    }

    public int getVol(int start, int end, int[] elevation, boolean[] startArr, boolean[] endArr) {
        if (Math.abs(start-end) <= 1) return 0;
        if (startArr[start] == true && endArr[end] == true) return 0;
        startArr[start] = true;
        startArr[end] = true;
        int volume = 0;
        int bound = Math.min(elevation[start], elevation[end]);
        for (int i = start + 1; i < end; ++i) {
            volume += bound - elevation[i];
        }
        return volume;
    }
}
