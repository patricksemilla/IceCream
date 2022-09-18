package final_project;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class dashboard{
	
	
	ImageIcon bg = new ImageIcon(getClass().getResource("bg.jpg"));
	JLabel lblbg = new JLabel();
	JLayeredPane panel = new JLayeredPane();
	JFrame frame = new JFrame();
	boolean F=false;
	
	List order = new List();
	
	int choco=0,van=0,straw=0,scp_id=20;
	int no_scoops=1;
	int flavor_price=0;
	
	String t="";
	int type_price=0;
	
	int al,ch,spr,nts, top_id;
	
	int toppings_price=0,top_al,top_ch,top_nt,top_spr;
	
	int total_ammount=0;
	String TA="";
	
	int pera=0,change=0;
	public dashboard() {
		
		// DATE
		
		Calendar cal = Calendar.getInstance();
        SimpleDateFormat dateOnly = new SimpleDateFormat("MM/dd/yyyy h:m:s");
        System.out.println(dateOnly.format(cal.getTime()));
        
		//for background
		
		panel.setLayout(null);
		lblbg.setIcon(bg);
		lblbg.setBounds(0,-100,1000,900);

		//caption
		
		JLabel choose = new JLabel("CHOOSE YOUR ICE CREAM (^.^)");
		choose.setForeground(Color.gray);
		choose.setFont(new Font("Franklin Gothic Book", Font.BOLD, 25));
		
		//orders
		
		
		panel.add(order,new Integer(1));
		order.setBounds(520,80,400,350);
		order.add("         ITEMS                            PRICE");
		order.add("                                ");
        order.setFont(new Font("Franklin Gothic Book", Font.BOLD, 20));
        
       
		
		//cone type
		
		JLabel conetype = new JLabel("Cone Type");
		conetype.setForeground(Color.gray);
		conetype.setFont(new Font("Franklin Gothic Book", Font.BOLD, 20));
		
		
		JRadioButton wafer = new JRadioButton("WAFER CONE (P20)");
		wafer.setFont(new Font("Franklin Gothic Book", Font.BOLD, 15));
		wafer.setForeground(new Color(105,105,105));
		wafer.setBackground(new Color(145,223,197));
		
		JRadioButton sugar = new JRadioButton("SUGAR CONE (P50)");
		sugar.setForeground(new Color(105,105,105));
		sugar.setBackground(new Color(145,223,197));
		sugar.setFont(new Font("Franklin Gothic Book", Font.BOLD, 15));
		
		JRadioButton cup = new JRadioButton("CUP (P18)");
		cup.setForeground(new Color(105,105,105));
		cup.setBackground(new Color(145,223,197));
		cup.setFont(new Font("Franklin Gothic Book", Font.BOLD, 15));
	
		
		ButtonGroup conez = new ButtonGroup();
		conez.add(wafer);
		conez.add(sugar);
		conez.add(cup);
		
		panel.add(lblbg,new Integer(0));
		panel.add(choose,new Integer(1));
		panel.add(conetype,new Integer(1));
		panel.add(wafer,new Integer(1));
		panel.add(sugar,new Integer(1));
		panel.add(cup,new Integer(1));
		
		choose.setBounds(350,15,500,40);
		conetype.setBounds(200,80,200,30);
		wafer.setBounds(160,120,210,30);
		sugar.setBounds(160,170,210,30);
		cup.setBounds(160,220,210,30);
		
		//flavors
		
		JLabel flavor = new JLabel("Flavor");
		flavor.setForeground(Color.gray);
		flavor.setFont(new Font("Franklin Gothic Book", Font.BOLD, 20));
		
		JComboBox flav = new JComboBox();
		flav.setForeground(new Color(175,175,175));
		flav.setFont(new Font("Franklin Gothic Book", Font.BOLD, 15));
		
		flav.addItem("Chocolate");
		flav.addItem("vanilla");
		flav.addItem("Strawberry");
		
		panel.add(flavor,new Integer(1));
		panel.add(flav,new Integer(1));
		
		flavor.setBounds(67,270,100,30);
		flav.setBounds(30,310,150,30);
		
		//scoops
		
		JLabel no = new JLabel("Number of Scoops");
		no.setForeground(Color.gray);
		no.setFont(new Font("Franklin Gothic Book", Font.BOLD, 20));
		
		
		JLabel cap = new JLabel("(P15 per scoop)");
		cap.setForeground(Color.gray);
		cap.setFont(new Font("Franklin Gothic Book", Font.BOLD, 15));
		
		panel.add(no,new Integer(1));
	
		panel.add(cap,new Integer(1));
		
		no.setBounds(240,270,250,30);
		
		cap.setBounds(330,310,150,30);
		
		//toppings
		
		JLabel toppings = new JLabel("Toppings (P20 each)");
		toppings.setForeground(Color.gray);
		toppings.setFont(new Font("Franklin Gothic Book", Font.BOLD, 20));
		
		JCheckBox almonds = new JCheckBox("ALMONDS");
		almonds.setForeground(new Color(105,105,105));
		almonds.setBackground(new Color(145,223,197));
		almonds.setFont(new Font("Franklin Gothic Book", Font.BOLD, 15));
		
		almonds.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				if(almonds.isSelected()) {
					order.add("         ALMONDS                       P20");
					al=1;
					top_al=20;
				}else {
					order.remove("         ALMONDS                       P20");
					al=0;
					top_al=0;
				}
				if(F==true) {
					order.remove("      ");
					order.remove(TA);
					F=false;
				}
			}
		});
		
		JCheckBox sprinkles = new JCheckBox("CANDY SPRINKLES");
		sprinkles.setForeground(new Color(105,105,105));
		sprinkles.setBackground(new Color(145,223,197));
		sprinkles.setFont(new Font("Franklin Gothic Book", Font.BOLD, 15));
		
		sprinkles.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				if(sprinkles.isSelected()) {
					spr=1;
					order.add("         SPRINKLES                      P20");
					top_spr=20;
				}else {
					spr=0;
					order.remove("         SPRINKLES                      P20");
					top_spr=0;
				}
				if(F==true) {
					order.remove("      ");
					order.remove(TA);
					F=false;
				}
			}
		});
		
		JCheckBox syrup = new JCheckBox("CHOCO SYRUP");
		syrup.setForeground(new Color(105,105,105));
		syrup.setBackground(new Color(145,223,197));
		syrup.setFont(new Font("Franklin Gothic Book", Font.BOLD, 15));
		
		syrup.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				
				if(e.getStateChange()==1) {
					ch=1;
					order.add("         CHOCO SYRUP               P20");
					top_ch=20;
				}else {
					ch=0;
					order.remove("         CHOCO SYRUP               P20");
					top_ch=0;
				}
				if(F==true) {
					order.remove("      ");
					order.remove(TA);
					F=false;
				}
			}
		});
		
		JCheckBox nut = new JCheckBox("NUTS");
		nut.setForeground(new Color(105,105,105));
		nut.setBackground(new Color(145,223,197));
		nut.setFont(new Font("Franklin Gothic Book", Font.BOLD, 15));
		
		nut.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				
				if(e.getStateChange()==1) {
					nts=1;
					
					order.add("         NUTS                               P20");
					top_nt=20;
				}else {
					nts=0;
					order.remove("         NUTS                               P20");
					top_nt=0;
				}
				
				if(F==true) {
					order.remove("      ");
					order.remove(TA);
					F=false;
				}
			}
		});
		
		panel.add(toppings,new Integer(1));
		panel.add(almonds,new Integer(1));
		panel.add(sprinkles,new Integer(1));
		panel.add(syrup,new Integer(1));
		panel.add(nut,new Integer(1));
		
		toppings.setBounds(130,350,250,30);
		almonds.setBounds(30,400,210,30);
		sprinkles.setBounds(270,400,210,30);
		syrup.setBounds(30,460,210,30);
		nut.setBounds(270,460,210,30);
	
		
		wafer.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				if(wafer.isSelected()) {
					order.add("         WAFER                            P20");
					t="wafer cone";
					type_price=20;
					
				}else {
					order.remove("         WAFER                            P20");
					type_price=0;
				}
				if(F==true) {
					order.remove("      ");
					order.remove(TA);
					F=false;
				}
			}
			
		});
		
		
		sugar.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				if(sugar.isSelected()) {
					order.add("         SUGAR                            P50");
					t="sugar cone";
					type_price=50;
				}else {
					order.remove("         SUGAR                            P50");
					type_price=0;
				}
				if(F==true) {
					order.remove("      ");
					order.remove(TA);
					F=false;
				}
			}
			
		});
		
		
		cup.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				if(cup.isSelected()) {
					order.add("         CUP                                 P18");
					t="cup";
					type_price=18;
					
				}else {
					order.remove("         CUP                                 P18");
					type_price=0;
				}
				
				if(F==true) {
					order.remove("      ");
					order.remove(TA);
					F=false;
				}
			}
			
		});
		
		
		//cash
		
				JLabel cash = new JLabel("CASH: ");
				cash.setForeground(new Color(105,105,105));
				cash.setFont(new Font("Franklin Gothic Book", Font.BOLD, 20));
				panel.add(cash,new Integer(1));
				cash.setBounds(540,450,210,50);
				
				JTextField txtcash = new JTextField();
				txtcash.setForeground(new Color(105,105,105));
				txtcash.setFont(new Font("Franklin Gothic Book", Font.BOLD, 20));
				panel.add(txtcash,new Integer(1));
				txtcash.setBounds(600,460,210,30);
				

			
		//add
		
		JButton add = new JButton("ADD");
		add.setForeground(Color.white);
		add.setBackground(Color.gray);
		add.setFont(new Font("Franklin Gothic Book", Font.BOLD, 15));
		
		panel.add(add,new Integer(1));
		add.setBounds(220,310,100,30);
	
		
		//remove
		
		
		JButton rem = new JButton("REMOVE");
		rem.setForeground(Color.white);
		rem.setBackground(Color.gray);
		rem.setFont(new Font("Franklin Gothic Book", Font.BOLD, 15));
		panel.add(rem,new Integer(1));
		rem.setBounds(360,550,100,60);
		rem.setEnabled(false);
		
		rem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				order.remove((String) flav.getSelectedItem());
				flavor_price=flavor_price-15;
				
			    no_scoops--;
			
				if(no_scoops==1) {
					rem.setEnabled(false);
				}
					if(no_scoops>0){
						add.setEnabled(true);
						
						if(flav.getSelectedIndex()==0) {
							choco--;
						}else if(flav.getSelectedIndex()==1) {
							van--;
						}else if(flav.getSelectedIndex()==2) {
							straw--;
						}
					}
					
					
						if(F==true) {
							order.remove("      ");
							order.remove(TA);
							F=false;
						}
						
			}
		});
		
		
		
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				order.add((String) flav.getSelectedItem());
				
				flavor_price=flavor_price+15;
				if(no_scoops>=3) {
					add.setEnabled(false);
					
				}else{
					rem.setEnabled(true);
				}
				no_scoops++;
				
					if(flav.getSelectedIndex()==0) {
						choco++;
					}else if(flav.getSelectedIndex()==1) {
						van++;
					}else if(flav.getSelectedIndex()==2) {
						straw++;
					}
					
					if(F==true) {
						order.remove("      ");
						order.remove(TA);
						F=false;
					}
			}
		});
		
		//process
		JLabel temp = new JLabel();
		panel.add(temp,new Integer(1));
		temp.setBounds(550,550,120,60);
		
		JButton process = new JButton("PROCESS");
		process.setForeground(Color.white);
		process.setBackground(Color.gray);
		process.setFont(new Font("Franklin Gothic Book", Font.BOLD, 15));
		
		panel.add(process,new Integer(1));
		process.setBounds(550,550,120,60);
		
		
		//checkout
		
		JButton checkout = new JButton("CHECK OUT");
		checkout.setForeground(Color.white);
		checkout.setBackground(Color.gray);
		checkout.setFont(new Font("Franklin Gothic Book", Font.BOLD, 15));
		checkout.setEnabled(false);
		panel.add(checkout,new Integer(1));
		checkout.setBounds(760,550,120,60);
		
		
		
		process.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if((al==0)&&(nts==0)&&(spr==0)&&(ch==1)) {
					top_id=1;
				}
				if((al==0)&&(nts==0)&&(spr==1)&&(ch==0)) {
					top_id=2;
				}
				if((al==0)&&(nts==0)&&(spr==1)&&(ch==1)) {
					top_id=3;
				}
				if((al==0)&&(nts==1)&&(spr==0)&&(ch==0)) {
					top_id=4;
				}
				if((al==0)&&(nts==1)&&(spr==0)&&(ch==1)) {
					top_id=5;
				}
				if((al==0)&&(nts==1)&&(spr==1)&&(ch==0)) {
					top_id=6;
				}
				if((al==0)&&(nts==1)&&(spr==1)&&(ch==1)) {
					top_id=7;
				}
				if((al==1)&&(nts==0)&&(spr==0)&&(ch==0)) {
					top_id=8;
				}
				if((al==1)&&(nts==0)&&(spr==0)&&(ch==1)) {
					top_id=9;
				}
				if((al==1)&&(nts==0)&&(spr==1)&&(ch==0)) {
					top_id=10;
				}
				if((al==1)&&(nts==0)&&(spr==1)&&(ch==1)) {
					top_id=11;
				}
				if((al==1)&&(nts==1)&&(spr==0)&&(ch==0)) {
					top_id=12;
				}
				if((al==1)&&(nts==1)&&(spr==0)&&(ch==1)) {
					top_id=13;
				}
				if((al==1)&&(nts==1)&&(spr==1)&&(ch==0)) {
					top_id=14;
				}
				if((al==1)&&(nts==1)&&(spr==1)&&(ch==1)) {
					top_id=15;
				}
				
