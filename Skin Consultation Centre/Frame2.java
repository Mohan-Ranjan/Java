import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame2 extends JFrame implements ActionListener {

    public static WestminsterSkinConsultationManager s1 = new WestminsterSkinConsultationManager();

    JButton button;
    JLabel topicLabel;
    JLabel columnLabel;

    //Sorted Doctor List
    public Frame2(){

        s1.deserializingDocObject();
        s1.displayArranged();

        String [] column = {"Name","Surname","Date Of Birth","Mobile No","Medical No","Specialisation"};
        DefaultTableModel doctorTable = new DefaultTableModel(column,0);
        JTable dTable = new JTable(doctorTable);
        dTable.setBounds(20,100,650,450);

        for (int i=0; i<s1.getDoctorList().size(); i++) {
            String name = s1.getDoctorList().get(i).getName();
            String surname = s1.getDoctorList().get(i).getSurname();
            String dob = s1.getDoctorList().get(i).getDateOfBirth();
            String mobileNo = s1.getDoctorList().get(i).getMobileNumber();
            String medicalNo = s1.getDoctorList().get(i).getMedicalLicenseNumber();
            String specialisation = s1.getDoctorList().get(i).getSpecialisation();

            Object [] row = {name,surname,dob,mobileNo,medicalNo,specialisation};
            doctorTable.addRow(row);
        }

        //Table columns
        columnLabel = new JLabel();
        columnLabel.setText("|          Name            |         Surname        |     Date Of Birth     |   Mobile Number   |  Medical Number  |    Specialisation    | ");
        columnLabel.setBounds(20,79,650,20);
        columnLabel.setForeground(new Color(213, 222, 232));

        //Page Title. List of Doctors sorted by First Name.
        topicLabel = new JLabel();
        topicLabel.setText("List of Doctors (Sorted) ");
        topicLabel.setBounds(200,20,550,30);
        topicLabel.setFont(new Font(Font.DIALOG_INPUT,Font.BOLD,20));
        topicLabel.setForeground(new Color(204, 193, 182));

        //Back Button
        button = new JButton();
        button.setText("Back");
        button.setBounds(20,20,75,30);
        button.setFocusable(false);
        button.addActionListener(this);

        //Setting the elements
        this.setTitle("Westminster Skin Consultation Manager");
        this.setSize(700,600);
        this.setVisible(true);
        this.setLayout(null);
        this.setResizable(false);
        this.setLocation(650,50);
        this.add(button);
        this.add(topicLabel);
        this.add(columnLabel);
        this.add(dTable);
        Color color=new Color(187, 220, 215);
        this.getContentPane().setBackground(color);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==button) {
            this.dispose();
            MainFrame mainFrame = new MainFrame();
        }
    }
}
