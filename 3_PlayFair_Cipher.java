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
        for(char c = 'a' ; c<='z'; c++) {
            if(key.indexOf(c)==-1) {
                alpha += c;
            }
        }
        String newMatrixText = key+alpha;
        if(newMatrixText.indexOf('i')< newMatrixText.indexOf('j')) {
            String split_1 = newMatrixText.substring(0, newMatrixText.indexOf('j'));
            String split_2 = newMatrixText.substring(newMatrixText.indexOf('j')+1, newMatrixText.length());
            newMatrixText = split_1+split_2;
        }
        else {
            String split_1 = newMatrixText.substring(0, newMatrixText.indexOf('i'));
            String split_2 = newMatrixText.substring(newMatrixText.indexOf('i')+1, newMatrixText.length());
            newMatrixText = split_1+split_2;
        }
        char[][] matrixP = new char[5][5];
        for(int i = 0, idex = 0; i<5; i++) {
            for(int j = 0; j<5; j++) {
                matrixP[i][j] = newMatrixText.charAt(idex++);
            }
        }
        String encryptedText = encrypt(text);
        input.close();
    }

    static String[] combinationOfString(String text) {
        int length = text.length();
        String newText = text;
        if(length%2!=0) {
            length++;
            newText += 'z';
        }
        String x[] = new String[length / 2];
        int counter = 0;
        for (int i = 0; i < length / 2; i++)
        {
            x[i] = newText.substring(counter, counter + 2);
            counter = counter + 2;
        }
        return x;
    }
    static String encrypt(String text) {
    }
}
