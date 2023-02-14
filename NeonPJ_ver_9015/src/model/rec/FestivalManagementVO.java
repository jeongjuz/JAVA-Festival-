package model.rec;

public class FestivalManagementVO {
	String fpublic,name,start,end,content;
	int festivalno,typeno;
	
	public String getFpublic() {
		return fpublic;
	}
	public void setFpublic(String fpublic) {
		this.fpublic = fpublic;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getFestivalno() {
		return festivalno;
	}
	public void setFestivalno(int festivalno) {
		this.festivalno = festivalno;
	}
	public int getTypeno() {
		return typeno;
	}
	public void setTypeno(int typeno) {
		this.typeno = typeno;
	}
	
	
	public FestivalManagementVO(String fpublic,String name,String start,String end,String content,int festivalno, int typeno) {
		this.fpublic = fpublic;
		this.name = name;
		this.start = start;
		this.end = end;
		this.content = content;
		this.festivalno = festivalno;
		this.typeno = typeno;
		
	}
	
}
