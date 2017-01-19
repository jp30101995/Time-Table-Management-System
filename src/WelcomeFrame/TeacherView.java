package WelcomeFrame;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class TeacherView extends TimeTable implements ActionListener{
	//for teacher table
	Connection con=null;
	Statement stmt=null;
	ResultSet rs=null;
	ResultSet rs2=null;
	JPanel upper = new JPanel();
	JPanel mid = new JPanel();
	JPanel end = new JPanel();
	JLabel lec = new JLabel();
	
	String[][] arrSub=new String[10][10];
	JComboBox<String> sem=new JComboBox<String>();
	JButton logout = new JButton("Logout");
	JPanel left = new JPanel();
	JPanel left_button =new JPanel();
	JPanel left_color = new JPanel();
	int semester =1;
	//for login
	JPanel head1 = new JPanel();
	JPanel head2 = new JPanel();
	JPanel head3 = new JPanel();
	JPanel head4 = new JPanel();
	JPanel head5 = new JPanel();
	JPanel msg = new JPanel();
	
	JLabel lab = new JLabel("UserID        :");
	JLabel lab2 = new JLabel("Password  :");
	JLabel lab3 = new JLabel("Enter Details : ");
	JLabel message = new JLabel();
	
	JButton login = new JButton("Login");
	JButton cancel = new JButton("Cancel Lecture");
	JButton extra = new JButton("Extra Lecture");
	JButton swap = new JButton("Swap Lecture");
	JButton find = new JButton("Find Lecture");
	JButton yesReq = new JButton("Yes");
	JButton noReq = new JButton("No");
	
	
 	JTextField userName = new JTextField(30);
	JTextField password = new JTextField(30);
	int tid=-1;
	
	
	public TeacherView(int semester,int td) {
		try{  
			this.tid=td;
			System.out.println(tid);
			//step1 load the driver class  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			  
			//step2 create  the connection object  
			Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:@localhost:1521:xe","system","jimmy3010");  
			  
			//step3 create the statement object  
//			while(rs.next())  
//			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getInt(3));  
			  
			//step5 close the connection object  
			

		setLayout(new BorderLayout());

		/*		add(upper,BorderLayout.NORTH);
		upper.setLayout(new FlowLayout());
		JComboBox<String> dept=new JComboBox<String>();
		dept.addItem("CS");
		upper.add(dept);
		sem.addItem("Sem 1");
		sem.addItem("Sem 2");
		sem.addItem("Sem 3");
		sem.addItem("Sem 4");
		sem.addItem("Sem 5");
		sem.addItem("Sem 6");
		sem.addItem("Sem 7");
		sem.addItem("Sem 8");
		upper.add(sem);
		sem.addActionListener(this);
*/		
		Border padding = BorderFactory.createEmptyBorder(50, 50, 50, 50);
		this.setBorder(padding);
		
		left.setLayout(new GridLayout(5,1));
		left_color.setLayout(new GridLayout(4,2,5,5));
		left_color.add(new JLabel("Regular          "));
		left_color.add(new Lec_color(1));
		left_color.add(new JLabel("Cancel           "));
		left_color.add(new Lec_color(2));
		left_color.add(new JLabel("New              "));
		left_color.add(new Lec_color(3));
		left_color.add(new JLabel("Swap             "));
		left_color.add(new Lec_color(4));
		left.add(left_color);
		//left_button.setLayout(new GridLayout(3,1));
	//	left.add(cancel);
	//	left.add(swap);
	//	left.add(extra);
	//	left.add(find);
	//	cancel.addActionListener(this);
	//	swap.addActionListener(this);
	//	extra.addActionListener(this);
	//	find.addActionListener(this);
		//left.add(left_button);
		add(left,BorderLayout.WEST);
		
		//setting time table...
		end.setLayout(new FlowLayout());
		msg.setLayout(new GridLayout(0,2));
		msg.add(message);
		msg.setSize(100,100);
		msg.setMinimumSize(new Dimension(100,100));
		end.add(msg);
		end.add(logout);
		add(end,BorderLayout.SOUTH);
		logout.addActionListener(this);
		mid.setLayout(new GridLayout(9,7,5,5));
		mid.setBackground(Color.WHITE);
		int k=0;
		String temp="LAB";
		String t2="";
		int semno=semester%2;
		String yr;
		for(int i=0;i<10;i++){
			for(int j=0;j<10;j++){
				arrSub[i][j]="----";
			}
		}
		//timtable
		for(int i=1;i<=7;i++){
			for(int j=1;j<8;j++){
				Statement stmt=con.createStatement();  
				Statement stmt2=con.createStatement();
				int dur=0;
				int type=111;
				int bnv=0;
				//step4 execute query
//					System.out.println("aloooooooooooooooooooooooooooooooooo");
				ResultSet rs=stmt.executeQuery("select * from subject where sub_id in (select sub_id from Lecture_master where day="+i+" and time="+j+" and T_ID="+td+" and mod(sem,2)="+semno+")");  
				ResultSet rs2=stmt2.executeQuery("select * from Lecture_master where day="+i+" and time="+j+" and T_ID="+td+" and mod(sem,2)="+semno+"");
			//	System.out.println("\n Inside teacher pane");
				while(rs2.next()) {
					bnv=rs2.getInt(2);
				//	System.out.println("\n Inside teacher33 pane");
					switch(bnv){
					case 1:yr="BE-I";break;
					case 2:yr="BE-II";break;
					case 3:yr="BE-III";break;
					case 4:yr="BE-IV";break;
					}
					dur=rs2.getInt(6);
					//System.out.println("DUR "+dur);
					type=rs2.getInt(7);
				if(rs2.getString(8).equals("420")) {
					//mid.add(new JLabel("free"));
					//System.out.println("Vaaggggggggaaaadiiiiiiiii");
					arrSub[j-1][i-1]="----";
				}
				if(rs2.getString(8).equals("421")) {
					//mid.add(new JLabel("free"));
					arrSub[j-1][i-1]="---";
				}
				else if(type==0){
					while(rs.next())
					temp=rs.getString(2)+"\n(LAB)";
					arrSub[j-1][i-1]=temp;
					if(dur==2) {
						arrSub[j][i-1]=temp;
					}
					else if(dur==3) {
						arrSub[j][i-1]=temp;
						arrSub[j+1][i-1]=temp;
					}
				}

				else {
				while(rs.next()){  
						temp=rs.getString(2);
						//System.out.println("new dur "+dur);
					
					while(dur>0){
						k=j;
						//mid.add(new JLabel(""+rs.getString(2)));
						arrSub[k-1][i-1]=temp;
						if(dur>1){
							
							arrSub[k-1][i-1]=temp;
								//System.out.println("temp printed");
						}
						dur--;
						k++;
					}
				}
				}
				}//while
				
			}
		}
		add(mid,BorderLayout.CENTER);
/*		for(int x=0;x<7;x++) {
			for(int y=0;y<6;y++) {
				System.out.print("\t\t"+arrSub[x][y]);
			}
			System.out.println();
		}
	*/	
		for(int x=0;x<=8;x++){
			for(int y=0;y<=6;y++){
				if(x==0) {
					switch(y) {
						case 0:
							mid.add( new Lecture("Time/Day"));
							break;
						case 1:
							mid.add(new Lecture("Monday"));
							break;
						case 2:
							mid.add(new Lecture("Tuesday"));
							break;
						case 3:
							mid.add(new Lecture("Wednesday"));
							break;
						case 4:
							mid.add(new Lecture("Thursday"));
							break;
						case 5:
							mid.add(new Lecture("Friday"));
							break;
						case 6:
							mid.add(new Lecture("Saturday"));
							break;		
					}
				}
				else if(x==5){
					if(y==0)
						mid.add(new Lecture("2:00 PM"));
					else
						mid.add(new Lecture("Recess"));}
				else if(x>0 && x<5){
					if(y==0) {
						switch(x) {
						case 1:
							mid.add(new Lecture("10:00 AM"));
							break;
						case 2:
							mid.add(new Lecture("11:00 AM"));
							break;
						case 3:
							mid.add(new Lecture("12:00 PM"));
							break;
						case 4:
							mid.add(new Lecture("1:00 PM"));
							break;
						case 5:
							mid.add(new Lecture("2:00 PM"));
							break;
						case 6:
							mid.add(new Lecture("2:30 PM"));
							break;
						case 7:
							mid.add(new Lecture("3:30 PM"));
							break;
						case 8:
							mid.add(new Lecture("4:30 PM"));
							break;
							}
						}else{
							if(arrSub[x-1][y-1]!=null) {
								if(getLoginMode() && !arrSub[x-1][y-1].equals("---"))
								mid.add(new Lecture(arrSub[x-1][y-1],x,y,semester,1,1,0,tid));
								else if(arrSub[x-1][y-1].equals("---"))
								mid.add(new Lecture(arrSub[x-1][y-1],x,y,semester,1,1,1,tid));
								else
								mid.add(new Lecture(arrSub[x-1][y-1],x,y,semester,0,1,0,tid));
									
							}
							else
								mid.add(new Lecture());
							
							
						}
					}
				//	if(x>0 && x<5)
					//	mid.add(new JLabel(arrSub[x-1][y-1]));
					
					else if(x>5){
						if(y==0) {
							switch(x) {
							case 1:
								mid.add(new Lecture("10:00 AM"));
								break;
							case 2:
								mid.add(new Lecture("11:00 AM"));
								break;
							case 3:
								mid.add(new Lecture("12:00 PM"));
								break;
							case 4:
								mid.add(new Lecture("1:00 PM"));
								break;
							case 5:
								mid.add(new Lecture("2:00 PM"));
								break;
							case 6:
								mid.add(new Lecture("2:30 PM"));
								break;
							case 7:
								mid.add(new Lecture("3:30 PM"));
								break;
							case 8:
								mid.add(new Lecture("4:30 PM"));
								break;
							}
						}else{
							if(arrSub[x-2][y-1]!=null) {
								if(getLoginMode() && !arrSub[x-2][y-1].equals("---"))
								mid.add(new Lecture(arrSub[x-2][y-1],x,y,semester,1,2,0,tid));
								else if(arrSub[x-2][y-1].equals("---"))
								mid.add(new Lecture(arrSub[x-2][y-1],x,y,semester,1,2,1,tid));
								else
								mid.add(new Lecture(arrSub[x-2][y-1],x,y,semester,0,2,0,tid));
									
							}
							else
								mid.add(new Lecture());
							
						}
					}
				
				//mid.add(new JLabel(arrSub[x][y]));
				
			}
		}
		con.close();  
		}catch(Exception e){ e.printStackTrace();}  
	}
	public TeacherView(int semester,int td,boolean flag) {
		try{  
			this.tid=td;
			loginFlag=flag;
//			System.out.println(tid);
			//step1 load the driver class  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			  
			//step2 create  the connection object  
			Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:@localhost:1521:xe","system","jimmy3010");  
			  
			//step3 create the statement object  
//			while(rs.next())  
//			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getInt(3));  
			  
			//step5 close the connection object  
			

		setLayout(new BorderLayout());

		/*		add(upper,BorderLayout.NORTH);
		upper.setLayout(new FlowLayout());
		JComboBox<String> dept=new JComboBox<String>();
		dept.addItem("CS");
		upper.add(dept);
		sem.addItem("Sem 1");
		sem.addItem("Sem 2");
		sem.addItem("Sem 3");
		sem.addItem("Sem 4");
		sem.addItem("Sem 5");
		sem.addItem("Sem 6");
		sem.addItem("Sem 7");
		sem.addItem("Sem 8");
		upper.add(sem);
		sem.addActionListener(this);
*/		
		Border padding = BorderFactory.createEmptyBorder(50, 50, 50, 50);
		this.setBorder(padding);
		
		left.setLayout(new GridLayout(5,1));
		left_color.setLayout(new GridLayout(4,2,5,5));
		left_color.add(new JLabel("Regular          "));
		left_color.add(new Lec_color(1));
		left_color.add(new JLabel("Cancel           "));
		left_color.add(new Lec_color(2));
		left_color.add(new JLabel("New              "));
		left_color.add(new Lec_color(3));
		left_color.add(new JLabel("Swap             "));
		left_color.add(new Lec_color(4));
	//	msg.setLayout(new GridLayout(5,3));
		left.add(left_color);
		//left_button.setLayout(new GridLayout(3,1));
	//	left.add(cancel);
	//	left.add(swap);
	//	left.add(extra);
	//	left.add(find);
	//	cancel.addActionListener(this);
	//	swap.addActionListener(this);
	//	extra.addActionListener(this);
	//	find.addActionListener(this);
		//left.add(left_button);
		add(left,BorderLayout.WEST);
		
		//setting time table...
		end.setLayout(new FlowLayout());
		msg.setLayout(new FlowLayout());
		msg.add(message);
		msg.add(yesReq);
		msg.add(noReq);
		end.add(logout);
		msg.setSize(100,100);
		msg.setMinimumSize(new Dimension(100,100));
		end.add(msg);
		//end.add(logout);
		add(end,BorderLayout.SOUTH);
		logout.addActionListener(this);
		yesReq.addActionListener(this);
		noReq.addActionListener(this);
		mid.setLayout(new GridLayout(9,7,5,5));
		mid.setBackground(Color.WHITE);
		int k=0;
		String temp="LAB";
		String t2="";
		int semno=semester%2;
		String yr;
		
		
		
		
	/*	
		Statement stmt5=con.createStatement();  
		int count =countReq();
		for(int i=0;i<count ; i++){
			
		}
		
		*/
		String strm=countReq();
		message.setText(strm);
		
		
		
		
		for(int i=0;i<10;i++){
			for(int j=0;j<10;j++){
				arrSub[i][j]="----";
			}
		}
		//timtable
		for(int i=1;i<=7;i++){
			for(int j=1;j<8;j++){
				Statement stmt=con.createStatement();  
				Statement stmt2=con.createStatement();
				int dur=0;
				int type=111;
				int bnv=0;
				//step4 execute query
//					System.out.println("aloooooooooooooooooooooooooooooooooo");
				ResultSet rs=stmt.executeQuery("select * from subject where sub_id in (select sub_id from Lecture_master where day="+i+" and time="+j+" and T_ID="+td+" and mod(sem,2)="+semno+")");  
				ResultSet rs2=stmt2.executeQuery("select * from Lecture_master where day="+i+" and time="+j+" and T_ID="+td+" and mod(sem,2)="+semno+"");
			//	System.out.println("\n Inside teacher pane");
				while(rs2.next()) {
					bnv=rs2.getInt(2);
				//	System.out.println("\n Inside teacher33 pane");
					switch(bnv){
					case 1:yr="BE-I";break;
					case 2:yr="BE-II";break;
					case 3:yr="BE-III";break;
					case 4:yr="BE-IV";break;
					}
					dur=rs2.getInt(6);
					//System.out.println("DUR "+dur);
					type=rs2.getInt(7);
				if(rs2.getString(8).equals("420")) {
					//mid.add(new JLabel("free"));
					//System.out.println("Vaaggggggggaaaadiiiiiiiii");
					arrSub[j-1][i-1]="----";
				}
				if(rs2.getString(8).equals("421")) {
					//mid.add(new JLabel("free"));
					arrSub[j-1][i-1]="---";
				}
				else if(type==0){
					while(rs.next())
					temp=rs.getString(2)+"\n(LAB)";
					arrSub[j-1][i-1]=temp;
					if(dur==2) {
						arrSub[j][i-1]=temp;
					}
					else if(dur==3) {
						arrSub[j][i-1]=temp;
						arrSub[j+1][i-1]=temp;
					}
				}

				else {
				while(rs.next()){  
						temp=rs.getString(2);
						//System.out.println("new dur "+dur);
					
					while(dur>0){
						k=j;
						//mid.add(new JLabel(""+rs.getString(2)));
						arrSub[k-1][i-1]=temp;
						if(dur>1){
							
							arrSub[k-1][i-1]=temp;
								//System.out.println("temp printed");
						}
						dur--;
						k++;
					}
					if(rs2.getInt(10)==2){
						temp=rs.getString(2);
						arrSub[j-1][i-1]="extra"+temp;
						
						//this.colorMode=2;
						System.out.println("jjjjjjjjjjiaaloiiiiiiiiiiiiii.......now....");
					}
					if(rs2.getInt(10)==3){
						temp=rs.getString(2);
						arrSub[j-1][i-1]="swap"+temp;
						
						//this.colorMode=2;
						System.out.println("jjjjjjjjjjiaaloiiiiiiiiiiiiii.......now....");
					}
					
				}
				}
				}//while
				
			}
		}
		add(mid,BorderLayout.CENTER);
/*		for(int x=0;x<7;x++) {
			for(int y=0;y<6;y++) {
				System.out.print("\t\t"+arrSub[x][y]);
			}
			System.out.println();
		}
	*/	
		for(int x=0;x<=8;x++){
			for(int y=0;y<=6;y++){
				if(x==0) {
					switch(y) {
						case 0:
							mid.add( new Lecture("Time/Day"));
							break;
						case 1:
							mid.add(new Lecture("Monday"));
							break;
						case 2:
							mid.add(new Lecture("Tuesday"));
							break;
						case 3:
							mid.add(new Lecture("Wednesday"));
							break;
						case 4:
							mid.add(new Lecture("Thursday"));
							break;
						case 5:
							mid.add(new Lecture("Friday"));
							break;
						case 6:
							mid.add(new Lecture("Saturday"));
							break;		
					}
				}
				else if(x==5){
					if(y==0)
						mid.add(new Lecture("2:00 PM"));
					else
						mid.add(new Lecture("Recess"));}
				else if(x>0 && x<5){
					if(y==0) {
						switch(x) {
						case 1:
							mid.add(new Lecture("10:00 AM"));
							break;
						case 2:
							mid.add(new Lecture("11:00 AM"));
							break;
						case 3:
							mid.add(new Lecture("12:00 PM"));
							break;
						case 4:
							mid.add(new Lecture("1:00 PM"));
							break;
						case 5:
							mid.add(new Lecture("2:00 PM"));
							break;
						case 6:
							mid.add(new Lecture("2:30 PM"));
							break;
						case 7:
							mid.add(new Lecture("3:30 PM"));
							break;
						case 8:
							mid.add(new Lecture("4:30 PM"));
							break;
							}
						}else{
							if(arrSub[x-1][y-1]!=null) {
								if(getLoginMode() && !arrSub[x-1][y-1].equals("---")){
									if(arrSub[x-1][y-1].contains("extra")){
										String sub=arrSub[x-1][y-1].substring(5);
										mid.add(new Lecture(sub,x,y,semester,1,2,2,tid));
									}
									else if(arrSub[x-1][y-1].contains("swap")){
										String sub=arrSub[x-1][y-1].substring(4);
										mid.add(new Lecture(sub,x,y,semester,1,2,3,tid));
									}
									else{
										mid.add(new Lecture(arrSub[x-1][y-1],x,y,semester,1,2,0,tid));
									}
								}
							
								else if(arrSub[x-1][y-1].equals("---"))
								mid.add(new Lecture(arrSub[x-1][y-1],x,y,semester,1,2,1,tid));
								else
								mid.add(new Lecture(arrSub[x-1][y-1],x,y,semester,0,2,0,tid));
									
							}
							else
								mid.add(new Lecture());
							
							
						}
					}
				//	if(x>0 && x<5)
					//	mid.add(new JLabel(arrSub[x-1][y-1]));
					
					else if(x>5){
						if(y==0) {
							switch(x) {
							case 1:
								mid.add(new Lecture("10:00 AM"));
								break;
							case 2:
								mid.add(new Lecture("11:00 AM"));
								break;
							case 3:
								mid.add(new Lecture("12:00 PM"));
								break;
							case 4:
								mid.add(new Lecture("1:00 PM"));
								break;
							case 5:
								mid.add(new Lecture("2:00 PM"));
								break;
							case 6:
								mid.add(new Lecture("2:30 PM"));
								break;
							case 7:
								mid.add(new Lecture("3:30 PM"));
								break;
							case 8:
								mid.add(new Lecture("4:30 PM"));
								break;
							}
						}else{
							if(arrSub[x-2][y-1]!=null) {
								if(getLoginMode() && !arrSub[x-2][y-1].equals("---")){
									if(arrSub[x-2][y-1].contains("extra")){
										String sub=arrSub[x-2][y-1].substring(5);
										mid.add(new Lecture(sub,x,y,semester,1,2,2,tid));
									}
									else if(arrSub[x-2][y-1].contains("swap")){
										String sub=arrSub[x-2][y-1].substring(4);
										mid.add(new Lecture(sub,x,y,semester,1,2,3,tid));
									}
									else{
										mid.add(new Lecture(arrSub[x-2][y-1],x,y,semester,1,2,0,tid));
									}
								}
								else if(arrSub[x-2][y-1].equals("---"))
								mid.add(new Lecture(arrSub[x-2][y-1],x,y,semester,1,2,1,tid));
								else
								mid.add(new Lecture(arrSub[x-2][y-1],x,y,semester,0,2,0,tid));
									
							}
							else
								mid.add(new Lecture());
							
						}
					}
				
				//mid.add(new JLabel(arrSub[x][y]));
				
			}
		}
		con.close();  
		}catch(Exception e){ e.printStackTrace();}  
	}
	public void executeReq(String res){
		try{  
			//step1 load the driver class  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			 System.out.println("delete from swap_request where receive_t_id="+this.tid+""); 
			//step2 create  the connection object  
			Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:@localhost:1521:xe","system","jimmy3010");  
			ResultSet yes,no;
			Statement stmt=con.createStatement();  
			if(res.equals("yes")){
				int ansx=-1;
				CallableStatement cstmt = con.prepareCall("{? = call executeSwapReq(?)}");
				cstmt.registerOutParameter (1, Types.INTEGER);
			    cstmt.setString (2, this.tid+"");  // The name argument is the second ?
			    cstmt.execute ();
			    ansx = cstmt.getInt(1);
			    if(ansx==0){
					JOptionPane.showMessageDialog(this, "Lecture is swapped!");
					end.remove(msg);
					ResultSet rsu=stmt.executeQuery("truncate table resetLog");
					rsu=stmt.executeQuery("insert into resetLog values(sysdate);");
					
			    }
			    else{
			    	JOptionPane.showMessageDialog(this, "Cannot swap lecture!");
			    }
			}
			else{
				System.out.println("alau");
				no=stmt.executeQuery("delete from swap_request where receive_t_id='"+this.tid+"'");
				no=stmt.executeQuery("update lecture_master set lock_lec=0 where t_id='"+this.tid+"'");
				JOptionPane.showMessageDialog(this, "Request denied....");
			    
			}
			//step3 create the statement object  
			//if(res.equals("yes"))  
			//ResultSet rs=stmt.executeQuery("select * from test");  
			//else
			//ResultSet rs2=stmt.executeQuery("select * from test");  
			//while(rs.next())  
			//System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getInt(3));  
			  
			//step5 close the connection object  
			con.close();  
			  
			}catch(Exception e){ System.out.println(e);}  

	}
	public void actionPerformed(ActionEvent e) {
		System.out.println("Alloo");
		System.out.println(e.getActionCommand());
		if(e.getActionCommand().equals("Login")){
			//new TimeTable(1);
			//System.out.println("Alaukika");
			TimeTable t=new TimeTable(1,tid);
			t.setPane();
			
		}
		
		if(e.getActionCommand().equals("Yes")){
			
			this.executeReq("yes");
		}
		if(e.getActionCommand().equals("No")){
			end.remove(msg);
			this.executeReq("no");
		}
		
		if(e.getActionCommand().equals("Logout")){
			this.setVisible(false);
			getRootPane().setVisible(false);
			Welcome w = new Welcome();
			//TimeTable t = new TimeTable(1,2,false);
			//w.setPane(tid,t);
		}
		if(e.getActionCommand().equals("Cancel Lecture")){
			//System.out.println("jimmy");
			//cancelLecture();
			//System.out.println(mainPane3.getSelectedIndex());
			//mainPane3.setSelectedIndex(0);
			//JFrame teacher = new 
			//mainPane3.setTabComponentAt(1, new StudentView(6));
			//mainPane3.addTab("jimmy",new StudentView(1));
			//JFrame temp= new JFrame("Update");
			//temp.setVisible(true);
			//temp.setLayout(new FlowLayout());
			//temp.add(new StudentView(1));
			//this.removeAll();
			//this.setVisible(false);
			//this.remove(0);
		}
	}
	public String countReq(){
		//lec.setText("Pending...");
		String ans="no request";
		 try{  
			//step1 load the driver class  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			  
			//step2 create  the connection object  
			Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:@localhost:1521:xe","system","jimmy3010");  
			  
			//step3 create the statement object  
			Statement stmt=con.createStatement();  
			//boolean ans = false;
			CallableStatement cstmt = con.prepareCall("{? = call getRequest (?)}");
			
			cstmt.registerOutParameter (1, Types.LONGVARCHAR);

		    // We want to raise LESLIE's salary by 20,000
		    cstmt.setString (2, this.tid+"");  // The name argument is the second ?
		    cstmt.execute ();
		    ans = cstmt.getString(1);
			System.out.println(ans+"++++++++++++++++++++");
		    // Declare that the first ? is a return value of type Int
		    //cstmt.registerOutParameter (1, Types.BOOLEAN);  
			//System.out.println(cstmt+"jlk....................");
		    //step4 execute query  
//			ResultSet rs=stmt.executeQuery("select * from test");  
//			while(rs.next())  
//			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getInt(3));  
			  
			//step5 close the connection object  
			cstmt.close();
			con.close();  
			  
			}catch(Exception e){ System.out.println(e);}  
		    // Declare that the first ? is a return value of type Int
		    //cstmt.registerOutParameter (1, Types.INTEGER);
		 return ans;
	}

}
