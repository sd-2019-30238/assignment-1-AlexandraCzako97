package presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class MyLibrary {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public void newScreenLibrary() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyLibrary window = new MyLibrary();
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
	public MyLibrary() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 468, 319);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea txtrWelcomeToYour = new JTextArea();
		txtrWelcomeToYour.setFont(new Font("Dialog", Font.BOLD, 15));
		txtrWelcomeToYour.setBackground(SystemColor.control);
		txtrWelcomeToYour.setText("Welcome to your personal library!");
		txtrWelcomeToYour.setBounds(10, 11, 320, 22);
		frame.getContentPane().add(txtrWelcomeToYour);
		
		JTextArea txtrHereAreYour = new JTextArea();
		txtrHereAreYour.setFont(new Font("Dialog", Font.PLAIN, 13));
		txtrHereAreYour.setBackground(SystemColor.menu);
		txtrHereAreYour.setText("Here are your books:");
		txtrHereAreYour.setBounds(10, 81, 183, 22);
		frame.getContentPane().add(txtrHereAreYour);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 106, 414, 110);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
		JButton btnNewButton = new JButton("Return books");
		btnNewButton.setBounds(296, 227, 128, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
