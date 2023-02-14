package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.rec.MemberPerformanceVO;

public class MemberPerformanceDAO {

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

	public MemberPerformanceDAO() throws Exception {
		connectDB();
	}

	void connectDB() throws Exception {

		Class.forName(driver);
		con = DriverManager.getConnection(url, user, pass);

	}

	public ArrayList performancelist(int festivalno) throws Exception {
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

		String sql = "select "
				+ "p.performanceno,p.performancename,p.performancelocation,p.performancestart,p.performanceend,f.pfcastname,p.performancecontent "
				+ "from performance p,performancecast f "
				+ "where p.performanceno=f.performanceno "
				+ "and p.festivalno = " + festivalno;

		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getInt("performanceno"));
			temp.add(rs.getString("performancename"));
			temp.add(rs.getString("performancelocation"));
			temp.add(rs.getString("performancestart"));
			temp.add(rs.getString("performanceend"));
			temp.add(rs.getString("pfcastname"));
			temp.add(rs.getString("performancecontent"));

			list.add(temp);
		}
		rs.close();
		stmt.close();
		return list;
	}

	public MemberPerformanceVO performancemodel(int performanceNo) throws Exception {

		MemberPerformanceVO vo = new MemberPerformanceVO();
		String sql = "SELECT p.performanceno,p.performancename,p.performancelocation,p.performancestart,p.performanceend,f.pfcastname,p.performancecontent from performance p,performancecast f where p.performanceno = f.performanceno and p.performanceno="
				+ performanceNo;
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		if (rs.next()) {

			vo.setName(rs.getString("performancename"));
			vo.setPlace(rs.getString("performancelocation"));
			vo.setStarttime(rs.getString("performancestart"));
			vo.setEndtime(rs.getString("performanceend"));
			vo.setCastname(rs.getString("pfcastname"));
			vo.setContent(rs.getString("performancecontent"));

		}
		rs.close();
		stmt.close();
		return vo;
	}

	public ArrayList mpsearch(int festivalNo, int sel, String text) throws Exception {

		String[] selCol = { "PERFORMANCENAME", "PERFORMANCELOCATION", "PERFORMANCESTART", "PERFORMANCEEND",
				"PFCASTNAME", "PERFORMANCECONTENT" };
		String sql = "SELECT "
				+ "p.PERFORMANCENO,p.PERFORMANCENAME,p.PERFORMANCELOCATION,p.PERFORMANCESTART,p.PERFORMANCEEND,t.PFCASTNAME,p.PERFORMANCECONTENT "
				+ "from PERFORMANCE p, PERFORMANCECAST t "
				+ "where p.PERFORMANCENO=t.PERFORMANCENO and p.festivalno = " + festivalNo + " and " + selCol[sel] + " like '%" + text + "%'";
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		ArrayList list = new ArrayList();

		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getInt("performanceno"));
			temp.add(rs.getString("performancename"));
			temp.add(rs.getString("performancelocation"));
			temp.add(rs.getString("performancestart"));
			temp.add(rs.getString("performanceend"));
			temp.add(rs.getString("pfcastname"));
			temp.add(rs.getString("performancecontent"));
			list.add(temp);

		}
		rs.close();
		stmt.close();

		return list;
	}
}