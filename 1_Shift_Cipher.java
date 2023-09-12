import java.util.*;

class exercise1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the String: ");
        String text = input.next();
        System.out.println("Enter the Key: ");
        int key = input.nextInt();
        int key1 =0;
        if(key>0) {
            key1 = key%26;
        }
        else {
            System.out.println("Enter a valid Number");
        }
        String cipher = encrypt(text, key1);
        System.out.println("The Cipher Text is (After Encryption): "+cipher);
        String normal = decrypt(cipher, key1);
        System.out.println("The Normal Text After Decryption: "+normal);
        input.close();
    }
    static String encrypt(String text, int key) {
        String cipher = "";
        for(int i = 0; i<text.length(); i++) {
            int a = text.charAt(i);
            cipher += (char) (a+key);
        }
        return cipher;
    }
    static String decrypt(String text, int key) {
        String cipher = "";
        for(int i = 0; i<text.length(); i++) {
            int a = text.charAt(i);
            cipher += (char) (a-key);
        }
        return cipher;
    }
}