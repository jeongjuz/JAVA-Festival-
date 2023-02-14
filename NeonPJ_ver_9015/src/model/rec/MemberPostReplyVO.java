package model.rec;

public class MemberPostReplyVO {

	private int replyNo;
	private String replyTime;
	private String replyContent;
	private int postNo;
	private int memberNo;
	private String memberId;
	
	
	public MemberPostReplyVO() {
		
	}
	
	public MemberPostReplyVO(int postNo, String memberId, String replyContent) {
		this.postNo = postNo;
		this.setMemberId(memberId);
		this.replyContent = replyContent;
		
	}

	public int getReplyNo() {
		return replyNo;
	}

	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}

	public String getReplyTime() {
		return replyTime;
	}

	public void setReplyTime(String replyTime) {
		this.replyTime = replyTime;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public int getPostNo() {
		return postNo;
	}

	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

}
