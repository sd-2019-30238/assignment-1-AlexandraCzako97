package presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminPage {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public void newScreenAdmin() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPage window = new AdminPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 452, 436);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea txtrHelloAdmin = new JTextArea();
		txtrHelloAdmin.setFont(new Font("Dialog", Font.BOLD, 20));
		txtrHelloAdmin.setBackground(SystemColor.control);
		txtrHelloAdmin.setText("Hello, Admin!");
		txtrHelloAdmin.setBounds(10, 11, 143, 37);
		frame.getContentPane().add(txtrHelloAdmin);
		
		textField = new JTextField();
		textField.setBounds(144, 59, 190, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(144, 90, 190, 20);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(144, 121, 190, 20);
		frame.getContentPane().add(textField_2);
		
		JTextArea txtrUsername = new JTextArea();
		txtrUsername.setFont(new Font("Dialog", Font.PLAIN, 13));
		txtrUsername.setBackground(SystemColor.control);
		txtrUsername.setText("Username:");
		txtrUsername.setBounds(20, 59, 112, 22);
		frame.getContentPane().add(txtrUsername);
		
		JTextArea txtrPassword = new JTextArea();
		txtrPassword.setFont(new Font("Dialog", Font.PLAIN, 13));
		txtrPassword.setBackground(SystemColor.control);
		txtrPassword.setText("Password:");
		txtrPassword.setBounds(22, 88, 112, 22);
		frame.getContentPane().add(txtrPassword);
		
		JTextArea txtrPaymentPlan = new JTextArea();
		txtrPaymentPlan.setFont(new Font("Dialog", Font.PLAIN, 13));
		txtrPaymentPlan.setBackground(SystemColor.control);
		txtrPaymentPlan.setText("Payment plan:");
		txtrPaymentPlan.setBounds(22, 119, 112, 22);
		frame.getContentPane().add(txtrPaymentPlan);
		
		JButton btnAddUser = new JButton("Add user");
		btnAddUser.setBounds(10, 167, 122, 23);
		frame.getContentPane().add(btnAddUser);
		
		JButton btnUpdateUser = new JButton("Update user");
		btnUpdateUser.setBounds(154, 167, 128, 23);
		frame.getContentPane().add(btnUpdateUser);
		
		JButton btnNewButton = new JButton("Delete user");
		btnNewButton.setBounds(302, 167, 122, 23);
		frame.getContentPane().add(btnNewButton);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(144, 59, 190, 20);
		frame.getContentPane().add(textField_3);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login log= new Login();
				log.newScreenLog();
				frame.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(180, 373, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
	}

}
