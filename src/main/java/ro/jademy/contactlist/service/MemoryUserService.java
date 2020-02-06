package ro.jademy.contactlist.service;

import ro.jademy.contactlist.model.Address;
import ro.jademy.contactlist.model.Company;
import ro.jademy.contactlist.model.PhoneNumber;
import ro.jademy.contactlist.model.User;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MemoryUserService implements UserService {

    private List<User> contacts = new ArrayList<>();

    @Override
    public List<User> getContacts() {

        // check if contacts is empty and init the contact list only if this is true
        if (contacts.isEmpty()) {
            contacts.addAll(initContacts()); // get the contacts from the init method and add them to the contacts list, which should be used through the program
        }

        // else return the current list of contacts
        return contacts;
    }

    @Override
    public Optional<User> getContactById(int userId) {
        return contacts.stream().filter(u -> u.getUserId() == userId).findFirst();
    }

    @Override
    public void addContact(User contact) {
        // add user to contact list
        contacts.add(contact);
    }

    @Override
    public void editContact(int userId, String firstName, String lastName, String email, Integer age, Map<String, PhoneNumber> phoneNumbers, Address address, String jobTitle, Company company, boolean isFavorite) {
        Optional<User> userOpt = getContactById(userId);
        // edit the contact only if the user was found
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            int index = contacts.indexOf(user);

            user.setUserId(userId);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(email);
            user.setAge(age);
            user.setPhoneNumbers(phoneNumbers);
            user.setAddress(address);
            user.setJobTitle(jobTitle);
            user.setCompany(company);
            user.setFavorite(isFavorite);

            contacts.set(index, user);

            // TODO.txt: use setters and update the user
        }
    }

    @Override
    public void removeContact(int userId) {
        Optional<User> userOpt = getContactById(userId);

        // remove the contact only if found
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            contacts.remove(user);
        }
    }

    @Override
    public List<User> search(String query) {
        List<User> byFirstName = contacts
                .stream()
                .filter(f -> f.getFirstName() != null)
                .filter(f -> f.getFirstName().toLowerCase().equals(query.toLowerCase()))
                .filter(l -> l.getLastName() != null)
                .filter(l -> l.getLastName().toLowerCase().equals(query.toLowerCase()))
                .collect(Collectors.toList());
        List<User> byLastName = contacts
                .stream()
                .filter(l -> l.getLastName() != null)
                .filter(l -> l.getLastName().toLowerCase().equals(query.toLowerCase()))
                .collect(Collectors.toList());

        List<User> result = new ArrayList<>();
        result.addAll(byFirstName);
        result.addAll(byLastName);
        // TODO.txt: implement method
        return result;
    }

    private List<User> initContacts() {
        Map<String, PhoneNumber> firstUserPhoneNumbers = new HashMap<>();
        firstUserPhoneNumbers.put("home", new PhoneNumber("740123456"));
        firstUserPhoneNumbers.put("work", new PhoneNumber("740111222"));

        Address firstUserAddress = new Address("Some Street", 1, "Bucharest", "Romania");
        Company firstUserCompany = new Company("Some Company");

        // using the complete constructor
        User firstUser = new User(1, "John", "Doe", "jonh.doe@example.com", 33, firstUserPhoneNumbers, firstUserAddress, "programmer", firstUserCompany, false);

        // using one of the simpler constructors
        User secondUser = new User(2, "Jane", "Doe", new PhoneNumber("072098765"));

        // using the simplest constructor
        User thirdUser = new User(3, "Fred", "Bloggs", "072023232");

        List<User> users = new ArrayList<>();
        users.add(firstUser);
        users.add(secondUser);
        users.add(thirdUser);

        return users;
    }

}
