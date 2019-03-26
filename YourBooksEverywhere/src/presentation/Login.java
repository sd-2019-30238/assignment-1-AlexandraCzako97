package presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import businessLogic.UserLogic;
import dao.User;

import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frmLogin;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void newScreenLog() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setResizable(false);
		frmLogin.setTitle("Login\r\n");
		frmLogin.setBounds(100, 100, 501, 404);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		JTextPane txtpnYourBooksEverywhere = new JTextPane();
		txtpnYourBooksEverywhere.setEditable(false);
		txtpnYourBooksEverywhere.setFont(new Font("Tekton Pro", Font.PLAIN, 26));
		txtpnYourBooksEverywhere.setBackground(SystemColor.control);
		txtpnYourBooksEverywhere.setText("Your books everywhere!");
		txtpnYourBooksEverywhere.setBounds(10, 0, 364, 66);
		frmLogin.getContentPane().add(txtpnYourBooksEverywhere);
		
		textField = new JTextField();
		textField.setBounds(205, 171, 151, 20);
		frmLogin.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(205, 202, 151, 20);
		frmLogin.getContentPane().add(textField_1);
		
		JTextArea txtrUsername = new JTextArea();
		txtrUsername.setEditable(false);
		txtrUsername.setFont(new Font("Dialog", Font.PLAIN, 15));
		txtrUsername.setBackground(SystemColor.control);
		txtrUsername.setText("Username:");
		txtrUsername.setBounds(115, 167, 80, 22);
		frmLogin.getContentPane().add(txtrUsername);
		
		JTextArea txtrPassword= new JTextArea();
		txtrPassword.setEditable(false);
		txtrPassword.setText("Password:");
		txtrPassword.setFont(new Font("Dialog", Font.PLAIN, 15));
		txtrPassword.setBackground(SystemColor.menu);
		txtrPassword.setBounds(115, 200, 80, 22);
		frmLogin.getContentPane().add(txtrPassword);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBackground(SystemColor.control);
		textArea.setBounds(115, 315, 241, 22);
		frmLogin.getContentPane().add(textArea);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UserLogic usr = new UserLogic();
				
				String username= textField.getText();
				String password= textField_1.getText();
				
				try {
					if(usr.validateUser(username, password)==1) {
						SearchPage search = new SearchPage();
						search.newScreen();
						frmLogin.setVisible(false);
					}
					else {
						textArea.setText("Wrong username/password");
						}
					
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(106, 247, 118, 23);
		frmLogin.getContentPane().add(btnNewButton);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnRegister.setBounds(234, 247, 118, 23);
		frmLogin.getContentPane().add(btnRegister);
		
		JTextArea txtrLoginRegisterFor = new JTextArea();
		txtrLoginRegisterFor.setEditable(false);
		txtrLoginRegisterFor.setFont(new Font("Dialog", Font.PLAIN, 18));
		txtrLoginRegisterFor.setBackground(SystemColor.control);
		txtrLoginRegisterFor.setText("Login/ register for an awesome experience!");
		txtrLoginRegisterFor.setBounds(65, 106, 348, 37);
		frmLogin.getContentPane().add(txtrLoginRegisterFor);
		
		JButton btnNewButton_1 = new JButton("Admin Login");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                UserLogic usr = new UserLogic();
				
				String username= textField.getText();
				String password= textField_1.getText();
				
				try {
					if(usr.validateUser(username, password)==1) {
						AdminPage adm = new AdminPage();
						adm.newScreenAdmin();
						frmLogin.setVisible(false);
					}
					else {
						textArea.setText("Wrong username/password");
						}
					
				} catch (ClassNotFoundException | SQLException ee) {
					ee.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(106, 281, 250, 23);
		frmLogin.getContentPane().add(btnNewButton_1);
	}
}
