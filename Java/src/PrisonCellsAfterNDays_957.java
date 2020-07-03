class PrisonCellsAfterNDays_957 {
    public int[] prisonAfterNDays(int[] cells, int N) {
        N = (N - 1) % 14 + 1;
        int[] cells2 = new int[8];
        cells2[0] = 0;
        cells2[7] = 0;

        for (int day = 0; day < N; day++) {
            if (day == 1) {
                cells[0] = 0;
                cells[7] = 0;
            }
            for (int cell = 1; cell < 7; cell++) {
                if (day % 2 == 0) {
                    if (cells[cell - 1] == 1 && cells[cell+1] == 1 || cells[cell - 1] == 0 && cells[cell+1] == 0) {
                        cells2[cell] = 1;
                    } else {
                        cells2[cell] = 0;
                    }
                } else {
                    if (cells2[cell - 1] == 1 && cells2[cell+1] == 1 || cells2[cell - 1] == 0 && cells2[cell+1] == 0) {
                        cells[cell] = 1;
                    } else {
                        cells[cell] = 0;
                    }
                }
            }
        }

        if (N % 2 == 0) {
            return cells;
        } else {
            return cells2;
        }
    }
}
