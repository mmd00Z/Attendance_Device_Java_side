//package dhgz;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SchoolClass implements Serializable{
	private String name = null;
	private  ArrayList<Student> students = null;
	private static App app = null;
	static Student last_student_displayed;
	SchoolClass(App app ,String name){
		SchoolClass.app = app;
		this.setName(name);
		students = new ArrayList<Student>();
	}
	
	//public void addStudent(String row, String Fname, String Lname, String national_code) {
	//	students.add(new Student(row, Fname, Lname, national_code));
	//}
	
	public void addStudent(String row_index, String Fname, String Lname,String father_name, String number_phone, String national_code) {
		students.add(new Student(row_index, Fname, Lname, father_name, number_phone, national_code, name));
		try { 
			Connection connection = DriverManager.getConnection("jdbc:sqlite:D:\\Programming\\Java\\Kharazmi\\Kharazmi\\Student_Reference_Database\\Student_Reference_Database.db");
			Statement statement = connection.createStatement();
			String query="INSERT INTO StudentReferenceTable values('%s','%s','%s','%s','%s','%s','%s','STUDENT')";
			query=String.format(query, row_index, Fname, Lname, father_name, number_phone, national_code, this.name );
			System.out.println(query);
			statement.executeUpdate(query);
			statement.close();
			connection.close();
			System.out.println("student added to db");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("student was added to db");
	}
	
	public static void editStudentInFront(){
		app.btnEdit.setVisible(false);
		app.lblFirstName.setText("First Name:");
		app.lblLastName.setText("Last Name:");
		app.lblFathersName.setText("Father's Name:");
		app.lblNationalCode.setText("National Code:");
		app.lblNumberPhone.setText("Number Phone:");
		app.lblClass.setText("Class:");
		app.rdbtnAbsent.setEnabled(true);
		app.rdbtnPresent.setEnabled(true);
		app.textField_InputFirstName.setVisible(true);
		app.textField_InputLastName.setVisible(true);
		app.textField_InputFatherName.setVisible(true);
		app.textField_InputNationalCode.setVisible(true);
		app.textField_InputNumberPhone.setVisible(true);
		app.comboInputChooseClass_1.setVisible(true);
		app.textField_InputFirstName.setText(last_student_displayed.getFirstName());
		app.textField_InputLastName.setText(last_student_displayed.getLastName());
		app.textField_InputFatherName.setText(last_student_displayed.getFatherName());
		app.textField_InputNationalCode.setText(last_student_displayed.getNationalCode());
		app.textField_InputNumberPhone.setText(last_student_displayed.getNumberPhone());
		app.comboInputChooseClass_1.setSelectedItem(last_student_displayed.getClassName());
	}
	
	public static void editStudentInBack( String Fname, String Lname,String father_name, String number_phone, String national_code) {
		try {
			Connection connection = DriverManager.getConnection("jdbc:sqlite:D:\\Programming\\Java\\Kharazmi\\Kharazmi\\Student_Reference_Database\\Student_Reference_Database.db");
			Statement statement = connection.createStatement();
			String query="UPDATE  StudentReferenceTable SET First_name='%s'  , Last_name='%s' , Fathername='%s' , Number_Phone='%s' , National_code='%s' , Class='m' WHERE National_code='%s'";
			query=String.format(query, Fname, Lname, father_name, number_phone, national_code ,SchoolClass.last_student_displayed.getNationalCode() );
			System.out.println(query);
			statement.executeUpdate(query);
			statement.close();
			connection.close();
			SchoolClass.last_student_displayed.setFirstName(Fname);
			SchoolClass.last_student_displayed.setLastName(Lname);
			SchoolClass.last_student_displayed.setFatherName(father_name);
			SchoolClass.last_student_displayed.setNationalCode(national_code);
			SchoolClass.last_student_displayed.setNumberPhone(number_phone);

					deleteStudents(last_student_displayed);

			for(int i=0;i<app.getClasses().size();i++) {
				if(app.getClasses().get(i).getName().equals(app.comboInputChooseClass_1.getSelectedItem())) {
					app.getClasses().get(i).getStudents().remove(last_student_displayed);
					break;
				}
			}
			
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}            

		
	}

	
	public static void  loadClass(App app,ArrayList<SchoolClass>classes ) {
		try {
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/D:\\Programming\\Java\\Kharazmi\\Kharazmi\\Student_Reference_Database\\Student_Reference_Database.db");
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * from ClassTable");
			while(resultSet.next()) {
				classes.add(new SchoolClass(app, resultSet.getString("class_name")));
				
			}
			statement.close();
			connection.close();
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void deleteStudents(Student bad_student) {
		for (int i=0; i<app.getClasses().size(); i++) {
			if(bad_student.getClassName().equals(app.getClasses().get(i).getName())){
				app.getClasses().get(i).getStudents().remove(bad_student);
				try {
					Connection connection = DriverManager.getConnection("jdbc:sqlite:D:\\Programming\\Java\\Kharazmi\\Kharazmi\\Student_Reference_Database\\Student_Reference_Database.db");
					Statement statement = connection.createStatement();
					String query="DELETE FROM StudentReferenceTable WHERE national_code = '%s'";
					query=String.format(query, bad_student.getNationalCode());
					statement.executeUpdate(query);
					statement.close();
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				app.show();
				break;
			}
		}
		System.out.println("bad_student is killed");
	}
	
	public static void showStudent_Profile (Student normal_student) {
		app.btnEdit.setVisible(true);
		SchoolClass.last_student_displayed=normal_student;
		app.pnl_StudentProfile.setVisible(true);
		app.lblFirstName.setText("First Name:"+normal_student.getFirstName());
		app.lblLastName.setText("Last Name:"+normal_student.getLastName());
		app.lblFathersName.setText("Father's Name:"+normal_student.getFatherName());
		app.lblNationalCode.setText("National Code:"+normal_student.getNationalCode());
		app.lblNumberPhone.setText("Number Phone:"+normal_student.getNumberPhone());
		app.lblClass.setText("Class:"+normal_student.getClassName());
		app.rdbtnAbsent.setEnabled(false);
		app.rdbtnPresent.setEnabled(false);
		app.textField_InputFirstName.setVisible(false);
		app.textField_InputLastName.setVisible(false);
		app.textField_InputFatherName.setVisible(false);
		app.textField_InputNationalCode.setVisible(false);
		app.textField_InputNumberPhone.setVisible(false);
		app.comboInputChooseClass_1.setVisible(false);	
	}
		
	
	public void loadStudent() {
		try {
			Connection connection = DriverManager.getConnection("jdbc:sqlite:D:\\Programming\\Java\\Kharazmi\\Kharazmi\\Student_Reference_Database\\Student_Reference_Database.db");
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * from StudentReferenceTable");
			while(resultSet.next()) {
				if(resultSet.getString("Class").equals(getName()))
					students.add(new Student(resultSet.getString("row"),resultSet.getString("first_name"),resultSet.getString("last_name"),resultSet.getString("father_name"),resultSet.getString("number_phone"),resultSet.getString("national_code"),resultSet.getString("Class")));
			}
			statement.close();
			connection.close();

		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("student loaded");
	}
	
	public void toLOP_Mode() {
		for(int i=0; i<students.size(); i++)
			students.get(i).setToLOP_Mode();
	}
	
	public void toAL_Mode() {
		for(int i=0; i<students.size(); i++)
			students.get(i).setToAL_Mode();
	}

	
	public int numberOfStudent() {
		return students.size();
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Student> getStudents() {
		return students;
	}
		
}