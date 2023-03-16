import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Transaction extends JFrame implements ActionListener{

    JLabel l1;
    JButton btn1, btn2, btn3, btn4, btn5, btn6;

    JFrame f = new JFrame();
    public Transaction(JFrame frame ) {

        if (frame != null){
            frame.setVisible(false);
        }
        f.setTitle("Transactions");
        f.setVisible(true);
        f.setSize(600,600);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        l1 = new JLabel("Transactions");
        l1.setForeground(Color.DARK_GRAY);
        l1.setFont(new Font("Serif", Font.BOLD, 30));
        l1.setBounds(220, 30, 400, 30);

        btn1 = new JButton("Deposit");
        btn1.setBounds(320, 100, 200, 40);
        btn2 = new JButton("Withdraw");
        btn2.setBounds(320, 160, 200, 40);
        btn3 = new JButton("Balance Inquiry");
        btn3.setBounds(320, 220, 200, 40);
        btn4 = new JButton("Money Transfer");
        btn4.setBounds(320, 280, 200, 40);
        btn5 = new JButton("History");
        btn5.setBounds(320, 340, 200, 40);
        btn6 = new JButton("Exit");
        btn6.setBounds(320, 400, 200, 40);

        f.add(l1);
        f.add(btn1);
        f.add(btn2);
        f.add(btn3);
        f.add(btn4);
        f.add(btn5);
        f.add(btn6);

        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
        btn5.addActionListener(this);
        btn6.addActionListener(this);

    }

    public static void main(String[] args) {
        new Transaction(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1)
        {
            new DepositMoney(null);
        }else if (e.getSource() == btn2)
        {
            new WithdrawMoney(null);
        }else if (e.getSource() == btn3)
        {
            new CheckBalance(null);
        }else if (e.getSource() == btn4)
        {
            System.out.println("Button4");
        }else if (e.getSource() == btn5)
        {
            System.out.println("Button5");
        }else if (e.getSource() == btn6)
        {
            JOptionPane.showMessageDialog(btn6,
                    "Thank you for banking with us!!!");
            System.exit(0);
        }
    }
}
