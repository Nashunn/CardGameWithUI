// School project : CardGame with an UI
//
// Written by Nicolas BOULLET
// Studying at UPMC in Licence Pro Projet Web (2017/2018)

package upmc.pcg.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class Util with methods about the console
 *
 * @author Nicolas BOULLET
 */
public class Console {
    private static Scanner scan;
    
    /**
     * Ask a question and return a string
     */
    public static String askString(String question) {
        String result = "";
        scan = setScanner();
        
        System.out.println(question);
        result = scan.nextLine();
        
        return result;
    }
    
    /**
     * Ask a question and return an integer
     */
    public static Integer askInt(String question) {
        scan = setScanner();
        Integer result = null;
        
        try {
            System.out.println(question);
            result = scan.nextInt();
        }
        catch (InputMismatchException e) {
            System.out.print("(!) Select a number !");
            System.out.println("");
        }
        
        return result;
    }

    public static Scanner setScanner() {
        return new Scanner(System.in);
    }
    
    /**
     * Print a separator line
     */
    public static void printSeparator() {
        System.out.println("\n===============================");
    }
}





