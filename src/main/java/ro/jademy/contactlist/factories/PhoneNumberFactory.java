package ro.jademy.contactlist.factories;

import ro.jademy.contactlist.model.PhoneNumber;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneNumberFactory {

    public static Map<String,PhoneNumber> createPhoneNumbers(){

        Map<String, PhoneNumber> phoneNumbersMap = new HashMap<>();

        PhoneNumber homeNumber = new PhoneNumber();
        PhoneNumber workNumber = new PhoneNumber();

        Scanner s = new Scanner(System.in);

        System.out.println("Enter country prefix for Home Phone number: ");
        String homePrefix = s.next();

        System.out.println("Enter Home Phone number: ");
        String homePhoneNumber = s.next();

        System.out.println("Enter country prefix for Work Phone number: ");
        String workPrefix = s.next();

        System.out.println("Enter Home Phone number: ");
        String workPhoneNumber = s.next();

        // Object Home Phone Number
        homeNumber.setCountryCode(homePrefix);
        homeNumber.setNumber(homePhoneNumber);

        // Object Home Phone Number
        workNumber.setCountryCode(workPrefix);
        workNumber.setNumber(workPhoneNumber);

        // Map List of keys and objects
        phoneNumbersMap.put("Home", homeNumber);
        phoneNumbersMap.put("Work", workNumber);

        return phoneNumbersMap;
    }
}
