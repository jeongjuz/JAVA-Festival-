package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.rec.BoothRevVo;

public class BoothRevDAO {

	Connection con;
	private String url = "jdbc:oracle:thin:@34.215.33.142:1521:kibwa";
	private String user = "neon";
	private String pass = "pass";
	private String driver = "oracle.jdbc.driver.OracleDriver";
	Statement stmt = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public BoothRevDAO() throws Exception {
		connectDB();
	}

	void connectDB() throws Exception {

		Class.forName(driver);
		con = DriverManager.getConnection(url, user, pass);

	}

	public ArrayList boothRevList(int boothNo) throws SQLException {
		ArrayList list = new ArrayList();


//		String sql = "SELECT " + "(select membername " + "from member " + "where memberno = r.memberno) membername, "
//				+ "BREVHCOUNT , " + "BREVNO, " + "rownum, " + "BREVTIME  " + "FROM " + "(SELECT * FROM BOOTHREV "
//				+ "ORDER BY brevtime) r";
		
		String sql = "SELECT * FROM  "
				+ "(SELECT (select membername from member where memberno = r.memberno) membername,  "
				+ "BREVHCOUNT ,  "
				+ "BREVNO,  "
				+ "BREVTIME,  "
				+ "RANK() OVER(ORDER BY brevtime) brevorder   "
				+ "FROM BOOTHREV r  "
				+ "WHERE breventry = 'NO'  "
				+ "AND brevcancel = 'NO'  "
				+ "AND boothno = ? "
				+ "ORDER BY brevtime)";

		ps = con.prepareStatement(sql);
		ps.setInt(1, boothNo);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getString("membername"));
			temp.add(rs.getInt("BREVHCOUNT"));
			temp.add(rs.getInt("brevorder")); // 대기순서
			temp.add(rs.getInt("BREVNO")); // 대기번호
			list.add(temp);
		}
		rs.close();
		ps.close();
		return list;
	}

	public BoothRevVo boothRevDetail(int boothRevNo, int boothNo) throws SQLException {
		BoothRevVo vo = new BoothRevVo();
		
//		String sql = "SELECT " + "(select membername " + "from member " + "where memberno = r.memberno) membername, "
//				+ "BREVHCOUNT , " + "BREVNO, " + "rownum, " + "BREVTIME  " + "FROM " + "(SELECT * FROM BOOTHREV "
//				+ "ORDER BY brevtime) r where BREVNO = ?";
		
		String sql = "SELECT * FROM "
				+ "(SELECT (select membername from member where memberno = r.memberno) membername, "
				+ "BREVHCOUNT , "
				+ "BREVNO, "
				+ "BREVTIME, "
				+ "RANK() OVER(ORDER BY brevtime) brevorder  "
				+ "FROM BOOTHREV r "
				+ "WHERE breventry = 'NO' "
				+ "AND brevcancel = 'NO' "
				+ "AND boothno = ? "
				+ "ORDER BY brevtime) "
				+ "WHERE BREVNO = ?";
		
		ps = con.prepareStatement(sql);
		ps.setInt(1, boothNo);
		ps.setInt(2, boothRevNo);
		ResultSet rs = ps.executeQuery();
		
		if (rs.next()) {
			vo.setMemberName(rs.getString("membername"));
			vo.setBoothRevCount(rs.getInt("BREVHCOUNT"));
			vo.setBoothRevNo(rs.getInt("BREVNO"));
			vo.setBoothRevOrder(rs.getInt("brevorder"));
			vo.setBoothRevTime(rs.getString("BREVTIME"));
		}
		rs.close();
		ps.close();
		
		return vo;
	}

	public void enterBooth(int boothRevNo) throws SQLException {
		String sql = "update boothrev set breventry = 'YES' where brevno = ?";
		ps = con.prepareStatement(sql);
		ps.setInt(1, boothRevNo);
		ps.executeUpdate();
		ps.close();
	}

	public void cancleBoothRev(int boothRevNo) throws SQLException {
		String sql = "update boothrev set brevcancel = 'YES' where brevno = ?";
		ps = con.prepareStatement(sql);
		ps.setInt(1, boothRevNo);
		ps.executeUpdate();
		ps.close();
	}

}
