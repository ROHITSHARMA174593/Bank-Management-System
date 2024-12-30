import javax.swing.*; // SetBounds and JFrames
import java.awt.*;// Fonts and Colors
import java.awt.event.*;// Action Listener and Action Event
import java.util.*;// Here is the Math and Random Method






public class SignUpOne extends JFrame implements ActionListener{
    long random;// globally Initialized Variable
    // now we need to Global all the Text Fields
    JTextField nameTextField, fNameTextField, dobTextField,  pinCodeTextField, stateTextField, cityTextField, addressTextField, emailAddTextField;
    JButton next;
    JRadioButton mailButton, femaleButton, marriedButton, unMarriedButton;



    SignUpOne(){

        setTitle("New Account Applicaton Form : 1");
        setLayout(null);

        JLabel heading = new JLabel("Page 1 : Personal Details");
        heading.setBounds(160,25,320,50);
        heading.setFont(new Font("Arial", Font.BOLD, 25));
        add(heading);

        // Here we need to create a Random Number
        Random ran = new Random();// Import from (Random) === Java.util.*; (Random)
//        System.out.println(Math.abs((random.nextLong() % 9000) + 1000));
        random = Math.abs((ran.nextLong() % 9000) + 1000);

        JLabel FormNo = new JLabel("Application Form No. "+random);
        FormNo.setFont(new Font("Arial", Font.BOLD, 20));
        FormNo.setBounds(320,65,250,45);
        add(FormNo);

        // Form Starts From here
        //All the Labels and Inputs
        JLabel Name = new JLabel("Name  :");
        Name.setBounds(93, 155, 100, 20);
        Name.setFont(new Font("Sans-Serif", Font.BOLD, 18));
        add(Name);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Sans-Serif", Font.BOLD, 15));
        nameTextField.setBounds(280, 150, 320, 37);
        add(nameTextField);





        JLabel FName = new JLabel("Father's Name  :");
        FName.setBounds(93, 195, 150, 20);
        FName.setFont(new Font("Sans-Serif", Font.BOLD, 18));
        add(FName);

        fNameTextField = new JTextField();
        fNameTextField.setFont(new Font("Sans-Serif", Font.BOLD, 15));
        fNameTextField.setBounds(280, 190, 320, 35);
        add(fNameTextField);




        JLabel dob = new JLabel("Date Of Birth  :");
        dob.setBounds(93, 235, 150, 20);
        dob.setFont(new Font("Sans-Serif", Font.BOLD, 18));
        add(dob);

        dobTextField = new JTextField();
        dobTextField.setBounds(280, 230, 320, 35);
        add(dobTextField);





        JLabel gender = new JLabel("Gender  :");
        gender.setBounds(93, 275, 150, 20);
        gender.setFont(new Font("Sans-Serif", Font.BOLD, 18));
        add(gender);

        //Radio Buttons
        mailButton = new JRadioButton("Male");
        mailButton.setBounds(280, 275, 80, 35);
        mailButton.setBackground(Color.WHITE);
        add(mailButton);

        femaleButton = new JRadioButton("Female");
        femaleButton.setBounds(380, 275, 120, 35);
        femaleButton.setBackground(Color.WHITE);
        add(femaleButton);
        // abhi ye dono radio buttons ek saath select ho sakte hai isliye inko group karna hoga
        ButtonGroup radioGenderButtonGroup = new ButtonGroup();
        radioGenderButtonGroup.add(mailButton);
        radioGenderButtonGroup.add(femaleButton);





        JLabel email = new JLabel("Email Address  :");
        email.setBounds(93, 315, 150, 20);
        email.setFont(new Font("Sans-Serif", Font.BOLD,18));
        add(email);

        emailAddTextField = new JTextField();
        emailAddTextField.setFont(new Font("Sans-Serif", Font.BOLD, 15));
        emailAddTextField.setBounds(280, 315, 320, 35);
        add(emailAddTextField);







        JLabel marital = new JLabel("Marital Status  :");
        marital.setBounds(93, 355, 150, 20);
        marital.setFont(new Font("Sans-Serif", Font.BOLD,18));
        add(marital);

        marriedButton = new JRadioButton("Married");
        marriedButton.setBounds(280, 350, 80, 35);
        marriedButton.setBackground(Color.WHITE);
        add(marriedButton);

        unMarriedButton = new JRadioButton("UnMarried");
        unMarriedButton.setBounds(380, 350, 120, 35);
        unMarriedButton.setBackground(Color.WHITE);
        add(unMarriedButton);

        // abhi ye dono radio buttons ek saath select ho sakte hai isliye inko bhi group karna hoga
        ButtonGroup radioMaritalButtonGroup = new ButtonGroup();
        radioMaritalButtonGroup.add(marriedButton);
        radioMaritalButtonGroup.add(unMarriedButton);





        JLabel address = new JLabel("Address  :");
        address.setBounds(93, 395, 150, 20);
        address.setFont(new Font("Sans-Serif", Font.BOLD,18));
        add(address);

        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Sans-Serif", Font.BOLD, 15));
        addressTextField.setBounds(280, 388, 320, 35);
        add(addressTextField);




        JLabel city = new JLabel("City  :");
        city.setBounds(93, 435, 150, 20);
        city.setFont(new Font("Sans-Serif", Font.BOLD,18));
        add(city);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Sans-Serif", Font.BOLD, 15));
        cityTextField.setBounds(280, 430, 320, 35);
        add(cityTextField);




        JLabel state = new JLabel("State  :");
        state.setBounds(93, 475, 150, 20);
        state.setFont(new Font("Sans-Serif", Font.BOLD,18));
        add(state);

        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Sans-Serif", Font.BOLD, 15));
        stateTextField.setBounds(280, 470, 320, 35);
        add(stateTextField);



        JLabel pinCode = new JLabel("Pin Code  :");
        pinCode.setBounds(93, 515, 150, 20);
        pinCode.setFont(new Font("Sans-Serif", Font.BOLD,18));
        add(pinCode);

        pinCodeTextField = new JTextField();
        pinCodeTextField.setFont(new Font("Sans-Serif", Font.BOLD, 15));
        pinCodeTextField.setBounds(280, 510, 320, 35);
        add(pinCodeTextField);



        //Final Button is Here
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(300, 585, 120,45);
        next.setFont(new Font("Raleway", Font.BOLD, 20));
        next.addActionListener(this); // todo ::: Here is the Main Access of ActionListener that is use onCLick on(this) // mtlb jab koi iss per click karega tob hi task perform hoga Actionperformed Class ka
        add(next);





        setSize(650,750);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
        setLocation(450,20);
    }

