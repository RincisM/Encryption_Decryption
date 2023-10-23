import java.util.*;

class Diffie_Hellman {
    public static long power(long a, long b, long P) {
        if (b == 0) {
            return 1;
        } else if (b == 1) {
            return a % P;
        } else {
            return (long) (Math.pow(a, b)) % P;
        }
    }

    public static boolean isPrimitiveRoot(long G, long P) {
        Set<Long> residues = new HashSet<>();
        long result = 1;
        for (int i = 0; i < P - 1; i++) {
            result = (result * G) % P;
            if (residues.contains(result) || result == 0) {
                return false;
            }
            residues.add(result);
        }
        return residues.size() == P - 1;
    }

    public static List<Long> findPrimitiveRoots(long P) {
        List<Long> primitiveRoots = new ArrayList<>();
        for (int i = 2; i < P; i++) {
            if (isPrimitiveRoot(i, P)) {
                primitiveRoots.add((long) i);
            }
        }
        return primitiveRoots;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a Prime Number: ");
        long P = input.nextLong();
        List<Long> primitiveRoots = findPrimitiveRoots(P);
        if (primitiveRoots.isEmpty()) {
            System.out.println("No primitive roots found for " + P);
            input.close();
            return;
        }
        // System.out.println("Primitive Roots: " + primitiveRoots);
        System.out.println("Enter the Private Key for Person A and Person B:");
        long a = input.nextLong();
        long b = input.nextLong();
        for (Long G : primitiveRoots) {
            long keyB = power(G, a, P);
            long keyA = power(G, b, P);
            long genKeyA = power(keyB, b, P);
            long genKeyB = power(keyA, a, P);
            System.out.println("Using G = " + G);
            System.out.println("The Generated Secret Key is: A: " + genKeyA + " B: " + genKeyB);
            if (genKeyA == genKeyB) {
                System.out.println("Shared Secret Keys Match!");
                break;
            } else {
                System.out.println("Shared Secret Keys Do Not Match!");
            }
        }
        input.close();
    }
}
