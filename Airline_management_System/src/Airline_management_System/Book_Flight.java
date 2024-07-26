package Airline_management_System;

import java.awt.Choice;
import java.awt.Color;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Random;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;



public class Book_Flight extends JFrame implements ActionListener{
	JLabel tfname,tfnatio,tfadd,labelgen,lblsrc,lbldes,labelfname,labelfcode,back;
	JTextField tfaad;
	JButton bookflight,fetchbtn,fetchflight;
	Choice src,dest;
	JDateChooser dt;
	
	
	
	public Book_Flight() {
		JLabel back;
		getContentPane().setBackground(Color.white);
		setLayout(null);
		setSize(1100,800);
		setLocation(300,50);
		setVisible(true);
		
		JLabel heading=new JLabel("BOOK FLIGHT");
		heading.setBounds(320, 20, 500, 35);
		heading.setForeground(Color.blue);
		heading.setFont(new Font("tahoma",Font.PLAIN,32));
		add(heading);
		
		JLabel lblaad=new JLabel("Aadhar Number");
		lblaad.setBounds(60, 90, 150, 25);
		lblaad.setFont(new Font("tahoma",Font.PLAIN,16));
		add(lblaad);
		
		tfaad=new JTextField();
		tfaad.setBounds(220,90,200,25);
		add(tfaad);
		
		fetchbtn=new JButton("Fetch Details");
		fetchbtn.setBackground(Color.black);
		fetchbtn.setForeground(Color.white);
		fetchbtn.addActionListener(this);
		fetchbtn.setBounds(430, 90, 150, 25);
		add(fetchbtn);
		
		JLabel lblname=new JLabel("Name");
		lblname.setBounds(60, 130, 150, 25);
		lblname.setFont(new Font("tahoma",Font.PLAIN,16));
		add(lblname);
		
		
		
		tfname=new JLabel();
		tfname.setBounds(220,130,200,25);
		add(tfname);
		
		JLabel lblnatio=new JLabel("Nationality");
		lblnatio.setBounds(60, 180, 150, 25);
		lblnatio.setFont(new Font("tahoma",Font.PLAIN,16));
		add(lblnatio);
		
		tfnatio=new JLabel();
		tfnatio.setBounds(220,180,200,25);
		add(tfnatio);
		
		
		JLabel lbladd=new JLabel("Adress");
		lbladd.setBounds(60, 250, 150, 25);
		lbladd.setFont(new Font("tahoma",Font.PLAIN,16));
		add(lbladd);
		
		tfadd=new JLabel();
		tfadd.setBounds(220,250,200,25);
		add(tfadd);
		
		JLabel lblgen=new JLabel("Gender");
		lblgen.setBounds(60, 310, 150, 25);
		lblgen.setFont(new Font("tahoma",Font.PLAIN,16));
		add(lblgen);
		
		labelgen=new JLabel("Gender");
		labelgen.setBounds(220, 310, 150, 25);
		add(labelgen);
		
		lblsrc=new JLabel("Source");
		lblsrc.setBounds(60, 360, 150, 25);
		lblsrc.setFont(new Font("tahoma",Font.PLAIN,16));
		add(lblsrc);
		
		src=new Choice();
		src.setBounds(220,360,150,25);
		add(src);
		
		lbldes=new JLabel("Destination");
		lbldes.setBounds(60, 410, 150, 25);
		lbldes.setFont(new Font("tahoma",Font.PLAIN,16));
		add(lbldes);
		
		dest=new Choice();
		dest.setBounds(220,410,150,25);
		add(dest);
		
		try {
			conn c=new conn();
			String query="select * from flight";
			ResultSet rs=c.s.executeQuery(query);
			
			while(rs.next()) {
				src.add(rs.getString("source"));
				dest.add(rs.getString("destination"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		fetchflight=new JButton("Fetch Flight");
		fetchflight.setBackground(Color.black);
		fetchflight.setForeground(Color.white);
		fetchflight.addActionListener(this);
		fetchflight.setBounds(380,410,150,25);
		add(fetchflight);
		
		JLabel lblfname=new JLabel("Flight Name");
		lblfname.setBounds(60, 460, 150, 25);
		lblfname.setFont(new Font("tahoma",Font.PLAIN,16));
		add(lblfname);
		
		labelfname=new JLabel();
		labelfname.setBounds(220,460,200,25);
		add(labelfname);
		
		JLabel lblfcode=new JLabel("Flight Code");
		lblfcode.setBounds(60, 510, 150, 25);
		lblfcode.setFont(new Font("tahoma",Font.PLAIN,16));
		add(lblfcode);
		
		labelfcode=new JLabel();
		labelfcode.setBounds(220,510,200,25);
		add(labelfcode);
		
		JLabel lbldt=new JLabel("Date Of Travel");
		lbldt.setBounds(60, 560, 150, 25);
		lbldt.setFont(new Font("tahoma",Font.PLAIN,16));
		add(lbldt);
		
		dt=new JDateChooser();
		dt.setBounds(220,560,200,25);
		add(dt);
		
		bookflight=new JButton("Book Flight");
		bookflight.setBackground(Color.black);
		bookflight.setForeground(Color.white);
		bookflight.addActionListener(this);
		bookflight.setBounds(220, 610, 200, 25);
		add(bookflight);
		
		
		back=new JLabel("image");
		ImageIcon icon = new ImageIcon(getClass().getResource("/Airline_management_System/images/icons/details.jpg"));
		Image image = icon.getImage().getScaledInstance(300, 320, Image.SCALE_DEFAULT);
		back.setBounds(600, 80, 300, 410);
		back.setIcon(new ImageIcon(image));
		add(back);
		
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==fetchbtn) {
		
		String aadhar=tfaad.getText();
		
		
		
		
		try {
			conn c=new conn();
			String query="select * from Passenger where aadhar='"+aadhar+"'";
			ResultSet rs=c.s.executeQuery(query);
			if(rs.next()) {
				 tfname.setText(rs.getString("name"));
				 tfnatio.setText(rs.getString("nation"));
				 tfadd.setText(rs.getString("address"));
				 labelgen.setText(rs.getString("gender"));
			}else
			JOptionPane.showMessageDialog(null, "Please Enter Your Correct Aadhar");
//		
	}catch(Exception e) {
		e.printStackTrace();
	}
	}else
		if(ae.getSource()==fetchflight) {
			
			String srrc=src.getSelectedItem();
			String desst=dest.getSelectedItem();			
			
			
			try {
				conn c=new conn();
				String query="select * from flight where source='"+srrc+"' and destination='"+desst+"'";
				ResultSet rs=c.s.executeQuery(query);
				if(rs.next()) {
					labelfname.setText(rs.getString("f_name"));
					labelfcode.setText(rs.getString("f_code"));
					
				}else 
				JOptionPane.showMessageDialog(null, "No Flight Available");
//			
		}catch(Exception e) {
			e.printStackTrace();
		}
			
		}else
			if (ae.getSource() == bookflight) {
			Random random=new Random();
			String name=tfname.getText();
			String nation=tfnatio.getText();
			String address=tfadd.getText();
			String gender=labelgen.getText();
			String fn=labelfname.getText();
			String fc=labelfcode.getText();
			String aadhar=tfaad.getText();
			String BookFlight= bookflight.getText();
			String fb= fetchbtn.getText();
			String ff=fetchflight.getText();
			String sr=src.getSelectedItem();
			String de=dest.getSelectedItem();
			String date=((JTextField) dt.getDateEditor().getUiComponent()).getText();
			
			
		
		try {
			conn c=new conn();
			String query="insert into reservation values('PNR-"+random.nextInt(1000000)+"',"
					+ "'TICKET-"+random.nextInt(10000)+"',"
					+ "'"+name+"','"+nation+"','"+address+"','"+gender+"',"
					+ "'"+sr+"','"+de+"','"+fn+"','"+fc+"','"+aadhar+"','"+BookFlight+"','"+fb+"','"+ff+"','"+sr+"','"+de+"','"+date+"')";
			c.s.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Ticket Booked successfully");
			setVisible(false);
//		
	}catch(Exception e) {
		e.printStackTrace();
	}
}
	}

	public static void main(String[] args) {	
		// TODO Auto-generated method stub
		new Book_Flight();

	}

}
