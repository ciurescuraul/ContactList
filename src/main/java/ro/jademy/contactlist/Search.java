package ro.jademy.contactlist;

import ro.jademy.contactlist.model.User;

import java.io.File;
import java.util.*;

public class Search {
    public static void searchUsers(File file) {

        Scanner s = new Scanner(System.in);
        System.out.println("Enter search criteria: ");
        String criteria = s.next();

        try {
            List<User> matchedUsers = new ArrayList();
            for (User user : FileHandler.readUsersFromFile(file)) {
                if (user.getFirstName().toLowerCase().equals(criteria.toLowerCase())) {
                    matchedUsers.add(user);
                }
            }
            for (User matchedUser : matchedUsers) {
                if (matchedUser.getFirstName().toLowerCase().equals(criteria.toLowerCase())){
                    System.out.println("------------------------------------------------------");
                    System.out.println("I found a match for the search criteria you've entered");
                    System.out.println(matchedUser.getFirstName() + " " + matchedUser.getLastName());
                    matchedUser.getPhoneNumbers();
                    System.out.println("------------------------------------------------------");
                }
            }
//            matchedUsers
//                    .stream()
//                    .sorted(Comparator.comparing(User::getFirstName))
//                    .count();
        } catch (Exception e) {
            System.out.println("This user does not exist !");
        }
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
