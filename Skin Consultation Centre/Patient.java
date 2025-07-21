import java.io.Serializable;

public class Patient extends Person implements Serializable {
    private String uniqueId;

    public Patient(String name, String surname, String dob, String mob, String uniqueId) {
        super(name, surname, dob, mob);
        this.uniqueId = uniqueId;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }
}
