import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

public class Frame5 extends JFrame implements ActionListener {

    WestminsterSkinConsultationManager s1 = new WestminsterSkinConsultationManager();
    JLabel consDone;
    JLabel date;
    JLabel time;
    JLabel doctor;
    JLabel name;
    JLabel surname;
    JLabel DateOfBirth;
    JLabel MobileNo;
    JLabel ID;
    JLabel notes;
    JLabel cost;


    JButton button;


    public Frame5() {
        s1.deserializingConObject();
        SimpleDateFormat dateFor = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFor = new SimpleDateFormat("hh:mm aa");
        int i = (s1.consultationList.size()-1);

        String pName = s1.getConsultationList().get(i).getPatient().getName();
        String pSurname = s1.getConsultationList().get(i).getPatient().getSurname();
        String pDob = s1.getConsultationList().get(i).getPatient().getDateOfBirth();
        String pMobileNo = s1.getConsultationList().get(i).getPatient().getMobileNumber();
        String pId = s1.getConsultationList().get(i).getPatient().getUniqueId();
        String pNotes = s1.getConsultationList().get(i).getNotes();
        String pDoctor = s1.getConsultationList().get(i).getDoctor().getName();
        String pDate = dateFor.format(s1.getConsultationList().get(i).getConsultationDate());
        String pTime = timeFor.format(s1.getConsultationList().get(i).getConsultationTime());
        String pCost = Integer.toString(s1.getConsultationList().get(i).getConsultationCost());


        setLayout(new GridLayout(11, 1, 5, 3));
        add(consDone = new JLabel());
        consDone.setText("  Consultation Added Successfully !");
        add(doctor = new JLabel());
        doctor.setText("      Doctor: " + pDoctor);

        add(date = new JLabel());
        date.setText("      Consultation Date: " + pDate);

        add(time = new JLabel());
        time.setText("      Consultation Time: " + pTime);

        add(name = new JLabel());
        name.setText("      Patient Name: " + pName + " "+ pSurname);

        add(DateOfBirth = new JLabel());
        DateOfBirth.setText("      Patient Date Of Birth: " + pDob);

        add(MobileNo = new JLabel());
        MobileNo.setText("      Patient Mobile Number : " + pMobileNo);

        add(ID = new JLabel());
        ID.setText("      Patient ID: " + pId);

        add(notes = new JLabel());
        notes.setText("      Patient Notes: " + pNotes);

        add(cost = new JLabel());
        cost.setText("      Cost: $" + pCost);

        add(button = new JButton());
        button.setText("Back");
        button.setFocusable(false);
        button.addActionListener(this);

        this.setTitle("Westminster Skin Consultation Manager");
        this.setSize(300, 400);
        this.setVisible(true);
        this.setLayout(null);
        this.setResizable(false);
        this.setLocation(650, 50);
        this.add(consDone);
        this.add(doctor);
        this.add(date);
        this.add(time);
        this.add(name);
        this.add(surname);
        this.add(DateOfBirth);
        this.add(MobileNo);
        this.add(ID);
        this.add(notes);
        this.add(cost);
        this.add(button);

        Color color=new Color(216, 228, 231);
        this.getContentPane().setBackground(color);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            this.dispose();
            MainFrame mainFrame = new MainFrame();

        }
    }
}
