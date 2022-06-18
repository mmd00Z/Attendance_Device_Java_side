

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class ClassNameDialog extends JFrame {

	private JPanel contentPane = null;
	private JTextField textFieldClassName = null;
	private App app = null;

	public ClassNameDialog(App app) {
		this.app = app;
		setVisible(false);
		setResizable(false);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(650, 250, 270, 185);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblClassName = new JLabel("Class name:");
		lblClassName.setForeground(Color.WHITE);
		lblClassName.setFont(new Font("Consolas", Font.BOLD, 18));
		lblClassName.setBounds(10, 10, 114, 35);
		contentPane.add(lblClassName);
		
		
		textFieldClassName = new JTextField();
		textFieldClassName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					OK();
				}
			}
		});
		textFieldClassName.setFont(new Font("Tahoma", Font.BOLD, 16));
		textFieldClassName.setBounds(10, 43, 243, 30);
		contentPane.add(textFieldClassName);
		textFieldClassName.setColumns(10);
		
		JButton btnCancel = new JButton("cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldClassName.setText("");
				ClassNameDialog.this.setVisible(false);
//				ClassNameDialog.this.dispatchEvent(new WindowEvent(ClassNameDialog.this, WindowEvent.WINDOW_CLOSING));
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancel.setBounds(10, 115, 85, 30);
		contentPane.add(btnCancel);
		
		JButton btnOK = new JButton("OK");
		btnOK.setHorizontalAlignment(SwingConstants.CENTER);
		btnOK.setOpaque(true);
		
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OK();
			}
		});
		btnOK.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnOK.setBounds(168, 115, 85, 30);
		contentPane.add(btnOK);
	}
	private void OK() {
		ClassNameDialog.this.app.addClass(ClassNameDialog.this.textFieldClassName.getText());
		ClassNameDialog.this.setVisible(false);
//		ClassNameDialog.this.app.setCombo();
//		ClassNameDialog.this.dispatchEvent(new WindowEvent(ClassNameDialog.this, WindowEvent.WINDOW_CLOSING));
	}

}