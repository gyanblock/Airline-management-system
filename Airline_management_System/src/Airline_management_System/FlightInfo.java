
package Airline_management_System;

import javax.swing.*;

import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.*;

public class FlightInfo extends JFrame {

    private JTable table;

    public FlightInfo() {
    
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Flight Information");
        setSize(800, 500);

        getContentPane().setBackground(Color.white);
        // Using BorderLayout instead of null layout
        setLayout(new BorderLayout());

        table = new JTable();

        try {
            conn c = new conn();
            String query = "select * from flight";
            ResultSet rs = c.s.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();
            DefaultTableModel model = new DefaultTableModel();

            // Add column names to the model
            int cols = rsmd.getColumnCount();
            for (int i = 1; i <= cols; i++) {
                model.addColumn(rsmd.getColumnName(i));
            }

            // Add rows to the model
            while (rs.next()) {
                Object[] row = new Object[cols];
                for (int i = 1; i <= cols; i++) {
                    row[i - 1] = rs.getObject(i);
                }
                model.addRow(row);
            }

            // Set the model to the table
            table.setModel(model);

        } catch (SQLException e) {
            
            e.printStackTrace();
        }

        // Add table to a scroll pane and add scroll pane to the frame
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0,0,800,500);
        add(scrollPane);

        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true);
    }

    public static void main(String[] args) {
         new FlightInfo();
    }
}