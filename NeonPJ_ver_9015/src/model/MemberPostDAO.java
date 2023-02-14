package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.rec.MemberPostVO;

public class MemberPostDAO {

	Connection conn;
	String jdbc_url = "jdbc:oracle:thin:@34.215.33.142:1521:kibwa";
	String db_id = "neon";
	String db_pwd = "pass";
	Statement stmt = null;
	PreparedStatement ps = null;
	String driver = "oracle.jdbc.driver.OracleDriver";
	int festNo;

	void connectDB() throws Exception {
		/*
		 * 1. 드라이버를 드라이버메니저에 등록 2. 연결 객체 얻어오기
		 */
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(jdbc_url, db_id, db_pwd);
		System.out.println("성공적으로 로딩되었음");

	}

	public MemberPostDAO(int festNo) throws Exception {
		connectDB();
		this.festNo = festNo;
	}

	public ArrayList postList() throws Exception {
		ArrayList list = new ArrayList();
		String sql = "select postno, posttitle, postcontent, posttime, "
				+ "(select membername from member where memberno = post.memberno) membername, "
				+ "(select memberid from member where memberno = post.memberno) memberid "
				+ "from post "
				+ "where festivalno = ? "
				+ "order by postno desc";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, this.festNo);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getInt("postno"));
			temp.add(rs.getString("posttitle"));
			temp.add(rs.getString("postcontent"));
			temp.add(rs.getString("posttime"));
			temp.add(rs.getString("membername"));
			temp.add(rs.getString("memberid"));
			list.add(temp);
		}
		rs.close();
		ps.close();
		return list;
	}

	public MemberPostVO selectPostByPostNo(int postNo) throws Exception {
		MemberPostVO vo = new MemberPostVO();
		String sql = "select "
				+ "postno,"
				+ "memberno,"
				+ "(select membername from member where memberno = p.memberno) membername,"
				+ "(select memberid from member where memberno = p.memberno) memberid,"
				+ "posttitle,"
				+ "postcontent,"
				+ "posttime "
				+ "from post p "
				+ "where postno = ?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, postNo);
		
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			vo.setPostNo(postNo);
			vo.setPostTitle(rs.getString("posttitle"));
			vo.setPostContent(rs.getString("postcontent"));
			vo.setMemberNo(rs.getInt("memberno"));
			vo.setMemberName(rs.getString("membername"));
			vo.setMemberId(rs.getString("memberid"));
			vo.setPostDate(rs.getString("posttime"));
		}
		
		// TODO Auto-generated method stub
		return vo;
	}

	public void registPost(MemberPostVO vo) throws Exception {
		// TODO Auto-generated method stub
		String sql = "insert into post "
				+ "(postno, memberno, posttitle, postcontent, posttime, festivalno) "
				+ "values "
				+ "(post_seq.nextval, "
				+ "(select memberno from member where memberid = ?), "
				+ "?, ?, sysdate, ?)";
		ps = conn.prepareStatement(sql);
		ps.setString(1, vo.getMemberId());
		ps.setString(2, vo.getPostTitle());
		ps.setString(3, vo.getPostContent());
		ps.setInt(4, this.festNo);
		ps.executeUpdate();
		ps.close();
	}

	public void updatePost(MemberPostVO vo) throws SQLException {
		String sql = "UPDATE POST SET "
				+ "POSTTITLE = ?,"
				+ "POSTCONTENT = ?,"
				+ "POSTTIME = SYSDATE "
				+ "WHERE POSTNO = ?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, vo.getPostTitle());
		ps.setString(2, vo.getPostContent());
		ps.setInt(3, vo.getPostNo());
		ps.executeUpdate();
		ps.close();
	}

	public void deletePost(int postNo) throws SQLException {
		String sql = "DELETE FROM POST WHERE POSTNO = ?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, postNo);
		ps.executeUpdate();
		ps.close();
		
	}

}
