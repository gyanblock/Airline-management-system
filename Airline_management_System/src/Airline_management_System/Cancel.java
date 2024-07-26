package Airline_management_System;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Cancel extends JFrame implements ActionListener {
	JLabel lblname,cancel,fcc,dt,back;
	JTextField pnr;
	JButton showdetails,cancelb;
	public Cancel() {
		 setTitle("Cancel Ticket ");
         

	        getContentPane().setBackground(Color.white);
	        // Using BorderLayout instead of null layout
	        Random random=new Random();
	        setLayout(null);
	        setSize(800,600);
			setLocation(400,150);
	        setVisible(true);
	        
	        JLabel heading=new JLabel("CANCELLATION");
			heading.setBounds(320, 20, 500, 35);
			
			heading.setFont(new Font("tahoma",Font.PLAIN,32));
			add(heading);
			
			JLabel lblpnr=new JLabel("PNR ");
			lblpnr.setBounds(60, 90, 150, 25);
			lblpnr.setFont(new Font("tahoma",Font.PLAIN,16));
			add(lblpnr);
			
			pnr=new JTextField();
			pnr.setBounds(220,90,200,25);
			add(pnr);
			
			showdetails=new JButton("Show Details");
			showdetails.setBackground(Color.black);
			showdetails.setForeground(Color.white);
			showdetails.addActionListener(this);
			showdetails.setBounds(430, 90, 150, 25);
			add(showdetails);
			
			lblname=new JLabel("Name");
			lblname.setBounds(60, 130, 150, 25);
			lblname.setFont(new Font("tahoma",Font.PLAIN,16));
			add(lblname);
			
			
			
			lblname=new JLabel("");
			lblname.setBounds(220,130,200,25);
			add(lblname);
			
			cancel=new JLabel("cancellation no");
			cancel.setBounds(60, 180, 150, 25);
			cancel.setFont(new Font("tahoma",Font.PLAIN,16));
			add(cancel);
			
			cancel=new JLabel(""+random.nextInt(1000000));
			cancel.setBounds(220,180,200,25);
			add(cancel);
			
			
			fcc=new JLabel("Flight Code");
			fcc.setBounds(60, 250, 150, 25);
			fcc.setFont(new Font("tahoma",Font.PLAIN,16));
			add(fcc);
			
			fcc=new JLabel();
			fcc.setBounds(220,250,200,25);
			add(fcc);
			
			dt=new JLabel("Date");
			dt.setBounds(60, 310, 150, 25);
			dt.setFont(new Font("tahoma",Font.PLAIN,16));
			add(dt);
			
			dt=new JLabel("");
			dt.setBounds(220, 310, 150, 25);
			add(dt);
			
			cancelb=new JButton("Cancel");
			cancelb.setBackground(Color.black);
			cancelb.setForeground(Color.white);
			cancelb.addActionListener(this);
			cancelb.setBounds(220, 350, 150, 25);
			add(cancelb);
			
			back=new JLabel("image");
			ImageIcon icon = new ImageIcon(getClass().getResource("/Airline_management_System/images/icons/cancel.jpg"));
			Image image = icon.getImage().getScaledInstance(300, 320, Image.SCALE_DEFAULT);
			back.setBounds(550, 50, 300, 410);
			back.setIcon(new ImageIcon(image));
			add(back);
			
			
			
	}
	
	 public void actionPerformed(ActionEvent ae) {
		 if(ae.getSource()==showdetails) {
				
				String pnrr=pnr.getText();
				
				
				try {
					conn c=new conn();
					String query="select * from reservation where PNR='"+pnrr+"'";
					ResultSet rs=c.s.executeQuery(query);
					if(rs.next()) {
						lblname.setText(rs.getString("name"));
						
						fcc.setText(rs.getString("fc"));
						dt.setText(rs.getString("date"));
					}else {
					JOptionPane.showMessageDialog(null, "Please Enter Your Correct PNR");
					}
			
			}catch(Exception e) {
				e.printStackTrace();
			}
				
	 
	 }else 
		 if(ae.getSource()==cancelb) {
				
				String pnrr=pnr.getText();
				String name=lblname.getText();
				String can=cancel.getText();
				String fc=fcc.getText();
				String dtt=dt.getText();
				
				try {
					conn c=new conn();
					String query="insert into cancel values('"+pnrr+"','"+name+"','"+can+"','"+fc+"','"+dtt+"')";
					c.s.executeUpdate(query);
					c.s.executeUpdate("delete from reservation where PNR='"+pnrr+"'");
				
				
					
					JOptionPane.showMessageDialog(null, "Ticket Cancelled");
					
		 
			}catch(Exception e) {
				e.printStackTrace();
				
			}

		 }
}

	 





	 
			

public static void main (String [] args) {
	new Cancel();
}
}


