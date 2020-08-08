import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
//import com.toedter.calendar.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Sale_Window {

	private JFrame frame;
	private JTextField textField_Id;
	private JTextField textField_PropertyID;
	private JTextField textField_ClientID;
	private JTextField textField_FinalPrice;
	private JTable table_Properties;
	private JTable table_Clients;
	//private JDateChooser date;
	private JTable table_Sales;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sale_Window window = new Sale_Window();
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
	public Sale_Window() {
		initialize();
		
 		fillTableProperties();
 		fillClientsTableData();
		 fillTableSales();
		
		// set selection background
		table_Properties.setSelectionBackground(new Color (0,100,0));
		
		JButton button_Refresh_Sales = new JButton("Refresh");
		button_Refresh_Sales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 fillTableSales();
			}
		});
		button_Refresh_Sales.setForeground(Color.WHITE);
		button_Refresh_Sales.setFont(new Font("Tahoma", Font.BOLD, 11));
		button_Refresh_Sales.setBackground(new Color(0, 0, 255));
		button_Refresh_Sales.setBounds(234, 393, 196, 22);
		frame.getContentPane().add(button_Refresh_Sales);
		
		JButton button_Refresh_Client = new JButton("Refresh");
		button_Refresh_Client.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fillClientsTableData();
			}
		});
		button_Refresh_Client.setForeground(Color.WHITE);
		button_Refresh_Client.setFont(new Font("Tahoma", Font.BOLD, 11));
		button_Refresh_Client.setBackground(Color.BLUE);
		button_Refresh_Client.setBounds(459, 393, 196, 22);
		frame.getContentPane().add(button_Refresh_Client);
		
		JButton button_Refresh_Property = new JButton("Refresh");
		button_Refresh_Property.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fillTableProperties();
			}
		});
		button_Refresh_Property.setForeground(Color.WHITE);
		button_Refresh_Property.setFont(new Font("Tahoma", Font.BOLD, 11));
		button_Refresh_Property.setBackground(Color.BLUE);
		button_Refresh_Property.setBounds(681, 392, 196, 22);
		frame.getContentPane().add(button_Refresh_Property);
		
		JButton Button_Add_Client_Table = new JButton("Add New Client");
		Button_Add_Client_Table.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CLIENT_WINDOW clientform= new CLIENT_WINDOW();
				clientform.setVisible(true);
				clientform.pack();
				clientform.setLocationRelativeTo(null);
				clientform.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
			}
		});
		Button_Add_Client_Table.setForeground(Color.WHITE);
		Button_Add_Client_Table.setFont(new Font("Tahoma", Font.BOLD, 11));
		Button_Add_Client_Table.setBackground(new Color(255, 255, 0));
		Button_Add_Client_Table.setBounds(459, 426, 196, 22);
		frame.getContentPane().add(Button_Add_Client_Table);
		
		JButton Button_Add_Properties_Table = new JButton("Add New Property");
		Button_Add_Properties_Table.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Property_Type_Window typeform= new Property_Type_Window();
				typeform.setVisible(true);
				typeform.pack();
				typeform.setLocationRelativeTo(null);
				typeform.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
			}
		});
		Button_Add_Properties_Table.setForeground(Color.WHITE);
		Button_Add_Properties_Table.setFont(new Font("Tahoma", Font.BOLD, 11));
		Button_Add_Properties_Table.setBackground(new Color(255, 255, 0));
		Button_Add_Properties_Table.setBounds(681, 426, 196, 22);
		frame.getContentPane().add(Button_Add_Properties_Table);
	}
