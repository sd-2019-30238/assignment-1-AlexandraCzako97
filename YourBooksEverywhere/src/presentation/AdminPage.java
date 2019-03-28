package presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JTextField;

import businessLogic.BookLogic;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class AdminPage {

	private JFrame frame;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField;
	private JTextField textField_1;

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
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(144, 59, 190, 20);
		frame.getContentPane().add(textField_3);
		
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
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(144, 183, 190, 20);
		frame.getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(144, 214, 190, 20);
		frame.getContentPane().add(textField_1);
		
		
		JButton btnAddUser = new JButton("Add book");
		btnAddUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookLogic book= new BookLogic();
				
				String title= textField_3.getText();
				String author= textField_4.getText();
				String genre= textField_5.getText();
				String release_date= textField_6.getText();
				String price= textField.getText();
				String status= textField_1.getText();
				
				try {
					book.addNewBook(title, author, genre, release_date,price,status);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnAddUser.setBounds(10, 286, 122, 23);
		frame.getContentPane().add(btnAddUser);
		
		JButton btnUpdateUser = new JButton("Update book");
		btnUpdateUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                BookLogic book= new BookLogic();
				
				String title= textField_3.getText();
				String author= textField_4.getText();
				String genre= textField_5.getText();
				String release_date= textField_6.getText();
				String price= textField.getText();
				String status= textField_1.getText();
				
				try {
					book.updateBook(title, author, genre, release_date,price,status);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnUpdateUser.setBounds(159, 286, 128, 23);
		frame.getContentPane().add(btnUpdateUser);
		
		JButton btnNewButton = new JButton("Delete book");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                BookLogic book= new BookLogic();
				
				String title= textField_3.getText();
				String author= textField_4.getText();
				String genre= textField_5.getText();
				String release_date= textField_6.getText();
				String price= textField.getText();
				String status= textField_1.getText();
				
				try {
					book.deleteBook(title, author, genre, release_date,price,status);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(314, 286, 122, 23);
		frame.getContentPane().add(btnNewButton);
		
	
		
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
		

		
		JTextArea txtrPrice = new JTextArea();
		txtrPrice.setText("Price:");
		txtrPrice.setFont(new Font("Dialog", Font.PLAIN, 13));
		txtrPrice.setBackground(SystemColor.menu);
		txtrPrice.setBounds(20, 181, 112, 22);
		frame.getContentPane().add(txtrPrice);
		
		JTextArea txtrStatus = new JTextArea();
		txtrStatus.setText("Status:");
		txtrStatus.setFont(new Font("Dialog", Font.PLAIN, 13));
		txtrStatus.setBackground(SystemColor.menu);
		txtrStatus.setBounds(20, 212, 112, 22);
		frame.getContentPane().add(txtrStatus);
	}
}
