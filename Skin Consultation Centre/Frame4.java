import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
public class Frame4 extends JFrame implements ActionListener {

    WestminsterSkinConsultationManager s1 = new WestminsterSkinConsultationManager();
    JButton button;
    JLabel topicLabel;
    JLabel columnLabel;

    public Frame4() {

        s1.deserializingConObject();
        SimpleDateFormat dateFor = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFor = new SimpleDateFormat("hh:mm aa");

        String[] column = {"Name", "Surname", "Date Of Birth", "Mobile Number", "ID Number", "Notes", "Doctor", "Consultation Date", "Consultation Time", "Cost"};
        DefaultTableModel consTable = new DefaultTableModel(column, 0);
        JTable dTable = new JTable(consTable);
        dTable.setBounds(20, 100, 1200, 600);

        for (int i = 0; i < s1.getConsultationList().size(); i++) {
            String name = s1.getConsultationList().get(i).getPatient().getName();
            String surname = s1.getConsultationList().get(i).getPatient().getSurname();
            String dob = s1.getConsultationList().get(i).getPatient().getDateOfBirth();
            String mobileNo = s1.getConsultationList().get(i).getPatient().getMobileNumber();
            String id = s1.getConsultationList().get(i).getPatient().getUniqueId();
            String notes = s1.getConsultationList().get(i).getNotes();
            String doctor = s1.getConsultationList().get(i).getDoctor().getName();
            String date = dateFor.format(s1.getConsultationList().get(i).getConsultationDate());
            String time = timeFor.format(s1.getConsultationList().get(i).getConsultationTime());
            String cost = Integer.toString(s1.getConsultationList().get(i).getConsultationCost());

            Object[] row = {name, surname, dob, mobileNo, id, notes, doctor, date, time, cost};
            consTable.addRow(row);
        }

        //Table columns.
        columnLabel = new JLabel();
        columnLabel.setText("| Patient Name           | Patient Surname       | Date Of Birth            | Mobile Number        | Unique ID                  | Notes                         | Name     |  Date    |  Time   |Cost");
        columnLabel.setBounds(20, 80, 1200, 20);
        columnLabel.setForeground(new Color(192, 210, 229));

        //Topic of the page.
        topicLabel = new JLabel();
        topicLabel.setText("Consultation Details");
        topicLabel.setBounds(450, 20, 550, 30);
        topicLabel.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 20));
        topicLabel.setForeground(new Color(173, 166, 160));

        //Back Button.
        button = new JButton();
        button.setText("Back");
        button.setBounds(20, 20, 75, 30);
        button.setFocusable(false);
        button.addActionListener(this);

        //Setting the elements.
        this.setTitle("Westminster Skin Consultation Manager");
        this.setSize(1260, 750);
        this.setVisible(true);
        this.setLayout(null);
        this.setResizable(false);
        this.setLocation(250, 50);
        this.add(button);
        this.add(topicLabel);
        this.add(columnLabel);
        this.add(dTable);

        Color color=new Color(126, 127, 136);
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
