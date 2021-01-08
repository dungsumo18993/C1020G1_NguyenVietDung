package Models;

public class Customer implements Comparable<Customer> {
    private String fullName;
    private String birthDay;
    private String gender;
    private String idCard;
    private String phoneNumber;
    private String email;
    private String customerType;
    private String address;
    private Services properties;

    public Customer() {
    }

    public Customer(String fullName, String birthDay, String gender, String idCard, String phoneNumber, String email, String customerType, String address) {
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.gender = gender;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.customerType = customerType;
        this.address = address;
    }

    public Customer(String fullName, String birthDay, String gender, String idCard, String phoneNumber, String email, String customerType, String address, Services properties) {
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.gender = gender;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.customerType = customerType;
        this.address = address;
        this.properties = properties;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Services getProperties() {
        return properties;
    }

    public void setProperties(Services properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return  fullName +
                "," + birthDay +
                "," + gender +
                "," + idCard +
                "," + phoneNumber +
                "," + email +
                "," + customerType +
                "," + address;
    }

    public void showInfo(){
        System.out.println("Full Name: "+fullName +
                ", BirthDay: " + birthDay +
                ", Gender: " + gender +
                ", IDCard: " + idCard +
                ", PhoneNumber: " + phoneNumber +
                ", Email: " + email +
                ", CustomerType: " + customerType +
                ", Address: " + address);
    }

    @Override
    public int compareTo(Customer o) {
        if (this.getFullName().compareTo(o.getFullName())==0){
            return this.getBirthDay().compareTo(o.getBirthDay());
        }else {
            return this.getFullName().compareTo(o.getFullName());
        }
    }

}
