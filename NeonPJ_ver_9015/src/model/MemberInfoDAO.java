package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import model.rec.MemberInfoVO;

public class MemberInfoDAO {

	// ###########################################################
	// DB control method
	Connection con;
	private String jdbc_url = "jdbc:oracle:thin:@34.215.33.142:1521:kibwa";
	private String db_id = "neon";
	private String db_pwd = "pass";
	Statement stmt = null;
	PreparedStatement ps = null; // 자동커밋
	String driver = "oracle.jdbc.driver.OracleDriver";

	void connectDB() throws Exception {
		/*
		 * 1. 드라이버를 드라이버메니저에 등록 2. 연결 객체 얻어오기
		 */

		Class.forName(driver);
		con = DriverManager.getConnection(jdbc_url, db_id, db_pwd);
	}

	public MemberInfoDAO() throws Exception {
		connectDB();
	}

	public MemberInfoVO MemberSearch(String id) throws Exception {

		String sql = "SELECT MEMBERNAME,MEMBERBIRTH, MEMBERID, MEMBERPW, MEMBERPHONE" + " FROM MEMBER WHERE MEMBERID = '"
				+ id + "'";
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		MemberInfoVO vo = null;
		if (rs.next()) {
			String name = rs.getString("MEMBERNAME");
			String pw = rs.getString("MEMBERPW");
			String birth = rs.getString("MEMBERBIRTH");
			String phone = rs.getString("MEMBERPHONE");
			vo = new MemberInfoVO(name, id, pw, birth, phone);

			rs.close();
			stmt.close();
		}

		return vo;
	}

}
