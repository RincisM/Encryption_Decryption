import java.util.*;

class hillCipher {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the String: ");
        String text = input.next();
        if (text.length() % 2 != 0) {
            text += 'x';
        }
        String key;
        int sq;
        do {
            System.out.println("Enter the Key (square numbers only): ");
            key = input.next().toUpperCase();
            sq = (int) Math.sqrt(key.length());
        } while (sq * sq != key.length());
        int row = sq;
        int column = sq;
        int[][] keyMatrix = new int[row][column];
        int k = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                keyMatrix[i][j] = (key.charAt(k)) % 26;
                k++;
            }
        }
        input.close();
    }

    static int[][] createMatrix(String text, int column) {
        int[][] matrix = new int[column][1];
        int k = 0;
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < 1; j++) {
                matrix[i][j] = text.charAt(k) % 65;
                k++;
            }
        }
        return matrix;
    }

    static String encrypt(String text, int[][] keyMatrix) {
        String encryptedText = "";

        return encryptedText;
    }
}
