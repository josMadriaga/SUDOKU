import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

public class AppSodoku {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppSodoku window = new AppSodoku();
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
	public AppSodoku() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			initialize();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1121, 453);
		frame.setLocationRelativeTo(null);
		
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel ldlSudokuTable=new JLabel("Sudoku");
		ldlSudokuTable.setFont(new Font("Rockwell", Font.BOLD, 25));
		contentPane.add(ldlSudokuTable,BorderLayout.NORTH);
		
		JScrollPane scrollPaneTabla=new JScrollPane();
		contentPane.add(scrollPaneTabla);
		
//		JTable tablaS=new JTable();
//		scrollPaneTabla.setViewportView(tablaS);
//		
//		DefaultTableModel tabla=new DefaultTableModel();
//		tabla.setRowCount(4);
//		tabla.setColumnCount(4);
//		
//		tablaS.setModel(tabla);
//		tablaS.setRowHeight(20);
//		tablaS.setTableHeader(null);
//		tablaS.setGridColor(new java.awt.Color(0, 0, 0));
//		scrollPaneTabla.setViewportView(tablaS);
		
		table = new JTable();
		JTextField a=new JTextField("");
		table.setFont(new Font("Tahoma", Font.PLAIN, 11));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, "", null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"", "", "", ""
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				false, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPaneTabla.setColumnHeaderView(table);
		
	}
}
