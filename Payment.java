

package airline.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import java.awt.EventQueue;

public class Payment extends JFrame {
     JTextField textField,textField_1,textField_2,textField_3,textField_4,textField_5,textField_6,textField_7,textField_8,textField_9,textField_10,textField_11,textField_12,textField_13;
     JComboBox source, destination,classnm,flight_name;
    public static void main(String[] args) {
        new Payment();
    }

    public Payment(){
	initialize();
    }

    private void initialize(){


    getContentPane().setForeground(Color.BLUE);
            getContentPane().setBackground(Color.WHITE);
            setTitle("GIVE PAYMENT INFO");
            
             setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            setSize(778,486);
            getContentPane().setLayout(null);

	JLabel FlightDetails = new JLabel("PAYMENT INFO");
	FlightDetails.setFont(new Font("Tahoma", Font.PLAIN, 36));
	FlightDetails.setForeground(new Color(100, 149, 237));
	FlightDetails.setBounds(300, 20, 570, 35);
	add(FlightDetails);
                
//            JLabel pnr_no = new JLabel("PASSENGER NO");
//            pnr_no.setFont(new Font("Tahoma", Font.PLAIN, 17));
//            pnr_no.setBounds(60, 80, 150, 27);
//            add(pnr_no);
//            
//            textField = new JTextField();
//            textField.setBounds(200, 80, 150, 27);
//            add(textField);
//            
//            JLabel name = new JLabel("NAME");
//            name.setFont(new Font("Tahoma", Font.PLAIN, 17));
//            name.setBounds(60, 120, 150, 27);
//            add(name);
//            
//            textField_1 = new JTextField();
//            textField_1.setBounds(200, 120, 150, 27);
//            add(textField_1);
//
//            JLabel phone = new JLabel("PHONE");
//            phone.setFont(new Font("Tahoma", Font.PLAIN, 17));
//            phone.setBounds(60, 160, 150, 27);
//            add(phone);
//            
//            textField_2 = new JTextField();
//            textField_2.setBounds(200, 160, 150, 27);
//            add(textField_2);
//
//            JLabel f_code = new JLabel("FLIGHT CODE");
//            f_code.setFont(new Font("Tahoma", Font.PLAIN, 17));
//            f_code.setBounds(60, 200, 150, 27);
//            add(f_code);
//            
//            textField_3 = new JTextField();
//            textField_3.setBounds(200, 200, 150, 27);
//            add(textField_3);
//
            
            JLabel ticket_id = new JLabel("TICKET ID");
            ticket_id.setFont(new Font("Tahoma", Font.PLAIN, 17));
            ticket_id.setBounds(60, 80, 150, 27);
            add(ticket_id);

            textField_4 = new JTextField();
            textField_4.setBounds(200, 80, 150, 27);
            add(textField_4);
            

            JLabel jny_date = new JLabel("JOURNEY DATE");
            jny_date.setFont(new Font("Tahoma", Font.PLAIN, 17));
            jny_date.setBounds(60, 120, 150, 27);
            add(jny_date);
            
            textField_5 = new JTextField();
            textField_5.setBounds(200, 120, 150, 27);
            add(textField_5);

            JLabel jny_time = new JLabel("JOURNEY TIME");
            jny_time.setFont(new Font("Tahoma", Font.PLAIN, 17));
            jny_time.setBounds(60, 160, 150, 27);
            add(jny_time);
            
            textField_6 = new JTextField();
            textField_6.setBounds(200, 160, 150, 27);
            add(textField_6);

            JLabel src = new JLabel("SOURCE");
            src.setFont(new Font("Tahoma", Font.PLAIN, 17));
            src.setBounds(60, 200, 150, 27);
            add(src);
            

              String f_add[] = {"DHAKA","QUTAR","JAPAN","DUBAI","INDIA"};
              source = new JComboBox(f_add);
              source.setBounds(200, 200, 150, 27);
              add(source);
 


            JLabel dst = new JLabel("DESTINATION");
            dst.setFont(new Font("Tahoma", Font.PLAIN, 17));
            dst.setBounds(60, 240, 150, 27);
            add(dst);
            
            destination = new JComboBox(f_add);
            destination.setBounds(200, 240, 150, 27);
            add(destination);

            JLabel seat_id = new JLabel("SEAT ID");
            seat_id.setFont(new Font("Tahoma", Font.PLAIN, 17));
            seat_id.setBounds(440, 80, 150, 27);
            add(seat_id);
            
            textField_9 = new JTextField();
            textField_9.setBounds(580, 80, 150, 27);
            add(textField_9);

//Again text and text field

            JLabel card_no = new JLabel("CARD NO");
            card_no.setFont(new Font("Tahoma", Font.PLAIN, 17));
            card_no.setBounds(440, 120, 150, 27);
            add(card_no);
            
            textField_10 = new JTextField();
            textField_10.setBounds(580, 120, 150, 27);
            add(textField_10);
//          Button
            JButton Next_2 = new JButton("CONFIRM PAYMENT");
            Next_2.setBounds(400, 460, 150, 30);
            Next_2.setBackground(Color.BLACK);
            Next_2.setForeground(Color.WHITE);
            add(Next_2);


//padi amo
            JLabel paid_amt = new JLabel("PAID AMOUNT");
            paid_amt.setFont(new Font("Tahoma", Font.PLAIN, 17));
            paid_amt.setBounds(440, 160, 150, 27);
            add(paid_amt);
            
            textField_11 = new JTextField();
            textField_11.setBounds(580, 160, 150, 27);
            add(textField_11);
//paydate
            JLabel pay_date = new JLabel("PAY DATE");
            pay_date.setFont(new Font("Tahoma", Font.PLAIN, 17));
            pay_date.setBounds(440, 200, 150, 27);
            add(pay_date);
            
            textField_12 = new JTextField();
            textField_12.setBounds(580, 200, 150, 27);
            add(textField_12);

            JLabel class_name = new JLabel("CLASS NAME");
            class_name.setFont(new Font("Tahoma", Font.PLAIN, 17));
            class_name.setBounds(440, 240, 150, 27);
            add(class_name);

             String class_add[] = {"BUSINESS","ECONOMY"};
              classnm = new JComboBox(class_add);
              classnm.setBounds(580, 240, 150, 27);
              add(classnm);


            JLabel flight_model = new JLabel("FLIGHT MODEL");
            flight_model.setFont(new Font("Tahoma", Font.PLAIN, 17));
            flight_model.setBounds(440, 280, 150, 27);
            add(flight_model);

             String flightName[] = {"Boeing 787","Airbus a380","Embraer 175","Beoing 735","Airbus a320"};
              flight_name = new JComboBox(flightName);
              flight_name.setBounds(580, 280, 150, 27);
              add(flight_name);


// action listeners
        textField_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
	
                String uniID = Add_Customer.timeAndDate;    
//                        System.out.print(uniID);
                       textField_4.setText(uniID);
                    
                }
            }
        );

 Next_2.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
