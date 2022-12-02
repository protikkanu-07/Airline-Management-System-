
package airline.management.system;

import java.awt.EventQueue;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;  
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.net.*;
import java.awt.event.FocusAdapter;

public class Add_Customer extends JFrame{ //Third Frame

        static String pnr_no= new String();
        static String name= new String();
        static String fl_code= new String();
        static String ph_no = new String();
        static String timeAndDate = new String();
	JTextField textField,textField_1,textField_2,textField_3,textField_4,textField_5,textField_6;
        JComboBox c1;

        public Add_Customer(){                    
                
            getContentPane().setForeground(Color.BLUE);
            getContentPane().setBackground(Color.WHITE);
            setTitle("ADD CUSTOMER DETAILS");
		 
            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            setSize(778,486);
            getContentPane().setLayout(null);
			
            JLabel Passportno = new JLabel("PASSPORT NO");
            Passportno.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Passportno.setBounds(60, 80, 150, 27);
            add(Passportno);
            
            textField = new JTextField();
            textField.setBounds(200, 80, 150, 27);
            add(textField);
			
            JButton Save = new JButton("SAVE");
            Save.setBounds(200, 420, 150, 30);
            Save.setBackground(Color.BLACK);
            Save.setForeground(Color.WHITE);
            add(Save);
			
            JLabel Pnrno = new JLabel("PNR NO");
            Pnrno.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Pnrno.setBounds(60, 120, 150, 27);
            add(Pnrno);
			
            textField_1 = new JTextField();
            textField_1.setBounds(200, 120, 150, 27);
            add(textField_1);
            
            JLabel Address = new JLabel("ADDRESS");
            Address.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Address.setBounds(60, 170, 150, 27);
            add(Address);
			
            textField_2 = new JTextField();
            textField_2.setBounds(200, 170, 150, 27);
            add(textField_2);
            		
            JLabel Nationality = new JLabel("NATIONALITY");
            Nationality.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Nationality.setBounds(60, 220, 150, 27);
            add(Nationality);
			
            textField_3 = new JTextField();
            textField_3.setBounds(200, 220, 150, 27);
            add(textField_3);
	
            JLabel Name = new JLabel("NAME");
            Name.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Name.setBounds(60, 270, 150, 27);
            add(Name);
	
            textField_4 = new JTextField();
            textField_4.setBounds(200, 270, 150, 27);
            add(textField_4);
	
            JLabel Gender = new JLabel("GENDER");
            Gender.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Gender.setBounds(60, 320, 150, 27);
            add(Gender);
		
            JRadioButton NewRadioButton = new JRadioButton("MALE");
            NewRadioButton.setBackground(Color.WHITE);
            NewRadioButton.setBounds(200, 320, 70, 27);
            add(NewRadioButton);
	
            JRadioButton Female = new JRadioButton("FEMALE");
            Female.setBackground(Color.WHITE);
            Female.setBounds(280, 320, 70, 27);
            add(Female);
            
            JLabel Phno = new JLabel("PH NO");
            Phno.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Phno.setBounds(60, 370, 150, 27);
            add(Phno);
			
            textField_5 = new JTextField();
            textField_5.setBounds(200, 370, 150, 27);
            add(textField_5);
	
            setVisible(true);
	
            JLabel AddPassengers = new JLabel("ADD CUSTOMER DETAILS");
            AddPassengers.setForeground(Color.BLUE);
            AddPassengers.setFont(new Font("Tahoma", Font.PLAIN, 31));
            AddPassengers.setBounds(420, 24, 442, 35);
            add(AddPassengers);
			
            

            
            JLabel Flightcode = new JLabel("FLIGHT CODE");
            Flightcode.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Flightcode.setBounds(60, 30, 150, 27);
            add(Flightcode);

            String s1[] = {"BG001","BG002"};
            c1 = new JComboBox(s1);
            c1.setBounds(200, 30, 150, 27);
            add(c1);
            
            
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/emp.png"));
            JLabel image = new JLabel(i1);
            image.setBounds(450,80,280,410);
            add(image);
  //hjerer          
             textField_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
	
                String numberss = Mainframe.pass_number;   
                int i = Integer.parseInt(numberss);
                i = i+1;
                String passengerNumber = String.valueOf(i);  
//                        System.out.print(uniID);
                       textField_1.setText(passengerNumber);
                    
                }
            }
        );



            Save.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    String passport_No = textField.getText();
                    pnr_no = textField_1.getText();
                    String address =  textField_2.getText();
                    String nationality = textField_3.getText();
                    name = textField_4.getText();
                    fl_code  = (String) c1.getSelectedItem();
                    String gender = null;
                    ph_no = textField_5.getText();
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");  
                 LocalDateTime now = LocalDateTime.now(); 
                 timeAndDate = pnr_no+"-"+dtf.format(now);
//                    System.out.println(timeAndDate); 

                      
                    if(NewRadioButton.isSelected()){
                        gender = "male";
                    
                    }else if(Female.isSelected()){
                        gender = "female";
                    }
                    
                    try {
                        conn c = new conn();
                        String str = "INSERT INTO passenger values( "+pnr_no+", '"+address+"', '"+nationality+"','"+name+"', '"+gender+"', '"+ph_no+"','"+passport_No+"', '"+fl_code+"')";
                        
                        c.s.executeUpdate(str);
                        JOptionPane.showMessageDialog(null,"Customer Added"); //pop up
                        setVisible(false);
                         new Payment();
                    
                    } catch (Exception e) {
                        e.printStackTrace();
        	    }
		}
            });
			
            setSize(900,600);
            setVisible(true);
            setLocation(100,40);
			
	}

    public static void main(String[] args){
 
        new Add_Customer();

    }   
}
