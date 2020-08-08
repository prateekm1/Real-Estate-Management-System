import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;

public class CLIENT_WINDOW {

	private JFrame frame;
	private JTextField textField_Id;
	private JTextField textField_FName;
	private JTextField textField_LName;
	private JTextField textField_Phone;
	private JTextField textField_Email;
	private JTextField textArea_Address;
	private final Action action = new SwingAction();
	private JTable table1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CLIENT_WINDOW window = new CLIENT_WINDOW();
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
	
	
	
	
	
	
	
	
	
	
	public CLIENT_WINDOW() {
		initialize();
		fillTableData();
	}

//	public void fillJtableWithClientsData()
//	{
//		P_Client client= new P_Client();
//		ArrayList<P_Client> clientlist=client.clientsList();
//		String[] colNames= {"ID","First Name","Last Name","Phone","Email","Address"};
//		Object [] [] rows=new Object[clientlist.size()][6];
//		for(int i=0;i<clientlist.size();i++) {
//			rows[i][0]=clientlist.get(i).getId();
//			rows[i][1]=clientlist.get(i).getFName();
//			rows[i][2]=clientlist.get(i).getLName();
//			rows[i][3]=clientlist.get(i).getPhone();
//			rows[i][4]=clientlist.get(i).getEmail();
//			rows[i][5]=clientlist.get(i).getAddress();
//			
//		}
//		
//	}
	public void fillTableData()
	{
		
		P_Client client=new P_Client();
		ArrayList<P_Client> clientsList=client.clientsList();
		
		//table columns
		String[] colmNames  = {"ID","FIRST NAME","LAST NAME","PHONE","EMAIL","ADDRESS"};
		
		Object[][] rows=new Object[clientsList.size()][6];
		
		for(int i=0;i<clientsList.size();i++)
		{
			rows[i][0]=clientsList.get(i).getId();
			rows[i][1]=clientsList.get(i).getFName();
			rows[i][2]=clientsList.get(i).getLName();
			rows[i][3]=clientsList.get(i).getPhone();
			rows[i][4]=clientsList.get(i).getEmail();
			rows[i][5]=clientsList.get(i).getAddress();
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
		frame.setBounds(100, 100, 1297, 742);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 0, 1273, 705);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 5, 1253, 68);
		panel_1.setBackground(new Color(255, 165, 0));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Clients");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 29));
		lblNewLabel.setBounds(519, 10, 145, 48);
		panel_1.add(lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.ORANGE);
		panel_3.setBounds(10, 70, 1253, 625);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setBounds(88, 34, 38, 36);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 21));
		panel_3.add(lblNewLabel_1);
		
		textField_Id = new JTextField();
		textField_Id.setBounds(139, 38, 299, 36);
		panel_3.add(textField_Id);
		textField_Id.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("First Name:");
		lblNewLabel_1_1.setBounds(10, 89, 117, 36);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 21));
		panel_3.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Last Name:");
		lblNewLabel_1_1_1.setBounds(10, 135, 117, 36);
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 21));
		panel_3.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Phone:");
		lblNewLabel_1_1_2.setBounds(51, 181, 75, 36);
		lblNewLabel_1_1_2.setFont(new Font("Times New Roman", Font.BOLD, 21));
		panel_3.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("Email:");
		lblNewLabel_1_1_2_1.setBounds(51, 238, 75, 36);
		lblNewLabel_1_1_2_1.setFont(new Font("Times New Roman", Font.BOLD, 21));
		panel_3.add(lblNewLabel_1_1_2_1);
		
		JLabel lblNewLabel_1_1_2_1_1 = new JLabel("Address:");
		lblNewLabel_1_1_2_1_1.setBounds(34, 284, 92, 36);
		lblNewLabel_1_1_2_1_1.setFont(new Font("Times New Roman", Font.BOLD, 21));
		panel_3.add(lblNewLabel_1_1_2_1_1);
		
		textField_FName = new JTextField();
		textField_FName.setBounds(139, 89, 299, 36);
		textField_FName.setColumns(10);
		panel_3.add(textField_FName);
		
		textField_LName = new JTextField();
		textField_LName.setBounds(139, 135, 299, 36);
		textField_LName.setColumns(10);
		panel_3.add(textField_LName);
		
		textField_Phone = new JTextField();
		textField_Phone.setBounds(139, 185, 299, 36);
		textField_Phone.setColumns(10);
		panel_3.add(textField_Phone);
		
		textField_Email = new JTextField();
		textField_Email.setBounds(139, 238, 299, 36);
		textField_Email.setColumns(10);
		panel_3.add(textField_Email);
		
		textArea_Address = new JTextField();
		textArea_Address.setBounds(139, 284, 299, 187);
		textArea_Address.setColumns(10);
		panel_3.add(textArea_Address);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.setBounds(63, 521, 130, 36);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ADD
				String fname=textField_FName.getText();
				String lname=textField_LName.getText();
				String phone=textField_Phone.getText();
				String email=textField_Email.getText();
				String address=textArea_Address.getText();
				
				P_Client client= new P_Client();
				
				if(fname.trim().equals("") || lname.trim().equals("") || phone.trim().equals("") || email.trim().equals("") || address.trim().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Enter Valid Inputs","Add Owner",2);
				}
				else
				{
					if(client.addNewClient(new P_Client(0,fname,lname,phone,email,address)))
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
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBackground(new Color(186, 85, 211));
		panel_3.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("EDIT");
		btnNewButton_1.setBounds(250, 521, 130, 36);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				//EDIT
				int ownerId=Integer.valueOf(textField_Id.getText());
				String fname=textField_FName.getText();
				String lname=textField_LName.getText();
				String phone=textField_Phone.getText();
				String email=textField_Email.getText();
				String address=textArea_Address.getText();
				
				P_Client client=new P_Client();
				
				if(fname.trim().equals("") || lname.trim().equals("") || phone.trim().equals("") || email.trim().equals("") || address.trim().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Enter Valid Inputs","Add Owner",2);
				}
				else
				{
					if(client.editClient(new P_Client(ownerId,fname,lname,phone,email,address)))
					{
						JOptionPane.showMessageDialog(null, "Owner Edited","Add Owner",1);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "New Not Owner Added","Add Owner",2);
					}
				}
				
			}
			}
		);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1.setBackground(new Color(255, 255, 0));
		panel_3.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("REMOVE");
		btnNewButton_1_1.setBounds(449, 521, 130, 36);
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
		
		});
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//REMOVE
				int clientId=Integer.valueOf(textField_Id.getText());
				
				P_Client client=new P_Client();
				if(textField_Id.getText().trim().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Enter Owner ID","Empty ID",2);
				}
				else
				{

					int yes_or_no = JOptionPane.showConfirmDialog(null, "Do you want to delete this owner?","Delete owner",JOptionPane.YES_NO_OPTION);
					
					if(yes_or_no ==JOptionPane.YES_OPTION)
					{
						if(client.deleteClient(clientId))
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
			}
		);
		btnNewButton_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1_1.setBackground(Color.RED);
		panel_3.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("REFRESH");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fillTableData();
			}
		});
		btnNewButton_1_2.setBounds(682, 521, 469, 36);
		btnNewButton_1_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1_2.setBackground(Color.BLUE);
		panel_3.add(btnNewButton_1_2);
		
		table1 = new JTable();
		table1.setBounds(682, 34, 469, 452);
		panel_3.add(table1);
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
			}
		);
		//panel_3.add(table1);
	}
	
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}

	public void setDefaultCloseOperation(int disposeOnClose) {
		// TODO Auto-generated method stub
		
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
}
