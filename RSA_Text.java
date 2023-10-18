import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.*;
import javax.crypto.Cipher;

class RSA_Text {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        //RSA needs a random key value
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(2048); //Fixing the Keysize to be 2048. The Generated Key 2will have a size of 2048 bits
        KeyPair pair = generator.generateKeyPair();
        //Extracting the Private and Public Key
        PrivateKey privateKey = pair.getPrivate(); //For Decrypting the Data
        PublicKey publicKey = pair.getPublic();  //For Encrypting the Data
        System.out.print("Enter the String: ");
        String message = input.nextLine();

        //Encryption

        //Creating a Cipher Object intialized for encryption with the public key
        Cipher encryptCipher = Cipher.getInstance("RSA");
        encryptCipher.init(Cipher.ENCRYPT_MODE, publicKey);
        
        //Calling the doFinal Method to encrypt the message
        byte[] messageBytes = message.getBytes(StandardCharsets.UTF_8); //Converting the Message to Bytes
        byte[] encryptedMessageBytes = encryptCipher.doFinal(messageBytes); //Encoding the Message
        //Converting the Bytes to String
        String encryptedMessage = Base64.getEncoder().encodeToString(encryptedMessageBytes);
        System.out.println("The Encrypted Message: "+ encryptedMessage);

        //Decryption

        //Creating a Cipher Object initialized for decryption with the private key
        Cipher decryptCipher = Cipher.getInstance("RSA");
        decryptCipher.init(Cipher.DECRYPT_MODE, privateKey);

        //Calling the doFinal the method to invoke the Cipher to deccrypt the encrypted message
        byte[] decryptedMessageBytes = decryptCipher.doFinal(encryptedMessageBytes);
        
        //Converting the Bytes to String
        String decryptedMessaege = new String(decryptedMessageBytes, StandardCharsets.UTF_8);
        System.out.println("The Decrypted Message is: "+ decryptedMessaege);
        input.close();
    }
}
