package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener {
   
    JTextField pan, aadhar;
    JButton next;
    JRadioButton syes, sno, eyes, eno;
    JComboBox religion, category, occupation, education, income;
    String formno;

    SignupTwo(String formno){
       this.formno = formno;
       setLayout(null);
        
       setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

       JLabel additionalDetails = new JLabel("Page 1 : Additional Details");
       additionalDetails.setFont(new Font("Raleway", Font.BOLD, 20));
       additionalDetails.setBounds(250, 80, 400, 30);
       add(additionalDetails);
       
       JLabel name = new JLabel("Religion : ");
       name.setFont(new Font("Raleway", Font.BOLD, 17));
       name.setBounds(100, 140, 100, 30);
       add(name);
       
       String valReligion[] = {"Select Religion","Hindu","Muslim","Sikh","Christian","Other"};
       religion = new JComboBox(valReligion);
       religion.setBounds(280,140,320,25);
       religion.setBackground(Color.WHITE);
       add(religion);
       
       JLabel fname = new JLabel("Category : ");
       fname.setFont(new Font("Raleway", Font.BOLD, 17));
       fname.setBounds(100, 180, 200, 30);
       add(fname);
        
       String valcategory[] = {"Select category","General","OBC","SC","ST","Other"};
       category = new JComboBox(valcategory);
       category.setBounds(280, 180, 320, 25);
       category.setBackground(Color.WHITE);
       add(category);
       
       JLabel dob = new JLabel("Income : ");
       dob.setFont(new Font("Raleway", Font.BOLD, 16));
       dob.setBounds(100,220, 200, 30);
       add(dob);
        
       String incomecategory[] = {"Select Income ","0","< 150000","< 250000","< 500000","> 1000000"};
       income = new JComboBox(incomecategory);
       income.setBounds(280, 220, 320, 25);
       income.setBackground(Color.WHITE);
       add(income);
       
       JLabel gender = new JLabel("Educational ");
       gender.setFont(new Font("Raleway", Font.BOLD, 16));
       gender.setBounds(100,260, 200, 30);
       add(gender);
        
       JLabel email = new JLabel("Qualification : ");
       email.setFont(new Font("Raleway", Font.BOLD, 16));
       email.setBounds(100,280, 200, 30);
       add(email);
       
       String educationValues[] = {"Select Education ","Non-Graduate","Graduate","Post Graduation","Doctorate","Other"};
       education = new JComboBox(educationValues);
       education.setBounds(280, 270, 320, 25);
       education.setBackground(Color.WHITE);
       add(education);
       
       JLabel marital = new JLabel("Occupation : ");
       marital.setFont(new Font("Raleway", Font.BOLD, 16));
       marital.setBounds(100,325, 200, 30);
       add(marital);
        
       String OccupationValues[] = {"Select Occupation", "Salaried ","Self-Employed","Business","Student","Retired","Other"};
       occupation = new JComboBox(OccupationValues);
       occupation.setBounds(280, 325, 320, 25);
       occupation.setBackground(Color.WHITE);
       add(occupation);
     
       JLabel address = new JLabel("PAN Number : ");
       address.setFont(new Font("Raleway", Font.BOLD, 16));
       address.setBounds(100,375, 200, 30);
       add(address);
        
       pan = new JTextField();
       pan.setFont(new Font("Raleway", Font.BOLD,14));
       pan.setBounds(280,380,320,25);
       add(pan);
      
       JLabel city = new JLabel("Aadhar Number : ");
       city.setFont(new Font("Raleway", Font.BOLD, 16));
       city.setBounds(100,420, 200, 30);
       add(city);
        
       aadhar = new JTextField();
       aadhar.setFont(new Font("Raleway", Font.BOLD,14));
       aadhar.setBounds(280,420,320,25);
       add(aadhar);
       
       JLabel state = new JLabel("Senior Citizen : ");
       state.setFont(new Font("Raleway", Font.BOLD, 16));
       state.setBounds(100,460, 200, 30);
       add(state);
        
       syes = new JRadioButton("Yes");
       syes.setBounds(280, 460, 60, 30);
       syes.setBackground(Color.WHITE);
       add(syes);
        
       sno = new JRadioButton("No");
       sno.setBounds(400, 460, 120, 30);
       sno.setBackground(Color.WHITE);
       add(sno);
      
       ButtonGroup gendergroup = new ButtonGroup();
       gendergroup.add(syes);
       gendergroup.add(sno);
  
       JLabel pincode = new JLabel("Existing Account : ");
       pincode.setFont(new Font("Raleway", Font.BOLD, 16));
       pincode.setBounds(100,500, 200, 30);
       add(pincode);
        
       eyes = new JRadioButton("Yes");
       eyes.setBounds(280, 500, 60, 30);
       eyes.setBackground(Color.WHITE);
       add(eyes);
        
       eno = new JRadioButton("No");
       eno.setBounds(400, 500, 120, 30);
       eno.setBackground(Color.WHITE);
       add(eno);
      
       ButtonGroup emarital = new ButtonGroup();
       emarital.add(eyes);
       emarital.add(eno);
       
       next = new JButton("Next");
       next.setBackground(Color.BLACK);
       next.setForeground(Color.WHITE);
       next.setFont(new Font("Raleway", Font.BOLD, 14));
       next.setBounds(530, 560, 70, 25);
       next.addActionListener(this);
       add(next);
        
       getContentPane().setBackground(Color.WHITE);
       
       setSize(850, 700);
       setLocation(350,10);
       setVisible(true);
    
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        
        String seniorcitizen = null;
        if(syes.isSelected()){
             seniorcitizen = "Yes";
        }else if(sno.isSelected()){
             seniorcitizen = "No";
        }
        
        String existingaccount = null;
        if(eyes.isSelected()){
            existingaccount = "Yes";
        }else if(eno.isSelected()){
            existingaccount = "No";
        }
        
        String span = pan.getText();
        String saadhar = aadhar.getText();
        
        try{
           Conn c = new Conn();
           String query1 = "insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+seniorcitizen+"','"+existingaccount+"')";
           c.s.executeUpdate(query1);
           
           setVisible(false);
           new SignupThree(formno).setVisible(true);
           
        } catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void main(String[] args) {
        new SignupTwo("");
     }
  }