package ro.jademy.contactlist.model;
import java.util.*;

public class Search {
    public static void searchUsers() {

        Scanner s = new Scanner(System.in);
        System.out.println("Enter search criteria: ");
        String criteria = s.next();

        List<User> matchedUsers = new ArrayList();

        for (User user : StaticUsers.sortedUsers()) {
            if (criteria.toLowerCase().contains(user.getFirstName().toLowerCase()) || criteria.toLowerCase().contains(user.getLastName().toLowerCase())){
               matchedUsers.add(user);
            }
        }

        User result = matchedUsers
                .stream()
                .sorted(Comparator.comparing(User::getFirstName))
                .findAny()
        .orElse(null);

        System.out.println(Objects.requireNonNull(result).displayUsers());
    }
}
