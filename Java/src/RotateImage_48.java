public class RotateImage_48 {
    public void rotate(int[][] matrix) {

        int temp;
        // First transpose the image
        for (int row = 0; row < matrix.length; row++) {
            for (int col = row; col < matrix[row].length; col++) {
                temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }

        // Then flip the iamge
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length / 2; col++) {
                temp = matrix[row][col];
                matrix[row][col] = matrix[row][matrix[row].length - 1 - col];
                matrix[row][matrix[row].length - 1 - col] = temp;
            }
        }
    }
}
