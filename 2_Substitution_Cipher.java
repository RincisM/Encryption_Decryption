import java.util.*;
class exercise2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the String: ");
        String text = input.next();
        String subst = "";
        for(int i = 0; i<26; i++) {
            System.out.println("Enter a Substitution Character for "+ ((char)(65+i)) +": ");
            char c = input.next().charAt(0);
            if(Character.isAlphabetic(c)) {
                subst += c;
            }
            else {
                System.out.println("Enter a valid Character");
                i--;
            }
        }
        String cipher = encrypt(text, subst);
        String normal = decrypt(cipher, subst);
        System.out.println("The Encryted Text is: "+ cipher);
        System.out.println("The Normal Text is (After Decryption): "+normal);
        input.close();
    }
    static String encrypt(String text, String subst) {
        String cipher = "";
        for(int i = 0; i<text.length(); i++) {
            int a = (int)(text.charAt(i))%65;
            cipher += subst.charAt(a);
        }
        return cipher;
    }
    static String decrypt(String text, String subst) {
        String normal = "";
        for(int i = 0; i<text.length(); i++) {
            int a = (int)(text.charAt(i))%65;
            normal += subst.charAt(a);
        }
        return normal;
    }
}
