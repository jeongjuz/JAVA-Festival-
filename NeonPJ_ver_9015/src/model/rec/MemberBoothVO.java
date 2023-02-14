package model.rec;

public class MemberBoothVO {
	int number;
	String name,place,starttime,endtime,content;

	public MemberBoothVO(){}
	
	public MemberBoothVO(int number,String name, String place, String starttime, String endtime,String content) {
		this.number=number;
		this.name=name;
		this.place=place;
		this.starttime=starttime;
		this.endtime=endtime;
		this.content=content;
		//부스명,부스위치,부스시작시간,부스마감시간,부스내용
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
