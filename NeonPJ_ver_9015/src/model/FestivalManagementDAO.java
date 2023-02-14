package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class FestivalManagementDAO {

	// ###########################################################
	// DB control method
	Connection con;
	private String jdbc_url = "jdbc:oracle:thin:@34.215.33.142:1521:kibwa";
	private String db_id = "neon";
	private String db_pwd = "pass";
	Statement stmt = null;
	PreparedStatement ps = null; // 자동커밋
	String driver = "oracle.jdbc.driver.OracleDriver";
	String loginMemberId;

	void connectDB() throws Exception {
		/*
		 * 1. 드라이버를 드라이버메니저에 등록 2. 연결 객체 얻어오기
		 */

		Class.forName(driver);
		con = DriverManager.getConnection(jdbc_url, db_id, db_pwd);
	}

	public FestivalManagementDAO(String loginMemberId) throws Exception {
		connectDB();
		this.loginMemberId = loginMemberId;
	}

	public ArrayList festivalsearchList() throws Exception {
		System.out.println(loginMemberId);
		ArrayList list = new ArrayList();

		String sql = "SELECT f.festivalno,"
				+ " (select festivaltypename FROM FESTIVALTYPE WHERE festivaltypeno = f.FESTIVALTYPENO) festivaltypename, f.FESTIVALPUBLIC, f.FESTIVALNAME,"
				+ " f.FESTIVALCONTENT, f.FESTIVALSTART, f.FESTIVALEND "
				+ " FROM FESTIVAL f, festivaljugw fjg, festivalmanager fm  where f.festivalno = fjg.festivalno "
				+ "and fjg.festivaljugwno = fm.festivaljugwno "
				+ " and fm.memberno = (select memberno from member where memberid = ?)";

		ps = con.prepareStatement(sql);
		ps.setString(1, loginMemberId);
		ResultSet rs = ps.executeQuery();

		// SELECT FESTIVALTYPENO, FESTIVALPUBLIC, FESTIVALNAME, FESTIVALCONTENT,
		// FESTIVALSTART, FESTIVALEND FROM FESTIVAL;

		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getInt("festivalno"));
			temp.add(rs.getString("festivaltypename"));
			temp.add(rs.getString("FESTIVALPUBLIC"));
			temp.add(rs.getString("FESTIVALNAME"));
			temp.add(rs.getString("FESTIVALCONTENT"));
			temp.add(rs.getString("FESTIVALSTART"));
			temp.add(rs.getString("FESTIVALEND"));
			list.add(temp);
		}
		rs.close();
		ps.close();

		return list;
	}

//	public ArrayList festivalListSearch() throws Exception {
//		ArrayList list = new ArrayList();
//		String sql = "SELECT FESTIVALTYPENO, FESTIVALPUBLIC, FESTIVALNAME, FESTIVALCONTENT, FESTIVALSTART, FESTIVALEND FROM FESTIVAL";
//		// SELECT FESTIVALTYPENO, FESTIVALPUBLIC, FESTIVALNAME, FESTIVALCONTENT,
//		// FESTIVALSTART, FESTIVALEND FROM FESTIVAL;
//		stmt = con.createStatement();
//		ResultSet rs = stmt.executeQuery(sql);
//		while (rs.next()) {
//			ArrayList temp = new ArrayList();
//			temp.add(rs.getInt("FESTIVALTYPENO"));
//			temp.add(rs.getString("FESTIVALPUBLIC"));
//			temp.add(rs.getString("FESTIVALNAME"));
//			temp.add(rs.getString("FESTIVALCONTENT"));
//			temp.add(rs.getString("FESTIVALSTART"));
//			temp.add(rs.getString("FESTIVALEND"));
//			list.add(temp);
//		}
//		rs.close();
//		stmt.close();
//
//		return list;
//	}

}
