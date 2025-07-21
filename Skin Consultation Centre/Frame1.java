import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Frame1 extends JFrame implements ActionListener {

    public static WestminsterSkinConsultationManager s1 = new WestminsterSkinConsultationManager();

    JButton button;

    JButton sort;
    JLabel topicLabel;
    JLabel columnLabel;

    // Doctor List
    public Frame1(){
        s1.deserializingDocObject();
        s1.displayDoctorList();

        String[] column = {"Name", "Surname", "Date Of Birth", "Mobile No", "Medical No", "Specialisation"};
        DefaultTableModel doctorTable = new DefaultTableModel(column, 0);
        JTable dTable = new JTable(doctorTable);
        dTable.setBounds(20, 100, 650, 450);

        for (int i = 0; i < s1.getDoctorList().size(); i++) {
            String name = s1.getDoctorList().get(i).getName();
            String surname = s1.getDoctorList().get(i).getSurname();
            String dob = s1.getDoctorList().get(i).getDateOfBirth();
            String mobileNo = s1.getDoctorList().get(i).getMobileNumber();
            String medicalNo = s1.getDoctorList().get(i).getMedicalLicenseNumber();
            String specialisation = s1.getDoctorList().get(i).getSpecialisation();

            Object[] row = {name, surname, dob, mobileNo, medicalNo, specialisation};
            doctorTable.addRow(row);

        }

        //Table columns
        columnLabel = new JLabel();
        columnLabel.setText("|          Name            |         Surname        |     Date Of Birth     |   Mobile Number   |  Medical Number  |    Specialisation    | ");
        columnLabel.setBounds(20, 79, 650, 22);
        columnLabel.setForeground(new Color(234, 216, 216));

        //Page Title
        topicLabel = new JLabel();
        topicLabel.setText("List of Doctors");
        topicLabel.setBounds(250, 20, 550, 30);
        topicLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        topicLabel.setForeground(new Color(63, 59, 58));

        //Back Button
        button = new JButton();
        button.setText("Back");
        button.setBounds(20, 20, 75, 30);
        button.setFocusable(false);
        button.addActionListener(this);

        //Sort Button.
        sort = new JButton();
        sort.setText("Sort Arrangement");
        sort.setBounds(600, 20, 75, 30);
        sort.setFocusable(false);
        sort.addActionListener(this);

        //Setting the elements
        this.setTitle("Westminster Skin Consultation Manager");
        this.setSize(700, 600);
        this.setVisible(true);
        this.setLayout(null);
        this.setResizable(false);
        this.setLocation(650, 50);
        this.add(button);
        this.add(sort);
        this.add(topicLabel);
        this.add(columnLabel);
        this.add(dTable);
        Color color = new Color(168, 182, 208);
        this.getContentPane().setBackground(color);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==button) {
            this.dispose();
            MainFrame mainFrame = new MainFrame();
        } else if (e.getSource()==sort) {
            this.dispose();
            Frame2 frame2 = new Frame2();

        }
    }
}
