package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.rec.FestivalBoothVO;

public class FestivalBoothDAO {

	// ###########################################################
//  DB  control method
	Connection con;
	private String jdbc_url = "jdbc:oracle:thin:@34.215.33.142:1521:kibwa";
	private String db_id = "neon";
	private String db_pwd = "pass";
	Statement stmt = null;
	PreparedStatement ps = null; // 자동커밋
	PreparedStatement ps2 = null; // 자동커밋
	String driver = "oracle.jdbc.driver.OracleDriver";
	String loginMemberId;
	int festNo;

	void connectDB() throws Exception {
		/*
		 * 1. 드라이버를 드라이버메니저에 등록 2. 연결 객체 얻어오기
		 */

		Class.forName(driver);
		con = DriverManager.getConnection(jdbc_url, db_id, db_pwd);
	}

	public FestivalBoothDAO(String loginMemberId, int festNo) throws Exception {
		this.loginMemberId = loginMemberId;
		this.festNo = festNo;
		connectDB();
	}

	public void FestivalBoothInsert(FestivalBoothVO vo) throws Exception {
		
		// 1. 부스 테이블에 인서트  
		String boothtype = vo.getBoothtype();
		String boothname = vo.getBoothname();
		String boothlocation = vo.getBoothlocation();
		String boothstart = vo.getBoothstart();
		String boothend = vo.getBoothend();
		String boothcontent = vo.getBoothcontent();
		int boothmax = vo.getBoothmax();

		String sql = "INSERT INTO "
				+ "Booth(boothno, boothmax,boothtypeno, boothname,boothlocation,boothstart,boothend,boothcontent,festivalno) "
				+ "values(booth_seq.nextval,?,(select boothtypeno from boothtype where boothtypename = ?),?,?,?,?,?,?)";

//		String sql = "INSERT INTO "
//				+ "PublicFacility(PUBLICFACILITYNO, PUBLICNAME,PFTYPENO,FESTIVALNO,PFTLOCATION) "
//				+ "values(pub_seq.nextval,?,(select PFTYPENO from PUBLICFACILITYTYPE where PFTYPENAME = ?),44, ?)";
//		

		ps = con.prepareStatement(sql);
		ps.setInt(1, boothmax);
		ps.setString(2, boothtype);
		ps.setString(3, boothname);
		ps.setString(4, boothlocation);
		ps.setString(5, boothstart);
		ps.setString(6, boothend);
		ps.setString(7, boothcontent);
		ps.setInt(8, festNo);

		ps.executeUpdate();
		ps.close();
		
		// 2. 부스관리자 테이블에 인서트 
		String mgrRank = vo.getMgrRank();
		String sqlMgr = "INSERT INTO BOOTHMANAGER (BMNO, BOOTHNO, MEMBERNO, BMRANKNO) VALUES (BOOTHMANAGER_SEQ.nextval, BOOTH_SEQ.currval, (SELECT MEMBERNO FROM MEMBER WHERE MEMBERID = ?), (SELECT BMRANKNO FROM BOOTHMANAGERRANK WHERE BMRANKNAME = ?))";
		PreparedStatement psMgr = con.prepareStatement(sqlMgr);
		psMgr.setString(1, loginMemberId);
		psMgr.setString(2, mgrRank);
		psMgr.executeUpdate();
		psMgr.close();
		
	}