    public void actionPerformed(ActionEvent ae){ // ActionListener Interface ke ander ek actionPerformed method bna hua hai usko call karke kisi particular element par hue task ka access le sakte hai
        String formNo = "" + random; //random is a Long datatype value so first we need to convert in a String (" "+variable)
        String name = nameTextField.getText();//text field me jo bhi value hai vo nikalne ke liye
        String fName = fNameTextField.getText();
        String dob = dobTextField.getText();
//        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText(); // Text direct Concat nahi ho sakta isliye usko pehle TextField me conver karvaya aur uske baad puri JTextField ko getText method me concat karva diya ++
        String gender = null;
        if(mailButton.isSelected()){ // agar mail Button Selected hua to gender ke ander Mail pass kar denge and else is opposite side of it.
            gender = "Mail";
        }else if(femaleButton.isSelected()) {
            gender = "Female";
        }

        String email = emailAddTextField.getText();
        String marital = null;
        if(marriedButton.isSelected()){ // here also task is like gender functionality
            marital = "Married";

        }else if(unMarriedButton.isSelected()){
            marital = "UnMarried";
        }


        String state = stateTextField.getText();
        String city = cityTextField.getText();
        String address = addressTextField.getText();
        String pinCode = pinCodeTextField.getText();


        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is Required");// ek middle wala alert box show karne ke liye hai
            }else{
                DatabaseConnection DC = new DatabaseConnection();
                String query = "insert into signup values('" + formNo + "', '" + name + "', '" + fName + "', '" + dob + "', '" + email + "', '" + gender + "', '" + marital + "', '" + address + "', '" + city + "', '" + state + "', '" + pinCode + "')";
                DC.st.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Form submitted successfully!");

                setVisible(false);// jisse ki jo page abhi open hoga current me vo inVisible ho jaayega and
                new SignUpTwo().setVisible(true);// SignUpTwo page visible ho jaayega
            }
        }catch(Exception err){
           err.printStackTrace();
        }



// todo :: abhi ke liye maine isko try block ke else ke ander rakh diya hai baad me agar kuch aur functioinality add karni hui to fir alag se rakh denge
        // Sign Up one(1) Page me jo last Next ka button hai uss per koi click karega to SignUpTwo page visible hoga!!!
//        if(ae.getSource() == next){
//            setVisible(false);
//            new SignUpTwo().setVisible(true);
//        }// Iss kaam ko direct Else(in Try Block) ki condiiton me bhi kar sakte hai bina kisi getSource ke




    }

    public static void main(String[] args){

        new SignUpOne();
    }
}
