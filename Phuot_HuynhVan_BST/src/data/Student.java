package data;

/**
 *
 * @author Huynh Van Phuot
 */
public class Student implements Comparable<Object> {

    public static String CODE_PATTERN = "S\\d{5}";
    public static String CODE_FORMAT = "Sxxxxx";
    public static String PHONE_NUMER_PATTERN = "0\\d{9}";
    public static String PHONE_NUMER_FORMAT = "0xxxxxxxxx";

    private String stuID;
    private String name;
    private int yearOfBirth;
    private double gpa;
    private String phoneNumber;

    public Student() {
    }

    public Student(String stuID, String name, int yearOfBirth, double gpa, String phoneNumber) {
        this.stuID = stuID;
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.gpa = gpa;
        this.phoneNumber = phoneNumber;
    }

    public Student(String stuID) {
        this.stuID = stuID;
        this.name = "";
        this.gpa = 0;
    }

    public String getStuID() {
        return stuID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public int compareTo(Object st) {
        return this.stuID.compareTo(((Student) st).stuID);
    }

    @Override
    public String toString() {
        return String.format("|%-5s|%-25s|%4s|%-4.1f|%11s|",
                stuID, name, yearOfBirth, gpa, phoneNumber);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Student std) 
                && this.stuID.equals(std.getStuID());
    }

}
