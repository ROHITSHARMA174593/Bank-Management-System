import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;// for ResultSet

public class FastCash extends JFrame implements ActionListener{
    JButton hundered, fivehundered, onethousand, twothousand, fivethousand, tenthousand, twentythousand, back;

    String pinNumber;
    FastCash(String pinNumber){
        this.pinNumber = pinNumber;
//        setLayout(null);

        ImageIcon imgIcon = new ImageIcon(ClassLoader.getSystemResource("Images/atm.jpg"));
        Image myImg = imgIcon.getImage().getScaledInstance(900,850, Image.SCALE_DEFAULT);
        ImageIcon imgIcon2 = new ImageIcon(myImg);
        JLabel image = new JLabel(imgIcon2);
        setBounds(0, 0, 900, 850);
        add(image);


        JLabel message = new JLabel("SELECT WITHDRAWAL AMOUNT ");
        message.setForeground(Color.WHITE);
        message.setFont(new Font("System", Font.BOLD, 17));
        message.setBounds(190, 275, 400, 20);
        image.add(message); // text ko image ke uper show karvaane ke liye isko image ke ander dalna hoga




        hundered = new JButton("Rs 100");
        hundered.setBounds(170, 335, 120, 30);
        hundered.addActionListener(this);
        image.add(hundered);


        fivehundered = new JButton("Rs 500");
        fivehundered.setBounds(370, 335, 120, 30);
        fivehundered.addActionListener(this);
        image.add(fivehundered);



        onethousand = new JButton("Rs 1000");
        onethousand.setBounds(170, 375, 120, 30);
        onethousand.addActionListener(this);
        image.add(onethousand);


        twothousand = new JButton("Rs 2000");
        twothousand.setBounds(370, 375, 120, 30);
        twothousand.addActionListener(this);
        image.add(twothousand);



        fivethousand = new JButton("Rs 5000");
        fivethousand.setBounds(170, 415, 120, 30);
        fivethousand.addActionListener(this);
        image.add(fivethousand);


        tenthousand = new JButton("Rs 10000");
        tenthousand.setBounds(370, 415, 120, 30);
        tenthousand.addActionListener(this);
        image.add(tenthousand);


        twentythousand = new JButton("Rs 20000");
        twentythousand.setBounds(170, 455, 120, 30);
        twentythousand.addActionListener(this);
        image.add(twentythousand);



        back = new JButton("Back");
        back.setBounds(370, 455, 120, 30);
        back.addActionListener(this);
        image.add(back);





        setSize(900,850);
        setLocation(300, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
            new Tranjactions(pinNumber).setVisible(true);
        }else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);// Substring kane se ye jitne bhi buttons hai unke starting 3 character,spaces ko remove kar dega and amount name ke variable me store hoga only Money || removed char&spaces(1=R, 2=s, 3=" ",      ab iske  baad jo bhi hoga vo amount me store ho jaayega)
            DatabaseConnection DC = new DatabaseConnection();
            try{
                ResultSet rs = DC.st.executeQuery("SELECT * FROM Bank WHERE Pin_Number = '"+pinNumber+"' ");
                double balance = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Double.parseDouble(rs.getString("amount"));// String ko integer me convert karne ke liye Integer.parseInt ka use hota hai

                    }else{
                        balance -= Double.parseDouble(rs.getString("amount"));
                    }
                }

                if (balance < Double.parseDouble(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }

                Date date = new Date();
                String query = "INSERT INTO Bank VALUES ('"+pinNumber+"', '"+date+"', 'Withdrawal', '"+amount+"')";
                DC.st.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs "+amount+" Debited Successfully");

                setVisible(false);
                new Tranjactions(pinNumber).setVisible(true);
            }catch(Exception err){
                System.out.println(err);
            }
        }
    }

    public static void main(String[] args){
        new FastCash("");
    }
}
