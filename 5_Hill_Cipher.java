import java.util.*;

class hillCipher {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the String: ");
        String text = input.next().toUpperCase();
        String key;
        int sq;
        do {
            System.out.println("Enter the Key (length of square numbers only): ");
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
        System.out.println("The Encrypted Text is: "+ encryptedText);
        input.close();
    }

    static String[] combinationOfString(String text) {
        int length = text.length();
        StringBuilder newTextBuilder = new StringBuilder(text);
        if (length % 2 != 0) {
            newTextBuilder.append('x');
            length++;
        }
        String newText = newTextBuilder.toString();
        String x[] = new String[length / 2];
        int counter = 0;
        for (int i = 0; i < length / 2; i++) {
            x[i] = newText.substring(counter, counter + 2);
            counter = counter + 2;
        }
        return x;
    }

    static String encrypt(String text, int[][] keyMatrix, int row) {
        String te[] = combinationOfString(text);
        int [][] matrix = new int[row][1];
        int [][] newMatrix = new int[row][1];
        StringBuilder encryptedText = new StringBuilder();
        char t;
        for(int i = 0; i<te.length; i++) {
            for(int j = 0; j<2; j++) {
                matrix[i][0] = (int)te[i].charAt(j) % 65;
            }
            for(int l = 0; l<row; l++) {
                for(int m = 0; m<1; m++) {
                    newMatrix[l][m] = 0;
                    for(int n = 0; n<row; n++) {
                        newMatrix[l][m] += (keyMatrix[l][n] * matrix[n][m])%26;
                    }
                }
            }
            for(int p=0; p<row; p++) {
                for(int q = 0; q<1; q++) {
                    t = (char) (newMatrix[p][q]+65);
                    encryptedText.append(t);
                }
            }
        }
        return encryptedText.toString(); 
    }
}
