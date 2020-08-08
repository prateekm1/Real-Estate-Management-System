import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class P_Owner {

	private int id;
	private String firstName;
	private String lastName;
	private String phone;
	private String email;
	private String address;
	public int getId() {
		return id;
	}
	public void setId(int ID) {
		this.id = ID;
	}
	public String getFName() {
		return firstName;
	}
	public void setFName(String FNAME) {
		this.firstName = FNAME;
	}
	public String getLName() {
		return lastName;
	}
	public void setLName(String LNAME) {
		this.lastName = LNAME;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String PHONE) {
		this.phone = PHONE;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String EMAIL) {
		this.email = EMAIL;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String ADDRESS) {
		this.address = ADDRESS;
	}
	
	public P_Owner() {
		
	}
	
	
	public P_Owner(int ID, String FNAME, String LNAME, String PHONE, String EMAIL, String ADDRESS) {
		
		this.id = ID;
		this.firstName = FNAME;
		this.lastName = LNAME;
		this.phone = PHONE;
		this.email = EMAIL;
		this.address = ADDRESS;
	}
	//function to add a new owner
	public boolean addNewOwner(P_Owner owner) 
	{
		PreparedStatement ps;
		
		String addQuery="INSERT INTO `property_owner`( `fname`, `lname`, `phone`, `email`, `address`) VALUES (?,?,?,?,?)";
		
		
		
		try {
			ps=THE_CONNECTION.getTheConnection().prepareStatement(addQuery);
			ps.setString(1, owner.getFName());
			ps.setString(2, owner.getLName());
			ps.setString(3, owner.getPhone());
			ps.setString(4, owner.getEmail());
			ps.setString(5, owner.getAddress());
			
			return (ps.executeUpdate()>0);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	//function to edit owner
	public boolean editOwner(P_Owner owner) {
		
		PreparedStatement ps;
		
		String editQuery="UPDATE `property_owner` SET `fname`=?,`lname`=?,`phone`=?,`email`=?,`address`=? WHERE `id`=?";
		
		
		
		try {
			ps=THE_CONNECTION.getTheConnection().prepareStatement(editQuery);
			ps.setString(1, owner.getFName());
			ps.setString(2, owner.getLName());
			ps.setString(3, owner.getPhone());
			ps.setString(4, owner.getEmail());
			ps.setString(5, owner.getAddress());
			ps.setInt(6, owner.getId());
			
			return (ps.executeUpdate()>0);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
	}
	
	//function to delete owner
	
	public boolean deleteOwner(int ownerId) {
	PreparedStatement ps;
		
		String deleteQuery="DELETE FROM `property_owner` WHERE `id`=?";
		
		
		
		try {
			ps=THE_CONNECTION.getTheConnection().prepareStatement(deleteQuery);
			
			ps.setInt(1, ownerId);
			
			return (ps.executeUpdate()>0);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	//array of owner
	public ArrayList<P_Owner> ownersList(){
		ArrayList<P_Owner> list=new ArrayList<>();
		
		Statement st;
		ResultSet rs;
		String selectQuery="SELECT * FROM `property_owner` ";
		
		try {
			st=THE_CONNECTION.getTheConnection().createStatement();
			rs= st.executeQuery(selectQuery);
			
			P_Owner owner;
			while(rs.next())
			{
			owner = new P_Owner(	rs.getInt(1),
									rs.getString(2),
									rs.getString(3),
									rs.getString(4),
									rs.getString(5),
									rs.getString(6));
			list.add(owner);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
}
