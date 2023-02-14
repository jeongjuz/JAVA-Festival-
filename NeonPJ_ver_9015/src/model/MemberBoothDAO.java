package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JTable;

import model.rec.MemberBoothVO;

public class MemberBoothDAO {

	// ###########################################################
	// DB control method
	Connection con;
	private String url = "jdbc:oracle:thin:@34.215.33.142:1521:kibwa";
	private String user = "neon";
	private String pass = "pass";
	private String driver = "oracle.jdbc.driver.OracleDriver";
	Statement stmt = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public MemberBoothDAO() throws Exception {
		connectDB();
	}

	void connectDB() throws Exception {

		Class.forName(driver);
		con = DriverManager.getConnection(url, user, pass);

	}

	public ArrayList boothlist(int festivalNo) throws Exception {
		// =========================================
		/*
		 * 1. sql 작성하기 ( select 문 작성 : 조건 지정하여 ) # SELECT videoNum, videoJanre,
		 * videoTitle, videoDirector, videoActor, videoRegDate FROM videoTab WHERE key값
		 * like '%word값%'
		 * 
		 * 2. sql 전송객체 얻어오기 ( Statement여야함 ) 3. sql 전송 ( executeQuery() 이용 ) ( 결과 받아 *
		 * Vector 에 지정 ) 4. 닫기 ( Connection은 닫으면 안됨 )
		 */
		ArrayList list = new ArrayList();

		// festival

		String sql = "select boothno,boothname,boothlocation,boothstart,boothend,boothcontent from booth where festivalno="
				+ festivalNo;

		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getString("boothno"));
			temp.add(rs.getString("boothname"));
			temp.add(rs.getString("boothlocation"));
			temp.add(rs.getString("boothstart"));
			temp.add(rs.getString("boothend"));
			temp.add(rs.getString("boothcontent"));
			list.add(temp);
		}
		rs.close();
		stmt.close();
		return list;
	}

	public MemberBoothVO boothmodel(int boothNo) throws Exception {

		MemberBoothVO vo = new MemberBoothVO();
		String sql = "SELECT boothno, boothname, boothlocation, boothstart, boothend, boothcontent from booth WHERE boothno = "
				+ boothNo;
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		if (rs.next()) {

			vo.setName(rs.getString("boothname"));
			vo.setPlace(rs.getString("boothlocation"));
			vo.setStarttime(rs.getString("boothstart"));
			vo.setEndtime(rs.getString("boothend"));
			vo.setContent(rs.getString("boothcontent"));

		}
		rs.close();
		stmt.close();
		return vo;
	}

	public void boothDelete(int boothNo) throws Exception {
		String sql = "delete booth where boothno =" + boothNo;
		ps = con.prepareStatement(sql);

		ps.setInt(1, boothNo);

		ps.executeUpdate();
		ps.close();

	}

	public MemberBoothVO findByNum(int bnum, int festivalno) throws Exception {

		MemberBoothVO vo = new MemberBoothVO();
		stmt = con.createStatement();
		String sql = "select boothno,boothname,boothlocation,boothstart,boothend,boothcontent from booth where festivalno="
				+ festivalno + "and boothno = " + bnum;
		ResultSet rs = stmt.executeQuery(sql);

		if (rs.next()) {
			vo.setName(rs.getString("boothname"));
			vo.setPlace(rs.getString("boothlocation"));
			vo.setStarttime(rs.getString("boothstart"));
			vo.setEndtime(rs.getString("boothend"));
			vo.setContent(rs.getString("boothcontent"));

		}
		rs.close();
		stmt.close();

		return vo;

	}

	public ArrayList bthsearch(int festivalNo, int sel, String text) throws Exception {

		String[] selCol = { "BOOTHNAME", "BOOTHLOCATION", "BOOTHSTART", "BOOTHEND", "boothcontent" };
		// boothno,boothname,boothlocation,boothstart,boothend,boothcontent
		String sql = "select boothno,boothname,boothlocation,boothstart,boothend,boothcontent from booth where festivalno= "
				+ festivalNo + " and "+ selCol[sel] + " like '%" + text + "%'";
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		ArrayList list = new ArrayList();

		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getInt("boothno"));
			temp.add(rs.getString("boothname"));
			temp.add(rs.getString("boothlocation"));
			temp.add(rs.getString("boothstart"));
			temp.add(rs.getString("boothend"));
			temp.add(rs.getString("boothcontent"));
			list.add(temp);

		}
		rs.close();
		stmt.close();

		return list;
	}

}