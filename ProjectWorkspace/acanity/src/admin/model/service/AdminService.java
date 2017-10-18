package admin.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import History.model.vo.History;
import admin.model.dao.AdminDao;
import community.model.vo.Community;
import member.model.vo.Member;
import post.model.vo.Post;

public class AdminService {

	// 전체 회원 수
	public int memberCount() {
		Connection con = getConnection();
		int result = new AdminDao().memberCount(con);
		
		close(con);
		
		return result;
	}
	
	// 전체 게시글 수
	public int postCount() {
		Connection con = getConnection();
		int result = new AdminDao().postCount(con);
		
		close(con);
		
		return result;
	}

	// 전체 그룹 수
	public int communityCount() {
		Connection con = getConnection();
		int result = new AdminDao().communityCount(con);
		
		close(con);
		
		return result;
	}

	// 전체 만남 수
	public int meetingCount() {
		Connection con = getConnection();
		int result = new AdminDao().meetingCount(con);
		
		close(con);
		
		return result;
	}
	
	// 전체 회원 출력
	public ArrayList<Member> memberAll() {
		Connection con = getConnection();
		ArrayList<Member> memberList = new AdminDao().memberAll(con);
		
		close(con);
		
		return memberList;
	}

	// 회원 상세 보기
	public Member memberDetail(String id) {
		Connection con = getConnection();
		Member member = new AdminDao().memberDetail(con, id);
		
		close(con);
		
		return member;
	}

	// 회원이 가입한 그룹 리스트
	public ArrayList<Community> memberCommunity(String id) {
		Connection con = getConnection();
		ArrayList<Community> communityList = new AdminDao().memberCommunity(con, id);
		
		close(con);
		
		return communityList;
	}

	// 회원이 작성한 게시글 수
	public int memberPostCount(String id) {
		Connection con = getConnection();
		int result = new AdminDao().memberPostCount(con, id);
		
		close(con);
		
		return result;
	}

	// 회원이 가입한 그룹 수
	public int memberGroupCount(String id) {
		Connection con = getConnection();
		int result = new AdminDao().memberGroupCount(con, id);
		
		close(con);
		
		return result;
	}

	// 회원이 참석한 미팅 수
	public int memberMeetingCount(String id) {
		Connection con = getConnection();
		int result = new AdminDao().memberMeetingCount(con, id);
		
		close(con);
		
		return result;
	}

	// 회원이 가입한 가장 오래된 그룹 모임에서의 참여 비율
	public int memberKeyGroupRate(String id) {
		Connection con = getConnection();
		int result = new AdminDao().memberKeyGroupRate(con, id);
		
		close(con);
		
		return result;
	}

	// 전체 그룹 출력
	public ArrayList<Community> communityAll() {
		Connection con = getConnection();
		ArrayList<Community> communityList = new AdminDao().communityAll(con);
		
		close(con);
		
		return communityList;
	}
	
	// 그룹 상세 보기
	public Community communityDetail(String no) {
		Connection con = getConnection();
		Community community = new AdminDao().communityDetail(con, no);
		
		close(con);
		
		return community;
	}
	
	// 해당 그룹의 만남 출력
	public ArrayList<History> communityMeeting(String no) {
		Connection con = getConnection();
		ArrayList<History> meetingList = new AdminDao().communityMeeting(con, no);
		
		close(con);
		
		return meetingList;
	}

	// 해당 그룹 멤버 수
	public int communityMemberCount(String no) {
		Connection con = getConnection();
		int result = new AdminDao().communityMemberCount(con, no);
		
		close(con);
		
		return result;
	}

	// 해당 그룹 만남 수
	public int communityMeetingCount(String no) {
		Connection con = getConnection();
		int result = new AdminDao().communityMeetingCount(con, no);
		
		close(con);
		
		return result;
	}

	// 날짜를 입력받고 그 날짜에 대한 방문수 리턴
	public int visitorCount(String date) {
		Connection con = getConnection();
		int result = new AdminDao().visitorCount(con, date);
		
		close(con);
		
		return result;
	}

	// 오늘 날짜에 기록된 ip가 있는지 여부
	public int existDate(String checkIp, String checkDate) {
		Connection con = getConnection();
		int result = new AdminDao().existDate(con, checkIp, checkDate);
		
		close(con);
		
		return result;
	}

	// 아이피, 날짜 삽입
	public void insertDate(String checkIp, String checkDate) {
		Connection con = getConnection();
		int result = new AdminDao().insertDate(con, checkIp, checkDate);
		
		if(result > 0)
			commit(con);
		else
			rollback(con);
		
		close(con);
	}

	// 회원이 참여한 총 만남 중 각 그룹의 만남 비율
	public int memberMeetingRate(String id, int no) {
		Connection con = getConnection();
		int result = new AdminDao().memberMeetingRate(con, id, no);
		
		close(con);
		
		return result;
	}

	// 이전 달의 출석수가 높은 회원 5명 추출
	public ArrayList<Member> topAttendMember() {
		Connection con = getConnection();
		ArrayList<Member> memberList = new AdminDao().topAttendMember(con);
		
		close(con);
		
		return memberList;
	}

	// 오늘 올라온 채용 공고
	public ArrayList<Community> todayRecruitCommunity() {
		Connection con = getConnection();
		ArrayList<Community> communityList = new AdminDao().todayRecruitCommunity(con);
		
		close(con);
		
		return communityList;
	}

	// 커뮤니티에 가입한 회원 출력
	public ArrayList<Member> communityMemberAll(int no) {
		Connection con = getConnection();
		ArrayList<Member> memberList = new AdminDao().communityMemberAll(con, no);
		
		close(con);
		
		return memberList;
	}

	// 전체 QnA 게시글 출력
	public ArrayList<Post> qnaAll() {
		Connection con = getConnection();
		ArrayList<Post> qnaList = new AdminDao().qnaAll(con);
		
		close(con);
		
		return qnaList;
	}

	// QnA 게시글 수
	public int qnaCount() {
		Connection con = getConnection();
		int result = new AdminDao().qnaCount(con);
		
		close(con);
		
		return result;
	}

	// QnA 상세보기
	public ArrayList<Post> qnaDetail(int no) {
		Connection con = getConnection();
		ArrayList<Post> qnaList = new AdminDao().qnaDetail(con, no);
		
		close(con);
		
		return qnaList;
	}

	// QnA 조회수 증가
	public void qnaRead(int no) {
		Connection con = getConnection();
		int result = new AdminDao().qnaRead(con, no);
		
		if(result > 0)
			commit(con);
		else
			rollback(con);
	}
	
	

}
