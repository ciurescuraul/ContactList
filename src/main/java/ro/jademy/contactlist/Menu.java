package ro.jademy.contactlist;

import ro.jademy.contactlist.model.Address;
import ro.jademy.contactlist.model.Company;
import ro.jademy.contactlist.model.PhoneNumber;
import ro.jademy.contactlist.model.User;
import ro.jademy.contactlist.service.UserService;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.naturalOrder;

public class Menu {

    private Scanner scanner = new Scanner(System.in);
    private UserService userService;

    public Menu(UserService userService) {
        this.userService = userService;
    }

    public void showMenu() {
        String[] menuList = {
                "List Contacts",
                "View Contact Details",
                "Add Contact",
                "Edit Contact Fields",
                "Delete Contact",
                "Search Contact",
                "View Favourites",
                "Create Backup File",
                "EXIT",
        };
        String header = "~~~~~~~~~~~~~ Contact List Menu ~~~~~~~~~~~~~";
        String footer = "~~~~~~~~~~~~~~~~~~~~ End ~~~~~~~~~~~~~~~~~~~~";
        boolean exit = false;
        while (!exit) {
            System.out.println(header);
            for (int i = 0; i < menuList.length; i++) {
                System.out.printf("\t %1d\t ~ \t%s\n", i + 1, menuList[i]);
            }
            System.out.println(footer);
            String opt = "";
            while (!opt.matches("^[1-9]\\d*$") || Integer.parseInt(opt) > menuList.length) {
                System.out.print("Enter option : ");
                opt = scanner.next();
            }
            exit = menuOptions(Integer.parseInt(opt));
        }
    }


    private boolean menuOptions(int i) {
        switch (i) {
            case 1:
                System.out.println();
                System.out.println(" All contacts \n");
                // Display a list of users
                if (userService.getContacts() != null && !userService.getContacts().isEmpty()) {
                    // Display users asociated to first char of user First name
                    List<User> users = userService.getContacts().stream().sorted(Comparator.comparing(User::getFirstName)).collect(Collectors.toList());
                    Map<Character, List<User>> sortedUsersMap = users.stream().collect(Collectors.groupingBy(
                            user -> user.getFirstName().charAt(0),
                            TreeMap::new,
                            Collectors.toList()
                    ));
                    if (!sortedUsersMap.isEmpty()) {
                        for (Map.Entry<Character, List<User>> entry : sortedUsersMap.entrySet()) {
                            System.out.println("--- " + entry.getKey() + " ---");
                            entry.getValue().forEach(u -> System.out.println(u.displayUsers()));
                        }
                    }
                    // How many users are in contactList
                    int size = userService.getContacts().size();
                    if (size == 1) {
                        System.out.println("You have only " + size + " contact\n");
                    } else if (size > 1) {
                        System.out.println(" You have " + size + " contacts\n");
                    } else {
                        System.out.println("NO users in contact list!\n");
                    }
                }
                System.out.println();
                break;
            case 2:
                // View contact details
                System.out.print("Please enter UserId to see details: ");
                int id = scanner.nextInt();

                Optional<User> userOpt = userService.getContactById(id);
                if (userOpt.isPresent()) {
                    User user = userOpt.get();
                    user.viewUserDetails();
                } else {
                    System.out.println("Sorry, no user with id " + id + " exists");
                }

                break;
            case 3:
                // Add contacts to Contact list
                int maxId = userService.getContacts().size();
                Integer userId = maxId + 10; // fetch the maximum id from the list

//                    IntSummaryStatistics stats = userService.getContacts().stream()
//                            .mapToInt(User::getUserId)
//                            .summaryStatistics();
//                    Integer userId = stats.getMax() + 1; // fetch the maximum id from the list

                System.out.println("Enter First name: ");
                String firstName = scanner.next();
                System.out.println("Enter Last name: ");
                String lastName = scanner.next();
                System.out.println("Enter Phone number: ");
                String phoneNumber = scanner.next();

                User user = new User(userId, firstName, lastName, phoneNumber);
                userService.addContact(user);
                break;
            case 4:
                // Edit a contact from Contact list
                try {
                    System.out.println("Enter an id for user you want to edit: ");
                    int Id = scanner.nextInt();

                    Optional<User> userOptEdit = userService.getContactById(Id);
                    if (userOptEdit.isPresent()) {
                        User userToEdit = userOptEdit.get();
                        userToEdit.viewUserDetails();
                        editUser(userToEdit);

                    } else {
                        System.out.println("Sorry, no user with id " + Id + " exists in Contact List");
                        System.exit(0);
                    }
                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                }
                break;
            case 5:
                // Remove a contact by ID
                System.out.println("Enter an ID for user you want to Delete: ");
                int removeId = scanner.nextInt();
                Optional<User> removeUserOpt = userService.getContactById(removeId);

                if (removeUserOpt.isPresent()) {
                    int userDel = removeUserOpt.get().getUserId();
                    userService.removeContact(userDel);
                    System.out.println("User was succesfully Deleted !");
                } else {
                    System.out.println("Sorry, no user with id " + removeId + " exists");
                }
                break;
            case 6:
                // Search for a user
                System.out.println("Search for a contact: ");
                String query = scanner.next();
                userService.search(query).forEach(u -> System.out.println(u.displayUsers()));
                break;
            case 7:
                List<User> favUsers = userService.getContacts().stream()
                        .sorted(Comparator.comparing(User::getFirstName))
                        .filter(User::isFavorite)
                        .collect(Collectors.toList());
                Map<Character, List<User>> sortedUsersMap = favUsers.stream().collect(Collectors.groupingBy(
                        u -> u.getFirstName().charAt(0),
                        TreeMap::new,
                        Collectors.toList()
                ));
                System.out.println("--- Favourite Users ---");
                System.out.println();
                if (!sortedUsersMap.isEmpty() && sortedUsersMap != null) {
                    for (Map.Entry<Character, List<User>> entry : sortedUsersMap.entrySet()) {
                        System.out.println("~~~~~ " + entry.getKey() + " ~~~~~");
                        entry.getValue().stream().filter(User::isFavorite).forEach(u -> System.out.println(u.displayUsers())); // Display favourite users by first char of firstname in natural order
                    }
                } else {
                    System.out.println("No favourite users to display.");
                }
                System.out.println("-----------------------");
                break;
            case 8:
                System.exit(0);
                break;
            case 9:
                System.exit(0);
                break;
        }
        return false;
    }


