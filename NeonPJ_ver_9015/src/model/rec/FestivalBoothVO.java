package model.rec;

public class FestivalBoothVO {

	public String getBoothtype() {
		return boothtype;
	}

	public void setBoothtype(String boothtype) {
		this.boothtype = boothtype;
	}

	public String getBoothname() {
		return boothname;
	}

	public void setBoothname(String boothname) {
		this.boothname = boothname;
	}

	public String getBoothlocation() {
		return boothlocation;
	}

	public void setBoothlocation(String boothlocation) {
		this.boothlocation = boothlocation;
	}

	public String getBoothstart() {
		return boothstart;
	}

	public void setBoothstart(String boothstart) {
		this.boothstart = boothstart;
	}

	public String getBoothend() {
		return boothend;
	}

	public void setBoothend(String boothend) {
		this.boothend = boothend;
	}

	public String getBoothcontent() {
		return boothcontent;
	}

	public void setBoothcontent(String boothcontent) {
		this.boothcontent = boothcontent;
	}

	public int getBoothmax() {
		return boothmax;
	}

	public void setBoothmax(int boothmax) {
		this.boothmax = boothmax;
	}

	String boothtype, boothname, boothlocation, boothstart, boothend, boothcontent;
	int boothmax;
	String mgrRank;

	public FestivalBoothVO(String boothtype, String boothname, String boothlocation, String boothstart, String boothend,
			String boothcontent, int boothmax, String mgrRank) {
		this.boothtype = boothtype;
		this.boothname = boothname;
		this.boothlocation = boothlocation;
		this.boothstart = boothstart;
		this.boothend = boothend;
		this.boothcontent = boothcontent;
		this.boothmax = boothmax;
		this.mgrRank = mgrRank;

	}

	public String getMgrRank() {
		return mgrRank;
	}

	public void setMgrRank(String mgrRank) {
		this.mgrRank = mgrRank;
	}

	public FestivalBoothVO() {

	}

}
