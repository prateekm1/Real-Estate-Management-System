import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.Border;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;

public class Main_App {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_App window = new Main_App();
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
	public Main_App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 0, 230, 462);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 230, 84);
		panel_1.setBackground(new Color(255, 140, 0));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("AppIcon");
		lblNewLabel_1.setBackground(new Color(255, 69, 0));
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBounds(10, 11, 70, 62);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("MyAPP");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Vani", Font.BOLD, 32));
		lblNewLabel_2.setBounds(90, 11, 130, 62);
		panel_1.add(lblNewLabel_2);
		
		//logo
		lblNewLabel_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.png")));
		
		//logo order
		Border logo_border= BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK);
		lblNewLabel_1.setBorder(logo_border);
		
		//logo name border
		Border name_border= BorderFactory.createMatteBorder(0,0,3,0,Color.WHITE);
		lblNewLabel_2.setBorder(name_border);
		
		JLabel lblNewLabel_3 = new JLabel(" Property");
		lblNewLabel_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_3.setBackground(Color.GRAY);
		lblNewLabel_3.setOpaque(true);
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
				lblNewLabel_3.setBackground(Color.WHITE);
				lblNewLabel_3.setForeground(Color.GRAY);
			}
			
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				
				lblNewLabel_3.setBackground(Color.GRAY);
				lblNewLabel_3.setForeground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				PROPERTY_WINDOW propertyform= new PROPERTY_WINDOW();
				propertyform.setVisible(true);
				propertyform.pack();
				propertyform.setLocationRelativeTo(null);
				propertyform.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
			}
		});
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(10, 103, 210, 29);
		panel.add(lblNewLabel_3);
		
		JLabel lblPropertytype = new JLabel(" Property-Type");
		lblPropertytype.addMouseListener(new MouseAdapter() {
			
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
				lblPropertytype.setBackground(Color.WHITE);
				lblPropertytype.setForeground(Color.GRAY);
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				lblPropertytype.setBackground(Color.GRAY);
				lblPropertytype.setForeground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				Property_Type_Window typeform= new Property_Type_Window();
				typeform.setVisible(true);
				typeform.pack();
				typeform.setLocationRelativeTo(null);
				typeform.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
			}
		});
		lblPropertytype.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblPropertytype.setBackground(Color.GRAY);
		lblPropertytype.setOpaque(true);
		lblPropertytype.setForeground(Color.WHITE);
		lblPropertytype.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPropertytype.setBounds(10, 143, 210, 29);
		panel.add(lblPropertytype);
		
		JLabel lblPropertyimage = new JLabel(" Property-Image");
		lblPropertyimage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblPropertyimage.setBackground(Color.WHITE);
				lblPropertyimage.setForeground(Color.GRAY);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				lblPropertyimage.setBackground(Color.GRAY);
				lblPropertyimage.setForeground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				PROPERTY_IMAGES_WINDOW imageform= new PROPERTY_IMAGES_WINDOW();
				imageform.setVisible(true);
			
				imageform.pack();
				imageform.setLocationRelativeTo(null);
				imageform.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
			}
		});
		lblPropertyimage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblPropertyimage.setBackground(Color.GRAY);
		lblPropertyimage.setOpaque(true);
		lblPropertyimage.setForeground(Color.WHITE);
		lblPropertyimage.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPropertyimage.setBounds(10, 184, 210, 29);
		panel.add(lblPropertyimage);
		
		JLabel lblOwner = new JLabel(" Owner");
		lblOwner.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblOwner.setBackground(Color.WHITE);
				lblOwner.setForeground(Color.GRAY);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				lblOwner.setBackground(Color.GRAY);
				lblOwner.setForeground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
				Owner_Window ownerform= new Owner_Window();
				ownerform.setVisible(true);
			
				ownerform.pack();
				ownerform.setLocationRelativeTo(null);
				ownerform.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
			}
		});
		lblOwner.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblOwner.setBackground(Color.GRAY);
		lblOwner.setOpaque(true);
		lblOwner.setForeground(Color.WHITE);
		lblOwner.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblOwner.setBounds(10, 223, 210, 29);
		panel.add(lblOwner);
		
		JLabel lblClient = new JLabel(" Client");
		lblClient.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblClient.setBackground(Color.WHITE);
				lblClient.setForeground(Color.GRAY);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				lblClient.setBackground(Color.GRAY);
				lblClient.setForeground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				CLIENT_WINDOW clientform= new CLIENT_WINDOW();
				clientform.setVisible(true);
			
				clientform.pack();
				clientform.setLocationRelativeTo(null);
				clientform.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
			}
		});
		lblClient.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblClient.setBackground(Color.GRAY);
		lblClient.setOpaque(true);
		lblClient.setForeground(Color.WHITE);
		lblClient.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblClient.setBounds(10, 263, 210, 29);
		panel.add(lblClient);
		JLabel lblSale = new JLabel(" Sale");
		lblSale.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Sale_Window saleform= new Sale_Window();
				saleform.setVisible(true);
			
				saleform.pack();
				saleform.setLocationRelativeTo(null);
				saleform.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblSale.setBackground(Color.WHITE);
				lblSale.setForeground(Color.GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblSale.setBackground(Color.GRAY);
				lblSale.setForeground(Color.WHITE);
			}
		});
		lblSale.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblSale.setOpaque(true);
		lblSale.setForeground(Color.WHITE);
		lblSale.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSale.setBackground(Color.GRAY);
		lblSale.setBounds(10, 303, 210, 29);
		panel.add(lblSale);
		// name border
				Border property_border= BorderFactory.createMatteBorder(0,0,1,0,Color.YELLOW);
				lblNewLabel_3.setBorder(property_border);
				
				// name border
				Border propertyType_border= BorderFactory.createMatteBorder(0,0,1,0,Color.YELLOW);
				lblPropertytype.setBorder(propertyType_border);
				// name border
				Border propertyImage_border= BorderFactory.createMatteBorder(0,0,1,0,Color.YELLOW);
				lblPropertyimage.setBorder(propertyImage_border);
				// name border
				Border owner_border= BorderFactory.createMatteBorder(0,0,1,0,Color.YELLOW);
				lblOwner.setBorder(owner_border);
				// name border
				Border client_border= BorderFactory.createMatteBorder(0,0,1,0,Color.YELLOW);
				lblClient.setBorder(client_border);
				// name border
				Border sale_border= BorderFactory.createMatteBorder(0,0,1,0,Color.YELLOW);
				lblSale.setBorder(sale_border);
				
				/*
				 * 
				 * adding foreign key
				 * 1. between property_type and the_property
				 * 
				 * ALTER TABLE property_owner ADD CONSTRAINT fk_type_id FOREIGN KEY (type) REFERENCES property_type(id) on UPDATE CASCADE on DELETE CASCADE;
				 * 
				 * 2. between property_owner and the_property
				 * 
				 * ALTER TABLE property_owner ADD CONSTRAINT fk_owner_id FOREIGN KEY (OwnerId) REFERENCES property_owner(id) on UPDATE CASCADE on DELETE CASCADE;
				 * 
				 * 
				 * 3. between property_images and the_property
				 * 
				 * ALTER TABLE property_images ADD CONSTRAINT fk_property_id FOREIGN KEY (property_id) REFERENCES the_property(id) on UPDATE CASCADE on DELETE CASCADE;
				 * 
				 * 4. between sale and the_property
				 * 
				 * ALTER TABLE sale ADD CONSTRAINT fk_sale_property_id FOREIGN KEY (property_id) REFERENCES the_property(id) on UPDATE CASCADE on DELETE CASCADE;
				 * 
				 * 4. between sale and propertyClient
				 * ALTER TABLE sale ADD CONSTRAINT fk_sale_client_id FOREIGN KEY (client_id) REFERENCES property_client(id) on UPDATE CASCADE on DELETE CASCADE;
				 */
			
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		frame.setVisible(true);
	}

	public void pack() {
		// TODO Auto-generated method stub
		
	}
}
