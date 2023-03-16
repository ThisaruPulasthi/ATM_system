import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DepositMoney extends JFrame implements ActionListener {

    JLabel l1, l2, l3;

    JTextField tf1, tf2;

    JButton btn1, btn2, btn3;

    JFrame f = new JFrame();
    DepositMoney(JFrame frame) {

        if (frame != null){
            frame.setVisible(false);
        }
        f.setTitle("Money Deposit");
        f.setVisible(true);
        f.setSize(600, 300);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        l1 = new JLabel("Money Deposit");
        l1.setForeground(Color.blue);
        l1.setFont(new Font("Serif", Font.BOLD, 20));
        l2 = new JLabel("Username" );
        l2.setFont(new Font("Serif", Font.BOLD, 18));
        l3 = new JLabel("Amount" );
        l3.setFont(new Font("Serif", Font.BOLD, 18));

        tf1 = new JTextField();
        tf2 = new JTextField();
        btn1 = new JButton("Deposit");
        btn2 = new JButton("Clear");
        btn3 = new JButton("Back");

        l1.setBounds(220, 30, 400, 30);
        l2.setBounds(100, 80, 200, 30);
        l3.setBounds(100, 120, 200, 30);
        tf1.setBounds(200, 80, 200, 30);
        tf2.setBounds(200, 120, 200, 30);
        btn1.setBounds(100, 165, 100, 35);
        btn2.setBounds(220, 165, 100, 35);
        btn3.setBounds(340, 165, 100, 35);

        f.add(l1);
        f.add(l2);
        f.add(l3);
        f.add(tf1);
        f.add(tf2);
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
            tf1.setText("");
            tf2.setText("");

        }else if (e.getSource() == btn1)
        {
            deposit();
        }else{
            new Transaction(null);
        }
    }

    public void deposit() {

        SignUp.currentAccounts.forEach((k, v) -> {
            String str = tf1.getText();
            String bal = tf2.getText();
            try{
                if (str.equals(k)){
                    double bal2 = Double.parseDouble(bal); // convert the string into double
                    Double currentBal = SignUp.currentAccounts.get(SignUp.mail)  + bal2;
                    SignUp.currentAccounts.put(str,currentBal);
                    System.out.println(SignUp.currentAccounts);
                    JOptionPane.showMessageDialog(btn1, "Successfully Deposited!");

                }else{
                    JOptionPane.showMessageDialog(btn1, "Invalid username!");
                }
            }catch (NumberFormatException e){
                JOptionPane.showMessageDialog(btn1, "Invalid Entry");
            }
        });

    }
    public static void main(String args[]) {

        new DepositMoney(null);

    }
}