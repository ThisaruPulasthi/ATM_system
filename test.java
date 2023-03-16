import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

public class test extends JFrame implements ActionListener {

    JLabel l1, l2 ;   //label for email and password

    JTextField tf1; // email field

    JButton btn1, btn2; // login button



  //file path
    int ln;

    File f = new File("Files");
    // create folder in which record is save

    //check file is exist or not
//    void readFile() {
//        try {
//            FileReader fr = new FileReader(f + "\\Account_Numbers.txt");
////            System.out.println("file exists!");
//        } catch (FileNotFoundException ex) {
//            try {
//                FileWriter fw = new FileWriter(f + "\\Account_Numbers.txt");
////                System.out.println("File created");
//            } catch (IOException ex1) {
//            }
//        }
//
//    }

    void etest(String usr) {

        try {
            RandomAccessFile raf = new RandomAccessFile( "Files/Account_Numbers.txt", "r");

            for (int i = 0; i < ln; i += 1) {
                System.out.println("hii 3" );
                System.out.println("count " + i);

                String forUser =raf.readLine();
                System.out.println(forUser);

                if (usr.equals(forUser)) {
                    JOptionPane.showMessageDialog(null, "Verify Successfully!!");
                    new SignUp();
                    break;
                } else if (i == (ln-1 )) {
                    JOptionPane.showMessageDialog(null, "incorrect Account Number");
                    break;
                }
//                for (int k = 0; k <=1; k++) {
//                    raf.readLine();
//                }
            }
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }

    }
    //count the number of lines from file
    void countLines() {
        try {
            ln = 0;
            RandomAccessFile raf = new RandomAccessFile(f + "\\Account_Numbers.txt", "rw");
            for (int i = 0; raf.readLine() != null; i++) {
                ln++;
            }
            System.out.println("number of lines:" + ln);
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }

    }


       test() {

        setTitle("Account Verify");

        setVisible(true);

        setSize(600, 300);

        setLayout(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        l1 = new JLabel("Account Verify");

        l1.setForeground(Color.blue);

        l1.setFont(new Font("Serif", Font.BOLD, 20));

        l2 = new JLabel("Enter Account number:");



        tf1 = new JTextField();



        btn1 = new JButton("Submit");

        btn2 = new JButton("Clear");

        l1.setBounds(100, 30, 400, 30);

        l2.setBounds(80, 70, 200, 30);



        tf1.setBounds(300, 70, 200, 30);



        btn1.setBounds(150, 160, 100, 30);

        btn2.setBounds(270, 160, 100, 30);

        add(l1);

        add(l2);

        add(tf1);




        add(btn1);

        add(btn2);

        btn1.addActionListener(this);

        btn2.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btn2)
        {
            tf1.setText("");


        }else
        {
        showData();


        }
    }

    public void showData() {

        JFrame f1 = new JFrame();

        JLabel l, l0;

        String str1 = tf1.getText();

        try {
//            readFile();
            etest(str1);
            countLines();


        } catch (Exception ex) {

            System.out.println(ex);

        }
    }

    public static void main(String args[]) {

        new test();

    }
}