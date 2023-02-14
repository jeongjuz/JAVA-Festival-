package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.rec.MemberPostReplyVO;

public class MemberPostReplyDAO {
	
	Connection conn;
	String jdbc_url = "jdbc:oracle:thin:@34.215.33.142:1521:kibwa";
	String db_id = "neon";
	String db_pwd = "pass";
	Statement stmt = null;
	PreparedStatement ps = null;
	String driver = "oracle.jdbc.driver.OracleDriver";

	void connectDB() throws Exception {
		/*
		 * 1. 드라이버를 드라이버메니저에 등록 2. 연결 객체 얻어오기
		 */
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(jdbc_url, db_id, db_pwd);
		System.out.println("성공적으로 로딩되었음");

	}
	
	public MemberPostReplyDAO() throws Exception {
		connectDB();
	}
	
	public void registPostReply(MemberPostReplyVO vo) throws Exception {
		System.out.println(vo.getMemberId());
		System.out.println(vo.getReplyContent());
		System.out.println(vo.getPostNo());
		String sql = "INSERT INTO REPLY "
				+ "(REPLYNO, REPLYTIME, REPLYCONTENT, POSTNO, MEMBERNO) "
				+ "VALUES "
				+ "(REPLY_SEQ.nextval, sysdate, ?, ?, (select memberno from member where memberid = ?))";
		ps = conn.prepareStatement(sql);
		ps.setString(1, vo.getReplyContent());
		ps.setInt(2, vo.getPostNo());
		ps.setString(3, vo.getMemberId());
		ps.executeUpdate();
		ps.close();
		
	}

	public ArrayList postReplyList(int postNo) throws SQLException {
		ArrayList list = new ArrayList();
		String sql = "SELECT REPLYNO, REPLYCONTENT, REPLYTIME, "
				+ "(SELECT MEMBERNAME FROM MEMBER WHERE MEMBERNO = r.MEMBERNO) membername, "
				+ "(SELECT MEMBERID FROM MEMBER WHERE MEMBERNO = r.MEMBERNO) MEMBERID "
				+ "FROM REPLY r "
				+ "where postno = ?";
		
		ps = conn.prepareStatement(sql);
		ps.setInt(1, postNo);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			ArrayList temp = new ArrayList();
//			temp.add(rs.getInt("REPLYNO"));
			temp.add(rs.getString("REPLYCONTENT"));
			temp.add(rs.getString("replytime"));
			temp.add(rs.getString("membername"));
//			temp.add(rs.getString("MEMBERID"));
			list.add(temp);
		}
		rs.close();
		ps.close();
		return list;
	}

}
