import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Owner_Properties_Form {

	private JFrame frame;
	private JTable table;
	static int ownerId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Owner_Properties_Form window = new Owner_Properties_Form(ownerId);
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
	public Owner_Properties_Form(int oId) {
		
		this.ownerId=oId;
		initialize();
	}
	//function to populate property table
	
	
	
	
	//function to populate sales table
//	public void fillTableSales() {
//		P_Sale sale = new P_Sale();
//		ArrayList<P_Sale> saleList = sale.salesList();
//		
//		String[] colNames= {"ID","Property", "Client","Price"};
//		
//		Object[][] rows= new Object[saleList.size()][4];
//		
//		for(int i=0;i<saleList.size();i++)
//		{
//			rows[i][0] = saleList.get(i).getId();
//			rows[i][1] = saleList.get(i).getProperty_id();
//			rows[i][2] = saleList.get(i).getClient_id();
//			rows[i][3] = saleList.get(i).getFinalPrice();
//		}
//		
//		DefaultTableModel model= new DefaultTableModel(rows,colNames);
//		table_Sales.setModel(model);
//		
//	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 864, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(154, 205, 50));
		panel.setBounds(0, 0, 848, 462);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 11, 828, 440);
		panel.add(table);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		frame.setVisible(true);
	}

	public void pack() {
		// TODO Auto-generated method stub
		
	}

	public void setLocationRelativeTo(Object object) {
		// TODO Auto-generated method stub
		
	}

	public void setDefaultCloseOperation(int disposeOnClose) {
		// TODO Auto-generated method stub
		
	}
}
