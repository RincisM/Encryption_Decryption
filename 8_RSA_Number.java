import java.math.*;
import java.util.*;

class RSA_Number {
    public static void main(String[] args) {
        int d, e;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the Message: ");
        int message = input.nextInt();
        System.out.println("Enter two Prime Numbers: ");
        int prime1 = input.nextInt();
        int prime2 = input.nextInt();
        input.close();

        int n = prime1 * prime2;
        int phiOfN = (prime1 - 1) * (prime2 - 1);

        // Calculate the public key (e)
        for (e = 2; e < phiOfN; e++) {
            if (getGCD(e, phiOfN) == 1) {
                break;
            }
        }
        System.out.println("The Public Key (e) is: " + e);

        // Calculate the private key (d) using the Extended Euclidean Algorithm
        d = calculateD(e, phiOfN);
        System.out.println("The Private Key (d) is: " + d);

        // Encryption
        BigInteger plaintext = BigInteger.valueOf(message);
        BigInteger ciphertext = plaintext.modPow(BigInteger.valueOf(e), BigInteger.valueOf(n));
        System.out.println("The Cipher Text is: " + ciphertext);

        // Decryption
        BigInteger decryptedMessage = ciphertext.modPow(BigInteger.valueOf(d), BigInteger.valueOf(n));
        System.out.println("The Decrypted Message is: " + decryptedMessage);
    }

    public static int getGCD(int mod, int num) {
        if (mod == 0) {
            return num;
        } else {
            return getGCD(num % mod, mod);
        }
    }

    public static int calculateD(int e, int phiOfN) {
        int x = 0, y = 1, lastX = 1, lastY = 0, temp, q;
        while (phiOfN != 0) {
            q = e / phiOfN;
            int remainder = e % phiOfN;
            e = phiOfN;
            phiOfN = remainder;
            temp = x;
            x = lastX - q * x;
            lastX = temp;
            temp = y;
            y = lastY - q * y;
            lastY = temp;
        }
        return lastX;
    }
}
