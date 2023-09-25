import java.util.*;

class railFenceCipher {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the String: ");
        String text = input.next();
        System.out.println("Enter the Key: ");
        int key = input.nextInt();
        String encryptedText = encrypt(text, key);
        System.out.println("The Encrypted Text is: "+ encryptedText);
        String decryptedText = encrypt(encryptedText, key);
        System.out.println("The Descrypted Text is: "+ decryptedText);
        input.close();
    }
    static String encrypt(String text, int key) {
        String encryptedText = "";
        int i = 0;
        while(encryptedText.length()<text.length()) {
            encryptedText += text.charAt(i % text.length());
            i = i+3;

        }
        return encryptedText;
    }
    static String decrypt(String text, int key) {
        String decryptedText = "";
        int i = 0;
        while(decryptedText.length()<text.length()) {
            decryptedText += text.charAt(i);
            i = i+4;
        }
        return decryptedText;
    }
}
