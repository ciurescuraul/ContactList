package ro.jademy.contactlist.model;

import java.util.*;
import java.util.stream.Collectors;

public class StaticUsers {
    public static List<User> sortedUsers() {

        // Phones User 1
        PhoneNumber phoneUser1Nr1 = new PhoneNumber("(+40)", "(740)-123.123");
        PhoneNumber phoneUser1Nr2 = new PhoneNumber("(+40)", "(761)-341.622");
        // Phones User 2
        PhoneNumber phoneUser2Nr1 = new PhoneNumber("(+40)", "(720)-987.654");
        PhoneNumber phoneUser2Nr2 = new PhoneNumber("(+40)", "(745)-582.582");
        // Phones User 3
        PhoneNumber phoneUser3Nr1 = new PhoneNumber("(+40)", "(259)-244.060");
        PhoneNumber phoneUser3Nr2 = new PhoneNumber("(+40)", "(734)-200.125");
        // Phones User 4
        PhoneNumber phoneUser4Nr1 = new PhoneNumber("(+40)", "(322)-533.644");
        PhoneNumber phoneUser4Nr2 = new PhoneNumber("(+40)", "(731)-800.658");
        // Phones User 5
        PhoneNumber phoneUser5Nr1 = new PhoneNumber("(+40)", "(588)-750.875");
        PhoneNumber phoneUser5Nr2 = new PhoneNumber("(+40)", "(789)-200.300");
        // Phones User 6
        PhoneNumber phoneUser6Nr1 = new PhoneNumber("(+40)", "(988)-001.542");
        PhoneNumber phoneUser6Nr2 = new PhoneNumber("(+40)", "(750)-400.800");

        // Address User 1
        Address user1Address = new Address("Str. Sever Axente", 28, 2, "3F", "075100", "Satu Mare", "Romania");
        // Address User 2
        Address user2Address = new Address("Str. I.C.Bratianu", 151, 34, "1A", "810093", "Braila", "Romania");
        // Address User 3
        Address user3Address = new Address("Str. Transilvaniei", 18, 78, "2D", "410412", "Oradea", "Romania");
        // Address User 4
        Address user4Address = new Address("Str. 23 August", 188, null, "", "078685", "Otopeni", "Romania");
        // Address User 5
        Address user5Address = new Address("Str. Mitropoliei", 56, 2, "1", "589632", "Bucuresti", "Romania");
        // Address User 6
        Address user6Address = new Address("Calea Bucurestilor ", 12, 56, "2T", "852963", "Iasi", "Romania");

        // CompanyAddress User 1
        CompanyAddress user1cAddress = new CompanyAddress("Str. Sever Axente", 28, "Satu Mare", "Romania");
        // CompanyAddress User 2
        CompanyAddress user2cAddress = new CompanyAddress("Str. I.C.Bratianu", 151, "Braila", "Romania");
        // CompanyAddress User 3
        CompanyAddress user3cAddress = new CompanyAddress("Str. Transilvaniei", 18, "Oradea", "Romania");
        // CompanyAddress User 4
        CompanyAddress user4cAddress = new CompanyAddress("Str. 23 August", 188, "Otopeni", "Romania");
        // CompanyAddress User 5
        CompanyAddress user5cAddress = new CompanyAddress("Str. Mitropoliei", 56, "Bucuresti", "Romania");
        // CompanyAddress User 6
        CompanyAddress user6cAddress = new CompanyAddress("Calea Bucurestilor ", 12, "Iasi", "Romania");

        // Map User 1
        Map<String, PhoneNumber> phoneNumberMapUser1 = new HashMap<>();
        phoneNumberMapUser1.put("Work", phoneUser1Nr1);
        phoneNumberMapUser1.put("Home", phoneUser1Nr2);
        // Map User 2
        Map<String, PhoneNumber> phoneNumberMapUser2 = new HashMap<>();
        phoneNumberMapUser2.put("Work", phoneUser2Nr1);
        phoneNumberMapUser2.put("Home", phoneUser2Nr2);
        // Map User 3
        Map<String, PhoneNumber> phoneNumberMapUser3 = new HashMap<>();
        phoneNumberMapUser3.put("Work", phoneUser3Nr2);
        phoneNumberMapUser3.put("Home", phoneUser3Nr1);
        // Map User 4
        Map<String, PhoneNumber> phoneNumberMapUser4 = new HashMap<>();
        phoneNumberMapUser4.put("Work", phoneUser4Nr2);
        phoneNumberMapUser4.put("Home", phoneUser4Nr1);
        // Map User 5
        Map<String, PhoneNumber> phoneNumberMapUser5 = new HashMap<>();
        phoneNumberMapUser5.put("Work", phoneUser5Nr2);
        phoneNumberMapUser5.put("Home", phoneUser5Nr1);
        // Map User 4
        Map<String, PhoneNumber> phoneNumberMapUser6 = new HashMap<>();
        phoneNumberMapUser6.put("Work", phoneUser6Nr2);
        phoneNumberMapUser6.put("Home", phoneUser6Nr1);

        // Company User 1
        Company user1Company = new Company("Tarom", user1cAddress);
        // Company User 2
        Company user2Company = new Company("Google", user2cAddress);
        // Company User 3
        Company user3Company = new Company("Coltuc si Asociatii", user3cAddress);
        // Company User 4
        Company user4Company = new Company("Cyber It Solutions", user4cAddress);
        // Company User 5
        Company user5Company = new Company("Cyber It Solutions", user5cAddress);
        // Company User 6
        Company user6Company = new Company("Cyber It Solutions", user6cAddress);

        // Create users

        User user1 = new User(1, "Absence", "Marius", "123marius@gmail.com", 23, phoneNumberMapUser1, user1Address, "Pilot", user1Company, true);
        User user2 = new User(2, "Gregor", "Andrei", "grigore@yahoo.com", 45, phoneNumberMapUser2, user2Address, "Programmer", user2Company, false);
        User user3 = new User(3, "Michail's", "Cristian-Inonu", "ionut4321@microsoft.com", 35, phoneNumberMapUser3, user3Address, "Advocate", user3Company, true);
        User user4 = new User(4, "Cristen", "Alexandre", "23543cristen@outlook.com", 18, phoneNumberMapUser4, user4Address, "Entrepreneur", user4Company, false);
        User user5 = new User(5, "Alexandru", "Marcel", "marcel2020@gmail.com", 31, phoneNumberMapUser5, user5Address, "Cercetator", user5Company, true);
        User user6 = new User(6, "Aurelian", "Eusebiu", "eus_ebiu@gmail.com", 27, phoneNumberMapUser6, user6Address, "Inginer", user6Company, false);

        // CREATE A CONTACT LIST OF USERS
        List<User> usersContactList = new ArrayList<>();
        usersContactList.add(user1);
        usersContactList.add(user2);
        usersContactList.add(user3);
        usersContactList.add(user4);
        usersContactList.add(user5);
        usersContactList.add(user6);

        List<User> sortedUsers = usersContactList
                .stream()
                .sorted(Comparator.comparing(User::getFirstName))
                .collect(Collectors.toList());



        return sortedUsers;
    }

    public static void listusers() {
        Map<Character, List<User>> usersSortMap = sortedUsers()
                .stream()
                .collect(Collectors.groupingBy(
                        user -> user.getFirstName().charAt(0),
                        () -> new TreeMap<>(), //TreeMap::new,
                        Collectors.toList()));

        for (Map.Entry<Character, List<User>> entry : usersSortMap.entrySet()) {
            Character character = entry.getKey();

            System.out.println();
            System.out.println("     ~ " + character + " ~     ");
            System.out.println();

            List<User> listaUseri = entry.getValue();

            for (User user : listaUseri) {
                System.out.println(user.displayUsers());
            }
            System.out.println();
        }
    }
}