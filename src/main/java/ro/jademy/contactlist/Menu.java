package ro.jademy.contactlist;

import ro.jademy.contactlist.model.Address;
import ro.jademy.contactlist.model.Company;
import ro.jademy.contactlist.model.PhoneNumber;
import ro.jademy.contactlist.model.User;
import ro.jademy.contactlist.service.UserService;

import java.util.*;
import java.util.jar.JarOutputStream;
import java.util.stream.IntStream;

public class Menu {

    private Scanner scanner = new Scanner(System.in);
    private UserService userService;

    public Menu(UserService userService) {

        this.userService = userService;
    }

    public void showMenu() {
        while (true) {
            System.out.println("------------- Contact List Menu -------------");
            System.out.println("- 1. View contacts --------------------------");
            System.out.println("- 2. View contact details -------------------");
            System.out.println("- 3. Add contact ----------------------------");
            System.out.println("- 4. Edit contact ---------------------------");
            System.out.println("- 5. Delete contact -------------------------");
            System.out.println("- 6. Search contact -------------------------");
            System.out.println("- 7. Exit -----------------------------------");
            System.out.println("-------------        END        -------------");
            System.out.println("\n");

            System.out.print("Enter menu option -> ");
            int menuOption = scanner.nextInt();

            switch (menuOption) {
                case 1:
                    // Display a list of users
                    if (userService.getContacts() != null && !userService.getContacts().isEmpty()) {
                        userService.getContacts().forEach(u -> System.out.println(u.displayUsers()));
                    } else {
                        System.out.println("NO users in contact list!");
                    }
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
                    Integer maxId = userService.getContacts().size(); // fetch the maximum id from the list
                    Integer userId = maxId + 1;
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
                        Integer Id = scanner.nextInt();

                        Optional<User> userOptEdit = userService.getContactById(Id);
                        if (userOptEdit.isPresent()) {
                            User editedUser = userOptEdit.get();
                            editedUser.viewUserDetails();

                            Integer editId = Id;
                            System.out.println("Edit User First Name: ");
                            String editFirstName = scanner.next();
                            System.out.println("Edit User Last Name: ");
                            String editLastName = scanner.next();
                            scanner.nextLine();
                            System.out.println("Edit User Email: ");
                            String editEmail = scanner.next();
                            System.out.println("Edit User Age: ");
                            Integer editAge = scanner.nextInt();
                            String editHome = "home";
                            System.out.println("Edit Home Number: ");
                            String editHomePhoneNumber = scanner.next();
                            String editWork = "work";
                            System.out.println("Edit Work Number: ");
                            String editWorkPhoneNumber = scanner.next();
                            System.out.println("Edit Address Street Name: ");
                            String editStreetName = scanner.next();
                            scanner.nextLine();
                            System.out.println("Edit Address Street Number: ");
                            Integer editStreetNumber = scanner.nextInt();
                            System.out.println("Edit Address Apartament Number: ");
                            Integer editApartamentNumber = scanner.nextInt();
                            System.out.println("Edit Address Apartament Floor: ");
                            String editApartamentFloor = scanner.next();
                            System.out.println("Edit Address ZipCode: ");
                            String editZipCode = scanner.next();
                            System.out.println("Edit Address City: ");
                            String editCity = scanner.next();
                            System.out.println("Edit Address Country: ");
                            String editCountry = scanner.next();
                            System.out.println("Edit Job Title: ");
                            String editJobTitle = scanner.next();
                            scanner.nextLine();
                            System.out.println("Edit Company Name: ");
                            String editCompanyName = scanner.next();
                            scanner.nextLine();
                            System.out.println("Edit if Contact is Favourite (true) or Not (false): ");
                            boolean editIsFavourite = scanner.nextBoolean();

                            Map<String, PhoneNumber> editedUserPhoneNumbers = new HashMap<>();
                            editedUserPhoneNumbers.put(editHome, new PhoneNumber(editHomePhoneNumber));
                            editedUserPhoneNumbers.put(editWork, new PhoneNumber(editWorkPhoneNumber));

                            Address address = new Address(editStreetName, editStreetNumber, editApartamentNumber, editApartamentFloor, editZipCode, editCity, editCountry);
                            Company company = new Company(editCompanyName, address);

                            userService.editContact(editId, editFirstName, editLastName, editEmail, editAge, editedUserPhoneNumbers, address, editJobTitle, company, editIsFavourite);
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
                    System.out.println("Enter First name of contact you want to search for: ");
                    String query = scanner.next();
                    userService.search(query).forEach(u -> System.out.println(u.displayUsers()));
                    break;
                case 7:
                    System.exit(0);
            }
        }
    }
}


