import java.util.*;

class hillCipher {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the String: ");
        String text = input.next().toUpperCase();
        String key;
        int sq;
        do {
            System.out.println(
                    "Enter the Key (length of square numbers only)\n1. The determinant of the matrix which is formed from the key you give, must be a positive integer.\r\n2. The determinant must not be divisible by 2 (except for the case where it's equal to 2 itself) or any other prime numbers less than 26 (e.g., 3, 5, 7, 11, 13, 17, 19, 23, 25)\n3. If you don't find a String type 'DFSZ': ");
            key = input.next().toUpperCase();
            sq = (int) Math.sqrt(key.length());
        } while (sq * sq != key.length());
        int row = sq;
        int column = sq;
        int[][] keyMatrix = new int[row][column];
        int k = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                keyMatrix[i][j] = (key.charAt(k)) % 65;
                k++;
            }
        }
        String encryptedText = encrypt(text, keyMatrix, row);
        System.out.println("The Encrypted Text is: " + encryptedText);
        System.out.println("The Decrypted Text is: " + decrypt(encryptedText, keyMatrix, row));
        input.close();
    }

    static String[] combinationOfString(String text, int row) {
        int length = text.length();
        StringBuilder newTextBuilder = new StringBuilder(text);
        if (length % row != 0) {
            newTextBuilder.append('X');
            length++;
        }
        String newText = newTextBuilder.toString();
        String[] x = new String[length / row];
        int counter = 0;
        for (int i = 0; i < length / row; i++) {
            x[i] = newText.substring(counter, counter + row);
            counter = counter + row;
        }
        return x;
    }

    static int determinantOfMatrix(int[][] matrix) {
        int size = matrix.length;
        if (size == 1) {
            return matrix[0][0];
        }
        if (size == 2) {
            int det = matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
            return (det + 26) % 26; // Apply modulo to the final result
        }
        int determinant = 0;
        int sign = 1;
        for (int i = 0; i < size; i++) {
            int[][] minorMatrix = new int[size - 1][size - 1];
            for (int j = 1; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    if (k < i) {
                        minorMatrix[j - 1][k] = matrix[j][k];
                    } else if (k > i) {
                        minorMatrix[j - 1][k - 1] = matrix[j][k];
                    }
                }
            }
            determinant += sign * matrix[0][i] * determinantOfMatrix(minorMatrix);
            sign = -sign;
        }
        return (determinant + 26) % 26; // Apply modulo to the final result
    }

    static int[][] adjointMatrix(int[][] matrix) {
        int size = matrix.length;
        int[][] adjMatrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int sign = ((i + j) % 2 == 0) ? 1 : -1;
                int cofactor = sign * determinantOfMatrix(minorMatrix(matrix, i, j));
                adjMatrix[i][j] = cofactor;
            }
        }
        return adjMatrix;
    }

    static int[][] minorMatrix(int[][] matrix, int rowToRemove, int colToRemove) {
        int size = matrix.length;
        int[][] minor = new int[size - 1][size - 1];
        int minorRow = 0;
        for (int i = 0; i < size; i++) {
            if (i == rowToRemove) {
                continue;
            }
            int minorCol = 0;
            for (int j = 0; j < size; j++) {
                if (j == colToRemove) {
                    continue;
                }
                minor[minorRow][minorCol] = matrix[i][j];
                minorCol++;
            }
            minorRow++;
        }
        return minor;
    }

    static double[][] inverseMatrix(int[][] matrix) {
        int size = matrix.length;
        int determinant = determinantOfMatrix(matrix);

        if (determinant == 0) {
            return null; // Matrix is not invertible
        }
        for (int i = 1; i < 26; i++) {
            if ((i * determinant) % 26 == 1) {
                determinant = i;
            }
        }
        double[][] inverse = new double[size][size];

        if (size == 2) {
            // Handle the 2x2 case
            matrix[0][0] = matrix[0][0];
            matrix[0][1] = -matrix[0][1];
            matrix[1][0] = -matrix[1][0];
            matrix[1][1] = matrix[1][1];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (matrix[i][j] < 0) {
                        matrix[i][j] += 26;
                    }
                }
            }

            double detInverse = determinant;

            inverse[0][0] = detInverse * matrix[1][1];
            inverse[0][1] = detInverse * matrix[0][1];
            inverse[1][0] = detInverse * matrix[1][0];
            inverse[1][1] = detInverse * matrix[0][0];

        } else {
            int[][] adjMatrix = adjointMatrix(matrix);

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    inverse[i][j] = adjMatrix[i][j] * (double) determinant;
                }
            }
        }

        return inverse;
    }

    static String encrypt(String text, int[][] keyMatrix, int row) {
        String[] te = combinationOfString(text, row);
        int[][] charMatrix = new int[row][1];
        int[][] newMatrix = new int[row][1];
        StringBuilder encryptedText = new StringBuilder();
        char t;
        for (int i = 0; i < te.length; i++) {
            for (int j = 0; j < row; j++) {
                charMatrix[j][0] = (int) te[i].charAt(j) - 'A';
            }
            for (int l = 0; l < row; l++) {
                newMatrix[l][0] = 0;
                for (int n = 0; n < row; n++) {
                    newMatrix[l][0] += (keyMatrix[l][n] * charMatrix[n][0]);
                    newMatrix[l][0] %= 26;
                }
            }
            for (int p = 0; p < row; p++) {
                t = (char) (newMatrix[p][0] + 'A');
                encryptedText.append(t);
            }
        }
        return encryptedText.toString();
    }

    static String decrypt(String text, int[][] keyMatrix, int row) {
        StringBuilder decryptedText = new StringBuilder();
        String[] te = combinationOfString(text, row);
        int determinant = determinantOfMatrix(keyMatrix);
        if (determinant == 0) {
            return "Decryption is not possible. The matrix is singular.";
        }
        double[][] inverseMatrix = inverseMatrix(keyMatrix);
        if (inverseMatrix == null) {
            return "Decryption is not possible. The matrix is singular.";
        }
        int[][] charMatrix = new int[row][1];
        char t;
        for (int i = 0; i < te.length; i++) {
            for (int j = 0; j < row; j++) {
                charMatrix[j][0] = (int) (te[i].charAt(j) - 65) % 26;
            }
            double[][] newMatrix = new double[row][1];
            for (int l = 0; l < row; l++) {
                newMatrix[l][0] = 0;
                for (int n = 0; n < row; n++) {
                    newMatrix[l][0] += (inverseMatrix[l][n] * charMatrix[n][0]);
                    newMatrix[l][0] = ((newMatrix[l][0] % 26) + 26) % 26;
                }
            }
            for (int p = 0; p < row; p++) {
                t = (char) ((newMatrix[p][0] % 26) + 65);
                decryptedText.append(t);
            }
        }
        if (decryptedText.length() % 2 == 0) {
            while (decryptedText.length() > 0 && decryptedText.charAt(decryptedText.length() - 1) == 'X') {
                decryptedText.deleteCharAt(decryptedText.length() - 1);
            }
        }
        return decryptedText.toString();
    }
}
