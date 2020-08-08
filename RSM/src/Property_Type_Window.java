import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.TableView.TableRow;
import javax.swing.text.html.ListView;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.swing.border.LineBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.AbstractListModel;

public class Property_Type_Window {

	private JFrame frame;
	private JTextField textField_Id;
	private JTextField textField_Name;

	
	DefaultListModel<String> listModel =  new DefaultListModel<String>() ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Property_Type_Window window = new Property_Type_Window();
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
	public Property_Type_Window() {
		initialize();
		//fillTypeList();
	}
public void fillTypeList(DefaultListModel<String> listModel) {
		
		JList<String> list1 = new JList<String>();
			P_Type type= new P_Type();
			
			HashMap<String,Integer> map= type.getTypeMap();
			//System.out.println(type.getTypeMap().toString());
			//DefaultListModel<String> listModel =  new DefaultListModel<String>() ;
			int i=0;
			for(String typeName: map.keySet()) {
				//listModel.add(i, typeName);
				listModel.addElement(typeName);
				i++;
				
			}
			//list1.setModel(listModel);
			listModel.addElement("******");
			list1.setModel(listModel);
			//String[] values = new String[] {list1.getModel()};
		//	System.out.println(list1.getModel().toString());
		}

		
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 799, 495);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 777, 70);
		panel.setBackground(Color.GRAY);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblPropertyType = new JLabel("Property Type");
		lblPropertyType.setForeground(Color.WHITE);
		lblPropertyType.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblPropertyType.setBounds(284, 11, 196, 48);
		panel.add(lblPropertyType);
		
		Border propertyType_border= BorderFactory.createMatteBorder(0,0,3,0,Color.WHITE);
		lblPropertyType.setBorder(propertyType_border);
		
	
		
		
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(74, 117, 43, 29);
		lblId.setFont(new Font("Tahoma", Font.BOLD, 15));
		frame.getContentPane().add(lblId);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(53, 157, 64, 29);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 15));
		frame.getContentPane().add(lblName);
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setBounds(10, 197, 107, 29);
		lblDescription.setFont(new Font("Tahoma", Font.BOLD, 15));
		frame.getContentPane().add(lblDescription);
		
		textField_Id = new JTextField();
		textField_Id.setBounds(127, 120, 107, 22);
		textField_Id.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(textField_Id);
		textField_Id.setColumns(10);
		
		textField_Name = new JTextField();
		textField_Name.setBounds(127, 160, 251, 22);
		textField_Name.setScrollOffset(20);
		textField_Name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_Name.setColumns(10);
		frame.getContentPane().add(textField_Name);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(127, 210, 251, 104);
		frame.getContentPane().add(scrollPane);
		
		JTextArea textArea_Description = new JTextArea();
		scrollPane.setViewportView(textArea_Description);
		textArea_Description.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		// fillTypeList();
		 
		JButton btnAdd_Button = new JButton("Add");
		btnAdd_Button.setBounds(53, 361, 102, 29);
		btnAdd_Button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdd_Button.setForeground(Color.WHITE);
		btnAdd_Button.setBackground(Color.GREEN);
		btnAdd_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String name= textField_Name.getText();
				String description = textArea_Description.getText();
				
				P_Type type=new P_Type(0,name,description);
				
				if(!name.trim().equals(""))
				{
					if(type.execTypeQuery("add", type))
					{
						JOptionPane.showMessageDialog(null, "New type added","Add type",1);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Operation Failed","Add type",2);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Insert the type name","Empty Name",2);
				}
				
			}
		});
		btnAdd_Button.setFont(new Font("Tahoma", Font.BOLD, 11));
		frame.getContentPane().add(btnAdd_Button);
		
		JButton btnEdit_Button = new JButton("Edit");
		btnEdit_Button.setBounds(180, 361, 105, 29);
		btnEdit_Button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEdit_Button.setBackground(Color.ORANGE);
		btnEdit_Button.setForeground(Color.WHITE);
		btnEdit_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Integer id=Integer.valueOf(textField_Id.getText());
					String name= textField_Name.getText();
					String description = textArea_Description.getText();
					
					P_Type type=new P_Type(id,name,description);
					
					if(!name.trim().equals(""))
					{
						if(type.execTypeQuery("edit", type))
						{
							JOptionPane.showMessageDialog(null, "Type updated","Edit type",1);
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Operation Failed","Edit type",2);
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Insert the type name","Empty Name",2);
					}
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage()+"Insert a valid type ID","Invalid Id",0);
				}
			}
		});
		btnEdit_Button.setFont(new Font("Tahoma", Font.BOLD, 11));
		frame.getContentPane().add(btnEdit_Button);
		
		JButton btnRemove_Button = new JButton("Remove");
		btnRemove_Button.setBounds(314, 361, 103, 29);
		btnRemove_Button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRemove_Button.setForeground(Color.WHITE);
		btnRemove_Button.setBackground(Color.RED);
		btnRemove_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				

				try {

					Integer id=Integer.valueOf(textField_Id.getText());
					
					
					P_Type type=new P_Type(id,"","");
					
					if(!textField_Id.getText().trim().equals(""))
					{
						int yes_or_no = JOptionPane.showConfirmDialog(null, "Do you want to delete this type?","Delete type",JOptionPane.YES_NO_OPTION);
						
						if(yes_or_no ==JOptionPane.YES_OPTION)
						{
							if(type.execTypeQuery("remove", type))
							{
								JOptionPane.showMessageDialog(null, "Type Deleted","Delete type",1);
							}
							else
							{
								JOptionPane.showMessageDialog(null, "Operation Failed","Delete type",2);
							}
						}
						
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Insert the type Id","Empty Id",2);
					}
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage()+"Insert a valid type ID","Invalid Id",0);
				}
			}
		});
		btnRemove_Button.setFont(new Font("Tahoma", Font.BOLD, 11));
		frame.getContentPane().add(btnRemove_Button);
		
		JButton btnRefresh_Button = new JButton("Refresh");
		btnRefresh_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				fillTypeList(listModel);
			}
		});
		btnRefresh_Button.setBounds(454, 361, 271, 29);
		btnRefresh_Button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRefresh_Button.setBackground(Color.BLUE);
		btnRefresh_Button.setForeground(Color.WHITE);
		btnRefresh_Button.setFont(new Font("Tahoma", Font.BOLD, 11));
		frame.getContentPane().add(btnRefresh_Button);
		
	//	list1.setModel(new fillTypeList());
