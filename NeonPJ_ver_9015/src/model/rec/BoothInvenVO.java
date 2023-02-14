package model.rec;

public class BoothInvenVO {

	int invno, boothno, invcount;
	String invname;

	public BoothInvenVO() {
		// TODO Auto-generated constructor stub
	}

	public BoothInvenVO(int invnumber, String name, int invcount, int boothno) {
		this.invno = invnumber;
		this.invname = name;
		this.invcount = invcount;
		this.boothno = boothno;
	}

	public BoothInvenVO(String name, int invcount, int boothno) {
		this.invname = name;
		this.invcount = invcount;
		this.boothno = boothno;
	}

	public BoothInvenVO(int invnumber, String name, int invcount) {
		this.invno = invnumber;
		this.invname = name;
		this.invcount = invcount;
	}

	public BoothInvenVO(String name, int invcount) {
		this.invname = name;
		this.invcount = invcount;
	}

	public BoothInvenVO(int boothno, int invcount) {
		this.boothno = boothno;
		this.invcount = invcount;
	}

	public int getInvenno() {
		return invno;
	}

	public void setInvenno(int invenno) {
		this.invno = invenno;
	}

	public int getBoothno() {
		return boothno;
	}

	public void setBoothno(int boothno) {
		this.boothno = boothno;
	}

	public int getInvencount() {
		return invcount;
	}

	public void setInvencount(int invencount) {
		this.invcount = invencount;
	}

	public String getInvenname() {
		return invname;
	}

	public void setInvenname(String invenname) {
		this.invname = invenname;
	}

}
