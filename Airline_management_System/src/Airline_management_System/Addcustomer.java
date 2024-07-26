package Airline_management_System;

import java.awt.Color;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;



public class Addcustomer extends JFrame implements ActionListener{
	JTextField tfname,tfnatio,tfaad,tfadd,tfcon;
	JRadioButton tfgen1,tfgen2;
	JLabel back;
	
	
	public Addcustomer() {
		
		getContentPane().setBackground(Color.white);
		setLayout(null);
		setSize(900,600);
		setLocation(300,150);
		setVisible(true);
		
		JLabel heading=new JLabel("ADD CUSTOMER DETAILS");
		heading.setBounds(230, 20, 500, 35);
		heading.setForeground(Color.blue);
		heading.setFont(new Font("tahoma",Font.PLAIN,32));
		add(heading);
		
		JLabel lblname=new JLabel("Name");
		lblname.setBounds(60, 80, 150, 25);
		lblname.setFont(new Font("tahoma",Font.PLAIN,16));
		add(lblname);
		
		 tfname=new JTextField();
		tfname.setBounds(220,80,200,25);
		add(tfname);
		
		JLabel lblnatio=new JLabel("Nationality");
		lblnatio.setBounds(60, 130, 150, 25);
		lblnatio.setFont(new Font("tahoma",Font.PLAIN,16));
		add(lblnatio);
		
		 tfnatio=new JTextField();
		tfnatio.setBounds(220,130,200,25);
		add(tfnatio);
		
		JLabel lblaad=new JLabel("Aadhar Number");
		lblaad.setBounds(60, 190, 150, 25);
		lblaad.setFont(new Font("tahoma",Font.PLAIN,16));
		add(lblaad);
		
		 tfaad=new JTextField();
		tfaad.setBounds(220,190,200,25);
		add(tfaad);
		
		JLabel lbladd=new JLabel("Adress");
		lbladd.setBounds(60, 250, 150, 25);
		lbladd.setFont(new Font("tahoma",Font.PLAIN,16));
		add(lbladd);
		
		 tfadd=new JTextField();
		tfadd.setBounds(220,250,200,25);
		add(tfadd);
		
		JLabel lblgen=new JLabel("Gender");
		lblgen.setBounds(60, 310, 150, 25);
		lblgen.setFont(new Font("tahoma",Font.PLAIN,16));
		add(lblgen);
		
		ButtonGroup gengroup=new ButtonGroup();
		
		tfgen1=new JRadioButton("Male");
		tfgen1.setBounds(220,310,100,25);
		tfgen1.setBackground(Color.white);
		add(tfgen1);
		
		tfgen2=new JRadioButton("Female");
		tfgen2.setBackground(Color.white);
		tfgen2.setBounds(330,310,100,25);
		add(tfgen2);
		
		gengroup.add(tfgen1);
		gengroup.add(tfgen2);
		
		JLabel lblcon=new JLabel("Contact No");
		lblcon.setBounds(60, 360, 150, 25);
		lblcon.setFont(new Font("tahoma",Font.PLAIN,16));
		add(lblcon);
		
		 tfcon=new JTextField();
		tfcon.setBounds(220,360,200,25);
		add(tfcon);
		
		JButton save=new JButton("Save");
		save.setBackground(Color.black);
		save.setForeground(Color.white);
		save.addActionListener(this);
		save.setBounds(220,420,150,30);
		add(save);
		
		back=new JLabel("image");
		ImageIcon icon = new ImageIcon(getClass().getResource("/Airline_management_System/images/icons/user.png"));
		Image image = icon.getImage().getScaledInstance(300, 320, Image.SCALE_DEFAULT);
		back.setBounds(550, 50, 300, 410);
		back.setIcon(new ImageIcon(image));
		add(back);
	}
	
	public void actionPerformed(ActionEvent ae) {
		String name=tfname.getText();
		String nation=tfnatio.getText();
		String aadhar=tfaad.getText();
		String adress=tfadd.getText();
		String contact=tfcon.getText();
		String gender=null;
		if(tfgen1.isSelected()) {
			gender="Male";
		}else {
			gender="Female";
		}
		
		try {
			conn c=new conn();
			String query="Insert Into Passenger Values('"+name+"','"+nation+"','"+aadhar+"','"+adress+"','"+gender+"','"+contact+"')";
			c.s.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Customer Deatils Added Successfully");
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	}

	public static void main(String[] args) {	
		// TODO Auto-generated method stub
		new Addcustomer();

	}

}
