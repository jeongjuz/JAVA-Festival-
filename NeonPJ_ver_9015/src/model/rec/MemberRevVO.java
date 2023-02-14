package model.rec;

public class MemberRevVO {
	int revNo,count,waitTeam;
	String waitTime,boothname;
	
	public String getBoothname() {
		return boothname;
	}
	public void setBoothname(String boothname) {
		this.boothname = boothname;
	}
	public int getRevNo() {
		return revNo;
	}
	public void setRevNo(int revNo) {
		this.revNo = revNo;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getWaitTime() {
		return waitTime;
	}
	public void setWaitTime(String waitTime) {
		this.waitTime = waitTime;
	}
	
	public MemberRevVO(int revNo,int count,String waitTime,String boothname,int waitTeam) {
		this.revNo = revNo;
		this.count = count;
		this.waitTime = waitTime;
		this.boothname = boothname;
		this.waitTeam = waitTeam;
	}
	public int getWaitTeam() {
		return waitTeam;
	}
	public void setWaitTeam(int waitTeam) {
		this.waitTeam = waitTeam;
	}
	public MemberRevVO() {
		// TODO Auto-generated constructor stub
	}
	
	
}
