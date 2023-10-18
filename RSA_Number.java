import java.math.*;
import java.util.*;

class RSA_Number {
    public static void main(String[] args) {
        int d = 0, e; // e = public key
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the Message: ");
        int message = input.nextInt();
        System.out.println("Enter two Prime Numbers: ");
        int prime1 = input.nextInt();
        int prime2 = input.nextInt();
        input.close();
        int n = prime1 * prime2;
        int phiOfN = (prime1 - 1) * (prime2 -1);
        for(e = 2; e<n; e++) {
            if(getGCD(e, phiOfN) == 1) {
                break;
            }
        }
        System.out.println("The Public Key is: "+ e);

        //Calculating the Private Key
        for(int m = 0; m<=9; m++) {
            int temp = 1 + (m* phiOfN);
            if(temp % e == 0) {
                d = temp / e;
                break;
            }
        }
        System.out.println("The Private Key is: "+ d);
        double e_message;
        BigInteger d_message;
        e_message = (Math.pow(message, e)) % n;
        System.out.println("The cipher Test is: "+ e_message);
        BigInteger bigN = BigInteger.valueOf(n);
        BigInteger bigC = BigDecimal.valueOf(e_message).toBigInteger();
        //decrypting the message
        d_message = (bigC.pow(d)).mod(bigN);
        System.out.println("The Decrypted Message is: "+d_message);
    }
    public static int getGCD(int mod, int num) {
        if(mod == 0) {
            return num;
        }
        else {
            return getGCD(num % mod, mod);
        }
    }
}
