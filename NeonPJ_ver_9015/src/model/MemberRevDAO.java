package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.rec.MemberBoothVO;
import model.rec.MemberRevVO;

public class MemberRevDAO {

	Connection con;
	private String url = "jdbc:oracle:thin:@34.215.33.142:1521:kibwa";
	private String user = "neon";
	private String pass = "pass";
	private String driver = "oracle.jdbc.driver.OracleDriver";
	Statement stmt = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public MemberRevDAO() throws Exception {
		connectDB();
	}

	void connectDB() throws Exception {

		Class.forName(driver);
		con = DriverManager.getConnection(url, user, pass);

	}
	//내 예약 리스트 출력
	//현재페이지의 축제번호와 부스테이블의 축제번호가 같은 부스번호와 예약에서 로그인한 회원의 번호가 있는 예약컬럼을 호출
	public ArrayList memberRevList(int festivalNo ,String id) throws Exception {

		ArrayList list = new ArrayList();

		// festival

		String sql = "SELECT r.BREVNO,(SELECT boothname FROM BOOTH WHERE BOOTHNO = r.boothno) boothname,(SELECT memberid from member where memberno = r.MEMBERNO) memberid, r.BREVTIME, r.BREVHCOUNT"
				+ " FROM BOOTHREV r,BOOTH b WHERE b.FESTIVALNO = "+festivalNo+
				" AND r.BOOTHNO = b.BOOTHNO "
				+ "AND r.MEMBERNO = (SELECT memberno FROM MEMBER where memberid = '"+id+"')"
						+ " AND r.BREVCANCEL = 'NO'"
						+ " AND r.BREVENTRY = 'NO'";

		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getString("BREVNO"));
			temp.add(rs.getString("boothname"));
			temp.add(rs.getString("memberid"));
			temp.add(rs.getInt("BREVHCOUNT"));
			temp.add(rs.getString("BREVTIME"));
			list.add(temp);
		}
		rs.close();
		stmt.close();
		return list;
	}
	
	public void cancleBoothRev(int boothRevNo) throws SQLException {
		String sql = "update boothrev set brevcancel = 'YES' where brevno = ?";
		ps = con.prepareStatement(sql);
		ps.setInt(1, boothRevNo);
		ps.executeUpdate();
		ps.close();
	}
	
	public MemberRevVO findByNum(int bnum, String name) throws Exception {

		MemberRevVO vo = new MemberRevVO();
		stmt = con.createStatement();
		String sql = "SELECT * FROM (SELECT BREVNO,BREVTIME,RANK()over(ORDER BY breVtime asc) waitteam, BREVHCOUNT"+
				" FROM BOOTHREV WHERE BOOTHNO = (SELECT BOOTHNO FROM BOOTH WHERE boothname = '"+name+"') AND BREVCANCEL = 'NO' AND BREVENTRY = 'NO') WHERE BREVNO = "+bnum;
		ResultSet rs = stmt.executeQuery(sql);

		if (rs.next()) {
			vo.setBoothname(name);
			vo.setCount(rs.getInt("BREVHCOUNT"));
			vo.setWaitTime(rs.getString("BREVTIME"));
			vo.setRevNo(bnum);
			vo.setWaitTeam(rs.getInt("waitteam"));
		}
		rs.close();
		stmt.close();

		return vo;

	}
	
	

	

}
