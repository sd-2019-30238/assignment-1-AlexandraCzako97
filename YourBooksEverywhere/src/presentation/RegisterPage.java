package presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;

public class RegisterPage {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterPage window = new RegisterPage();
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
	public RegisterPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 502, 358);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea txtrRegisterHere = new JTextArea();
		txtrRegisterHere.setEditable(false);
		txtrRegisterHere.setFont(new Font("Dialog", Font.BOLD, 15));
		txtrRegisterHere.setBackground(SystemColor.control);
		txtrRegisterHere.setText("Register here:");
		txtrRegisterHere.setBounds(10, 11, 168, 22);
		frame.getContentPane().add(txtrRegisterHere);
		
		textField = new JTextField();
		textField.setBounds(163, 105, 155, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(163, 136, 155, 20);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(163, 167, 155, 20);
		frame.getContentPane().add(textField_2);
		
		JTextArea txtrUsername = new JTextArea();
		txtrUsername.setEditable(false);
		txtrUsername.setFont(new Font("Dubai", Font.PLAIN, 15));
		txtrUsername.setBackground(SystemColor.control);
		txtrUsername.setText("Username:");
		txtrUsername.setBounds(84, 105, 69, 22);
		frame.getContentPane().add(txtrUsername);
		
		JTextArea txtrPassword = new JTextArea();
		txtrPassword.setEditable(false);
		txtrPassword.setText("Password:\r\n");
		txtrPassword.setFont(new Font("Dubai", Font.PLAIN, 15));
		txtrPassword.setBackground(SystemColor.menu);
		txtrPassword.setBounds(88, 136, 65, 22);
		frame.getContentPane().add(txtrPassword);
		
		JTextArea txtrTypePasswordAgain = new JTextArea();
		txtrTypePasswordAgain.setEditable(false);
		txtrTypePasswordAgain.setText("Type password again:");
		txtrTypePasswordAgain.setFont(new Font("Dubai", Font.PLAIN, 15));
		txtrTypePasswordAgain.setBackground(SystemColor.menu);
		txtrTypePasswordAgain.setBounds(17, 167, 136, 22);
		frame.getContentPane().add(txtrTypePasswordAgain);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(203, 244, 89, 23);
		frame.getContentPane().add(btnLogin);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerListModel(new String[] {"Monthly", "Yearly"}));
		spinner.setBounds(163, 198, 155, 20);
		frame.getContentPane().add(spinner);
		
		JTextArea txtrPaymentPlan = new JTextArea();
		txtrPaymentPlan.setText("Payment plan:");
		txtrPaymentPlan.setFont(new Font("Dubai", Font.PLAIN, 15));
		txtrPaymentPlan.setEditable(false);
		txtrPaymentPlan.setBackground(SystemColor.menu);
		txtrPaymentPlan.setBounds(62, 196, 91, 22);
		frame.getContentPane().add(txtrPaymentPlan);
	}
}
