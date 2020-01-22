package ro.jademy.contactlist;
import ro.jademy.contactlist.factories.UserFactory;
import ro.jademy.contactlist.model.*;
import ro.jademy.contactlist.view.Menu;

import java.util.*;
public class Main {

    public static void main(String[] args) {

        //  CONTACTLIST MENU
        System.out.println("~~~~~ Contact List Menu ~~~~~");
        Scanner scan = new Scanner(System.in);

        while(true) {
            Menu.showContactListMenu();
            System.out.print("Choose an option: ");
            int opt = scan.nextInt();

            switch (opt) {
                    // View
                case 1 :
                    StaticUsers.listusers();
                    break;

                    // Add
                case 2:
                    User user = UserFactory.createUser();
                    if (!StaticUsers.sortedUsers().add(user)){
                        System.out.println("Eroare la inregistrare!");
                    } else {
                        System.out.println();
                        System.out.println("DONE! A new user was added.");
                        System.out.println();
                    }
                    break;

                    // Edit
                case 3:
                    break;

                    // Delete
                case 4:
                    break;

                    // Search users by firstname
                case 5:
                    Search.searchUsers();
                    break;

                    // Exit
                case 6:
                    System.exit(0);
                    break;

                    // Default
                default:
                    System.out.print("Choose a valid option! ");
                    scan.nextInt();
            }

        }

//        SEARCH BY FIRST LETTER
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Litera de cautare: ");
//        String letter = scanner.next().toLowerCase();
//
//        List<User> searchList = usersContactList.stream()
//                .filter(s -> s.getFirstName().toLowerCase().startsWith(letter))
//                .collect(Collectors.toList());
//
//        for (User user : searchList) {
//            if(user.getFirstName().length() > 0){
//                System.out.println();
//                System.out.println(user.getFirstName());
//            }
//        }

    }
}
