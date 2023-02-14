package model;

import java.awt.font.TextHitInfo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.rec.MemberReservationVO;

public class MemberReservationDAO {

	// ###########################################################
		// DB control method
		Connection con;
		private String url = "jdbc:oracle:thin:@34.215.33.142:1521:kibwa";
		private String user ="neon";
		private String pass  ="pass";
		private String driver = "oracle.jdbc.driver.OracleDriver";
		Statement stmt = null;
		PreparedStatement ps = null; 
		ResultSet rs = null;
		
		public MemberReservationDAO() throws Exception {
			connectDB();
		}
		
		
		void connectDB() throws Exception {
		

			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pass);

		}
		
		public void insertreservation(MemberReservationVO vo) throws Exception {
			String sql ="INSERT INTO BOOTHREV(BOOTHNO, BREVNO, MEMBERNO, BREVTIME, BREVHCOUNT, BREVCANCEL, BREVENTRY) "
					+ "VALUES(?, BOOTHREV_SEQ.nextval, (SELECT memberno FROM MEMBER WHERE memberid = ?), SYSDATE, ?, 'NO', 'NO')";

			ps = con.prepareStatement(sql);
			ps.setInt(1, vo.getBoothNo());
			ps.setString(2, vo.getId());
			ps.setInt(3, vo.getBrevhCount());
			

			ps.executeUpdate();
			ps.close();
			
			
		
			
			
		}
	
}
