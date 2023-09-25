import java.util.*;

class hillCipher {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the String: ");
        String text = input.next();
        System.out.println("Enter the Key (square numbers only): ");
        String key = input.next().toUpperCase();
        int row = 0;
        int column = 0;
        if(key.length()==4) {
            row = 2;
            column = 2;
        } else if(key.length() == 9) {
            row = 3;
            column = 3;
        }
        else {
            System.out.println("Enter the Key of length of square numbers");
            System.exit(0);
        }
        int[][] keyMatrix = new int[row][column];
        int k = 0;
        for(int i = 0; i<row; i++) {
            for(int j = 0; j<column; j++) {
                keyMatrix[i][j] = (key.charAt(k)) % 65;
                k++;
            }
        }
        input.close();
    }
    static String encrypt(String text, int[][] keyMatrix) {
        String encryptedText = "";
        
        return encryptedText;
    }
}