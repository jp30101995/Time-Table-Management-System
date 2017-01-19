package WelcomeFrame;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class StudentView extends TimeTable implements ActionListener{
	Connection con=null;
	Statement stmt=null;
	ResultSet rs=null;
	JPanel upper = new JPanel();
	JPanel mid = new JPanel();
	JPanel left = new JPanel();
	JLabel lec = new JLabel();
	JPanel left_color = new JPanel();
	String[][] arrSub=new String[10][10];
	int semester;
	int canceled =-1;
	int colorMode = -1;
	JPanel base = new JPanel();
	JComboBox<String> sem=new JComboBox<String>();
	public StudentView(int semester) {
		this.semester=semester;
		try{  
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
		left.setLayout(new FlowLayout());
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
		//setting time table...
		mid.setLayout(new GridLayout(9,7,5,5));
		mid.setBackground(Color.white);
		add(left,BorderLayout.WEST);
		int k=0;
		String temp="LAB";
		String t2="";
		
		
		//timtable
		for(int i=1;i<=7;i++){
			for(int j=1;j<8;j++){
				Statement stmt=con.createStatement();  
				Statement stmt2=con.createStatement();
				int dur=0;
				int type=111;
				//step4 execute query 
				
				ResultSet rs=stmt.executeQuery("select * from subject where sub_id in (select sub_id from Lecture_master where day="+i+" and time="+j+" and sem="+semester+")");  
				ResultSet rs2=stmt2.executeQuery("select * from Lecture_master where day="+i+" and time="+j+" and sem="+semester+"");
				while(rs2.next()) {
					dur=rs2.getInt(6);
					type=rs2.getInt(7);
				if(rs2.getString(8).equals("420")) {
					//mid.add(new JLabel("free"));
					arrSub[j-1][i-1]="----";
				}
				if(rs2.getString(8).equals("421")) {
					//mid.add(new JLabel("free"));
					arrSub[j-1][i-1]="---";
				}
/*				if(rs2.getString(10).equals("2")){
					this.colorMode=2;
				}
*/				else if(type==0){
					while(rs.next()) {
						temp=rs.getString(2)+"\n(LAB)";
						//arrSub[j-1][i-1]=rs.getString(2)+"\n(LAB)";
						arrSub[j-1][i-1]=temp;
					}
					if(dur==2) {
						arrSub[j][i-1]=temp;;
					}
					else if(dur==3) {
						arrSub[j][i-1]=temp;
						arrSub[j+1][i-1]=temp;
					}					
				}
				else {
				while(rs.next()){  
						temp=rs.getString(2);
						
					
					while(dur>0){
						k=j;
						//mid.add(new JLabel(""+rs.getString(2)));
						arrSub[k-1][i-1]=temp;
						if(dur>1){
							
							arrSub[k-1][i-1]=temp;
								
						}
						dur--;
						k++;
					}
					if(rs2.getInt(10)==2){
						temp=rs.getString(2);
						arrSub[j-1][i-1]="extra"+temp;
						
						//this.colorMode=2;
						System.out.println("jjjjjsadffajjjjjiiiiiiiiiiiiiii.......now....");
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
							mid.add(new Lecture("Time/Day"));
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
							//System.out.println(arrSub[x-1][y-1]);
							//if(arrSub[x-1][y-1].equals(null))
							if(arrSub[x-1][y-1]!=null){
								if(getLoginMode() && !arrSub[x-1][y-1].equals("---")){
									if(arrSub[x-1][y-1].contains("extra")){
										String sub=arrSub[x-1][y-1].substring(5);
										mid.add(new Lecture(sub,x,y,semester,1,1,0,loginTeacherId));
									}else{
										mid.add(new Lecture(arrSub[x-1][y-1],x,y,semester,1,1,0,loginTeacherId));
									}
								}
								else if(arrSub[x-1][y-1]=="---")
								mid.add(new Lecture(arrSub[x-1][y-1],x,y,semester,1,1,1));
								else 
								mid.add(new Lecture(arrSub[x-1][y-1],x,y,semester,0,1));
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
							//System.out.println(arrSub[x-2][y-1]);
							//if(arrSub[x-2][y-1].equals(null))
							if(arrSub[x-2][y-1]!=null){
								if(getLoginMode() && !arrSub[x-2][y-1].equals("---")){
									if(arrSub[x-2][y-1].contains("extra")){
										String sub=arrSub[x-2][y-1].substring(5);
										mid.add(new Lecture(sub,x,y,semester,1,1,0,loginTeacherId));
									}else{
										mid.add(new Lecture(arrSub[x-2][y-1],x,y,semester,1,1,0,loginTeacherId));
									}
								}
								else if(arrSub[x-2][y-1]=="---")
								mid.add(new Lecture(arrSub[x-2][y-1],x,y,semester,1,1,1));
								else
								mid.add(new Lecture(arrSub[x-2][y-1],x,y,semester,0,1));
									
							}else
								mid.add(new Lecture());
						}
					}
				
				//mid.add(new JLabel(arrSub[x][y]));
				
			}
		}
		con.close();  
		}catch(Exception e){ e.printStackTrace();}  
		
	}
	public StudentView(int semester,boolean flag) {
		System.out.println("jimmy.................///////////////");
		this.semester=semester;
		loginFlag=flag;
		try{  
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
		left.setLayout(new FlowLayout());
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
		//setting time table...
		mid.setLayout(new GridLayout(9,7,5,5));
		mid.setBackground(Color.white);
		add(left,BorderLayout.WEST);
		int k=0;
		String temp="LAB";
		String t2="";
		
		
		//timtable
		for(int i=1;i<=7;i++){
			for(int j=1;j<8;j++){
				Statement stmt=con.createStatement();  
				Statement stmt2=con.createStatement();
				Statement stmt3=con.createStatement();
				int dur=0;
				int type=111;
				//step4 execute query 
				
				ResultSet rs=stmt.executeQuery("select * from subject where sub_id in (select sub_id from Lecture_master where day="+i+" and time="+j+" and sem="+semester+")");  
				ResultSet rs2=stmt2.executeQuery("select * from Lecture_master where day="+i+" and time="+j+" and sem="+semester+"");
				while(rs2.next()) {
					dur=rs2.getInt(6);
					type=rs2.getInt(7);
				if(rs2.getString(8).equals("420")) {
					//mid.add(new JLabel("free"));
					arrSub[j-1][i-1]="----";
				}
				if(rs2.getString(8).equals("421")) {
					//mid.add(new JLabel("free"));
					arrSub[j-1][i-1]="---";
				}
				else if(type==0){
					while(rs.next()) {
						temp=rs.getString(2)+"\n(LAB)";
						//arrSub[j-1][i-1]=rs.getString(2)+"\n(LAB)";
						arrSub[j-1][i-1]=temp;
					}
					if(dur==2) {
						arrSub[j][i-1]=temp;;
					}
					else if(dur==3) {
						arrSub[j][i-1]=temp;
						arrSub[j+1][i-1]=temp;
					}					
				}
				else {
				while(rs.next()){  
						temp=rs.getString(2);
						
					
					while(dur>0){
						k=j;
						//mid.add(new JLabel(""+rs.getString(2)));
						arrSub[k-1][i-1]=temp;
						if(dur>1){
							
							arrSub[k-1][i-1]=temp;
								
						}
						dur--;
						k++;
					}
					if(rs2.getInt(10)==2){
						temp=rs.getString(2);
						arrSub[j-1][i-1]="extra"+temp;
						
						//this.colorMode=2;
						System.out.println("jjjjjjjjjjjlkiiiiiiiiiiiiiii.......now....");
					}
					if(rs2.getInt(10)==3){
						temp=rs.getString(2);
						arrSub[j-1][i-1]="swap"+temp;
						
						//this.colorMode=2;
						System.out.println("jjjjjjjjjjjlkiiiiiiiiiiiiiii.......now....");
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
							mid.add(new Lecture("Time/Day"));
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
							//System.out.println(arrSub[x-1][y-1]);
							//if(arrSub[x-1][y-1].equals(null))
							if(arrSub[x-1][y-1]!=null){
								System.out.println("lecture not null"+arrSub[x-1][y-1]);
								if(!arrSub[x-1][y-1].equals("---")){
									System.out.println(arrSub[x-1][y-1]+"lllll------------------------");
									if(arrSub[x-1][y-1].contains("extra")){
										String sub=arrSub[x-1][y-1].substring(5);
										System.out.println(sub+"-----------------------");
										mid.add(new Lecture(sub,x,y,semester,1,1,2,loginTeacherId));
									}
									else if(arrSub[x-1][y-1].contains("swap")){
										String sub=arrSub[x-1][y-1].substring(4);
										System.out.println(sub+"-----------------------");
										mid.add(new Lecture(sub,x,y,semester,1,1,3,loginTeacherId));
									}
									else{
										mid.add(new Lecture(arrSub[x-1][y-1],x,y,semester,1,1,0,loginTeacherId));
									}
									
								}
								
								else if(arrSub[x-1][y-1]=="---")
								mid.add(new Lecture(arrSub[x-1][y-1],x,y,semester,1,1,1));
								else
								mid.add(new Lecture(arrSub[x-1][y-1],x,y,semester,0,1));
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
							//System.out.println(arrSub[x-2][y-1]);
							//if(arrSub[x-2][y-1].equals(null))
							if(arrSub[x-2][y-1]!=null){
								System.out.println("after recess..............");
								if(!getLoginMode() && !arrSub[x-2][y-1].equals("---")){
									System.out.println(arrSub[x-2][y-1]+"lllll------------------------");
									if(arrSub[x-2][y-1].contains("extra")){
										String sub=arrSub[x-2][y-1].substring(5);
										System.out.println(sub+"------------------------");
										mid.add(new Lecture(sub,x,y,semester,1,1,2,loginTeacherId));
									}
									else if(arrSub[x-2][y-1].contains("swap")){
										String sub=arrSub[x-2][y-1].substring(4);
										System.out.println(sub+"------------------------");
										mid.add(new Lecture(sub,x,y,semester,1,1,3,loginTeacherId));
									}
									else{
										mid.add(new Lecture(arrSub[x-2][y-1],x,y,semester,1,1,0,loginTeacherId));
									}
								}
								else if(arrSub[x-2][y-1].equals("---"))
								mid.add(new Lecture(arrSub[x-2][y-1],x,y,semester,1,1,1));
								else
								mid.add(new Lecture(arrSub[x-2][y-1],x,y,semester,0,1));
									
							}else
								mid.add(new Lecture());
						}
					}
				
				//mid.add(new JLabel(arrSub[x][y]));
				
			}
		}
		con.close();  
		}catch(Exception e){ e.printStackTrace();}  
		
	}
	public StudentView(int semester,int teacherId,boolean flag) {
		loginTeacherId=teacherId;
		this.semester=semester;
		loginFlag=flag;
		try{  
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
		left.setLayout(new FlowLayout());
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
		//setting time table...
		mid.setLayout(new GridLayout(9,7,5,5));
		mid.setBackground(Color.white);
		add(left,BorderLayout.WEST);
		int k=0;
		String temp="LAB";
		String t2="";
		
		
		//timtable
		for(int i=1;i<=7;i++){
			for(int j=1;j<8;j++){
				Statement stmt=con.createStatement();  
				Statement stmt2=con.createStatement();
				Statement stmt3=con.createStatement();
				int dur=0;
				int type=111;
				//step4 execute query 
				
				ResultSet rs=stmt.executeQuery("select * from subject where sub_id in (select sub_id from Lecture_master where day="+i+" and time="+j+" and sem="+semester+")");  
				ResultSet rs2=stmt2.executeQuery("select * from Lecture_master where day="+i+" and time="+j+" and sem="+semester+"");
				while(rs2.next()) {
					dur=rs2.getInt(6);
					type=rs2.getInt(7);
				//if(type==2){	
				if(rs2.getString(8).equals("420")) {
					//mid.add(new JLabel("free"));
					arrSub[j-1][i-1]="----";
				}
				if(rs2.getString(8).equals("421")) {
					//mid.add(new JLabel("free"));
					arrSub[j-1][i-1]="---";
				}

				else if(type==0){
					while(rs.next()) {

						temp=rs.getString(2)+"\n(LAB)";
						//arrSub[j-1][i-1]=rs.getString(2)+"\n(LAB)";
						arrSub[j-1][i-1]=temp;
					}
					if(dur==2) {
						arrSub[j][i-1]=temp;;
					}
					else if(dur==3) {
						arrSub[j][i-1]=temp;
						arrSub[j+1][i-1]=temp;
					}
					
				}
				else {
				while(rs.next()){  

						temp=rs.getString(2);
					
					while(dur>0){
						k=j;
						//mid.add(new JLabel(""+rs.getString(2)));
						arrSub[k-1][i-1]=temp;
						if(dur>1){
							
							arrSub[k-1][i-1]=temp;
								
						}
						dur--;
						k++;
					}
					if(rs2.getInt(10)==2){
							temp=rs.getString(2);
							arrSub[j-1][i-1]="extra"+temp;
							
							//this.colorMode=2;
							System.out.println("jjjjjjjjSddsaffgagghhjjiiiiiiiiiiiiiii.......now....");
					}
					if(rs2.getInt(10)==3){
						temp=rs.getString(2);
						arrSub[j-1][i-1]="swap"+temp;
						
						//this.colorMode=2;
						System.out.println("jjjjjjjjSddsaffgagghhjjiiiiiiiiiiiiiii.......now....");
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
							mid.add(new Lecture("Time/Day"));
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
							//System.out.println(arrSub[x-1][y-1]);
							//if(arrSub[x-1][y-1].equals(null))
							if(arrSub[x-1][y-1]!=null){
								if(getLoginMode() && !arrSub[x-1][y-1].equals("---")){//normal
									System.out.println("Subject..............before if..........................."+arrSub[x-1][y-1]);
									if(arrSub[x-1][y-1].contains("extra")){
										String sub=arrSub[x-1][y-1].substring(5);
										System.out.println("Subject........................................."+sub);
										mid.add(new Lecture(sub,x,y,semester,1,1,2,loginTeacherId));
									}
									else if(arrSub[x-1][y-1].contains("swap")){
										String sub=arrSub[x-1][y-1].substring(4);
										System.out.println("Subject........................................."+sub);
										mid.add(new Lecture(sub,x,y,semester,1,1,3,loginTeacherId));
									}
									else{
										System.out.println("Subject.........................................");
										mid.add(new Lecture(arrSub[x-1][y-1],x,y,semester,1,1,0,loginTeacherId));
									}
								}
								//System.out.println("before pass"+loginTeacherId);
								
								//System.out.println("alaukika called in subject");}
								else if(arrSub[x-1][y-1]=="---")//cancel
								mid.add(new Lecture(arrSub[x-1][y-1],x,y,semester,1,1,1,loginTeacherId));
								else
								mid.add(new Lecture(arrSub[x-1][y-1],x,y,semester,0,1));
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
							//System.out.println(arrSub[x-2][y-1]);
							//if(arrSub[x-2][y-1].equals(null))
							if(arrSub[x-2][y-1]!=null){
								if(getLoginMode() && !arrSub[x-2][y-1].equals("---")){
									System.out.println("Subject..............before if..........................."+arrSub[x-2][y-1]);
									if(arrSub[x-2][y-1].contains("extra")){
										String sub=arrSub[x-2][y-1].substring(5);
										mid.add(new Lecture(sub,x,y,semester,1,1,2,loginTeacherId));
									}
									else if(arrSub[x-2][y-1].contains("swap")){
										System.out.println("ALaukika testin****&&&&&&&&&&&&********");
										String sub=arrSub[x-2][y-1].substring(4);
										mid.add(new Lecture(sub,x,y,semester,1,1,3,loginTeacherId));
									}
									else{
										System.out.println("bamboooooo ALaukika testin****&&&&&&&&&&&&********");
										mid.add(new Lecture(arrSub[x-2][y-1],x,y,semester,1,1,0,loginTeacherId));
									}
								}
								else if(arrSub[x-2][y-1].equals("---"))
								mid.add(new Lecture(arrSub[x-2][y-1],x,y,semester,1,1,1,loginTeacherId));
								else
								mid.add(new Lecture(arrSub[x-2][y-1],x,y,semester,0,1));
									
							}else
								mid.add(new Lecture());
						}
					}
				
				//mid.add(new JLabel(arrSub[x][y]));
				
			}
		}
		con.close();  
		}catch(Exception e){ e.printStackTrace();}  
		
	}
/*	public JPanel setStudentView(){
		try{  
			//step1 load the driver class  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			  
			//step2 create  the connection object  
			Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:@localhost:1521:xe","system","jimmy3010");  
			  
			//step3 create the statement object  
//			while(rs.next())  
//			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getInt(3));  
			  
			//step5 close the connection object  
			  
		base.setLayout(new BorderLayout());
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
/*		Border padding = BorderFactory.createEmptyBorder(50, 50, 50, 50);
		base.setBorder(padding);
		left.setLayout(new FlowLayout());
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
		//setting time table...
		mid.setLayout(new GridLayout(9,7,5,5));
		mid.setBackground(Color.white);
		base.add(left,BorderLayout.WEST);
		int k=0;
		String temp="LAB";
		String t2="";
		
		
		//timtable
		for(int i=1;i<=7;i++){
			for(int j=1;j<8;j++){
				Statement stmt=con.createStatement();  
				Statement stmt2=con.createStatement();
				int dur=0;
				int type=111;
				//step4 execute query 
				
				ResultSet rs=stmt.executeQuery("select * from subject where sub_id in (select sub_id from Lecture_master where day="+i+" and time="+j+" and sem="+semester+")");  
				ResultSet rs2=stmt2.executeQuery("select * from Lecture_master where day="+i+" and time="+j+" and sem="+semester+"");
				while(rs2.next()) {
					dur=rs2.getInt(6);
					type=rs2.getInt(7);
				if(rs2.getString(8).equals("420")) {
					//mid.add(new JLabel("free"));
					arrSub[j-1][i-1]="----";
				}
				else if(type==0){
					while(rs.next()) {
						temp=rs.getString(2)+"\n(LAB)";
						//arrSub[j-1][i-1]=rs.getString(2)+"\n(LAB)";
						arrSub[j-1][i-1]=temp;
					}
					if(dur==2) {
						arrSub[j][i-1]=temp;;
					}
					else if(dur==3) {
						arrSub[j][i-1]=temp;
						arrSub[j+1][i-1]=temp;
					}					
				}
				else {
				while(rs.next()){  
						temp=rs.getString(2);
						
					
					while(dur>0){
						k=j;
						//mid.add(new JLabel(""+rs.getString(2)));
						arrSub[k-1][i-1]=temp;
						if(dur>1){
							
							arrSub[k-1][i-1]=temp;
								
						}
						dur--;
						k++;
					}
				}
				}
				}//while
				
			}
		}
		base.add(mid,BorderLayout.CENTER);
/*		for(int x=0;x<7;x++) {
			for(int y=0;y<6;y++) {
				System.out.print("\t\t"+arrSub[x][y]);
			}
			System.out.println();
		}
	*/	
/*		for(int x=0;x<=8;x++){
			for(int y=0;y<=6;y++){
				if(x==0) {
					switch(y) {
						case 0:
							mid.add(new Lecture("Time/Day"));
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
							//System.out.println(arrSub[x-1][y-1]);
							//if(arrSub[x-1][y-1].equals(null))
							if(arrSub[x-1][y-1]!=null)
								mid.add(new Lecture(arrSub[x-1][y-1],x,y,semester));

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
							//System.out.println(arrSub[x-2][y-1]);
							//if(arrSub[x-2][y-1].equals(null))
							if(arrSub[x-2][y-1]!=null)
								mid.add(new Lecture(arrSub[x-2][y-1],x,y,semester));
							else
								mid.add(new Lecture());
						}
					}
				
				//mid.add(new JLabel(arrSub[x][y]));
				
			}
		}
		con.close();  
		}catch(Exception e){ e.printStackTrace();}  
		return base;
	}*/
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getSource());
	}

}
