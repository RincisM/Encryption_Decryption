import java.util.*;

class railFenceCipher {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the String: ");
        String text = input.next();
        System.out.println("Enter the Key: ");
        int key = input.nextInt();
        String encryptedText = encrypt(text, key);
        System.out.println("The Encrypted Text is: " + encryptedText);
        String decryptedText = decrypt(encryptedText, key);
        System.out.println("The Descrypted Text is: " + decryptedText);
        input.close();
    }

    static String encrypt(String text, int key) {
        if (key <= 1) {
            return text;
        }
        int length = text.length();
        char[][] railFence = new char[key][length];
        for (int i = 0; i < key; i++) {
            Arrays.fill(railFence[i], ' ');
        }
        int row = 0, column = 0;
        boolean moveDown = false;
        for (int i = 0; i < length; i++) {
            railFence[row][column] = text.charAt(i);
            if (row == 0 || row == key - 1) {
                moveDown = !moveDown;
            }
            if (moveDown) {
                row++;
            } else {
                row--;
                column++;
            }
        }
        StringBuilder encryptedText = new StringBuilder();
        for (int i = 0; i < key; i++) {
            for (int j = 0; j < length; j++) {
                if (railFence[i][j] != ' ') {
                    encryptedText.append(railFence[i][j]);
                }
            }
        }
        return encryptedText.toString();
    }

    static String decrypt(String text, int key) {
        if (key <= 1) {
            return text;
        }
        int length = text.length();
        char[][] railFence = new char[key][length];
        for (int i = 0; i < key; i++) {
            Arrays.fill(railFence[i], ' ');
        }
        int row = 0, column = 0;
        boolean moveDown = false;
        for (int i = 0; i < length; i++) {
            railFence[row][column] = '*'; // Marking the Patterns where the characters should be placed based on the
                                          // pattern
            if (row == 0 || row == key - 1) {
                moveDown = !moveDown;
            }
            if (moveDown) {
                row++;
            } else {
                row--;
                column++;
            }
        }
        int index = 0;
        for (int i = 0; i < key; i++) {
            for (int j = 0; j < length; j++) {
                if (railFence[i][j] == '*' && index < length) {
                    railFence[i][j] = text.charAt(index);
                    index++;
                }
            }
        }

        StringBuilder decryptedText = new StringBuilder();
        row = 0;
        column = 0;
        moveDown = false;
        for (int i = 0; i < length; i++) {
            decryptedText.append(railFence[row][column]);
            if (row == 0 || row == key - 1) {
                moveDown = !moveDown;
            }
            if (moveDown) {
                row++;
            } else {
                row--;
                column++;
            }
        }
        return decryptedText.toString();
    }
}
