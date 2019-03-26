package presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Login {

	private JFrame frmLogin;
	private JTextField textField;
	private JTextField textField_1;
	private JTextArea txtrPassword;

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
		frmLogin.setTitle("Login\r\n");
		frmLogin.setBounds(100, 100, 501, 404);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		JTextPane txtpnYourBooksEverywhere = new JTextPane();
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
		txtrUsername.setFont(new Font("Dialog", Font.PLAIN, 15));
		txtrUsername.setBackground(SystemColor.control);
		txtrUsername.setText("Username:");
		txtrUsername.setBounds(115, 167, 80, 22);
		frmLogin.getContentPane().add(txtrUsername);
		
		txtrPassword = new JTextArea();
		txtrPassword.setText("Password:");
		txtrPassword.setFont(new Font("Dialog", Font.PLAIN, 15));
		txtrPassword.setBackground(SystemColor.menu);
		txtrPassword.setBounds(115, 200, 80, 22);
		frmLogin.getContentPane().add(txtrPassword);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(110, 271, 118, 23);
		frmLogin.getContentPane().add(btnNewButton);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnRegister.setBounds(238, 271, 118, 23);
		frmLogin.getContentPane().add(btnRegister);
		
		JTextArea txtrLoginRegisterFor = new JTextArea();
		txtrLoginRegisterFor.setFont(new Font("Dialog", Font.PLAIN, 18));
		txtrLoginRegisterFor.setBackground(SystemColor.control);
		txtrLoginRegisterFor.setText("Login/ register for an awesome experience!");
		txtrLoginRegisterFor.setBounds(65, 106, 348, 37);
		frmLogin.getContentPane().add(txtrLoginRegisterFor);
	}
}
