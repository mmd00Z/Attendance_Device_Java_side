//package dhgz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JSeparator;
import javax.swing.JProgressBar;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JTree;
import java.awt.Font;
import javax.swing.JEditorPane;
import javax.swing.JSpinner;
import javax.swing.JScrollBar;
import javax.swing.JDesktopPane;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.beans.Statement;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerNumberModel;
import javax.swing.DefaultComboBoxModel;

public class App implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -329371300890119586L;
	private ArrayList <Student> today_students; // the present student in day
	private ArrayList <SchoolClass> classes;
	
	public static String ESP_IP = "192.168.43.100";
	public static String SETTING_SAVE_PATH = "setting_config.json";
	public static String DEFAULT_SETTING_LOAD_PATH = "default_setting_config.json";
	
	public static Border borders;
	private boolean isManualStarted 			= false;
	private boolean is_first_action_performed_of_combo ;
	private boolean visible_of_list_1 			= false;
	private boolean visible_of_list_2 			= false;
	private boolean visible_of_btnClassChooser 	= false;
	public JFrame frmJustDarkMode 				= null;
	public Settings pnl_Setting 				= null;
	public JPanel pnl_main 						= null;
	private JList list_1 						= null;
	private JList list_2 						= null;
	JRadioButton rdbtnPresent 					= null;
	JRadioButton rdbtnAbsent 					= null;
	JTextField textField_InputLastName			= null; 			
	JTextField textField_InputFirstName			= null;
	JTextField textField_InputFatherName 		= null;
	JTextField textField_InputNationalCode 		= null;
	JTextField textField_InputNumberPhone 		= null;
	private JRadioButton rdbtnToday 			= null;
	private JRadioButton rdbtnYesterday 		= null;
	JPanel pnl_StudentProfile 					= null;
	JRadioButton rdbtnStudent 					= null;
	JRadioButton rdbtnEmployee 					= null;
	private JTable table 						= null;
	private JTextField searchField 				= null;
	private JTextField textField 				= null;
	JComboBox<String> comboInputChooseClass_1	= null;
	private JPanel tbl							= null;
	JLabel lblFirstName							= null;
	JLabel lblLastName							= null;
	JLabel lblFathersName						= null;
	JLabel lblNationalCode						= null;
	JLabel lblNumberPhone						= null;
	JLabel lblClass								= null;
	JComboBox<String> comboChooseClass			= null;
	private JComboBox comboShowMode				= null;
	JLabel btnEdit;
	JButton btnCancel_edit;
	JButton btnSubmit_edit;
	static final int ATTENDANCE_LIST = 0;
	static final int LIST_OF_PERSONS = 1;
	static final int ABSENTEE_LIST   = 2;
	static final int PRESENT_LIST =  3;
	private JButton btnCancel_add;
	private JButton btnSubmit_add;
	private JLabel lblAddStatus;
	private JSpinner spinnerYear;
	private LocalDateTime date_time					= null;
	private JLabel lbl_tbl_Present 					= new JLabel("");
	private LocalDateTime dateTime;
	public static Color background_color = new Color(40, 40, 40);
	public static Color foreground_color = new Color(242, 170, 76);
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
					window.frmJustDarkMode.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public App() {
		initialize();
	}

	private void initialize() {		
		classes = new ArrayList<SchoolClass>();
		today_students = new ArrayList<Student>();
		SchoolClass.loadClass(App.this, classes);
		for(int i=0;i<classes.size();i++) {
			classes.get(i).loadStudent();
			System.out.println(classes.get(i).getStudents().size());
		}
		borders = BorderFactory.createLineBorder(new Color(242, 170, 76), 2);
		Border bordersk = BorderFactory.createLineBorder(new Color(255, 255, 255), 1);
		frmJustDarkMode = new JFrame();
		frmJustDarkMode.setFont(new Font("Vazirmatn", Font.PLAIN, ۱۶));
		frmJustDarkMode.setResizable(true);
		frmJustDarkMode.getContentPane().setBackground(new Color(40, 40, 40));
		frmJustDarkMode.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Programming\\Java\\dhgz\\dhgz\\Icons\\sampad.jpg"));
		frmJustDarkMode.setTitle("دستگاه حضور و غیاب");
		frmJustDarkMode.setResizable(false);
		frmJustDarkMode.setBounds(-6, 0, 1550, 823);
		frmJustDarkMode.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmJustDarkMode.getContentPane().setLayout(null);
		
		pnl_Setting = new Settings(this);
//		File settings_file = new File(SETTING_SAVE_PATH);
//		pnl_Setting = loadSettingsPanel((settings_file.exists())? SETTING_SAVE_PATH:DEFAULT_SETTING_LOAD_PATH);
//		frmJustDarkMode = pnl_Setting.app.frmJustDarkMode;
		
		pnl_main = new JPanel();
		pnl_main.setBackground(new Color(40, 40, 40));
		pnl_main.setBounds(10, 11, 1516, 765);
		frmJustDarkMode.getContentPane().add(pnl_main);
		pnl_main.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(50, 50, 50));
		panel.setBounds(1109, 11, 397, 83);
		pnl_main.add(panel);
		panel.setLayout(null);
		
		JLabel btnNewButton = new JLabel("");
		btnNewButton.setForeground(new Color(107, 142, 35));
		btnNewButton.setIcon(new ImageIcon("D:\\Programming\\Java\\dhgz\\dhgz\\Icons\\search-free-icon-font.png"));
		btnNewButton.setHorizontalAlignment(SwingConstants.CENTER);
		btnNewButton.setBackground(new Color(16, 24, 32));
		btnNewButton.setFont(new Font("Consolas", Font.BOLD, ۱۷));
		btnNewButton.setBounds(1451, 102, 55, 40);
		pnl_main.add(btnNewButton);
		btnNewButton.setOpaque(true);
		btnNewButton.setBorder(bordersk);
		//btnNewButton.setBorderPainted(false);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDate.setForeground(new Color(242, 170, 76));
		lblDate.setFont(new Font("Tahoma", Font.BOLD, ۲۰));
		lblDate.setBounds(0, 0, 64, 28);
		panel.add(lblDate);
		
		rdbtnToday = new JRadioButton("today");
		rdbtnToday.setForeground(new Color(242, 170, 76));
		rdbtnToday.setBackground(new Color(50, 50, 50));
		rdbtnToday.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnYesterday.setSelected(false);
			}
		});
		rdbtnToday.setFont(new Font("Tahoma", Font.PLAIN, ۱۴));
		rdbtnToday.setBounds(10, 37, 103, 21);
		panel.add(rdbtnToday);
		rdbtnToday.setFocusPainted(false);
	
		
		rdbtnYesterday = new JRadioButton("Yesterday");
		rdbtnYesterday.setForeground(new Color(242, 170, 76));
		rdbtnYesterday.setBackground(new Color(50, 50, 50));
		rdbtnYesterday.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnToday.setSelected(false);
			}
		});
		rdbtnYesterday.setFont(new Font("Tahoma", Font.PLAIN, ۱۴));
		rdbtnYesterday.setBounds(10, 56, 103, 21);
		panel.add(rdbtnYesterday);
		rdbtnYesterday.setFocusPainted(false);
		
		JSpinner spinnerDay = new JSpinner();
		spinnerDay.setFont(new Font("Tahoma", Font.PLAIN, ۱۶));
		spinnerDay.setBounds(317, 30, 70, 29);
		panel.add(spinnerDay);
		
		spinnerYear = new JSpinner();
		spinnerYear.setForeground(new Color(0, 139, 139));
		spinnerYear.setBackground(new Color(255, 255, 255));
		spinnerYear.setFont(new Font("Tahoma", Font.PLAIN, ۱۶));
		spinnerYear.setBounds(119, 30, 64, 29);
		panel.add(spinnerYear);
		
		JLabel lblDay = new JLabel("Day");
		lblDay.setForeground(new Color(242, 170, 76));
		lblDay.setHorizontalAlignment(SwingConstants.CENTER);
		lblDay.setFont(new Font("Tahoma", Font.BOLD, ۱۶));
		lblDay.setBounds(324, 2, 46, 29);
		panel.add(lblDay);
		
		JLabel lblMonth = new JLabel("Month");
		lblMonth.setForeground(new Color(242, 170, 76));
		lblMonth.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonth.setFont(new Font("Tahoma", Font.BOLD, ۱۶));
		lblMonth.setBounds(215, 2, 63, 29);
		panel.add(lblMonth);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setForeground(new Color(242, 170, 76));
		lblYear.setHorizontalAlignment(SwingConstants.CENTER);
		lblYear.setFont(new Font("Tahoma", Font.BOLD, ۱۶));
		lblYear.setBounds(131, 2, 46, 29);
		panel.add(lblYear);
		
		pnl_StudentProfile = new JPanel();
		pnl_StudentProfile.setBackground(new Color(50, 50, 50));
		pnl_StudentProfile.setBounds(1109, 152, 397, 603);
		pnl_main.add(pnl_StudentProfile);
		pnl_StudentProfile.setLayout(null);
		pnl_StudentProfile.setVisible(false);
		
		lblFirstName = new JLabel("First Name:");
		lblFirstName.setForeground(new Color(242, 170, 76));
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, ۱۶));
		lblFirstName.setBounds(10, 85, 316, 29);
		pnl_StudentProfile.add(lblFirstName);
		
		lblFathersName = new JLabel("Father's Name:");
		lblFathersName.setForeground(new Color(242, 170, 76));
		lblFathersName.setFont(new Font("Tahoma", Font.BOLD, ۱۶));
		lblFathersName.setBounds(10, 161, 316, 29);
		pnl_StudentProfile.add(lblFathersName);
		
		lblClass = new JLabel("Class:");
		lblClass.setForeground(new Color(242, 170, 76));
		lblClass.setFont(new Font("Tahoma", Font.BOLD, ۱۶));
		lblClass.setBounds(10, 278, 316, 29);
		pnl_StudentProfile.add(lblClass);
		
		lblNationalCode = new JLabel("National Code:");
		lblNationalCode.setForeground(new Color(242, 170, 76));
		lblNationalCode.setFont(new Font("Tahoma", Font.BOLD, ۱۶));
		lblNationalCode.setBounds(10, 199, 316, 29);
		pnl_StudentProfile.add(lblNationalCode);
		
		lblNumberPhone = new JLabel("Number Phone:");
		lblNumberPhone.setForeground(new Color(242, 170, 76));
		lblNumberPhone.setFont(new Font("Tahoma", Font.BOLD, ۱۶));
		lblNumberPhone.setBounds(10, 239, 316, 29);
		pnl_StudentProfile.add(lblNumberPhone);
		
		JLabel lblStudentProfile = new JLabel("Student Profile:");
		lblStudentProfile.setForeground(new Color(242, 170, 76));
		lblStudentProfile.setFont(new Font("Tahoma", Font.BOLD, ۱۶));
		lblStudentProfile.setBounds(10, 10, 193, 29);
		pnl_StudentProfile.add(lblStudentProfile);
		
		rdbtnPresent = new JRadioButton("Present");
		rdbtnPresent.setForeground(new Color(242, 170, 76));
		rdbtnPresent.setBackground(new Color(50, 50, 50));
		rdbtnPresent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnAbsent.setSelected(false);
			}
		});
		rdbtnPresent.setFont(new Font("Tahoma", Font.BOLD, ۱۶));
		rdbtnPresent.setBounds(10, 45, 103, 21);
		pnl_StudentProfile.add(rdbtnPresent);
		
		
		rdbtnAbsent = new JRadioButton("Absent");
		rdbtnAbsent.setForeground(new Color(242, 170, 76));
		rdbtnAbsent.setBackground(new Color(50, 50, 50));
		rdbtnAbsent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnPresent.setSelected(false);
			}
		});
		rdbtnAbsent.setFont(new Font("Tahoma", Font.BOLD, ۱۶));
		rdbtnAbsent.setBounds(126, 45, 103, 21);
		pnl_StudentProfile.add(rdbtnAbsent);
		
		lblAddStatus = new JLabel("");
		lblAddStatus.setBounds(52, 485, 313, 45);
		pnl_StudentProfile.add(lblAddStatus);
		lblAddStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddStatus.setFont(new Font("Vazirmatn", Font.PLAIN, ۱۸));
		lblAddStatus.setVisible(false);
		
		textField_InputFirstName = new JTextField();
		textField_InputFirstName.setBackground(new Color(10, 18, 20));
		textField_InputFirstName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_InputFirstName.setForeground(new Color(242, 170, 76));
		textField_InputFirstName.setToolTipText("name");
		textField_InputFirstName.setBounds(138, 85, 188, 26);
		pnl_StudentProfile.add(textField_InputFirstName);
		textField_InputFirstName.setColumns(10);
		
		textField_InputFatherName = new JTextField();
		textField_InputFatherName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_InputFatherName.setBackground(new Color(10, 18, 20));
		textField_InputFatherName.setForeground(new Color(242, 170, 76));
		textField_InputFatherName.setToolTipText("father's name");
		textField_InputFatherName.setBounds(138, 161, 188, 26);
		pnl_StudentProfile.add(textField_InputFatherName);
		textField_InputFatherName.setColumns(10);
		
		textField_InputNationalCode = new JTextField();
		textField_InputNationalCode.setBackground(new Color(10, 18, 20));
		textField_InputNationalCode.setForeground(new Color(242, 170, 76));
		textField_InputNationalCode.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_InputNationalCode.setToolTipText("national code");
		textField_InputNationalCode.setBounds(138, 200, 188, 26);
		pnl_StudentProfile.add(textField_InputNationalCode);
		textField_InputNationalCode.setColumns(10);
		
		textField_InputNumberPhone = new JTextField();
		textField_InputNumberPhone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		textField_InputNumberPhone.setForeground(new Color(242, 170, 76));
		textField_InputNumberPhone.setToolTipText("number phone");
		textField_InputNumberPhone.setBounds(138, 243, 188, 26);
		pnl_StudentProfile.add(textField_InputNumberPhone);
		textField_InputNumberPhone.setColumns(10);
		textField_InputNumberPhone.setBackground(new Color(10, 18, 20));
		btnSubmit_add = new JButton("OK");
		btnSubmit_add.setFocusPainted(false);
		btnSubmit_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnl_StudentProfile.setVisible(false);
				lblAddStatus.setText("Hold the card in front of the device...");
				lblAddStatus.setVisible(true);
				if(textField_InputFirstName.getText().equals("")) lblAddStatus.setText("First name field is required!");
				else if(textField_InputLastName.getText().equals("")) lblAddStatus.setText("Last name field is required!");
				else if(textField_InputFatherName.getText().equals("")) lblAddStatus.setText("Father name field is required!");
				else if(textField_InputNumberPhone.getText().equals("")) lblAddStatus.setText("Number phone field is required!");
				else if(textField_InputNationalCode.getText().equals("")) lblAddStatus.setText("National code field is required!");
				else if(textField_InputNationalCode.getText().length() != 10) lblAddStatus.setText("The national code must be 10 characters!");
				else {
					Frame_Refresh();
					pnl_StudentProfile.setEnabled(false);
					
					if(sendRequest(App.this.formatInputData()).equals("Student added!")) {
						System.out.println(App.this.formatInputData());
						
						for(int i=0; i<classes.size(); i++) {
							if(classes.get(i).getName().equals(comboInputChooseClass_1.getSelectedItem())) {
								classes.get(i).addStudent((classes.get(i).numberOfStudent()+1)+"", textField_InputFirstName.getText(), textField_InputLastName.getText(), textField_InputFatherName.getText(), textField_InputNumberPhone.getText(), textField_InputNationalCode.getText());
								break;
							}
						}
						pnl_StudentProfile.setVisible(false);
						lblAddStatus.setVisible(false);
						show();
					}
				}
			}
		});
		
		btnSubmit_add.setHorizontalAlignment(SwingConstants.CENTER);
		btnSubmit_add.setFont(new Font("Tahoma", Font.PLAIN, ۱۸));
		btnSubmit_add.setBounds(311, 558, 80, 35);
		pnl_StudentProfile.add(btnSubmit_add);
		
		btnCancel_add = new JButton("Cancel");
		btnCancel_add.setFocusPainted(false);
		btnCancel_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnl_StudentProfile.setVisible(false);
			}
		});
		
		btnCancel_add.setHorizontalAlignment(SwingConstants.CENTER);
		btnCancel_add.setFont(new Font("Tahoma", Font.PLAIN, ۱۸));
		btnCancel_add.setBounds(209, 558, 85, 35);
		pnl_StudentProfile.add(btnCancel_add);
		
		textField_InputLastName = new JTextField();
		textField_InputLastName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_InputLastName.setBackground(new Color(10, 18, 20));
		textField_InputLastName.setToolTipText("father's name");
		textField_InputLastName.setForeground(new Color(242, 170, 76));
		textField_InputLastName.setColumns(10);
		textField_InputLastName.setBounds(138, 124, 188, 26);
		pnl_StudentProfile.add(textField_InputLastName);
		
		lblLastName = new JLabel("Last Name:");
		lblLastName.setForeground(new Color(242, 170, 76));
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, ۱۶));
		lblLastName.setBounds(10, 124, 316, 29);
		pnl_StudentProfile.add(lblLastName);
		
		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
		JLabel lbl_tbl_Row = new JLabel("Row");
		lbl_tbl_Row.setForeground(new Color(242, 170, 76));
		lbl_tbl_Row.setBackground(new Color(50, 50, 50));
		lbl_tbl_Row.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_tbl_Row.setFont(new Font("Consolas", Font.BOLD, ۲۰));
		lbl_tbl_Row.setBounds(0, 114, 60, 40);
		lbl_tbl_Row.setOpaque(true);
		lbl_tbl_Row.setBorder(border);
		pnl_main.add(lbl_tbl_Row);
		
		JLabel lbl_tbl_FirstName = new JLabel("First name");
		lbl_tbl_FirstName.setBackground(new Color(50, 50, 50));
		lbl_tbl_FirstName.setForeground(new Color(242, 170, 76));
		lbl_tbl_FirstName.setOpaque(true);
		lbl_tbl_FirstName.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_tbl_FirstName.setFont(new Font("Consolas", Font.BOLD, ۲۰));
		lbl_tbl_FirstName.setBounds(60, 114, 280, 40);
		lbl_tbl_FirstName.setBorder(border);
		pnl_main.add(lbl_tbl_FirstName);
		
		JLabel lbl_tbl_LastName = new JLabel("Last name");
		lbl_tbl_LastName.setBackground(new Color(50, 50, 50));
		lbl_tbl_LastName.setForeground(new Color(242, 170, 76));
		lbl_tbl_LastName.setOpaque(true);
		lbl_tbl_LastName.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_tbl_LastName.setFont(new Font("Consolas", Font.BOLD, ۲۰));
		lbl_tbl_LastName.setBounds(340, 114, 280, 40);
		lbl_tbl_LastName.setBorder(border);
		pnl_main.add(lbl_tbl_LastName);
		
		JLabel lbl_tbl_VationalCode = new JLabel("National code");
		lbl_tbl_VationalCode.setBackground(new Color(50, 50, 50));
		lbl_tbl_VationalCode.setForeground(new Color(242, 170, 76));
		lbl_tbl_VationalCode.setOpaque(true);
		lbl_tbl_VationalCode.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_tbl_VationalCode.setFont(new Font("Consolas", Font.BOLD, ۲۰));
		lbl_tbl_VationalCode.setBounds(620, 114, 200, 40);
		lbl_tbl_VationalCode.setBorder(border);
		pnl_main.add(lbl_tbl_VationalCode);
		
		JLabel lbl_tbl_Present = new JLabel("Present");
		lbl_tbl_Present.setBackground(new Color(50, 50, 50));
		lbl_tbl_Present.setForeground(new Color(242, 170, 76));
		lbl_tbl_Present.setOpaque(true);
		lbl_tbl_Present.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_tbl_Present.setFont(new Font("Consolas", Font.BOLD, ۲۰));
		lbl_tbl_Present.setBounds(820, 114, 90, 40);
		lbl_tbl_Present.setBorder(border);
		pnl_main.add(lbl_tbl_Present);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 152, 1090, 602);
		pnl_main.add(scrollPane);
		
		tbl = new JPanel();
		tbl.setForeground(Color.WHITE);
		tbl.setBackground(new Color(50, 50, 50));
		scrollPane.setViewportView(tbl);
		
		GridBagLayout gbl_tbl = new GridBagLayout();
		gbl_tbl.columnWidths = new int[] {1100};
		gbl_tbl.rowHeights = new int[] {40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40};
		gbl_tbl.columnWeights = new double[]{0.0};
		gbl_tbl.rowWeights = new double[]{0.0, 0.0};
		tbl.setLayout(gbl_tbl);
