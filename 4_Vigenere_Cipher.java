import java.util.*;

class vigenereCipher {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the Key: ");
        String key = input.next().toLowerCase();
        System.out.print("Enter the Text: ");
        String text = input.next().toUpperCase();
        char[][] matrixV = new char[26][26];
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                matrixV[i][j] = (char) (65 + (i + j) % 26);
            }
        }
        // Creating a Matrix
        // System.out.println("The Matrix Created is: ");
        // for (int i = 0; i < 26; i++) {
        // for (int j = 0; j < 26; j++) {
        // System.out.print(matrixV[i][j] + " ");
        // }
        // System.out.print("\n");
        // }
        int i = 0;
        while (text.length() > key.length()) {
            key += key.charAt(i % key.length()); //Replicating the Key till the length of the Key reaches the length of the Text.
            i++;
        }
        String encryptedText = encrypt(key, text, matrixV);
        System.out.println("The Encrypted Text is: " + encryptedText);
        String decryptedText = decrypt(key, encryptedText, matrixV);
        System.out.println("The Decrypted Text is: " + decryptedText);
        input.close();
    }

    static String encrypt(String key, String text, char[][] matrixV) {
        String encryptedText = "";
        int row = 0;
        int column = 0;
        for (int i = 0; i < text.length(); i++) {
            column = (text.charAt(i) - 'A') % 26;
            row = (key.charAt(i) - 'A') % 26;
            encryptedText += matrixV[row][column];
        }
        return encryptedText;
    }

    static String decrypt(String key, String text, char[][] matrixV) {
        String decryptedText = "";
        int row = 0;
        for (int i = 0; i < text.length(); i++) {
            row = (key.charAt(i) - 'A') % 26;
            for (int j = 0; j < 26; j++) {
                if (matrixV[row][j] == text.charAt(i)) {
                    decryptedText += (char) (('A' + j));
                }
            }
        }
        return decryptedText;
    }
}
