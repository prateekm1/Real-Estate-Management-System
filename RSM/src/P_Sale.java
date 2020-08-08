import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class P_Sale {

	private int id;
	private int propertyId;
	private int clientId;
	private String finalPrice;
	private String sellingDate;
	
	public P_Sale() {
		
	}

	public P_Sale(int ID, int PROPERTY_ID, int CLIENT_ID, String FINAL_PRICE) {
		
		this.id = ID;
		this.propertyId = PROPERTY_ID;
		this.clientId = CLIENT_ID;
		this.finalPrice = FINAL_PRICE;
		//this.sellingDate = SELLING_DATE;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProperty_id() {
		return propertyId;
	}

	public void setProperty_id(int property_id) {
		this.propertyId = property_id;
	}

	public int getClient_id() {
		return clientId;
	}

	public void setClient_id(int client_id) {
		this.clientId = client_id;
	}

	public String getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(String finalPrice) {
		this.finalPrice = finalPrice;
	}

//	public String getSellingDate() {
//		return sellingDate;
//	}
//
//	public void setSellingDate(String sellingDate) {
//		this.sellingDate = sellingDate;
//	}
	
	//function to add a new sale
		public boolean addNewSale(P_Sale sale) 
		{
			PreparedStatement ps;
			
			String addQuery="INSERT INTO `sale`( `property_id`, `client_id`, `final_price`) VALUES (?,?,?)";
			
			
			
			try {
				ps=THE_CONNECTION.getTheConnection().prepareStatement(addQuery);
				ps.setInt(1, sale.getProperty_id());
				ps.setInt(2, sale.getClient_id());
				ps.setString(3, sale.getFinalPrice());
				//ps.setString(4, sale.getSellingDate());
				
				
				return (ps.executeUpdate()>0);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}
		
		//function to edit sale
		public boolean editSale(P_Sale sale) {
			
			PreparedStatement ps;
			
			String editQuery="UPDATE `sale` SET `property_id`=?,`client_id`=?,`final_price`=? WHERE `id`=?";
			
			
			
			try {
				ps=THE_CONNECTION.getTheConnection().prepareStatement(editQuery);
				ps.setInt(1, sale.getProperty_id());
				ps.setInt(2, sale.getClient_id());
				ps.setString(3, sale.getFinalPrice());
				//ps.setString(4, sale.getSellingDate());
				
				
				ps.setInt(5, sale.getId());
				
				return (ps.executeUpdate()>0);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
			
			
		}
		
		//function to delete owner
		
		public boolean deleteSale(int saleId) {
		PreparedStatement ps;
			
			String deleteQuery="DELETE FROM `sale` WHERE `id`=?";
			
			
			
			try {
				ps=THE_CONNECTION.getTheConnection().prepareStatement(deleteQuery);
				
				ps.setInt(1, saleId);
				
				return (ps.executeUpdate()>0);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}
	//	array of sale
		public ArrayList<P_Sale> salesList(){
			ArrayList<P_Sale> list=new ArrayList<>();
			
			Statement st;
			ResultSet rs;
			String selectQuery="SELECT * FROM `sale` ";
			
			try {
				st=THE_CONNECTION.getTheConnection().createStatement();
				rs= st.executeQuery(selectQuery);
				
				P_Sale sale;
				while(rs.next())
				{
				sale = new P_Sale(	rs.getInt(1),
										rs.getInt(2),
										rs.getInt(3),
										rs.getString(4));
										
				list.add(sale);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return list;
		}
	
}
