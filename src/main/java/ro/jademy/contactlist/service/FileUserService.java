package ro.jademy.contactlist.service;

import org.w3c.dom.ls.LSOutput;
import ro.jademy.contactlist.model.Address;
import ro.jademy.contactlist.model.Company;
import ro.jademy.contactlist.model.PhoneNumber;
import ro.jademy.contactlist.model.User;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class FileUserService implements UserService {

    private File contactsFile;
    private List<User> contacts = new ArrayList<>();

    public FileUserService(File contactsFile) {
        this.contactsFile = contactsFile;
    }

    public FileUserService(String contactsFileName) {
        this(new File(contactsFileName));
    }

    @Override
    public List<User> getContacts() {

        // check if contacts is empty
        if (contacts.isEmpty()) {
            contacts.addAll(readFromFile());
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

        // overwrite the whole list of contacts in the file
        writeToFile();
    }

    @Override
    public void editContact(int userId, String firstName, String lastName, String email, Integer age, Map<String, PhoneNumber> phoneNumbers, Address address, String jobTitle, Company company, boolean isFavorite) {
        Optional<User> userOpt = getContactById(userId);

        // edit the contact only if the user was found
        if (userOpt.isPresent()) {
            User user = userOpt.get();

            // TODO.txt: use setters and update the user

            // overwrite the whole list of contacts in the file
            writeToFile();
        }
    }

    @Override
    public void removeContact(int userId) {
        Optional<User> userOpt = getContactById(userId);

        // remove the contact only if found
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            contacts.remove(user);

            // TODO.txt: write changes to file
            writeToFile();
        }
    }

    @Override
    public List<User> search(String query) {

        // TODO.txt: implement method

        return new ArrayList<>();
    }

    private List<User> readFromFile() {
        String read = "";
        List<User> userList = new ArrayList<>();
        if (contactsFile.exists()) {
            try (BufferedReader out = new BufferedReader(new FileReader(contactsFile))) {
                while ((read = out.readLine()) != null) {
                    String[] lineSplit = read.split("[|,_]");

                    String firstName = lineSplit[0].toUpperCase();
                    String lastName = lineSplit[1].toUpperCase();
                    String workCategory = lineSplit[2].toUpperCase();
                    String workPrefix = lineSplit[3];
                    String workNumber = lineSplit[4];
                    String homeCategory = lineSplit[5].toUpperCase();
                    String homePrefix = lineSplit[6];
                    String homeNumber = lineSplit[7];
                    String email = lineSplit[8].toUpperCase();

                    Map<String, PhoneNumber> phoneMap = new HashMap<>();
                    phoneMap.put(workCategory, new PhoneNumber(workPrefix, workNumber));
                    phoneMap.put(homeCategory, new PhoneNumber(homePrefix, homeNumber));

                    int userId = (int) (Math.random() * 900) + 1;
                    User user = new User(userId, firstName, lastName, email, null, phoneMap, null, null, null, false);
                    userList.add(user);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            File file = new File(String.valueOf(contactsFile));
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("File cannot be created");
                e.printStackTrace();
            }
        }

        // TODO.txt: read user properties from file and create the user list
        // TODO.txt: remember to check if the file exists first (create it if it does not)

        return userList;
    }

    private void writeToFile() {

        try {
            BufferedWriter in = new BufferedWriter(new FileWriter(contactsFile,true));

            for (User user : contacts) {
                in.newLine();
                in.append(user.getFirstName().toLowerCase()).append("|");
                in.append(user.getLastName().toLowerCase()).append("|");
                // Iterates the map
                for (Map.Entry<String, PhoneNumber> entry : user.getPhoneNumbers().entrySet()) {
                    if(entry.getKey().toLowerCase().equals("work")) {
                        in.append(entry.getKey()).append("_").append(entry.getValue().getCountryCode()).append("_").append(entry.getValue().getNumber()).append(",");
                    }
                    if(entry.getKey().toLowerCase().equals("home")) {
                        in.append(entry.getKey()).append("_").append(entry.getValue().getCountryCode()).append("_").append(entry.getValue().getNumber()).append("|");
                    }
                }

                in.append(user.getEmail());
            }
            in.flush();
            in.close();

        } catch (IOException e) {
            System.out.println("Can't write to file !");
            e.printStackTrace();
        }
        // TODO.txt: implement method using the contacts and file properties
    }

}
