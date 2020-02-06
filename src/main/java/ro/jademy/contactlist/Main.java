package ro.jademy.contactlist;

import ro.jademy.contactlist.service.FileUserService;
import ro.jademy.contactlist.service.MemoryUserService;

import java.io.File;

public class Main {
    public static void main(String[] args) {

        // create a contact list of users
        // list contact list in natural order
        // list contact list by a given criteria
        // display a favorites list
        // search by a given or multiple criteria
        // display some statistics for the contact list

        Menu menu = new Menu(new FileUserService("contactsFile.txt"));
        menu.showMenu();

























        //  CONTACTLIST MENU
//        System.out.println();
//        System.out.println("~~~~~ Phone Book ~~~~~");
//        Scanner scan = new Scanner(System.in);
//        while (true) {
//            Menu.showContactListMenu();
//            System.out.print("Choose an option: ");
//            int opt = scan.nextInt();
//            File file = new File("contacts.csv");
//
//            switch (opt) {
//                // View all existing users
//                // categorized by first letter of first name
//                case 1:
//                    FileHandler.readUsersFromFile(file);
//                    break;
//                // Create a new user in memory
//                case 2:
//                    FileHandler.writeUser(file,user);
////                    User user = UserFactory.createUser();
////                    List<User> addedUsersList = new ArrayList<>();
////                    addedUsersList.add(user);
////                    System.out.println("DONE! A new user was added.");
////                    addedUsersList.forEach(System.out::println);
//                    break;
//                // Edit
//                case 3:
//                    break;
//                // Delete
//                case 4:
//                    break;
//                // Search users by firstname
//                case 5:
//                    Search.searchUsers(file);
//                    break;
//                // Exit
//                case 6:
//                    System.exit(0);
//                    break;
//                // Default
//                default:
//                    System.out.print("Choose a valid option! ");
//                    scan.nextInt();
//            }
//        }
    }

}
