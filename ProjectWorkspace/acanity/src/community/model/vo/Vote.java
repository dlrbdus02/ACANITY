package community.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Vote implements Serializable {
	
	private int voteNo;
	private String voteTitle;
	private Date voteStartDate;
	private Date voteEndDate;
	private int voteCNo;
	private int voteItemNo;
	private String voteItemSelect;
	private int voteResultNo;
	private String voteResultSelect;
	private String voteResultId;
	
	public Vote() {
		super();
	}

	public Vote(int voteNo, String voteTitle, Date voteStartDate, Date voteEndDate, int voteCNo) {
		super();
		this.voteNo = voteNo;
		this.voteTitle = voteTitle;
		this.voteStartDate = voteStartDate;
		this.voteEndDate = voteEndDate;
		this.voteCNo = voteCNo;
	}

	public Vote(int voteItemNo, String voteItemSelect) {
		super();
		this.voteItemNo = voteItemNo;
		this.voteItemSelect = voteItemSelect;
	}

	public Vote(int voteResultNo, String voteResultSelect, String voteResultId) {
		super();
		this.voteResultNo = voteResultNo;
		this.voteResultSelect = voteResultSelect;
		this.voteResultId = voteResultId;
	}

	public Vote(int voteNo, String voteTitle, Date voteStartDate, Date voteEndDate, int voteCNo, int voteItemNo,
			String voteItemSelect, int voteResultNo, String voteResultSelect, String voteResultId) {
		super();
		this.voteNo = voteNo;
		this.voteTitle = voteTitle;
		this.voteStartDate = voteStartDate;
		this.voteEndDate = voteEndDate;
		this.voteCNo = voteCNo;
		this.voteItemNo = voteItemNo;
		this.voteItemSelect = voteItemSelect;
		this.voteResultNo = voteResultNo;
		this.voteResultSelect = voteResultSelect;
		this.voteResultId = voteResultId;
	}

	public int getVoteNo() {
		return voteNo;
	}

	public void setVoteNo(int voteNo) {
		this.voteNo = voteNo;
	}

	public String getVoteTitle() {
		return voteTitle;
	}

	public void setVoteTitle(String voteTitle) {
		this.voteTitle = voteTitle;
	}

	public Date getVoteStartDate() {
		return voteStartDate;
	}

	public void setVoteStartDate(Date voteStartDate) {
		this.voteStartDate = voteStartDate;
	}

	public Date getVoteEndDate() {
		return voteEndDate;
	}

	public void setVoteEndDate(Date voteEndDate) {
		this.voteEndDate = voteEndDate;
	}

	public int getVoteCNo() {
		return voteCNo;
	}

	public void setVoteCNo(int voteCNo) {
		this.voteCNo = voteCNo;
	}

	public int getVoteItemNo() {
		return voteItemNo;
	}

	public void setVoteItemNo(int voteItemNo) {
		this.voteItemNo = voteItemNo;
	}

	public String getVoteItemSelect() {
		return voteItemSelect;
	}

	public void setVoteItemSelect(String voteItemSelect) {
		this.voteItemSelect = voteItemSelect;
	}

	public int getVoteResultNo() {
		return voteResultNo;
	}

	public void setVoteResultNo(int voteResultNo) {
		this.voteResultNo = voteResultNo;
	}

	public String getVoteResultSelect() {
		return voteResultSelect;
	}

	public void setVoteResultSelect(String voteResultSelect) {
		this.voteResultSelect = voteResultSelect;
	}

	public String getVoteResultId() {
		return voteResultId;
	}

	public void setVoteResultId(String voteResultId) {
		this.voteResultId = voteResultId;
	}

	@Override
	public String toString() {
		return voteNo + ", " + voteTitle + ", " + voteStartDate + ", " + voteEndDate + ", " + voteCNo + ", " + 
			   voteItemNo + ", " + voteItemSelect + ", " + voteResultNo + ", " + voteResultSelect + ", " + 
			   voteResultId;
	}
	
	
}
