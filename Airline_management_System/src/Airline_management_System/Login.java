package Airline_management_System;
import java.awt.Color;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener {
	JButton reset,submit,close;
	JTextField tfusrname;
	JPasswordField tfpass;
	public Login() {
		getContentPane().setBackground(Color.white);
		setLayout(null);
		setSize(400,250);
		setLocation(600,250);
		setVisible(true);
		
		JLabel lbluser=new JLabel("username");
		lbluser.setBounds(20,20,100,20);
		add(lbluser);
		
		tfusrname=new JTextField();
		tfusrname.setBounds(130,20,200,20);
		add(tfusrname);
		
		tfpass=new JPasswordField();
		tfpass.setBounds(130,60,200,20);
		add(tfpass);
		
		JLabel lblpass=new JLabel("password");
		lblpass.setBounds(20,60,100,20);
		add(lblpass);
		
		reset=new JButton("Reset");
		reset.addActionListener(this);
		reset.setBounds(40,120,120,20);
		add(reset);
		
		submit=new JButton("Submit");
		submit.addActionListener(this);
		submit.setBounds(190,120,120,20);
		add(submit);
		
		close=new JButton("Close");
		close.addActionListener(this);
		close.setBounds(120,160,120,20);
		add(close);
		
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Login();

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==submit) {
			//call Home class object
			new Home();
			setVisible(false);
			String username=tfusrname.getText();
			String password=tfpass.getText();
			try {
				conn c=new conn();
				String query="select * from login where username='"+username+"' and password='"+password+"'";
				ResultSet rs=c.s.executeQuery(query);
				if(rs.next()) {
					System.out.println("valiid");
				}else {
					JOptionPane.showMessageDialog(null, "Invalid username and Passsword");
					setVisible(false);
				}
			}catch(Exception e1) {
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==close){
			setVisible(false);
		}
		else if(e.getSource()==reset) {
			tfusrname.setText("");
			tfpass.setText("");
		
		}
		
	}

} 
