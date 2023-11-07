import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import javax.swing.*;

class SHA_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String text = JOptionPane.showInputDialog("Enter the Text: ");
        String hashcode = shaHash(text);
        JOptionPane.showMessageDialog(null,"The Hash Value for Text "+text+" is: "+hashcode);
        String newText = JOptionPane.showInputDialog(null, "Enter the Text to check: ");
        if(hashcode.equals(shaHash(newText))) {
            JOptionPane.showMessageDialog(null,"Text Matched - Unlocked", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            JOptionPane.showMessageDialog(null, "Text does not match","Warning", JOptionPane.ERROR_MESSAGE);
        }
        input.close();
    }

    public static String shaHash(String text) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1"); //Calling the MD5 algorithm
            byte[] messageDigest = md.digest(text.getBytes()); //Converting the text to byte array 
            BigInteger number = new BigInteger(1, messageDigest); //Converting the byte array to a signum representation
            String hashtext = number.toString(16); //Converting the number representation to a hexadecimal value

            while(hashtext.length() < 32) {
                hashtext = "0" + hashtext; //padding the characters if the length of the hashtext is less than 32
            }
            return hashtext;
        }
        catch(NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
