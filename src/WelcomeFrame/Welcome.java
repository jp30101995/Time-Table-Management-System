package WelcomeFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class Welcome extends JFrame implements ActionListener {
	JButton b1;
	JButton b2;
	JPanel timeTable;
	JPanel login;
	JPanel bottom=new JPanel();
	TimeTable stu=new TimeTable(1,2,false);
	JLabel background=new JLabel(new ImageIcon("C:\\Users\\Jaimin\\workspace\\TimeTableManagementSystem\\src\\WelcomeFrame\\crap2.jpg"));
	private String tid;
	public Welcome() {
		
		setTitle("Timetable Management System");
		setSize(1366,730);
		setLayout(new BorderLayout());
		setBackground(new Color(227,227,227));
		//setVisible(true);
		
		add(background,BorderLayout.CENTER);
		/*background.setLayout(new FlowLayout());
		JLabel l1 = new JLabel("Here is a button");
		JButton b1 = new JButton("I am a button");
		background.add(l1);
		background.add(b1);*/
		add(bottom,BorderLayout.SOUTH);
		bottom.setBackground(new Color(227,227,227));
		bottom.setLayout(new FlowLayout());
		b1=new JButton("Teacher");
		b1.addActionListener(this);
		b2= new JButton("Student");
		//b1.setBounds(50,50,100,100);
		b1.setPreferredSize(new Dimension(100,30));
		b2.setPreferredSize(new Dimension(100,30));
		//b1.setLocation(50, 50);
		bottom.add(b1);
		bottom.add(b2);
		this.updateAllDB();
		b2.addActionListener(this);
		addWindowListener(
				  new WindowAdapter() {
					  public void windowClosing(WindowEvent e) { 
					      System.exit(0); 
					  } 
				      } 
				  );
		setVisible(true);
	}
	public void removeButton(){
		bottom.remove(b1);
		bottom.remove(b2);
	}
	public void updateAllDB(){
		try{  
			//step1 load the driver class  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			  
			//step2 create  the connection object  
			Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:@localhost:1521:xe","system","jimmy3010");  
			  
			//step3 create the statement object  
			Statement stmt=con.createStatement();  
			  
			//step4 execute query  
			CallableStatement cstmt = con.prepareCall("{? = call resetLecMaster (?)}");
			System.out.println("jlsakdsjdlakhsidavhdvih");
			cstmt.registerOutParameter (1, Types.INTEGER);
			int ans=-1;
		    // We want to raise LESLIE's salary by 20,000
		    cstmt.setInt (2, 0);  // The name argument is the second ?
		    cstmt.execute ();
		    ans = cstmt.getInt(1);
			  
			//step5 close the connection object  
			con.close();  
			  
			}catch(Exception e){ System.out.println(e);}  
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Teacher")){
			//timeTable = new TimeTable(1,3);
			//add(timeTable,BorderLayout.CENTER);
			bottom.remove(b1);
			bottom.remove(b2);
			this.remove(background);
			login = new Login();
			add(login,BorderLayout.CENTER);
			setVisible(true);
			//System.out.println("Alaukika");
		}
		if(e.getActionCommand().equals("Student")){
			//timeTable = new TimeTable(1,3);
			//add(timeTable,BorderLayout.CENTER);
			bottom.remove(b1);
			bottom.remove(b2);
			this.remove(background);
			add(stu,BorderLayout.CENTER);
			stu.removeTeacher();
			setVisible(true);
			System.out.println("Alaukika");
		}
		
}
	public void setPane(int tid,TimeTable t){
		TimeTable timeTable =t;
		add(timeTable,BorderLayout.CENTER);
//		t.setLoginMode();
	}
	public void setStudentPaneOnly(){
		
	}
	
	public void removeBackground(){
		this.remove(background);
	}
	public static void main(String[] args){
		Welcome a=new Welcome();
	}

}