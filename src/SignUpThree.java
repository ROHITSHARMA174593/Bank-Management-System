import com.mysql.cj.jdbc.ConnectionImpl;


import javax.swing.*;// JFrame
import java.awt.*;// for Font
import java.awt.event.*;// Action Listener implementation
import java.util.Random;// For Random card Number

public class SignUpThree extends JFrame implements ActionListener{

    JRadioButton savingAcc, fixDepositAcc, currentAcc, recDepoAcc;
    JCheckBox atmCard, internetBanking, mobileBanking, mailAlert, chequeBook, e_Statement;
    JButton submitButton, cancelButton;

    SignUpThree(){
        setLayout(null);// for set according to me all the JFrame class(JLabel, JTextField, JRadioButton, JComboBox)

        JLabel heading = new JLabel("Page 3 : Account Details");
        heading.setBounds(245, 45, 380, 45);
        heading.setFont(new Font("Raleway", Font.BOLD, 28));
        add(heading);

        JLabel accountType = new JLabel("Account Type : ");
        accountType.setBounds(100, 120, 180, 45);
        accountType.setFont(new Font("Raleway", Font.BOLD, 22));
        add(accountType);

        //Radio Buttons start
        savingAcc = new JRadioButton("Saving Account ");
        savingAcc.setBounds(120, 160, 230, 45);
        savingAcc.setFont(new Font("Sans-Serif", Font.BOLD, 16));
        savingAcc.setBackground(Color.WHITE);
        add(savingAcc);

        fixDepositAcc = new JRadioButton("Fix Deposit Amount");
        fixDepositAcc.setBounds(420, 160, 230, 45);
        fixDepositAcc.setFont(new Font("Sans-Serif", Font.BOLD, 16));
        fixDepositAcc.setBackground(Color.WHITE);
        add(fixDepositAcc);

        currentAcc = new JRadioButton("Current Account ");
        currentAcc.setBounds(120, 205, 230, 45);
        currentAcc.setFont(new Font("Sans-Serif", Font.BOLD, 16));
        currentAcc.setBackground(Color.WHITE);
        add(currentAcc);

        recDepoAcc = new JRadioButton("Recurring Deposit Amount");
        recDepoAcc.setBounds(420, 205, 280, 45);
        recDepoAcc.setFont(new Font("Sans-Serif", Font.BOLD, 16));
        recDepoAcc.setBackground(Color.WHITE);
        add(recDepoAcc);

        //Now you can select only one radio button
        ButtonGroup accountTypeRadioButtonGroup = new ButtonGroup();
        accountTypeRadioButtonGroup.add(savingAcc);
        accountTypeRadioButtonGroup.add(currentAcc);
        accountTypeRadioButtonGroup.add(fixDepositAcc);
        accountTypeRadioButtonGroup.add(recDepoAcc);


        // Card Data
        JLabel card = new JLabel("Card Number :");
        card.setFont(new Font("Sans-Serif", Font.BOLD, 20));
        card.setBounds(100, 280, 170, 30);
        add(card);

        JLabel cardNumber = new JLabel("XXXX-XXXX-XXXX-1745");
        cardNumber.setFont(new Font("Sans-Serif", Font.BOLD, 20));
        cardNumber.setBounds(420, 280, 260, 30);
        add(cardNumber);


        JLabel belowCard = new JLabel("(Your 16 digit card number) :");
        belowCard.setBounds(110, 310, 180, 30);
        belowCard.setFont(new Font("Sans-Serif", Font.BOLD, 12));
        add(belowCard);

        JLabel belowCardNumber = new JLabel("It would appear on ATM card, CheckBook, Bank Statement");
        belowCardNumber.setBounds(400, 310, 330, 30);
        belowCardNumber.setFont(new Font("Sans-Serif", Font.BOLD, 12));
        add(belowCardNumber);


        //PIN Data
        JLabel pin = new JLabel(" PIN : ");
        pin.setBounds(100, 350, 100, 30);
        pin.setFont(new Font("Sans-Serif", Font.BOLD, 20));
        add(pin);

        JLabel realPin = new JLabel("XXXX");
        realPin.setBounds(420, 350, 100, 30);
        realPin.setFont(new Font("Sans-Serif", Font.BOLD, 20));
        add(realPin);

        JLabel digitDescription = new JLabel("(4-Digit Password)");
        digitDescription.setBounds(120, 370, 180, 30);
        digitDescription.setFont(new Font("Sans-Serif", Font.BOLD, 12));
        add(digitDescription);


        //Service Required Menu:::
        JLabel serviceRequired = new JLabel("Service Required :");
        serviceRequired.setBounds(100, 430, 240, 30);
        serviceRequired.setFont(new Font("Sans-Serif", Font.BOLD, 22));
        add(serviceRequired);

        atmCard = new JCheckBox("ATM Card ");
        atmCard.setBounds(125, 480, 170, 30);
        atmCard.setFont(new Font("Sans-Serif", Font.BOLD, 17));
        atmCard.setBackground(Color.WHITE);
        add(atmCard);

        internetBanking = new JCheckBox("Internet Banking ");
        internetBanking.setBounds(420, 480, 170, 30);
        internetBanking.setFont(new Font("Sans-Serif", Font.BOLD, 17));
        internetBanking.setBackground(Color.WHITE);
        add(internetBanking);

        mobileBanking = new JCheckBox("Mobile Banking");
        mobileBanking.setBounds(125, 530, 170, 30);
        mobileBanking.setFont(new Font("Sans-Serif", Font.BOLD, 17));
        mobileBanking.setBackground(Color.WHITE);
        add(mobileBanking);

        mailAlert = new JCheckBox("E-mail Alerts");
        mailAlert.setBounds(420, 530, 170, 30);
        mailAlert.setFont(new Font("Sans-Serif", Font.BOLD, 17));
        mailAlert.setBackground(Color.WHITE);
        add(mailAlert);

        chequeBook = new JCheckBox("Cheque Book");
        chequeBook.setBounds(120, 580, 170, 30);
        chequeBook.setFont(new Font("Sans-Serif", Font.BOLD, 17));
        chequeBook.setBackground(Color.WHITE);
        add(chequeBook);

        e_Statement = new JCheckBox("E-Statement");
        e_Statement.setBounds(420, 580, 170, 30);
        e_Statement.setFont(new Font("Sans-Serif", Font.BOLD, 17));
        e_Statement.setBackground(Color.WHITE);
        add(e_Statement);


        // we can group CheckBoxes like Radio Buttons (Only Any One is Select)
//        ButtonGroup gr = new ButtonGroup();
//        gr.add(mailAlert);
//        gr.add(atmCard);
//        gr.add(internetBanking);
//        gr.add(mobileBanking);





        // Final CheckBox // that is a Message
        JCheckBox finalCheckBox = new JCheckBox("I hereby declares that the above entered details correct to the best of my Knowledge");
        finalCheckBox.setBounds(170, 680, 470, 30);
        finalCheckBox.setFont(new Font("Sans-Serif", Font.BOLD, 10));
        finalCheckBox.setBackground(Color.WHITE);
        add(finalCheckBox);


        //Final Buttons
        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(170, 720, 175, 40);
        cancelButton.setFont(new Font("Sans-Serif", Font.BOLD, 18));
        cancelButton.setBackground(Color.BLACK);
        cancelButton.setForeground(Color.white);
        cancelButton.addActionListener(this);
        add(cancelButton);



        submitButton = new JButton("Submit");
        submitButton.setBounds(450, 720, 175, 40);
        submitButton.setFont(new Font("Sans-Serif", Font.BOLD, 18));
        submitButton.setBackground(Color.black);
        submitButton.setForeground(Color.white);
        submitButton.addActionListener(this);
        add(submitButton);






        getContentPane().setBackground(Color.WHITE);
        setSize(850,820);
        setLocation(350,0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        //todo : Which type of Account Access____________________Start
        if(ae.getSource() == submitButton){
            String AccountType = null;
            if(savingAcc.isSelected()){
                AccountType = "Saving Account";
            }else if(fixDepositAcc.isSelected()){
                AccountType = "Fix Deposit Amount";
            }else if(currentAcc.isSelected()){
                AccountType = "Current Account";
            }else if(recDepoAcc.isSelected()){
                AccountType = "Recurring Deposit Amount";
            }
            //todo : Which type of Account Access____________________ End



            //Now Create Random Card Number 16Digit
            Random  random = new Random();
            String cardNumber = ""+Math.abs((random.nextLong() % 90000000l) + 1745930000000000l);// it Returns 16 Random Number
            //here we concat with an string then it will convert in a string

            //Now Generate a 4 Digit Pin Number
            String pinNumber = ""+Math.abs((random.nextLong() % 9000) + 1000);



        //todo : = Check Boxes Access (Multiple CheckBox)
            String facility = "";
            if(atmCard.isSelected()){
                facility = facility + " ATM Card";
            }else if(internetBanking.isSelected()){
                facility = facility + " Internet Banking";
            }else if(mobileBanking.isSelected()){
                facility = facility + " Mobile Banking";
            }else if(mailAlert.isSelected()){
                facility = facility + " Mail Alert!";
            }else if(chequeBook.isSelected()){
                facility = facility + " Cheque Book";
            }else if(e_Statement.isSelected()){
                facility = facility + " E-Statement";
            }

            // Now the Database manage
            try{
                if(AccountType.equals("")){
                    JOptionPane.showMessageDialog(null, "Account Type is Required");
                }else{
                    DatabaseConnection DC = new DatabaseConnection();//Class Name
                    String query1 = "INSERT INTO signupthree VALUES ('"+AccountType+"', '"+cardNumber+"', '"+pinNumber+"', '"+facility+"')";
                    String query2 = "INSERT INTO login VALUES ('"+cardNumber+"', '"+pinNumber+"')";
                    DC.st.executeUpdate(query1);
                    DC.st.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null, "Form Data store on Database");
                    JOptionPane.showMessageDialog(null, "Card Number : "+cardNumber+" \n Pin Number : "+pinNumber);
                    //For User Information like(cardNumber, pinNumber, formno)

                    //todo :: Abhi m chahta hu ki jaise hi user new SignUp kar le to uske baad uske pass automatic hi login page fir se open hoke aa jaaye
                    setVisible(false);
                    new Deposit(pinNumber).setVisible(true);

                }
            }catch(Exception err){
                System.out.println(err);
            }



        }else if(ae.getSource() == cancelButton){
            setVisible(false);
            new Login().setVisible(true);
        }
    }

    public static void main(String[] args){
        new SignUpThree();
    }
}










































