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
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

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
		
		JButton btnAddUser = new JButton("Add book");
		btnAddUser.setBounds(10, 224, 122, 23);
		frame.getContentPane().add(btnAddUser);
		
		JButton btnUpdateUser = new JButton("Update book");
		btnUpdateUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnUpdateUser.setBounds(161, 224, 128, 23);
		frame.getContentPane().add(btnUpdateUser);
		
		JButton btnNewButton = new JButton("Delete book");
		btnNewButton.setBounds(314, 224, 122, 23);
		frame.getContentPane().add(btnNewButton);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(144, 59, 190, 20);
		frame.getContentPane().add(textField_3);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPage log= new LoginPage();
				log.newScreenLog();
				frame.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(180, 373, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(144, 90, 190, 20);
		frame.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(144, 121, 190, 20);
		frame.getContentPane().add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(144, 152, 190, 20);
		frame.getContentPane().add(textField_6);
		
		JTextArea txtrTitle = new JTextArea();
		txtrTitle.setText("Title:");
		txtrTitle.setFont(new Font("Dialog", Font.PLAIN, 13));
		txtrTitle.setBackground(SystemColor.menu);
		txtrTitle.setBounds(20, 59, 112, 22);
		frame.getContentPane().add(txtrTitle);
		
		JTextArea txtrAuthor = new JTextArea();
		txtrAuthor.setText("Author:");
		txtrAuthor.setFont(new Font("Dialog", Font.PLAIN, 13));
		txtrAuthor.setBackground(SystemColor.menu);
		txtrAuthor.setBounds(20, 88, 112, 22);
		frame.getContentPane().add(txtrAuthor);
		
		JTextArea txtrGenre = new JTextArea();
		txtrGenre.setText("Genre:");
		txtrGenre.setFont(new Font("Dialog", Font.PLAIN, 13));
		txtrGenre.setBackground(SystemColor.menu);
		txtrGenre.setBounds(20, 119, 112, 22);
		frame.getContentPane().add(txtrGenre);
		
		JTextArea txtrReleasedate = new JTextArea();
		txtrReleasedate.setText("Release_date:");
		txtrReleasedate.setFont(new Font("Dialog", Font.PLAIN, 13));
		txtrReleasedate.setBackground(SystemColor.menu);
		txtrReleasedate.setBounds(20, 150, 112, 22);
		frame.getContentPane().add(txtrReleasedate);
	}
}
