import java.io.Serializable;
import java.util.Date;

public class Consultation implements Serializable {

    private Date consultationDate;
    private Date consultationTime;
    private int consultationCost;
    private String notes;
    private Doctor doctor;
    private Patient patient;

    public Consultation(Date consultationDate,Date consultationTime, int consultationCost, String notes,Doctor doctor,Patient patient){
        this.consultationDate = consultationDate;
        this.doctor = doctor;
        this.consultationCost = consultationCost;
        this.notes = notes;
        this.patient = patient;
        this.consultationTime = consultationTime;
    }

    public Date getConsultationDate() {
        return consultationDate;
    }

    public void setDate(Date date) {
        this.consultationDate = date;
    }

    public Date getConsultationTime() {
        return consultationTime;
    }

    public void setConsultationTime(Date consultationTime) {
        this.consultationTime = consultationTime;
    }

    public int getConsultationCost() {
        return consultationCost;
    }

    public void setConsultationCost(int consultationCost) {
        this.consultationCost = consultationCost;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }



    @Override
    public String toString() {
        return "Appointment{" +
                "date=" + consultationDate + ", time=" + consultationTime +", cost=" + consultationCost + " ,notes=" + notes+
                ", docInfo=" + doctor +
                '}';
    }

}
