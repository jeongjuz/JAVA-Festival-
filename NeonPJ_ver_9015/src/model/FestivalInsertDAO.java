package model;

import java.nio.channels.SelectableChannel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import model.rec.FestivalInsertVO;
import model.rec.JoinVO;

public class FestivalInsertDAO {

	private Connection conn;
	private String url = "jdbc:oracle:thin:@34.215.33.142:1521:kibwa";
	private String id = "neon";
	private String pw = "pass";
	Statement stmt = null;
	PreparedStatement ps = null;
	String driver = "oracle.jdbc.driver.OracleDriver";

	public FestivalInsertDAO() throws Exception {
		connectDB();
	}
	
	void connectDB() throws Exception {
		Class.forName(driver);
		conn = DriverManager.getConnection(url, id, pw);
	}
	
	public void regist(FestivalInsertVO vo, String loginMemberId) throws Exception {

		// 1. festival 테이블 인서트 
		String fpublic = vo.getFpublic();
		String typeno = vo.getType();
		String name = vo.getName();
		String start = vo.getStart();
		String end = vo.getEnd();
		String content = vo.getContent();
		String addr = vo.getAddr();

		String sqlFestival = "INSERT INTO FESTIVAL(FESTIVALNO, FESTIVALTYPENO, FESTIVALPUBLIC, FESTIVALNAME, FESTIVALSTART, FESTIVALEND, FESTIVALCONTENT, FESTIVALADDR)"
				+ "VALUES(FESTIVAL_SEQ.nextval, (SELECT FESTIVALTYPENO FROM FESTIVALTYPE WHERE FESTIVALTYPENAME = ?), ?, ?, ?, ?, ?, ?)";

		ps = conn.prepareStatement(sqlFestival);
		ps.setString(1, typeno);
		ps.setString(2, fpublic);
		ps.setString(3, name);
		ps.setString(4, start);
		ps.setString(5, end);
		ps.setString(6, content);
		ps.setString(7, addr);

		ps.executeUpdate();
		ps.close();
		
		// 2. festivaljugw테이블 인서트
		String jugw = vo.getJugw();
		String sqlJugw = "INSERT INTO FESTIVALJUGW (FESTIVALJUGWNO, FESTIVALJUGWNAME, FESTIVALNO) VALUES (FESTIVALJUGW_SEQ.nextval, ?, FESTIVAL_SEQ.currval)";
		PreparedStatement psJugw = conn.prepareStatement(sqlJugw);
		psJugw.setString(1, jugw);
		psJugw.executeUpdate();
		psJugw.close();
		
		
		// 3. festivaljuch테이블 인서트 
		String juch = vo.getJuch();
		String sqlJuch = "INSERT INTO FESTIVALJUCH (FESTIVALJUCHNO, FESTIVALJUCHNAME, FESTIVALNO) VALUES (FESTIVALJUCH_SEQ.nextval, ?, FESTIVAL_SEQ.currval)";
		PreparedStatement psJuch = conn.prepareStatement(sqlJuch);
		psJuch.setString(1, juch);
		psJuch.executeUpdate();
		psJuch.close();
		
		// 4. festivalmanager 테이블 인서트 
		String festMgrRank = vo.getMgrRank();
		String sqlFestMgr = "INSERT INTO FESTIVALMANAGER (FMNO, MEMBERNO, FMRANKNO, FESTIVALJUGWNO) VALUES (FESTIVALMANAGER_SEQ.nextval, (SELECT MEMBERNO FROM MEMBER WHERE MEMBERID = ?), (SELECT FMRANKNO FROM FESTIVALMANAGERRANK WHERE FMRANKNAME = ?), FESTIVALJUGW_SEQ.currval)";
		PreparedStatement psFestMgr = conn.prepareStatement(sqlFestMgr);
		psFestMgr.setString(1, loginMemberId);
		psFestMgr.setString(2, festMgrRank);
		psFestMgr.executeUpdate();
		psFestMgr.close();
		
	}

}
