package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.rec.FestivalBoothVO;
import model.rec.FestivalPerformanceVO;

public class FestivalPerformanceDAO {

	// ###########################################################
//  DB  control method
	Connection con;
	private String jdbc_url = "jdbc:oracle:thin:@34.215.33.142:1521:kibwa";
	private String db_id = "neon";
	private String db_pwd = "pass";
	Statement stmt = null;
	PreparedStatement ps = null; // 자동커밋
	PreparedStatement ps2 = null;
	String driver = "oracle.jdbc.driver.OracleDriver";

	void connectDB() throws Exception {
		/*
		 * 1. 드라이버를 드라이버메니저에 등록 2. 연결 객체 얻어오기
		 */

		Class.forName(driver);
		con = DriverManager.getConnection(jdbc_url, db_id, db_pwd);
	}

	public FestivalPerformanceDAO() throws Exception {
		connectDB();
	}

	public void FestivalPerformanceInsert(FestivalPerformanceVO vo,int festivalno) throws Exception {
		String performancename = vo.getPerformancename();
		String performancelocation = vo.getPerformancelocation();
		String performancestart = vo.getPerformancestart();
		String performanceend = vo.getPerformanceend();
		String performancecast = vo.getPerformancecast();
		String performancecontent = vo.getPerformancecontent();

		String sql = "INSERT INTO " + "PERFORMANCE"
				+ "(FESTIVALNO,PERFORMANCENO,PERFORMANCENAME,PERFORMANCELOCATION, PERFORMANCESTART,PERFORMANCEEND,PERFORMANCECONTENT) "
				+ "values("+festivalno+",performance_seq.nextval,?,?,?,?,?)";
		String sql2 = "INSERT INTO " + "PERFORMANCECAST(PFCASTNO,PERFORMANCENO,PFCASTNAME) "
				+ "values(performancecast_seq.nextval,performance_seq.currval,?)";

		ps = con.prepareStatement(sql);
		ps.setString(1, performancename);
		ps.setString(2, performancelocation);
		ps.setString(3, performancestart);// ps.setString(1,vo.getName());
		ps.setString(4, performanceend);// ps.setString(1,vo.getName());
		ps.setString(5, performancecontent);// ps.setString(1,vo.getName());

		ps2 = con.prepareStatement(sql2);
		ps2.setString(1, performancecast);

		ps.executeUpdate();
		ps2.executeUpdate();

		ps.close();
		ps2.close();

	}

	public ArrayList publicList(int festivalNo) throws Exception {
		ArrayList list = new ArrayList();

		String sql = "SELECT p.performanceno,p.performancename,p.performancelocation,p.performancestart,"
				+ "p.performanceend,t.pfcastname,p.performancecontent "
				+ "from performance p, performancecast t where p.performanceno=t.performanceno and p.festivalno = "+ festivalNo;
		
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getString("performanceno"));
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

	public FestivalPerformanceVO publicmodel(int performanceNo) throws Exception {

		FestivalPerformanceVO vo = new FestivalPerformanceVO();
		String sql = "SELECT p.performanceno,p.performancename,p.performancelocation,"
				+ "p.performancestart,p.performanceend,t.pfcastname,p.performancecontent "
				+ "from performance p,performancecast t where p.performanceno = t.performanceno and p.performanceno="
				+ performanceNo;
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		if (rs.next()) {
			vo.setPerformanceno(rs.getInt("performanceno"));
			vo.setPerformancename(rs.getString("performancename"));
			vo.setPerformancelocation(rs.getString("performancelocation"));
			vo.setPerformancestart(rs.getString("performancestart"));
			vo.setPerformanceend(rs.getString("performanceend"));
			vo.setPerformancecast(rs.getString("pfcastname"));
			vo.setPerformancecontent(rs.getString("performancecontent"));

		}
		rs.close();
		stmt.close();
		return vo;
	}

	public void performanceDelete(int num) throws Exception {
		String sql = "delete from performancecast where performanceno =?";

		String sql2 = "delete from performance where performanceno =?";

		ps = con.prepareStatement(sql);
		ps.setInt(1, num);

		ps2 = con.prepareStatement(sql2);
		ps2.setInt(1, num);

		ps.executeUpdate();
		ps2.executeUpdate();
		ps.close();
		ps2.close();

	}

	public ArrayList publicsearch(int sel, String text) throws Exception {

		String[] selCol = { "PERFORMANCENAME", "PERFORMANCELOCATION", "PERFORMANCESTART", "PERFORMANCEEND",
				"PFCASTNAME", "PERFORMANCECONTENT" };
		String sql = "SELECT p.PERFORMANCENO,p.PERFORMANCENAME,p.PERFORMANCELOCATION,p.PERFORMANCESTART,p.PERFORMANCEEND,t.PFCASTNAME,p.PERFORMANCECONTENT from PERFORMANCE p, PERFORMANCECAST t where p.PERFORMANCENO=t.PERFORMANCENO and "
				+ selCol[sel] + " like '%" + text + "%'";
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		ArrayList list = new ArrayList();

		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getString("performanceno"));
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