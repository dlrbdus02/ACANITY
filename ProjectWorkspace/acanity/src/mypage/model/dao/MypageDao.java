package mypage.model.dao;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import community.model.vo.Community;
import member.model.vo.Member;

public class MypageDao {
	
	public MypageDao(){}

	  // 게시글 리스트 조회
	public ArrayList<Community> selectList(Connection conn) {
	     
	      return null;
	   }
	
	
	//회원 정보 수정
	public int updateMember(Connection con, Member member){
		
		return 0;
	}
	
	
	//회원 탈퇴 
	public int deleteMember(Connection con, String userId) {
		
		return 0;
	}
}
