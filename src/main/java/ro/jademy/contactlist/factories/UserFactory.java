package ro.jademy.contactlist.factories;
import ro.jademy.contactlist.model.User;
import java.util.Scanner;

public class UserFactory {
    public static User createUser() {
        User user = new User();

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the ID for the user.");
        int id = scan.nextInt();

        System.out.println("Enter firstname: ");
        String firstname = scan.next();

        System.out.println("Enter lastname: ");
        String lastname = scan.next();

        System.out.println("Enter email: ");
        String email = scan.next();

        System.out.println("Enter age: ");
        int age = scan.nextInt();

        System.out.println("Enter job title: ");
        String jobtitle = scan.next();
        scan.nextLine();

        System.out.println("Is favourite ?: ");
        boolean isfavourite = scan.nextBoolean();

        user.setId(id);
        user.setFirstName(firstname);
        user.setLastName(lastname);
        user.setEmail(email);
        user.setAge(age);
        user.setPhoneNumbers(PhoneNumberFactory.createPhoneNumbers());
        user.setAddress(AddressFactory.createAddress());
        user.setJobTitle(jobtitle);
        user.setCompany(CompanyFactory.createCompany());
        user.setFavorite(isfavourite);

        return user;
    }

}
