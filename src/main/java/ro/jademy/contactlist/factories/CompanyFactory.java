package ro.jademy.contactlist.factories;

import ro.jademy.contactlist.model.Company;

import java.util.Scanner;

public class CompanyFactory {
    public static Company createCompany() {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter company name: ");
        String companyName;
        companyName = s.nextLine();

        Company company = new Company(companyName, CompanyAddressFactory.createCompanyAddress());
        company.setName(companyName);

        return company;
    }
}
