import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class PROPERTY_IMAGES_WINDOW {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	P_Type type= new P_Type();
	HashMap<String,Integer> map= type.getTypeMap();
	String property_image_path="";
	int propertyId;
	private JTable table_property;
	
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PROPERTY_IMAGES_WINDOW window = new PROPERTY_IMAGES_WINDOW();
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
	public PROPERTY_IMAGES_WINDOW() {
		initialize();
		bindCombo() ;
		fillJtableWithPropertiesData();
		
		int rowIndex = table_property.getSelectedRow();
		
	//	propertyId = Integer.valueOf(table_property.getValueAt(rowIndex, 0).toString());
		
		//display image in list
		//fillImageList();
		
	}
	
public void fillImageList() {
		
			HashMap<byte[],Integer> imageListMap = new P_PROPERTY().propertyImagesList(propertyId);
			JList list = new JList();
			DefaultListModel listModel = new DefaultListModel();
			
			int i=0;
			for(Integer id: imageListMap.values()) {
			
				listModel.add(i,id);
				i++;
				
			}
			
			list.setModel(listModel);
		
		}


	/**
	 * Initialize the contents of the frame.
	 */
	
	public void bindCombo() {
		JComboBox comboBox = new JComboBox();
			for(String s: map.keySet()) {
				
				comboBox.addItem(s);
				//System.out.println(s);
			}
			
	}
public ImageIcon resizeImage(String path,byte[] byteImage){
		
		JLabel lblNewLabel = new JLabel("Property-Images");
		ImageIcon pic;
		if(byteImage!=null) pic =new ImageIcon(byteImage);
		else pic=new ImageIcon(path);
	//	Image img=pic.getImage().getScaledInstance(lblNewLabel.getWidth(),lblNewLabel.getHeight(),Image.SCALE_SMOOTH);
		Image img=pic.getImage();
		ImageIcon image=new ImageIcon(img);
		return image;
	}
	
	
	public void fillJtableWithPropertiesData()
	{
		P_PROPERTY property= new P_PROPERTY();
		
		ArrayList<P_PROPERTY> propertyList=property.propertiesList();
		
		String[] colNames= {"ID","Address"};
		
		
		Object [] [] rows=new Object[propertyList.size()][2];
		
		
		for(int i=0;i<propertyList.size();i++) {
		
			rows[i][0]=propertyList.get(i).getId();
			
			rows[i][1]=propertyList.get(i).getAddress();
		
		
		}
		
		DefaultTableModel model=new DefaultTableModel(rows,colNames);
		
		
		table_property.setModel(model);
	}
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().addMouseListener(new MouseAdapter() {
		
			
		});
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBounds(100, 100, 1328, 761);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
//		table.setRowHeight(40);
//		table.setSelectionBackground(new Color(27,150,77));
		
		table_property = new JTable();
		table_property.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int rowIndex =table_property.getSelectedRow();
				propertyId = Integer.valueOf(table_property.getValueAt(rowIndex, 0).toString());
			}
		});
		table_property.setBounds(52, 176, 410, 375);
		frame.getContentPane().add(table_property);
