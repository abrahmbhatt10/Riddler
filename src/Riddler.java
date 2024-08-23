import java.util.ArrayList;

/**
 * The Riddler:
 * A puzzle by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
 *
 * Completed by: AGASTYA BRAHMBHATT
 */
public class Riddler {

    public String decryptOne(String encrypted) {
        String decrypted = "";
        // TODO: Complete the decryptOne() function.
        char shiftedBy = 'j' - 'a';
        char loopBy = 'R' - 'A';
        Character decryptedChar = ' ';
        for(int i = 0; i < encrypted.length(); i++)
        {
            if((encrypted.charAt(i) >= 'R' && encrypted.charAt(i) <= 'Z') || (encrypted.charAt(i) >= 'r' && encrypted.charAt(i) <= 'z'))
            {
                decryptedChar = (char)((int)encrypted.charAt(i) - loopBy);
            }
            else if(encrypted.charAt(i) == ' ' || encrypted.charAt(i) == '.' || encrypted.charAt(i) == ',' || encrypted.charAt(i) == ':')
            {
                decryptedChar = encrypted.charAt(i);
            }
            else
            {
                decryptedChar = (char)((int)encrypted.charAt(i) + shiftedBy);
            }
            decrypted += decryptedChar.toString();
        }
        System.out.println(decrypted);
        return decrypted;
    }

    public String decryptTwo(String encrypted) {
        String decrypted = "";
        // TODO: Complete the decryptTwo() function.
        Character decryptedChar = ' ';
        String[] numArray = encrypted.split(" ");
        String aTrim;
        for(String a : numArray)
        {
            aTrim = a.trim();
            decryptedChar = (char) Integer.parseInt(aTrim);
            decrypted += decryptedChar.toString();
        }
        System.out.println(decrypted);
        return decrypted;
    }

    public String decryptThree(String encrypted) {
        String decrypted = "";
        // TODO: Complete the decryptThree() function.
        Character decryptedChar = ' ';
        String[] numArray = encrypted.split("(?<=\\G.{8})");
        String aTrim;
        for(String a : numArray)
        {
            aTrim = a.trim();
            decryptedChar = (char) Integer.parseInt(aTrim, 2);
            decrypted += decryptedChar.toString();
        }
        System.out.println(decrypted);
        return decrypted;
    }

    public String decryptFour(String encrypted) {
        String decrypted = "";
        // TODO: Complete the decryptFour() function.
        Character decryptedChar = ' ';
        char shiftedBy = 'j' - 'a';
        char loopBy = 'R' - 'A';
        for(int i = 0; i < encrypted.length(); i++)
        {
            decryptedChar = (char)((int)(encrypted.charAt(i) - 9919));
            decrypted += decryptedChar.toString();
        }
        System.out.println(decrypted);
        return decrypted;
    }
}
