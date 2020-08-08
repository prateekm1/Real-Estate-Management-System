import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import javax.swing.JOptionPane;

public class P_Type {

	private Integer id;
	private String name;
	private String description;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer ID) {
		this.id = ID;
	}
	public String getName() {
		return name;
	}
	public void setName(String NAME) {
		this.name = NAME;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String DESCRIPTION) {
		this.description = DESCRIPTION;
	}
	
	public P_Type() {
		
	}
	public P_Type(Integer ID , String NAME, String DESCRIPTION) {
		
		this.id = ID;
		this.name = NAME;
		this.description = DESCRIPTION;
	}
	@Override
	public String toString() {
		return "P_Type [id=" + id + ", name=" + name + ", description=" + description + "]";
	}
	public boolean execTypeQuery(String queryType, P_Type type) {
		
		PreparedStatement ps;
		
		if(queryType.equals("add"))
		{
			//query== INSERT INTO `property_type`(`name`, `description`) VALUES (?,?)
			try {
				ps=THE_CONNECTION.getTheConnection().prepareStatement("INSERT INTO `property_type`(`name`, `description`) VALUES (?,?)");
			    ps.setString(1, type.getName());
			    ps.setString(2, type.getDescription());
			    
			    return (ps.executeUpdate() > 0);
			
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
			
		}
		
		else if(queryType.equals("edit"))
		{
			//query== UPDATE `property_type` SET `name`=?,`description`=? WHERE `id`=?
			try {
				ps=THE_CONNECTION.getTheConnection().prepareStatement("UPDATE `property_type` SET `name`=?,`description`=? WHERE `id`=?");
			    ps.setString(1, type.getName());
			    ps.setString(2, type.getDescription());
			    ps.setInt(3, type.getId());
			    
			    return (ps.executeUpdate() > 0);
			
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
			
		}
		
		else if(queryType.equals("remove"))
		{
			//query== DELETE FROM `property_type` WHERE `id`=?
			try {
				ps=THE_CONNECTION.getTheConnection().prepareStatement("DELETE FROM `property_type` WHERE `id`=?");
			    
			    ps.setInt(1, type.getId());
			    
			    return (ps.executeUpdate() > 0);
			
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
			
		}
		else {
			JOptionPane.showMessageDialog(null, "Enter the correct query (add,edit,remove)","Invalid Operation",2);
			return false;
		}
	}
	
	public HashMap<String,Integer> getTypeMap()
	{
		HashMap<String,Integer> map= new HashMap<>();
		Statement st;
		ResultSet rs;
		
		try {
			
			st= THE_CONNECTION.getTheConnection().createStatement();
			rs=st.executeQuery("SELECT * FROM `property_type`");
			
			P_Type type ;
			
			while(rs.next()) {
				type=new P_Type(rs.getInt(1), rs.getString(2),rs.getString(3));
				
				//System.out.println(type.toString());
				map.put(type.getName(), type.getId());
				//map.put(getName(), getId());
				//System.out.println(map.toString());
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(map.toString());
		return map;
		
	}
	
	public P_Type getTypeById(Integer id) {
		PreparedStatement ps;
		ResultSet rs;
	
		P_Type type=new P_Type();
		Integer i= type.getId();
		try {
			
			ps= THE_CONNECTION.getTheConnection().prepareStatement("SELECT * FROM `property_type` WHERE `id` =?");
			
			ps.setInt(1, id);
			
			rs=ps.executeQuery();
			
			
			if(rs.next())
			{
				type.setId(id);
				type.setName(rs.getString(2));
				type.setDescription(rs.getString(3));
				//System.out.println(type.getName());
				
			}
		
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return type;
	}
	
}
