package model.rec;

public class LoginVO {

	int memberno;
	public int getMemberno() {
		return memberno;
	}







	public void setMemberno(int memberno) {
		this.memberno = memberno;
	}







	public int getMembertypeno() {
		return membertypeno;
	}







	public void setMembertypeno(int membertypeno) {
		this.membertypeno = membertypeno;
	}







	public String getMemberbirth() {
		return memberbirth;
	}







	public void setMemberbirth(String memberbirth) {
		this.memberbirth = memberbirth;
	}







	public String getMemberpw() {
		return memberpw;
	}







	public void setMemberpw(String memberpw) {
		this.memberpw = memberpw;
	}







	public String getMemberphone() {
		return memberphone;
	}







	public void setMemberphone(String memberphone) {
		this.memberphone = memberphone;
	}







	public String getMembername() {
		return membername;
	}







	public void setMembername(String membername) {
		this.membername = membername;
	}







	public String getMembersex() {
		return membersex;
	}







	public void setMembersex(String membersex) {
		this.membersex = membersex;
	}







	public String getMemberid() {
		return memberid;
	}







	public void setMemberid(String memeberid) {
		this.memberid = memeberid;
	}







	int membertypeno;
	String memberbirth,memberpw, memberphone, membername, membersex, memberid;

	
	


	
	
	public LoginVO(String id, String pw, int memebertypeno) {
		this.memberid=id;
		this.memberpw=pw;
		this.membertypeno=memebertypeno;
	
	}

}
