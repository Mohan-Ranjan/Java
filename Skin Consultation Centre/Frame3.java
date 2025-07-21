import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class Frame3 extends JFrame implements ActionListener {
    ArrayList<Patient> patientList = new ArrayList<>();
    public static WestminsterSkinConsultationManager s1 = new WestminsterSkinConsultationManager();

    JButton button;
    JLabel date;
    JLabel time;
    JLabel doctor;
    JLabel titleLabel;
    JComboBox selectDoctor;
    JLabel name;
    JLabel surname;
    JLabel DateOfBirth;
    JLabel MobileNo;
    JLabel ID;
    JLabel notes;
    JTextField consultationDate;
    JTextField consultationTime;
    JTextField patientName;
    JTextField patientSurname;
    JTextField patientDateOfBirth;
    JTextField patientMobileNo;
    JTextField patientID;
    JTextField patientNotes;
    JButton submit;

    public Frame3() {

        s1.deserializingDocObject();
        s1.deserializingConObject();
        s1.displayDoctorList();

        //Page Title. Booking Consultation
        titleLabel = new JLabel();
        titleLabel.setText("Booking Consultation");
        titleLabel.setBounds(150,10,550,30);
        titleLabel.setFont(new Font(Font.DIALOG_INPUT,Font.BOLD,20));
        titleLabel.setForeground(new Color(155, 179, 185));

        doctor = new JLabel();
        doctor.setText("Select a Doctor for appointment: ");
        doctor.setBounds(30,50,200,40);

        int x = s1.doctorList.size();
        String[] docStrings = new String[x];
        for (int i = 0; i < x; i++) {
            docStrings[i] = s1.doctorList.get(i).getName();
        }

        selectDoctor = new JComboBox(docStrings);
        selectDoctor.setSelectedIndex(x - 1);
        selectDoctor.addActionListener(this);
        selectDoctor.setBounds(300,50,200,40);

        date = new JLabel();
        date.setText("Consultation Date (YYYY-MM-DD):  ");
        date.setBounds(30,100,300,40);

        consultationDate = new JTextField();
        consultationDate.setBounds(300,100,200,40);

        time = new JLabel();
        time.setText("Consultation Time(HH:MM AM/PM): ");
        time.setBounds(30,150,300,40);

        consultationTime = new JTextField();
        consultationTime.setBounds(300,150,200,40);

        name = new JLabel();
        name.setText("Patient Name: ");
        name.setBounds(30,200,200,40);

        patientName = new JTextField();
        patientName.setBounds(300,200,200,40);

        surname = new JLabel();
        surname.setText("Patient Surname: ");
        surname.setBounds(30,250,200,40);

        patientSurname = new JTextField();
        patientSurname.setBounds(300,250,200,40);

        DateOfBirth = new JLabel();
        DateOfBirth.setText("Enter your Date Of Birth (YYYY-MM-DD): ");
        DateOfBirth.setBounds(30,300,250,40);

        patientDateOfBirth = new JTextField();
        patientDateOfBirth.setBounds(300,300,200,40);

        MobileNo = new JLabel();
        MobileNo.setText("Enter the Patient Mobile Number: ");
        MobileNo.setBounds(30,350,200,40);

        patientMobileNo = new JTextField();
        patientMobileNo.setBounds(300,350,200,40);

        ID = new JLabel();
        ID.setText("Enter the Patient ID Nmber: ");
        ID.setBounds(30,400,200,40);

        patientID = new JTextField();
        patientID.setBounds(300,400,200,40);

        notes = new JLabel();
        notes.setText("Enter the Patient Notes: ");
        notes.setBounds(30,450,200,40);

        patientNotes = new JTextField();
        patientNotes.setBounds(300,450,200,100);

        submit = new JButton();
        submit.setText("Submit");
        submit.setFocusable(false);
        submit.addActionListener(this);
        submit.setBounds(100,600,100,30);

        button = new JButton();
        button.setText("Back");
        button.setFocusable(false);
        button.addActionListener(this);
        button.setBounds(300,600,100,30);

        this.setTitle("Westminster Skin Consultation Manager");
        this.setSize(550, 700);
        this.setVisible(true);
        this.setLayout(null);
        this.setResizable(false);
        this.setLocation(650, 50);
        this.add(button);
        this.add(titleLabel);
        this.add(doctor);
        this.add(selectDoctor);
        this.add(date);
        this.add(consultationDate);
        this.add(time);
        this.add(consultationTime);
        this.add(name);
        this.add(patientName);
        this.add(surname);
        this.add(patientSurname);
        this.add(DateOfBirth);
        this.add(patientDateOfBirth);
        this.add(MobileNo);
        this.add(patientMobileNo);
        this.add(ID);
        this.add(patientID);
        this.add(notes);
        this.add(patientNotes);
        this.add(submit);
        Color color=new Color(195, 204, 232);
        this.getContentPane().setBackground(color);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        SimpleDateFormat dateFor = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFor = new SimpleDateFormat("HH:mm aa");
        int cost = 15;
        Doctor dan = s1.doctorList.get(selectDoctor.getSelectedIndex());
        if (e.getSource()==button) {
            this.dispose();
            MainFrame mainFrame = new MainFrame();
        } else if (e.getSource()==submit) {
            if (consultationDate.getText().equals("")||patientName.getText().equals("")
                    ||patientSurname.getText().equals("")
                    ||patientDateOfBirth.getText().equals("")
                    ||patientMobileNo.getText().equals("")
                    ||patientID.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Please Enter All Details");
            }else {
                int answer = JOptionPane.showConfirmDialog(null, "Do you want to proceed?", "Confirmation", JOptionPane.YES_NO_OPTION);


                patientList.add(new Patient(patientName.getText(),patientSurname.getText(),patientDateOfBirth.getText(),patientMobileNo.getText(),patientID.getText()));
                Patient p = new Patient(patientName.getText(),patientSurname.getText(),patientDateOfBirth.getText(),patientMobileNo.getText(),patientID.getText());

                String cd = consultationDate.getText();
                Date thisConsDate = new Date();
                String ct = consultationTime.getText();
                Date thisConsTime = new Date();

                try {
                    thisConsDate = new SimpleDateFormat("yyyy-MM-dd").parse(cd);
                    thisConsTime = new SimpleDateFormat("hh:mm aa").parse(ct);


                    for (int x = 0; x < s1.consultationList.size(); x++) {
                        if (s1.consultationList.get(x).getPatient().getUniqueId().equalsIgnoreCase(patientID.getText())) {
                            cost = 25;
                            break;
                        }
                    }

                    for (int x = 0; x < s1.consultationList.size(); x++) {
                        if (s1.consultationList.get(x).getDoctor().getMedicalLicenseNumber().equalsIgnoreCase(dan.getMedicalLicenseNumber())) {
                            if (dateFor.format(s1.consultationList.get(x).getConsultationDate()).equalsIgnoreCase(consultationDate.getText())
                                    && timeFor.format(s1.consultationList.get(x).getConsultationTime()).equalsIgnoreCase(consultationTime.getText())) {
                                int ranPosition = x;
                                while (ranPosition == x) {
                                    ranPosition = (int) (Math.random() * s1.doctorList.size());
                                    dan = s1.doctorList.get(ranPosition);
                                }

                            }

                        }
                    }

                    s1.consultationList.add(new Consultation(thisConsDate, thisConsTime, cost, patientNotes.getText(), dan, p));
                    s1.serializingConObject();
                    this.dispose();
                    Frame5 frame5 = new Frame5();

                }catch(ParseException parseException){
                    JOptionPane.showMessageDialog(this, "Something Went Wrong Try Again");
                }
            }

        }
    }
}
