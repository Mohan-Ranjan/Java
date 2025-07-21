public class CruiseShipPassenger {
    String firstName;  // Create variables
    String surname;
    double expenses;

    public CruiseShipPassenger(String firstName, String surname, double expenses) {
        this.firstName = firstName;
        this.surname = surname;
        this.expenses = expenses;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setExpenses(double expenses) {
        this.expenses = expenses;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public double getExpenses() {
        return expenses;
    }
}
