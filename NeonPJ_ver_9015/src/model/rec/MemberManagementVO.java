package model.rec;

public class MemberManagementVO {
	String number,typename,name,place,startdate,deadline,code;

	public MemberManagementVO(){}
	
	public MemberManagementVO(String number,String typename, String name, String place, String startdate, String deadline,String code) {
		this.number=number;
		this.typename=typename;
		this.name = name;
		this.place = place;
		this.startdate=startdate;
		this.deadline = deadline;
		this.code=code;
		//축제유형번호 축제명  시작날짜 끝 날짜, 입장코드
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
} 