//		list1.setModel(new AbstractListModel() {
//			String[] values = new String[] {"List"};
//			public int getSize() {
//				return values.length;
//			}
//			public Object getElementAt(int index) {
//				return values[index];
//			}
//		});
		fillTypeList(listModel);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(438, 117, 302, 197);
		frame.getContentPane().add(scrollPane_1);
		
		JList list1 = new JList();
		scrollPane_1.setViewportView(list1);
		list1.setModel(listModel);
		//System.out.println(list1.getModel().toString());
		list1.setName("list1");
		//fillTypeList();
		list1.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				P_Type type= new P_Type();
				HashMap<String,Integer> map= type.getTypeMap();
				
				Integer typeId=map.get(list1.getSelectedValue());
			//	Integer i= map.get(list1.getSelectedValue());
				type=type.getTypeById(typeId);
				textField_Id.setText(type.getId().toString());
				textField_Name.setText(type.getName());
				textArea_Description.setText(type.getDescription());
				//System.out.println(map.toString());
			}
		});
		//fillTypeList();
		
	
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		frame.setVisible(true);
	}

	public void pack() {
		// TODO Auto-generated method stub
		
	}

	public void setDefaultCloseOperation(int disposeOnClose) {
		// TODO Auto-generated method stub
		frame.getDefaultCloseOperation();
	}

	public void setLocationRelativeTo(Object object) {
		// TODO Auto-generated method stub
		
	}
	
	
}
