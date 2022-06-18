


import javax.swing.JPanel;
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
//import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JMenuBar;
import javax.swing.JSpinner;
import javax.swing.JScrollBar;
import javax.swing.JDesktopPane;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import org.json.JSONObject;
import org.json.JSONStringer;
import org.json.JSONWriter;

import java.awt.Scrollbar;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Canvas;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

import javax.swing.JToolBar;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Settings extends JPanel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5572715587414161627L;
	private JFrame frame;
	private JTextField networkNemeField;
	private JTextField textField_SaveDataByMonth;
	private JTextField adminEmailField;
	private JPasswordField networkPasswordField;
	private JPasswordField settingsPasswordField;
	private JTextField textField_SaveDataByMonthInApp;
	private boolean list_button_state=false;
	private boolean list_button_state_1=false;
	private boolean is_eye = true;
	private boolean is_eye_1 = true;
	private JRadioButton rdbtnDark;
	private JRadioButton rdbtnLight;
	public JSpinner spinner_of_start_hour;
	public JSpinner spinner_of_start_min;
	public JSpinner spinner_of_end_hour;
	public JSpinner spinner_of_end_min;
	private JComboBox comboBoxVoiceCMD;
	private JComboBox comboLanguage;
//	App hasan=this;
	//////////////////////////////////
	private static boolean turn=true;
	private static boolean is_first=true;
	private JLabel btnSendEmailToAdmin;
	private JLabel Circle;
	private Timer timer;
	private static int x1 = 307;
	//////////////////////////////////
	private static boolean turn_1=true;
	private static boolean is_first_1=true;
	private JLabel btnAbilityOfTheBlind;
	private JLabel Circle_1;
	private Timer timer_1;
	private static int x2 = 307;
	//////////////////////////////////
	private static boolean turn_2=true;
	private static boolean is_first_2=true;
	private JLabel btnMessagingToParents;
	private JLabel Circle_2;
	private Timer timer_2;
	private static int x3 = 900;
	//////////////////////////////////
	private static boolean turn_3=true;
	private static boolean is_first_3=true;
	private JLabel btnCallingingToParents;
	private JLabel Circle_3;
	private Timer timer_3;
	private static int x4 = 900;
	//////////////////////////////////
	private static boolean turn_4=true;
	private static boolean is_first_4=true;
	private JLabel btnNotification;
	private JLabel Circle_4;
	private Timer timer_4;
	private static int x5 = 900;
	//////////////////////////////////
	public App app=null;

	///////////////////////////////////////////////////////////////////////////////
	public class MyActionListener_front implements ActionListener{
	@Override
		public void actionPerformed(ActionEvent arg0) {
			Circle.setLocation(x1++, 377);
			if(x1>=351) {
				timer.stop();
				remove(btnSendEmailToAdmin);
				add(btnSendEmailToAdmin );
				btnSendEmailToAdmin.setIcon(new ImageIcon("D:\\Programming\\Java\\dhgz\\dhgz\\Icons\\red_on_button00small.png"));
				turn=false;
			}
		}
	}
	public class MyActionListener_back implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Circle.setLocation(x1--, 377);
			if(x1<=308) {
				timer.stop();
				remove(btnSendEmailToAdmin);
				add(btnSendEmailToAdmin );
				btnSendEmailToAdmin.setIcon(new ImageIcon("D:\\Programming\\Java\\dhgz\\dhgz\\Icons\\green_on_button00small.png"));
				turn=true;
			}
		}
	}
	//////////////////////////////////////////////////////////////////////////

	public class MyActionListener_front_1 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Circle_1.setLocation(x2++, 557);
			if(x2>=351) {
				timer_1.stop();
				remove(btnAbilityOfTheBlind);
				add(btnAbilityOfTheBlind );
				btnAbilityOfTheBlind.setIcon(new ImageIcon("D:\\Programming\\Java\\dhgz\\dhgz\\Icons\\red_on_button00small.png"));
				turn_1=false;
			}
		}
	}
	public class MyActionListener_back_1 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Circle_1.setLocation(x2--, 557);
			if(x2<=308) {
				timer_1.stop();
				remove(btnAbilityOfTheBlind);
				add(btnAbilityOfTheBlind);
				btnAbilityOfTheBlind.setIcon(new ImageIcon("D:\\Programming\\Java\\dhgz\\dhgz\\Icons\\green_on_button00small.png"));
				turn_1=true;
			}
		}
	}
	
	public class MyActionListener_front_2 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Circle_2.setLocation(x3++, 17);
			if(x3>=943) {
				timer_2.stop();
				remove(btnMessagingToParents);
				add(btnMessagingToParents);
				btnMessagingToParents.setIcon(new ImageIcon("D:\\Programming\\Java\\dhgz\\dhgz\\Icons\\red_on_button00small.png"));
				turn_2=false;
			}
		}
	}
	public class MyActionListener_back_2 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Circle_2.setLocation(x3--, 17);
			if(x3<=900) {
				timer_2.stop();
				remove(btnMessagingToParents);
				add(btnMessagingToParents);
				btnMessagingToParents.setIcon(new ImageIcon("D:\\Programming\\Java\\dhgz\\dhgz\\Icons\\green_on_button00small.png"));
				turn_2=true;
			}
		}
	}
	
	public class MyActionListener_front_3 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Circle_3.setLocation(x4++, 67);
			if(x4>=943) {
				timer_3.stop();
				remove(btnCallingingToParents);
				add(btnCallingingToParents);
				btnCallingingToParents.setIcon(new ImageIcon("D:\\Programming\\Java\\dhgz\\dhgz\\Icons\\red_on_button00small.png"));
				turn_3=false;
			}
		}
	}
	public class MyActionListener_back_3 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Circle_3.setLocation(x4--, 67);
			if(x4<=900) {
				timer_3.stop();
				remove(btnCallingingToParents);
				add(btnCallingingToParents);
				btnCallingingToParents.setIcon(new ImageIcon("D:\\Programming\\Java\\dhgz\\dhgz\\Icons\\green_on_button00small.png"));
				turn_3=true;
			}
		}
	}
	
	public class MyActionListener_front_4 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Circle_4.setLocation(x5++, 377);
			if(x5>=943) {
				timer_4.stop();
				remove(btnNotification);
				add(btnNotification);
				btnNotification.setIcon(new ImageIcon("D:\\Programming\\Java\\dhgz\\dhgz\\Icons\\red_on_button00small.png"));
				turn_4=false;
			}
		}
	}
	public class MyActionListener_back_4 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Circle_4.setLocation(x5--, 377);
			if(x5<=900) {
				timer_4.stop();
				remove(btnNotification);
				add(btnNotification);
				btnNotification.setIcon(new ImageIcon("D:\\Programming\\Java\\dhgz\\dhgz\\Icons\\green_on_button00small.png"));
				turn_4=true;
			}
		}
	}
	
	public Settings(App app) {
		setBackground(new Color(40, 40, 40));
		this.app = app;
		setLayout(null);
		setBounds(10, 11, 1516, 765);
		
		JLabel lblNetworkName = new JLabel("Network name");
		lblNetworkName.setForeground(new Color(242, 170, 76));
		lblNetworkName.setFont(new Font("Arbaeen", Font.PLAIN, 22));
		lblNetworkName.setBounds(14, 70, 190, 40);
		add(lblNetworkName);
		
		JLabel lblNetworkPassword = new JLabel("Network password");
		lblNetworkPassword.setForeground(new Color(242, 170, 76));
		lblNetworkPassword.setFont(new Font("Arbaeen", Font.PLAIN, 22));
		lblNetworkPassword.setBounds(14, 130, 200, 40);
		add(lblNetworkPassword);
		
		JLabel lblStartTimeOf = new JLabel("Start time of absence");
		lblStartTimeOf.setForeground(new Color(242, 170, 76));
		lblStartTimeOf.setFont(new Font("Arbaeen", Font.PLAIN, 22));
		lblStartTimeOf.setBounds(14, 190, 210, 40);
		add(lblStartTimeOf);
		
		JLabel lblEndTimeOf = new JLabel("End time of absence");
		lblEndTimeOf.setForeground(new Color(242, 170, 76));
		lblEndTimeOf.setFont(new Font("Arbaeen", Font.PLAIN, 22));
		lblEndTimeOf.setBounds(14, 250, 210, 40);
		add(lblEndTimeOf);
		
		JLabel lblTimeToSave = new JLabel("Time to save data on SD card (By month)");
		lblTimeToSave.setForeground(new Color(242, 170, 76));
		lblTimeToSave.setFont(new Font("Arbaeen", Font.PLAIN, 22));
		lblTimeToSave.setBounds(14, 310, 428, 40);
		add(lblTimeToSave);
		
		JLabel lblAdminEmail = new JLabel("Admin Email");
		lblAdminEmail.setForeground(new Color(242, 170, 76));
		lblAdminEmail.setFont(new Font("Arbaeen", Font.PLAIN, 22));
		lblAdminEmail.setBounds(14, 430, 180, 40);
		add(lblAdminEmail);
		
		JLabel lblSendListToEmail = new JLabel("Send the list to admin");
		lblSendListToEmail.setForeground(new Color(242, 170, 76));
		lblSendListToEmail.setFont(new Font("Arbaeen", Font.PLAIN, 22));
		lblSendListToEmail.setBounds(14, 370, 220, 40);
		add(lblSendListToEmail);
		
		JLabel lblSettingsPassword = new JLabel("Settings password");
		lblSettingsPassword.setForeground(new Color(242, 170, 76));
		lblSettingsPassword.setFont(new Font("Arbaeen", Font.PLAIN, 22));
		lblSettingsPassword.setBounds(14, 490, 210, 40);
		add(lblSettingsPassword);
		
		JLabel lblAbilityOfTheBlind = new JLabel("Ability of the blind");
		lblAbilityOfTheBlind.setForeground(new Color(242, 170, 76));
		lblAbilityOfTheBlind.setFont(new Font("Arbaeen", Font.PLAIN, 22));
		lblAbilityOfTheBlind.setBounds(14, 550, 180, 40);
		add(lblAbilityOfTheBlind);
		
		JLabel lblBlind_voice_cmd = new JLabel("Blind voice command");
		lblBlind_voice_cmd.setForeground(new Color(242, 170, 76));
		lblBlind_voice_cmd.setFont(new Font("Arbaeen", Font.PLAIN, 22));
		lblBlind_voice_cmd.setBounds(14, 610, 220, 40);
		add(lblBlind_voice_cmd);
		
		networkNemeField = new JTextField();
		networkNemeField.setText("MyNet");
		networkNemeField.setForeground(new Color(242,170,76));
		networkNemeField.setBackground(new Color(16, 24, 32));
		networkNemeField.setFont(new Font("Arbaeen", Font.PLAIN, 22));
		networkNemeField.setBounds(300, 70, 230, 40);
		add(networkNemeField);
		networkNemeField.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(642, 0, 1, 800);
		add(separator);
		
		JLabel btnNewButton = new JLabel("");
		btnNewButton.setHorizontalAlignment(SwingConstants.CENTER);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(is_eye==true) {
					networkPasswordField.setEchoChar((char) 0);
					 is_eye = false;
					 btnNewButton.setIcon(new ImageIcon("D:\\Programming\\Java\\dhgz\\dhgz\\Icons\\eye-free-icon-font.png"));
					}
					else  {
						networkPasswordField.setEchoChar('•');
					btnNewButton.setIcon(new ImageIcon("D:\\Programming\\Java\\dhgz\\dhgz\\Icons\\eye-crossed-free-icon-font.png"));
					 is_eye = true;
					}
			}
		});

		btnNewButton.setIcon(new ImageIcon("D:\\Programming\\Java\\dhgz\\dhgz\\Icons\\eye-crossed-free-icon-font.png"));
		btnNewButton.setBounds(540, 130, 45, 40);
		add(btnNewButton);
		
		spinner_of_start_hour = new JSpinner();
		spinner_of_start_hour.setFont(new Font("Tahoma", Font.PLAIN, 20));
		spinner_of_start_hour.setBounds(367, 192, 46, 40);
		add(spinner_of_start_hour);
		
		JLabel lblHour = new JLabel("Hour :");
		lblHour.setForeground(new Color(255, 165, 0));
		lblHour.setFont(new Font("Arbaeen", Font.PLAIN, 22));
		lblHour.setBounds(300, 190, 68, 40);
		add(lblHour);
		
		JLabel lblMin = new JLabel("Min :");
		lblMin.setForeground(new Color(255, 165, 0));
		lblMin.setFont(new Font("Arbaeen", Font.PLAIN, 22));
		lblMin.setBounds(434, 190, 68, 40);
		add(lblMin);
		
		spinner_of_start_min = new JSpinner();
		spinner_of_start_min.setFont(new Font("Tahoma", Font.PLAIN, 20));
		spinner_of_start_min.setBounds(501, 192, 46, 40);
		add(spinner_of_start_min);
		
		JLabel lblHour_1 = new JLabel("Hour :");
		lblHour_1.setForeground(new Color(255, 165, 0));
		lblHour_1.setFont(new Font("Arbaeen", Font.PLAIN, 22));
		lblHour_1.setBounds(300, 250, 68, 40);
		add(lblHour_1);
		
		spinner_of_end_hour = new JSpinner();
		spinner_of_end_hour.setFont(new Font("Tahoma", Font.PLAIN, 20));
		spinner_of_end_hour.setBounds(367, 250, 46, 40);
		add(spinner_of_end_hour);
		
		JLabel lblMin_1 = new JLabel("Min :");
		lblMin_1.setForeground(new Color(255, 165, 0));
		lblMin_1.setFont(new Font("Arbaeen", Font.PLAIN, 22));
		lblMin_1.setBounds(434, 250, 68, 40);
		add(lblMin_1);
		
		spinner_of_end_min = new JSpinner();
		spinner_of_end_min.setFont(new Font("Tahoma", Font.PLAIN, 20));
		spinner_of_end_min.setBounds(501, 250, 46, 40);
		add(spinner_of_end_min);
		
		textField_SaveDataByMonth = new JTextField();
		textField_SaveDataByMonth.setText("6");
		textField_SaveDataByMonth.setForeground(new Color(242,170,76));
		textField_SaveDataByMonth.setBackground(new Color(16, 24, 32));
		textField_SaveDataByMonth.setFont(new Font("Tahoma", Font.PLAIN, ۲۲));
		textField_SaveDataByMonth.setColumns(10);
		textField_SaveDataByMonth.setBounds(452, 310, 134, 40);
		add(textField_SaveDataByMonth);
		
		adminEmailField = new JTextField();
		adminEmailField.setText("mmd.gh313@gmail.com");
		adminEmailField.setForeground(new Color(242,170,76));
		adminEmailField.setBackground(new Color(16, 24, 32));

		adminEmailField.setFont(new Font("Arbaeen", Font.PLAIN, 22));
		adminEmailField.setColumns(10);
		adminEmailField.setBounds(300, 430, 286, 40);
		add(adminEmailField);
		
		networkPasswordField = new JPasswordField();
		networkPasswordField.setFont(new Font("Tahoma", Font.PLAIN, ۲۰));
		networkPasswordField.setForeground(new Color(242,170,76));
		networkPasswordField.setBackground(new Color(16, 24, 32));
		networkPasswordField.setBounds(300, 130, 230, 40);
		networkPasswordField.setText("12345678");
		add(networkPasswordField);                                                                                                                                               
		
		settingsPasswordField = new JPasswordField();
		settingsPasswordField.setFont(new Font("Tahoma", Font.PLAIN, ۲۰));
		settingsPasswordField.setForeground(new Color(242,170,76));
		settingsPasswordField.setBackground(new Color(16, 24, 32));
		settingsPasswordField.setBounds(300, 490, 230, 40);
		settingsPasswordField.setText("12345678");
		add(settingsPasswordField);
		
		JLabel lblCallingingToParents = new JLabel("Callinging to parents");
		lblCallingingToParents.setForeground(new Color(242, 170, 76));
		lblCallingingToParents.setFont(new Font("Arbaeen", Font.PLAIN, 22));
		lblCallingingToParents.setBounds(653, 60, 220, 40);
		add(lblCallingingToParents);
		
		JLabel lblMessagingToParents = new JLabel("Messaging to parents");
		lblMessagingToParents.setForeground(new Color(242, 170, 76));
		lblMessagingToParents.setFont(new Font("Arbaeen", Font.PLAIN, 22));
		lblMessagingToParents.setBounds(653, 10, 220, 40);
		add(lblMessagingToParents);
		
		JLabel lblDeviceSettings = new JLabel("Device settings");
		lblDeviceSettings.setForeground(new Color(255, 255, 255));
		lblDeviceSettings.setFont(new Font("Arbaeen", Font.BOLD, 28));
		lblDeviceSettings.setBounds(64, 0, 230, 40);
		add(lblDeviceSettings);
		
		JLabel lblApplicationSettings = new JLabel("Application settings");
		lblApplicationSettings.setForeground(new Color(255, 255, 255));
		lblApplicationSettings.setFont(new Font("Arbaeen", Font.BOLD, 28));
		lblApplicationSettings.setBounds(653, 190, 273, 40);
		add(lblApplicationSettings);
		
		JLabel lblApplicationTheme = new JLabel("Application theme");
		lblApplicationTheme.setForeground(new Color(242, 170, 76));
		lblApplicationTheme.setFont(new Font("Arbaeen", Font.PLAIN, 22));
		lblApplicationTheme.setBounds(653, 250, 240, 40);
		add(lblApplicationTheme);
		
		JLabel lblTimeToSaveInApp = new JLabel("Time to save data on computer (By month)");
		lblTimeToSaveInApp.setForeground(new Color(242, 170, 76));
		lblTimeToSaveInApp.setFont(new Font("Arbaeen", Font.PLAIN, 22));
		lblTimeToSaveInApp.setBounds(653, 310, 422, 40);
		add(lblTimeToSaveInApp);
		
		JLabel lblNotification = new JLabel("Notification");
		lblNotification.setForeground(new Color(242, 170, 76));
		lblNotification.setFont(new Font("Arbaeen", Font.PLAIN, 22));
		lblNotification.setBounds(653, 370, 180, 40);
		add(lblNotification);
		
		JLabel lblLanguage = new JLabel("Language");
		lblLanguage.setForeground(new Color(242, 170, 76));
		lblLanguage.setFont(new Font("Arbaeen", Font.PLAIN, 22));
		lblLanguage.setBounds(653, 430, 220, 40);
		add(lblLanguage);
		
		JLabel lblApplicationGuide = new JLabel("Application guide");
		lblApplicationGuide.setForeground(Color.WHITE);
		lblApplicationGuide.setFont(new Font("Arbaeen", Font.PLAIN, 22));
		lblApplicationGuide.setBounds(1326, 131, 180, 40);
		add(lblApplicationGuide);
		
		JLabel lblDeviceGuide = new JLabel("Device guide");
		lblDeviceGuide.setForeground(Color.WHITE);
		lblDeviceGuide.setFont(new Font("Arbaeen", Font.PLAIN, 22));
		lblDeviceGuide.setBounds(1323, 69, 169, 40);
		add(lblDeviceGuide);
		
		JLabel lblAboutUs = new JLabel("About us");
		lblAboutUs.setForeground(Color.WHITE);
		lblAboutUs.setBackground(new Color(101, 204, 255));
		lblAboutUs.setFont(new Font("Arbaeen", Font.PLAIN, 22));
		lblAboutUs.setBounds(1326, 0, 169, 40);
		add(lblAboutUs);
		
		JButton btnOK = new JButton("OK");
		btnOK.setForeground(new Color(242, 170, 76));
		btnOK.setBackground(App.background_color);
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(format_addres());
				if(App.sendRequest(format_addres()).equals("Settings saved!")) {
					System.out.println("Settings saved!");
				}
				app.frmJustDarkMode.getContentPane().remove(app.pnl_Setting);
				app.frmJustDarkMode.getContentPane().add(app.pnl_main);
				app.Frame_Refresh();
				saveSettings(App.SETTING_SAVE_PATH);
			}
		});
		btnOK.setFont(new Font("Tahoma", Font.PLAIN, ۱۸));
		btnOK.setToolTipText("applay and ok");
		btnOK.setBounds(1396, 711, 110, 40);
		btnOK.setBorder(App.borders);
		add(btnOK);
		
		textField_SaveDataByMonthInApp = new JTextField();
		textField_SaveDataByMonthInApp.setText("6");
		textField_SaveDataByMonthInApp.setForeground(new Color(242,170,76));
		textField_SaveDataByMonthInApp.setBackground(new Color(16, 24, 32));
		textField_SaveDataByMonthInApp.setFont(new Font("Tahoma", Font.PLAIN, ۲۲));
		textField_SaveDataByMonthInApp.setColumns(10);
		textField_SaveDataByMonthInApp.setBounds(1105, 310, 134, 40);
		add(textField_SaveDataByMonthInApp);
		
		rdbtnLight = new JRadioButton("Light");
		rdbtnLight.setBackground(new Color(40, 40, 40));
		rdbtnLight.setForeground(new Color(242,170,76));
		rdbtnLight.setSelected(true);
		rdbtnLight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnDark.setSelected(false);
			}
		});
		rdbtnLight.setFont(new Font("Arbaeen", Font.PLAIN, 22));
		rdbtnLight.setBounds(1121, 250, 118, 34);
		add(rdbtnLight);
		
		JLabel btnBack = new JLabel("");
		btnBack.setIcon(new ImageIcon("D:\\Programming\\Java\\dhgz\\dhgz\\Icons\\arrow-small-left-free-icon-font.png"));
		btnBack.setHorizontalAlignment(SwingConstants.CENTER);
		btnBack.setToolTipText("back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, ۱۸));
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				app.frmJustDarkMode.getContentPane().remove(app.pnl_Setting);
				app.frmJustDarkMode.getContentPane().add(app.pnl_main);
				app.Frame_Refresh();
			}
		});
		btnBack.setBounds(0, 0, 50, 40);
		add(btnBack);
		
		JButton btnSavaAsDefault = new JButton("Save as default");
		btnSavaAsDefault.setForeground(App.foreground_color);
		btnSavaAsDefault.setBackground(App.background_color);
		btnSavaAsDefault.setFont(new Font("Tahoma", Font.PLAIN, ۱۸));
		btnSavaAsDefault.setToolTipText("save as default");
		btnSavaAsDefault.setBounds(1070, 711, 169, 40);
		btnSavaAsDefault.setBorder(App.borders);
		add(btnSavaAsDefault);
		
		JButton btnApplay = new JButton("Applay");
		btnApplay.setForeground(App.foreground_color);
		btnApplay.setBackground(App.background_color);
		btnApplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				App.sendRequest(format_addres());
			}
		});
		btnApplay.setFont(new Font("Tahoma", Font.PLAIN, ۱۸));
		btnApplay.setToolTipText("Applay settings");
		btnApplay.setBounds(1276, 711, 110, 40);
		btnApplay.setBorder(App.borders);
		add(btnApplay);
		
		rdbtnDark = new JRadioButton("Dark");
		rdbtnDark.setBackground(new Color(40, 40, 40));
		rdbtnDark.setForeground(new Color(242,170,76));
		rdbtnDark.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnLight.setSelected(false);
			}
		});
		rdbtnDark.setFont(new Font("Arbaeen", Font.PLAIN, 22));
		rdbtnDark.setBounds(973, 250, 118, 34);
		add(rdbtnDark);
		
		JLabel btnNewButton_4 = new JLabel("");
		btnNewButton_4.setIcon(new ImageIcon("D:\\Programming\\Java\\dhgz\\dhgz\\Icons\\eye-crossed-free-icon-font.png"));
		btnNewButton_4.setHorizontalAlignment(SwingConstants.CENTER);
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(is_eye_1==true) {
					settingsPasswordField.setEchoChar((char) 0);
					 is_eye_1 = false;
					 btnNewButton_4.setIcon(new ImageIcon("D:\\Programming\\Java\\dhgz\\dhgz\\Icons\\eye-free-icon-font.png"));
					}
					else  {
						settingsPasswordField.setEchoChar('•');
					 is_eye_1 = true;
					 btnNewButton_4.setIcon(new ImageIcon("D:\\Programming\\Java\\dhgz\\dhgz\\Icons\\eye-crossed-free-icon-font.png"));
					}
			}
		});
		btnNewButton_4.setBounds(540, 490, 45, 40);
		add(btnNewButton_4);
		
	    Circle = new JLabel("");
		Circle.setIcon(new ImageIcon("D:\\Programming\\Java\\dhgz\\dhgz\\Icons\\Picture1small.png"));
		Circle.setBounds(308, 377, 26, 26);
		add(Circle);
		
		btnSendEmailToAdmin = new JLabel("");
		btnSendEmailToAdmin.setToolTipText("enable send email");
		btnSendEmailToAdmin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clickToSendEmail();
			}
		});
		btnSendEmailToAdmin.setForeground(Color.WHITE);
		btnSendEmailToAdmin.setBackground(Color.WHITE);
		btnSendEmailToAdmin.setIcon(new ImageIcon("D:\\Programming\\Java\\dhgz\\dhgz\\Icons\\Picture2small.png"));
		btnSendEmailToAdmin.setBounds(300, 370, 85, 40);
		add(btnSendEmailToAdmin);
		
		Circle_1 = new JLabel("");
		Circle_1.setIcon(new ImageIcon("D:\\Programming\\Java\\dhgz\\dhgz\\Icons\\Picture1small.png"));
		Circle_1.setBounds(308, 557, 26, 26);
		add(Circle_1);
		
		btnAbilityOfTheBlind = new JLabel("");
		btnAbilityOfTheBlind.setToolTipText("enable ability of blind");
		btnAbilityOfTheBlind.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clickToAbilityOfTheBlind();
			}
		});
		
		btnAbilityOfTheBlind.setIcon(new ImageIcon("D:\\Programming\\Java\\dhgz\\dhgz\\Icons\\Picture2small.png"));
		btnAbilityOfTheBlind.setForeground(Color.WHITE);
		btnAbilityOfTheBlind.setBackground(Color.WHITE);
		btnAbilityOfTheBlind.setBounds(300, 550, 85, 40);
		add(btnAbilityOfTheBlind);
		
		Circle_2 = new JLabel("");
		Circle_2.setIcon(new ImageIcon("D:\\Programming\\Java\\dhgz\\dhgz\\Icons\\Picture1small.png"));
		Circle_2.setBounds(900, 17, 26, 26);
		add(Circle_2);
		
		btnMessagingToParents = new JLabel("");
		btnMessagingToParents.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clickToMessagingToParents();
			}
		});
		btnMessagingToParents.setIcon(new ImageIcon("D:\\Programming\\Java\\dhgz\\dhgz\\Icons\\Picture2small.png"));
		btnMessagingToParents.setToolTipText("enable send email");
		btnMessagingToParents.setForeground(Color.WHITE);
		btnMessagingToParents.setBackground(Color.WHITE);
		btnMessagingToParents.setBounds(892, 10, 85, 40);
		add(btnMessagingToParents);
		
		Circle_3 = new JLabel("");
		Circle_3.setIcon(new ImageIcon("D:\\Programming\\Java\\dhgz\\dhgz\\Icons\\Picture1small.png"));
		Circle_3.setBounds(900, 67, 26, 26);
		add(Circle_3);
		
		btnCallingingToParents = new JLabel("");
		btnCallingingToParents.setIcon(new ImageIcon("D:\\Programming\\Java\\dhgz\\dhgz\\Icons\\Picture2small.png"));
		btnCallingingToParents.setToolTipText("enable send email");
		btnCallingingToParents.setForeground(Color.WHITE);
		btnCallingingToParents.setBackground(Color.WHITE);
		btnCallingingToParents.setBounds(892, 60, 85, 40);
		add(btnCallingingToParents);
		btnCallingingToParents.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clickToCallingingToParent();
			}
		});
		
		Circle_4 = new JLabel("");
		Circle_4.setIcon(new ImageIcon("D:\\Programming\\Java\\dhgz\\dhgz\\Icons\\Picture1small.png"));
		Circle_4.setBounds(900, 377, 26, 26);
		add(Circle_4);
		
		btnNotification = new JLabel("");
		btnNotification.setIcon(new ImageIcon("D:\\Programming\\Java\\dhgz\\dhgz\\Icons\\Picture2small.png"));
		btnNotification.setToolTipText("enable send email");
		btnNotification.setForeground(Color.WHITE);
		btnNotification.setBackground(Color.WHITE);
		btnNotification.setBounds(892, 370, 85, 40);
		btnNotification.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clickToNotification();
			}
		});
		add(btnNotification);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(1309, 8, 13, 160);
		add(separator_1);
		
		comboBoxVoiceCMD = new JComboBox();
		comboBoxVoiceCMD.setFont(new Font("Vazirmatn", Font.PLAIN, ۲۰));
		comboBoxVoiceCMD.setModel(new DefaultComboBoxModel(new String[] {"Break", "whistle", "clap"}));
		comboBoxVoiceCMD.setForeground(new Color(242, 170, 76));
		comboBoxVoiceCMD.setBackground(new Color(16, 24, 32));
		comboBoxVoiceCMD.setBounds(300, 610, 286, 40);
		add(comboBoxVoiceCMD);
		
		comboLanguage = new JComboBox();
		comboLanguage.setFont(new Font("Vazirmatn", Font.PLAIN, ۲۰));
		comboLanguage.setModel(new DefaultComboBoxModel(new String[] {"English", "فارسی"}));
		comboLanguage.setForeground(new Color(242, 170, 76));
		comboLanguage.setBackground(new Color(16, 24, 32));
		comboLanguage.setBounds(953, 432, 286, 40);
		add(comboLanguage);
		
		JLabel lblNewLabel = new JLabel("Reseted Factory");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				resetFactory();
			}
		});
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, ۲۰));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(1326, 191, 173, 40);
		add(lblNewLabel);
		
		
		loadSettings(App.SETTING_SAVE_PATH);
	}
	
	public void saveSettings(String file_name) {
		JSONStringer json_s = new JSONStringer();
		json_s.object();
		json_s.key("SSID").value(networkNemeField.getText());
		json_s.key("Password").value(networkPasswordField.getText());
		json_s.key("access_password").value(settingsPasswordField.getText());
		json_s.key("email_address").value(adminEmailField.getText());
		json_s.key("start_hour").value(spinner_of_start_hour.getValue());
		json_s.key("start_min").value(spinner_of_start_min.getValue());
		json_s.key("end_hour").value(spinner_of_end_hour.getValue());
		json_s.key("end_min").value(spinner_of_end_min.getValue());
		json_s.key("storage_time").value(textField_SaveDataByMonth.getText());
		json_s.key("send_email").value(turn);
		json_s.key("call_parent").value(turn_3);
		json_s.key("massage_parent").value(turn_2);
		json_s.key("ability_blind").value(turn_1);
		json_s.key("voice_cmd").value(comboBoxVoiceCMD.getSelectedItem());
		json_s.key("theme").value((rdbtnDark.isSelected())? "Dark":"Light");
		json_s.key("storage_in_pc").value(textField_SaveDataByMonthInApp.getText());
		json_s.key("notification").value(turn_4);
		json_s.key("language").value(comboLanguage.getSelectedItem());
		json_s.endObject();
		
		try {
			FileWriter fw = new FileWriter(file_name);
			fw.write(json_s.toString());
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void loadSettings(String file_name) {
		File f = new File(file_name);
		String jsonString = "";
		try {
			Scanner cin = new Scanner(f);
			while (cin.hasNext()) 
				jsonString += cin.next();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject obj = new JSONObject(jsonString);
		
		networkNemeField.setText(obj.getString("SSID"));
		networkPasswordField.setText(obj.getString("Password"));
		textField_SaveDataByMonth.setText(obj.getString("storage_time"));
		adminEmailField.setText(obj.getString("email_address"));
		settingsPasswordField.setText(obj.getString("access_password"));
		spinner_of_start_hour.setValue(obj.getBigInteger("start_hour"));
		spinner_of_start_min.setValue(obj.getBigInteger("start_min"));
		spinner_of_end_hour.setValue(obj.getBigInteger("end_hour"));
		spinner_of_end_min.setValue(obj.getBigInteger("end_min"));
		
		turn   = !obj.getBoolean("send_email");
		turn_1 = !obj.getBoolean("ability_blind");;
		turn_2 = !obj.getBoolean("massage_parent");;
		turn_3 = !obj.getBoolean("call_parent");;
		turn_4 = !obj.getBoolean("notification");
		setTheButtunsByTurns();
		
		if(obj.getString("theme").equals("Dark")) {
			rdbtnDark.setSelected(true);
			rdbtnLight.setSelected(false);
		}
		else if(obj.getString("theme").equals("Light")) {
			rdbtnDark.setSelected(false);
			rdbtnLight.setSelected(true);
		}
		
		textField_SaveDataByMonthInApp.setText(obj.getString("storage_in_pc"));
		
		comboLanguage.setSelectedItem(obj.getString("language"));
	}
	
	private void setTheButtunsByTurns() {
		clickToNotification();
		clickToCallingingToParent();
		clickToMessagingToParents();
		clickToAbilityOfTheBlind();
		clickToSendEmail();
	}
	
	private void clickToNotification() {
		if(turn_4) {
			timer_4 = new Timer(2/5000,new MyActionListener_front_4());
			timer_4.start();
			turn_4=false;
			if(is_first_4) {
				btnNotification.setIcon(new ImageIcon("D:\\Programming\\Java\\dhgz\\dhgz\\Icons\\green_on_button00small.png"));
				is_first_4=false;
			}
		}	
		else {
			timer_4 = new Timer(2/5000,new MyActionListener_back_4());
			timer_4.start();
			turn_4=true;	
		}
	}
	
	private void clickToCallingingToParent() {
		if(turn_3) {
			timer_3 = new Timer(2/5000,new MyActionListener_front_3());
			timer_3.start();
			turn_3=false;
			if(is_first_3) {
				btnCallingingToParents.setIcon(new ImageIcon("D:\\Programming\\Java\\dhgz\\dhgz\\Icons\\green_on_button00small.png"));
				is_first_3=false;
			}
		}	
		else {
			timer_3 = new Timer(2/5000,new MyActionListener_back_3());
			timer_3.start();
			turn_3=true;	
		}
	}
	
	private void clickToMessagingToParents() {
		if(turn_2) {
	        timer_2 = new Timer(2/5000,new MyActionListener_front_2());
	        timer_2.start();
	        turn_2=false;
	        if(is_first_2) {
	        	btnMessagingToParents.setIcon(new ImageIcon("D:\\Programming\\Java\\dhgz\\dhgz\\Icons\\green_on_button00small.png"));
	        	is_first_2=false;
	        }
		}	
		else {
	        timer_2 = new Timer(2/5000,new MyActionListener_back_2());
	        timer_2.start();
	        turn_2=true;	
		}
	}
	
	private void clickToAbilityOfTheBlind() {
		if(turn_1) {
	        timer_1 = new Timer(2/5000,new MyActionListener_front_1());
	        timer_1.start();
	        turn_1=false;
	        if(is_first_1) {
	        	btnAbilityOfTheBlind.setIcon(new ImageIcon("D:\\Programming\\Java\\dhgz\\dhgz\\Icons\\green_on_button00small.png"));
	        	is_first_1=false;
	        }
		}	
		else {
	        timer_1 = new Timer(2/5000,new MyActionListener_back_1());
	        timer_1.start();
	        turn_1=true;	
		}
	}
	
	private void clickToSendEmail() {
		if(turn) {
	        timer = new Timer(2/5000,new MyActionListener_front());
	        timer.start();
	        turn=false;
	        if(is_first) {
	        	btnSendEmailToAdmin.setIcon(new ImageIcon("D:\\Programming\\Java\\dhgz\\dhgz\\Icons\\green_on_button00small.png"));
	        	is_first=false;
	        }
		}
		else {
	        timer = new Timer(2/5000,new MyActionListener_back());
	        timer.start();
	        turn = true;	
		}
		adminEmailField.setEnabled(turn);
	}
	
	public String format_addres() {
		String str = "http://" + App.ESP_IP + "/settings?";
		if(networkNemeField.getText()!="") 
			str +="network_name="+networkNemeField.getText()+'&';
		if(networkPasswordField.getText() != "") 
			str +="network_password="+networkPasswordField.getText()+'&';
		str +="start_hour="+spinner_of_start_hour.getValue()+'&';
		str +="start_min="+spinner_of_start_min.getValue()+'&';
		str +="end_hour="+spinner_of_end_hour.getValue()+'&';
		str +="end_min="+spinner_of_end_min.getValue()+'&';
		if(textField_SaveDataByMonth.getText() != "") 
			str +="storage_time="+textField_SaveDataByMonth.getText()+'&';
		if(adminEmailField.getText() != "") 
			str +="admin_Email="+adminEmailField.getText()+'&';
		if(settingsPasswordField.getText() != "") 
			str +="settings_password="+settingsPasswordField.getText()+'&';
		str +="ability_of_blind="+turn_1+'&';
		str +="blind_voice_command="+comboBoxVoiceCMD.getSelectedItem()+'&';
		str +="message_to_parents="+turn_2+'&';
		str +="call_to_parents="+turn_3+'&';
		return str;
	}
	
	public void resetFactory() {
		if(App.sendRequest("http://"+App.ESP_IP+"/reset-factory").equals("Reseted Factory")) {
			System.out.println("Reseted Factory");
		}
	}
}

