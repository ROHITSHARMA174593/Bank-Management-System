import javax.swing.*;
import java.awt.*;// For Image
import java.awt.event.*;
import java.util.*;//now it is use for Date


public class Deposit extends JFrame implements ActionListener{

    //Globally Define all the useful variable they use in another Class
    JTextField amountField;
    JButton deposit, back;
    String pinNumber;


    Deposit(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);


        ImageIcon imgIcon = new ImageIcon(ClassLoader.getSystemResource("Images/atm.jpg"));
        Image myImg = imgIcon.getImage().getScaledInstance(900,850, Image.SCALE_DEFAULT);
        //again convert this resized image in ImageIcon Predefined Variable
        ImageIcon imgIcon2 = new ImageIcon(myImg);
        JLabel image = new JLabel(imgIcon2);
        image.setBounds(0,0,900,900);
        add(image);



        JLabel message = new JLabel("Enter the Amount You Want to Deposit");
        message.setForeground(Color.WHITE);
        message.setFont(new Font("System", Font.BOLD, 16));
        message.setBounds(190, 300, 400, 20);
        image.add(message); // text ko image ke uper show karvaane ke liye isko image ke ander dalna hoga



        amountField = new JTextField();
        amountField.setFont(new Font("Raleway", Font.BOLD, 22));
        amountField.setBounds(180, 345, 300, 28);
        image.add(amountField);



        deposit = new JButton("Deposit");
        deposit.setBounds(360, 500, 145, 30);
        deposit.addActionListener(this);
        image.add(deposit);


        back = new JButton("Back");
        back.setBounds(360, 465, 145, 30);
        back.addActionListener(this);
        image.add(back);








        setSize(900,850);
        setLocation(300,0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == deposit){
            String Money = ""+amountField.getText();
            //now in database we use date also so here we need the access of date when user deposit money
            Date date = new Date();
            // ab hume check karna hai ki textField empty to nahi hai agar empty hai to ek dialog box show hoga
            if(amountField.equals("")){
                JOptionPane.showMessageDialog(null,"Please Enter Amount");
            }else{
                // todo:: Important !!!  yaha per har file ke ander Exception Handling karni hogi agar JDBC se related kuch bhi karna hua to otherwise bina error ke  bhi error milti hai
                try{
                    DatabaseConnection DC = new DatabaseConnection();
                    String query = "INSERT INTO Bank VALUES('"+pinNumber+"', '"+date+"', 'Deposit', '"+Money+"')";//deposit is the button name
                    DC.st.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "RS ₹ "+Money+" Deposited Successfully");
                    setVisible(false);// jaise hi deposit hoga ye wala frame close hoga for Safety||
                    new Tranjactions(pinNumber).setVisible(true);// humko ab jaha jaha bhi tranjaction ko call karvaayenge vaha vaha iske constructor me pinNumber ko pass karna hoga kyuki humne Tranjaction file ke ander pinNumber ko as a parameter pass kar rkha hai to isko har jagah likhna hi padega chahe use me lo ya mat lo ::
                }catch(Exception err){
                    System.out.println(err);
                }
            }
        }else if(ae.getSource() == back){
            //current Frame is close
            setVisible(false);
            new Tranjactions(pinNumber).setVisible(true);// tranjaction wala page open ho jaayega ||   jab hum "deposit" button per click karenge (Tranjaction file me) tab hmaare pass deposit file ka frame open hoga aur jaise hi usme back button per click karenge to fir se Tranajaction file per jaayega
        }
    }

    public static void main(String[] args){
        new Deposit("");// isko apne hi coustructor se liya hai isliye yaha empty string pass ki hai agar ab kahi per bhi Deposit class ka use lenge to hume  bracket me pinNumber dalana hoga kyuki humne uss me ye cheez as a parameter pass kar rakhi hai
    }
}
