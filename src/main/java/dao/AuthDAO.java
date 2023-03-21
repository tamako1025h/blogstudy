package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import model.User;

public class AuthDAO {
	private final static String JDBC_URL="jdbc:mysql://localhost:3306/blog?characterEncoding=UTF-8&serverTimezone=JST";
	private final static String DB_USER="root";
	private final static String DB_PASS="";
	
	/**
	 * ログインにつかうメソッド
	 * param String username
	 * param String password
	 * return User
	 */
	public User Login(String username,String password) {
		User user=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		try(Connection conn=DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			// SQL文
			String sql = "SELECT ID,USER_NAME,PASSWORD,PRIVILEGE,CREATED_AT,UPDATE_AT FROM USER WHERE USER_NAME = ? AND PASSWORD = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, username);
			pStmt.setString(2, password);
			
			// SQL文を実行
			ResultSet rs = pStmt.executeQuery();
			
			// 一致する行があった場合、Userを返す
			if (rs.next()) {
				int id = rs.getInt("ID");
				String privilege = rs.getString("PRIVILEGE");
				Date created_at = rs.getDate("CREATED_AT");
				Date update_at = rs.getDate("UPDATE_AT");
				
				user = new User(id,username,password,privilege,created_at,update_at);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return user;
	}
}
