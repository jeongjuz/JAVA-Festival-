package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class BoothSelectDAO {
	
	
	
	Connection con;
	private String url = "jdbc:oracle:thin:@34.215.33.142:1521:kibwa";
	private String user ="neon";
	private String pass  ="pass";
	private String driver = "oracle.jdbc.driver.OracleDriver";
	Statement stmt = null;
	PreparedStatement ps = null; 
	ResultSet rs = null;
	String LoginMemberId;
	
	public BoothSelectDAO(String LoginMemberId) throws Exception {
		connectDB();
		this.LoginMemberId = LoginMemberId;
	}
	
	
	void connectDB() throws Exception {
	

		Class.forName(driver);
		con = DriverManager.getConnection(url, user, pass);

	}
	
	public ArrayList boothList() throws Exception {
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
		
		String sql = "SELECT "
				+ "(select festivalname "
				+ "from festival "
				+ "where festivalno = booth.festivalno) festivalname, "
				+ "bm.BOOTHNO, "
				+ "booth.BOOTHNAME , "
				+ "booth.BOOTHLOCATION , "
				+ "booth.BOOTHSTART , "
				+ "booth.BOOTHEND , "
				+ "booth.BOOTHCONTENT "
				+ "FROM BOOTHMANAGER bm, BOOTH booth "
				+ "WHERE bm.BOOTHNO = booth.BOOTHNO "
				+ "AND bm.MEMBERNO = (SELECT MEMBERNO FROM MEMBER WHERE memberid = ?)";

		ps = con.prepareStatement(sql);
		ps.setString(1, this.LoginMemberId);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getInt("BOOTHNO"));
			temp.add(rs.getString("festivalname"));
			temp.add(rs.getString("BOOTHNAME"));
			temp.add(rs.getString("BOOTHLOCATION"));
			temp.add(rs.getString("BOOTHSTART"));
			temp.add(rs.getString("BOOTHEND"));
			temp.add(rs.getString("BOOTHCONTENT"));
			list.add(temp);
		}
		
		rs.close();
		ps.close();
		return list;
	}

}
