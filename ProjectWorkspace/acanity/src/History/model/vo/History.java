package History.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class History implements Serializable {
	private static final long serialVersionUID = 3333L;
	
	private Date chDate;	 // 모임 날짜
	private Date chTime; 	 // 모임 시간
	private int chNo; 		 // 모임 번호
	private String chPlace;  // 만난 장소
	
	public History() {
		super();
	}

	public History(Date chDate, Date chTime, int chNo, String chPlace) {
		super();
		this.chDate = chDate;
		this.chTime = chTime;
		this.chNo = chNo;
		this.chPlace = chPlace;
	}

	public Date getChDate() {
		return chDate;
	}

	public void setChDate(Date chDate) {
		this.chDate = chDate;
	}

	public Date getChTime() {
		return chTime;
	}

	public void setChTime(Date chTime) {
		this.chTime = chTime;
	}

	public int getChNo() {
		return chNo;
	}

	public void setChNo(int chNo) {
		this.chNo = chNo;
	}

	public String getChPlace() {
		return chPlace;
	}

	public void setChPlace(String chPlace) {
		this.chPlace = chPlace;
	}

	@Override
	public String toString() {
		return "History [chDate=" + chDate + ", chTime=" + chTime + ", chNo=" + chNo + ", chPlace=" + chPlace + "]";
	}
	
}
