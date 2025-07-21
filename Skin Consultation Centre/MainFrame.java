import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class MainFrame extends JFrame implements ActionListener {
    WestminsterSkinConsultationManager s1 = new WestminsterSkinConsultationManager();

    private final JButton docListBtn;
    //private final JButton sortBtn;

    private final JButton bookBtn;

    private final JButton conDetailBtn;


    public MainFrame() {

        //Inputting an Image
        ImageIcon image = new ImageIcon("home.png");
        JLabel label1 = new JLabel();
        label1.setBounds(250,20,300,284);
        label1.setIcon(image);
        label1.setHorizontalTextPosition(JLabel.CENTER);
        label1.setVerticalTextPosition(JLabel.TOP);

        //Center Name
        JLabel label2 = new JLabel();
        label2.setText(" Westminster");
        label2.setBounds(320,280,600,100);
        label2.setFont(new Font("SansSerif", Font.BOLD, 32));

        //Welcoming
        JLabel label3 = new JLabel();
        label3.setText("Skin Consultation Center");
        label3.setBounds(245,320,600,100);
        label3.setFont(new Font("SansSerif", Font.PLAIN, 28));

        //Welcoming
        JLabel label4 = new JLabel();
        label4.setText("Website : www.westminsterskinconsultation.org");
        label4.setBounds(410,535,600,25);
        label4.setFont(new Font("SansSerif", Font.PLAIN, 16));

        //Button to Display Doctor List
        docListBtn = new JButton();
        docListBtn.setBounds(100,425,175,60);
        docListBtn.setText("Doctors List");
        docListBtn.setFocusable(false);
        docListBtn.addActionListener(this);

        //Button to view Booking interface
        bookBtn = new JButton();
        bookBtn.setBounds(325,425,175,60);
        bookBtn.setText("Bookings of Consultation");
        bookBtn.setFocusable(false);
        bookBtn.addActionListener(this);

        //Button to view Consultation List
        conDetailBtn = new JButton();                                                    //Adding the button for Generate a random race.
        conDetailBtn.setBounds(550,425,175,60);
        conDetailBtn.setText("Consultation Details");
        conDetailBtn.setFocusable(false);
        conDetailBtn.addActionListener(this);


        this.setTitle("Westminster");                                    //Adding the elements to the Main Frame.
        this.setSize(800,600);
        Color color=new Color(102, 118, 122);
        this.getContentPane().setBackground(color);
        this.setVisible(true);
        this.setResizable(false);
        this.setLayout(null);
        this.add(label1);
        this.add(label2);
        this.add(label3);
        this.add(label4);
        this.add(docListBtn);
        this.add(bookBtn);
        this.add(conDetailBtn);
        this.setLocation(650,50);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== docListBtn) {
            this.dispose();
            Frame1 frame1 = new Frame1();
        }

        else if (e.getSource()== bookBtn) {
            this.dispose();
            Frame3 frame3 = new Frame3();
        }
        else if (e.getSource()== conDetailBtn) {
            this.dispose();
            Frame4 frame4 = new Frame4();
        }

    }
}