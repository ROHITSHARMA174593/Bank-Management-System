import javax.swing.*;// JFrame class ke liye swing package ko import karvaya
import java.awt.*;// Image class ke liye isko Import karvaya
import java.awt.event.*;
import java.sql.*; // Result Set and more classes


public class Login extends JFrame implements ActionListener{// implement karvaane ke baad ye error dega because interface ko kahi per defiine nahi kiya gaya hai and it is an Abstract Methoed so we need to define it outside the Main Method

    //todo::  Globally Button and Input fields Declaration because we need to use in ActionPerformed Method(ActionListener) and it is outside the Login Method
    JButton signInButton, signUpButton, clearButton;
    JTextField CardNumField;
    //for pin we need to Password Field
    JPasswordField PinInputField;

    Login(){
        setTitle("ATM(Automated Teller Machine)");

        setLayout(null);// now we always need to call add()Method because here we define the Null every Layout like(JButton, JLabel, JInputField)


        ImageIcon ImgIcon = new ImageIcon(ClassLoader.getSystemResource("Images/logo.jpg")); // size ko maintain karne ke liye image ka main object bnana padega
        Image myImgSize = ImgIcon.getImage().getScaledInstance(120,120, Image.SCALE_DEFAULT); // image ki size ko maintain krne ke liye getScaledInstance() Method ka use hota hai jo ki byDefault jFrame provide karvata hai

        ImageIcon myImgSizeObj = new ImageIcon(myImgSize); // isko isiliye bnaya hai taki label ke ander isko pass kar sake kyuki direct Image Class ko pass naih kar sakte
        JLabel myLabel = new JLabel(myImgSizeObj);// Image name ki class ko direct JLabel ke ander import nahi karva sakte isliye ek aur object bnana padega
        //JLabel function ek GUI(Graphical User Interface) hai jo ki image ko show karne ka kaam kar rha hai
        myLabel.setBounds(80,20,100,100);// ye ek Custom Layout bnaya hai lekin java ise allow nahi karta to isliye jo iska default layout rahta hai usko null karna padega
        add(myLabel);// add Function ke ander JLabel ka object hai jo ki reSized image ko show kar rha hai
        // Heading Image and Text
        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Sans-Serif", Font.BOLD, 45));
        text.setBounds(235, 20, 450, 80);// todo ::: Maine Login Page ka setLayout(null) kar diya hai to mujhe ab jaha bhi JLabel ka use lena hoga vaha uska SetBounds() set karna hoga jisse ki vo custom rahe aur hum Add()Method ko call karke use show bhi kravate rahe
        add(text);

        //Middle Data
        // Card Number
        JLabel cardNo = new JLabel("Card No :");
        cardNo.setFont(new Font("Sans-Serif", Font.BOLD, 30));
        cardNo.setBounds(85, 115, 350, 100);
        add(cardNo);

        // Card Number Input::
        // isme hume JInputField likhne ki need nahi hai kyuki humne usko Globally Define kar diya hai go to >> outside the Login Method ^^^👆👆👆👆
        CardNumField = new JTextField();
        //setFontSizeLikePreviousData
        CardNumField.setFont(new Font("Cursive ", Font.BOLD, 20));
        CardNumField.setBounds(245,145,320,45);
        add(CardNumField);


        // User PIN ::
        JLabel PinNO = new JLabel("PIN         :");
        PinNO.setFont(new Font("Sans-Serif", Font.BOLD, 30));
        PinNO.setBounds(85, 177, 350, 100);
        add(PinNO);

        //Input Field of PIN :
        PinInputField = new JPasswordField();// because it is secure text field
        //set Font Size of Input Field
        PinInputField.setFont(new Font("Cursive", Font.BOLD, 20));
        PinInputField.setBounds(245, 208, 320, 45);
        add(PinInputField);




//todo ::: Buttons Content Start from Here
        // ab hume buttons per JButton likhne ki bhi need nahi hai kyuki humne JButton ko globally define kar diya hai outside the Login Method ^^^👆👆👆👆
        signInButton = new JButton("SIGN IN"); // yaha per humne JButton ko tino button ke aage se hata diya hai because vo ab globally define hai to ab uski need nahi hai ki block ke ander bhi define kare
        signInButton.setBounds(255, 275, 120, 45);
        signInButton.setBackground(Color.BLACK);
        signInButton.setForeground(Color.WHITE);
        signInButton.addActionListener(this);
        add(signInButton);

        signUpButton = new JButton("SIGN UP");
        signUpButton.setBounds(435, 275, 120, 45);
        signUpButton.setBackground(Color.BLACK);
        signUpButton.setForeground(Color.WHITE);
        signUpButton.addActionListener(this);
        add(signUpButton);

        clearButton = new JButton("CLEAR");
        clearButton.setBounds(250, 345, 310, 45);
        clearButton.setBackground(Color.BLACK);
        clearButton.setForeground(Color.WHITE);
        clearButton.addActionListener(this);// is Functionality se Button per click event lagaye jaate hai jisse ki us per kuch particular task perform kar sake
        add(clearButton);// Add hameesha karna padega Class ko kyuki iske bina screen per kuch bhi show nahi hoga
        // And JFrame ki classes (button, textArea, textField) ke ander setVisibility(True) Kaam nahi karta hai

//todo ::: Buttons Content Ends Here



        getContentPane().setBackground(Color.WHITE);

        setSize(700, 450);
        setVisible(true);
        setLocation(350, 200);
    }

    public void actionPerformed(ActionEvent ae){ // We cannot change this Abstract Method name ("Action Event ye btata hai ki konse button per click hua , humne  sabhhi buttons per addActionListener laga rkha hai ")
        if(ae.getSource() == clearButton){
            CardNumField.setText("");
            PinInputField.setText("");
        }else if(ae.getSource() == signInButton){
            DatabaseConnection DC = new DatabaseConnection();
            String cardNumber = CardNumField.getText();
            String pinNumber = PinInputField.getText();// iss per yellow line isliye aa rhi hai kyuki pin ek password field hai aur password ke liye getText ka use nahi karna chahiye but abhi koi option nahi hai
            String query = "SELECT * FROM login WHERE Card_Number = '"+cardNumber+"' AND Pin_Number = '"+pinNumber+"' ";// yaha per jo string ke ander Card_Number and Pin_Number de rakha hai ye database me jo table ka name hai vo hi dena hai kyuki ye ek query hai SQL ki

            try{
                ResultSet RS =  DC.st.executeQuery(query);
                if(RS.next()){
                    setVisible(false);// Agar Table ke ander given condition match ho gayi to fir ye if ki condtion Hit hogi and current Frame close ho jaayega and Transaction wale ko open kar denge
                    new Tranjactions(pinNumber).setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number and Pin");
                }
            }catch(Exception err){
                System.out.println(err);
            }
        }else if(ae.getSource() == signUpButton){
            setVisible(false); // abhi jo bhi page hoga vo to visible hoga nahi
            new SignUpOne().setVisible(true);// And jo SignUpOne name ki file hai vo active ho jaayegi because byDefault to vo folse hoti hai lekin yaha humne isko true kar diya hai to uski jagah SignUpOne visible ho jaayegi
        }

        // "ae" is a parameter that is find the location on which button user click because we write on everyButton ActionListener
    }




    public static void main(String[] args){
        new Login();
    }
}
//todo::: Important ::: Set Bound Har jagah dena padega kyuki Layout Null Hai Aur isse hum uski size and X-angle and Y-Angele dekh sakte hai