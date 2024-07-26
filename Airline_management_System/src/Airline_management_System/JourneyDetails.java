package Airline_management_System;

import javax.swing.*;

import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class JourneyDetails extends JFrame implements ActionListener {

     JTable table;
     JTextField pnr;

    public JourneyDetails() {
    
      
        setTitle("Flight Information");
               

        getContentPane().setBackground(Color.white);
        // Using BorderLayout instead of null layout
        setLayout(null);
        
        JLabel lblpnr=new JLabel("PNR");
        lblpnr.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblpnr.setBounds(50,50,100,25);
        add(lblpnr);
        
        pnr=new JTextField();
        pnr.setBounds(160,50,120,25);
        add(pnr);
        
        JButton show=new JButton("Show Details");
        show.setBackground(Color.black);
        show.setForeground(Color.white);
        show.addActionListener(this);
        show.setBounds(290,50,120,25);
        add(show);
       
        

        table = new JTable();

       

        // Add table to a scroll pane and add scroll pane to the frame
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0,100,800,150);
        scrollPane.setBackground(Color.white);
        add(scrollPane);
        
        setSize(800, 600);
        setLocation(400,150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
    	 try {
             conn c = new conn();
            
             ResultSet rs = c.s.executeQuery("select * from reservation where PNR='"+pnr.getText()+"'");
             if(!rs.isBeforeFirst()) {
            	 JOptionPane.showMessageDialog(null, "No Reservation Found");
            	 return;
             }
             DefaultTableModel model = new DefaultTableModel();
             
             // Retrieve metadata (column names)
             ResultSetMetaData metaData = rs.getMetaData();
             int columnCount = metaData.getColumnCount();
             for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                 model.addColumn(metaData.getColumnLabel(columnIndex));
             }
             
             // Populate the model with data from the ResultSet
             while (rs.next()) {
                 Object[] rowData = new Object[columnCount];
                 for (int i = 0; i < columnCount; i++) {
                     rowData[i] = rs.getObject(i + 1);
                 }
                 model.addRow(rowData);
             }
            
             
             table.setModel(model);
            

         } catch (SQLException e) {
             
             e.printStackTrace();
            
         }
    	 
    }
    


    public static void main(String[] args) {
         new JourneyDetails();
    }
}
