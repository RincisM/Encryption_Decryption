import java.util.*;

class caesarCipher {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the String: ");
        String text = input.next();
        System.out.println("Enter the Key (1-25): ");
        int key = input.nextInt();
        if (key >= 1 && key <= 25) {
            String cipher = encrypt(text, key);
            System.out.println("The Cipher Text is (After Encryption): " + cipher);
            String normal = decrypt(cipher, key);
            System.out.println("The Normal Text After Decryption: " + normal);
        } else {
            System.out.println("Enter a valid key in the range 1-25");
        }
        input.close();
    }

    static String encrypt(String text, int key) {
        StringBuilder cipher = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char original = text.charAt(i);
            if (Character.isLetter(original)) {
                char shifted = (char) (original + key);
                if ((Character.isLowerCase(original) && shifted > 'z')
                        || (Character.isUpperCase(original) && shifted > 'Z')) {
                    shifted = (char) (original - (26 - key));
                }
                cipher.append(shifted);
            } else {
                cipher.append(original);
            }
        }
        return cipher.toString();
    }

    static String decrypt(String text, int key) {
        return encrypt(text, 26 - key);
    }
}
