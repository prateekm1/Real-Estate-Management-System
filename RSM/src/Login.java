

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import javax.swing.border.MatteBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {

	private JFrame frame;
	private JTextField txtUsername;
	private JPasswordField pwdPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 701, 472);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 298, 434);
		panel.setBackground(Color.PINK);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.PINK);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBounds(31, 11, 236, 412);
		panel.add(lblNewLabel);
		
		//image display
				lblNewLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empire.png")));
				
				JLabel lblLogin_1 = new JLabel("LOGIN");
				lblLogin_1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 69, 0)));
				lblLogin_1.setForeground(new Color(30, 144, 255));
				lblLogin_1.setFont(new Font("Arial Black", Font.BOLD, 49));
				lblLogin_1.setBounds(308, 11, 256, 114);
				frame.getContentPane().add(lblLogin_1);
				
				JLabel label_Username_Icon = new JLabel("");
				label_Username_Icon.setOpaque(true);
				label_Username_Icon.setBackground(new Color(255, 255, 255));
				label_Username_Icon.setBounds(332, 180, 40, 36);
				frame.getContentPane().add(label_Username_Icon);
				label_Username_Icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user.png")));
				
				JLabel label_Password_Icon = new JLabel("");
				label_Password_Icon.setOpaque(true);
				label_Password_Icon.setBackground(Color.WHITE);
				label_Password_Icon.setBounds(332, 241, 40, 43);
				frame.getContentPane().add(label_Password_Icon);
				label_Password_Icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pass.png")));
				
				txtUsername = new JTextField();
				txtUsername.addFocusListener(new FocusAdapter() {
					@Override
					public void focusGained(FocusEvent arg0) {
						
						if(txtUsername.getText().trim().toLowerCase().equals("username"))
						{
							txtUsername.setText("");
							txtUsername.setForeground(Color.BLACK);
						}
					}
					@Override
					public void focusLost(FocusEvent arg0) {
						if(txtUsername.getText().trim().equals("")|| txtUsername.getText().trim().toLowerCase().equals("username"))
						{
							txtUsername.setText("username");
							txtUsername.setForeground(new Color(153,153,153));
						}
					}
				});
				txtUsername.setForeground(new Color(169, 169, 169));
				txtUsername.setText("Username");
				txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
				txtUsername.setBounds(395, 180, 234, 36);
				frame.getContentPane().add(txtUsername);
				txtUsername.setColumns(10);
				
				pwdPassword = new JPasswordField();
				pwdPassword.addFocusListener(new FocusAdapter() {
					@Override
					public void focusGained(FocusEvent arg0) {
						String password = String.valueOf(pwdPassword.getPassword());
						if(password.trim().toLowerCase().equals("password"))
						{
							pwdPassword.setText("");
							pwdPassword.setForeground(Color.black);
						}
					}
					@Override
					public void focusLost(FocusEvent arg0) {
						String password = String.valueOf(pwdPassword.getPassword());
						if(password.trim().equals("")|| password.trim().toLowerCase().equals("password"))
						{
							pwdPassword.setText("password");
							pwdPassword.setForeground(new Color(153,153,153));
						}
					}
				});
				pwdPassword.setForeground(new Color(169, 169, 169));
				pwdPassword.setText("password");
				pwdPassword.setBounds(395, 241, 234, 36);
				frame.getContentPane().add(pwdPassword);
				
				JButton btnNewButton = new JButton("Log In");
				btnNewButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						String username= txtUsername.getText();
						String password = String.valueOf(pwdPassword.getPassword());
						
						PreparedStatement ps;
						ResultSet rs;
						
						String selectQuery ="SELECT * FROM `user` WHERE `username`=? AND `password`=?";
						
						if(username.trim().toLowerCase().equals("username")|| password.trim().toLowerCase().equals("password"))
						{
							JOptionPane.showMessageDialog(null, "Enter Username and Password","Empty Field",2);
						}
						else {
							try {
								ps = THE_CONNECTION.getTheConnection().prepareStatement(selectQuery);
								ps.setString(1, username);
								ps.setString(2, password);
								
								rs = ps.executeQuery();
								
								if(rs.next()) {
									Main_App mainform = new Main_App();
									
									mainform.setVisible(true);
									mainform.pack();
									
								}
								else
								{
									JOptionPane.showMessageDialog(null, "Invalid Username or Password","Wrong Data",2);
								}
							}
							catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				});
				btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
				btnNewButton.setForeground(new Color(255, 255, 255));
				btnNewButton.setBackground(new Color(30, 144, 255));
				btnNewButton.setBounds(354, 334, 275, 49);
				frame.getContentPane().add(btnNewButton);
				
				JLabel lblLogin = new JLabel("Login");
				lblLogin.setVerticalAlignment(SwingConstants.TOP);
				lblLogin.setForeground(new Color(30, 144, 255));
				lblLogin.setFont(new Font("Tahoma", Font.BOLD, 44));
				lblLogin.setPreferredSize(new Dimension(100, 40));
			//	contentPane.add(lblLogin);
				
				//center the form
			//	this.setLocationRelativeTo(null);
	}
}
