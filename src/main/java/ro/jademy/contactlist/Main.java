package ro.jademy.contactlist;

import ro.jademy.contactlist.model.Address;
import ro.jademy.contactlist.model.Company;
import ro.jademy.contactlist.model.PhoneNumber;
import ro.jademy.contactlist.model.User;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        // Phones User 1
        PhoneNumber phoneUser1Nr1 = new PhoneNumber("(+40)","(740)-123.123");
        PhoneNumber phoneUser1Nr2 = new PhoneNumber("(+40)","(761)-341.622");
        // Phones User 2
        PhoneNumber phoneUser2Nr1 = new PhoneNumber("(+40)","(720)-987.654");
        PhoneNumber phoneUser2Nr2 = new PhoneNumber("(+40)","(745)-582.582");
        // Phones User 3
        PhoneNumber phoneUser3Nr1 = new PhoneNumber("(+40)","(259)-244.060");
        PhoneNumber phoneUser3Nr2 = new PhoneNumber("(+40)","(734)-200.125");
        // Phones User 4
        PhoneNumber phoneUser4Nr1 = new PhoneNumber("(+40)","(322)-533.644");
        PhoneNumber phoneUser4Nr2 = new PhoneNumber("(+40)","(731)-800.658");

        // Address User 1
        Address user1Address = new Address("Str. Sever Axente",28,2,"3F","075100","Satu Mare","Romania");
        // Address User 2
        Address user2Address = new Address("Str. I.C.Bratianu",151,34,"1A","810093","Braila","Romania");
        // Address User 3
        Address user3Address = new Address("Str. Transilvaniei",18,78,"2D","410412","Oradea","Romania");
        // Address User 4
        Address user4Address = new Address("Str. 23 August",188,null,"","078685","Otopeni","Romania");

        // Map User 1
        Map<String, PhoneNumber> mapUser1 = new HashMap<>();
        mapUser1.put("Work",phoneUser1Nr1);
        mapUser1.put("Home",phoneUser1Nr2);
        // Map User 2
        Map<String, PhoneNumber> mapUser2 = new HashMap<>();
        mapUser2.put("Work",phoneUser2Nr1);
        mapUser2.put("Home",phoneUser2Nr2);
        // Map User 3
        Map<String, PhoneNumber> mapUser3 = new HashMap<>();
        mapUser3.put("Work",phoneUser3Nr2);
        mapUser3.put("Home",phoneUser3Nr1);
        // Map User 4
        Map<String, PhoneNumber> mapUser4 = new HashMap<>();
        mapUser4.put("Work",phoneUser4Nr2);
        mapUser4.put("Home",phoneUser4Nr1);

        // Company User 1
        Company user1Company = new Company("Tarom",user1Address);
        // Company User 2
        Company user2Company = new Company("Google",user2Address);
        // Company User 3
        Company user3Company = new Company("Coltuc si Asociatii",user3Address);
        // Company User 4
        Company user4Company = new Company("Cyber It Solutions",user4Address);

        // Create users
        User user1 = new User("Absence","Marius","123marius@gmail.com",23 ,mapUser1, user1Address,"Pilot", user1Company, true);
        User user2 = new User("Gregor","Andrei","grigore@yahoo.com",45 ,mapUser2, user2Address,"Programmer", user2Company, false);
        User user3 = new User("Michail's","Cristian-Inonu","ionut4321@microsoft.com",35 ,mapUser3, user3Address,"Advocate", user3Company, true);
        User user4 = new User("Cristen","Alexandre","23543cristen@outlook.com",18 ,mapUser4, user4Address,"Entrepreneur", user4Company, false);

        // CREATE A CONTACT LIST OF USERS

        List<User> usersContactList = new ArrayList<>();
        usersContactList.add(user1);
        usersContactList.add(user2);
        usersContactList.add(user3);
        usersContactList.add(user4);

        // LIST CONTACT LIST IN NATURAL ORDER
        System.out.println("-----------------------------------------------------------");
        System.out.println("#1 ~~ Contact List displayed in Natural Order ~~");
        System.out.println("-----------------------------------------------------------");
        usersContactList
                .stream()
                .sorted(Comparator.naturalOrder())
                .forEach(System.out::println);

        // LIST CONTACT LIST BY A GIVEN CRITERIA
        System.out.println("-----------------------------------------------------------");
        System.out.println("#2 ~~ Contact List displayed by a Given Criteria ~~ In this case by --> AGE <--");
        System.out.println("-----------------------------------------------------------");
        usersContactList
                .stream()
                .sorted(Comparator.comparing(User::getAge))  //#1 (o1,o2) -> o1.getAge().compareTo(o2.getAge())
                                                             //#2 Comparator.comparing(User::getAge)
                .forEach(System.out::println);

        // DISPLAY A FAVORITES LIST
        System.out.println("-----------------------------------------------------------");
        System.out.println("#3 ~~ Displaying all the Favourites contacts from our Contact List ~~");
        System.out.println("-----------------------------------------------------------");
        usersContactList
                .stream()
                .filter(User::isFavorite)
                .forEach(System.out::println);

        // search by a given or multiple criteria
        System.out.println("-----------------------------------------------------------");
        System.out.println("#4 ~~ Contact List displayed by a Given or Multiple Criteria ~~");
        System.out.println("-----------------------------------------------------------");
        usersContactList
                .stream()
                .sorted(Comparator.comparing(User::getEmail))
                .forEach(System.out::println);

        // display some statistics for the contact list
        System.out.println("-----------------------------------------------------------");
        System.out.println("#4 ~~ Displaying Statistics ~~");
        System.out.println("-----------------------------------------------------------");
        int stats = usersContactList
                            .size();
        System.out.println("In Contact List you have " + stats + " contacts");

                }
}
