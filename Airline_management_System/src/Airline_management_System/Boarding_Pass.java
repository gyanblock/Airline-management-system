package Airline_management_System;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Random;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Boarding_Pass extends JFrame implements ActionListener  {
	JLabel lblpnr,lblname,nation,sr,fn,dt,ds,fc,back;
	JTextField pnr;
	JButton ent;
	public Boarding_Pass() {
		getContentPane().setBackground(Color.white);
        // Using BorderLayout instead of null layout
      
        setLayout(null);
        setSize(1000,500);
		setLocation(300,150);
        setVisible(true);
        
        JLabel heading=new JLabel("AIR INDIA");
		heading.setBounds(380, 20, 450, 35);
		heading.setFont(new Font("tahoma",Font.PLAIN,32));
		add(heading);
		
		JLabel heading2=new JLabel("BOARDING PASS");
		heading2.setBounds(380, 70, 450, 35);
		heading2.setForeground(Color.BLUE);
		heading2.setFont(new Font("tahoma",Font.PLAIN,32));
		add(heading2);
		
		

		
		
		
		
		JLabel lblpnr=new JLabel("PNR DETAILS ");
		lblpnr.setBounds(60, 120, 150, 25);
		lblpnr.setFont(new Font("tahoma",Font.PLAIN,16));
		add(lblpnr);
		
		pnr=new JTextField();
		pnr.setBounds(220,120,200,25);
		add(pnr);
		
		ent=new JButton("Enter");
		ent.setBackground(Color.black);
		ent.setForeground(Color.white);
		ent.addActionListener(this);
		ent.setBounds(430, 120, 150, 25);
		add(ent);
		
		lblname=new JLabel("Name");
		lblname.setBounds(60, 160, 150, 25);
		lblname.setFont(new Font("tahoma",Font.PLAIN,16));
		add(lblname);
		
		
		
		lblname=new JLabel("");
		lblname.setBounds(220,160,200,25);
		add(lblname);
		
		
		
		nation=new JLabel("NATIONALITY");
		nation.setBounds(60, 210, 150, 25);
		nation.setFont(new Font("tahoma",Font.PLAIN,16));
		add(nation);
		
		
		
		nation=new JLabel("");
		nation.setBounds(220,210,200,25);
		add(nation);
		
		
		sr=new JLabel("SRC");
		sr.setBounds(60, 260, 150, 25);
		sr.setFont(new Font("tahoma",Font.PLAIN,16));
		add(sr);
		
		sr=new JLabel("");
		sr.setBounds(220,260,150,25);
		add(sr);
		
		ds=new JLabel("DEST");
		ds.setBounds(380, 260, 150, 25);
		ds.setFont(new Font("tahoma",Font.PLAIN,16));
		add(ds);
		
		ds=new JLabel("");
		ds.setBounds(500,260,150,25);
		add(ds);
		
		fn=new JLabel("FLIGHT NAME");
		fn.setBounds(60, 310, 150, 25);
		fn.setFont(new Font("tahoma",Font.PLAIN,16));
		add(fn);
		
		fn=new JLabel("");
		fn.setBounds(220, 310, 150, 25);
		add(fn);
		
		fc=new JLabel("FLIGHT CODE");
		fc.setBounds(380, 310, 150, 25);
		fc.setFont(new Font("tahoma",Font.PLAIN,16));
		add(fc);
		
		fc=new JLabel("");
		fc.setBounds(500, 310, 150, 25);
		add(fc);
		
		dt=new JLabel("DATE");
		dt.setBounds(60, 360, 150, 25);
		dt.setFont(new Font("tahoma",Font.PLAIN,16));
		add(dt);
		
		dt=new JLabel("");
		dt.setBounds(220, 360, 150, 25);
		add(dt);
		
		back=new JLabel("image");
		ImageIcon icon = new ImageIcon(getClass().getResource("/Airline_management_System/images/icons/airindia.png"));
		Image image = icon.getImage().getScaledInstance(300, 320, Image.SCALE_DEFAULT);
		back.setBounds(550, 50, 300, 410);
		back.setIcon(new ImageIcon(image));
		add(back);
		
		
	}
	public void actionPerformed(ActionEvent ae) {
		 if(ae.getSource()==ent) {
				
				String pnrr=pnr.getText();
				
				
				
				try {
					conn c=new conn();
					String query="select * from reservation where PNR='"+pnrr+"'";
					ResultSet rs=c.s.executeQuery(query);
					if(rs.next()) {
						lblname.setText(rs.getString("name"));
						nation.setText(rs.getString("nation"));
						sr.setText(rs.getString("source"));
						ds.setText(rs.getString("destination"));
						fn.setText(rs.getString("fn"));
						fc.setText(rs.getString("fc"));
						dt.setText(rs.getString("date"));
					}else {
					JOptionPane.showMessageDialog(null, "Please Enter Your Correct PNR");
					}
			
			}catch(Exception e) {
				e.printStackTrace();
			}
				
	}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Boarding_Pass();
	}

}
