package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.rec.BoothProgramVO;

public class BoothProgramDAO {

	Connection con;
	private String url = "jdbc:oracle:thin:@34.215.33.142:1521:kibwa";
	private String user = "neon";
	private String pass = "pass";
	private String driver = "oracle.jdbc.driver.OracleDriver";
	Statement stmt = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public BoothProgramDAO() throws Exception {
		connectDB();
	}

	void connectDB() throws Exception {

		Class.forName(driver);
		con = DriverManager.getConnection(url, user, pass);

	}

	public ArrayList programList(int boothNo) throws Exception {

		ArrayList list = new ArrayList();
		

		// "프로그램번호", "프로그램명", "프로그램내용", "최대인원"
		String sql = "select "
				+ "boothprogramno, "
				+ "boothproname, "
				+ "boothprocontent, "
				+ "boothpromax "
				+ "from boothprogram "
				+ "where boothno = ?";
		
		ps = con.prepareStatement(sql);
		ps.setInt(1, boothNo);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getInt("BOOTHPROGRAMNO"));
			temp.add(rs.getString("BOOTHPRONAME"));
			temp.add(rs.getString("BOOTHPROCONTENT"));
			temp.add(rs.getInt("BOOTHPROMAX"));
			list.add(temp);
		}
		rs.close();
		ps.close();
		return list;
	}
	
	public BoothProgramVO programDetail(int programNo) throws Exception {
		BoothProgramVO vo = new BoothProgramVO();
		String sql = "select "
				+ "boothprogramno, "
				+ "boothproname, "
				+ "boothprocontent, "
				+ "boothpromax "
				+ "from boothprogram "
				+ "where boothprogramno = ?";
		ps = con.prepareStatement(sql);
		ps.setInt(1, programNo);
		ResultSet rs = ps.executeQuery();
		
		if (rs.next()) {
			vo.setProgramNo(rs.getInt("boothprogramno"));
			vo.setProgramName(rs.getString("boothproname"));
			vo.setProgramContent(rs.getString("boothprocontent"));
			vo.setProgramMax(rs.getInt("boothpromax"));
		}
		rs.close();
		ps.close();
		
		return vo;
	}

	public void registProgram(BoothProgramVO vo) throws SQLException {
		String sql = "insert into boothprogram "
				+ "(boothprogramno, boothproname, boothprocontent, boothpromax, boothno) "
				+ "values "
				+ "(boothprogram_seq.nextval, ?, ?, ?, ?)";
		ps = con.prepareStatement(sql);
		ps.setString(1, vo.getProgramName());
		ps.setString(2, vo.getProgramContent());
		ps.setInt(3, vo.getProgramMax());
		ps.setInt(4, vo.getBoothNo());
		ps.executeUpdate();
		ps.close();
	}

	public void deleteProgram(int programNo) throws SQLException {
		String sql = "delete from boothprogram where boothprogramno = ?";
		ps = con.prepareStatement(sql);
		ps.setInt(1, programNo);
		ps.executeUpdate();
		ps.close();
	}

}
