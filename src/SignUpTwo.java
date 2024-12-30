import com.mysql.cj.jdbc.ConnectionImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class SignUpTwo extends JFrame implements ActionListener{
    //Declaration of All the Data Globally
    JButton next;
    JRadioButton existingAccountButtonNo, existingAccountButtonYes, seniorCitizenRadioButtonNo, seniorCitizenRadioButtonYes;
    JTextField aadharNumField, panNumField;
    JComboBox religionMenu, categoryMenu, incomeMenu, educationMenu, occupationMenu;


    SignUpTwo(){
        setTitle("New Account Appliation Form : 2");
        setLayout(null); // because ye apne aap se default layout set kar deta hai jo ki content ko center me le aata hai to it is necessary(null) and setBound bhi jab hi work karega jab ye null hoga




        //Heading
        JLabel heading = new JLabel("Page 2 : Additional Details");
        heading.setBounds(200, 40, 300, 30);
        heading.setFont(new Font("Arial", Font.BOLD, 20));
        add(heading);





        // Form Start
        JLabel religion = new JLabel("Religioin:");
        religion.setBounds(55, 120, 150, 45);
        religion.setFont(new Font("Arial", Font.BOLD, 20));
        add(religion);
        //DropDown Menu
        String religionElem[] = {" ","Hindu", "Muslim", "Sikh", "Christian", "Other"} ;
        religionMenu = new JComboBox(religionElem);
        religionMenu.setBounds(230, 130, 320, 30);
        add(religionMenu);








        JLabel category = new JLabel("Category :");
        category.setBounds(55, 175, 150, 45);
        category.setFont(new Font("Arial", Font.BOLD, 20));
        add(category);

        String categoryElem[] = {" ","General", "OBC", "ST", "SC"} ;
        categoryMenu = new JComboBox(categoryElem);
        categoryMenu.setBounds(230, 185, 320, 30);
        add(categoryMenu);








        JLabel income = new JLabel("Income :");
        income.setBounds(55, 230, 150, 45);
        income.setFont(new Font("Arial", Font.BOLD, 20));
        add(income);

        String incomeElem[] = {" ","Null", " < 1,50,000 ", " < 2,50,000", " < 5,00,000", " > 5,00,000", " < 10,00,000"} ;
        incomeMenu = new JComboBox(incomeElem);
        incomeMenu.setBounds(230, 240, 320, 30);
        add(incomeMenu);








        JLabel eduquali = new JLabel("Education  :");
        eduquali.setBounds(55, 285, 170, 45);
        eduquali.setFont(new Font("Arial", Font.BOLD, 20));
        add(eduquali);

        String educationElem[] = {" ", "Non-Graduation", "Post-Graduation", "Graduate", "Doctrate", "Other"};
        educationMenu = new JComboBox(educationElem);
        educationMenu.setBounds(230, 295, 320,30);
        add(educationMenu);









        JLabel occupation = new JLabel("Occupation :");
        occupation.setBounds(55, 340, 150, 45);
        occupation.setFont(new Font("Arial", Font.BOLD, 20));
        add(occupation);

        String occupationElem[] = {" ", "Salaried", "Self-Employed", "Business", "Student", "Retired", "Other"};
        occupationMenu = new JComboBox(occupationElem);
        occupationMenu.setBounds(230, 350, 320, 30);
        add(occupationMenu);










        JLabel panNum = new JLabel("Pan Number :");
        panNum.setBounds(55, 395, 150, 45);
        panNum.setFont(new Font("Arial", Font.BOLD, 20));
        add(panNum);

        panNumField = new JTextField();
        panNumField.setBounds(230, 405,320,30);
        panNumField.setFont(new Font("Arial", Font.BOLD, 16));
        add(panNumField);










        JLabel aadharNum = new JLabel("Aadhar Number :");
        aadharNum.setBounds(55, 450, 220, 45);
        aadharNum.setFont(new Font("Arial", Font.BOLD, 20));
        add(aadharNum);

        aadharNumField = new JTextField();
        aadharNumField.setBounds(230, 460,320,30);
        aadharNumField.setFont(new Font("Arial", Font.BOLD, 16));
        add(aadharNumField);








        JLabel seniorCitizen = new JLabel("Senior Citizen :");
        seniorCitizen.setBounds(55, 505, 150, 45);
        seniorCitizen.setFont(new Font("Arial", Font.BOLD, 20));
        add(seniorCitizen);

        seniorCitizenRadioButtonYes = new JRadioButton("Yes ");
        seniorCitizenRadioButtonYes.setBounds(240,505,130,45);
        seniorCitizenRadioButtonYes.setBackground(Color.WHITE);
        seniorCitizenRadioButtonYes.setForeground(Color.BLACK);
        add(seniorCitizenRadioButtonYes);

        seniorCitizenRadioButtonNo = new JRadioButton("No  ");
        seniorCitizenRadioButtonNo.setBounds(350,505,130,45);
        seniorCitizenRadioButtonNo.setBackground(Color.WHITE);
        seniorCitizenRadioButtonNo.setForeground(Color.BLACK);
        add(seniorCitizenRadioButtonNo);

        //Group These Both Buttons (Senior Citizen Button)
        ButtonGroup seniorCitizenRadioButtonGroup = new ButtonGroup();
        seniorCitizenRadioButtonGroup.add(seniorCitizenRadioButtonYes);
        seniorCitizenRadioButtonGroup.add(seniorCitizenRadioButtonNo);












        JLabel existingAcc = new JLabel("Existing Account :");
        existingAcc.setBounds(55, 560, 220, 45);
        existingAcc.setFont(new Font("Arial", Font.BOLD, 20));
        add(existingAcc);

        existingAccountButtonYes = new JRadioButton("Yes ");
        existingAccountButtonYes.setBounds(240,560,130,45);
        existingAccountButtonYes.setBackground(Color.WHITE);
        existingAccountButtonYes.setForeground(Color.BLACK);
        add(existingAccountButtonYes);

        existingAccountButtonNo = new JRadioButton("No  ");
        existingAccountButtonNo.setBounds(350,560,130,45);
        existingAccountButtonNo.setBackground(Color.WHITE);
        existingAccountButtonNo.setForeground(Color.BLACK);
        add(existingAccountButtonNo);

        //Group These Both Buttons (Senior Citizen Button)
        ButtonGroup existingAccountButtonGroup = new ButtonGroup();
        existingAccountButtonGroup.add(existingAccountButtonYes);
        existingAccountButtonGroup.add(existingAccountButtonNo);









        // Final Button End of Page
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(275, 650, 120,45);
        next.setFont(new Font("Raleway", Font.BOLD, 20));
        next.addActionListener(this);
        add(next);






        setSize(650, 750);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
        setLocation(450,20);




    }

    public void actionPerformed(ActionEvent ae){
        //DropDown Menu Access
        String religionAccess = (String) religionMenu.getSelectedItem();// agar yaha per string nahi hoga to ye isko ek object ki tarah leta hai isliye typeCast String dena padta hai
        String categoryAccess = (String) categoryMenu.getSelectedItem();
        String incomeAccess = (String) incomeMenu.getSelectedItem();
        String educationAccess = (String) educationMenu.getSelectedItem();
        String occupationAccess = (String) occupationMenu.getSelectedItem();


        //Text Field Access
        String panNumAccess = ""+panNumField.getText();// for convert to an String  [ Plus(+) Symbol is concat the both ]
        String aadharNumAccess = ""+aadharNumField.getText();


        // todo:: Radio Button Access
        // Existing Buttons
        String existingAccountAccess = null;
        if(existingAccountButtonYes.isSelected()){
            existingAccountAccess = "Yes";
        }else {
            existingAccountAccess = "No";
        }

        // Senior Citizen Buttons
        String seniorCitizenAccess = null;
        if(seniorCitizenRadioButtonYes.isSelected()){
            seniorCitizenAccess = "Yes";
        }else {
            seniorCitizenAccess = "No";
        }

        //manage Database
        try{
            if(religionAccess.isEmpty()){
                JOptionPane.showMessageDialog(null, "Religion Required !1");
            }else{
                DatabaseConnection DC = new DatabaseConnection();
                String queryTwo = "insert into signuptwo values('" + religionAccess + "', '" + categoryAccess + "', '" + incomeAccess + "', '" + occupationAccess + "', '" + aadharNumAccess + "', '" + panNumAccess + "', '" + educationAccess + "', '" + seniorCitizenAccess+  "','"+ existingAccountAccess +"')";
                DC.st.executeUpdate(queryTwo);
                JOptionPane.showMessageDialog(null, "Form submitted successfully!");

            }
        }catch(Exception err){
            err.printStackTrace();
        }


        // Next Button Clickable Functionality
        if(ae.getSource() == next){
            setVisible(false);
            new SignUpThree().setVisible(true);
        }

    }


    public static void main(String[] args){
        new SignUpTwo();
    }
}




