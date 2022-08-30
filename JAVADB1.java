package projectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class JAVADB1 {

	public static void main(String[] args) {

		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt=null;
		String dbURL="jdbc:mariadb://localhost:3306/user";
		String dbID = "user";
		String dbPassword="123456";
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
			String SQL = "CREATE TABLE userATable ( "
					+ " userName VARCHAR(50), "
					+ " UserTell VARCHAR(50), "
					+ " UserAddress VARCHAR(255)  "
					+ " )";
			pstmt = conn.prepareStatement(SQL);
			int result = pstmt.executeUpdate();
			System.out.println("테이블이 생성되었습니다.");
			pstmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
