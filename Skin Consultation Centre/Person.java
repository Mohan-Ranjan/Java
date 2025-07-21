import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private String surname;
    private String dateOfBirth;
    private String mobileNumber;

    public Person(String name, String surname, String dob, String mob){
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dob;
        this.mobileNumber = mob;
    }


    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getSurname() {
        return surname;    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setBirth_date(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}