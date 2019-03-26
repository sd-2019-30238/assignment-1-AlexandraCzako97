package presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import dao.Book;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.JList;
import javax.swing.AbstractListModel;

public class SearchPage {

	private JFrame frame;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public void newScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchPage window = new SearchPage();
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
	public SearchPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 511, 376);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(48, 155, 412, 132);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Title", "Author", "Release Date", "Price"
			}
		));
		scrollPane.setViewportView(table);
		
		JTextArea txtrSortBy = new JTextArea();
		txtrSortBy.setEditable(false);
		txtrSortBy.setFont(new Font("Dialog", Font.PLAIN, 13));
		txtrSortBy.setBackground(SystemColor.control);
		txtrSortBy.setText("Sort by:");
		txtrSortBy.setBounds(48, 122, 62, 22);
		frame.getContentPane().add(txtrSortBy);
		
		JSpinner spinner = new JSpinner();
		spinner.setForeground(SystemColor.control);
		spinner.setModel(new SpinnerListModel(new String[] {"Title", "Author", "Genre", "Release Date"}));
		spinner.setBounds(116, 124, 97, 20);
		frame.getContentPane().add(spinner);
		
		JTextArea txtrSearchForYour = new JTextArea();
		txtrSearchForYour.setEditable(false);
		txtrSearchForYour.setFont(new Font("Dialog", Font.BOLD, 15));
		txtrSearchForYour.setBackground(SystemColor.control);
		txtrSearchForYour.setText("Search for your favorite books:");
		txtrSearchForYour.setBounds(43, 22, 313, 22);
		frame.getContentPane().add(txtrSearchForYour);
		
		textField = new JTextField();
		textField.setBounds(164, 68, 185, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JTextArea txtrSearchForBooks = new JTextArea();
		txtrSearchForBooks.setEditable(false);
		txtrSearchForBooks.setFont(new Font("Dialog", Font.PLAIN, 13));
		txtrSearchForBooks.setBackground(SystemColor.control);
		txtrSearchForBooks.setText("Search for books:");
		txtrSearchForBooks.setBounds(48, 66, 106, 22);
		frame.getContentPane().add(txtrSearchForBooks);
	}
	

}
