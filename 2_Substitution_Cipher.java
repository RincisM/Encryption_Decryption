import java.util.*;

class substitutionCipher {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the String: ");
        String text = input.next();
        String subst = "";
        for (char c = 'A'; c <= 'Z'; c++) {
            System.out.println("Enter a Substitution Character for " + c + ": ");
            char substituted = input.next().charAt(0);
            if (Character.isAlphabetic(substituted)) {
                subst += substituted;
            } else {
                System.out.println("Enter a valid Alphabetic Character");
                c--;
            }
        }
        String cipher = encrypt(text, subst.toUpperCase());
        String normal = decrypt(cipher, subst.toUpperCase());
        System.out.println("The Encryted Text is: " + cipher);
        System.out.println("The Normal Text is (After Decryption): " + normal);
        input.close();
    }

    static String encrypt(String text, String subst) {
        text = text.toUpperCase();
        String cipher = "";
        for (int i = 0; i < text.length(); i++) {
            int index = text.charAt(i) - 'A';
            cipher += subst.charAt(index);
        }
        return cipher;
    }

    static String decrypt(String text, String subst) {
        text = text.toUpperCase();
        String normal = "";
        for (int i = 0; i < text.length(); i++) {
            int index = subst.indexOf(text.charAt(i));
            normal += (char) ('A' + index);
        }
        return normal;
    }
}
