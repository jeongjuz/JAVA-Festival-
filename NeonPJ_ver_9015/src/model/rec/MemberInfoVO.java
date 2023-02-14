package model.rec;

public class MemberInfoVO {

	String name,id,pw,birth,phone;

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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public MemberInfoVO(String name,String id,String pw,String birth,String phone) {
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.birth = birth;
		this.phone = phone;
		
		
		
	}
}
