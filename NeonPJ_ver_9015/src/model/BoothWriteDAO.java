package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.rec.BoothWriteVO;

public class BoothWriteDAO {

	Connection con;
	private String jdbc_url = "jdbc:oracle:thin:@34.215.33.142:1521:kibwa";
	private String db_id = "neon";
	private String db_pw = "pass";
	Statement stmt = null;
	PreparedStatement ps = null; // 자동커밋
	PreparedStatement ps2 = null;
	String driver = "oracle.jdbc.driver.OracleDriver";

	public BoothWriteDAO() throws Exception {
		connectDB();
	}

	void connectDB() throws Exception {

		Class.forName(driver);
		con = DriverManager.getConnection(jdbc_url, db_id, db_pw);
		System.out.println("DB 연결 성공");

	}

	// 부스 리스트
	public ArrayList festivallist() throws Exception {

		ArrayList list = new ArrayList();

		String sql = "SELECT f.festivalno, festivaltypename, festivalname,festivalstart,festivalend,festivalentercode from festival f, festivaltype t, festivalcode c where f.festivaltypeno = t.festivaltypeno and f.festivalno=c.festivalno (+)";
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getInt("festivalno"));
			temp.add(rs.getString("festivaltypename"));
			temp.add(rs.getString("festivalname"));
			temp.add(rs.getString("festivalstart"));
			temp.add(rs.getString("festivalend"));
			temp.add(rs.getString("festivalentercode"));
			list.add(temp);
		}
		rs.close();
		stmt.close();
		return list;
	}

	// 부스 등록

	public void regist(BoothWriteVO vo) throws Exception {

		System.out.println(vo.getBoothTypeName());
		System.out.println(vo.getBoothname());
		System.out.println(vo.getBoothmax());
		System.out.println(vo.getBoothstart());
		System.out.println(vo.getBoothend());
		System.out.println(vo.getBoothcontent());
		System.out.println(vo.getFestivalno());

		String sql = "insert into booth (boothno, boothtypeno, boothname, boothmax, boothstart, boothend, boothcontent, festivalno)"
				+ "values (booth_seq.nextval, (select boothtypeno from boothtype where boothtypename = ?), ?, ?, ?, ?, ?, ?)";

		ps = con.prepareStatement(sql);
		ps.setString(1, vo.getBoothTypeName());
		ps.setString(2, vo.getBoothname());
		ps.setInt(3, vo.getBoothmax());
		ps.setString(4, vo.getBoothstart());
		ps.setString(5, vo.getBoothend());
		ps.setString(6, vo.getBoothcontent());
		ps.setInt(7, vo.getFestivalno());

		ps.executeUpdate();
		ps.close();

		String sql2 = "insert into boothmanager (bmno, bmrankno, memberno, boothno)"
				+ "values (boothmanager_seq.nextval, (select bmrankno from boothmanagerrank where bmrankname = ?),"
				+ "(select memberno from member where memberid = ?), booth_seq.currval)";

		ps2 = con.prepareStatement(sql2);
		ps2.setString(1, vo.getBoothrankname());
		ps2.setString(2, vo.getMemberid());

		ps2.executeUpdate();
		ps2.close();

	}

}
