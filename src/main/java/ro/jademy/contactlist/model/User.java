package ro.jademy.contactlist.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class User {

    private static final String DEFAULT_PHONE_NUMBER_GROUP = "home";

    private Integer userId;
    private String firstName;
    private String lastName;
    private String email;
    private Integer age;

    private Map<String, PhoneNumber> phoneNumbers;
    private Address address;

    private String jobTitle;
    private Company company;

    private boolean isFavorite;

    public User(Integer userId, String firstName, String lastName, String email, Integer age, Map<String, PhoneNumber> phoneNumbers, Address address, String jobTitle, Company company, boolean isFavorite) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.phoneNumbers = phoneNumbers;
        this.address = address;
        this.jobTitle = jobTitle;
        this.company = company;
        this.isFavorite = isFavorite;
    }

    public User(Integer userId, String firstName, String lastName, String email, Integer age, Map<String, PhoneNumber> phoneNumbers, Address address, String jobTitle, Company company) {
        this(userId, firstName, lastName, email, age, phoneNumbers, address, jobTitle, company, false);
    }

    public User(Integer userId, String firstName, String lastName, PhoneNumber phoneNumber, boolean isFavorite) {

        this(userId, firstName, lastName, null, null, new HashMap<>(), null, null, null, isFavorite);

        this.phoneNumbers.put(DEFAULT_PHONE_NUMBER_GROUP, phoneNumber); // add the phone number to a default phone number group
    }

    public User(Integer userId, String firstName, String lastName, PhoneNumber phoneNumber) { // simple constructor, but requiring a PhoneNumber object

        this(userId, firstName, lastName, phoneNumber, false);
    }

    public User(Integer userId, String firstName, String lastName, String phoneNumber) { // simplest constructor, requiring only the minimal necessary information in literal form

        this(userId, firstName, lastName, new PhoneNumber(phoneNumber), false);
    }


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void getPhoneNumbers() {

    phoneNumbers.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " " + entry.getValue());
        });
    }

    public void setPhoneNumbers(Map<String, PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return isFavorite == user.isFavorite &&
                Objects.equals(userId, user.userId) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(email, user.email) &&
                Objects.equals(age, user.age) &&
                Objects.equals(phoneNumbers, user.phoneNumbers) &&
                Objects.equals(address, user.address) &&
                Objects.equals(jobTitle, user.jobTitle) &&
                Objects.equals(company, user.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, firstName, lastName, email, age, phoneNumbers, address, jobTitle, company, isFavorite);
    }

    @Override
    public String toString() {
        return  "\n userId : " + userId +
                "\n firstName : " + firstName +
                "\n lastName : " + lastName +
                "\n email : " + email +
                "\n age : " + age +
                "\n phoneNumbers : " + phoneNumbers +
                "\n address : " + address +
                "\n jobTitle : " + jobTitle +
                "\n company : " + company +
                "\n isFavorite : " + isFavorite;
    }

    public String displayUsers() {
        return getUserId() + ". " + getFirstName() + " " + getLastName();
    }

    public void viewUserDetails() {
        System.out.println("***********  User " + userId + " Details " + "***********");
        System.out.println("User id: " + getUserId());
        System.out.println("First name: " + getFirstName());
        System.out.println("Last name: " + getLastName());
        System.out.println("Email: " + getEmail());
        System.out.println("Age: " + getAge());
        System.out.println("Phone numbers: ");
        getPhoneNumbers();
        System.out.println("Address: " + getAddress());
        System.out.println("Job title: " + getJobTitle());
        System.out.println("Company: " + getCompany());
        System.out.println("Is favourite: " + isFavorite());
        System.out.println("**********************************************************");
    }

    public int compareTo(User o) {
        if (lastName.compareTo(o.lastName) == 0) {
            return firstName.compareTo(o.firstName);
        }
        return lastName.compareTo(o.lastName);
    }
}
