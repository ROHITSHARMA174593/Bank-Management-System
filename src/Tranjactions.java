import javax.swing.*;
import java.awt.*;// for Set a Image and more things like font, Color etc.
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//we can write previous Two Libraries
//import java.awt.event.*;^^

public class Tranjactions extends JFrame implements ActionListener{
    //Globally Access of all the Variables
    JButton deposit, withdrawal, exit, balanceenquiry, fastcash, ministatement, pinchange;

    String pinNumber;

    Tranjactions(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);


        ImageIcon imgIcon = new ImageIcon(ClassLoader.getSystemResource("Images/atm.jpg"));
        Image myImg = imgIcon.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon imgIcon2 = new ImageIcon(myImg);
        JLabel image = new JLabel(imgIcon2);
        image.setBounds(0, 0, 900, 900);
        add(image);


        JLabel text = new JLabel("Please Select Your Transaction");
        text.setBounds(220, 300, 300, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Arial", Font.BOLD, 16));
        image.add(text); // text ka jo layout hai usko add function me image variable ki help se call karna padega jisse ki vo uss se uper ki taraf aaye






        //  Buttons
        deposit = new JButton("Deposit");
        deposit.setBounds(170,415, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);





        withdrawal = new JButton("Cash Withdrawal");
        withdrawal.setBounds(355,415, 150, 30);
        withdrawal.addActionListener(this);
        image.add(withdrawal);





        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(170,450, 150, 30);
        fastcash.addActionListener(this);
        image.add(fastcash);





        ministatement = new JButton("Mini Statement");
        ministatement.setBounds(355,450, 150, 30);
        ministatement.addActionListener(this);
        image.add(ministatement);





        pinchange = new JButton("Pin Change");
        pinchange.setBounds(170,485, 150, 30);
        pinchange.addActionListener(this);
        image.add(pinchange);





        balanceenquiry = new JButton("Balance Enquiry");
        balanceenquiry.setBounds(355,485, 150, 30);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);




        exit = new JButton("EXIT");
        exit.setBounds(355,520, 150, 30);
        exit.addActionListener(this);
        image.add(exit);








        setSize(900, 900);
        setLocation(300,0);
        setUndecorated(true);// Uper jo Minimize and Maximize and close ke buttons aate hai vo remove ho jaayenge
        setVisible(true);// setVisible true sabse last me likhna hota hai always

    }

    public void actionPerformed(ActionEvent ae){// we Cannot change the name of this class because it's and predefine class that is comes into a Interface(Action Listener) that is import From Java.awt.event.ActionListener
        if(ae.getSource() == exit){
            System.exit(0);
        }else if(ae.getSource() == deposit){// jaise hi koi deposit button per click  karega to ...
            setVisible(false);
            new Deposit(pinNumber).setVisible(true);// yaha se pinNumber ko pass kiya aur ab isko Deposit wali class me access kar lenge
        }else if(ae.getSource() == withdrawal){
            setVisible(false);
            new Withdrawal(pinNumber).setVisible(true);
        }else if(ae.getSource() == fastcash){
            setVisible(false);
            new FastCash(pinNumber).setVisible(true);
        }
    }

    public static void main(String[] args){
        new Tranjactions("");
    }
}
// todo ::: == Jitne bhi buttons ke ander addActionListener laga hua hai uska mtlb hai ki jaise hi un per koi Action Perform hoga yaha per perform se mtlb hai only Click to fir usko "actionPerformed" class ke ander if - else ke ander define kiya gaya hai ki uss Particular button ke saath kya functionality hogi