//		comboInputChooseClass = new JComboBox<String>();
		
		comboShowMode = new JComboBox();
		comboShowMode.setBackground(new Color(16, 24, 32));
		comboShowMode.setForeground(new Color(242, 170, 76));
		comboShowMode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				show();
			}
		});
		comboShowMode.setFont(new Font("Vazirmatn", Font.PLAIN, ۱۸));
		comboShowMode.setModel(new DefaultComboBoxModel(new String[] {"Attendance list", "List of persons", "Absentee list", "Present list"}));
		comboShowMode.setBounds(413, 68, 200, 36);
		pnl_main.add(comboShowMode);
		
		searchField = new JTextField();
		searchField.setBackground(new Color(16, 24, 32));
		searchField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(searchField.getText().equals("Type here to search")) {
					searchField.setText("");
					searchField.setForeground(new Color(242, 170, 76));
				}
			}
		});
		searchField.setText("Type here to search");
		searchField.setForeground(Color.LIGHT_GRAY);
		searchField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(searchField.getText().length() <= 1 && e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
					searchField.setText("Type here to searchh");
					searchField.setForeground(Color.LIGHT_GRAY);
				}
				else if(searchField.getText().equals("Type here to search")) {
					searchField.setText("");
					searchField.setForeground(new Color(242, 170, 76));
				}
			}
		});
		searchField.setFont(new Font("Vazirmatn", Font.PLAIN, ۱۸));
		searchField.setBounds(1109, 102, 351, 40);
		pnl_main.add(searchField);

		
		comboChooseClass = new JComboBox<String>();
		comboChooseClass.setBackground(new Color(16, 24, 32));
		comboChooseClass.setForeground(new Color(242, 170, 76));
		comboInputChooseClass_1 = 
		new JComboBox<String>();
		comboInputChooseClass_1.setBackground(new Color(16, 24, 32));
		comboInputChooseClass_1.setForeground(new Color(242, 170, 76));
		comboChooseClass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (is_first_action_performed_of_combo) is_first_action_performed_of_combo = false;
				else show();					
			}
		});
		
		comboChooseClass.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, ۲۰));
