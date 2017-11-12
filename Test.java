package dbcp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbcp.BasicDataSource;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BasicDataSource bds = new BasicDataSource();
		bds.setUrl("");
		bds.setDriverClassName("");
		bds.setUsername("");
		bds.setPassword("");
		
		Connection conn = null;
		Statement sta = null;
		ResultSet rs = null;
		
		try {
			
			conn = bds.getConnection();
			
			sta = conn.createStatement();
			
			rs = sta.executeQuery("select * from product where id = 1");
			
			while(rs.next()){
				
				System.out.println(rs.getString("productName"));
				System.out.println(rs.getInt("Inventory"));
				
				
			}
		
		
/*			conn.setAutoCommit(false);
			conn.commit();*/
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
			if(conn != null){
				conn.close();
			}
			
			if(sta != null){
				sta.close();
			}
			if(rs != null){
				rs.close();
			}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		
		
		}
		
	}


