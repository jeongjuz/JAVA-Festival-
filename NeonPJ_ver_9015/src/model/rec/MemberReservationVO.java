package model.rec;

public class MemberReservationVO {

	int boothNo,brevNo,brevhCount;
	String cansel,entry,time,id;
	public int getBoothNo() {
		return boothNo;
	}
	public void setBoothNo(int boothNo) {
		this.boothNo = boothNo;
	}
	public int getBrevNo() {
		return brevNo;
	}
	public void setBrevNo(int brevNo) {
		this.brevNo = brevNo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getBrevhCount() {
		return brevhCount;
	}
	public void setBrevhCount(int brevhCount) {
		this.brevhCount = brevhCount;
	}
	public String getCansel() {
		return cansel;
	}
	public void setCansel(String cansel) {
		this.cansel = cansel;
	}
	public String getEntry() {
		return entry;
	}
	public void setEntry(String entry) {
		this.entry = entry;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	public MemberReservationVO(int boothNo,int brevhCount,String id) {
		this.boothNo = boothNo;
		this.brevhCount = brevhCount;
		this.id = id;
	}
	
	
	
}
