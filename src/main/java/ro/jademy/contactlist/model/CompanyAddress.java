package ro.jademy.contactlist.model;

public class CompanyAddress {
    private String companyStreeName;
    private Integer companyStreetNumber;
    private Integer companyApartmentNumber;
    private String companyFloor;
    private String companyZipCode;
    private String companyCity;
    private String companyCountry;

    public CompanyAddress(String companyStreeName, Integer companyStreetNumber, String companyCity, String companyCountry) {
        this.companyStreeName = companyStreeName;
        this.companyStreetNumber = companyStreetNumber;
        this.companyCity = companyCity;
        this.companyCountry = companyCountry;
    }

    public CompanyAddress (){

    }

    public String getCompanyStreeName() {
        return companyStreeName;
    }

    public void setCompanyStreeName(String companyStreeName) {
        this.companyStreeName = companyStreeName;
    }

    public Integer getCompanyStreetNumber() {
        return companyStreetNumber;
    }

    public void setCompanyStreetNumber(Integer companyStreetNumber) {
        this.companyStreetNumber = companyStreetNumber;
    }

    public String getCompanyCity() {
        return companyCity;
    }

    public void setCompanyCity(String companyCity) {
        this.companyCity = companyCity;
    }

    public String getCompanyCountry() {
        return companyCountry;
    }

    public void setCompanyCountry(String companyCountry) {
        this.companyCountry = companyCountry;
    }

    @Override
    public String toString() {
        return "CompanyAddress{" +
                "companyStreeName='" + companyStreeName + '\'' +
                ", companyStreetNumber=" + companyStreetNumber +
                ", companyApartmentNumber=" + companyApartmentNumber +
                ", companyFloor='" + companyFloor + '\'' +
                ", companyZipCode='" + companyZipCode + '\'' +
                ", companyCity='" + companyCity + '\'' +
                ", companyCountry='" + companyCountry + '\'' +
                '}';
    }
}
