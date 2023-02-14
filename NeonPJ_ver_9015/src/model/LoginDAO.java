package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;

import model.rec.LoginVO;


public class LoginDAO extends JFrame {

	private Connection conn;
	private String url = "jdbc:oracle:thin:@34.215.33.142:1521:kibwa";
	private String id = "neon";
	private String pw = "pass";
	Statement stmt = null;
	PreparedStatement ps = null;
	String driver = "oracle.jdbc.driver.OracleDriver";

	public LoginDAO() throws Exception {
		connectDB();
	}

	void connectDB() throws Exception {
		Class.forName(driver);
		conn = DriverManager.getConnection(url, id, pw);
	}

	public String memberLogin(LoginVO vo) throws SQLException {
		String id = vo.getMemberid();
		String pw = vo.getMemberpw();
		int membertypeno = vo.getMembertypeno();

		String sql = "select memberid, memberpw, membertypeno from " + "member where memberid = '" + id
				+ "' and memberpw = '" + pw + "' and membertypeno =" + membertypeno;
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		
		
		if (rs.next()) {
			String db_id = rs.getString("memberid");
			System.out.println(db_id);
			if ((id.equals(db_id)) && (pw.equals(rs.getString("memberpw")))
					&& (membertypeno == rs.getInt("membertypeno"))) {
				rs.close();
				stmt.close();
				return db_id;
			}
		}
		rs.close();
		stmt.close();
		return null;
	}

}
