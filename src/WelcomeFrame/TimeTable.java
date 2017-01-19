package WelcomeFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class TimeTable extends JPanel implements ActionListener{
	int semester = -1;
	StudentView s;
	TeacherView t;
	Login l;
	TimeTable tt;
	JPanel upper = new JPanel();
	JPanel upper_tea = new JPanel();
	JPanel Student=new JPanel();
	JPanel Teacher=new JPanel();
	boolean loginFlag = false;
	JComboBox<String> sem=new JComboBox<String>();
	JTabbedPane mainPane = new JTabbedPane();
	JTabbedPane mainPane2 = new JTabbedPane();
	public JTabbedPane mainPane3 = new JTabbedPane();
	JComboBox<String> dept=new JComboBox<String>();
	JComboBox<String> sem_stu=new JComboBox<String>();
	JComboBox<String> dept_stu=new JComboBox<String>();
	int id=-1;
	public int loginTeacherId=-1;
	public TimeTable(){
		
	}
	public boolean getLoginMode(){
		return loginFlag;
	}
	public TimeTable(int semester,int id) {
		this.id=id;
		setVisible(true);
		//tt=new TimeTable(semester,id);
//		tt=new Login();
		//setTitle("TimeTable");
		s = new StudentView(3);
		t = new TeacherView(1,3);
		setSize(1366,730);
		setLayout(new BorderLayout());
		setBackground(new Color(192,192,204));
		
		add(upper,BorderLayout.NORTH);
	
		upper.setLayout(new FlowLayout());
		dept_stu.addItem("CS");
		upper.add(dept_stu);
		sem_stu.addItem("Sem 1");
		sem_stu.addItem("Sem 2");
		sem_stu.addItem("Sem 3");
		sem_stu.addItem("Sem 4");
		sem_stu.addItem("Sem 5");
		sem_stu.addItem("Sem 6");
		sem_stu.addItem("Sem 7");
		sem_stu.addItem("Sem 8");
		upper.add(sem_stu);
		sem_stu.addActionListener(this);

		upper_tea.setLayout(new FlowLayout());
		dept.addItem("CS");
		upper_tea.add(dept);
		sem.addItem("sem 1");
		sem.addItem("sem 2");
		upper_tea.add(sem);
		sem.addActionListener(this);
		
		//t=new TeacherView(semester,id);
		mainPane2.addTab("Sem 1",s);
		mainPane3.addTab("Sem 1",t);
		//mainPane3.add("semester 1",t);	
		mainPane.add("Student",Student);
		mainPane.add("Teacher",Teacher);
		Student.setLayout(new BorderLayout());
		Teacher.setLayout(new BorderLayout());
		Student.add(upper,BorderLayout.NORTH);
		Student.add(mainPane2,BorderLayout.CENTER);
		Teacher.add(upper_tea,BorderLayout.NORTH);
		Teacher.add(mainPane3,BorderLayout.CENTER);
		add(mainPane);
		//setPane();	
/*		addWindowListener(
				  new WindowAdapter() {
					  public void windowClosing(WindowEvent e) { 
					      System.exit(0); 
					  } 
				      } 
				  );
		setVisible(true);
*/
	}
	public TimeTable(int semester,int id,boolean flag) {
		this.loginTeacherId=id;
		this.id=id;
		this.loginFlag=flag;
		setVisible(true);
		//tt=new TimeTable(semester,id);
//		tt=new Login();
		//setTitle("TimeTable");
		if(this.loginFlag){
		s = new StudentView(3,this.loginTeacherId,true);
		t = new TeacherView(1,this.loginTeacherId,true);
		}
		else{
		s = new StudentView(8,false);
		t = new TeacherView(1,this.loginTeacherId);
		}
		setSize(1366,730);
		setLayout(new BorderLayout());
		setBackground(new Color(192,192,204));
		
		add(upper,BorderLayout.NORTH);
	
		upper.setLayout(new FlowLayout());
		dept_stu.addItem("CS");
		upper.add(dept_stu);
		sem_stu.addItem("Sem 1");
		sem_stu.addItem("Sem 2");
		sem_stu.addItem("Sem 3");
		sem_stu.addItem("Sem 4");
		sem_stu.addItem("Sem 5");
		sem_stu.addItem("Sem 6");
		sem_stu.addItem("Sem 7");
		sem_stu.addItem("Sem 8");
		upper.add(sem_stu);
		sem_stu.addActionListener(this);

		upper_tea.setLayout(new FlowLayout());
		dept.addItem("CS");
		upper_tea.add(dept);
		sem.addItem("sem 1");
		sem.addItem("sem 2");
		upper_tea.add(sem);
		sem.addActionListener(this);
		
		//t=new TeacherView(semester,id);
		mainPane2.addTab("Sem 1",s);
		mainPane3.addTab("Sem 1",t);
		//mainPane3.add("semester 1",t);	
		mainPane.add("Student",Student);
		mainPane.add("Teacher",Teacher);
		Student.setLayout(new BorderLayout());
		Teacher.setLayout(new BorderLayout());
		Student.add(upper,BorderLayout.NORTH);
		Student.add(mainPane2,BorderLayout.CENTER);
		Teacher.add(upper_tea,BorderLayout.NORTH);
		Teacher.add(mainPane3,BorderLayout.CENTER);
		add(mainPane);
		//setPane();	
/*		addWindowListener(
				  new WindowAdapter() {
					  public void windowClosing(WindowEvent e) { 
					      System.exit(0); 
					  } 
				      } 
				  );
		setVisible(true);
*/
	}
	public void removeTeacher(){
		mainPane.remove(Teacher);
	}
	public void checkLogin(){
		
		if(l.getLogin()){
			this.setPane();
		}
		
	}
	public void setPane(){
		
		System.out.println("jdkdkkdfk");
//		loginFlag=true;
		t=new TeacherView(semester,id);
//		TeacherView t= new TeacherView(1,id);
		mainPane3.addTab("Sem gjhggj",t);
//		add(mainPane3);
		mainPane3.remove(0);
	}
	public TimeTable getTimeTable(){
		return this;
	}
	public void setLogin(){
		mainPane3.add("Sem 1",new Login());
		mainPane3.remove(0);
	}
	public void setLoginMode(){
		this.loginFlag=true;
	}
	public static void main(String[] args){
		new TimeTable(6,3);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("hiiiii");
		if(e.getSource()==sem){
			System.out.println("aloo000");
			String s=(String)sem.getSelectedItem();
			System.out.println(s);
			switch(s) {
				case "sem 1":
					if(getLoginMode())
					mainPane3.add("sem 1",new TeacherView(1,id,true));
					else
					mainPane3.add("sem 1",new TeacherView(1,id));
						
					mainPane3.remove(0);
					break;
				case "sem 2":
					if(getLoginMode())
					mainPane3.add("sem 2",new TeacherView(2,id,true));
					else
					mainPane3.add("sem 2",new TeacherView(2,id));
						
					mainPane3.remove(0);
					break;
			}
		}
		// TODO Auto-generated method stub
		else if(e.getSource()==sem_stu){
			System.out.println("aloo");
			String s=(String)sem_stu.getSelectedItem();
			System.out.println(s);
			switch(s) {
				case "Sem 1":
					if(getLoginMode())
					mainPane2.add("Sem 1",new StudentView(1,this.loginTeacherId,true));
					else
					mainPane2.add("Sem 1",new StudentView(1,false));
						
					mainPane2.remove(0);
					break;
				case "Sem 2":
					if(getLoginMode())
					mainPane2.add("Sem 2",new StudentView(2,this.loginTeacherId,true));
					else
					mainPane2.add("Sem 2",new StudentView(2,false));
						
					mainPane2.remove(0);
					break;
				case "Sem 3":
					if(getLoginMode())
					mainPane2.add("Sem 3",new StudentView(3,this.loginTeacherId,true));
					else
					mainPane2.add("Sem 3",new StudentView(3,false));
						
					mainPane2.remove(0);
					break;
				case "Sem 4":
					if(getLoginMode())
					mainPane2.add("Sem 4",new StudentView(4,this.loginTeacherId,true));
					else
					mainPane2.add("Sem 4",new StudentView(4,false));
						
					mainPane2.remove(0);
					break;
				case "Sem 5":
					if(getLoginMode()){
					mainPane2.add("Sem 5",new StudentView(5,this.loginTeacherId,true));
					System.out.println("login ......................tid.........."+this.loginTeacherId);
					}else{
					System.out.println("................................................................................");	
					mainPane2.add("Sem 5",new StudentView(5,false));
					System.out.println("loginji ......................tid.........."+this.loginTeacherId);
					
					}	
					mainPane2.remove(0);
					break;
				case "Sem 6":
					if(getLoginMode())
					mainPane2.add("Sem 6",new StudentView(6,this.loginTeacherId,true));
					else
					mainPane2.add("Sem 6",new StudentView(6,false));
						
					mainPane2.remove(0);
					break;
				case "Sem 7":
					if(getLoginMode())
					mainPane2.add("Sem 7",new StudentView(7,this.loginTeacherId,true));
					else
					mainPane2.add("Sem 7",new StudentView(7,false));
						
					mainPane2.remove(0);
					break;
				case "Sem 8":
					if(getLoginMode())
					mainPane2.add("Sem 8",new StudentView(8,this.loginTeacherId,true));
					else
					mainPane2.add("Sem 8",new StudentView(8,false));
						
					mainPane2.remove(0);
					break;
			}
		}
		
	}
/*	public void actionPerformed(ActionEvent e) {
		System.out.println("hiiiii");
		if(e.getSource()==sem_stu){
			System.out.println("aloo");
			String s=(String)sem.getSelectedItem();
			System.out.println(s);
			switch(s) {
				case "Sem 1":
					mainPane2.add("Sem 1",new StudentView(1));
					mainPane2.remove(0);
					break;
				case "Sem 2":
					mainPane2.add("Sem 2",new StudentView(2));
					mainPane2.remove(0);
					break;
				case "Sem 3":
					mainPane2.add("Sem 3",new StudentView(3));
					mainPane2.remove(0);
					break;
				case "Sem 4":
					mainPane2.add("Sem 4",new StudentView(4));
					mainPane2.remove(0);
					break;
				case "Sem 5":
					mainPane2.add("Sem 5",new StudentView(5));
					mainPane2.remove(0);
					break;
				case "Sem 6":
					mainPane2.add("Sem 6",new StudentView(6));
					mainPane2.remove(0);
					break;
				case "Sem 7":
					mainPane2.add("Sem 7",new StudentView(7));
					mainPane2.remove(0);
					break;
				case "Sem 8":
					mainPane2.add("Sem 8",new StudentView(8));
					mainPane2.remove(0);
					break;
			}
		}
		// TODO Auto-generated method stub
		
	}*/

}
