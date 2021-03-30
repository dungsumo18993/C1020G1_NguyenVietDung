package ListCustomer;

public class Customer {
    private String name;
    private String dayOfBirth;
    private int gender;
    private String address;
    private int numberOfOder;
    private String image;

    public Customer(String name, String dayOfBirth, int gender, String address, int numberOfOder, String image) {
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.gender = gender;
        this.address = address;
        this.numberOfOder = numberOfOder;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumberOfOder() {
        return numberOfOder;
    }

    public void setNumberOfOder(int numberOfOder) {
        this.numberOfOder = numberOfOder;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
