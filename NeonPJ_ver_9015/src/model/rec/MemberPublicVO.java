package model.rec;

public class MemberPublicVO {
	
	int number;
	String typename,name,location;
	String publicPicturePath;
	
	public String getPublicPicturePath() {
		return publicPicturePath;
	}

	public void setPublicPicturePath(String publicPicturePath) {
		this.publicPicturePath = publicPicturePath;
	}

	public MemberPublicVO()
	{}
	
	public MemberPublicVO(int number, String typename,String name,String location) {
		this.number=number;
		this.typename=typename;
		this.name=name;
		this.location=location;
		
	}


	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
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


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}
	
	
	

}
