import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.sql.ResultSet;

public class MiniStatement extends JFrame{

    String pinNumber;
    MiniStatement(String pinNumber){
        this.pinNumber = pinNumber;
        setTitle("Mini Statement");

        JLabel mini = new JLabel();
        mini.setBounds(20,140,400,200);
        add(mini);

        JLabel bank = new JLabel("State Bank of India");
        bank.setBounds(150,20,200,20);
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20,100,300,30);
        add(card);

        JLabel balance = new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);

        // This try catch is for show the Card Number :: Which Card Number Statement is Return ...
        try{
            DatabaseConnection DC = new DatabaseConnection();
            ResultSet RS = DC.st.executeQuery("SELECT * FROM login WHERE Pin_Number='"+pinNumber+"'");
            while(RS.next()){
                card.setText("Card Number : "+RS.getString("Card_Number").substring(0, 4)+ "XXXXXXXX"+ RS.getString("Card_Number").substring(12));
            }
        }catch(Exception err){
            err.printStackTrace();
        }

        // This try Catch is for show last 5 bank statements
        try{
            DatabaseConnection DC = new DatabaseConnection();
            ResultSet RS = DC.st.executeQuery("select * from bank where Pin_Number='"+pinNumber+"'");
            while(RS.next()){
                mini.setText(mini.getText()+"<html>"+RS.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ RS.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+RS.getString("amount")+"<br><br></html>");
                // here we use html tag for use html Tags like br, and other according to need &nbsp; is for space
            }
        }catch(Exception err){
            err.printStackTrace();
        }

        setSize(400,600);
        setLocation(20,20);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);

    }

    public static void main(String[] args){
        new MiniStatement("");
    }
}
