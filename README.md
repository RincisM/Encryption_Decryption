**# Encryption_Decryption**

**1. (Shift or Ceasar Cipher)**

Use the formula E = P + K (For Encryption) D = C - K (For Decryption) where E - Encrypted Text (Cipher text (C))

*Definition*
The Caesar cipher, also known as a shift cipher, is one of the simplest and most widely known encryption techniques. It is a type of substitution cipher where each letter in the plaintext is shifted a certain number of places down or up the alphabet. In a Caesar cipher, the key is a fixed integer value that determines the number of positions each letter is shifted.

For example, with a key of 3:
    'A' would become 'D'
    'B' would become 'E'
    'C' would become 'F'

**2. Substitution Cipher**

*Definition*
A substitution cipher is a method of encrypting a message by replacing each letter in the plaintext with another letter or symbol. The replacement is typically determined by a fixed rule or key.

Example:
Let's consider a simple substitution cipher, where we replace each letter with the one that follows it in the alphabet. This is sometimes called a Caesar cipher with a shift of 1. In this cipher:
    'A' becomes 'B'
    'B' becomes 'C'
    'C' becomes 'D'
    ...
So, if we encrypt the word "HELLO," it becomes "IFMMP." Each letter is replaced by the letter that follows it in the alphabet. To decrypt, you simply reverse the process by shifting each letter back one position.

**3. Play Fair Cipher**

*Definition*
The Playfair Cipher is a symmetric-key substitution cipher that operates on pairs of letters (digraphs) in the plaintext, replacing them with different pairs based on a key.

Example:
Suppose we want to encrypt the message "HELLO" using the Playfair Cipher with the key "KEYWORD." First, we construct a key table:

K E Y W O  
R D A B C  
F G H I L  
M N P Q S  
T U V X Z  

Now, we follow these steps to encrypt "HELLO":
    Step 1: Break the message into digraphs, preserving spaces: "HE LL O"
    Step 2: Apply the Playfair rules:
        H -> EK (row/column positions in the key table)
        E -> WO
        LL -> IG (both letters are in the same row)
        O -> NL
    Step 3: The encrypted message is: "EK WO IG NL"

To decrypt, you reverse the process using the same key table to obtain the original message "HELLO."
Playfair Cipher is known for its effectiveness against simple frequency analysis methods due to its treatment of double letters and letter pairs.

**4. Vigenere Cipher**

*Definition*
The Vigenère cipher is a method of encrypting alphabetic text by using a simple form of polyalphabetic substitution. In other words, it's a more complex extension of the Caesar cipher, which shifts letters by a fixed number. In the Vigenère cipher, the shift value changes based on a keyword, making it more secure than a simple Caesar cipher.

Here's how it works:

  Step 1: You choose a keyword, for example, "KEY."

  Step 2: You repeat the keyword to match the length of the message. If the message is "HELLO," the keyword becomes "KEYKE."

  Step 3: You create a table (often called a Vigenère square) with the alphabet written out multiple times, shifting each row by one letter to the right. It looks like this:  