//                    String pnr_no = textField.getText();
//                    String name = textField_1.getText();
//                    String phone =  textField_2.getText();
//                    String f_code = textField_3.getText();
                       

                    String ticket_id = textField_4.getText();
                    String jny_date = textField_5.getText();
                    String jny_time = textField_6.getText();

                    String src  = (String) source.getSelectedItem();

                    String dst  = (String) destination.getSelectedItem();
                    String seat_id  = textField_9.getText();
                    String card_no  = textField_10.getText();
                    String paid_amt  = textField_11.getText();
                    String pay_date  = textField_12.getText();
                    String pnr_no = Add_Customer.pnr_no;
                    String name = Add_Customer.name;
                    String f_code = Add_Customer.fl_code;
                    String ph_no = Add_Customer.ph_no;
                    String class_name = (String) classnm.getSelectedItem();
                    String flight_model = (String) flight_name.getSelectedItem();
                    try {
                        conn c = new conn();
                        String str = "INSERT INTO payment values( '"+pnr_no+"', '"+name+"', '"+f_code+"','"+ticket_id+"', '"+paid_amt+"', '"+card_no+"','"+pay_date+"', '"+src+"','"+dst+"','"+jny_date+"','"+jny_time+"','"+seat_id+"','"+class_name+"','"+flight_model+"')";
                        String str1 = "update flight set sold=sold+1 where f_code='"+f_code+"' and class_name='"+class_name+"' and src = '"+src+"' and dst = '"+dst+"' and flight_model='"+flight_model+"'";
                        c.s.executeUpdate(str);
                        c.s.executeUpdate(str1);
                        JOptionPane.showMessageDialog(null,"Payment Done"); //pop up
                        setVisible(false);
                    
                    } catch (Exception e) {
                        e.printStackTrace();
        	    }
		}
            });




	setSize(960,590);
        setLocation(100,40);
	setVisible(true);

    }
}
