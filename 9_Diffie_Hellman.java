import java.util.*;
import java.math.*;

class Diffie_Hellman {
    public static int power(int a, int b, int P) {
        if(a==0) return 0;
        int po = Math.pow(a, b);
        return po % 23;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the Public Numbers for Person A and Person B: ");
        int P = input.nextInt();
        int G = input.nextInt();
        System.out.println("Enter the Private Key for Person A and Person B: ");
        int a = input.nextInt();
        int b = input.nextInt();
        //Calculating the Public key Values
        int A = ()
        input.close();
    }
}
