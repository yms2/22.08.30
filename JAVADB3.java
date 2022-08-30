package projectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class JAVADB3 {

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
			Scanner in = new Scanner(System.in);
			System.out.println("이름 입력:");
			String name= in.nextLine();
			System.out.println("전화 번호입력");
			String tel=in.nextLine();
			System.out.println("주소입력:");
			String address = in.nextLine();
			String SQL = "INSERT INTO useratable (userName,UserTell,userAddress) VALUES(?,?,?)";
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, name);
			pstmt.setString(2, tel);
			pstmt.setString(3, address);
			int result = pstmt.executeUpdate();
			System.out.println("결과:"+result);
			
			String SQL1= " SELECT * FROM useratable";
			pstmt = conn.prepareStatement(SQL1);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
