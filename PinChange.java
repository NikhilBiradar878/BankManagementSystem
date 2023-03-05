package bankmanagementsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener{
    
    JPasswordField pin, repin;
    JButton change, back;
    String pinnumber;
    
    PinChange(String pinnumber){
        this.pinnumber = pinnumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("Change your PIN ");
        text.setBounds(240,190, 500, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);
        
        JLabel pintext = new JLabel("New PIN : ");
        pintext.setBounds(150,250, 180, 25);
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System", Font.BOLD, 16));
        image.add(pintext);
        
        pin = new JPasswordField();
        pin.setFont(new Font("Raleway", Font.BOLD,14));
        pin.setBounds(310,250,150,25);
        image.add(pin);
        
        JLabel repintext = new JLabel("Re-Enter New PIN : ");
        repintext.setBounds(150,290, 180, 25);
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System", Font.BOLD, 16));
        image.add(repintext);
        
        repin = new JPasswordField();
        repin.setFont(new Font("Raleway", Font.BOLD,14));
        repin.setBounds(310,290,150,25);
        image.add(repin);
        
        change = new JButton("CHANGE");
        change.setBounds(330,375, 130, 30);
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton("BACK");
        back.setBounds(330,410, 130, 30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(850, 720);
        setLocation(350, 10);
        setUndecorated(true);
        setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == change){
            
        try{
            String npin = pin.getText();
            String rpin = repin.getText();
            
            if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return;  
            }
        
            if(npin.equals("")){
                JOptionPane.showMessageDialog(null, "Please Enter new PIN ");
                return;
            }
            if(rpin.equals("")){
                JOptionPane.showMessageDialog(null, "Please re-Enter new PIN ");
                return;
            }
            
            Conn conn = new Conn();
            String query1 = "update bank set pin =  '"+rpin+"' where pin='"+pinnumber+"'";
            String query2 = "update login set pin =  '"+rpin+"' where pin='"+pinnumber+"'";
            String query3 = "update signupThree set pin =  '"+rpin+"' where pin='"+pinnumber+"'";
            
            conn.s.executeUpdate(query1);
            conn.s.executeUpdate(query2);
            conn.s.executeUpdate(query3);
            
            JOptionPane.showMessageDialog(null, "PIN Changed Successfully.");
            
            setVisible(false);
            new Transactions(rpin).setVisible(true);
            
        }catch(Exception e){
            System.out.println(e);
            }
        }else {
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
                }
        }
    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }
    
}
