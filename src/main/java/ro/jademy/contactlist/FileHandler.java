package ro.jademy.contactlist;

import org.apache.commons.validator.routines.EmailValidator;
import ro.jademy.contactlist.model.PhoneNumber;
import ro.jademy.contactlist.model.User;

import java.io.*;
import java.util.*;

public class FileHandler {
    public static List<User> readUsersFromFile(File file) {
        Map<Character, List<User>> mapUsersList = new TreeMap<>();
        List<User> usersList = new ArrayList<>();

        // Reading file
        String read;
        try (
                BufferedReader out = new BufferedReader(new FileReader(file))) {
            while ((read = out.readLine()) != null) {
                String[] stringSplit = read.split("[\\|,_]");

                Integer generatedId = RandomID.generateId();

                Integer userId = generatedId;
                String firstName = stringSplit[0];
                String lastName = stringSplit[1];
                String homeCategory = stringSplit[2];
                String homePrefix = stringSplit[3];
                String homeNumber = stringSplit[4];
                String workCategory = stringSplit[5];
                String workPrefix = stringSplit[6];
                String workNumber = stringSplit[7];
                String email = stringSplit[8];

                Map<String, PhoneNumber> phoneNumberMap = new HashMap<>();

                User user = new User(userId, firstName, lastName, homeNumber);

                phoneNumberMap.put(homeCategory, new PhoneNumber(homePrefix, homeNumber)); //  Home
                phoneNumberMap.put(workCategory, new PhoneNumber(workPrefix, workNumber)); //  Work

                usersList.add(user); // Make object from file

                mapUsersList.put(firstName.charAt(0),usersList); // Map the list of users with first character in their firstname
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }




        mapUsersList.entrySet()
                .forEach(entry->{
            System.out.println(entry.getKey());
            for (User user : usersList) {
                if (entry.getKey().equals(user.getFirstName().charAt(0))){
                    System.out.println(user.displayUsers());
                    user.getPhoneNumbers();
                }
            }
        });
        return usersList;
    }



// Writing user to file
    public static void writeUser(File file, User user) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter firstname: ");
        String fn = input.nextLine();
        while (!fn.isEmpty() && !fn.matches("[a-zA-Z]+")) {
            System.out.println("Please enter only characters");
            fn = input.nextLine();
        }

        System.out.println("Enter lastname: ");
        String ln = input.nextLine();
        while (!ln.isEmpty() && !ln.matches("[a-zA-Z]+")) {
            System.out.println("Please enter only characters");
            ln = input.nextLine();
        }
        Integer wNr;
        do {
            System.out.println("Enter Work Number: ");
            while (!input.hasNextInt()) {
                System.out.println("That's not a phone number");
                input.nextInt();
            }
            wNr = input.nextInt();
        } while (wNr < 0);

        Integer hNr;
        do {
            System.out.println("Enter Home Number: ");
            while (!input.hasNextInt()) {
                System.out.println("That's not a phone number");
                input.nextInt();
            }
            hNr = input.nextInt();
        } while (hNr < 0);

        System.out.println("Enter email: ");
        EmailValidator validator = EmailValidator.getInstance();
        String email = input.next();
        if (validator.isValid(email)) {
            System.out.println("DONE!");
        } else {
            System.out.println("Invalid email, please try again");
            input.nextLine();
        }
        BufferedWriter in;
        try {
            in = new BufferedWriter(new FileWriter(file, true));
            in.newLine();
            in.append(fn).append("|");
            in.append(ln).append("|");
            in.append("work_+40_" + wNr + ",");
            in.append("home_+40_" + hNr + "|");
            in.append(email);
            in.flush();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
