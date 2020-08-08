import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Owner_Window {

	private JFrame frame;
	private JTextField textField_Id;
	private JTextField textField_FName;
	private JTextField textField_LName;
	private JTextField textField_Phone;
	private JTextField textField_Email;
	private JTable table1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Owner_Window window = new Owner_Window();
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
	public Owner_Window() {
		initialize();
		fillTableData();
	}
	
	public void fillTableData()
	{
		
		P_Owner owner=new P_Owner();
		ArrayList<P_Owner> ownersList=owner.ownersList();
		
		//table columns
		String[] colmNames  = {"ID","FIRST NAME","LAST NAME","PHONE","EMAIL","ADDRESS"};
		
		Object[][] rows=new Object[ownersList.size()][6];
		
		for(int i=0;i<ownersList.size();i++)
		{
			rows[i][0]=ownersList.get(i).getId();
			rows[i][1]=ownersList.get(i).getFName();
			rows[i][2]=ownersList.get(i).getLName();
			rows[i][3]=ownersList.get(i).getPhone();
			rows[i][4]=ownersList.get(i).getEmail();
			rows[i][5]=ownersList.get(i).getAddress();
		}
		DefaultTableModel model= new DefaultTableModel(rows,colmNames);
		table1.setModel(model);
//		model.addRow(rows);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(186, 85, 211));
		frame.setBounds(100, 100, 785, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 769, 70);
		panel.setLayout(null);
		panel.setBackground(new Color(148, 0, 211));
		frame.getContentPane().add(panel);
		
		JLabel lblOwnerType = new JLabel("Owners");
		lblOwnerType.setForeground(Color.WHITE);
		lblOwnerType.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblOwnerType.setBounds(335, 11, 124, 48);
		panel.add(lblOwnerType);
		
		JLabel label_1 = new JLabel("ID:");
		label_1.setBounds(74, 93, 43, 29);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		frame.getContentPane().add(label_1);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(20, 133, 107, 29);
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 15));
		frame.getContentPane().add(lblFirstName);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(38, 293, 72, 29);
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 15));
		frame.getContentPane().add(lblAddress);
		
		textField_Id = new JTextField();
		textField_Id.setBounds(137, 96, 107, 22);
		textField_Id.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_Id.setColumns(10);
		frame.getContentPane().add(textField_Id);
		
		textField_FName = new JTextField();
		textField_FName.setBounds(137, 136, 251, 22);
		textField_FName.setScrollOffset(20);
		textField_FName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_FName.setColumns(10);
		frame.getContentPane().add(textField_FName);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(137, 297, 249, 81);
		frame.getContentPane().add(scrollPane);
		
		JTextArea textArea_Address = new JTextArea();
		scrollPane.setViewportView(textArea_Address);
		textArea_Address.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JButton button_Add_Owner = new JButton("Add");
		button_Add_Owner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//ADD
				String fname=textField_FName.getText();
				String lname=textField_LName.getText();
				String phone=textField_Phone.getText();
				String email=textField_Email.getText();
				String address=textArea_Address.getText();
				
				P_Owner owner=new P_Owner();
				
				if(fname.trim().equals("") || lname.trim().equals("") || phone.trim().equals("") || email.trim().equals("") || address.trim().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Enter Valid Inputs","Add Owner",2);
				}
				else
				{
					if(owner.addNewOwner(new P_Owner(0,fname,lname,phone,email,address)))
					{
						JOptionPane.showMessageDialog(null, "New Owner Added","Add Owner",1);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "New Not Owner Added","Add Owner",2);
					}
				}
				
			}
		});
		button_Add_Owner.setBounds(38, 389, 102, 29);
		button_Add_Owner.setForeground(Color.WHITE);
		button_Add_Owner.setFont(new Font("Tahoma", Font.BOLD, 11));
		button_Add_Owner.setBackground(Color.GREEN);
		frame.getContentPane().add(button_Add_Owner);
		
		JButton button_Edit_Owner = new JButton("Edit");
		button_Edit_Owner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//EDIT
				int ownerId=Integer.valueOf(textField_Id.getText());
				String fname=textField_FName.getText();
				String lname=textField_LName.getText();
				String phone=textField_Phone.getText();
				String email=textField_Email.getText();
				String address=textArea_Address.getText();
				
				P_Owner owner=new P_Owner();
				
				if(fname.trim().equals("") || lname.trim().equals("") || phone.trim().equals("") || email.trim().equals("") || address.trim().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Enter Valid Inputs","Add Owner",2);
				}
				else
				{
					if(owner.editOwner(new P_Owner(ownerId,fname,lname,phone,email,address)))
					{
						JOptionPane.showMessageDialog(null, "Owner Edited","Add Owner",1);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "New Not Owner Added","Add Owner",2);
					}
				}
				
			}
		});
		button_Edit_Owner.setBounds(173, 389, 105, 29);
		button_Edit_Owner.setForeground(Color.WHITE);
		button_Edit_Owner.setFont(new Font("Tahoma", Font.BOLD, 11));
		button_Edit_Owner.setBackground(Color.ORANGE);
		frame.getContentPane().add(button_Edit_Owner);
		
		JButton button_Remove_owner = new JButton("Remove");
		button_Remove_owner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//REMOVE
				int ownerId=Integer.valueOf(textField_Id.getText());
				
				P_Owner owner=new P_Owner();
				if(textField_Id.getText().trim().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Enter Owner ID","Empty ID",2);
				}
				else
				{

					int yes_or_no = JOptionPane.showConfirmDialog(null, "Do you want to delete this owner?","Delete owner",JOptionPane.YES_NO_OPTION);
					
					if(yes_or_no ==JOptionPane.YES_OPTION)
					{
						if(owner.deleteOwner(ownerId))
						{
							JOptionPane.showMessageDialog(null, "Owner Deleted","Delete owner",1);
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Operation Failed","Delete owner",2);
						}
					}
				}
			}
		});
		button_Remove_owner.setBounds(307, 389, 103, 29);
		button_Remove_owner.setForeground(Color.WHITE);
		button_Remove_owner.setFont(new Font("Tahoma", Font.BOLD, 11));
		button_Remove_owner.setBackground(Color.RED);
		frame.getContentPane().add(button_Remove_owner);
		
		JButton button_Refresh_Owner = new JButton("Refresh");
		button_Refresh_Owner.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fillTableData();
			}
		});
		button_Refresh_Owner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fillTableData();
			}
		});
		button_Refresh_Owner.setBounds(447, 389, 271, 29);
		button_Refresh_Owner.setForeground(Color.WHITE);
		button_Refresh_Owner.setFont(new Font("Tahoma", Font.BOLD, 11));
		button_Refresh_Owner.setBackground(Color.BLUE);
		frame.getContentPane().add(button_Refresh_Owner);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(20, 173, 90, 29);
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 15));
		frame.getContentPane().add(lblLastName);
		
		textField_LName = new JTextField();
		textField_LName.setBounds(137, 176, 251, 22);
		textField_LName.setScrollOffset(20);
		textField_LName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_LName.setColumns(10);
		frame.getContentPane().add(textField_LName);
		
		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setBounds(53, 213, 64, 29);
		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 15));
		frame.getContentPane().add(lblPhone);
		
		textField_Phone = new JTextField();
		textField_Phone.setBounds(137, 216, 251, 22);
		textField_Phone.setScrollOffset(20);
		textField_Phone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_Phone.setColumns(10);
		frame.getContentPane().add(textField_Phone);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(60, 253, 57, 29);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
		frame.getContentPane().add(lblEmail);
		
		textField_Email = new JTextField();
		textField_Email.setBounds(137, 256, 251, 22);
		textField_Email.setScrollOffset(20);
		textField_Email.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_Email.setColumns(10);
		frame.getContentPane().add(textField_Email);
		
		table1 = new JTable();
		table1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				int selectedRowIndex=table1.getSelectedRow();
				textField_Id.setText(table1.getValueAt(selectedRowIndex, 0).toString());
				textField_FName.setText(table1.getValueAt(selectedRowIndex, 1).toString());
				textField_LName.setText(table1.getValueAt(selectedRowIndex, 2).toString());
				textField_Phone.setText(table1.getValueAt(selectedRowIndex, 3).toString());
				textField_Email.setText(table1.getValueAt(selectedRowIndex, 4).toString());
				textArea_Address.setText(table1.getValueAt(selectedRowIndex, 5).toString());
				
			}
		});
		table1.setBounds(425, 81, 334, 297);
		frame.getContentPane().add(table1);
		
		JButton btnOwnerProperty = new JButton("Owner Property");
		btnOwnerProperty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				try
				{

					int selectedRowIndex=table1.getSelectedRow();
					int id = Integer.valueOf(table1.getValueAt(selectedRowIndex, 0).toString());
					

					Owner_Properties_Form ownerPropertyform= new Owner_Properties_Form(id);
					
					ownerPropertyform.setVisible(true);
					ownerPropertyform.pack();
					ownerPropertyform.setLocationRelativeTo(null);
					ownerPropertyform.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Select owner from table first","No Owner Selected",2);
				}
				
				
				
			}
		});
		btnOwnerProperty.setForeground(Color.WHITE);
		btnOwnerProperty.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnOwnerProperty.setBackground(new Color(255, 255, 0));
		btnOwnerProperty.setBounds(38, 429, 240, 29);
		frame.getContentPane().add(btnOwnerProperty);
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
