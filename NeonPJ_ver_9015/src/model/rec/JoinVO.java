package model.rec;

public class JoinVO {

	int memberno;
	int membertypeno;
	String memberbirth,memberpw, memberphone, membername, membersex;
	
	
	
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getPw() {
		return pw;
	}



	public void setPw(String pw) {
		this.pw = pw;
	}



	public String getBirth() {
		return birth;
	}



	public void setBirth(String birth) {
		this.birth = birth;
	}



	public int getMembertypeno() {
		return membertypeno;
	}



	public void setMembertypeno(int membertypeno) {
		this.membertypeno = membertypeno;
	}



	public String getMembersex() {
		return membersex;
	}



	public void setMembersex(String membersex) {
		this.membersex = membersex;
	}



	public String getPhonenumber() {
		return phonenumber;
	}



	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}



	String name, id, pw, birth, phonenumber;



	public JoinVO(String name, String id, String pw, String birth, String phonenumber,int membertypeno, String membersex) {
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.birth = birth;
		this.phonenumber = phonenumber;
		this.membertypeno = membertypeno;
		this.membersex = membersex;
	

	}

}
