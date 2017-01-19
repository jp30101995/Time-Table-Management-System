package WelcomeFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class TimeTableNew extends JFrame implements ActionListener{
	JPanel upper = new JPanel();
	JPanel upper_tea = new JPanel();
	JPanel Student = new JPanel();
	JPanel Teacher = new JPanel();
	
	JComboBox<String> sem=new JComboBox<String>();
	JTabbedPane mainPane = new JTabbedPane();
	JTabbedPane mainPane2 = new JTabbedPane();
	public JTabbedPane mainPane3 = new JTabbedPane();
	JComboBox<String> dept=new JComboBox<String>();
	JComboBox<String> sem_stu=new JComboBox<String>();
	JComboBox<String> dept_stu=new JComboBox<String>();
	int id=-1;
	Connection con=null;
	Statement stmt=null;
	ResultSet rs=null;
//	JPanel upper = new JPanel();
	JPanel mid = new JPanel();
	JPanel left = new JPanel();
	JLabel lec = new JLabel();
	JPanel left_color = new JPanel();
	String[][] arrSub=new String[10][10];

	
//	JComboBox<String> sem=new JComboBox<String>();
//	ResultSet rs=null;
	ResultSet rs2=null;
//	JPanel upper = new JPanel();
//	JPanel mid = new JPanel();
//	JPanel end = new JPanel();
//	JLabel lec = new JLabel();
//	String[][] arrSub=new String[10][10];
//	JComboBox<String> sem=new JComboBox<String>();
	JButton logout = new JButton("Logout");
//	JPanel left = new JPanel();
	JPanel left_button =new JPanel();
//	JPanel left_color = new JPanel();
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
	JLabel message = new JLabel("message");
	
	JButton login = new JButton("Login");
	JButton cancel = new JButton("Cancel Lecture");
	JButton extra = new JButton("Extra Lecture");
	JButton swap = new JButton("Swap Lecture");
	JButton find = new JButton("Find Lecture");
	
 	JTextField userName = new JTextField(30);
	JTextField password = new JTextField(30);
	int tid=-1;

	public TimeTableNew() {
		this.id=id;
		setTitle("TimeTable");
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

		mainPane2.add("Sem 1",new StudentView(semester));
		mainPane3.add("Sem 1",new Login());

		
		mainPane.add("Student",Student);
		mainPane.add("Teacher",Teacher);
		Student.setLayout(new BorderLayout());
		Teacher.setLayout(new BorderLayout());
		Student.add(upper,BorderLayout.NORTH);
		Student.add(mainPane2,BorderLayout.CENTER);
		Teacher.add(upper_tea,BorderLayout.NORTH);
		Teacher.add(mainPane3,BorderLayout.CENTER);
		add(mainPane);
			
		addWindowListener(
				  new WindowAdapter() {
					  public void windowClosing(WindowEvent e) { 
					      System.exit(0); 
					  } 
				      } 
				  );
		setVisible(true);


	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
