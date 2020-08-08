import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;
import javax.swing.JScrollBar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.awt.Cursor;
import javax.swing.SpinnerNumberModel;

public class PROPERTY_WINDOW {
	P_Type type=new P_Type();
	HashMap<String, Integer> map=type.getTypeMap();

	private JFrame frame;
	private JTextField textField_Id;
	private JTextField textField_area;
	private JTextField textField_ownerId;
	private JTextField textField_price;
	private JTextField textField_address;
	private JTextField textField_description;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PROPERTY_WINDOW window = new PROPERTY_WINDOW();
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
	public PROPERTY_WINDOW() {
		initialize();
		bindCombo();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	public void bindCombo() {
	
		JComboBox comboBox_type = new JComboBox();
			for(String s: map.keySet()) {
				
				comboBox_type.addItem(s);
			//	System.out.println(s);
			}
			
	}
	
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1239, 681);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(34, 139, 34));
		panel.setBounds(0, 0, 1225, 72);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_Property = new JLabel("Property");
		lblNewLabel_Property.setForeground(new Color(255, 255, 255));
		lblNewLabel_Property.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel_Property.setBounds(539, 10, 140, 57);
		panel.add(lblNewLabel_Property);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(127, 255, 0));
		panel_1.setBounds(0, 74, 1225, 570);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_Id = new JLabel("ID:");
		lblNewLabel_Id.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_Id.setBounds(106, 47, 51, 33);
		panel_1.add(lblNewLabel_Id);
		
		textField_Id = new JTextField();
		textField_Id.setBounds(167, 52, 128, 33);
		panel_1.add(textField_Id);
		textField_Id.setColumns(10);
		
		
		JLabel lblNewLabel_Type = new JLabel("Type:");
		lblNewLabel_Type.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_Type.setBounds(82, 106, 78, 33);
		panel_1.add(lblNewLabel_Type);
		
		JComboBox comboBox_type = new JComboBox();
		comboBox_type.setBackground(new Color(255, 255, 255));
		comboBox_type.setToolTipText("");
		comboBox_type.setBounds(170, 108, 282, 38);
		panel_1.add(comboBox_type);
		//bindCombo();
		for(String s: map.keySet()) {
			
			comboBox_type.addItem(s);
		//	System.out.println(s);
		}
