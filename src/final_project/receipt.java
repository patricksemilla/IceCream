package final_project;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
public class receipt{
	
	
	ImageIcon bg = new ImageIcon(getClass().getResource("1.jpg"));
	JLabel lblbg = new JLabel();
	JLayeredPane panel = new JLayeredPane();
	JFrame frame = new JFrame();
	
	public receipt(List r) {
		
		Calendar cal = Calendar.getInstance();

        SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
     
        
		
		
		//bg
		panel.setLayout(null);
		lblbg.setIcon(bg);
		lblbg.setBounds(-50,-220,1000,900);
		panel.add(lblbg,new Integer(0));
		r.setBounds(70, 90, 420, 250);
		panel.add(r,new Integer(1));  
		r.add("DATE :      "+date.format(cal.getTime()),0);
		r.add(" ");	
		
		//labels
		
		JLabel tu = new JLabel();
		JLabel sem = new JLabel("SEMILLA'S ICE CREAM");
		JPanel list = new JPanel();
		
		JLabel tnx = new JLabel("THANK YOU FOR ORDERING COME AGAIN!");
		panel.add(tnx,new Integer(1));
		tnx.setBounds(100,320,550,100);
		tnx.setFont(new Font("Franklin Gothic Book", Font.BOLD, 19));
		tnx.setForeground(new Color(105,105,105));
		
		
		JButton done = new JButton("DONE");
		JButton back = new JButton("BACK");
		
		panel.setLayout(null);
		panel.add(list,new Integer(1));
		panel.add(done,new Integer(1));
		panel.add(sem,new Integer(1));
		
		sem.setBounds(130,15,350,60);
		sem.setFont(new Font("Franklin Gothic Book", Font.BOLD, 30));
		sem.setForeground(new Color(105,105,105));
	
		done.setBounds(230,400,100,40);
		done.setForeground(Color.white);
		done.setBackground(Color.gray);
		done.setFont(new Font("Franklin Gothic Book", Font.BOLD, 15));
		
		frame.setBounds(600,110,580,510);
		frame.add(panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Receipt");
		
		//list
		
        
		done.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				new dashboard();
				frame.setVisible(false);
			}
		});
		
	}
}


