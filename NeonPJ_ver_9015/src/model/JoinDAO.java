package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import model.rec.JoinVO;

public class JoinDAO extends JFrame {


	private Connection conn;
	private String url = "jdbc:oracle:thin:@34.215.33.142:1521:kibwa";
	private String id = "neon";
	private String pw = "pass";
	Statement stmt = null;
	PreparedStatement ps = null;
	String driver = "oracle.jdbc.driver.OracleDriver";

	public JoinDAO() throws Exception {
		connectDB();
	}
	
	void connectDB() throws Exception {
		Class.forName(driver);
		conn = DriverManager.getConnection(url, id, pw);
	}

	public void regist(JoinVO vo) throws Exception {

		String sex = vo.getMembersex();
		int membertypeno = vo.getMembertypeno();
		String name = vo.getName();
		String id = vo.getId();
		String pw = vo.getPw();
		String birth = vo.getBirth();
		String phonenumber = vo.getPhonenumber();

		String sql = "insert into "
				+ "member(memberno, membername, memberid,memberpw, memberbirth, MEMBERPHONE,membersex, membertypeno)"
				+ "values(mem_seq.NEXTVAL,?,?,?,?,?,?,?)";

		ps = conn.prepareStatement(sql);
		ps.setString(1, name);
		ps.setString(2, id);
		ps.setString(3, pw);
		ps.setString(4, birth);
		ps.setString(5, phonenumber);
		ps.setString(6, sex);
		ps.setInt(7, membertypeno);

		ps.executeUpdate();
		ps.close();
	}

}
