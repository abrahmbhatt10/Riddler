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
    /*
    Riddle 1 is a cesar shift, so I converted everything into ascii and depending on whether
    it was punctuation, a capital letter, and/or if it was before or after R (so it could loop around),
    I either shifted it up or down towards the correct ascii number it should be, and then converted it back into a char.
     */
    public String decryptOne(String encrypted) {
        //New way of doing it
        String decrypted = "";
        Character shifted;
        for(int i = 0; i < encrypted.length();i++){
            if((encrypted.charAt(i) >= 'A') || (encrypted.charAt(i) <= 'Z'))
            {
                shifted = (char)((encrypted.charAt(i) - 'A' + 9) % 26 + 'A');
                decrypted += shifted.toString();
            }
            else if((encrypted.charAt(i) >= 'a') || (encrypted.charAt(i) <= 'z'))
            {
                shifted = (char)((encrypted.charAt(i) - 'a' + 9) % 26 + 'a');
                decrypted += shifted.toString();
            }
        }
        /* old way of doing it
        String decrypted = "";
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
         */
        System.out.println(decrypted);
        return decrypted;
    }

    /*
    Riddle two uses ascii conversion to each character, so I simply used parseInt to convert each ascii
    number into a char and returned it in decrypted form. I used a regex of space because each number is separated by a space
    and used a.Trim() in order for parseInt() to work properly.
     */
    public String decryptTwo(String encrypted) {
        String decrypted = "";
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

    /*
       Riddle three used 8 binary digits to represent each character,
       so decryptThree uses a regex of separating into 8 binary characters
       in order to convert each binary character using parseInt()
     */
    public String decryptThree(String encrypted) {
        String decrypted = "";
        Character decryptedChar = ' ';
        /*
        \\G does a global match and not just a match in the beginning of the string.
        The regular expression below is splitting the string matching any characters
        into substrings of 8 characters.
         */

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

    /*
    Riddle four uses a unicode shift of 9919,
    which using ascii, can give us each individual character.
    The decryptFour() method initially converts the character into an int.
    Using trial and error, the method eventually worked with substracting
    the integer form of the character by the number 9919 to get its correct ascii value.
    Then, I converted the ascii values for each back into chars.
     */
    public String decryptFour(String encrypted) {
        String decrypted = "";
        Character decryptedChar = ' ';
        for(int i = 0; i < encrypted.length(); i++)
        {
            decryptedChar = (char)((int)(encrypted.charAt(i) - 9919));
            decrypted += decryptedChar.toString();
        }
        System.out.println(decrypted);
        return decrypted;
    }
}
