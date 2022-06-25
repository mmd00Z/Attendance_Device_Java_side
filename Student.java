//package dhgz;

import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Student extends JPanel {
	JLabel row 			= null;
	private JLabel firstName 	= null;
	private JLabel lastName 	= null;
	private JLabel nationalCode = null;
	private String fatherName 	= null;
	private String numberPhone 	= null;
	private String className 	= null;
	JLabel lblTime		= null;
	JLabel lblView;
	JLabel lblDelete;
	private JLabel chekPresent;

    public enum StudentProperty {ROW, FIRST_NAME, LAST_NAME, FATHER_NAME, NATIONAL_CODE, NUMBER_PHONE, CLASS_NAME};
    
    public void graphicalInit(String row_index, String Fname, String Lname, String national_code){
    	this.setBounds(0, 0, 1100, 40);
    	setLayout(null);
    	
    	Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
    	Border border_delete = BorderFactory.createMatteBorder(1, 0, 1, 1, Color.BLACK);
    	Border border_view = BorderFactory.createMatteBorder(1, 1, 1, 0, Color.BLACK);
    	
    	row = new JLabel(row_index);
    	row.setForeground(new Color(242, 170, 76));
    	row.setOpaque(true);
    	row.setHorizontalAlignment(SwingConstants.CENTER);
    	row.setFont(new Font("Consolas", Font.BOLD, ۲۰));
    	row.setBounds(0, 0, 60, 40);
    	row.setBorder(border);
    	add(row);
    	
    	firstName = new JLabel(Fname);
    	firstName.setForeground(new Color(242, 170, 76));
    	firstName.setOpaque(true);
    	firstName.setHorizontalAlignment(SwingConstants.CENTER);
    	firstName.setFont(new Font("Vazirmatn", Font.BOLD, ۲۰));
    	firstName.setBounds(60, 0, 280, 40);
    	firstName.setBorder(border);
    	add(firstName);
    	
    	lastName = new JLabel(Lname);
    	lastName.setForeground(new Color(242, 170, 76));
    	lastName.setOpaque(true);
    	lastName.setHorizontalAlignment(SwingConstants.CENTER);
    	lastName.setFont(new Font("Vazirmatn", Font.BOLD, ۲۰));
    	lastName.setBounds(340, 0, 280, 40);
    	lastName.setBorder(border);
    	add(lastName);
    	
    	nationalCode = new JLabel(national_code);
    	nationalCode.setForeground(new Color(242, 170, 76));
    	nationalCode.setOpaque(true);
    	nationalCode.setHorizontalAlignment(SwingConstants.CENTER);
    	nationalCode.setFont(new Font("Consolas", Font.BOLD, ۲۰));
    	nationalCode.setBounds(620, 0, 170, 40);
    	nationalCode.setBorder(border);
    	add(nationalCode);
    	
    	lblView = new JLabel("");
    	lblView.setIcon(new ImageIcon("D:\\Programming\\Java\\dhgz\\dhgz\\Icons\\eye-free-icon-font.png"));
    	lblView.setForeground(new Color(242, 170, 76));
    	lblView.addMouseListener(new MouseAdapter() {
    		@Override
    		public void mouseClicked(MouseEvent e) {
    			SchoolClass.showStudent_Profile(Student.this);
    		}
    	});
    	lblView.setHorizontalAlignment(SwingConstants.CENTER);
    	lblView.setFont(new Font("Tahoma", Font.BOLD, ۱۸));
    	lblView.setBounds(1010, 0, 90, 40);
    	lblView.setBorder(border_view);
    	add(lblView);
    	
//    	lblDelete = new JLabel("");
//    	lblDelete.setIcon(new ImageIcon("D:\\Programming\\Java\\dhgz\\dhgz\\Icons\\trash-free-icon-font.png"));
//    	lblDelete.setForeground(new Color(242, 170, 76));
//    	lblDelete.addMouseListener(new MouseAdapter() {
//    		@Override
//    		public void mouseClicked(MouseEvent e) {
//    			SchoolClass.deleteStudents(Student.this);
//    		}
//    	});
//    	lblDelete.setHorizontalAlignment(SwingConstants.CENTER);
//    	lblDelete.setFont(new Font("Tahoma", Font.BOLD, ۱۸));
//    	lblDelete.setBounds(1000, 0, 90, 40);
//    	lblDelete.setBorder(border_delete);
//    	add(lblDelete);
//    	//scaleCheckBoxIcon(chckbxPresent);
//    	lblDelete.setBorder(border);
    	
    	chekPresent = new JLabel("");
    	chekPresent.setIcon(new ImageIcon("D:\\Programming\\Java\\dhgz\\dhgz\\Icons\\Picture5.png"));
    	chekPresent.setHorizontalAlignment(SwingConstants.CENTER);
    	chekPresent.setBounds(920, 0, 90, 40);
    	add(chekPresent);
    	chekPresent.setBorder(border);
    	
    	lblTime = new JLabel("00:00:00");
    	lblTime.setOpaque(true);
    	lblTime.setHorizontalAlignment(SwingConstants.CENTER);
    	lblTime.setForeground(App.foreground_color);
    	lblTime.setFont(new Font("Consolas", Font.BOLD, ۲۰));
    	lblTime.setBounds(790, 0, 130, 40);
    	add(lblTime);
    	
    	if((row_index.charAt(0)-48)%2 != 0) {
    		System.out.println("o");
    		row.setBackground(new Color(50, 50, 50));
    		firstName.setBackground(new Color(50, 50, 50));
    		lastName.setBackground(new Color(50, 50, 50));
    		nationalCode.setBackground(new Color(50, 50, 50));
    		lblView.setBackground(new Color(50, 50, 50));
    		lblTime.setBackground(new Color(50, 50, 50));
//    		lblDelete.setBackground(new Color(50, 50, 50));
    		//chckbxPresent.setBackground(new Color(50, 50, 50));
    		this.setBackground(new Color(50, 50, 50));
    	}
    	else if((row_index.charAt(0)-48)%2 == 0) {
    		System.out.println("o");
    		row.setBackground(new Color(16, 24, 32));
    		firstName.setBackground(new Color(16, 24, 32));
    		lastName.setBackground(new Color(16, 24, 32));
    		nationalCode.setBackground(new Color(16, 24, 32));
    		lblView.setBackground(new Color(16, 24, 32));
    		lblTime.setBackground(new Color(16, 24, 32));
//    		lblDelete.setBackground(new Color(16, 24, 32));
    		//chckbxPresent.setBackground(new Color(16, 24, 32));
    		this.setBackground(new Color(16, 24, 32));
    	}
    }

    public Student(String row_index, String Fname, String Lname, String national_code) {
    	this.setFatherName("");
    	this.setNumberPhone("");
    	this.setclassName("");
    	graphicalInit(row_index, Fname, Lname, national_code);
    }
    /**
     * @wbp.parser.constructor
     */
    public Student(String row_index, String Fname, String Lname, String father_name, String number_phone,String national_code, String className) {
    	this.setFatherName(father_name);
    	this.setNumberPhone(number_phone);
    	this.setclassName(className);
    	graphicalInit(row_index, Fname, Lname, national_code);
    }

    public String get(StudentProperty sp) {
    	switch (sp) {
			case ROW: 			return row.getText();
			case FIRST_NAME:	return firstName.getText();
			case LAST_NAME:		return lastName.getText();
			case FATHER_NAME:	return fatherName;
			case NATIONAL_CODE:	return nationalCode.getText();
			case NUMBER_PHONE:	return numberPhone;
			case CLASS_NAME:			return className;
			default: return "";
    	}
    }
	
	public String getRow() {
		return this.row.getText();
	}
	public void setRow(String row) {
		this.row.setText(row);
	}
	
	public String getFirstName() {
		return this.firstName.getText();
	}
	public void setFirstName(String firstName) {
		this.firstName.setText(firstName);
	}
	
	public String getLastName() {
		return this.lastName.getText();
	}
	public void setLastName(String lastName) {
		this.firstName.setText(lastName);
	}
	
	public String getNationalCode() {
		return this.nationalCode.getText();
	}
	public void setNationalCode(String nationalCode) {
		this.nationalCode.setText(nationalCode);
	}
	
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getNumberPhone() {
		return numberPhone;
	}
	public void setNumberPhone(String numberPhone) {
		this.numberPhone = numberPhone;
	}
	
	public String getClassName() {
		return className;
	}
	public void setclassName(String className) {
		this.className = className;
	}
	
	public void setAsPresent() {
		chekPresent.setIcon(new ImageIcon("D:\\Programming\\Java\\dhgz\\dhgz\\Icons\\checkbox-free-icon-font.png"));
	}
	
	public void setAsAbsent() {
		chekPresent.setIcon(new ImageIcon("D:\\Programming\\Java\\dhgz\\dhgz\\Icons\\Picture5.png"));
	}
	
//	public static void scaleCheckBoxIcon(JCheckBox checkbox){
//	    boolean previousState = checkbox.isSelected();
//	    checkbox.setSelected(false);
//	    FontMetrics boxFontMetrics =  checkbox.getFontMetrics(checkbox.getFont());
//	    Icon boxIcon = UIManager.getIcon("CheckBox.icon");
//	    BufferedImage boxImage = new BufferedImage(
//	        boxIcon.getIconWidth(), boxIcon.getIconHeight(), BufferedImage.TYPE_INT_ARGB
//	    );
//	    Graphics graphics = boxImage.createGraphics();
//	    try{
//	        boxIcon.paintIcon(checkbox, graphics, 0, 0);
//	    }finally{
//	        graphics.dispose();
//	    }
//	    ImageIcon newBoxImage = new ImageIcon(boxImage);
//	    Image finalBoxImage = newBoxImage.getImage().getScaledInstance(
//	        boxFontMetrics.getHeight(), boxFontMetrics.getHeight(), Image.SCALE_SMOOTH
//	    );
//	    checkbox.setIcon(new ImageIcon(finalBoxImage));
//
//	    checkbox.setSelected(true);
//	    Icon checkedBoxIcon = UIManager.getIcon("CheckBox.icon");
//	    BufferedImage checkedBoxImage = new BufferedImage(
//	        checkedBoxIcon.getIconWidth(),  checkedBoxIcon.getIconHeight(), BufferedImage.TYPE_INT_ARGB
//	    );
//	    Graphics checkedGraphics = checkedBoxImage.createGraphics();
//	    try{
//	        checkedBoxIcon.paintIcon(checkbox, checkedGraphics, 0, 0);
//	    }finally{
//	        checkedGraphics.dispose();
//	    }
//	    ImageIcon newCheckedBoxImage = new ImageIcon(checkedBoxImage);
//	    Image finalCheckedBoxImage = newCheckedBoxImage.getImage().getScaledInstance(
//	        boxFontMetrics.getHeight(), boxFontMetrics.getHeight(), Image.SCALE_SMOOTH
//	    );
//	    checkbox.setSelectedIcon(new ImageIcon(finalCheckedBoxImage));
//	    checkbox.setSelected(false);
//	    checkbox.setSelected(previousState);
//	}
	
	public void setToLOP_Mode() {
		chekPresent.setVisible(false);
		lblTime.setVisible(false);
		lblView.setBounds(790, 1, 90, 38);
//		lblDelete.setBounds(910, 0, 90, 40);	
	}
	
	public void setToAL_Mode() {
		chekPresent.setVisible(true);
		lblTime.setVisible(true);
		lblView.setBounds(1010, 0, 90, 40);
//		lblDelete.setBounds(1000, 0, 90, 40);	
	}

}