//		comboBox_type.addItem("Commercial");
//		comboBox_type.addItem("Residential");
//		comboBox_type.addItem("Industrial");
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Square feet:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1_1_1.setBounds(10, 171, 148, 33);
		panel_1.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Owner Id:");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1_1_1_1.setBounds(31, 214, 128, 33);
		panel_1.add(lblNewLabel_1_1_1_1);
		
		textField_area = new JTextField();
		textField_area.setColumns(10);
		textField_area.setBounds(167, 172, 287, 33);
		panel_1.add(textField_area);
		
		textField_ownerId = new JTextField();
		textField_ownerId.setColumns(10);
		textField_ownerId.setBounds(165, 219, 287, 33);
		panel_1.add(textField_ownerId);
		
		JLabel lblNewLabel_Price = new JLabel("Price:");
		lblNewLabel_Price.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_Price.setBounds(79, 273, 78, 33);
		panel_1.add(lblNewLabel_Price);
		
		textField_price = new JTextField();
		textField_price.setColumns(10);
		textField_price.setBounds(167, 273, 287, 33);
		panel_1.add(textField_price);
		
		JLabel lblNewLabel_Address = new JLabel("Address:");
		lblNewLabel_Address.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_Address.setBounds(53, 330, 104, 33);
		panel_1.add(lblNewLabel_Address);
		
		textField_address = new JTextField();
		textField_address .setBounds(167, 330, 285, 138);
		panel_1.add(textField_address );
		textField_address.setColumns(10);
		
		JLabel lblNewLabel_Bedrooms = new JLabel("Bedrooms:");
		lblNewLabel_Bedrooms.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_Bedrooms.setBounds(516, 47, 136, 33);
		panel_1.add(lblNewLabel_Bedrooms);
		
		JSpinner spinner_bedroom = new JSpinner();
		spinner_bedroom.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_bedroom.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		spinner_bedroom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		spinner_bedroom.setBounds(659, 47, 83, 32);
		panel_1.add(spinner_bedroom);
		
		JLabel lblNewLabel_1_1_1_2_1 = new JLabel("Bathrooms:");
		lblNewLabel_1_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1_1_1_2_1.setBounds(516, 106, 136, 33);
		panel_1.add(lblNewLabel_1_1_1_2_1);
		
		JSpinner spinner_bathroom = new JSpinner();
		spinner_bathroom.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_bathroom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		spinner_bathroom.setBounds(659, 106, 83, 32);
		panel_1.add(spinner_bathroom);
		
		JLabel lblNewLabel_1_1_1_2_1_1 = new JLabel("Age of the house:");
		lblNewLabel_1_1_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1_1_1_2_1_1.setBounds(516, 171, 214, 33);
		panel_1.add(lblNewLabel_1_1_1_2_1_1);
		
		JSpinner spinner_age = new JSpinner();
		spinner_age.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_age.setFont(new Font("Tahoma", Font.PLAIN, 20));
		spinner_age.setBounds(659, 214, 83, 32);
		panel_1.add(spinner_age);
		
		JLabel lblNewLabel_2 = new JLabel("*0 means brand new");
		lblNewLabel_2.setForeground(new Color(128, 128, 128));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(536, 214, 116, 33);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1_1_2_1_2 = new JLabel("Description/comments:");
		lblNewLabel_1_1_1_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1_1_1_2_1_2.setBounds(516, 273, 273, 33);
		panel_1.add(lblNewLabel_1_1_1_2_1_2);
		
		textField_description = new JTextField();
		textField_description.setColumns(10);
		textField_description.setBounds(516, 330, 460, 138);
		panel_1.add(textField_description);
		
		JCheckBox CheckBox_balcony = new JCheckBox("Balcony");
		CheckBox_balcony.setFont(new Font("Tahoma", Font.PLAIN, 20));
		CheckBox_balcony.setBounds(865, 47, 111, 33);
		panel_1.add(CheckBox_balcony);
		
		JCheckBox CheckBox_pool = new JCheckBox("Pool");
		CheckBox_pool.setFont(new Font("Tahoma", Font.PLAIN, 20));
		CheckBox_pool.setBounds(865, 95, 78, 33);
		panel_1.add(CheckBox_pool);
		
		JCheckBox CheckBox_backyard = new JCheckBox("Backyard");
		CheckBox_backyard.setFont(new Font("Tahoma", Font.PLAIN, 20));
		CheckBox_backyard.setBounds(865, 149, 111, 33);
		panel_1.add(CheckBox_backyard);
		
		JCheckBox CheckBox_garage = new JCheckBox("Garage");
		CheckBox_garage.setFont(new Font("Tahoma", Font.PLAIN, 20));
		CheckBox_garage.setBounds(865, 203, 111, 33);
		panel_1.add(CheckBox_garage);
		
		
		JButton Button_search = new JButton("Search");
		Button_search.setBackground(new Color(192, 192, 192));
		Button_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// search button
				try {
					int propertyId=Integer.valueOf(lblNewLabel_Id.getText());
				
					P_PROPERTY property=new P_PROPERTY().searchProperty(propertyId);
					if(property !=null) {
						textField_address.setText(property.getAddress());
						textField_description.setText(property.getDescription());
						textField_price.setText(property.getPrice());
						textField_area.setText(String.valueOf(property.getSize()));
						textField_ownerId.setText(String.valueOf(property.getOwnerId()));
						
						
						
						//displaying the property type in the combobox
						for(Object type:map.keySet()) {
						
							if(map.get(type).equals(property.getType()))
								comboBox_type.setSelectedItem(type);
						}
						
						
						spinner_bedroom.setValue(property.getBedrooms());
						spinner_bathroom.setValue(property.getBathrooms());
						spinner_age.setValue(property.getAge());
						
						if(property.isBalcony()) CheckBox_balcony.setSelected(true);
						if(property.isPool()) CheckBox_pool.setSelected(true);
						if(property.isBackyard()) CheckBox_backyard.setSelected(true);
						if(property.isGarage()) CheckBox_garage.setSelected(true);
					}
					else {
						 JOptionPane.showMessageDialog(null,"Property Not Found","ERROR",0);
					}
					
				}
				catch(Exception ex){
					JOptionPane.showMessageDialog(null, "Enter a valid Property id","Inavlid Data",0);
				}
			}
		});
		Button_search.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Button_search.setBounds(305, 51, 96, 33);
		panel_1.add(Button_search);
		
		
		JButton btnNewButton_1 = new JButton("Add");
