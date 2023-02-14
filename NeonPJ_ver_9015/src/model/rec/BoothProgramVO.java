package model.rec;

public class BoothProgramVO {
	int programNo, programMax, boothNo;
	String programName, programContent;

	public BoothProgramVO(int boothNo, String proName, int proMax, String proContent) {
		this.boothNo = boothNo;
		this.programName = proName;
		this.programMax = proMax;
		this.programContent = proContent;
	}

	public BoothProgramVO() {
		// TODO Auto-generated constructor stub
	}

	public int getBoothNo() {
		return boothNo;
	}

	public void setBoothNo(int boothNo) {
		this.boothNo = boothNo;
	}

	public int getProgramNo() {
		return programNo;
	}

	public void setProgramNo(int programNo) {
		this.programNo = programNo;
	}

	public int getProgramMax() {
		return programMax;
	}

	public void setProgramMax(int programMax) {
		this.programMax = programMax;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public String getProgramContent() {
		return programContent;
	}

	public void setProgramContent(String programContent) {
		this.programContent = programContent;
	}

}
