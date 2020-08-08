import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SHOW_PROPERTIES {

	private JFrame frame;
	
	
	private JTable table_1;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JTextField textField_1;
	
	
	
	public void fillJtableWithPropertiesData()
	{
		P_PROPERTY property= new P_PROPERTY();
		
		ArrayList<P_PROPERTY> propertyList=property.propertiesList();
		
		String[] colNames= {"ID","Type","Square_feet","Owner","Price","Address","Bedrooms","Bathrooms","Age","Balcony","Pool","Backyard","Garage","Description"};
		
		
		Object [] [] rows=new Object[propertyList.size()][16];
		
		
		for(int i=0;i<propertyList.size();i++) {
			
			
			rows[i][0]=propertyList.get(i).getId();
			rows[i][1]=propertyList.get(i).getType();
			rows[i][2]=propertyList.get(i).getSize();
			rows[i][3]=propertyList.get(i).getOwnerId();
			rows[i][4]=propertyList.get(i).getPrice();
			rows[i][5]=propertyList.get(i).getAddress();
			rows[i][6]=propertyList.get(i).getBedrooms();
			rows[i][7]=propertyList.get(i).getBathrooms();
			rows[i][8]=propertyList.get(i).getAge();
			if(propertyList.get(i).isBalcony())  rows[i][9]="YES";
			else {
				 rows[i][9]="NO";
			}
			if(propertyList.get(i).isPool())  rows[i][10]="YES";
			else {
				 rows[i][10]="NO";
			}
			if(propertyList.get(i).isBackyard())  rows[i][11]="YES";
			else {
				 rows[i][11]="NO";
			}
			if(propertyList.get(i).isGarage())  rows[i][12]="YES";
			else {
				 rows[i][12]="NO";
			}
			
			rows[i][13]=propertyList.get(i).getDescription();
			
			
			
		}
		
		DefaultTableModel model=new DefaultTableModel(rows,colNames);
//		table_1.setModel(
//				new DefaultTableModel(
//			new Object[][] {
//				{},
//			},
//			new String[] {
//			}
//		)
//				);
		table_1.setModel(model);
		
	
		
		
		
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SHOW_PROPERTIES window = new SHOW_PROPERTIES();
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
	public SHOW_PROPERTIES() {
		initialize();
		fillJtableWithPropertiesData();
	table_1.setRowHeight(40);
		
		table_1.setSelectionBackground(new Color(27,150,77));
		
		lblNewLabel = new JLabel("Address:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(21, 369, 90, 39);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(21, 418, 370, 144);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setForeground(Color.WHITE);
		lblDescription.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblDescription.setBounds(543, 369, 112, 39);
		frame.getContentPane().add(lblDescription);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(543, 418, 370, 144);
		frame.getContentPane().add(textField_1);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(21, 514, 17, 48);
		frame.getContentPane().add(scrollBar);
		
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(160, 82, 45));
		frame.setBounds(100, 100, 1011, 630);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
	
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int selectedRowIndex=table_1.getSelectedRow();
				textField.setText(table_1.getValueAt(selectedRowIndex,5).toString());
				textField_1.setText(table_1.getValueAt(selectedRowIndex,13).toString());
				
				
				
			}
		});
		scrollPane.setBounds(21, 23, 954, 347);
		frame.getContentPane().add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		
	
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
	
