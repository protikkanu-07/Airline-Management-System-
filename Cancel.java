

package airline.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;

public class Cancel extends JFrame { //Sixth
    
    private JTextField textField,textField_1,textField_2,textField_3,textField_4;
    String f_code = new String();
    String src = new String();
    String dst = new String();
    String fli_model = new String();
    String class_name = new String();
    String pnr_no = new String();
    String todayDate = new String();
    public static void main(String[] args) {
        new Cancel();
    }

    public Cancel() {
        initialize();
    }
    
    private void initialize() {
        setTitle("CANCELLATION");
	getContentPane().setBackground(Color.WHITE);
	setBounds(100, 100, 801, 472);
	setLayout(null);
		
	JLabel Cancellation = new JLabel("CANCELLATION");
	Cancellation.setFont(new Font("Tahoma", Font.PLAIN, 31));
	Cancellation.setBounds(185, 24, 259, 38);
	add(Cancellation);
		
	
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/cancelled.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel NewLabel = new JLabel(i3);
	NewLabel.setBounds(470, 100, 250, 250);
	add(NewLabel);
		
	JLabel PassengerNo = new JLabel("TICKET NO");
	PassengerNo.setFont(new Font("Tahoma", Font.PLAIN, 17));
	PassengerNo.setBounds(60, 180, 132, 26);
	add(PassengerNo);
		
	
	textField = new JTextField();
	textField.setBounds(250, 180, 150, 27);
	add(textField);
	
	JButton Cancel = new JButton("CANCEL");
	Cancel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        Cancel.setBackground(Color.BLACK);
        Cancel.setForeground(Color.WHITE);
	Cancel.setBounds(250, 350, 150, 30);
	add(Cancel);
	
        Cancel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
		
                String ticket_no = textField.getText();
					
					
		try{	
                    conn c = new conn();
                    
                    String str = "select pnr_no, f_code,src,dst,flight_model,class_name from payment where ticket_id = '"+ticket_no+"'";
                    ResultSet rs = c.s.executeQuery(str);

                 DateTimeFormatter myDate = DateTimeFormatter.ofPattern("yyyy:MM:dd");  
                 LocalDateTime maybeNow = LocalDateTime.now(); 
                    todayDate = myDate.format(maybeNow);
                    
                    while (rs.next())
                         {
                f_code = rs.getString("f_code");
                src = rs.getString("src");
                dst = rs.getString("dst");
                fli_model = rs.getString("flight_model");
                class_name = rs.getString("class_name");
                pnr_no = rs.getString("pnr_no");

//                System.out.print(f_code+" "+ src+" "+dst+" "+flight_model+" "+class_name);

      }
            String str1 = "INSERT INTO cancellation values('"+pnr_no+"', '"+todayDate+"','"+ticket_no+"', '"+f_code+"', '"+src+"', '"+dst+"','"+fli_model+"','"+class_name+"')";
             c.s.executeUpdate(str1);
            String str2 = "update flight set sold=sold-1 where f_code='"+f_code+"' and class_name='"+class_name+"' and src = '"+src+"' and dst = '"+dst+"' and flight_model='"+fli_model+"'";
            c.s.executeUpdate(str2);
            String str3 = "delete from passenger where pnr_no = '"+pnr_no+"'";
            String str4 = "delete from payment where ticket_id = '"+ticket_no+"'";
            c.s.executeUpdate(str3);
            c.s.executeUpdate(str4);

                    JOptionPane.showMessageDialog(null,"Ticket Cancelled and Refunding in Process!");
                    setVisible(false);
						
		}catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
			
	setSize(860,500);
	setVisible(true);
        setLocation(100,40);
    }
}