// populate  property table
	
	public void fillTableProperties() {
		P_PROPERTY property = new P_PROPERTY();
		ArrayList<P_PROPERTY> propertyList = property.propertiesList();
		
		String[] colNames= {"ID","Owner Id", "Price"};
		
		Object[][] rows= new Object[propertyList.size()][3];
		
		for(int i=0;i<propertyList.size();i++)
		{
			rows[i][0] = propertyList.get(i).getId();
			rows[i][1] = propertyList.get(i).getOwnerId();
			rows[i][2] = propertyList.get(i).getPrice();
		}
		
		DefaultTableModel model= new DefaultTableModel(rows,colNames);
		table_Properties.setModel(model);
		
	}
	// populate client table
	
	public void fillClientsTableData()
	{
	
		P_Client client=new P_Client();
		ArrayList<P_Client> clientsList=client.clientsList();
		
		//table columns
		String[] colmNames  = {"ID","FIRST NAME","LAST NAME"};
		
		Object[][] rows=new Object[clientsList.size()][3];
		
		for(int i=0;i<clientsList.size();i++)
		{
			rows[i][0]=clientsList.get(i).getId();
			rows[i][1]=clientsList.get(i).getFName();
			rows[i][2]=clientsList.get(i).getLName();
			
		}
		DefaultTableModel model= new DefaultTableModel(rows,colmNames);
		table_Clients.setModel(model);
		//System.out.println(clientsList);
	}
	
	// populate  sale table
	
		public void fillTableSales() {
			P_Sale sale = new P_Sale();
			ArrayList<P_Sale> saleList = sale.salesList();
			
			String[] colNames= {"ID","Property", "Client","Price"};
			
			Object[][] rows= new Object[saleList.size()][4];
			
			for(int i=0;i<saleList.size();i++)
			{
				rows[i][0] = saleList.get(i).getId();
				rows[i][1] = saleList.get(i).getProperty_id();
				rows[i][2] = saleList.get(i).getClient_id();
				rows[i][3] = saleList.get(i).getFinalPrice();
			}
			
			DefaultTableModel model= new DefaultTableModel(rows,colNames);
			table_Sales.setModel(model);
			
		}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 69, 0));
		frame.setBounds(100, 100, 903, 493);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
