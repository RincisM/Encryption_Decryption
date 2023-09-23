import java.util.*;

class playFairCipher {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the Key: ");
        String key = input.next();
        System.out.print("Enter the String: ");
        String text = input.next();
        text = text.toLowerCase();
        key = key.toLowerCase();
        String alpha = "";
        for (char c = 'a'; c <= 'z'; c++) {
            if (key.indexOf(c) == -1) {
                alpha += c;
            }
        }
        String newMatrixText = key + alpha;
        if (newMatrixText.indexOf('i') < newMatrixText.indexOf('j')) {
            String split_1 = newMatrixText.substring(0, newMatrixText.indexOf('j'));
            String split_2 = newMatrixText.substring(newMatrixText.indexOf('j') + 1, newMatrixText.length());
            newMatrixText = split_1 + split_2;
        } else {
            String split_1 = newMatrixText.substring(0, newMatrixText.indexOf('i'));
            String split_2 = newMatrixText.substring(newMatrixText.indexOf('i') + 1, newMatrixText.length());
            newMatrixText = split_1 + split_2;
        }
        char[][] matrixP = new char[5][5];
        for (int i = 0, idex = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                matrixP[i][j] = newMatrixText.charAt(idex++);
            }
        }
        // To Print the Matrix
        // System.out.println("The Matrix is: ");
        // for (int i = 0; i < 5; i++) {
        // for (int j = 0; j < 5; j++) {
        // System.out.print(matrixP[i][j] + " ");
        // }
        // System.out.println("");
        // }
        String encryptedText = encrypt(text, matrixP);
        String decryptedText = decrypt(encryptedText, matrixP);
        System.out.println("The Encrypted Text is: " + encryptedText);
        System.out.println("The Decrypted Text is: " + decryptedText);
        input.close();
    }

    static String[] combinationOfString(String text) {
        int length = text.length();
        StringBuilder newTextBuilder = new StringBuilder(text);

        for (int i = 0; i < newTextBuilder.length() - 2; i += 2) {
            if (newTextBuilder.charAt(i) == newTextBuilder.charAt(i + 1)) {
                newTextBuilder.insert(i + 1, 'x');
                length++;
            }
        }
        if (length % 2 != 0) {
            newTextBuilder.append('z');
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

    static String encrypt(String text, char[][] matrixP) {
        String[] pairs = combinationOfString(text);
        StringBuilder encryptedText = new StringBuilder();
        for (String pair : pairs) {
            char firstChar = pair.charAt(0);
            char secondChar = pair.charAt(1);
            int[] firstPos = findPosition(matrixP, firstChar);
            int[] secondPos = findPosition(matrixP, secondChar);

            char encryptedFirstChar, encryptedSecondChar;
            if (firstPos[0] == secondPos[0]) {
                int newFirstCol = (firstPos[1] + 1) % 5;
                int newSecondCol = (secondPos[1] + 1) % 5;
                encryptedFirstChar = matrixP[firstPos[0]][newFirstCol];
                encryptedSecondChar = matrixP[secondPos[0]][newSecondCol];
            } else if (firstPos[1] == secondPos[1]) {
                int newFirstRow = (firstPos[0] + 1) % 5;
                int newSecondRow = (secondPos[0] + 1) % 5;
                encryptedFirstChar = matrixP[newFirstRow][firstPos[1]];
                encryptedSecondChar = matrixP[newSecondRow][secondPos[1]];
            } else {
                encryptedFirstChar = matrixP[firstPos[0]][secondPos[1]];
                encryptedSecondChar = matrixP[secondPos[0]][firstPos[1]];
            }
            encryptedText.append(encryptedFirstChar).append(encryptedSecondChar);
        }
        return encryptedText.toString();
    }

    static int[] findPosition(char[][] matrixP, char target) {
        int[] position = new int[2];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (matrixP[i][j] == target) {
                    position[0] = i;
                    position[1] = j;
                }
            }
        }
        return position;
    }

    static String decrypt(String text, char[][] matrixP) {
        String[] pairs = combinationOfString(text);
        StringBuilder decryptedText = new StringBuilder();
        for (int i = 0; i < pairs.length; i++) {
            char firstChar = pairs[i].charAt(0);
            char secondChar = pairs[i].charAt(1);
            int[] firstPos = findPosition(matrixP, firstChar);
            int[] secondPos = findPosition(matrixP, secondChar);

            char decryptedFirstChar, decryptedSecondChar;
            if (firstPos[0] == secondPos[0]) {
                int newFirstCol = (firstPos[1] - 1 + 5) % 5;
                int newSecondCol = (secondPos[1] - 1 + 5) % 5;
                decryptedFirstChar = matrixP[firstPos[0]][newFirstCol];
                decryptedSecondChar = matrixP[secondPos[0]][newSecondCol];
            } else if (firstPos[1] == secondPos[1]) {
                int newFirstRow = (firstPos[0] - 1 + 5) % 5;
                int newSecondRow = (secondPos[0] - 1 + 5) % 5;
                decryptedFirstChar = matrixP[newFirstRow][firstPos[1]];
                decryptedSecondChar = matrixP[newSecondRow][secondPos[1]];
            } else {
                decryptedFirstChar = matrixP[firstPos[0]][secondPos[1]];
                decryptedSecondChar = matrixP[secondPos[0]][firstPos[1]];
            }
            decryptedText.append(decryptedFirstChar).append(decryptedSecondChar);
        }
        int length = decryptedText.length();
        for (int i = 0; i < length; i++) {
            if (decryptedText.charAt(i) == 'x') {
                if (i > 0 && i < length - 1 && decryptedText.charAt(i - 1) == decryptedText.charAt(i + 1)) {
                    decryptedText.replace(i, i + 1, "");
                    length--;
                    i--;
                }
            }
        }
        if (length % 2 != 0 && decryptedText.charAt(length - 1) == 'z') {
            decryptedText.replace(length - 1, length, "");
        }
        return decryptedText.toString();
    }
}
