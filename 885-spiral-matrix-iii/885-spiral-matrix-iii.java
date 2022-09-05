class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int number = 0;
        int[][] result = new int[rows * cols][cols];
        result[number++] = new int[]{rStart, cStart};
        int size = 1;
        cStart++;
        while (number < rows * cols) {
            for (int i = cStart; i < cStart + size; i++) {
                if (!isIn(rows, cols, rStart, i)) {
                    continue;
                }
                result[number++] = new int[]{rStart, i};
            }
            cStart = cStart + size - 1;
            rStart++;
            for (int i = rStart; i < rStart + size; i++) {
                if (!isIn(rows, cols, i, cStart)) {
                    continue;
                }
                result[number++] = new int[]{i, cStart};
            }
            rStart = rStart + size - 1;
            cStart--;
            for (int i = cStart; i >= cStart - (size); i--) {
                if (!isIn(rows, cols, rStart, i)) {
                    continue;
                }
                result[number++] = new int[]{rStart, i};
            }
            cStart = cStart - (size);
            rStart--;

            for (int i = rStart; i >= rStart - (size); i--) {
                if (!isIn(rows, cols, i, cStart)) {
                    continue;
                }
                result[number++] = new int[]{i, cStart};
            }
            rStart = rStart - (size);
            cStart++;

            size = size + 2;
        }
        return result;
    }

    private boolean isIn(int maxRows, int maxCols, int curRow, int curCol) {
        return curRow >= 0 && curRow < maxRows && curCol >= 0 && curCol < maxCols;
    }
}