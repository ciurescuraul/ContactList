package ro.jademy.contactlist.factories;
import ro.jademy.contactlist.model.Address;
import java.util.Scanner;

public class AddressFactory {

    public static Address createAddress() {

        Address address = new Address();

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter street name: ");
        String streetName = scan.nextLine();

        System.out.println("Enter street number: ");
        Integer streetNr = scan.nextInt();

        System.out.println("Enter city: ");
        String city = scan.next();

        System.out.println("Enter country: ");
        String country = scan.next();

        address.setCountry(country);
        address.setCity(city);
        address.setStreetName(streetName);
        address.setStreetNumber(streetNr);

        return address;
    }
}
