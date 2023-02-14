package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import model.rec.BoothInvenVO;

public class BoothInvenDAO {

	   Connection con;
	   private String jdbc_url = "jdbc:oracle:thin:@34.215.33.142:1521:kibwa";
	   private String db_id = "neon";
	   private String db_pw = "pass";
	   Statement stmt = null;
	   PreparedStatement ps = null;
	   String driver = "oracle.jdbc.driver.OracleDriver";

	   public BoothInvenDAO() throws Exception {
		     connectDB();
	   }

	   void connectDB() throws Exception {
	   
	   Class.forName(driver);
		   	 con = DriverManager.getConnection(jdbc_url,db_id,db_pw);
	   		 System.out.println("DB 연결 성공");	
	   }
	   
	   public void invenInsert(BoothInvenVO vo) throws Exception {
		   
		   String sql = "insert into "
				   +    "inventory (invno, invname, invcount, boothno) "
				   +    "values (inv_seq.nextval, ?, ?, ?)";
		   
		   	ps = con.prepareStatement(sql);
		   	ps.setString(1, vo.getInvenname());
		   	ps.setInt	(2, vo.getInvencount());
		   	ps.setInt	(3, vo.getBoothno());
		   
		   	ps.executeUpdate();
		   	ps.close();
	   		
	   }
	   
	   public void invenModify(BoothInvenVO vo) throws Exception {
		   
		   String sql = "update inventory set "
				   +	"invname = ?, "
				   +	"invcount = ? "
				   +	"where invno = ?";

		   ps = con.prepareStatement(sql);
		   ps.setString(1, vo.getInvenname());
		   ps.setInt(2, vo.getInvencount());
		   ps.setInt(3, vo.getInvenno());
		   
		   ps.executeUpdate();
		   ps.close();
		   
	   }
	   
	   public void invenDelete(int invno) throws Exception {
		   
		   String sql = "delete inventory where invno = ? ";
		   ps = con.prepareStatement(sql);
		   ps.setInt(1, invno);
		   ps.executeUpdate();
		   ps.close();
		   
	   }
	   
	   
	   public ArrayList invenlist(int boothNo) throws Exception {
		   
		   ArrayList list = new ArrayList();
		   
		   String sql = "select invno, invname, invcount from inventory where boothno = " + boothNo;
		   stmt = con.createStatement();
		   ResultSet rs = stmt.executeQuery(sql);
		   
		   while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getInt("invno"));
			temp.add(rs.getString("invname"));
			temp.add(rs.getInt("invcount"));
			list.add(temp);
		   }	
		   rs.close();
		   stmt.close();
		   return list;
		   
		}
		   
		public BoothInvenVO findbyno (int invno) throws Exception {
			
			BoothInvenVO vo = new BoothInvenVO();
			String sql = 
					"select invno, invname, invcount from inventory where invno = " + invno;
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				vo.setInvenno(rs.getInt("invno"));
				vo.setInvenname(rs.getString("invname"));
				vo.setInvencount(rs.getInt("invcount"));
			}
			
			rs.close();
			stmt.close();
			return vo;
		}
	   

}