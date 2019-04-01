package presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import businessLogic.BookLogic;
import businessLogic.Recommend;
import businessLogic.RecommendFactory;
import dao.Book;

import dao.BookDao;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class SearchPage {

	private JFrame frame;
	private JTable table;
	private JTextField textField;
	private JTable table_1;

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
		frame.setBounds(100, 100, 512, 439);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		table_1 = new JTable();
		table_1.setBounds(48, 154, 408, 144);
		table_1.setAutoscrolls(true);
		
		frame.getContentPane().add(table_1);
		
		
		JTextArea txtrSortBy = new JTextArea();
		txtrSortBy.setEditable(false);
		txtrSortBy.setFont(new Font("Dialog", Font.PLAIN, 13));
		txtrSortBy.setBackground(SystemColor.control);
		txtrSortBy.setText("Filter by:");
		txtrSortBy.setBounds(147, 119, 62, 22);
		frame.getContentPane().add(txtrSortBy);
		
		JSpinner spinner = new JSpinner();
		spinner.setForeground(SystemColor.control);
		spinner.setModel(new SpinnerListModel(new String[] {"Author", "Genre", "Release Date","Price","Status"}));
		spinner.setBounds(213, 121, 97, 20);
		frame.getContentPane().add(spinner);
		
		JTextArea txtrSearchForYour = new JTextArea();
		txtrSearchForYour.setEditable(false);
		txtrSearchForYour.setFont(new Font("Dialog", Font.BOLD, 15));
		txtrSearchForYour.setBackground(SystemColor.control);
		txtrSearchForYour.setText("Search for your favorite books:");
		txtrSearchForYour.setBounds(43, 22, 313, 22);
		frame.getContentPane().add(txtrSearchForYour);
		
		textField = new JTextField();
		textField.setBounds(214, 55, 206, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnSortBooks = new JButton("Sort books");
		btnSortBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookLogic bl=new BookLogic();
				String filterBy= textField.getText();

				if(spinner.getValue()=="Author") {
					ArrayList<String[]>bb = new ArrayList<String[]>();
					DefaultTableModel model= new DefaultTableModel();
					
					String[] columns= {"Title", "Author", "Genre", "Release Date","Price","Status"};
					int n =columns.length;
					try {
						bb=bl.filterBooks("author",filterBy);
					} catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}
					for(int i=0;i<n;i++) {
						model.addColumn(columns[i]);
					}
					for(String[] b: bb) {
					    model.addRow(b);
					}
					
					table_1.setModel(model);
					
				}else
					if(spinner.getValue()=="Genre") {
						ArrayList<String[]>bb = new ArrayList<String[]>();
						DefaultTableModel model= new DefaultTableModel();
						
						String[] columns= {"Title", "Author", "Genre", "Release Date","Price","Status"};
						int n =columns.length;
						try {
							bb=bl.filterBooks("genre",filterBy);
						} catch (ClassNotFoundException | SQLException e1) {
							e1.printStackTrace();
						}
						for(int i=0;i<n;i++) {
							model.addColumn(columns[i]);
						}
						for(String[] b: bb) {
						    model.addRow(b);
						}
						
						table_1.setModel(model);
					}
			}
		});
		btnSortBooks.setBounds(320, 120, 100, 23);
		frame.getContentPane().add(btnSortBooks);
		
		JButton btnAddToMy = new JButton("Add to my library");
		btnAddToMy.setBounds(330, 309, 123, 23);
		frame.getContentPane().add(btnAddToMy);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(48, 343, 408, 22);
		frame.getContentPane().add(textArea);
		
		JButton btnGoToMy = new JButton("Go to my library");
		btnGoToMy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				MyLibrary log= new MyLibrary();
				log.newScreenLibrary();
				//frame.setVisible(false);
			}
		});
		btnGoToMy.setBounds(266, 376, 190, 23);
		frame.getContentPane().add(btnGoToMy);
		
		

		
		JButton btnNewButton = new JButton("All books");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BookLogic book = new BookLogic();
				ArrayList<String[]>bb = new ArrayList<String[]>();
				DefaultTableModel model= new DefaultTableModel();
				
				String[] columns= {"Title", "Author", "Genre", "Release Date","Price","Status"};
				int n =columns.length;
				try {
					bb=book.viewAll();
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
				for(int i=0;i<n;i++) {
					model.addColumn(columns[i]);
			    }
			    for(String[] b: bb) {
				    model.addRow(b);
			    }
				
			    table_1.setModel(model);
              
			}
		});
		btnNewButton.setBounds(51, 376, 212, 23);
		frame.getContentPane().add(btnNewButton);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerListModel(new String[] {"Genre", "Trends"}));
		spinner_1.setForeground(SystemColor.menu);
		spinner_1.setBounds(213, 86, 97, 20);
		
		JButton btnSearch = new JButton("Recommend");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RecommendFactory rf= new RecommendFactory();
				String rrr="";
				Recommend rr=rf.getOneRecommend(spinner_1.getValue().toString());
				try {
					rrr=rr.returnRecommend();
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
				
				//System.out.println(spinner_1.getValue().toString());
				textArea.setText(rrr);
			}
		});
		
		btnSearch.setBounds(320, 86, 100, 23);
		frame.getContentPane().add(btnSearch);
		
		
		frame.getContentPane().add(spinner_1);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setText("Recommend by:");
		textArea_1.setFont(new Font("Dialog", Font.PLAIN, 13));
		textArea_1.setEditable(false);
		textArea_1.setBackground(SystemColor.menu);
		textArea_1.setBounds(103, 85, 106, 22);
		frame.getContentPane().add(textArea_1);
		
		JTextArea txtrRecommendedBook = new JTextArea();
		txtrRecommendedBook.setText("Recommended book:");
		txtrRecommendedBook.setFont(new Font("Dialog", Font.PLAIN, 13));
		txtrRecommendedBook.setEditable(false);
		txtrRecommendedBook.setBackground(SystemColor.menu);
		txtrRecommendedBook.setBounds(48, 310, 190, 22);
		frame.getContentPane().add(txtrRecommendedBook);
		
		JTextArea txtrSearchBooksBy = new JTextArea();
		txtrSearchBooksBy.setText("Search books by:");
		txtrSearchBooksBy.setFont(new Font("Dialog", Font.PLAIN, 13));
		txtrSearchBooksBy.setEditable(false);
		txtrSearchBooksBy.setBackground(SystemColor.menu);
		txtrSearchBooksBy.setBounds(98, 55, 106, 22);
		frame.getContentPane().add(txtrSearchBooksBy);

	}
}