//		comboChooseClass.setModel(new DefaultComboBoxModel(new String[] {"Add Class"}));
		comboChooseClass.setBounds(78, 69, 232, 35);
		pnl_main.add(comboChooseClass);
		
		comboInputChooseClass_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, ۲۰));
		comboInputChooseClass_1.setBounds(94, 278, 232, 35);
		pnl_StudentProfile.add(comboInputChooseClass_1);
		
		btnEdit = new JLabel("");
		btnEdit.setIcon(new ImageIcon("D:\\Programming\\Java\\dhgz\\dhgz\\Icons\\edit-free-icon-font.png"));
		btnEdit.setForeground(new Color(242, 170, 76));
		btnEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SchoolClass.editStudentInFront();
				btnSubmit_add.setVisible(false);
				btnCancel_add.setVisible(false);
				btnSubmit_edit.setVisible(true);
				btnCancel_edit.setVisible(true);
			}
		});
		btnEdit.setHorizontalAlignment(SwingConstants.CENTER);
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnEdit.setBounds(10, 541, 60, 60);
		pnl_StudentProfile.add(btnEdit);
		btnEdit.setBorder(borders);
		
		btnCancel_edit = new JButton("Cancel");
		btnCancel_edit.setFocusPainted(false);
		btnCancel_edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnl_StudentProfile.setVisible(false);
			}
		});
		btnCancel_edit.setHorizontalAlignment(SwingConstants.CENTER);
		btnCancel_edit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCancel_edit.setBounds(209, 558, 85, 35);
		pnl_StudentProfile.add(btnCancel_edit);
		
		btnSubmit_edit = new JButton("OK");
		btnSubmit_edit.setFocusPainted(false);
		btnSubmit_edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//for(int i=0; i<classes.size(); i++) {
					//if(classes.get(i).getName().equals(comboInputChooseClass.getSelectedItem())) {
						SchoolClass.editStudentInBack(textField_InputFirstName.getText(), textField_InputLastName.getText(), textField_InputFatherName.getText(), textField_InputNumberPhone.getText(), textField_InputNationalCode.getText());
						btnEdit.setVisible(true);
						pnl_StudentProfile.setVisible(true);
						lblFirstName.setText("First Name:"+SchoolClass.last_student_displayed.getFirstName());
						lblLastName.setText("Last Name:"+SchoolClass.last_student_displayed.getLastName());
						lblFathersName.setText("Father's Name:"+SchoolClass.last_student_displayed.getFatherName());
						lblNationalCode.setText("National Code:"+SchoolClass.last_student_displayed.getNationalCode());
						lblNumberPhone.setText("Number Phone:"+SchoolClass.last_student_displayed.getNumberPhone());
						lblClass.setText("Class:"+SchoolClass.last_student_displayed.getClassName());
						rdbtnAbsent.setEnabled(false);
						rdbtnPresent.setEnabled(false);
						textField_InputFirstName.setVisible(false);
						textField_InputLastName.setVisible(false);
						textField_InputFatherName.setVisible(false);
						textField_InputNationalCode.setVisible(false);
						textField_InputNumberPhone.setVisible(false);
					//}
				//}
			}
		});
		btnSubmit_edit.setHorizontalAlignment(SwingConstants.CENTER);
		btnSubmit_edit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSubmit_edit.setBounds(311, 558, 76, 35);
		pnl_StudentProfile.add(btnSubmit_edit);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pnl_StudentProfile.setVisible(false);
			}
		});
		lblNewLabel_2.setIcon(new ImageIcon("D:\\Programming\\Java\\dhgz\\dhgz\\Icons\\cross-free-icon-font.png"));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(361, 0, 30, 30);
		pnl_StudentProfile.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("D:\\Programming\\Java\\dhgz\\dhgz\\Icons\\plus-free-icon-font.png"));
		lblNewLabel.setForeground(new Color(242, 170, 76));
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pnl_StudentProfile.setVisible(true);
				rdbtnPresent.setVisible(false);
				rdbtnAbsent.setVisible(false);
				btnEdit.setVisible(false);
				lblFirstName.setText("First Name:");
				lblLastName.setText("Last Name:");
				lblFathersName.setText("Father's Name:");
				lblNationalCode.setText("National Code:");
				lblNumberPhone.setText("Number Phone:");
				lblClass.setText("Class:");
				textField_InputFirstName.setVisible(true);
				textField_InputLastName.setVisible(true);
				textField_InputFatherName.setVisible(true);
			 	textField_InputNationalCode.setVisible(true);
				textField_InputNumberPhone.setVisible(true);
				btnSubmit_edit.setVisible(false);
				btnCancel_edit.setVisible(false);
				btnSubmit_add.setVisible(true);
				btnCancel_add.setVisible(true);
				textField_InputFirstName.setText("");
				textField_InputLastName.setText("");
				textField_InputFatherName.setText("");
				textField_InputNationalCode.setText("");
				textField_InputNumberPhone.setText("");
			}
		});
		lblNewLabel.setBounds(0, 0, 60, 60);
		pnl_main.add(lblNewLabel);
		
		lblNewLabel.setBorder(borders);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon("D:\\Programming\\Java\\dhgz\\dhgz\\Icons\\settings-free-icon-font.png"));
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmJustDarkMode.getContentPane().remove(pnl_main);
				frmJustDarkMode.getContentPane().add(pnl_Setting);
				Frame_Refresh();
			}
		});
		lblNewLabel_1.setForeground(new Color(242, 170, 76));
		lblNewLabel_1.setBounds(90, 0, 60, 60);
		pnl_main.add(lblNewLabel_1);
		lblNewLabel_1.setBorder(borders);
		
		JLabel btnStopStart = new JLabel("");
		btnStopStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				isManualStarted = !isManualStarted;
				if(sendRequest("http://"+ESP_IP+"//set-manual-attendance?is_manual_started="+isManualStarted).equals("Attendance began"))
					System.out.println("Attendance began");
				else
					System.out.println("Attendance is over");
				if(isManualStarted)
					btnStopStart.setIcon(new ImageIcon("D:\\Programming\\Java\\dhgz\\dhgz\\Icons\\stop-free-icon-font.png"));					
				else
					btnStopStart.setIcon(new ImageIcon("D:\\Programming\\Java\\dhgz\\dhgz\\Icons\\play-free-icon-font.png"));
			}
		});
		btnStopStart.setIcon(new ImageIcon("D:\\Programming\\Java\\dhgz\\dhgz\\Icons\\play-free-icon-font.png"));
		btnStopStart.setHorizontalAlignment(SwingConstants.CENTER);
		btnStopStart.setForeground(new Color(242, 170, 76));
		btnStopStart.setBounds(180, 0, 60, 60);
		pnl_main.add(btnStopStart);
		btnStopStart.setBorder(borders);
		
		JComboBox comboMonths = new JComboBox();
		comboMonths.setForeground(new Color(242,170,76));
		comboMonths.setBackground(new Color(16, 24, 32));
		comboMonths.setMaximumRowCount(12);
		comboMonths.setFont(new Font("Vazirmatn", Font.PLAIN, ۱۶));
		comboMonths.setModel(new DefaultComboBoxModel(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		comboMonths.setBounds(193, 30, 114, 30);
		date_time = LocalDateTime.now();
		comboMonths.setSelectedIndex(date_time.getMonthValue()-1);
		panel.add(comboMonths);
		
		JLabel lblNewLabel_5 = new JLabel("Class:");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setFont(new Font("Vazirmatn", Font.PLAIN, ۱۸));
		lblNewLabel_5.setBounds(15, 68, 75, 36);
		pnl_main.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("Show:");
		lblNewLabel_5_1.setForeground(Color.WHITE);
		lblNewLabel_5_1.setFont(new Font("Vazirmatn", Font.PLAIN, ۱۸));
		lblNewLabel_5_1.setBounds(350, 68, 75, 36);
		pnl_main.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(863, 11, 259, 112);
		frmJustDarkMode.getContentPane().add(lblNewLabel_4);
		
		for(int i=0; i<classes.size(); i++) {
			comboInputChooseClass_1.addItem(classes.get(i).getName());
			comboChooseClass.addItem(classes.get(i).getName());
		}
		comboChooseClass.addItem("Add Class");
		
		
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				dateTime = LocalDateTime.now();
				if(isPresentTime()) {
					String presents = sendRequest("http://"+ESP_IP+"/present");
					System.out.println(presents);
					unpack_string(today_students, presents, '*');
					System.out.println(today_students);
					show();					
				}
			}
		}, 3000, 5000); // after first 3s do the run code whit 5s delay
		
		dateTime = LocalDateTime.now();

		Frame_Refresh();
	}
	
	public boolean isPresentTime() {
		int start_h = Integer.parseInt(pnl_Setting.spinner_of_start_hour.getValue().toString());
		int start_m = Integer.parseInt(pnl_Setting.spinner_of_start_min.getValue().toString());
		int end_h	= Integer.parseInt(pnl_Setting.spinner_of_end_hour.getValue().toString());
		int end_m	= Integer.parseInt(pnl_Setting.spinner_of_end_min.getValue().toString());
		int h = dateTime.getHour(), m=dateTime.getMinute();
		return (isManualStarted || ((h > start_h || (h == start_h && m >= start_m)) && (h < end_h || (h == end_h && m <= end_m))));
	}
	
	// unpack the server response and put the extracted data to students lists
	public boolean unpack_string(ArrayList<Student>students_input, String str_input, char separator_char){
		if(today_students.size() > 0) {
			for(int i=0; i<today_students.size(); i++) {
				today_students.remove(i);
			}
		}
		int number_of_strings = 0;
		for (int i=0; i<str_input.length(); i++)
			number_of_strings += (str_input.charAt(i) == separator_char)? 1:0;
		--number_of_strings;
		System.out.println(number_of_strings);
		
		int index_of_separator_char = str_input.indexOf(""+separator_char);
		for (int i=0; i<number_of_strings; i++) {
			int last_index_of_separator_char = index_of_separator_char;
			for(int j=last_index_of_separator_char+1; j<str_input.length(); j++){
				if(str_input.charAt(j) == separator_char){
					index_of_separator_char=j;
					break;
				}
			}
			String str_output = "";
			for(int k=last_index_of_separator_char+1; k<index_of_separator_char; k++)
				str_output += str_input.charAt(k);
			System.out.println(str_output);
			for(int j=0; j<classes.size(); j++) {
				for(int k=0; k<classes.get(j).getStudents().size(); k++) {
					if(classes.get(j).getStudents().get(k).getNationalCode().startsWith(str_output)) {
						System.out.println(classes.get(j).getStudents().get(k).getFirstName());
						today_students.add(new Student(""+j, classes.get(j).getStudents().get(k).getFirstName(), classes.get(j).getStudents().get(k).getLastName(), classes.get(j).getStudents().get(k).getFatherName(), classes.get(j).getStudents().get(k).getNumberPhone(), classes.get(j).getStudents().get(k).getNationalCode(), classes.get(j).getStudents().get(k).getClassName()));
						break;
					}
				}
			}
		}
		return true;
	}
	
	// Add the last added class to combo boxes and handle add "Add Class" item
	public void addLastClassToCombo() {
		if(classes.size() > 0) {
			comboChooseClass.removeItem("Add Class");
			comboChooseClass.addItem(classes.get(classes.size()-1).getName());			
			comboInputChooseClass_1.addItem(classes.get(classes.size()-1).getName());	
		}
		comboChooseClass.addItem("Add Class");
		comboChooseClass.setSelectedIndex(classes.size()-1);
		comboInputChooseClass_1.setSelectedIndex(classes.size()-1);
		Frame_Refresh();
	}
	
	// Show any student list in table
	public void generalShow(ArrayList<Student> students_list) {
		tbl.removeAll();
		for(int i=0; i<students_list.size(); i++) {
			GridBagConstraints z = new GridBagConstraints();
			z.gridwidth = 0;
			z.gridx = 0;
			z.fill = GridBagConstraints.BOTH;
			z.gridy = i;
			tbl.add(students_list.get(i), z);
		}
		Frame_Refresh();
	}

	public void show() {
		if(comboChooseClass.getSelectedItem() == "Add Class") { // if add class:
			ClassNameDialog cnd = new ClassNameDialog(App.this);
			cnd.setVisible(true);
		}
		else if(comboChooseClass.getSelectedIndex() >= 0){ // SelectedIndex() is not -1
			switch (comboShowMode.getSelectedIndex()) {
				case ATTENDANCE_LIST:
					classes.get(comboChooseClass.getSelectedIndex()).toAL_Mode();
					generalShow(getAttendanceList(classes.get(comboChooseClass.getSelectedIndex()).getStudents(), today_students));
					lbl_tbl_Present.setVisible(true);
					break;
				case LIST_OF_PERSONS:
					lbl_tbl_Present.setVisible(false);
					generalShow(classes.get(comboChooseClass.getSelectedIndex()).getStudents());
					classes.get(comboChooseClass.getSelectedIndex()).toLOP_Mode();
					break;
				case ABSENTEE_LIST:
					generalShow(getAbsents(classes.get(comboChooseClass.getSelectedIndex()).getStudents(), today_students));
					lbl_tbl_Present.setVisible(false);
					break;
				case PRESENT_LIST:
					for(int i=0; i<today_students.size(); i++) 
						today_students.get(i).setToLOP_Mode();
					lbl_tbl_Present.setVisible(false);
					System.out.println(today_students.size());
					generalShow(getPresent(today_students));
					break;
				default:
					break;
			}
		}
		Frame_Refresh();
	}
	
	public ArrayList<Student> getAttendanceList(ArrayList<Student> all_student, ArrayList<Student> present_student) {
		for(int i=0; i<all_student.size(); i++) {
			if(present_student.size() <= 0) 
				all_student.get(i).setAsAbsent();
			else {
				for(int j=0; j<present_student.size(); j++) {
					if(all_student.get(i).getNationalCode().equals(present_student.get(j).getNationalCode())) {
						all_student.get(i).setAsPresent();
						break;
					}
					else
						all_student.get(i).setAsAbsent();
				}
			}
		}
		Frame_Refresh();
		return all_student;
	}
	
	public ArrayList<Student> getAbsents(ArrayList<Student> all_student, ArrayList<Student> present_student) {
		ArrayList<Student> absents = new ArrayList<Student>();
		for(int i=0; i<all_student.size(); i++) {
			boolean isAbsent = true;
			for(int j=0; j<present_student.size(); j++) {
				if(all_student.get(i).getNationalCode().equals(present_student.get(j).getNationalCode())) {
					isAbsent = false;
					break;
				}
			}
			if(isAbsent)
				absents.add(new Student(""+(absents.size()+1), all_student.get(i).getFirstName(), all_student.get(i).getLastName(), all_student.get(i).getFatherName(), all_student.get(i).getNumberPhone(), all_student.get(i).getNationalCode(), all_student.get(i).getClassName()));
		}
		for(int i=0; i<absents.size(); i++) 
			absents.get(i).setToLOP_Mode();
		System.out.println(absents.size());
		return absents;
	}
	
	public ArrayList<Student> getPresent(ArrayList<Student> present_student) {
		ArrayList<Student> present_in_this_class = new ArrayList<Student>();
		for(int i=0; i<present_student.size(); i++) {
			if(classes.get(comboChooseClass.getSelectedIndex()).getName().equals(present_student.get(i).getClassName())) {
				present_in_this_class.add(present_student.get(i));
			}
		}
		return present_in_this_class;
	}
	
	public void addClass(String class_name) {
		classes.add(new SchoolClass(this, class_name));
		try {
			Connection connection = DriverManager.getConnection("jdbc:sqlite:D:\\Programming\\Java\\Kharazmi\\Kharazmi\\Student_Reference_Database\\Student_Reference_Database.db");
			java.sql.Statement statement = connection.createStatement();
			String query="INSERT INTO ClassTable values('%s')";
			query=String.format(query, class_name);
			
			statement.executeUpdate(query);
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		addLastClassToCombo();
	}
	
	// return formated address form input student data
	public String formatInputData() { 
		return "http://"+ESP_IP+"/add?FName="+textField_InputFirstName.getText()+"&LName="+textField_InputLastName.getText()+"&Number="+textField_InputNumberPhone.getText()+"&Code="+textField_InputNationalCode.getText();
	}
	
	// send a HTTP request to the addrass and check the server response and return it
	public static String sendRequest(String Addres) {
		try {
			URL urlForGetReq = new URL(spaceKiller(Addres));
			String read = null;  
			HttpURLConnection connection = (HttpURLConnection) urlForGetReq.openConnection();  
			connection.setRequestMethod("GET"); 
			int codeResponse = connection.getResponseCode();  
			// checking whether the connection has been established or not  
			if (codeResponse == HttpURLConnection.HTTP_OK) {  
				System.out.println("Request sended!");
				// reading the response from the server  
				InputStreamReader isrObj = new InputStreamReader(connection.getInputStream());  
				BufferedReader bf = new BufferedReader(isrObj);  
				// to store the response from the servers  
				StringBuffer responseStr = new StringBuffer();  
				while ((read = bf.readLine()) != null)
				    responseStr.append(read);  
				// closing the BufferedReader  
				bf.close();  
				// disconnecting the connection  
				connection.disconnect(); 
				return spaceSavior(responseStr.toString());
			}   
			else System.out.println("GET Request did not work");  		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return "";
	}
	
	public void saveSettingsPanel(Settings s, String file_name) {
		File f = new File(file_name);
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(f);
			ObjectOutputStream o = new ObjectOutputStream(fos);
			o.writeObject(s);
			o.close();
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Settings loadSettingsPanel(String file_name) {
		Settings s = null;
		File fi = new File(file_name);
		FileInputStream f;
		try {
			f = new FileInputStream(fi);
			ObjectInputStream o = new ObjectInputStream(f);
			s = (Settings) o.readObject();
			o.close();
			f.close();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(s == null) 
			s = new Settings(this);
		return s;
	}
	
	public void Frame_Refresh() {
		frmJustDarkMode.revalidate();
		frmJustDarkMode.repaint();
	}
	
	public ArrayList<SchoolClass> getClasses() {
		return App.this.classes;
	}
	
	public static String spaceKiller(String str) {
		char[] arr_str = str.toCharArray();
		for(int i=0; i<str.length(); i++) 
			if(str.charAt(i) == ' ') arr_str[i] = '$';
		str = String.valueOf(arr_str);
		return str;
	}
	
	public static String spaceSavior(String str) {
		char[] arr_str = str.toCharArray();
		for(int i=0; i<str.length(); i++) 
			if(str.charAt(i) == '$') arr_str[i] = ' ';
		str = String.valueOf(arr_str);
		return str;
	}
}
