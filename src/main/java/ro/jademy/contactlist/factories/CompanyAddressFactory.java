package ro.jademy.contactlist.factories;
import ro.jademy.contactlist.model.CompanyAddress;
import java.util.Scanner;

public class CompanyAddressFactory {
    public static CompanyAddress createCompanyAddress() {
        Scanner s = new Scanner(System.in);

        System.out.println("Company street name: ");
        String compStreeName = s.next();
        s.nextLine();

        System.out.println("Company street number: ");
        Integer compStreetNumber = s.nextInt();

        System.out.println("Company city: ");
        String compCity = s.next();

        System.out.println("Company country: ");
        String compCountry = s.next();

        CompanyAddress companyAddress = new CompanyAddress();
        companyAddress.setCompanyCountry(compCountry);
        companyAddress.setCompanyCity(compCity);
        companyAddress.setCompanyStreeName(compStreeName);
        companyAddress.setCompanyStreetNumber(compStreetNumber);

        return companyAddress;
    }
}
