package final_project;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class login {
		 
		ImageIcon bg = new ImageIcon(getClass().getResource("ice.jpg"));
		JLabel lblbg = new JLabel();
		JLayeredPane panel = new JLayeredPane();
		JFrame frame = new JFrame();
	
	public login() {
		
	panel.setLayout(null);
	lblbg.setIcon(bg);
	lblbg.setBounds(0,-300,1000,900);

	frame.setVisible(true);
	frame.setSize(450,300);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setLocationRelativeTo(null);
	frame.setTitle("LOGIN");

	frame.add(panel);
	panel.setBackground(new Color(37,42,55));

	JLabel header = new JLabel("SEMILLA'S ICE CREAM");
	panel.add(header);
	header.setBounds(70, 35,350, 20);
	header.setFont(new Font("Franklin Gothic Book", Font.BOLD, 30));
	header.setForeground(new Color(105,105,105));
	
	panel.add(lblbg,new Integer(0));
	
	JLabel lbl = new JLabel("USERNAME");
	panel.add(lbl,new Integer(1));
	lbl.setBounds(90,80,130,30);
	lbl.setFont(new Font("Franklin Gothic Book", Font.BOLD, 20));
	lbl.setForeground(new Color(105,105,105));

	JLabel lbl2 = new JLabel("PASSWORD");
	panel.add(lbl2,new Integer(1));
	lbl2.setBounds(90,120,130,30);
	lbl2.setFont(new Font("Franklin Gothic Book", Font.BOLD, 20));
	lbl2.setForeground(new Color(105,105,105));

	final JTextField txt1 = new JTextField();
	panel.add(txt1,new Integer(1));
	txt1.setBounds(220,85,120,20);
	
	final JPasswordField txt2 = new JPasswordField();
	panel.add(txt2,new Integer(1));
	txt2.setBounds(220,125,120,20);

	final JButton cancel=new JButton("CANCEL");
	panel.add(cancel,new Integer(1));
	cancel.setBounds(230,180,100,30);
	cancel.setForeground(Color.white);
	cancel.setBackground(Color.gray);
	cancel.setFont(new Font("Franklin Gothic Book", Font.BOLD, 15));
	
	cancel.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {

			frame.setVisible(false);

		}
	});

	
	JButton btn=new JButton("LOGIN");
	panel.add(btn,new Integer(1));
	btn.setBounds(100,180,100,30);
	btn.setForeground(Color.white);
	btn.setBackground(Color.gray);
	btn.setFont(new Font("Franklin Gothic Book", Font.BOLD, 15));
	
	btn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ae) {
			try {

				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db_order","root",""); 
				String sql = "Select * from tbl_user where user=? and pass=?";
				PreparedStatement pst = con.prepareStatement(sql); 
				pst.setString(1,txt1.getText());
				pst.setString(2,txt2.getText());
				ResultSet rs = pst.executeQuery();
					if(rs.next()) {
					JOptionPane.showMessageDialog(null, "Successfully Login as "+rs.getString("name"));					
					frame.setVisible(false);
					new dashboard();
					}else{
					JOptionPane.showMessageDialog(null, "Invalid Username/Password ");
					}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	});
}	
	public static void main (String[]args) {
		login log=new login();
	}
}