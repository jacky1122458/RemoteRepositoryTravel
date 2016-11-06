package cht.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cht.model.Hotel;
import cht.model.misc.SQLUtil;

public class HotelDAOJdbc {
	private static final String URL = "jdbc:sqlserver://localhost:1433;database=gking";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "P@ssw0rd";
	
	
	private static final String SELECT_BY_ID = "SELECT * FROM hotel WHERE hotelid=?";
	private static final String SELECT_BY_NAME = "SELECT * FROM hotel WHERE hotelname LIKE ?";
//	private static final String SELECT_BY_ADDRESS = "SELECT * FROM hotel WHERE address LIKE ?";
	private static final String SELECT_ALL = "SELECT * FROM hotel";
	
	private static final String SELECT_BY_NAME_FORROOM = 
			"SELECT distinct h.* FROM hotel h JOIN room r ON h.hotelid = r.hotelid  WHERE h.status=1 and peoplenum >=? and number>=? and hotelname LIKE ?";
	
	private static final String SELECT_BY_ADDRESS_FORROOM = 
			"SELECT distinct h.* FROM hotel h JOIN room r ON h.hotelid = r.hotelid  WHERE h.status=1 and peoplenum >=? and number>=? and address LIKE ?";
	
	private static final String SELECT_BY_NAME_TYPEID = 
			"SELECT distinct h.* FROM hotel h JOIN room r ON h.hotelid = r.hotelid  WHERE h.status=1 and peoplenum >=? and number>=? and typeid=? and hotelname LIKE ?";
	
	private static final String SELECT_BY_ADDRESS_TYPEID = 
			"SELECT distinct h.* FROM hotel h JOIN room r ON h.hotelid = r.hotelid  WHERE h.status=1 and peoplenum >=? and number>=? and typeid=? and address LIKE ?"; 

