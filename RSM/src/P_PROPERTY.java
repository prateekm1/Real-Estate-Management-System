import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class P_PROPERTY {
private int id;
private int type;
private int size;
private int ownerId;
private String price;
private String address;
private int bedrooms;
private int bathrooms;
private int age;
private boolean balcony;
private boolean pool;
private boolean backyard;
private boolean garage;
private String description;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getType() {
	return type;
}
public void setType(int type) {
	this.type = type;
}
public int getSize() {
	return size;
}
public void setSize(int size) {
	this.size = size;
}
public int getOwnerId() {
	return ownerId;
}
public void setOwnerId(int ownerId) {
	this.ownerId = ownerId;
}
public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public int getBedrooms() {
	return bedrooms;
}
public void setBedrooms(int bedrooms) {
	this.bedrooms = bedrooms;
}
public int getBathrooms() {
	return bathrooms;
}
public void setBathrooms(int bathrooms) {
	this.bathrooms = bathrooms;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public boolean isBalcony() {
	return balcony;
}
public void setBalcony(boolean balcony) {
	this.balcony = balcony;
}
public boolean isPool() {
	return pool;
}
public void setPool(boolean pool) {
	this.pool = pool;
}
public boolean isBackyard() {
	return backyard;
}
public void setBackyard(boolean backyard) {
	this.backyard = backyard;
}
public boolean isGarage() {
	return garage;
}
public void setGarage(boolean garage) {
	this.garage = garage;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}



public P_PROPERTY() {}
public P_PROPERTY(int ID, int TYPE,int SIZE, int OWNER_ID, String PRICE, String ADDRESS, int BEDROOMS, int BATHROOMS,int AGE,
		boolean BALCONY, boolean POOL,boolean BACKYARD, boolean GARAGE, String DESCRIPTION) {
	this.id=ID;
	this.type=TYPE;
	this.size=SIZE;
	this.ownerId=OWNER_ID;
	this.price=PRICE;
	this.address=ADDRESS;
	this.age=AGE;
	this.bathrooms=BATHROOMS;
	this.bedrooms=BEDROOMS;
	this.description=DESCRIPTION;
	this.balcony=BALCONY;
	this.backyard=BACKYARD;
	this.garage=GARAGE;
	this.pool=POOL;
}




@Override
public String toString() {
	return "P_PROPERTY [id=" + id + ", type=" + type + ", size=" + size + ", ownerId=" + ownerId + ", price=" + price
			+ ", address=" + address + ", bedrooms=" + bedrooms + ", bathrooms=" + bathrooms + ", age=" + age
			+ ", balcony=" + balcony + ", pool=" + pool + ", backyard=" + backyard + ", garage=" + garage
			+ ", description=" + description + "]";
}
public boolean addNewProperty(P_PROPERTY property) {
	PreparedStatement ps;
	
	String addQuery="INSERT INTO `the_property`(`type`, `square_feet`, `ownerId`, `price`, `address`, `bedrooms`, `bathrooms`, `age`, `balcony`, `pool`, `backyard`, `garage`, `description`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
	try {
		ps=THE_CONNECTION.getTheConnection().prepareStatement(addQuery);
		
		ps.setInt(1, property.getType());
		ps.setInt(2, property.getSize());
		ps.setInt(3, property.getOwnerId());
		ps.setString(4, property.getPrice());
		ps.setString(5, property.getAddress());
		ps.setInt(6, property.getBedrooms());
		ps.setInt(7, property.getBathrooms());
		ps.setInt(8, property.getAge());
		ps.setBoolean(9, property.isBalcony());
		ps.setBoolean(10, property.isPool());
		ps.setBoolean(11, property.isBackyard());
		ps.setBoolean(12, property.isGarage());
		ps.setString(13, property.getDescription());
		
		return (ps.executeUpdate()>0);
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
	
}
public boolean editProperty(P_PROPERTY property) {

PreparedStatement ps;
	
	String editQuery="UPDATE `the_property` SET `type`=?,`square_feet`=?,`ownerId`=?,`price`=?,`address`=?,`bedrooms`=?,`bathrooms`=?,`age`=?,`balcony`=?,`pool`=?,`backyard`=?,`garage`=?,`description`=? WHERE `id`=?";
	try {
		ps=THE_CONNECTION.getTheConnection().prepareStatement(editQuery);
		
		ps.setInt(1, property.getType());
		ps.setInt(2, property.getSize());
		ps.setInt(3, property.getOwnerId());
		ps.setString(4, property.getPrice());
		ps.setString(5, property.getAddress());
		ps.setInt(6, property.getBedrooms());
		ps.setInt(7, property.getBathrooms());
		ps.setInt(8, property.getAge());
		ps.setBoolean(9, property.isBalcony());
		ps.setBoolean(10, property.isPool());
		ps.setBoolean(11, property.isBackyard());
		ps.setBoolean(12, property.isGarage());
		ps.setString(13, property.getDescription());
		ps.setInt(14, property.getId());
		
		return (ps.executeUpdate()>0);
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
}
public boolean removeProperty(int propertyId) {
	PreparedStatement ps;
	
	String deleteQuery="DELETE FROM `the_property` WHERE `id`=?";
	
	
	
	try {
		ps=THE_CONNECTION.getTheConnection().prepareStatement(deleteQuery);
		
		ps.setInt(1, propertyId);
		
		return (ps.executeUpdate()>0);
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
}


public P_PROPERTY searchProperty(int propertyId) {
	PreparedStatement ps;
	ResultSet rs;
	P_PROPERTY property=null;
	String searchQuery="SELECT * FROM 'the_property' WHERE 'id'=?";
	
	try {
		
		ps=THE_CONNECTION.getTheConnection().prepareStatement(searchQuery);
		ps.setInt(1, propertyId);
		rs=ps.executeQuery();
		if(rs.next()) {
			property=new P_PROPERTY(rs.getInt("id"),
					rs.getInt("type"),
					rs.getInt("square_feet"),
					rs.getInt("ownerId"),
					rs.getString("price"),
					rs.getString("address"),
					rs.getInt("bedrooms"),
					rs.getInt("bathrooms"),
					rs.getInt("age"),
					rs.getBoolean("backyard"),
					rs.getBoolean("balcony"),
					rs.getBoolean("garage"),
					rs.getBoolean("pool"),
					rs.getString(description));				
		}
		return property;
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
    return property;
}



public ArrayList<P_PROPERTY> propertiesList(){
	
	Statement st;
	ArrayList<P_PROPERTY> list =new ArrayList<P_PROPERTY>();
	ResultSet rs;
	String selectQuery="SELECT * FROM `the_property` ";
	
	try {
		st=THE_CONNECTION.getTheConnection().createStatement();
		rs= st.executeQuery(selectQuery);
		
		P_PROPERTY property;
		while(rs.next())
		{
		property = new P_PROPERTY(rs.getInt("id"),
				rs.getInt("type"),
				rs.getInt("square_feet"),
				rs.getInt("ownerId"),
				rs.getString("price"),
				rs.getString("address"),
				rs.getInt("bedrooms"),
				rs.getInt("bathrooms"),
				rs.getInt("age"),
				rs.getBoolean("backyard"),
				rs.getBoolean("balcony"),
				rs.getBoolean("garage"),
				rs.getBoolean("pool"),
				rs.getString("description"));	
		
		list.add(property);
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return list;
}



public ArrayList<P_PROPERTY> propertiesListByType(int typeId){
	
	ArrayList<P_PROPERTY> list =new ArrayList<P_PROPERTY>();
	PreparedStatement ps;
	ResultSet rs;
	
	String selectQuery="SELECT * FROM `the_property` WHERE `type`=?";
	
	try {
		ps=THE_CONNECTION.getTheConnection().prepareStatement(selectQuery);
		ps.setInt(1, typeId);
		rs= ps.executeQuery();
		
		P_PROPERTY property;
		while(rs.next())
		{
		property = new P_PROPERTY(rs.getInt("id"),
				rs.getInt("type"),
				rs.getInt("square_feet"),
				rs.getInt("ownerId"),
				rs.getString("price"),
				rs.getString("address"),
				rs.getInt("bedrooms"),
				rs.getInt("bathrooms"),
				rs.getInt("age"),
				rs.getBoolean("backyard"),
				rs.getBoolean("balcony"),
				rs.getBoolean("garage"),
				rs.getBoolean("pool"),
				rs.getString("description"));	
		
		list.add(property);
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return list;
}


public boolean addImage(int propertyId,String the_image_path) {
	PreparedStatement ps;
	
	String addQuery="INSERT INTO `property_images` (`property_id`,`the_image`) VALUES (?,?)";
	try {
		
		
		try {
			FileInputStream propertyImage=new FileInputStream(new File(the_image_path));
			//InputStream propertyPic = new FileInputStream(new File(the_image_path));
			ps=THE_CONNECTION.getTheConnection().prepareStatement(addQuery);
			
			ps.setInt(1, propertyId);
			ps.setBinaryStream(2, propertyImage);
		//	ps.setBlob(2, propertyImage);
			
			return (ps.executeUpdate()>0);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
	
}
public HashMap<byte[] ,Integer> propertyImagesList(int propertyId){
	
	HashMap<byte[] ,Integer> list =new HashMap<byte[] ,Integer>();
	PreparedStatement ps;
	ResultSet rs;
	
	String selectQuery="SELECT * FROM `property_images` WHERE `property_id`=?";
	
	try {
		ps=THE_CONNECTION.getTheConnection().prepareStatement(selectQuery);
		ps.setInt(1, propertyId);
		
		rs= ps.executeQuery();
		
		while(rs.next())
		{
		list.put(rs.getBytes("the_image"), rs.getInt("id"));
		//System.out.println(list);
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return list;
}


public byte[] getImageId(int imageId){

	PreparedStatement ps;
	ResultSet rs;
	
	String selectQuery="SELECT 'the_image' FROM `property_images` WHERE 'property_id'=? ";
	
	try {
		ps=THE_CONNECTION.getTheConnection().prepareStatement(selectQuery);
		ps.setInt(1, imageId);
		rs= ps.executeQuery();
		
		
		if(rs.next())
		{
		return rs.getBytes("the_image");
		}
		else {
			return null;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
	
	
}



public boolean removePropertyImage(int imageId){

	PreparedStatement ps;
	ResultSet rs;
	
	String deleteQuery="DELETE FROM `property_images` WHERE 'id'=? ";
	
	try {
		ps=THE_CONNECTION.getTheConnection().prepareStatement(deleteQuery);
		ps.setInt(1, imageId);
		return (ps.executeUpdate()>0);
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
	
	
}

}
