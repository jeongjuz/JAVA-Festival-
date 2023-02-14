package model.rec;

import java.util.function.IntBinaryOperator;

public class BoothWriteVO {
	int boothno, festivalno, boothmax, boothrank, boothtypeno, bmrankno;
	String bmrankname, memberid, boothname, boothlocation, boothstart, boothend, boothcontent, boothTypeName;
	
	
	
	
	public int getBmrankno() {
		return bmrankno;
	}

	public void setBmrankno(int bmrankno) {
		this.bmrankno = bmrankno;
	}
	
	public String getBoothrankname() {
		return bmrankname;
	}

	public void setBoothrankname(String boothrankname) {
		this.bmrankname = boothrankname;
	}

	public String getMemberid() {
		return memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}

	public int getBoothrank() {
		return boothrank;
	}

	public void setBoothrank(int boothrank) {
		this.boothrank = boothrank;
	}
	
	public String getBoothTypeName() {
		return boothTypeName;
	}

	public void setBoothTypeName(String boothTypeName) {
		this.boothTypeName = boothTypeName;
	}

	public BoothWriteVO() {}
	
	public BoothWriteVO(int boothno, int boothtypeno, int festivalno, int boothmax, String boothname, String boothlocation, String boothstart, String boothend, String boothcontent) {
		this.boothno = boothno;
		this.boothtypeno = boothtypeno;
		this.festivalno = festivalno;
		this.boothmax = boothmax;
		this.boothname = boothname;
		this.boothstart = boothstart;
		this.boothend = boothend;
		this.boothcontent = boothcontent;
	}
	
	public BoothWriteVO(int boothtypeno, int festivalno, int boothmax, String boothname, String boothlocation, String boothstart, String boothend, String boothcontent) {
		this.boothtypeno = boothtypeno;
		this.festivalno = festivalno;
		this.boothmax = boothmax;
		this.boothname = boothname;
		this.boothlocation = boothlocation;
		this.boothstart = boothstart;
		this.boothend = boothend;
		this.boothcontent = boothcontent;
	}
	
	public BoothWriteVO(String typeName, int festivalno, int max, String boothname, String boothstart, String boothend, String boothcontent, String memberid, String bmRankName) {
		this.boothTypeName = typeName;
		this.festivalno = festivalno;
		this.boothmax = max;
		this.boothname = boothname;
		this.boothstart = boothstart;
		this.boothend = boothend;
		this.boothcontent = boothcontent;
		this.memberid = memberid;
		this.bmrankname =bmRankName; 
	}
		
		
	public int getBoothno() {
		return boothno;
	}

	public void setBoothno(int boothno) {
		this.boothno = boothno;
	}

	public int getFestivalno() {
		return festivalno;
	}

	public void setFestivalno(int festivalno) {
		this.festivalno = festivalno;
	}

	public int getBoothtypeno() {
		return boothtypeno;
	}

	public void setBoothtype(int boothtypeno) {
		this.boothtypeno = boothtypeno;
	}

	public int getBoothmax() {
		return boothmax;
	}

	public void setBoothmax(int boothmax) {
		this.boothmax = boothmax;
	}

	public String getBoothname() {
		return boothname;
	}

	public void setBoothname(String boothname) {
		this.boothname = boothname;
	}

	public String getBoothlocation() {
		return boothlocation;
	}

	public void setBoothlocation(String boothlocation) {
		this.boothlocation = boothlocation;
	}

	public String getBoothstart() {
		return boothstart;
	}

	public void setBoothstart(String boothstart) {
		this.boothstart = boothstart;
	}

	public String getBoothend() {
		return boothend;
	}

	public void setBoothend(String boothend) {
		this.boothend = boothend;
	}

	public String getBoothcontent() {
		return boothcontent;
	}

	public void setBoothcontent(String boothcontent) {
		this.boothcontent = boothcontent;
	}
	
}