	private static final String INSERT = 
			"INSERT INTO hotel (typeid, hotelname, class_level, phone, check_in, check_out, years, price_bed, address, lng, lat, language, note, tol_avg, total_comment, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String UPDATE = 
			"UPDATE hotel SET typeid=?, hotelname=?, class_level=?, phone=?, check_in=?, check_out=?, years=?, price_bed=?, address=?, lng=?, lat=?, note=?, language=?, tol_avg=?, total_comment=?, status=? WHERE hotelid=?";
	private static final String DELETE = "DELETE FROM hotel WHERE hotelid=?";
	
	
	public Hotel selectById(int hotelid){
		Hotel result = null;
		ResultSet rset =null;
		try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID);){
			stmt.setInt(1, hotelid);
			rset = stmt.executeQuery();
			if(rset.next()){
				result = setBean(rset);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			if (rset!=null) {
				try {
					rset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}
		}
		return result;
	}
	
	public List<Hotel> selectByName(String hotelname){
		List<Hotel> result = null;
		ResultSet rset =null;
		try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			PreparedStatement stmt = conn.prepareStatement(SELECT_BY_NAME);){
			stmt.setString(1, "%"+hotelname+"%");
			rset = stmt.executeQuery();
			result = new ArrayList<Hotel>();
			while(rset.next()){
				Hotel bean = new Hotel();
				bean = setBean(rset);
				
				result.add(bean);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			if (rset!=null) {
				try {
					rset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}
		}
		return result;
	}
	
	public List<Hotel> selectByName(String hotelname,int peoplenum, int number){
		List<Hotel> result = null;
		ResultSet rset =null;
		try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			PreparedStatement stmt = conn.prepareStatement(SELECT_BY_NAME_FORROOM);){
			stmt.setInt(1, peoplenum);
			stmt.setInt(2, number);
			stmt.setString(3, "%"+hotelname+"%");
			rset = stmt.executeQuery();
			result = new ArrayList<Hotel>();
			while(rset.next()){
				Hotel bean = new Hotel();
				bean = setBean(rset);
				
				result.add(bean);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			if (rset!=null) {
				try {
					rset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}
		}
		return result;
	}
	
	public List<Hotel> selectByAddress(String address,int peoplenum, int number){
		List<Hotel> result = null;
		ResultSet rset =null;
		try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ADDRESS_FORROOM);){
			stmt.setInt(1, peoplenum);
			stmt.setInt(2, number);
			stmt.setString(3, "%"+address+"%");
			rset = stmt.executeQuery();
			result = new ArrayList<Hotel>();
			while(rset.next()){
				Hotel bean = new Hotel();
				bean = setBean(rset);
				
				result.add(bean);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			if (rset!=null) {
				try {
					rset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}
		}
		return result;
	}
	
	public List<Hotel> selectByNameType(String hotelname,int peoplenum,int number,int typeid){
		List<Hotel> result = null;
		ResultSet rset =null;
		try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			PreparedStatement stmt = conn.prepareStatement(SELECT_BY_NAME_TYPEID);){
			stmt.setInt(1, peoplenum);
			stmt.setInt(2, number);
			stmt.setInt(3, typeid);
			stmt.setString(4, "%"+hotelname+"%");
			rset = stmt.executeQuery();
			result = new ArrayList<Hotel>();
			while(rset.next()){
				Hotel bean = new Hotel();
				bean = setBean(rset);
				result.add(bean);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			if (rset!=null) {
				try {
					rset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}
		}
		return result;
	}
	
	public List<Hotel> selectByAddressType(String address,int peoplenum,int number,int typeid){
		List<Hotel> result = null;
		ResultSet rset =null;
		try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ADDRESS_TYPEID);){
			stmt.setInt(1, peoplenum);
			stmt.setInt(2, number);
			stmt.setInt(3, typeid);
			stmt.setString(4, "%"+address+"%");
			rset = stmt.executeQuery();
			result = new ArrayList<Hotel>();
			while(rset.next()){
				Hotel bean = new Hotel();
				bean = setBean(rset);
				
				result.add(bean);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			if (rset!=null) {
				try {
					rset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}
		}
		return result;
	}
	
	public List<Hotel> selectByName_Service(String hotelname,int peoplenum, int number,String[] service){
		List<Hotel> result = null;
		ResultSet rset =null;
		try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			PreparedStatement stmt = conn.prepareStatement(SQLUtil.getName_ServiceSql(service));){
			stmt.setInt(1, peoplenum);
			stmt.setInt(2, number);
			stmt.setString(3, "%"+hotelname+"%");
			rset = stmt.executeQuery();
			result = new ArrayList<Hotel>();
			while(rset.next()){
				Hotel bean = new Hotel();
				bean = setBean(rset);
				
				result.add(bean);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			if (rset!=null) {
				try {
					rset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}
		}
		return result;
	}
	
	public List<Hotel> selectByAddress_Service(String address,int peoplenum, int number ,String[] service){
		List<Hotel> result = null;
		ResultSet rset =null;
		try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			PreparedStatement stmt = conn.prepareStatement(SQLUtil.getAddr_ServiceSql(service));){
			stmt.setInt(1, peoplenum);
			stmt.setInt(2, number);
			stmt.setString(3, "%"+address+"%");
			rset = stmt.executeQuery();
			result = new ArrayList<Hotel>();
			while(rset.next()){
				Hotel bean = new Hotel();
				bean = setBean(rset);
				
				result.add(bean);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			if (rset!=null) {
				try {
					rset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}
		}
		return result;
	}
	
	public List<Hotel> selectByNameType_Service(String hotelname,int peoplenum,int number,int typeid,String[] service){
		List<Hotel> result = null;
		ResultSet rset =null;

		try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			PreparedStatement stmt = conn.prepareStatement(SQLUtil.getNameType_ServiceSql(service));){
			stmt.setInt(1, peoplenum);
			stmt.setInt(2, number);
			stmt.setInt(3, typeid);
			stmt.setString(4, "%"+hotelname+"%");

			rset = stmt.executeQuery();
			result = new ArrayList<Hotel>();
			while(rset.next()){
				Hotel bean = new Hotel();
				bean = setBean(rset);
				result.add(bean);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			if (rset!=null) {
				try {
					rset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}
		}
		return result;
	}
	
	public List<Hotel> selectByAddressType_Service(String address,int peoplenum,int number,int typeid,String[] service){
		List<Hotel> result = null;
		ResultSet rset =null;
		try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			PreparedStatement stmt = conn.prepareStatement(SQLUtil.getAddrType_ServiceSql(service));){
			stmt.setInt(1, peoplenum);
			stmt.setInt(2, number);
			stmt.setInt(3, typeid);
			stmt.setString(4, "%"+address+"%");
			rset = stmt.executeQuery();
			result = new ArrayList<Hotel>();
			while(rset.next()){
				Hotel bean = new Hotel();
				bean = setBean(rset);
				
				result.add(bean);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			if (rset!=null) {
				try {
					rset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}
		}
		return result;
	}
	
	public List<Hotel> select() {
		List<Hotel> result = null;
		
		try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			PreparedStatement stmt = conn.prepareStatement(SELECT_ALL);
			ResultSet rset = stmt.executeQuery();) {
			result = new ArrayList<Hotel>();
			while(rset.next()) {
				Hotel bean = new Hotel();
				bean = setBean(rset);
				
				result.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public Hotel insert(Hotel bean){
		Hotel result = null;
		ResultSet rset = null;
		if(bean!=null){
			try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(INSERT,Statement.RETURN_GENERATED_KEYS);) {
				stmt.setInt(1, bean.getTypeid());
				stmt.setString(2, bean.getHotelname());
				stmt.setInt(3, bean.getClass_level());
				stmt.setString(4, bean.getPhone());
				stmt.setString(5, bean.getCheck_in());
				stmt.setString(6, bean.getCheck_out());
				stmt.setInt(7, bean.getYears());
				stmt.setInt(8, bean.getPrice_bed());
				stmt.setString(9, bean.getAddress());
				stmt.setDouble(10, bean.getLng());
				stmt.setDouble(11, bean.getLat());
				stmt.setString(12, bean.getLanguage());
				stmt.setString(13, bean.getNote());
				stmt.setDouble(14, bean.getTol_avg());
				stmt.setInt(15, bean.getTotal_comment());
				stmt.setBoolean(16, bean.isStatus());
				
				int i =stmt.executeUpdate();
				if(i==1){
					rset =stmt.getGeneratedKeys();
					if(rset.next()){
						bean.setHotelid(rset.getInt(1));
						result = bean;
					}
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public Hotel update(int typeid, String hotelname, int class_level, String phone, String check_in, String check_out, int years, int price_bed, String address, double lng, double lat, String language, String note, double tol_avg, int total_comment, boolean status, int hotelid) {
		Hotel result = null;
		try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			PreparedStatement stmt = conn.prepareStatement(UPDATE);) {
				
			stmt.setInt(1, typeid);
			stmt.setString(2, hotelname);
			stmt.setInt(3, class_level);
			stmt.setString(4, phone);
			stmt.setString(5, check_in);
			stmt.setString(6, check_out);
			stmt.setInt(7, years);
			stmt.setInt(8, price_bed);
			stmt.setString(9, address);
			stmt.setDouble(10, lng);
			stmt.setDouble(11, lat);
			stmt.setString(12, note);
			stmt.setString(13, language);
			stmt.setDouble(14, tol_avg);
			stmt.setInt(15, total_comment);
			stmt.setBoolean(16, status);
			stmt.setInt(17, hotelid);
			
			int i = stmt.executeUpdate();
			if(i==1) {
				result = this.selectById(hotelid);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public boolean delete(int hotelid) {
		try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			PreparedStatement stmt = conn.prepareStatement(DELETE);) {
			
			stmt.setInt(1, hotelid);
			int i = stmt.executeUpdate();
			if(i==1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Hotel setBean(ResultSet rset) throws SQLException{
		Hotel bean = new Hotel();
		bean.setHotelid(rset.getInt("hotelid"));
		bean.setTypeid(rset.getInt("typeid"));
		bean.setHotelname(rset.getString("hotelname"));
		bean.setClass_level(rset.getInt("class_level"));
		bean.setPhone(rset.getString("phone"));
		bean.setCheck_in(rset.getString("check_in"));
		bean.setCheck_out(rset.getString("check_out"));
		bean.setYears(rset.getInt("years"));
		bean.setPrice_bed(rset.getInt("price_bed"));
		bean.setAddress(rset.getString("address"));
		bean.setLng(rset.getDouble("lng"));
		bean.setLat(rset.getDouble("lat"));
		bean.setLanguage(rset.getString("language"));
		bean.setNote(rset.getString("note"));
		bean.setTol_avg(rset.getDouble("tol_avg"));
		bean.setTotal_comment(rset.getInt("total_comment"));
		bean.setStatus(rset.getBoolean("status"));
		return bean;
	}
}