//		date = new JDateChooser();
//		//date.enable(true);
//		date.getCalendarButton();
//		date.getCalendar();
//		date.isEnabled();
	
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 887, 70);
		panel.setLayout(null);
		panel.setBackground(new Color(255, 0, 0));
		frame.getContentPane().add(panel);
		
		JLabel lblSale = new JLabel("Sale");
		lblSale.setForeground(Color.WHITE);
		lblSale.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblSale.setBounds(417, 11, 124, 48);
		panel.add(lblSale);
		
		JLabel label_1 = new JLabel("ID:");
		label_1.setBounds(80, 82, 43, 29);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		frame.getContentPane().add(label_1);
		
		JLabel lblClientId = new JLabel("Property ID:");
		lblClientId.setBounds(16, 122, 97, 29);
		lblClientId.setFont(new Font("Tahoma", Font.BOLD, 15));
		frame.getContentPane().add(lblClientId);
		
		textField_Id = new JTextField();
		textField_Id.setBounds(123, 85, 77, 22);
		textField_Id.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_Id.setColumns(10);
		frame.getContentPane().add(textField_Id);
		
		textField_PropertyID = new JTextField();
		textField_PropertyID.setBounds(123, 125, 77, 22);
		textField_PropertyID.setScrollOffset(20);
		textField_PropertyID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_PropertyID.setColumns(10);
		frame.getContentPane().add(textField_PropertyID);
		
		JButton button = new JButton("Add");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//add a new sale
				try {
					//int id = Integer.valueOf(textField_Id.getText());
					int propertyId = Integer.valueOf(textField_PropertyID.getText());
					int ClientId = Integer.valueOf(textField_ClientID.getText());
					String finalPrice = textField_FinalPrice.getText();
					//SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
					//String seelingDate = dateFormate.format(DATECHOOSER.getDate());
					
					P_Sale sale = new P_Sale(0,propertyId,ClientId,finalPrice);
					
					if(new P_Sale().addNewSale(sale))
					{
						JOptionPane.showMessageDialog(null, "A new sale is created","Add Sale",1);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Sale not created","Add Sale",2);
					}
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage()+"Select Property Id and Client Id","Add Sale",2);
				}
				
			}
		});
		button.setBounds(51, 271, 115, 29);
		button.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.BOLD, 11));
		button.setBackground(Color.GREEN);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("Edit");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//edit sale
				try {
					int id = Integer.valueOf(textField_Id.getText());
					int propertyId = Integer.valueOf(textField_PropertyID.getText());
					int ClientId = Integer.valueOf(textField_ClientID.getText());
					String finalPrice = textField_FinalPrice.getText();
					SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
					//String seelingDate = dateFormate.format(DATECHOOSER.getDate());
					
					P_Sale sale = new P_Sale(id ,propertyId,ClientId,finalPrice);
					
					if(new P_Sale().editSale(sale))
					{
						JOptionPane.showMessageDialog(null, "Sale data is updated","Edit Sale",1);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Sale not created","Edit Sale",2);
					}
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Select Property Id and Client Id","Add Sale",2);
				}
				
			}
		});
		button_1.setBounds(51, 330, 115, 29);
		button_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		button_1.setBackground(Color.ORANGE);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("Remove");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//delete sale
				try {
					int id = Integer.valueOf(textField_Id.getText());
				
					
					if(new P_Sale().deleteSale(id))
					{
						JOptionPane.showMessageDialog(null, "Sale data is deleted","Delete Sale",1);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Sale Deleted","Delete Sale",2);
					}
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Select Sale Id","Delete Sale Error",2);
				}
			}
		});
		button_2.setBounds(51, 390, 115, 29);
		button_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		button_2.setBackground(Color.RED);
		frame.getContentPane().add(button_2);
		
		JLabel lblClientId_1 = new JLabel("Client ID:");
		lblClientId_1.setBounds(26, 162, 87, 29);
		lblClientId_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		frame.getContentPane().add(lblClientId_1);
		
		textField_ClientID = new JTextField();
		textField_ClientID.setBounds(123, 165, 77, 22);
		textField_ClientID.setScrollOffset(20);
		textField_ClientID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_ClientID.setColumns(10);
		frame.getContentPane().add(textField_ClientID);
		
		JLabel lblFinalPrice = new JLabel("Final Price:");
		lblFinalPrice.setBounds(16, 202, 97, 29);
		lblFinalPrice.setFont(new Font("Tahoma", Font.BOLD, 15));
		frame.getContentPane().add(lblFinalPrice);
		
		textField_FinalPrice = new JTextField();
		textField_FinalPrice.setBounds(123, 205, 77, 22);
		textField_FinalPrice.setScrollOffset(20);
		textField_FinalPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_FinalPrice.setColumns(10);
		frame.getContentPane().add(textField_FinalPrice);
		
		table_Properties = new JTable();
		table_Properties.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				int selectedRowIndex =  table_Properties.getSelectedRow();
				textField_PropertyID.setText(table_Properties.getValueAt(selectedRowIndex, 0).toString());
				//textField_ClientID.setText(table_Properties.getValueAt(selectedRowIndex, 2).toString());
				textField_FinalPrice.setText(table_Properties.getValueAt(selectedRowIndex, 2).toString());
			}
		});
		table_Properties.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_Properties.setBounds(681, 99, 196, 279);
		frame.getContentPane().add(table_Properties);
		
		JLabel lblPropertyList = new JLabel("Property List");
		lblPropertyList.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPropertyList.setBounds(682, 67, 107, 29);
		frame.getContentPane().add(lblPropertyList);
		
		table_Clients = new JTable();
		table_Clients.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				int selectedRowIndex =  table_Clients.getSelectedRow();
				textField_ClientID.setText(table_Clients.getValueAt(selectedRowIndex, 0).toString());
				//textField_PropertyID.setText(table_Clients.getValueAt(selectedRowIndex, 1).toString());
			}
		});
		table_Clients.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_Clients.setBounds(459, 99, 196, 279);
		frame.getContentPane().add(table_Clients);
		//fillClientsTableData();
		
		JLabel lblClientList = new JLabel("Client List");
		lblClientList.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblClientList.setBounds(460, 67, 107, 29);
		frame.getContentPane().add(lblClientList);
		
		table_Sales = new JTable();
		table_Sales.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				int selectedRowIndex =  table_Sales.getSelectedRow();
				textField_Id.setText(table_Sales.getValueAt(selectedRowIndex, 0).toString());
				textField_PropertyID.setText(table_Sales.getValueAt(selectedRowIndex, 1).toString());
				textField_ClientID.setText(table_Sales.getValueAt(selectedRowIndex, 2).toString());
				textField_FinalPrice.setText(table_Sales.getValueAt(selectedRowIndex, 3).toString());
				
				
			}
		});
		table_Sales.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_Sales.setBounds(234, 99, 196, 279);
		frame.getContentPane().add(table_Sales);
		
		JLabel lblSaleList = new JLabel("Sale List");
		lblSaleList.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSaleList.setBounds(235, 67, 107, 29);
		frame.getContentPane().add(lblSaleList);
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
		frame.getDefaultCloseOperation();
	}
}
