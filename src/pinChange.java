import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class pinChange extends JFrame implements ActionListener{

    JButton change, back;
    JTextField pinTextField, reEnterPinTextField;
    pinChange(String pinChange){
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

        pinTextField = new JTextField();
        pinTextField.setBounds(290, 360, 220, 30);
        pinTextField.setFont(new Font("Sans-Serif", Font.BOLD, 16));
        pinTextField.setForeground(Color.WHITE);
        image.add(pinTextField);




        JLabel reEnterPinText = new JLabel("Re-Enter Pin :");
        reEnterPinText.setBounds(170, 420, 200, 35);
        reEnterPinText.setFont(new Font("Sans-Serif", Font.BOLD, 16));
        reEnterPinText.setForeground(Color.WHITE);
        image.add(reEnterPinText);

        reEnterPinTextField = new JTextField();
        reEnterPinTextField.setBounds(290, 420, 220, 30);
        reEnterPinTextField.setFont(new Font("Sans-Serif", Font.BOLD, 16));
        reEnterPinTextField.setForeground(Color.WHITE);
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

    }
    public static void main(String[] args){
        new pinChange("").setVisible(true);
    }
}
