package model.rec;

public class FestivalPublicVO {
	
	int pftypeno;
	String publicname;// 공공시설명
	String publictypename;// 공공시설타입명
	String publiclocation;
	String publicPicturePath;

	public String getPublicPicturePath() {
		return publicPicturePath;
	}

	public void setPublicPicturePath(String publicPicturePath) {
		this.publicPicturePath = publicPicturePath;
	}

	public String getPublicname() {
		return publicname;
	}

	public void setPublicname(String publicname) {
		this.publicname = publicname;
	}

	public String getPublictypename() {
		return publictypename;
	}

	public void setPublictypename(String publictypename) {
		this.publictypename = publictypename;
	}

	public String getPubliclocation() {
		return publiclocation;
	}

	public void setPubliclocation(String publiclocation) {
		this.publiclocation = publiclocation;
	}


	public FestivalPublicVO(int pftypeno,String publicname, String publictypename, String publiclocation, String publicPicturePath) {
		this.pftypeno=pftypeno;
		this.publictypename = publictypename;
		this.publicname = publicname;
		this.publiclocation = publiclocation;
		this.publicPicturePath = publicPicturePath;

	}
	
	public int getPftypeno() {
		return pftypeno;
	}

	public void setPftypeno(int pftypeno) {
		this.pftypeno = pftypeno;
	}

	public FestivalPublicVO() {}


}
