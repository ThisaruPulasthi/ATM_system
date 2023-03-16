import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FirstWindow extends JFrame implements ActionListener {
    JLabel l1;
    JButton btn1, btn2;

    JFrame f =new JFrame();
    public FirstWindow() {
        f.setTitle("ATM");
        f.setVisible(true);
        f.setSize(600,300);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        l1 = new JLabel("ATM");
        l1.setForeground(Color.DARK_GRAY);
        l1.setFont(new Font("Serif", Font.BOLD, 30));
        l1.setBounds(250, 30, 400, 30);

        btn1 = new JButton("Register");
        btn1.setBounds(190, 100, 200, 40);
        btn2 = new JButton("Login");
        btn2.setBounds(190, 150, 200, 40);

        f.add(l1);
        f.add(btn1);
        f.add(btn2);

        btn1.addActionListener(this);
        btn2.addActionListener(this);
    }

    public static void main(String[] args) {
        new FirstWindow();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1)
        {
            new SignUp();
        }else if (e.getSource() == btn2)
        {
            new Login();
        }
    }
}
