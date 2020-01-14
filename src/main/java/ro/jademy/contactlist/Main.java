package ro.jademy.contactlist;

import ro.jademy.contactlist.model.Address;
import ro.jademy.contactlist.model.Company;
import ro.jademy.contactlist.model.PhoneNumber;
import ro.jademy.contactlist.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        // Address User 1
        Address user1Address = new Address("Str. Sever Axente",28,2,"3F","075100","Satu Mare","Romania");
        // Address User 2
        Address user2Address = new Address("Str. I.C.Bratianu",151,34,"1A","810093","Braila","Romania");
        // Address User 3
        Address user3Address = new Address("Str. Transilvaniei",18,78,"2D","410412","Oradea","Romania");

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

        // Comapany User 1
        Company user1Company = new Company("Tarom",user1Address);
        // Comapany User 2
        Company user2Company = new Company("Google",user2Address);
        // Comapany User 3
        Company user3Company = new Company("Coltuc si Asociatii",user3Address);

        // Create users
        User user1 = new User("Acsente","Marius","marius@gmail.com",23 ,mapUser1, user1Address,"Pilot", user1Company, true);
        User user2 = new User("Grigore","Andrei","andrei@yahoo.com",27 ,mapUser2, user2Address,"Programator", user2Company, false);
        User user3 = new User("Mihailescu","Cristian-Ionut","ionut4321@microsoft.com",35 ,mapUser3, user3Address,"Avocat", user3Company, true);

        // create a contact list of users

        List<User> usersContactList = new ArrayList<User>();
        usersContactList.add(user1);
        usersContactList.add(user2);
        usersContactList.add(user3);

        for (User user : usersContactList) {
            System.out.println(user.getJobTitle());
        }
        // list contact list in natural order
        // list contact list by a given criteria
        // display a favorites list
        // search by a given or multiple criteria
        // display some statistics for the contact list
    }
}
