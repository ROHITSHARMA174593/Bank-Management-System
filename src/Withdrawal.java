import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.*;

public class Withdrawal extends JFrame implements ActionListener{
    JTextField amountField;
    JButton withdrawal, back;
    String pinNumber;


    Withdrawal(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);


        ImageIcon imgIcon = new ImageIcon(ClassLoader.getSystemResource("Images/atm.jpg"));
        Image myImg = imgIcon.getImage().getScaledInstance(900,850, Image.SCALE_DEFAULT);
        //again convert this resized image in ImageIcon Predefined Variable
        ImageIcon imgIcon2 = new ImageIcon(myImg);
        JLabel image = new JLabel(imgIcon2);
        image.setBounds(0,0,900,900);
        add(image);



        JLabel message = new JLabel("Enter the Amount You Want to Withdrawal");
        message.setForeground(Color.WHITE);
        message.setFont(new Font("System", Font.BOLD, 16));
        message.setBounds(190, 300, 400, 20);
        image.add(message); // text ko image ke uper show karvaane ke liye isko image ke ander dalna hoga




        amountField = new JTextField();// for Withdrawal
        amountField.setFont(new Font("Raleway", Font.BOLD, 22));
        amountField.setBounds(180, 345, 300, 28);
        image.add(amountField);




        withdrawal = new JButton("Withdraw");
        withdrawal.setBounds(360, 500, 145, 30);
        withdrawal.addActionListener(this);
        image.add(withdrawal);


        back = new JButton("Back");
        back.setBounds(360, 465, 145, 30);
        back.addActionListener(this);
        image.add(back);



        setSize(900,850);
        setLocation(300,0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == withdrawal) {
            String MoneyStr = amountField.getText(); // Capital M used
            Date date = new Date();

            if (MoneyStr.equals("")) {
                JOptionPane.showMessageDialog(null, "Please Enter Amount for Withdrawal");
                return;
            }

            try {
                int Money = Integer.parseInt(MoneyStr); // Capital M

                DatabaseConnection DC = new DatabaseConnection();

                // Step 1: Get all transactions of this pin
                String query = "SELECT type, amount FROM Bank WHERE Pin_Number = '" + pinNumber + "'";
                ResultSet rs = DC.st.executeQuery(query);

                int balance = 0;

                // Step 2: Calculate balance
                while (rs.next()) {
                    String type = rs.getString("type");
                    int amount = rs.getInt("amount");

                    if (type.equalsIgnoreCase("Deposit")) {
                        balance += amount;
                    } else if (type.equalsIgnoreCase("Withdrawal")) {
                        balance -= amount;
                    }
                }

                // Step 3: Check if balance is enough
                if (Money > balance) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }

                // Step 4: Proceed with withdrawal
                String insertQuery = "INSERT INTO Bank VALUES ('" + pinNumber + "', '" + date + "', 'Withdrawal', '" + Money + "')";
                DC.st.executeUpdate(insertQuery);

                JOptionPane.showMessageDialog(null, "RS ₹ " + Money + " Withdrawn Successfully");
                setVisible(false);
                new Tranjactions(pinNumber).setVisible(true);

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number");
            } catch (Exception err) {
                System.out.println(err);
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Login().setVisible(true);
        }
    }


    public static void main(String[] args){
        new Withdrawal("");
    }
}
