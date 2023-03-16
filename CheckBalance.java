import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckBalance extends JFrame implements ActionListener {

    JLabel l1, l2, l3;
    JTextField tf1;
    JButton btn1, btn2, btn3;


    JFrame f = new JFrame();
    CheckBalance(JFrame frame) {

        if (frame != null){
            frame.setVisible(false);
        }
        f.setTitle("Balance Inquiry");
        f.setVisible(true);
        f.setSize(600, 300);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        l1 = new JLabel("Balance Inquiry");
        l1.setForeground(Color.blue);
        l1.setFont(new Font("Serif", Font.BOLD, 20));
        l2 = new JLabel("Username" );
        l2.setFont(new Font("Serif", Font.BOLD, 18));
//        l3 = new JLabel("Your current balance is " + SignUp.currentAccounts.containsKey(SignUp.mail));
//        l3.setFont(new Font("Serif", Font.BOLD, 18));
//        l3.setForeground(Color.RED);

        tf1 = new JTextField();
        btn1 = new JButton("Enter");
        btn2 = new JButton("Logout");
        btn3 = new JButton("Back");

        l1.setBounds(220, 30, 400, 30);
        l2.setBounds(100, 80, 200, 30);
//        l3.setBounds(130, 130, 300, 30);
        tf1.setBounds(200, 80, 200, 30);
        btn1.setBounds(100, 180, 100, 35);
        btn2.setBounds(220, 180, 100, 35);
        btn3.setBounds(340,180,100,35);

        f.add(l1);
        f.add(l2);
//        add(l3);
        f.add(tf1);
        f.add(btn1);
        f.add(btn2);
        f.add(btn3);

        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btn2)
        {
            JOptionPane.showMessageDialog(btn1, "Successfully Logout!!!");
            System.exit(0);
        }else if (e.getSource() == btn1){
            SignUp.currentAccounts.forEach((k, v) -> {
                String str = tf1.getText();
                if (str.equals(k)){
                    double blnc = SignUp.currentAccounts.get(SignUp.mail);
                    System.out.println("Your account balance is "+ blnc);
                    System.out.println(SignUp.currentAccounts);

                    l3 = new JLabel("Your current balance is " + blnc);
                    l3.setFont(new Font("Serif", Font.BOLD, 18));
                    l3.setForeground(Color.RED);
                    l3.setBounds(130, 130, 300, 30);
                    add(l3);

                }else{
                    JOptionPane.showMessageDialog(btn1, "Invalid username!");
                }
            });

        }else {

            new Transaction(null);
        }
    }

    public static void main(String args[]) {

        new CheckBalance(null);

    }
}
