package Airline_management_System;

	import java.awt.Color;

	import java.awt.Font;
	import java.awt.event.ActionEvent;
	import javax.swing.*;
	import java.awt.event.ActionListener;

	
	

	public class Home extends JFrame implements ActionListener {
		
		public Home() {
			JLabel back;
			
			setLayout(null);
			//open a full screen frame
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			
			//insert image on frame
			back=new JLabel("image");
			back.setIcon(new ImageIcon(getClass().getResource("/Airline_management_System/images/icons/front.jpg")));
			back.setBounds(0,0,1600,800);
			add(back);
			
			setExtendedState(JFrame.MAXIMIZED_BOTH);
			setVisible(true);
			
			JLabel heading=new JLabel("AIR INDIA WELCOME TO YOU");
			heading.setBounds(500, 40, 1000, 40);
			heading.setForeground(Color.blue);
			heading.setFont(new Font("tahoma",Font.PLAIN,36));
			back.add(heading);
			
			JMenuBar menubar=new JMenuBar();
			setJMenuBar(menubar);
			
			
			
			JMenu details=new JMenu("Details");
			
			JMenuItem i1=new JMenuItem("Flight Details");
			i1.addActionListener(this);
			details.add(i1);
			menubar.add(details);
			
			JMenuItem i2=new JMenuItem("Add Customer Details");
			i2.addActionListener(this);
			details.add(i2);
			menubar.add(details);
			
			JMenuItem i3=new JMenuItem("Book Flight");
			i3.addActionListener(this);
			details.add(i3);
			menubar.add(details);
			
			JMenuItem i4=new JMenuItem("Journey Details");
			i4.addActionListener(this);
			details.add(i4);
			menubar.add(details);
			
			JMenuItem i5=new JMenuItem("Cancel Ticket");
			i5.addActionListener(this);
			details.add(i5);
			menubar.add(details);
			
			JMenu ticket=new JMenu("Ticket");
			
			JMenuItem i6=new JMenuItem("Boarding Pass");
			ticket.add(i6);
			menubar.add(ticket);
			
			setVisible(true);
			
		
			
			
			
//			
			}
			
		
		

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			
	            new Home();
		}

		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			String text=e.getActionCommand();	
			if(text.equals("Add Customer Details")){
				new Addcustomer();
				
			

	} else if  (text.equals("Flight Details")){
		new FlightInfo();
		
	}else if  (text.equals("Book Flight")){
		new Book_Flight();
		}else if  (text.equals("Journey Details")){
			new JourneyDetails();
	}
		else if  (text.equals("Cancel Ticket")){
			new Cancel();
	}
		}
	}
	
		
	
	



