public class RobotBoundedInCircle_1041 {
    public boolean isRobotBounded(String instructions) {
        int[] positions = new int[4]; // UP, RIGHT, DOWN, LEFT

        int dir = 0;

        for (int i = 0; i < instructions.length(); ++i) {
            switch (instructions.charAt(i)) {
                case 'G':
                    positions[dir]++;
                    break;
                case 'L':
                    dir--;
                    break;
                case 'R':
                    dir++;
                    break;
            }
            if (dir < 0) dir = 3;
            if (dir > 3) dir = 0;
        }

        return (positions[0] - positions[2] + positions[1] - positions[3] == 0 || dir != 0);
    }
}