A B C D E F G H I J K L M N O P Q R S T U V W X Y Z  
B C D E F G H I J K L M N O P Q R S T U V W X Y Z A  
C D E F G H I J K L M N O P Q R S T U V W X Y Z A B  
D E F G H I J K L M N O P Q R S T U V W X Y Z A B C  
E F G H I J K L M N O P Q R S T U V W X Y Z A B C D  
F G H I J K L M N O P Q R S T U V W X Y Z A B C D E  
G H I J K L M N O P Q R S T U V W X Y Z A B C D E F  
H I J K L M N O P Q R S T U V W X Y Z A B C D E F G  
I J K L M N O P Q R S T U V W X Y Z A B C D E F G H  
J K L M N O P Q R S T U V W X Y Z A B C D E F G H I  
K L M N O P Q R S T U V W X Y Z A B C D E F G H I J  
L M N O P Q R S T U V W X Y Z A B C D E F G H I J K  
M N O P Q R S T U V W X Y Z A B C D E F G H I J K L  
N O P Q R S T U V W X Y Z A B C D E F G H I J K L M  
O P Q R S T U V W X Y Z A B C D E F G H I J K L M N  
P Q R S T U V W X Y Z A B C D E F G H I J K L M N O  
Q R S T U V W X Y Z A B C D E F G H I J K L M N O P  
R S T U V W X Y Z A B C D E F G H I J K L M N O P Q  
S T U V W X Y Z A B C D E F G H I J K L M N O P Q R  
T U V W X Y Z A B C D E F G H I J K L M N O P Q R S  
U V W X Y Z A B C D E F G H I J K L M N O P Q R S T  
V W X Y Z A B C D E F G H I J K L M N O P Q R S T U  
W X Y Z A B C D E F G H I J K L M N O P Q R S T U V  
X Y Z A B C D E F G H I J K L M N O P Q R S T U V W  
Y Z A B C D E F G H I J K L M N O P Q R S T U V W X  
Z A B C D E F G H I J K L M N O P Q R S T U V W X Y  
  
  Step 4: You match each letter of your message with the corresponding letter in the keyword. Then, you find the letter in the Vigenère square at the intersection of the row with the message letter and the column with the keyword letter. This is the encrypted letter.

  Step 5: You repeat this process for each letter in the message, using the keyword cyclically.

  Step 6: The result is the encrypted message.

Decrypting is done in a similar way but in reverse, using the same keyword to find the original message.
The Vigenère cipher is a polyalphabetic cipher, which means it uses multiple substitution alphabets to make it more difficult to crack than simple substitution ciphers like the Caesar cipher. However, it's not as secure as modern encryption methods.


**5. Hill Cipher**

*Definition*
The Hill Cipher is a polygraphic substitution cipher that operates on blocks of letters instead of individual letters. It uses matrix multiplication to encrypt and decrypt messages.

Let's say we want to encrypt the message "HELLO" using a 2x2 Hill Cipher with the matrix:

| 1  2 |
| 3  5 |

The first step is to convert the message to numbers (e.g., A=0, B=1, C=2, ... Z=25):

H -> 7, E -> 4, L -> 11, L -> 11, O -> 14

Then, we group the numbers into 2-letter blocks:

74 11 14

To encrypt, we multiply this block by the matrix:

| 1  2 |   | 7  4 |   | 78 39 |   | 00 13 |   -> 00 13 -> N  N
| 3  5 | x | 11 14 | = | 314 175 | = | 15 22 |   -> 15 22 -> P  W

So, "HELLO" is encrypted to "NNPW."

To decrypt, we use the inverse of the matrix and perform matrix multiplication similarly. In this case, it would transform "NNPW" back into "HELLO."



**6. Rail Fence Cipher (Zigzag Cipher)**

*Definition*
The Rail Fence Cipher is a simple transposition cipher that rearranges the characters of a message to form a zigzag pattern.

Let's say we want to encrypt the message "HELLO" using a 3-rail fence pattern:

H . . . O . . .   (Rail 1)
. E . L . . L .   (Rail 2)
. . L . . . O .   (Rail 3)

Reading the zigzag pattern from left to right gives us the ciphertext: "HOLELLO."

To decrypt, we need to know the number of rails used (in this case, 3), and we recreate the zigzag pattern. Reading the ciphertext from left to right along the zigzag pattern, we get the original message: "HELLO."

**7. DES (Data Encryption Standard)**

*Definition*
DES is a symmetric-key block cipher that operates on 64-bit blocks of data and uses a 56-bit key. It encrypts and decrypts data in blocks.

If we want to encrypt the plaintext "HELLO" using a specific 56-bit key, the DES algorithm will apply a series of substitutions, permutations, and transformations to produce ciphertext, which is a series of bytes. The example provided earlier demonstrates how to use DES for encryption.

To decrypt the ciphertext back to the original message, the same 56-bit key is used, and the DES decryption algorithm performs the reverse of the encryption process. The example provided earlier demonstrates how to use DES for decryption.
