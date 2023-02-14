package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.rec.MemberManagementVO;

public class MemberManagementDAO {

	// ###########################################################
	// DB control method
	Connection con;
	private String url = "jdbc:oracle:thin:@34.215.33.142:1521:kibwa";
	private String user ="neon";
	private String pass  ="pass";
	private String driver = "oracle.jdbc.driver.OracleDriver";
	Statement stmt = null;
	PreparedStatement ps = null; 
	ResultSet rs = null;
	
	public MemberManagementDAO() throws Exception {
		connectDB();
	}
	
	
	void connectDB() throws Exception {
	

		Class.forName(driver);
		con = DriverManager.getConnection(url, user, pass);

	}
	
	public ArrayList festivallist() throws Exception {
		// =========================================
		/*
		 * 1. sql 작성하기 ( select 문 작성 : 조건 지정하여 ) # SELECT videoNum, videoJanre,
		 * videoTitle, videoDirector, videoActor, videoRegDate FROM videoTab WHERE key값
		 * like '%word값%'
		 * 
		 * 2. sql 전송객체 얻어오기 ( Statement여야함 ) 
		 * 3. sql 전송 ( executeQuery() 이용 ) ( 결과 받아 * Vector 에 지정 ) 4. 닫기 ( Connection은 닫으면 안됨 )
		 */
		ArrayList list = new ArrayList();
		
		//festival
		
		String sql = "SELECT f.festivalno, t.festivaltypename, f.festivalname, f.festivalstart, f.festivalend, c.festivalentercode from festival f, festivaltype t, festivalcode c  where f.festivaltypeno = t.festivaltypeno and f.festivalno=c.festivalno (+)";

		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getInt("festivalno"));
			temp.add(rs.getString("festivaltypename"));
			temp.add(rs.getString("festivalname"));
			temp.add(rs.getString("festivalstart"));
			temp.add(rs.getString("festivalend"));
			temp.add(rs.getString("festivalentercode"));
			list.add(temp);
		}
		rs.close();
		stmt.close();
		return list;
	}
}