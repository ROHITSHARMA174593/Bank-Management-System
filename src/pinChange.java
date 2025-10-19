import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;

public class pinChange extends JFrame implements ActionListener{

    JButton change, back;
    JPasswordField pinTextField, reEnterPinTextField;
    String pinNumber;
    pinChange(String pinNumber){
        this.pinNumber = pinNumber;

        setLayout(null);


        ImageIcon imgIcon = new ImageIcon(ClassLoader.getSystemResource("Images/atm.jpg"));
        Image myImg = imgIcon.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon imgIcon2 = new ImageIcon(myImg);
        JLabel image = new JLabel(imgIcon2);
        image.setBounds(0,0,900,900);
        add(image);



        JLabel text = new JLabel("Change Your Pin");
        text.setBounds(220, 290, 300, 35);
        text.setFont(new Font("Sans-Serif", Font.BOLD, 27));
        text.setForeground(Color.WHITE);
        image.add(text);


        JLabel pinText = new JLabel("New Pin :");
        pinText.setBounds(170, 360, 200, 35);
        pinText.setFont(new Font("Sans-Serif", Font.BOLD, 16));
        pinText.setForeground(Color.WHITE);
        image.add(pinText);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(290, 360, 220, 30);
        pinTextField.setFont(new Font("Sans-Serif", Font.BOLD, 16));
        pinTextField.setForeground(Color.BLACK);
        image.add(pinTextField);




        JLabel reEnterPinText = new JLabel("Re-Enter Pin :");
        reEnterPinText.setBounds(170, 420, 200, 35);
        reEnterPinText.setFont(new Font("Sans-Serif", Font.BOLD, 16));
        reEnterPinText.setForeground(Color.WHITE);
        image.add(reEnterPinText);

        reEnterPinTextField = new JPasswordField();
        reEnterPinTextField.setBounds(290, 420, 220, 30);
        reEnterPinTextField.setFont(new Font("Sans-Serif", Font.BOLD, 16));
        reEnterPinText.setForeground(Color.BLACK);
        image.add(reEnterPinTextField);




        back = new JButton("BACK");
        back.setBounds(180, 480, 130, 30);
        back.addActionListener(this);
        image.add(back);


        change = new JButton("CHANGE");
        change.setBounds(355, 480, 130, 30);
        change.addActionListener(this);
        image.add(change);







        setSize(900,900);
        setLocation(300,0);
        setVisible(true);


    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == change){
            try{
                String newPin = pinTextField.getText();
                String rePin = reEnterPinTextField.getText();
                if(!newPin.equals(rePin)){
                    JOptionPane.showMessageDialog(null, "Entered Pin Does Not Match.");
                    return;
                }

                if(newPin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please Enter New Pin");
                    return;
                }

                if(rePin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please Re-Enter new Pin");
                    return;
                }


                DatabaseConnection DC = new DatabaseConnection();
                String query1 = "UPDATE Bank SET Pin_Number = '"+rePin+"' WHERE Pin_Number='"+pinNumber+"'";
                String query2 = "UPDATE login SET Pin_Number = '"+rePin+"' WHERE Pin_Number='"+pinNumber+"'";
                String query3 = "UPDATE signupthree SET Pin_Number = '"+rePin+"' WHERE Pin_Number='"+pinNumber+"'";
                JOptionPane.showMessageDialog(null, "PIN Change Successfully");
                DC.st.executeUpdate(query1);
                DC.st.executeUpdate(query2);
                DC.st.executeUpdate(query3);



                //Now the Update Pin in DATABASE
                setVisible(false);
                new Tranjactions(rePin).setVisible(true);

            }catch(Exception err){
                System.out.println(err);
            }
        }else {
            setVisible(false);
            new Tranjactions(pinNumber).setVisible(true);
        }
    }
    public static void main(String[] args){
        new pinChange("").setVisible(true);
    }
}