//		
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			
			public void mouseClicked(MouseEvent e) {
				try {
					int type =map.get(comboBox_type.getSelectedItem().toString());
					int ownerId=Integer.valueOf(textField_ownerId.getText());
					int squareFeet=Integer.valueOf(textField_area.getText());
					int bedrooms=Integer.valueOf(spinner_bedroom.getValue().toString());
					int bathrooms=Integer.valueOf(spinner_bathroom.getValue().toString());
					int age=Integer.valueOf(spinner_age.getValue().toString());
					boolean haveBalcony=false;
					boolean havePool=false;
					boolean haveBackyard=false;
					boolean haveGarage=false;
					if(CheckBox_balcony.isSelected()) haveBalcony=true;
					if(CheckBox_backyard.isSelected()) haveBackyard=true;
					if(CheckBox_pool.isSelected()) havePool=true;
					if(CheckBox_garage.isSelected()) haveGarage=true;
					String price=textField_price.getText();
					String address=textField_address.getText();
					String description=textField_description.getText();
					
					P_PROPERTY property =new P_PROPERTY(0,type,squareFeet,ownerId,price,address,bedrooms,bathrooms,age,haveBalcony,havePool,haveBackyard,haveGarage,description);
				
					if(new P_PROPERTY().addNewProperty(property)) {
						JOptionPane.showMessageDialog(null, "New Property Added to The System","Add Property",1);
					}
					else {
						JOptionPane.showMessageDialog(null, "Property Not Added to The System","Add Property",2);
					}
				
					
				}
				catch(Exception ex){
					JOptionPane.showMessageDialog(null,"Enter a valid Owner Id and Square Feet","Inavlid Data",0);
				}
	
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_1.setBounds(82, 502, 128, 33);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Edit");
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// edit the selected property
				try {
					
					
					int id=Integer.valueOf(textField_Id.getText());
					int type =map.get(comboBox_type.getSelectedItem().toString());
					int ownerId=Integer.valueOf(textField_ownerId.getText());
					int squareFeet=Integer.valueOf(textField_area.getText());
					int bedrooms=Integer.valueOf(spinner_bedroom.getValue().toString());
					int bathrooms=Integer.valueOf(spinner_bathroom.getValue().toString());
					int age=Integer.valueOf(spinner_age.getValue().toString());
					boolean haveBalcony=false;
					boolean havePool=false;
					boolean haveBackyard=false;
					boolean haveGarage=false;
					if(CheckBox_balcony.isSelected()) haveBalcony=true;
					if(CheckBox_backyard.isSelected()) haveBackyard=true;
					if(CheckBox_pool.isSelected()) havePool=true;
					if(CheckBox_garage.isSelected()) haveGarage=true;
					String price=textField_price.getText();
					String address=textField_address.getText();
					String description=textField_description.getText();
					
					P_PROPERTY property =new P_PROPERTY(0,type,squareFeet,ownerId,price,address,bedrooms,bathrooms,age,haveBalcony,havePool,haveBackyard,haveGarage,description);
					
					if(new P_PROPERTY().editProperty(property)) {
						JOptionPane.showMessageDialog(null, "Property Data Updated","Edit Property",1);
					}
					else {
						JOptionPane.showMessageDialog(null, "Property Not Updated","Edit Property",2);
					}
					
				}
				catch(Exception ex){
					JOptionPane.showMessageDialog(null, ex.getMessage()+"Enter a valid Property id ,Owner Id and Square Feet","Inavlid Data",0);
				}
				
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_1_1.setBounds(245, 502, 128, 33);
		panel_1.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Remove");
		btnNewButton_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				//remove the selected property
				try {
					int id=Integer.valueOf(textField_Id.getText());
					
					P_PROPERTY property=new P_PROPERTY();
					if(textField_Id.getText().trim().equals(""))
					{
						JOptionPane.showMessageDialog(null,"Enter the property ID","Empty ID",2);
					}
					else {
						
						int yes_or_no =JOptionPane.showConfirmDialog(null, "Do you want to Delete This Property","Delete Property", JOptionPane.YES_NO_OPTION);
						if(yes_or_no==JOptionPane.YES_OPTION) {
							if(property.removeProperty(id)) {
								JOptionPane.showMessageDialog(null, "Property Data Deleted","Delete Property",1);
								
								textField_Id.setText("");
								textField_address.setText("");
								textField_description.setText("");
								textField_price.setText("");
								textField_area.setText("");
								textField_ownerId.setText("");
								comboBox_type.setSelectedItem(0);
								
								
								spinner_bedroom.setValue(0);
								spinner_bathroom.setValue(0);
								spinner_age.setValue(0);
								
								CheckBox_balcony.setSelected(false);
								CheckBox_backyard.setSelected(false);
								CheckBox_pool.setSelected(false);
								CheckBox_garage.setSelected(false);
							}
							else {
								JOptionPane.showMessageDialog(null, "Operation Failed","Delete Property",2);
							}
						}
					}
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,ex.getMessage()+"Enter a valid property id","Invalid id",0);
				}
				
				
				
				
				
			}
		});
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1_2.setBounds(406, 502, 128, 33);
		panel_1.add(btnNewButton_1_2);
		
		JButton btnNewButton_1_2_1 = new JButton("Show Properties");
		btnNewButton_1_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				SHOW_PROPERTIES propertyForm=new SHOW_PROPERTIES();
				propertyForm.setVisible(true);
				propertyForm.pack();
				propertyForm.setLocationRelativeTo(null);
				propertyForm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
			}
		});
		btnNewButton_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1_2_1.setBounds(567, 502, 175, 33);
		panel_1.add(btnNewButton_1_2_1);
	}


public void setVisible(boolean b) {
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

