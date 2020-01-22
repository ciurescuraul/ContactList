package ro.jademy.contactlist.model;

public class Company {

    private String name;
    private CompanyAddress companyAddress;

    public Company(String name, CompanyAddress companyAddress) {
        this.name = name;
        this.companyAddress = companyAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CompanyAddress getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(CompanyAddress companyAddress) {
        this.companyAddress = companyAddress;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", companyAddress=" + companyAddress +
                '}';
    }
}