    private User editUser(User user) {

        String[] editFields = {
                "Edit First Name",
                "Edit Last Name",
                "Edit Email",
                "Change Age",
                "Update Phone Numbers",
                "Update Address",
                "Replace Job Title",
                "Change Company",
                "Edit Is Favourite",
                "Return to Main Menu",
        };
        boolean exit = false;
        while (!exit) {
            System.out.println("Edit user: " + user.getFirstName() + " " + user.getLastName());
            System.out.println("Choose what field you want to update");
            for (int i = 0; i < editFields.length; i++) {
                System.out.printf("\t %1d\t ~ \t%s\n", i + 1, editFields[i]);
            }
            String opt = "";
            while (!opt.matches("^[1-9]\\d*$") || (Integer.parseInt(opt) > editFields.length)) {
                System.out.println("Enter valid option : ");
                opt = scanner.next();
            }
            switch (Integer.parseInt(opt)) {
                case 1:
                    System.out.println("Enter new first name : ");
                    user.setFirstName(scanner.next());
                    break;
                case 2:
                    System.out.println("Enter new last name : ");
                    user.setLastName(scanner.next());
                    scanner.nextLine();
                    break;
                case 3:
                    System.out.println("Enter new email address : ");
                    user.setEmail(scanner.next());
                    break;
                case 4:
                    System.out.println("Change age : ");
                    user.setAge(scanner.nextInt());
                    break;
                case 5:
                    Map<String, PhoneNumber> phoneNumberMap = new HashMap<>();
                    System.out.println("Enter new home phone number : ");
                    phoneNumberMap.put("Home", new PhoneNumber(scanner.next()));
                    System.out.println("Enter new work phone number : ");
                    phoneNumberMap.put("Work", new PhoneNumber(scanner.next()));
                    user.setPhoneNumbers(phoneNumberMap);
                    break;
                case 6:
                    System.out.println("Enter new fields for the address");
                    System.out.println("Enter street name : ");
                    String streetName = scanner.next();
                    scanner.nextLine();
                    System.out.println("Enter street number : ");
                    int streetNr = scanner.nextInt();
                    System.out.println("Enter apartament number : ");
                    int apartNr = scanner.nextInt();
                    System.out.println("Enter apartament floor : ");
                    String floor = scanner.next();
                    System.out.println("Enter ZipCode : ");
                    String zipCode = scanner.next();
                    System.out.println("Enter city : ");
                    String city = scanner.next();
                    System.out.println("Enter country");
                    String country = scanner.next();

                    user.setAddress(new Address(streetName, streetNr, apartNr, floor, zipCode, city, country));

                    break;
                case 7:
                    System.out.println("Change job title : ");
                    user.setJobTitle(scanner.next());
                    break;
                case 8:
                    System.out.println("Modify company : ");
                    user.setCompany(new Company(scanner.next()));
                    scanner.nextLine();
                    break;
                case 9:
                    System.out.println("Change IsFavourite status (true/false) : ");
                    user.setFavorite(scanner.nextBoolean());
                    break;
                case 10:
                    exit = true;
            }

        }
        return user;
    }
}


