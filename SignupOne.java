package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;


public class SignupOne extends JFrame implements ActionListener {
    
    long random;
    JTextField nameTextField, fnameTextField, emailTextField, addressTextField, cityTextField, stateTextField, pinTextField;
    JButton next;
    JRadioButton male, female, other, married, unmarried;
    JDateChooser dateChooser;
    
    SignupOne(){
        
        setLayout(null);
        
        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);
       
        
        JLabel formno = new JLabel("APPLICATION FORM NO.  " + random);
        formno.setFont(new Font("Raleway", Font.BOLD, 28));
        formno.setBounds(140, 20, 600, 40);
        add(formno);
        
        JLabel personalDetails = new JLabel("Page 1 : Personal Details");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 20));
        personalDetails.setBounds(250, 80, 400, 30);
        add(personalDetails);
        
        JLabel name = new JLabel("Name : ");
        name.setFont(new Font("Raleway", Font.BOLD, 17));
        name.setBounds(100, 140, 100, 30);
        add(name);
        
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD,14));
        nameTextField.setBounds(280,140,320,25);
        add(nameTextField);
        
        JLabel fname = new JLabel("Father's Name : ");
        fname.setFont(new Font("Raleway", Font.BOLD, 17));
        fname.setBounds(100, 180, 200, 30);
        add(fname);
        
        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway", Font.BOLD,14));
        fnameTextField.setBounds(280,180,320,25);
        add(fnameTextField);
        
        JLabel dob = new JLabel("Date of Birth : ");
        dob.setFont(new Font("Raleway", Font.BOLD, 16));
        dob.setBounds(100,220, 200, 30);
        add(dob);
        
        dateChooser = new JDateChooser();
        dateChooser.setBounds(280, 220, 320, 30);
        dateChooser.setForeground(new Color(105, 105, 105));
        add(dateChooser);
        
        JLabel gender = new JLabel("Gender : ");
        gender.setFont(new Font("Raleway", Font.BOLD, 16));
        gender.setBounds(100,260, 200, 30);
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(280, 260, 60, 30);
        male.setBackground(Color.WHITE);
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(400, 260, 120, 30);
        female.setBackground(Color.WHITE);
        add(female);
        
        other = new JRadioButton("Other");
        other.setBounds(530, 260, 120, 30);
        other.setBackground(Color.WHITE);
        add(other);
        
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        gendergroup.add(other);
        
        JLabel email = new JLabel("Email Address : ");
        email.setFont(new Font("Raleway", Font.BOLD, 16));
        email.setBounds(100,300, 200, 30);
        add(email);
        
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD,14));
        emailTextField.setBounds(280,300,320,25);
        add(emailTextField);
         
        JLabel marital = new JLabel("Marital Status : ");
        marital.setFont(new Font("Raleway", Font.BOLD, 16));
        marital.setBounds(100,340, 200, 30);
        add(marital);
        
        married = new JRadioButton("Married");
        married.setBounds(280, 340, 120, 30);
        married.setBackground(Color.WHITE);
        add(married);
        
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(400, 340, 100, 30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        
        other = new JRadioButton("Other");
        other.setBounds(530, 340, 100, 30);
        other.setBackground(Color.WHITE);
        add(other);
        
        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        maritalgroup.add(other);
        
        JLabel address = new JLabel("Address : ");
        address.setFont(new Font("Raleway", Font.BOLD, 16));
        address.setBounds(100,380, 200, 30);
        add(address);
        
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway", Font.BOLD,14));
        addressTextField.setBounds(280,380,320,25);
        add(addressTextField);
        
        JLabel city = new JLabel("City : ");
        city.setFont(new Font("Raleway", Font.BOLD, 16));
        city.setBounds(100,420, 200, 30);
        add(city);
        
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD,14));
        cityTextField.setBounds(280,420,320,25);
        add(cityTextField);
        
        JLabel state = new JLabel("State : ");
        state.setFont(new Font("Raleway", Font.BOLD, 16));
        state.setBounds(100,460, 200, 30);
        add(state);
        
        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway", Font.BOLD,14));
        stateTextField.setBounds(280,460,320,25);
        add(stateTextField);
        
        JLabel pin = new JLabel("Pin Code : ");
        pin.setFont(new Font("Raleway", Font.BOLD, 16));
        pin.setBounds(100,500, 200, 30);
        add(pin);
        
        pinTextField = new JTextField();
        pinTextField.setFont(new Font("Raleway", Font.BOLD,14));
        pinTextField.setBounds(280,500,320,25);
        add(pinTextField);
        
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
        String formno = "" + random; 
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        }else if (female.isSelected()){
            gender = "Female";
        }
        
        String email = emailTextField.getText();
        String marital = null;
        if(married.isSelected()){
            marital = "Married";
        }else if(unmarried.isSelected()){
            marital = "Unmarried";
        }else if(other.isSelected()){
            marital = "Other";
        }
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state =stateTextField.getText();
        String pin = pinTextField.getText();
        
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is Required");
            }else if(fname.equals("")){
                JOptionPane.showMessageDialog(null, "Father's name is Required");
            }else if(dob.equals("")){
                JOptionPane.showMessageDialog(null, "Date of Birth is Required");
            }else if(email.equals("")){
                JOptionPane.showMessageDialog(null, "Email Address is Required");
            }else if(address.equals("")){
            JOptionPane.showMessageDialog(null, "Address is Required");
            }else if(city.equals("")){
                JOptionPane.showMessageDialog(null, "City is Required");
            }else if(state.equals("")){
                JOptionPane.showMessageDialog(null, "State is Required");
            }else if(pin.equals("")){
                JOptionPane.showMessageDialog(null, "pin Code is Required");
            }else{
                Conn c = new Conn();
                String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pin+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
        } catch(Exception e){
            System.out.println(e);
        }
        
    }
            
    public static void main(String[] args) {
        new SignupOne();
    }

    void setvisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

   