package model.rec;

public class FestivalInsertVO {

	int no;
	String fpublic, name, start, end, content, addr, type;
	String jugw, juch, mgrRank;

	public String getJugw() {
		return jugw;
	}

	public void setJugw(String jugw) {
		this.jugw = jugw;
	}

	public String getJuch() {
		return juch;
	}

	public void setJuch(String juch) {
		this.juch = juch;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getType() {
		return type;
	}

	public void setTypeno(String typeno) {
		this.type = type;
	}

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

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public FestivalInsertVO(String type, String fpublic, String name, String start, String end, String content,
			String addr) {
		this.type = type;
		this.fpublic = fpublic;
		this.name = name;
		this.start = start;
		this.end = end;
		this.content = content;
		this.addr = addr;

	}

	public FestivalInsertVO(String type2, String fpublic2, String name2, String start2, String end2, String content2,
			String addr2, String jugw, String juch, String mgrRank) {
		this(type2, fpublic2, name2, start2, end2, content2, addr2);
		this.jugw = jugw;
		this.juch = juch;
		this.mgrRank = mgrRank;
		
	}

	public String getMgrRank() {
		return mgrRank;
	}

	public void setMgrRank(String mgrRank) {
		this.mgrRank = mgrRank;
	}

}
