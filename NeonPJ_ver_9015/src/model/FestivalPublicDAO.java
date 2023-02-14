package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.rec.FestivalPublicVO;

public class FestivalPublicDAO {

//###########################################################
//   DB  control method
	Connection con;
	private String jdbc_url = "jdbc:oracle:thin:@34.215.33.142:1521:kibwa";
	private String db_id = "neon";
	private String db_pwd = "pass";
	Statement stmt = null;
	PreparedStatement ps = null; // 자동커밋
	ResultSet rs = null;
	String driver = "oracle.jdbc.driver.OracleDriver";
	int festNo;

	void connectDB() throws Exception {
		/*
		 * 1. 드라이버를 드라이버메니저에 등록 2. 연결 객체 얻어오기
		 */

		Class.forName(driver);
		con = DriverManager.getConnection(jdbc_url, db_id, db_pwd);
	}

	public FestivalPublicDAO(int festNo) throws Exception {
		connectDB();
		this.festNo = festNo;
	}

	public void FestivalPublicInsert(FestivalPublicVO vo) throws Exception {
		int publicno = vo.getPftypeno();
		String publicname = vo.getPublicname();
		String publictypename = vo.getPublictypename();
		String publiclocation = vo.getPubliclocation();
		String publicPicPath = vo.getPublicPicturePath();

		String sql = "INSERT INTO " + "PublicFacility(PUBLICFACILITYNO, PUBLICNAME,PFTYPENO,FESTIVALNO,PFTLOCATION, PFTPICTUREPATH) "
				+ "values(pub_seq.nextval,?,(select PFTYPENO from PUBLICFACILITYTYPE where PFTYPENAME = ?), ?, ?, ?)";
		ps = con.prepareStatement(sql);

		ps.setString(1, publicname);
		ps.setString(2, publictypename);
		ps.setInt(3, festNo);
		ps.setString(4, publiclocation);// ps.setString(1,vo.getName());
		ps.setString(5, publicPicPath);

		ps.executeUpdate();
		ps.close();
	}

	public ArrayList publicList() throws Exception {
		System.out.println("DAO");
		ArrayList list = new ArrayList();

		String sql = "SELECT PUBLICFACILITYNO, publicname, (select PFTYPENAME from publicfacilitytype where pftypeno = p.pftypeno) publictypename, pftlocation from PUBLICFACILITY p where festivalno = " + festNo;

		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getString("PUBLICFACILITYNO"));
			temp.add(rs.getString("publictypename"));
			temp.add(rs.getString("publicname"));
			temp.add(rs.getString("pftlocation"));
			list.add(temp);
		}
		rs.close();
		stmt.close();
		return list;

	}

	public FestivalPublicVO findByNum(int publicNo) throws Exception {
		System.out.println("DAO-" + publicNo);

		FestivalPublicVO vo = new FestivalPublicVO();
//		String sql = "select p.pftypeno,t.pftypename,p.publicname,p.pftlocation, p.pftpicturepath "
//				+ "from publicfacility p, publicfacilitytype t where p.pftypeno=t.pftypeno and p.PUBLICFACILITYNO="
//				+ publicNo;
		
		String sql = "select p.pftypeno,t.pftypename,p.publicname,p.pftlocation, p.pftpicturepath from publicfacility p, publicfacilitytype t where p.pftypeno=t.pftypeno and p.PUBLICFACILITYNO=?";
		//stmt = con.createStatement();
		//rs = stmt.executeQuery(sql);
		ps = con.prepareStatement(sql);
		ps.setInt(1, publicNo);
		ResultSet rs = ps.executeQuery();
		
		if (rs.next()) {
			vo.setPftypeno(rs.getInt("pftypeno"));
			vo.setPublictypename(rs.getString("pftypename"));
			vo.setPublicname(rs.getString("publicname"));
			vo.setPubliclocation(rs.getString("pftlocation"));
			vo.setPublicPicturePath(rs.getString("pftpicturepath"));
		}

		rs.close();
		stmt.close();

		return vo;
	}

	public ArrayList publicsearch(int sel, String text) throws SQLException {
		String[] selCol= {"PUBLICNAME","PFTLOCATION"};
		String sql = "select PUBLICFACILITYNO,publicname, (select PFTYPENAME from publicfacilitytype where pftypeno = p.pftypeno) publictypename, pftlocation from PUBLICFACILITY p  WHERE " + selCol[sel] + " like '%" + text + "%'";
		stmt = con.createStatement();
        ResultSet rs =stmt.executeQuery(sql);
        ArrayList list = new ArrayList();
        
        while(rs.next()) {
           ArrayList temp = new ArrayList();
   		temp.add(rs.getString("PUBLICFACILITYNO"));
		temp.add(rs.getString("publictypename"));
		temp.add(rs.getString("publicname"));
		temp.add(rs.getString("pftlocation"));
		list.add(temp);
           
        }
        rs.close();
        stmt.close();

        return list;
	}
}
