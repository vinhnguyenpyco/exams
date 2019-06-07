package exams.myexercise.model;

public class User {

    private String name;
    private String age;
    private String address;
    private String phone;
    private boolean affiliate;
    private boolean employee;
    private int yearOfMember;

    public int getYearOfMember() {
        return yearOfMember;
    }

    public void setYearOfMember(int yearOfMember) {
        this.yearOfMember = yearOfMember;
    }

    public boolean isEmployee() {
        return employee;
    }

    public void setEmployee(boolean employee) {
        this.employee = employee;
    }

    public boolean isAffiliate() {
        return affiliate;
    }

    public void setAffiliate(boolean affiliate) {
        this.affiliate = affiliate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
