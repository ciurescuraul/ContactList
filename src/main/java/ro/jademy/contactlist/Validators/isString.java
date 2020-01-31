package ro.jademy.contactlist.Validators;

import java.util.Scanner;

public class isString {
    public static String isString(Scanner in) {

        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        while (!input.isEmpty() && !input.matches("[a-zA-Z]+")){
            System.out.println("Please enter only characters");
            input = scan.next();
        }
        return input;
    }
}