//		table.getColumnModel().getColumn(0).setPreferredWidth(25);
//		table.getColumnModel().getColumn(1).setPreferredWidth(250);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 1314, 67);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Property-Images");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 22));
		lblNewLabel.setBounds(451, 5, 223, 52);
		panel.add(lblNewLabel);
		
		JButton btnShowProperty = new JButton("Show this Property");
		btnShowProperty.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					// show the image
					Property_Image_Slider imagesSliderform= new Property_Image_Slider(propertyId);
					
					int rowIndex = table_property.getSelectedRow();
					int id=Integer.valueOf(table_property.getValueAt(rowIndex, 0).toString());
					
					imagesSliderform.propertyId=id;
					imagesSliderform.setVisible(true);
					imagesSliderform.pack();
					imagesSliderform.setLocationRelativeTo(null);
					imagesSliderform.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
				}
				catch(Exception ex) {

					JOptionPane.showMessageDialog(null,"Select the Property first","Property not selected", 2);
				}
				
			}
		});
		btnShowProperty.setBackground(Color.BLUE);
		btnShowProperty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnShowProperty.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnShowProperty.setBounds(52, 576, 410, 46);
		frame.getContentPane().add(btnShowProperty);
		
		JButton btnRemove = new JButton("REMOVE");
		btnRemove.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				JList list = new JList();
				String selectedListItem=String.valueOf(list.getSelectedValue());
				
				Integer imageId=Integer.valueOf(selectedListItem);
				int yes_or_no =JOptionPane.showConfirmDialog(null, "Do you want to Delete This Image","Delete Image", JOptionPane.YES_NO_OPTION);
				if(yes_or_no==JOptionPane.YES_OPTION)
				{
					if(new P_PROPERTY().removePropertyImage(imageId)) {
						JOptionPane.showMessageDialog(null, "Property Image Deleted","Delete Image", 1);
					}
				}
				else {
					JOptionPane.showMessageDialog(null,"Operation Failed","Delete Property",2);
				}
			}
		});
		btnRemove.setBackground(Color.GREEN);
		btnRemove.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnRemove.setBounds(496, 576, 281, 46);
		frame.getContentPane().add(btnRemove);
		
		JButton btnAddImage = new JButton("ADD");
		btnAddImage.setActionCommand("ADD");
		btnAddImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				P_PROPERTY property=new P_PROPERTY();
				if(propertyId!=0) {
				if(property.addImage(propertyId, property_image_path)) {
					JOptionPane.showMessageDialog(null,"Image Added to this Property","Add Image", 1);
				}
				
				else {
					JOptionPane.showMessageDialog(null,"Image Not Added to this Property","Add Image", 2);
				
				}
				}
				else {
				JOptionPane.showMessageDialog(null,"Select the Property first","Property not selected", 2);
			}
			}
		});
		btnAddImage.setBackground(Color.YELLOW);
		btnAddImage.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnAddImage.setBounds(841, 576, 434, 46);
		frame.getContentPane().add(btnAddImage);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int typeId = map.get(comboBox.getSelectedItem().toString());
				//System.out.println(typeId);
				
				P_PROPERTY property= new P_PROPERTY();
				
					ArrayList<P_PROPERTY> propertyList = property.propertiesListByType(typeId);
					
			//	System.out.println(property.propertiesListByType(typeId));
					
				String[] colNames= {"ID","Address"};
				
				
				Object [] [] rows=new Object[propertyList.size()][2];
				
				
				for(int i=0;i<propertyList.size();i++) {
					
					
					rows[i][0]=propertyList.get(i).getId();
					
					rows[i][1]=propertyList.get(i).getAddress();
					
				}
				
				DefaultTableModel model=new DefaultTableModel(rows,colNames);
				table_property.setModel(model);
				
			}
		});
		for(String s: map.keySet()) {
			
			comboBox.addItem(s);
		//	System.out.println(s);
		}
		
		
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox.setBounds(264, 104, 198, 46);
		frame.getContentPane().add(comboBox);

		
		JLabel lblNewLabel_Image = new JLabel("");
		lblNewLabel_Image.setOpaque(true);
		lblNewLabel_Image.setBackground(Color.PINK);
		lblNewLabel_Image.setBounds(841, 176, 434, 355);
		frame.getContentPane().add(lblNewLabel_Image);
		

		
		JButton Button_Image = new JButton("Browse");
		Button_Image.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				JFileChooser fileChooser=new JFileChooser();
				fileChooser.setDialogTitle("Select The Property Image");
				fileChooser.setCurrentDirectory(new File("D:\\Images"));
				
				FileNameExtensionFilter fileFilter=new FileNameExtensionFilter("Images",".jpg",".png",".jpeg");
				fileChooser.addChoosableFileFilter(fileFilter);
				int fileState=fileChooser.showSaveDialog(null);
				if(fileState==JFileChooser.APPROVE_OPTION) {
					String path=fileChooser.getSelectedFile().getAbsolutePath();
					lblNewLabel_Image.setIcon(resizeImage(path,null));
					property_image_path=path;
			}
			}});
		
		Button_Image.setFont(new Font("Tahoma", Font.BOLD, 24));
		Button_Image.setBounds(1107, 102, 167, 49);
		frame.getContentPane().add(Button_Image);
		
		JList list = new JList();
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String selectedListItem=String.valueOf(list.getSelectedValue());
				Integer imageId=Integer.valueOf(selectedListItem);
				byte[] image=new P_PROPERTY().getImageId(imageId);
				lblNewLabel_Image.setIcon(resizeImage("",image));
			
			}
		});
//		list.setModel(new AbstractListModel() {
//			String[] values = new String[] {};
//			public int getSize() {
//				return values.length;
//			}
//			public Object getElementAt(int index) {
//				return values[index];
//			}
//		});
		list.setBounds(496, 176, 281, 375);
		frame.getContentPane().add(list);
		
		JLabel lblNewLabel_2 = new JLabel("<html>*this table contains the property's id and addresses<br>(click on the button to show the images slider).</html>");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(52, 632, 410, 60);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("<html>*this list contains the images id<br> of the selected property<br>(select the property form the table)</html>");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1.setBounds(496, 626, 281, 76);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("<html>*select an itme from the list to display <br>or browse an image from your computer</html>");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_1.setBounds(841, 616, 321, 76);
		frame.getContentPane().add(lblNewLabel_2_1_1);
		
		JLabel lblSelectType = new JLabel("Select a Type:");
		lblSelectType.setForeground(Color.WHITE);
		lblSelectType.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblSelectType.setBounds(83, 104, 171, 44);
		frame.getContentPane().add(lblSelectType);
		
		JLabel lblSelectImage = new JLabel("Select Image:");
		lblSelectImage.setForeground(Color.WHITE);
		lblSelectImage.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblSelectImage.setBounds(932, 106, 165, 44);
		frame.getContentPane().add(lblSelectImage);
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
