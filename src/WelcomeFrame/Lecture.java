package WelcomeFrame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Lecture extends JLabel implements MouseListener{
	
	String lec="----";
	Color lecColor;
	int day = -1;
	int time = - 1;
	int sem=-1;
	int teacherId=-1;
	boolean loginFlag = false;
	boolean cancelMode = false;
	boolean swapMode = false;
	boolean extraMode = false;
	int mode=-1;
	int view=-1;
	int cancel = -1;
	int colorFlag=-1;
	public Lecture(){
		this.setForeground(Color.black);
		//this.lec=lec;
		//this.setText(lec);
	//	this.setHorizontalAlignment(CENTER);
		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
		this.setBorder(border);
		//compound = BorderFactory.createBevelBorder(1,Color.black, Color.black);
		this.setOpaque(true);
		this.setBackground(Color.green);
		this.addMouseListener(this);
	}
	public Lecture(String lec,int i,int j,int s){
		sem=s;
		day=i;
		time=j;
		this.setForeground(Color.black);
		this.lec=lec;
		this.setText(lec);
		this.setHorizontalAlignment(CENTER);
		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
		this.setBorder(border);
		//compound = BorderFactory.createBevelBorder(1,Color.black, Color.black);
		this.setOpaque(true);
		this.setBackground(Color.white);
		//System.out.println(lec);
		this.addMouseListener(this);
		if(lec.equals("Recess")){
			this.setOpaque(true);
			this.setBackground(new Color(192,192,192));
		}
		
		if(lec.equals("Time/Day") || lec.equals("Monday") || lec.equals("Tuesday") || lec.equals("Wednesday") || lec.equals("Thursday")||lec.equals("Friday")||lec.equals("Saturday")){
			this.setOpaque(true);
			this.setBackground(new Color(192,192,192));
		}
		else if(lec.contains(":")){
			this.setOpaque(true);
			this.setBackground(new Color(192,192,192));
		}
		else if(lec.equals("----")){
			this.setOpaque(true);
			this.setBackground(Color.WHITE);
		}
		else if(lec.isEmpty() || lec.equals("null")){
			
			this.setOpaque(true);
			this.setBackground(Color.WHITE);
			
		}
		
	}
	public Lecture(String lec,int i,int j,int s,int mode){
		this.mode=mode;
		sem=s;
		day=i;
		time=j;
		this.setForeground(Color.black);
		this.lec=lec;
		this.setText(lec);
		this.setHorizontalAlignment(CENTER);
		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
		this.setBorder(border);
		//compound = BorderFactory.createBevelBorder(1,Color.black, Color.black);
		this.setOpaque(true);
		this.setBackground(Color.white);
		//System.out.println(lec);
		this.addMouseListener(this);
		if(lec.equals("Recess")){
			this.setOpaque(true);
			this.setBackground(new Color(192,192,192));
		}
		
		if(lec.equals("Time/Day") || lec.equals("Monday") || lec.equals("Tuesday") || lec.equals("Wednesday") || lec.equals("Thursday")||lec.equals("Friday")||lec.equals("Saturday")){
			this.setOpaque(true);
			this.setBackground(new Color(192,192,192));
		}
		else if(lec.contains(":")){
			this.setOpaque(true);
			this.setBackground(new Color(192,192,192));
		}
		else if(lec.equals("----")){
			this.setOpaque(true);
			this.setBackground(Color.WHITE);
		}
		else if(lec.isEmpty() || lec.equals("null")){
			
			this.setOpaque(true);
			this.setBackground(Color.WHITE);
			
		}
		
	}
	public Lecture(String lec,int j,int i,int s,int mode,int view){
		this.mode=mode;//login 
		this.view=view;//student....teacher
		System.out.println("lllakakkdkd : "+view);
		sem=s;
		day=i;
		time=j;
		this.setForeground(Color.black);
		this.lec=lec;
		this.setText(lec);
		this.setHorizontalAlignment(CENTER);
		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
		this.setBorder(border);
		//compound = BorderFactory.createBevelBorder(1,Color.black, Color.black);
		this.setOpaque(true);
		this.setBackground(Color.white);
		//System.out.println(lec);
		this.addMouseListener(this);
		if(lec.equals("Recess")){
			this.setOpaque(true);
			this.setBackground(new Color(192,192,192));
		}
		
		if(lec.equals("Time/Day") || lec.equals("Monday") || lec.equals("Tuesday") || lec.equals("Wednesday") || lec.equals("Thursday")||lec.equals("Friday")||lec.equals("Saturday")){
			this.setOpaque(true);
			this.setBackground(new Color(192,192,192));
		}
		else if(lec.contains(":")){
			this.setOpaque(true);
			this.setBackground(new Color(192,192,192));
		}
		else if(lec.equals("----")){
			this.setOpaque(true);
			this.setBackground(Color.WHITE);
		}
		else if(lec.isEmpty() || lec.equals("null")){
			
			this.setOpaque(true);
			this.setBackground(Color.WHITE);
			
		}
		
	}
	public Lecture(String lec,int j,int i,int s,int mode,int view,int cancelFlag){
		
		this.cancel=cancelFlag;
		this.mode=mode;//login 
		this.view=view;//student....teacher
		System.out.println("lllakakkdkd : "+view);
		sem=s;
		day=i;
		time=j;
		this.setForeground(Color.black);
		this.lec=lec;
		this.setText(lec);
		this.setHorizontalAlignment(CENTER);
		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
		this.setBorder(border);
		//compound = BorderFactory.createBevelBorder(1,Color.black, Color.black);
		this.setOpaque(true);
		this.setBackground(Color.white);
		//System.out.println(lec);
		this.addMouseListener(this);
		if(lec.equals("Recess")){
			this.setOpaque(true);
			this.setBackground(new Color(192,192,192));
		}
		
		if(lec.equals("Time/Day") || lec.equals("Monday") || lec.equals("Tuesday") || lec.equals("Wednesday") || lec.equals("Thursday")||lec.equals("Friday")||lec.equals("Saturday")){
			this.setOpaque(true);
			this.setBackground(new Color(192,192,192));
		}
		else if(lec.contains(":")){
			this.setOpaque(true);
			this.setBackground(new Color(192,192,192));
		}
		else if(lec.equals("----")){
			this.setOpaque(true);
			this.setBackground(Color.WHITE);
		}
		else if(lec.isEmpty() || lec.equals("null")){
			
			this.setOpaque(true);
			this.setBackground(Color.WHITE);
			
		}
		if(this.cancel==1){
			this.setOpaque(true);
			this.setBackground(Color.red);
		}
		
	}
	public Lecture(String lec,int j,int i,int s,int mode,int view,int colorFlag,int tid){
		//System.out.println("jjjjjjjaaaaaaaaaaaaddddddddddddddiiiiiiiiiiiiiii");
		this.teacherId=tid;
		//System.out.println("Alaukika needs tid: "+this.teacherId+lec);
		this.colorFlag=colorFlag;
		this.mode=mode;//login 
		this.view=view;//student....teacher
		//System.out.println("lllakakkdkd : "+view);
		checkPending();
		sem=s;
		day=i;
		time=j;
		if(time>4) time-=1;
		this.setForeground(Color.black);
		this.lec=lec;
		this.setText(lec);
		this.setHorizontalAlignment(CENTER);
		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
		this.setBorder(border);
		//compound = BorderFactory.createBevelBorder(1,Color.black, Color.black);
		this.setOpaque(true);
		this.setBackground(Color.white);
		//System.out.println(lec);
		this.addMouseListener(this);
		if(lec.equals("Recess")){
			this.setOpaque(true);
			this.setBackground(new Color(192,192,192));
		}
		
		if(lec.equals("Time/Day") || lec.equals("Monday") || lec.equals("Tuesday") || lec.equals("Wednesday") || lec.equals("Thursday")||lec.equals("Friday")||lec.equals("Saturday")){
			this.setOpaque(true);
			this.setBackground(new Color(192,192,192));
		}
		else if(lec.contains(":")){
			this.setOpaque(true);
			this.setBackground(new Color(192,192,192));
		}
		else if(lec.equals("----")){
			this.setOpaque(true);
			this.setBackground(Color.WHITE);
		}
		else if(lec.isEmpty() || lec.equals("null")){
			
			this.setOpaque(true);
			this.setBackground(Color.WHITE);
			
		}
		if(this.cancel==1){
			this.setOpaque(true);
			this.setBackground(Color.red);
		}
		if(colorFlag==1){
			this.setOpaque(true);
			this.setBackground(Color.red);
		}
		
		if(colorFlag==2){
			this.setOpaque(true);
			this.setBackground(Color.green);
		}
		if(colorFlag==3){
			this.setOpaque(true);
			this.setBackground(Color.yellow);
		}
	}
	public void checkPending(){
		
	}
	public int getColorMode(){
		int color_flag=-1;
		try{  
			//step1 load the driver class  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			  
			//step2 create  the connection object  
			Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:@localhost:1521:xe","system","jimmy3010");  
			  
			//step3 create the statement object  
			Statement stmt=con.createStatement();  
			  
			//step4 execute query  
			ResultSet rs=stmt.executeQuery("select change from lecture_master where day="+this.day+" and time="+this.time+" and sem="+this.sem+"");  
			while(rs.next())  
			//System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getInt(3));  
			  
			//step5 close the connection object  
			con.close();  
			  
			}catch(Exception e){ System.out.println(e);}  
		return color_flag;
	}
	public Lecture(String lec) {
		this.setForeground(Color.black);
		this.lec=lec;
		this.setText(lec);
		this.setHorizontalAlignment(CENTER);
		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
		this.setBorder(border);
		//compound = BorderFactory.createBevelBorder(1,Color.black, Color.black);
		this.setOpaque(true);
		this.setBackground(Color.white);
		//System.out.println(lec);
		this.addMouseListener(this);
		if(lec.equals("Recess")){
			this.setOpaque(true);
			this.setBackground(new Color(192,192,192));
		}
		
		if(lec.equals("Time/Day") || lec.equals("Monday") || lec.equals("Tuesday") || lec.equals("Wednesday") || lec.equals("Thursday")||lec.equals("Friday")||lec.equals("Saturday")){
			this.setOpaque(true);
			this.setBackground(new Color(192,192,192));
		}
		else if(lec.contains(":")){
			this.setOpaque(true);
			this.setBackground(new Color(192,192,192));
		}
		else if(lec.equals("----")){
			this.setOpaque(true);
			this.setBackground(Color.WHITE);
		}
		else if(lec.isEmpty() || lec.equals("null")){
			
			this.setOpaque(true);
			this.setBackground(Color.WHITE);
			
		}

	}
	public void setLogin(){
		this.loginFlag=true;
	}
	public boolean getLogin(){
		return loginFlag;
	}
	public void setCancelOn(){
		cancelMode=true;
	}
	public void setSwapOn(){
		swapMode=true;
	}
	public void setExtraOn(){
		extraMode=true;
	}
	public void setCancelOff(){
		cancelMode=false;
	}
	public void setSwapOff(){
		swapMode=false;
	}
	public void setExtraOff(){
		extraMode=false;
	}
	public boolean getCancel(){
		return cancelMode;
	}
	public boolean getSwap(){
		return swapMode;
	}
	public boolean getExtra(){
		return extraMode;
	}
	public Lecture getLec(){
		return this;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		JLabel l=(JLabel)e.getSource();
		System.out.println(l.getText());
/*		if(this.getCancel()){
			this.setOpaque(true);
			this.setBackground(Color.red);
		}
		if(this.getSwap()){
			this.setOpaque(true);
			this.setBackground(Color.yellow);
		}
		if(this.getExtra()){
			this.setOpaque(true);
			this.setBackground(Color.green);
		}
*/		if(mode==1){
			String[] values1 = {"Cancel", "Swap", "Extra"};
			String[] values2 = {"Swap"};
			String[] values3 = {"Extra"};
			String[] values4 = {"Cancel"};
			System.out.println("view : "+view);
			if(view==1){
			if(l.getText().equals("----")){
				Object selected = JOptionPane.showInputDialog(null, "Select Yout Option", "Selection", JOptionPane.DEFAULT_OPTION, null, values3, "0");
				update(selected);
			}
			else if(l.getText().contains("LAB")){
				Object selected = JOptionPane.showInputDialog(null, "Select Yout Option", "Selection", JOptionPane.DEFAULT_OPTION, null, values4, "0");
				update(selected);
			}
			else if(l.getText().equals("---")){
				System.out.println("jiiiilakdldkdo...................................");
				Object selected = JOptionPane.showInputDialog(null, "Select Yout Option", "Selection", JOptionPane.DEFAULT_OPTION, null, values3, "0");
				update(selected);
			}
			else if(!(l.getText().equals("Recess")) || !(l.getText().contains(":")) || !(l.getText().contains("day")) || !(l.getText().contains("/"))){
				Object selected = JOptionPane.showInputDialog(null, "Select Yout Option", "Selection", JOptionPane.DEFAULT_OPTION, null, values2, "0");
				update(selected);
			}
			}
			else if(view==2){
			if(l.getText().contains("LAB")){
				Object selected = JOptionPane.showInputDialog(null, "Select Yout Option", "Selection", JOptionPane.DEFAULT_OPTION, null, values4, "0");
				update(selected);
			}
			if(l.getText().equals("---")){
				//Object selected = JOptionPane.showInputDialog(null, "Select Yout Option", "Selection", JOptionPane.DEFAULT_OPTION, null, values4, "0");
				//update(selected);
			}
			
			else if(!(l.getText().equals("----")) && (!(l.getText().equals("Recess")) || !(l.getText().contains(":")) || !(l.getText().contains("day")) || !(l.getText().contains("/")))){
//				System.out.println("jiiiilakdldkdo...................................");
				Object selected = JOptionPane.showInputDialog(null, "Select Yout Option", "Selection", JOptionPane.DEFAULT_OPTION, null, values4, "0");
				update(selected);
			}
			
			}
//			Object selected = JOptionPane.showInputDialog(null, "Select Yout Option", "Selection", JOptionPane.DEFAULT_OPTION, null, values1, "0");
//			System.out.println("jiiiiiiiiiii"+selected);
		}
		/*if(l.getText().equals("Maths-I")){
			System.out.println(this.day+" "+this.time);
		}*/
	}
	public void update(Object o){
		System.out.println(o);
		if(o.toString().equals("Cancel")){
			cancelLecture(this);
		}
		
		else if(o.toString().equals("Swap")){
			String[] days=new String[7];
			int ans=-1;
		    int count=0;			
		    try{  
				//step1 load the driver class  
				Class.forName("oracle.jdbc.driver.OracleDriver");  
				  
				//step2 create  the connection object  
				Connection con=DriverManager.getConnection(  
				"jdbc:oracle:thin:@localhost:1521:xe","system","jimmy3010");  
				  
				//step3 create the statement object  
				Statement stmt=con.createStatement();  
				  
				//step4 execute query  
//				ResultSet rs=stmt.executeQuery("select * from test");  
//				while(rs.next())  
//				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getInt(3));  
				for(int i=1;i<=6;i++){
				CallableStatement cstmt = con.prepareCall("{? = call checkDay(?, ? ,?)}");
				 System.out.println(ans+"ans......llllllllllllllll.....");
				  
				cstmt.registerOutParameter (1, Types.INTEGER);

			    // We want to raise LESLIE's salary by 20,000
			    cstmt.setInt (2, i);  // The name argument is the second ?
				 System.out.println(ans+"ans......llllllllhjhugugllllllll.....");
			    cstmt.setInt (3, this.sem);  // The name argument is the second ?
				 System.out.println(ans+"ans......lllllllllllllkjlkjjklllll.....");
			    cstmt.setInt (4, this.teacherId);  // The name argument is the second ?
				 System.out.println(ans+"ans......lllllllljkajsjskajkallllllll.....");
				    cstmt.execute ();
		
				 ans = cstmt.getInt(1);
				 System.out.println(ans+"ans......lllllllllokajjskkaskkalllllllll.....");
			    System.out.println(ans+"ans...........");
			    cstmt.close();
			    

				if(ans>0 && i==1){
					days[count]="Monday";
					count++;
				}
				if(ans>0 && i==2){
					days[count]="Tuesday";
					count++;
				}
				if(ans>0 && i==3){
					days[count]="Wednesday";
					count++;
				}
				if(ans>0 && i==4){
					days[count]="Thursday";
					count++;
				}
				if(ans>0 && i==5){
					days[count]="Friday";
					count++;
				}
				if(ans>0 && i==6){
					days[count]="Saturday";
					count++;
				}
			    }
				for(int i=0;i<7;i++){
					System.out.println(days[i]);
				}
				//step5 close the connection object  
				con.close();  
				  
				}catch(Exception e){ System.out.println(e);}  
				Object selected = JOptionPane.showInputDialog(null, "Select Yout Option", "Selection", JOptionPane.DEFAULT_OPTION, null, days, "0");
				System.out.println(selected);

			swapLecture(this,selected);
	
		}
		else{
			extraLecture(this);
		}
	}
	public void updateDB(){
		try{  
			//step1 load the driver class  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			  
			//step2 create  the connection object  
			Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:@localhost:1521:xe","system","jimmy3010");  
			  
			//step3 create the statement object  
			Statement stmt=con.createStatement();  
			  
			//step4 execute query  
		//	ResultSet rs=stmt.executeQuery("truncate table resetLog");
			
			ResultSet rs=stmt.executeQuery("update resetLog set lastupdate=sysdate");
			rs=stmt.executeQuery("commit");
			//while(rs.next())  
			//System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getInt(3));  
			  
			//step5 close the connection object  
			con.close();  
			  
			}catch(Exception e){ System.out.println(e);}  
		
	}
	public void cancelLecture(Lecture lec){
		try{  
			System.out.println(this.day+"    "+this.time);
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:@localhost:1521:xe","system","jimmy3010");  
			Statement stmt=con.createStatement();  
			Calendar calendar = Calendar.getInstance();
			int day = calendar.get(Calendar.DAY_OF_WEEK);
			int dayno = 0;
			switch (day) {
			    case Calendar.SUNDAY:dayno=0; break;
			    case Calendar.MONDAY:dayno=1;break;
			    case Calendar.TUESDAY:dayno=2;break;
			    case Calendar.WEDNESDAY:dayno=3;break;
			    case Calendar.THURSDAY:dayno=4;break;
			    case Calendar.FRIDAY:dayno=5;break;
			    case Calendar.SATURDAY:dayno=6;break;
			}
			System.out.println(dayno + "   "+this.day);
			if(dayno<this.day){
			String str="declare\n "
					+ "day varchar(20);\n "
					+ "dayno lecture_master.day%type;\n "
					+ "temp lecture_master.day%type;\n "
					+ "iday lecture_master.lec_id%type;\n "
					+ "subid lecture_master.sub_id%type;\n "
					+ "begin\n "
					+ "select sub_id into subid from subject where sub_name='"+this.lec+"';\n "
					+ "select lec_id into iday from lecture_master where day="+this.day+" and time="+this.time+" and sub_id=subid;\n "
					//+ "select lec_id into iday from lecture_master where day=2 and time=4 and sub_id=subid;\n "
					+ "--select day into inputday from lecture_master where lec_id=iday;\n "
					+ "dayno:=to_char(sysdate,'d');\n "
				//	+ "dayno:=0; \n"	
				//	+ "if day='monday' then dayno:=1; end if;\n "
				//	+ "if upper(day)='tuesday' then dayno:=2; end if;\n "
				//	+ "if upper(day)='WEDNESDAY' then dayno:=3; end if;\n "
				//	+ "if day='thursday' then dayno:=4;\n "
				//	+ "insert into subject values(600,dayno); end if;\n"
				//	+ "if upper(day)='FRIDAY' then dayno:=5; end if;\n "
				//	+ "if upper(day)='SATURDAY' then dayno:=6; end if;\n "
				//	+ "if upper(day)='SUNDAY' then dayno:=0; end if;\n "
				//	+ "end if;\n "
					+ "temp:= "+this.day+";\n "
				//	+ "insert into subject values(600,dayno); \n"
				//	+ "if dayno>temp then "
//			    	+ "insert into subject values(615,dayno-1); \n"
				//	+ "then "
					+ "update lecture_master set lec_type=2,sub_id=421,change=1 where lec_id=iday; "
				//	+ "end if;\n "
					+ "commit;\n "
					+ "end;\n ";
//			String str="declare \n a number(2);\n begin\n dbms_output.put_line('alaukika'||a); \n end;";
			int rs=stmt.executeUpdate(str);
			lec.setText("----");
			this.setOpaque(true);
			this.setBackground(Color.red);

//			System.out.println("jiiiiiiiiii");
			System.out.println(rs);  
			updateDB();
			}else{
				JOptionPane.showMessageDialog(this, "You cannot change lec...");
			}
			con.close();  
			}catch(Exception e){ System.out.println(e);}  
		
	}
	public void swapLecture(Lecture lec,Object sel){
		int ans=this.checkLec();
		int dayx=-1;
		if(sel.toString().equals("Monday")) dayx=1;
		else if(sel.toString().equals("Tuesday")) dayx=2;
		else if(sel.toString().equals("Wednesday")) dayx=3;
		else if(sel.toString().equals("Thursday")) dayx=4;
		else if(sel.toString().equals("Friday")) dayx=5;
		else if(sel.toString().equals("Saturday")) dayx=6;
		
		System.out.println("agfhjikftgyhujhygtf");
		if(ans==1){
			try{  
				//step1 load the driver class  
				Class.forName("oracle.jdbc.driver.OracleDriver");  
				  
				//step2 create  the connection object  
				Connection con=DriverManager.getConnection(  
				"jdbc:oracle:thin:@localhost:1521:xe","system","jimmy3010");  
				  
				//step3 create the statement object  
				Statement stmt=con.createStatement();
				System.out.println("alsjdidj");
				int teid=-1;
				int subid=-1;
				int lock=checkSwap();
/*				String strlock="declare\n"
						+ "lock2 number(3);\n"
						+ "teid number(3);\n"
						+ "begin\n"
						+ "select t_id into teid from lecture_master where day="+this.day+" and time="+this.time+" and sem="+this.sem+";\n"
						+ "select lock_lec into lock2 from lecture_master where t_id=teid;\n"
						+ ""+lock+":=lock2;\n"
						+ "end;\n";
				
				int rs=stmt.executeUpdate(strlock);
	*/			
		//		System.out.println("select t_id into "+teid+" from lecture_master where day="+this.day+" and time="+this.time+" and sem="+this.sem+"");
				if(lock!=1){
				String str="declare\n"
						+ "teid number(2);\n"
						+ "subid number(3);\n"
						+ "lecid number(4); \n"
						+ "begin\n"
						+ "select t_id into teid from lecture_master where day="+this.day+" and time="+this.time+" and sem="+this.sem+";\n"
						+ "select sub_id into subid from lecture_master where day="+this.day+" and time="+this.time+" and sem="+this.sem+";\n"
						+ "select lec_id into lecid from lecture_master where day="+dayx+" and sem="+this.sem+" and t_id="+this.teacherId+" and time in (select min(time) from lecture_master where day="+dayx+" and sem="+this.sem+" and t_id="+this.teacherId+");\n"
						+ "insert into swap_request values('"+this.teacherId+"',teid,subid,"+this.time+","+this.day+","+this.sem+",lecid);\n"
						+ "update lecture_master set lock_lec=1 where t_id=teid;\n "
						+ "end;\n";
				int rs2=stmt.executeUpdate(str);
				System.out.println("alsjdidj");
				if(rs2==1){
				//	String insert="insert into swap_request values('"+this.teacherId+"','"+teid+"','"+subid+"',"+this.time+","+this.day+","+this.sem+")";
				//	stmt.executeQuery(insert);
				}
				System.out.println("aloosjdidj");
				lec.setText(lec.getText()+" (Requested)");

				}
				else{
					JOptionPane.showMessageDialog(this, "Cannot Request");

				}
				//step4 execute query  
				//ResultSet rs=stmt.executeQuery("select * from test");  
				//while(rs.next())  
				//System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getInt(3));  
				  
				//step5 close the connection object  
				con.close();  
				  
				}catch(Exception e){ System.out.println(e);}  

		}
		else{
			JOptionPane.showMessageDialog(this, "Lecture is already scheduled for this slot");
		}
	}
	public int checkLec(){
		//lec.setText("Pending...");
		int ans=-1;
		 try{  
			//step1 load the driver class  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			  
			//step2 create  the connection object  
			Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:@localhost:1521:xe","system","jimmy3010");  
			  
			//step3 create the statement object  
			Statement stmt=con.createStatement();  
			//boolean ans = false;
			CallableStatement cstmt = con.prepareCall("{? = call check_freeLec (?, ? ,? , ?)}");
			
			cstmt.registerOutParameter (1, Types.INTEGER);

		    // We want to raise LESLIE's salary by 20,000
		    cstmt.setInt (2, this.teacherId);  // The name argument is the second ?
		    cstmt.setInt (3, this.day);  // The name argument is the second ?
		    cstmt.setInt (4, this.time);  // The name argument is the second ?
		    cstmt.setInt (5, this.sem);  // The name argument is the second ?
		    cstmt.execute ();
		    ans = cstmt.getInt(1);
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
	public int checkSwap(){
		//lec.setText("Pending...");
		int ans=-1;
		 try{  
			//step1 load the driver class  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			  
			//step2 create  the connection object  
			Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:@localhost:1521:xe","system","jimmy3010");  
			  
			//step3 create the statement object  
			Statement stmt=con.createStatement();  
			//boolean ans = false;
			CallableStatement cstmt = con.prepareCall("{? = call checkSwap (?, ? ,?)}");
			
			cstmt.registerOutParameter (1, Types.INTEGER);

		    // We want to raise LESLIE's salary by 20,000
		    cstmt.setInt (2, this.day);  // The name argument is the second ?
		    cstmt.setInt (3, this.time);  // The name argument is the second ?
		    cstmt.setInt (4, this.sem);  // The name argument is the second ?
		    cstmt.execute ();
		    ans = cstmt.getInt(1);
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
	public void extraLecture(Lecture lec){
		String[] values1 = {"Cancel", "Swap", "Extra"};
		String[] subject= new String[4];
		System.out.println("Extra called"+this.teacherId);
		try{  
			//step1 load the driver class  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			  
			//step2 create  the connection object  
			Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:@localhost:1521:xe","system","jimmy3010");  
			  
			//step3 create the statement object  
			Statement stmt=con.createStatement();  
			  
			//step4 execute query  
			String str="select * from subject where sub_id in (select distinct sub_id from lecture_master where sem="+this.sem+" and t_id="+this.teacherId+")";
			ResultSet rs=stmt.executeQuery(str); 
			System.out.println(rs);
			System.out.println("subject"+str);
			int count=0;
			subject[0]="no subject";
			while(rs.next()){
				subject[count]=rs.getString(2);
				count++;
				//System.out.println("jiiiekdljasf: "+rs.getString(2));
			}
			for(int i=0;i<4;i++){
				System.out.println("alala:   "+subject[i]);
			}
			//System.out.println("subject length : "+subject.length);
			if(subject[0].equals("no subject")){
				JOptionPane.showMessageDialog(this, "Sorry, but you are not taking any subjects in this semester!");
				//lec.setText(subject[0]);
			}
			else{
				Object selected = JOptionPane.showInputDialog(null, "Select Yout Option", "Selection", JOptionPane.DEFAULT_OPTION, null, subject, "0");
				Calendar calendar = Calendar.getInstance();
				int day = calendar.get(Calendar.DAY_OF_WEEK);
				int dayno = 0;
				switch (day) {
				    case Calendar.SUNDAY:dayno=0; break;
				    case Calendar.MONDAY:dayno=1;break;
				    case Calendar.TUESDAY:dayno=2;break;
				    case Calendar.WEDNESDAY:dayno=3;break;
				    case Calendar.THURSDAY:dayno=4;break;
				    case Calendar.FRIDAY:dayno=5;break;
				    case Calendar.SATURDAY:dayno=6;break;
				}
				System.out.println(dayno + "   "+this.day);
				System.out.println("select sub_id into subid from subject where sub_name="+selected.toString()+"");
				System.out.println("select lec_id into iday from dummy where day="+this.day+" and time="+this.time+" and sem="+this.sem+";\n");
				System.out.println("update lecture_master set lec_type=1,sub_id=subid,t_id=1 where lec_id=iday;\n");
				int ans=checkLec();
				if(dayno<this.day+1 && ans==1){
					
				String str_extra="declare \n "
						+ "iday number(3); \n "
						+ "subid number(3); \n "
						+ "begin \n "
						+ "select sub_id into subid from subject where sub_name='"+selected.toString()+"';\n "
						+ "select lec_id into iday from lecture_master where day="+this.day+" and time="+this.time+" and sem="+this.sem+";\n "
						+ "update lecture_master set lec_type=1,sub_id=subid,t_id="+this.teacherId+",change=2 where lec_id=iday;\n "
						+ "commit;\n "
						+ "end;\n ";
//				String str="declare \n a number(2);\n begin\n dbms_output.put_line('alaukika'||a); \n end;";
				System.out.println(str_extra);
				int rs_extra=stmt.executeUpdate(str_extra);
				if(rs_extra==1){
					lec.setText(selected.toString());
					this.setOpaque(true);
					this.setBackground(Color.green);
				}	
//				System.out.println("jiiiiiiiiii");
				//System.out.println(rs_extra);  
				updateDB();
				}else{
					JOptionPane.showMessageDialog(this, "You can not change lecture!");
				}
			}
			//System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getInt(3));  
			  
			//step5 close the connection object  
			con.close();  
			  
			}catch(Exception e){ System.out.println(e);}  
		
	}
	public void check(){
		try{  
			//step1 load the driver class  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			  
			//step2 create  the connection object  
			Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:@localhost:1521:xe","system","jimmy3010");  
			  
			//step3 create the statement object  
			Statement stmt=con.createStatement();  
			//CallableStatment stmt2;
			
			//step4 execute query 
			String str="declare "
					+ "begin "
					+ "insert into subject values(500,'jimmy'); "
					+ "end;"
					;
			int rs=stmt.executeUpdate(str);  
			//while(rs.next())  
			System.out.println(rs);  
			  
			//step5 close the connection object  
			con.close();  
			  
			}catch(Exception e){ System.out.println(e);}  
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
