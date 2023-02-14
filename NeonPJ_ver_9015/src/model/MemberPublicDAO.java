package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.rec.MemberPerformanceVO;
import model.rec.MemberPublicVO;

public class MemberPublicDAO {

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

	public MemberPublicDAO() throws Exception {
		connectDB();
	}

	void connectDB() throws Exception {

		Class.forName(driver);
		con = DriverManager.getConnection(url, user, pass);

	}

	public ArrayList Publiclist(int festivalNo) throws Exception {
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

		String sql = "select publicfacilityno,t.pftypename,p.publicname,p.pftlocation from publicfacility p, publicfacilitytype t where p.pftypeno = t.pftypeno and festivalno ="
				+ festivalNo;

		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getString("publicfacilityno"));
			temp.add(rs.getString("pftypename"));
			temp.add(rs.getString("publicname"));
			temp.add(rs.getString("pftlocation"));

			list.add(temp);
		}
		rs.close();
		stmt.close();
		return list;
	}

	public MemberPublicVO publicmodel(int publicfacilityNo) throws Exception {

		MemberPublicVO vo = new MemberPublicVO();
		String sql = "Select p.publicfacilityno,t.pftypename,p.publicname,p.pftlocation, p.pftpicturepath from publicfacility p,publicfacilitytype t where p.pftypeno=t.pftypeno and publicfacilityno="
				+ publicfacilityNo;
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		if (rs.next()) {
			vo.setTypename(rs.getString("pftypename"));
			vo.setName(rs.getString("publicname"));
			vo.setLocation(rs.getString("pftlocation"));
			vo.setPublicPicturePath(rs.getString("pftpicturepath"));
		}
		rs.close();
		stmt.close();
		return vo;
	}

}