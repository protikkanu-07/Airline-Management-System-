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
import java.io.IOException; 
import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import java.awt.print.PrinterJob;
import java.awt.print.PageFormat;
import java.awt.print.Book;
import java.awt.print.*;
import java.awt.print.PrinterJob;
import javax.print.PrintService;
//import org.apache.fontbox.afm.AFMParser;


public class TicketGenerate extends JFrame{
            private JTextField textField;
            String name,f_code,ticket_id,pay_date, src, dst, jny_date, jny_time, seat_id, class_name, flight_model;
        public TicketGenerate(){
            getContentPane().setForeground(Color.BLUE);
            getContentPane().setBackground(Color.WHITE);
            setTitle("GENERATE TICKET");
            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            getContentPane().setLayout(null);
            setBounds(100, 100, 801, 472);
            setLayout(null);

            JLabel Ticket = new JLabel("TICKET");
            Ticket.setFont(new Font("Tahoma", Font.PLAIN, 31));
            Ticket.setBounds(185, 24, 259, 38);
            add(Ticket);
            
           ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/ticket.png"));
           Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
           ImageIcon i3 = new ImageIcon(i2);
           JLabel NewLabel = new JLabel(i3);
           NewLabel.setBounds(470, 100, 250, 250);
           add(NewLabel);




            JLabel PassengerNo = new JLabel("PASSENGER NO:");
            PassengerNo.setFont(new Font("Tahoma", Font.PLAIN, 17));
            PassengerNo.setBounds(60, 180, 132, 26);
            add(PassengerNo);
            

            textField = new JTextField();
            textField.setBounds(250, 180, 150, 27);
            add(textField);

            JButton GTicket = new JButton("GENERATE TICKET");
            GTicket.setFont(new Font("Tahoma", Font.PLAIN, 14));
            GTicket.setBackground(Color.BLACK);
            GTicket.setForeground(Color.WHITE);
            GTicket.setBounds(250, 350, 150, 30);
            add(GTicket);



        GTicket.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                String pnr_no = textField.getText();

					
		try{	
                    conn c = new conn();
                    
                    String str = "select * from payment where pnr_no ='"+pnr_no+"'";
                    ResultSet rs = c.s.executeQuery(str);


















                    while (rs.next())
                         {
                    f_code = rs.getString("f_code");
                    src = rs.getString("src");
                    dst = rs.getString("dst");
                    flight_model = rs.getString("flight_model");
                    class_name = rs.getString("class_name");
                    name = rs.getString("name");
                    ticket_id = rs.getString("ticket_id");
                    jny_date = rs.getString("jny_date");
                    jny_time= rs.getString("jny_time");
                    seat_id = rs.getString("seat_id");

      }






         String fileName = "F:/Invoice/"+ticket_id+".pdf"; 
        
        PDDocument doc = new PDDocument();
        PDPage page = new PDPage();

        doc.addPage(page);

        PDPageContentStream content = new PDPageContentStream(doc, page);
        
        content.beginText();
        content.setFont(PDType1Font.HELVETICA, 24);
        content.moveTextPositionByAmount(180, 750);
        content.drawString("Biman Bangladesh Airline");
        content.endText();
        
        
        content.beginText();
        content.setFont(PDType1Font.HELVETICA, 16);
        content.moveTextPositionByAmount(80, 670);
        content.drawString("Name : "+name+"");
        content.endText();
        
        
        content.beginText();
        content.setFont(PDType1Font.HELVETICA, 16);
        content.moveTextPositionByAmount(80,640);
        content.drawString("Journey Date : "+jny_date+"");
        content.endText();
        
        content.beginText();
        content.moveTextPositionByAmount(80,610);
        content.drawString("Journey Time : "+jny_time+"PM");
        content.endText();
        
        content.beginText();
        content.moveTextPositionByAmount(350,670);
        content.drawString("Flight Code: "+f_code+"");
        content.endText();
        
        content.beginText();
        content.moveTextPositionByAmount(350,640);
        content.drawString("Flight Model: "+flight_model+"");
        content.endText();

        content.beginText();
        content.moveTextPositionByAmount(350,610);
        content.drawString("Ticket ID: "+ticket_id+"");
        content.endText();

        content.beginText();
        content.moveTextPositionByAmount(80,500);
        content.drawString(""+src+"");
        content.endText();

        content.beginText();
        content.moveTextPositionByAmount(200,500);
        content.drawString(""+dst+"");
        content.endText();

        content.beginText();
        content.moveTextPositionByAmount(340,500);
        content.drawString(""+seat_id+"");
        content.endText();

        content.beginText();
        content.moveTextPositionByAmount(460,500);
        content.drawString(""+class_name+"");
        content.endText();


        content.beginText();
        content.moveTextPositionByAmount(80,550);
        content.drawString("Source");
        content.endText();

        content.beginText();
        content.moveTextPositionByAmount(200,550);
        content.drawString("Destination");
        content.endText();

        content.beginText();
        content.moveTextPositionByAmount(340,550);
        content.drawString("Seat ID");
        content.endText();

        content.beginText();
        content.moveTextPositionByAmount(460,550);
        content.drawString("Class Name");
        content.endText();


        content.beginText();
        content.moveTextPositionByAmount(80,580);
        content.drawString("------------------------------------------------------------------------------------------");
        content.endText();







        content.close();
        doc.save(fileName);
        doc.close();



                    JOptionPane.showMessageDialog(null,"You Ticket has generated. Please check your folder!");
                    setVisible(false);
						
		}catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        });











            setSize(900,600);
            setVisible(true);
            setLocation(100,40);
            }



         public static void main(String[] args) {
         new TicketGenerate();
    }

}
