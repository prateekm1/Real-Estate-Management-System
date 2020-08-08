import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Property_Image_Slider {

	private JFrame frame;
	static int propertyId;

	//image list
	
	ArrayList<byte[]> imageList;
	
	//image index
	int index ;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Property_Image_Slider window = new Property_Image_Slider(propertyId);
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
	public Property_Image_Slider(int pId) {
		initialize();
		
		
		this.propertyId = pId;
		
		//getting image
		HashMap<byte[], Integer> map = new P_PROPERTY().propertyImagesList(propertyId);
		imageList = new ArrayList<>(map.keySet());
	//	System.out.println(imageList);
		displyaImage(index);
	}

	//function to display images
	public void displyaImage(int imageIndex)
	{
		JLabel label_image = new JLabel("");
		Image img= new ImageIcon(imageList.get(imageIndex)).getImage();
		
		ImageIcon image= new ImageIcon(img);
		label_image.setIcon(image);
		//System.out.println(image);
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 815, 495);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 799, 457);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label_image = new JLabel("");
		label_image.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		label_image.setBounds(46, 36, 704, 305);
		label_image.setOpaque(true);
		label_image.setBackground(new Color(192, 192, 192));
		panel.add(label_image);
		//displyaImage(index);
		
		
		
		JLabel lblNewLabel = new JLabel("         >");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				//show next image
				index++;
				if(index>=imageList.size()) index=imageList.size()-1;
				displyaImage(index);
			}
		});
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 255, 0)));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(626, 352, 124, 51);
		panel.add(lblNewLabel);
		
		JLabel label_Previous = new JLabel("        <");
		label_Previous.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// show the previous image
				index--;
				if(index<0) index=0;
				displyaImage(index);
			}
		});
		label_Previous.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_Previous.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 255, 0)));
		label_Previous.setOpaque(true);
		label_Previous.setBackground(new Color(255, 255, 255));
		label_Previous.setFont(new Font("Tahoma", Font.BOLD, 22));
		label_Previous.setBounds(10, 352, 124, 51);
		panel.add(label_Previous);
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
