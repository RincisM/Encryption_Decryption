import javax.crypto.*;
import javax.crypto.spec.*;
import java.nio.charset.*;
import java.util.*;

class DES {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the Key: ");
        String text = input.nextLine();
        System.out.print("Enter the Key String: ");
        String key = input.nextLine();
        SecretKey genKey = generateDESKey(key); // It is a Symmetric key from java.crypto.SecretKey package
        byte[] encryptedTextData = encrypt(text, genKey);
        System.out.println("The Encrypted Text is: " + new String(encryptedTextData));
        String decryptedText = decrypt(encryptedTextData, genKey);
        System.out.println("The Decrypted Text is: " + decryptedText);
        input.close();
    }

    public static SecretKey generateDESKey(String key) throws Exception {
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES"); // creates a SecretKeyFactory for DES keys
        DESKeySpec desSpec = new DESKeySpec(key.getBytes(StandardCharsets.UTF_8)); // specifies the key using a byte
                                                                                   // array
        return keyFactory.generateSecret(desSpec); // generates the secret key based on the specified key specification
    }

    public static byte[] encrypt(String text, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding"); // creates a DES encryption cipher with Electronic
                                                                    // Codebook (ECB) mode and PKCS5 padding
        cipher.init(Cipher.ENCRYPT_MODE, key); // Initializes the Cipher for Encryption with the provided Secret Key
        byte[] cipherText = text.getBytes(StandardCharsets.UTF_8); // converts the plaintext string into a byte array
                                                                   // using UTF-8 encoding
        return cipher.doFinal(cipherText); // performs the actual encryption and returns the ciphertext as a byte array
    }

    public static String decrypt(byte[] cipherText, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding"); // creates a DES decryption cipher with Electronic
                                                                    // Codebook (ECB) mode and PKCS5 padding
        cipher.init(Cipher.DECRYPT_MODE, key); // initializes the cipher for decryption with the provided secret key
        byte[] decryptedBytes = cipher.doFinal(cipherText); // performs the decryption and returns the result as a byte
                                                            // array
        return new String(decryptedBytes, StandardCharsets.UTF_8); // converts the decrypted byte array back to a string
                                                                   // using UTF-8 encoding and returns the plaintext
    }
}