// scoops 
				if((choco==1)&&(van==0)&&(straw==0)){
					scp_id=1;
				}
				if((choco==2)&&(van==0)&&(straw==0)){
					scp_id=2;
				}
				if((choco==3)&&(van==0)&&(straw==0)){
					scp_id=3;
				}
				if((choco==0)&&(van==1)&&(straw==0)){
					scp_id=4;
				}
				 if((choco==0)&&(van==2)&&(straw==0)){
					scp_id=5;
				}
				if((choco==0)&&(van==3)&&(straw==0)){
					scp_id=6;
				}
				if((choco==0)&&(van==0)&&(straw==1)){
					scp_id=7;
				}
				if((choco==0)&&(van==0)&&(straw==2)){
					scp_id=8;
				}
				if((choco==0)&&(van==0)&&(straw==3)){
					scp_id=9;
				}

			 if((choco==2)&&(van==11)&&(straw==0)){
				scp_id=10;
			}
			 
			 if((choco==2)&&(van==0)&&(straw==1)){
				scp_id=11;
			}
			 if((choco==1)&&(van==2)&&(straw==0)){
				scp_id=12;
			}
			 if((choco==0)&&(van==2)&&(straw==1)){
				scp_id=13;
			}
			 if((choco==1)&&(van==0)&&(straw==2)){
				scp_id=14;
			}
			  if((choco==0)&&(van==1)&&(straw==2)){
				scp_id=15;
			}
			  if((choco==1)&&(van==1)&&(straw==1)){
				  
				scp_id=16;
			}
			  if((choco==1)&&(van==1)&&(straw==0)){
				scp_id=17;
			}
			  if((choco==1)&&(van==0)&&(straw==1)){
				scp_id=18;
			}
			  if((choco==0)&&(van==1)&&(straw==1)){
				scp_id=19;
			}
			  if((choco==0)&&(van==0)&&(straw==0)){
				scp_id=20;
			}
				
				if(scp_id<20) {
					total_ammount=flavor_price+type_price+toppings_price;
					TA="        Total amount:                   P"+total_ammount;
					order.add("      ");
					order.add(TA);
					checkout.setEnabled(true);
				}
				else
				{
					
					JOptionPane.showMessageDialog(null, "Please add some ice cream scoop!");
				}

		        F=true;  //para maupdate lang yung total ammount sa loob ng list 
			}
		});
		
		
		checkout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String ammount = txtcash.getText();
				pera=Integer.parseInt(ammount);
					if(pera>=total_ammount) {
						change=pera-total_ammount;
						JOptionPane.showMessageDialog(null,"CHANGE: "+change);
						
					}else {
						JOptionPane.showMessageDialog(null, "Insuficient Cash!");
					}
				
					Calendar cal = Calendar.getInstance();

			        SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
			        
			        
			/*	try {

					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db_order","root",""); 
					String query = " insert into `tbl_transaction`(type, scoop, toppings, ammt,cash,sukli,date) VALUES (?,?,?,?,?,?,?)";
					PreparedStatement pst = con.prepareStatement(query); 
					
					pst.setString(1,t);
					pst.setString(2,""+scp_id);
					pst.setString(3,""+top_id);
					pst.setString(4,""+total_ammount);
					pst.setString(5,""+pera);
					pst.setString(6,""+change);
					pst.setString(7,""+date.format(cal.getTime()));
					pst.executeUpdate();
					
					con.close();
				
				}catch(Exception err) {
					 System.out.print(err);
				}
				*/
				     new receipt(order);
				     frame.dispose();
				
			}
		});
		
	

		//void
		
		JButton cancel = new JButton("VOID");
		cancel.setForeground(Color.white);
		cancel.setBackground(Color.gray);
		cancel.setFont(new Font("Franklin Gothic Book", Font.BOLD, 15));
		
		panel.add(cancel,new Integer(1));
		cancel.setBounds(170,550,100,60);
		
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add.setEnabled(true);
				rem.setEnabled(false);
				no_scoops=1;
				total_ammount=0;
				flavor_price=0;
				type_price=0;
				toppings_price=0;
				scp_id=20;
				choco=0;
				van=0;
				straw=0;
				txtcash.setText("");
				conez.clearSelection();
				almonds.setSelected(false);
				syrup.setSelected(false);
				nut.setSelected(false);
				sprinkles.setSelected(false);
				order.removeAll();
				order.add("         ITEMS                            PRICE");
				order.add("                                ");    
				
				
			}
		});

		//frame
		
		frame.add(panel);
		frame.setBounds(0,0,1000,700);
		frame.setLocationRelativeTo(null);
		frame.setTitle("MENU");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
		
		
		
	}
}
	
	
