package tools;

public class Tools {
    public static void printMatrix(double[][] matrix, boolean half) {
        if (matrix.length < 0)
            return;
        long[][] matrixCopy = new long[matrix.length][matrix[0].length];
        for (int i=0;i<matrix.length;i++) {
            for (int j=0;j<matrix[0].length;j++) {
                matrixCopy[i][j] = (long) matrix[i][j];
            }
        }
        printMatrix(matrixCopy, half);
    }
    public static void printMatrix(int[][] matrix, boolean half) {
        if (matrix.length < 0)
            return;
        long[][] matrixCopy = new long[matrix.length][matrix[0].length];
        for (int i=0;i<matrix.length;i++) {
            for (int j=0;j<matrix[0].length;j++) {
                matrixCopy[i][j] = (long) matrix[i][j];
            }
        }
        printMatrix(matrixCopy, half);
    }
    public static void printMatrix(long[][] matrix, boolean half) {
        if (matrix.length < 0)
            return;

        int h = matrix.length, w = matrix[0].length;
        int len0 = String.valueOf(matrix.length).length();
        int[] len = new int[h];
        for (int i=0;i<h;i++) {
            for (int j=0;j<h;j++) {
                int l =  String.valueOf(matrix[j][i]).length();
                if (l > len[i])
                    len[i] = l;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(new String(new char[len0]).replace("\0", " ")).append(" | ");
        for (int c=0; c<w; c++)
            sb.append(String.format("%" + len[c] + "d", c+1)).append("|");
        System.out.println(sb.toString());
        System.out.println(new String(new char[sb.length()]).replace("\0", "-"));
        for (int r=0; r<h; r++) {
            sb.setLength(0);
            sb.append(String.format("%" + len0 + "d | ", r+1));
            for (int c=0; c<w; c++) {
                if (half && c < r) sb.append(new String(new char[len[c]]).replace("\0", " ")).append(" ");
                else sb.append(String.format("%" + len[c] + "d", matrix[r][c])).append("|");
            }
            System.out.println(sb.toString());
        }
    }
}