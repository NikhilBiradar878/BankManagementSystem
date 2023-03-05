package bankmanagementsystem;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
    
    JButton hundred, fivehundred, thousand, twohundred, fivethousand, tenthousand, back;
    String pinnumber;
    
    FastCash(String pinnumber){
        this.pinnumber = pinnumber;
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("Select Withdrawl Amount");
        text.setBounds(200,210, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);
        
        thousand = new JButton("₹ 1000");
        thousand.setBounds(130, 327, 150, 30);
        thousand.addActionListener(this);
        image.add(thousand);
        
        hundred = new JButton("₹ 100");
        hundred.setBounds(340, 327, 150, 30);
        hundred.addActionListener(this);
        image.add(hundred);
        
        fivethousand = new JButton("₹ 5000");
        fivethousand.setBounds(130, 362, 150, 30);
        fivethousand.addActionListener(this);
        image.add(fivethousand);
        
        twohundred = new JButton("₹ 200");
        twohundred.setBounds(340, 362, 150, 30);
        twohundred.addActionListener(this);
        image.add(twohundred);
        
        tenthousand = new JButton("₹ 10000");
        tenthousand.setBounds(130, 396, 150, 30);
        tenthousand.addActionListener(this);
        image.add(tenthousand);
        
        fivehundred = new JButton("₹ 500");
        fivehundred.setBounds(340, 396, 150, 30);
        fivehundred.addActionListener(this);
        image.add(fivehundred);
        
        back = new JButton("Back");
        back.setBounds(340, 430, 150, 30);
        back.addActionListener(this);
        image.add(back);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850, 720);
        setLocation(350, 10);
        setUndecorated(true);
        setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }else{
            String amount = ((JButton)ae.getSource()).getText().substring(2);
            Conn c = new Conn();
            
            try{
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(ae.getSource() != back && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                Date date = new Date();
                String query = "insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs " + amount + " Debited Successfully");
                
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
                
            }catch(Exception e){
                System.out.print(e);
            }
        } 
    }
    
    public static void main(String[] args) {
     new FastCash("");
     
    }
}