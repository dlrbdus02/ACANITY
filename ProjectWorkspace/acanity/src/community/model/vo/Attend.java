package community.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Attend implements Serializable {
	
	private int attendNo;
	private String attnedId;
	private Date attendDate;
	
	public Attend() {
		super();
	}

	public Attend(int attendNo, String attnedId, Date attendDate) {
		super();
		this.attendNo = attendNo;
		this.attnedId = attnedId;
		this.attendDate = attendDate;
	}

	public int getAttendNo() {
		return attendNo;
	}

	public void setAttendNo(int attendNo) {
		this.attendNo = attendNo;
	}

	public String getAttnedId() {
		return attnedId;
	}

	public void setAttnedId(String attnedId) {
		this.attnedId = attnedId;
	}

	public Date getAttendDate() {
		return attendDate;
	}

	public void setAttendDate(Date attendDate) {
		this.attendDate = attendDate;
	}

	@Override
	public String toString() {
		return attendNo + ", " + attnedId + ", " + attendDate;
	}
	
}