	public ArrayList boothlist() throws Exception {
		System.out.println("DAO");
		ArrayList list = new ArrayList();

		String sql = "select "
				+ "b.boothno,"
				+ "(select membername from member where memberno = bm.memberno) bmname, "
				+ "(select bmrankname from boothmanagerrank where bmrankno = bm.bmrankno) bmrank,"
				+ "(select boothtypename from boothtype where boothtypeno = b.boothtypeno) boothtypename, "
				+ "b.boothname, "
				+ "b.boothcontent, "
				+ "b.boothstart, "
				+ "b.boothend, "
				+ "b.boothlocation, "
				+ "b.boothmax "
				+ "from boothmanager bm, booth b "
				+ "where bm.boothno = b.boothno "
				+ "and b.festivalno = ? "
				+ "order by b.boothname, bm.bmrankno desc";

		ps = con.prepareStatement(sql);
		ps.setInt(1, festNo);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getInt("boothno"));
			temp.add(rs.getString("bmname"));
			temp.add(rs.getString("bmrank"));	
			temp.add(rs.getString("boothtypename"));
			temp.add(rs.getString("boothname"));
			temp.add(rs.getString("boothmax"));
			list.add(temp);
		}
		rs.close();
		ps.close();
		return list;

	}

	public FestivalBoothVO festivalBoothDetail(int boothNo) throws SQLException {
		FestivalBoothVO vo = new FestivalBoothVO();
		String sql = " SELECT " + "(select boothtypename " + "from boothtype "
				+ "where BOOTHTYPENO = p.BOOTHTYPENO ) boothtypename, "
				+ "boothname, boothlocation, boothmax, boothstart, boothend, boothcontent "
				+ "from booth p where boothno = ?";
		ps = con.prepareStatement(sql);
		ps.setInt(1, boothNo);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			vo.setBoothtype(rs.getString("boothtypename"));
			vo.setBoothname(rs.getString("boothname"));
			vo.setBoothlocation(rs.getString("boothlocation"));
			vo.setBoothmax(rs.getInt("boothmax"));
			vo.setBoothstart(rs.getString("boothstart"));
			vo.setBoothend(rs.getString("boothend"));
			vo.setBoothcontent(rs.getString("boothcontent"));
		}
		rs.close();
		ps.close();
		return vo;
	}

	public void deleteFestivalBooth(int boothNo) throws SQLException {

		String sqlProgram = "delete from boothprogram boothno = ?";
		String sqlBooth = "delete from booth where boothno = ?";

//		ps = con.prepareStatement(sqlProgram);
//		ps.setInt(1, boothNo);
//		ps.executeUpdate();
//		ps.close();

		ps2 = con.prepareStatement(sqlBooth);
		ps2.setInt(1, boothNo);
		ps2.executeUpdate();
		ps2.close();
	}

	// 부스 검색 기능 시작 (new)
	public ArrayList boothsearch(int sel, String text) throws Exception {

		ArrayList list = new ArrayList();
		String[] selCol = {"BOOTHNAME", "BOOTHLOCATION", "BOOTHMAX", "BOOTHSTART", "BOOTHEND", "boothcontent" };
		
		//SELECT boothno, (select boothtypename from boothtype where BOOTHTYPENO = p.BOOTHTYPENO)boothtypename, boothname,boothlocation,  boothmax, boothstart, boothend from booth p
//		String sql = " SELECT boothno, (select boothtypename from boothtype where BOOTHTYPENO = p.BOOTHTYPENO )boothtypename,boothname,BOOTHLOCATION,BOOTHMAX, BOOTHSTART,BOOTHEND from booth p where  "
//				+ selCol[sel] + " like '%" + text + "%'";
		
		
		String sql = "select "
				+ "b.boothno,"
				+ "(select membername from member where memberno = bm.memberno) bmname, "
				+ "(select bmrankname from boothmanagerrank where bmrankno = bm.bmrankno) bmrank,"
				+ "(select boothtypename from boothtype where boothtypeno = b.boothtypeno) boothtypename, "
				+ "b.boothname, "
				+ "b.boothcontent, "
				+ "b.boothstart, "
				+ "b.boothend, "
				+ "b.boothlocation, "
				+ "b.boothmax "
				+ "from boothmanager bm, booth b "
				+ "where bm.boothno = b.boothno "
				+ "and b.festivalno = " + festNo + " and b."+ selCol[sel] +" like '%" + text + "%' "
				+ "order by b.boothname, bm.bmrankno desc";
		
//		ps = con.prepareStatement(sql);
//		ps.setInt(1, festNo);
//		ps.setString(2, selCol[sel]);
//		ps.setString(3, text);
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getInt("boothno"));
			temp.add(rs.getString("bmname"));
			temp.add(rs.getString("bmrank"));	
			temp.add(rs.getString("boothtypename"));
			temp.add(rs.getString("boothname"));
			temp.add(rs.getString("boothmax"));
			list.add(temp);

		}
		rs.close();
		ps.close();

		return list;
	}
	// 부스 검색 기능 끝
	///////////////////////////////////

}
