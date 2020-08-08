import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RealEstateApp {

	private JFrame frame;
	private JTextField txtTextfieldusename;
	private JPasswordField pwdTextfieldpassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RealEstateApp window = new RealEstateApp();
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
	public RealEstateApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 651, 451);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLabel = new JLabel("Label_Image");
		lblLabel.setOpaque(true);
		lblLabel.setBackground(Color.PINK);
		lblLabel.setForeground(Color.PINK);
		lblLabel.setBounds(10, 11, 277, 391);
		frame.getContentPane().add(lblLabel);
		
	
		
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Arial", Font.BOLD, 42));
		lblLogin.setForeground(new Color(100, 149, 237));
		lblLogin.setBounds(300, 47, 252, 55);
		frame.getContentPane().add(lblLogin);
		
		JLabel lblNewLabel = new JLabel("Label_Username_Icon");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(216, 191, 216));
		lblNewLabel.setBounds(318, 170, 38, 36);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblLablepasswordicon = new JLabel("Lable_Password_Icon");
		lblLablepasswordicon.setOpaque(true);
		lblLablepasswordicon.setBackground(new Color(216, 191, 216));
		lblLablepasswordicon.setBounds(318, 217, 38, 36);
		frame.getContentPane().add(lblLablepasswordicon);
		
		//image display
		lblLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empire.png")));
		lblNewLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user.png")));
		lblLablepasswordicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pass.png")));
		
		txtTextfieldusename = new JTextField();
		txtTextfieldusename.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if(txtTextfieldusename.getText().trim().toLowerCase().equals("username")) 
				{
					txtTextfieldusename.setText("");
					txtTextfieldusename.setForeground(Color.black);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtTextfieldusename.getText().trim().equals("")||txtTextfieldusename.getText().trim().toLowerCase().equals("username"))
				{
					txtTextfieldusename.setText("Username");
					txtTextfieldusename.setForeground(new Color(153,153,153));
				}
			}
		});
		txtTextfieldusename.setForeground(new Color(220, 220, 220));
		txtTextfieldusename.setDisabledTextColor(new Color(245, 245, 245));
		txtTextfieldusename.setText("Username");
		txtTextfieldusename.setBounds(366, 170, 245, 36);
		frame.getContentPane().add(txtTextfieldusename);
		txtTextfieldusename.setColumns(10);
		
		pwdTextfieldpassword = new JPasswordField();
		pwdTextfieldpassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
			
				String password=String.valueOf(pwdTextfieldpassword.getPassword());
				if(password.trim().toLowerCase().equals("password"))
				{
					pwdTextfieldpassword.setText("");
					pwdTextfieldpassword.setForeground(Color.black);
				}
			}
			
			@Override
			public void focusLost(FocusEvent e) {
				
				String password=String.valueOf(pwdTextfieldpassword.getPassword());
				if(password.trim().equals("")||password.trim().toLowerCase().equals("password"))
				{
					pwdTextfieldpassword.setText("Username");
					pwdTextfieldpassword.setForeground(new Color(153,153,153));
				}
				
			}
		});
		pwdTextfieldpassword.setForeground(new Color(220, 220, 220));
		pwdTextfieldpassword.setDisabledTextColor(new Color(245, 245, 245));
		pwdTextfieldpassword.setText("password");
		pwdTextfieldpassword.setBounds(366, 217, 245, 36);
		frame.getContentPane().add(pwdTextfieldpassword);
		
		JButton btnNewButton = new JButton("Log In");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
				String username=txtTextfieldusename.getText();
				String password=String.valueOf(pwdTextfieldpassword.getPassword());
				
				PreparedStatement ps;
				ResultSet rs;
				
				String selectquery="SELECT * FROM `user` WHERE `username`=? AND password =?";
				
				if(username.trim().toLowerCase().equals("username")||password.trim().toLowerCase().equals("password"))
				{
					JOptionPane.showMessageDialog(null, "Enter your Username and Password","Empty Field",2);
				}
				
				else
				{
					//JOptionPane.showMessageDialog(null, "else");
					try {
						
						ps=THE_CONNECTION.getTheConnection().prepareStatement(selectquery);
						//ps=ConnectionDB.getTheConnection().prepareStatement(selectquery);
						ps.setString(1, username);
						ps.setString(2, password);
						
						rs=ps.executeQuery();
						
						if(rs.next())
						{
							//JOptionPane.showMessageDialog(null, "Main Form");
							//MAIN FORM
							Main_App mainform= new Main_App();
							mainform.setVisible(true);
							
							mainform.pack();
							
							this.dispose();
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Invalid Username or Password",
									"Wrong Data",2);
						}
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}

			private void dispose() {
				// TODO Auto-generated method stub
				
			}
		});
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setSelected(true);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(30, 144, 255));
		btnNewButton.setBounds(318, 303, 293, 36);
		frame.getContentPane().add(btnNewButton);
	}
}
