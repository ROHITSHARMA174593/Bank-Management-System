import com.mysql.cj.jdbc.ConnectionImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

public class BalanceInquiry extends JFrame implements ActionListener{

    String pinnumber;
    JButton back;
    BalanceInquiry(String pinnumber){
        this.pinnumber = pinnumber;

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Images/atm.jpg"));
        Image i2 = img.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);


        back = new JButton("Back");
        back.setBounds(355, 520, 145, 30);
        back.addActionListener(this);
        image.add(back);


        // jab hume button ke click per JDBC ki query chalani hoti hai to hum iska code Action Listener wali class ke ander likhte hai lekin abhi hume direct show karna hai
        DatabaseConnection DC = new DatabaseConnection();
        int balance = 0;
        try{
            ResultSet RS = DC.st.executeQuery("Select * from bank where Pin_Number = '"+pinnumber+"'");
            while(RS.next()){
                if(RS.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(RS.getString("amount"));
                }else{
                    balance -= Integer.parseInt(RS.getString("amount"));
                }
            }
        } catch(Exception err){
            System.out.println(err);
        }

        JLabel text = new JLabel("Your Current Account Balance is Rs:"+balance);
        text.setForeground(Color.WHITE);
        text.setBounds(170,300, 400, 30);
        image.add(text);

        setSize(900,900);
        setLocation(320, 0);
        setLayout(null);
//        setUndecorated(true); // iss line ka mtlb hai jo Frame me top per minimize, maximize, close ke button jo hote hai vo show hona band ho jaayenge
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Tranjactions(pinnumber).setVisible(true);
    }


    public static void main(String[] args){
        new BalanceInquiry("");
    }
}
