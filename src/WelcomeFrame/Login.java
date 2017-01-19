package WelcomeFrame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends TimeTable implements ActionListener{
JPanel head1 = new JPanel();
JPanel head2 = new JPanel();
JPanel head3 = new JPanel();
JPanel head4 = new JPanel();
JPanel head5 = new JPanel();
JLabel lab = new JLabel("UserID        :");
JLabel lab2 = new JLabel("Password  :");
JLabel lab3 = new JLabel("Enter Details : ");
JButton login = new JButton("Login");
JTextField userName = new JTextField(30);
JPasswordField password = new JPasswordField(30);
boolean loginFlag=false;
//TimeTable t=new TimeTable();
	public Login() {
		
		createLoginPane();//	add(head5,BorderLayout.);
	}
	
	public void createLoginPane(){
		setLayout(new BorderLayout());
		head1.setLayout(new BorderLayout());
		head2.setLayout(new FlowLayout());
		head2.add(lab);
		head2.add(userName);
		head3.setLayout(new FlowLayout());
		head3.add(lab2);
		head3.add(password);
		head1.add(head2,BorderLayout.NORTH);
		head1.add(head3,BorderLayout.CENTER);
		add(head1,BorderLayout.CENTER);
		head4.setLayout(new FlowLayout());
		head4.add(lab3);
		add(head4,BorderLayout.NORTH);
		head3.add(login);
		login.addActionListener(this);
		
	}
	public void setLogin(){
		loginFlag=true;
	}
	public boolean getLogin(){
		return loginFlag;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Alloo");
		if(e.getActionCommand().equals("Login")){
			//new TimeTable(1);
			System.out.println("Alaukika");
			//System.exit(0);
			try{  
				//step1 load the driver class  
				Class.forName("oracle.jdbc.driver.OracleDriver");  
				  
				//step2 create  the connection object  
				Connection con=DriverManager.getConnection(  
				"jdbc:oracle:thin:@localhost:1521:xe","system","jimmy3010");  
				  
				//step3 create the statement object  
				Statement stmt=con.createStatement();  
				String name=userName.getText();
				String pass=password.getText();
				//step4 execute query  
				ResultSet rs=stmt.executeQuery("select * from login");  
				while(rs.next()){  
				//System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
					if(name.equals(rs.getString(2)) && pass.equals(rs.getString(3))){
						super.loginTeacherId=rs.getInt(1);
						System.out.println("Login set then................................"+super.loginTeacherId);
					}
				} 
				if(loginTeacherId==-1){
					System.out.println("alau");
					JOptionPane.showMessageDialog(this, "Invalid Login Details");
					
				}
				else{
					//this.setVisible(false);
					//getRootPane().setVisible(false);
					//this.setLogin();
					
					Welcome w = new Welcome();
					TimeTable t = new TimeTable(1,loginTeacherId,true);
					w.removeBackground();
					w.setPane(loginTeacherId,t);
					w.removeButton();
					//this.setVisible(false);
				}
				//step5 close the connection object  
				con.close();  
				  
				}catch(Exception e1){ System.out.println(e1);}  
			
			
			
			//redirect
			}
		
	}

}
