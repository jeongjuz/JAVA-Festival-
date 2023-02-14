package model.rec;

public class MemberPostVO {

	private int postNo;
	private int memberNo;
	private String postTitle;
	private String postContent;
	private String postDate;
	private int festivalNo;
	private String memberName;
	private String memberId;

	public int getPostNo() {
		return postNo;
	}

	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public int getFestivalNo() {
		return festivalNo;
	}

	public void setFestivalNo(int festivalNo) {
		this.festivalNo = festivalNo;
	}

	public MemberPostVO() {
		// TODO Auto-generated constructor stub
	}

	public MemberPostVO(int postNo, int memberNo, String postTitle, String postContent, int festivalNo) {
		super();
		this.postNo = postNo;
		this.memberNo = memberNo;
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.festivalNo = festivalNo;
	}

	public MemberPostVO(String memberId, String postTitle, String postContent) {
		this.memberId = memberId;
		this.postTitle = postTitle;
		this.postContent = postContent;
	}

	public MemberPostVO(int postNo, String memberId, String postTitle, String postContent) {
		this(memberId, postTitle, postContent);
		this.postNo = postNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getPostDate() {
		return postDate;
	}

	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}

}
