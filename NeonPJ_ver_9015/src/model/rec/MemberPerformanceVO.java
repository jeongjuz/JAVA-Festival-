package model.rec;

public class MemberPerformanceVO {
	int number;
	String name,place,starttime,endtime,castname,content;

	public MemberPerformanceVO(){}
	
	public MemberPerformanceVO(int number,String name, String place, String starttime, String endtime,String content) {
		this.number=number;
		this.name=name;
		this.place=place;
		this.starttime=starttime;
		this.endtime=endtime;
		this.castname=castname;
		this.content=content;
		//공연번호,공연명,공연장소,시작시간,마감시간,출연진,공연내용
	}

	public String getCastname() {
		return castname;
	}

	public void setCastname(String castname) {
		this.castname = castname;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
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

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
