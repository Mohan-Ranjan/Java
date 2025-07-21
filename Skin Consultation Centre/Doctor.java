import java.io.Serializable;
import java.util.Comparator;

public class Doctor extends Person implements Serializable {
    private String medicalLicenseNumber;
    private String specialisation;

    public Doctor(String name, String surname, String dob, String mob, String medicalLicenseNumber, String specialisation) {
        super(name, surname, dob, mob);
        this.medicalLicenseNumber = medicalLicenseNumber;
        this.specialisation = specialisation;

    }
    public String getMedicalLicenseNumber() {
        return medicalLicenseNumber;
    }

    public void setMedicalLicenseNumber(String medicalLicenseNumber) {
        this.medicalLicenseNumber = medicalLicenseNumber;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }


    public static Comparator<Doctor> DocSurnameComparator = (o1, o2) -> {
        String DoctorName1 = o1.getSurname().toUpperCase();
        String DoctorName2 = o2.getSurname().toUpperCase();
        return DoctorName1.compareTo(DoctorName2);
    };
    public static Comparator<Doctor> DocNameComparator = new Comparator<Doctor>() {
        @Override
        public int compare(Doctor o1, Doctor o2) {
            String DoctorName1 = o1.getName().toUpperCase();
            String DoctorName2 = o2.getName().toUpperCase();

            return DoctorName1.compareTo(DoctorName2);
        }
    };

}
