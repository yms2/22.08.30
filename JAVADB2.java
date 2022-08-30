package projectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class JAVADB2 {

	public static void main(String[] args) {

		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String dbURL="jdbc:mariadb://localhost:3306/user";
		String dbID = "user";
		String dbPassword="123456";
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
			String SQL = "INSERT INTO useratable (userName,UserTell,userAddress) VALUES('홍길동','010-1111-1111','부1')";
			String SQL1 = " INSERT INTO useratable (userName,UserTell,userAddress) VALUES('홍길동1','010-2222-2222','부2')";
			String SQL2 = "INSERT INTO useratable (userName,UserTell,userAddress) VALUES('홍길동2','010-3333-3333','부3')";
			pstmt = conn.prepareStatement(SQL);
			int result = pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement(SQL1);
			result = pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement(SQL2);
			result = pstmt.executeUpdate();
			
//			System.out.println("겨과:"+result);
			pstmt.close();
			conn.close();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}