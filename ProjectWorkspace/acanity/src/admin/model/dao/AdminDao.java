package admin.model.dao;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import History.model.vo.History;
import admin.controller.adCommunityListServlet;
import community.model.vo.Community;
import community.model.vo.Vote;
import member.model.vo.Member;
import post.model.vo.Post;

public class AdminDao {
	
	public AdminDao() {}

	// 전체 회원수
	public int memberCount(Connection con) {
		int result = 0;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select count(*) from member";
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			rs.next();
			result = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
		}
		return result;
	}

	// 전체 게시글 수 
	public int postCount(Connection con) {
		int result = 0;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select count(*) from post";
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			rs.next();
			result = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
		}
		return result;
	}

	// 전체 모임 수 
	public int communityCount(Connection con) {
		int result = 0;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select count(*) from community";
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			rs.next();
			result = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
		}
		return result;
	}

	// 전체 만남 수
	public int meetingCount(Connection con) {
		int result = 0;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select count(*) from c_history";
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			rs.next();
			result = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
		}
		return result;
	}

	// 전체 회원 출력
	public ArrayList<Member> memberAll(Connection con) {
		ArrayList<Member> memberList = new ArrayList<Member>();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from member";
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				Member member = new Member();
				member.setmId(rs.getString("m_id"));
				member.setmPwd(rs.getString("m_pw"));
				member.setmName(rs.getString("m_name"));
				member.setmClass(rs.getString("m_class"));
				member.setmTime(rs.getString("m_time"));
				member.setmTel(rs.getString("m_tel"));
				member.setmEmail(rs.getString("m_email"));
				
				memberList.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
		}
		
		return memberList;
	}

	// 회원 상세 정보
	public Member memberDetail(Connection con, String id) {
		Member member = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member where m_id = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				member = new Member();
				member.setmId(rs.getString("m_id"));
				member.setmPwd(rs.getString("m_pw"));
				member.setmName(rs.getString("m_name"));
				member.setmClass(rs.getString("m_class"));
				member.setmTime(rs.getString("m_time"));
				member.setmTel(rs.getString("m_tel"));
				member.setmEmail(rs.getString("m_email"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return member;
	}

	// 회원이 가입한 그룹 리스트
	public ArrayList<Community> memberCommunity(Connection con, String id) {
		ArrayList<Community> communityList = null;
		Community community = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select c_no, c_category, c_name, c_j_date, c_id " + 
					 "from c_join " + 
					 "join COMMUNITY on (c_j_no = c_no) " + 
					 "where c_id = ? " + 
					 "order by c_j_no";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs != null) {
				communityList = new ArrayList<Community>();
				
				while(rs.next()) {
					community = new Community();
					community.setCommunityNo(rs.getInt("c_no"));
					community.setCommunityCategory(rs.getString("c_category"));
					community.setCommunityName(rs.getString("c_name"));
					community.setCommunityId(rs.getString("c_id"));
					community.setCommunityStartDate(rs.getDate("c_j_date")); // 음 이거 잘못됬어.. 가입날짜를 시작날짜로 넣어서 해결했는데 해결 방법 고민해보장.
					communityList.add(community);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return communityList;
	}

	// 회원이 작성한 게시글 수
	public int memberPostCount(Connection con, String id) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select count(*) from post where p_id = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			rs.next();
			result = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}

	// 회원이 가입한 그룹 수
	public int memberGroupCount(Connection con, String id) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select count(*) from c_join where c_j_id = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			rs.next();
			result = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}

	// 회원이 참석한 미팅 수
	public int memberMeetingCount(Connection con, String id) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select count(*) from attend where a_id = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			rs.next();
			result = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}

	public int memberKeyGroupRate(Connection con, String id) {
		// 자기가 가입한 날 이후로 그룹에서 진행한 모임의 수
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select count(*) " + 
					 "from c_history " + 
				     "join c_join on (c_j_no = c_h_no) " + 
				     "where c_h_no = (select c_j_no " + 
				     "from (select rownum, c_j_no " + 
				     "      from c_join " + 
				     "      where c_j_id = ? " + 
				     "      order by c_j_date asc) " + 
				     "where rownum = 1) " + 
				     "and c_j_date <= c_h_date";
		
		// 자신이 가입한 가장 오래된 그룹에서의 자신의 참여기록
		PreparedStatement pstmt2 = null;
		ResultSet rs2 = null;
		String sql2 = "select count(*) " + 
					  "from attend " + 
					  "where a_no = (select c_j_no " + 
					  "from (select rownum, c_j_no " + 
					  "      from c_join " + 
					  "      where c_j_id = ? " + 
					  "      order by c_j_date asc) " + 
					  "where rownum = 1)";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			rs.next();
			
			pstmt2 = con.prepareStatement(sql2);
			pstmt2.setString(1, id);
			rs2 = pstmt2.executeQuery();
			rs2.next();
			if(rs.getInt(1) != 0)
				result = (rs2.getInt(1) / rs.getInt(1)) * 100;
			else
				result = 0;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(pstmt2);
			close(rs);
			close(rs2);
		}
		
		return result;
	}

	// 전체 그룹 출력
	public ArrayList<Community> communityAll(Connection con) {
		ArrayList<Community> communityList = new ArrayList<Community>();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from community";
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				Community community = new Community();
				community.setCommunityNo(rs.getInt("c_no"));
				community.setCommunityCategory(rs.getString("c_category"));
				community.setCommunityName(rs.getString("c_name"));
				community.setCommunityClass(rs.getString("c_class"));
				community.setCommunityTime(rs.getString("c_time"));
				communityList.add(community);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
		}
		
		return communityList;
	}

	// 그룹 상세 보기
	public Community communityDetail(Connection con, String no) {
		Community community = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from community where c_no = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, no);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				community = new Community();
				community.setCommunityNo(rs.getInt("c_no"));
				community.setCommunityCategory(rs.getString("c_category"));
				community.setCommunityName(rs.getString("c_name"));
				community.setCommunityClass(rs.getString("c_class"));
				community.setCommunityTime(rs.getString("c_time"));
				community.setCommunityImgUrl(rs.getString("c_imgurl"));
				community.setCommunityContent(rs.getString("c_content"));
				community.setCommunityId(rs.getString("c_id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return community;
	}

	// 해당 그룹의 만남 출력
	public ArrayList<History> communityMeeting(Connection con, String no) {
		ArrayList<History> meetingList = new ArrayList<History>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from c_history where c_h_no = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, no);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				History history = new History();
				history.setChDate(rs.getDate("c_h_date"));
				history.setChNo(rs.getInt("c_h_no"));
				history.setChPlace(rs.getString("c_h_place"));
				/*history.setChTime(rs.getDate("c_h_time")); 나중에 처리하기*/ 
				meetingList.add(history);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return meetingList;
	}

	// 해당 그룹 멤버 수
	public int communityMemberCount(Connection con, String no) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select count(*) from c_join where c_j_no = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, no);
			rs = pstmt.executeQuery();
			rs.next();
			result = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}

	// 해당 그룹 만남 수
	public int communityMeetingCount(Connection con, String no) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select count(*) from c_history where c_h_no = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, no);
			rs = pstmt.executeQuery();
			rs.next();
			result = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}

	// 날짜를 입력받고 그 날짜에 대한 방문수 리턴
	public int visitorCount(Connection con, String date) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select count(*) from visitor where to_char(v_date, 'yy/fmMM/dd') = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, date);
			rs = pstmt.executeQuery();
			rs.next();
			result = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		} 
		return result;
	}

	// 오늘 날짜에 기록된 ip가 있는지 여부
	public int existDate(Connection con, String checkIp, String checkDate) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select count(*) from visitor where ip = ? and to_char(v_date, 'yy/fmMM/dd') = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, checkIp);
			pstmt.setString(2, checkDate);
			rs = pstmt.executeQuery();
			rs.next();
			result = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}

	// 아이피, 날짜 삽입
	public int insertDate(Connection con, String checkIp, String checkDate) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = "insert into visitor values(? ,?)";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, checkIp);
			pstmt.setString(2, checkDate);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	// 회원이 참여한 총 만남 중 각 그룹의 만남 비율
	public int memberMeetingRate(Connection con, String id, int no) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select count(*) from attend where a_id = ? and a_no = ?";
		System.out.println(id);
		System.out.println(no);
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, no);
			rs = pstmt.executeQuery();
			rs.next();
			result = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		System.out.println(result);
		return result;
	}
	
	// 이전 달의 출석수가 높은 회원 5명 추출
	public ArrayList<Member> topAttendMember(Connection con) {
		ArrayList<Member> memberList = new ArrayList<Member>();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT m_id, " + 
					 "       m_name, " + 
					 "       m_class, " + 
					 "       m_time, " + 
					 "       attend " + 
					 "FROM   member " + 
					 "       right join (SELECT a_id, " + 
					 "                          attend " + 
					 "                   FROM  (SELECT ROWNUM, " + 
					 "                                 a_id, " + 
					 "                                 attend " + 
					 "                          FROM  (SELECT a_id, " + 
					 "                                        Count(*) attend " + 
					 "                                 FROM   attend " + 
					 "                                 WHERE  Extract(month FROM a_date) = " + 
					 "                                        Extract(month FROM SYSDATE) - 1 " + 
					 "                                 GROUP  BY a_id " + 
					 "                                 ORDER  BY Count(*) DESC)) " + 
					 "                   WHERE  ROWNUM <= 5) " + 
				 	 "               ON ( m_id = a_id )";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				Member member = new Member();
				member.setmId(rs.getString("m_id"));
				member.setmName(rs.getString("m_name"));
				member.setmClass(rs.getString("m_class"));
				member.setmTime(rs.getString("m_time"));
				member.setmEmail(rs.getString("attend")); // attend 저장
				
				memberList.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
		}
		
		return memberList;
	}

	// 오늘 올라온 채용 공고
	public ArrayList<Community> todayRecruitCommunity(Connection con) {
		ArrayList<Community> communityList = new ArrayList<Community>();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * " + 
					 "FROM   community " + 
					 "WHERE  Extract(month FROM c_start_date) = Extract(month FROM SYSDATE) " + 
					 "       AND Extract(day FROM c_start_date) = Extract(day FROM SYSDATE)";
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Community community = new Community();
				community.setCommunityNo(rs.getInt("c_no"));
				community.setCommunityCategory(rs.getString("c_category"));
				community.setCommunityName(rs.getString("c_name"));
				community.setCommunityClass(rs.getString("c_class"));
				community.setCommunityTime(rs.getString("c_time"));
				community.setCommunityEndDate(rs.getDate("c_end_date"));
				community.setCommunityImgUrl(rs.getString("c_imgurl"));
				community.setCommunityLimit(rs.getInt("c_limit"));
				communityList.add(community);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
		}
		
		return communityList;
	}

	// 커뮤니티에 가입한 회원 출력
	public ArrayList<Member> communityMemberAll(Connection con, int no) {
		ArrayList<Member> memberList = new ArrayList<Member>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT c_j_id, " + 
					 "       c_j_date " + 
					 "FROM   community " + 
					 "       join c_join " + 
					 "         ON ( c_no = c_j_no ) " + 
					 "WHERE  c_no = ? ";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Member member = new Member();
				member.setmId(rs.getString("c_j_id"));
				member.setmEmail(rs.getString("c_j_date")); // 원래는 email이지만 현재는 가입날짜(c_j_date)를 넣었다.
				
				memberList.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return memberList;
	}
	
	// 전체 QnA 게시글 출력
	public ArrayList<Post> qnaAll(Connection con) {
		ArrayList<Post> qnaList = new ArrayList<Post>();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT P_NO,  " + 
					 "       P_DEPTH,  " + 
					 "       P_TITLE,  " + 
					 "       P_READCOUNT,  " + 
					 "       P_DATE,  " + 
					 "       P_ID,  " + 
					 "       CASE  " + 
					 "         WHEN EXISTS (SELECT *  " + 
					 "                      FROM   POST B  " + 
					 "                      WHERE  A.P_REFNO = B.P_REFNO  " + 
					 "                             AND MOD((SELECT MAX(C.P_DEPTH)  " + 
					 "                                      FROM   POST C  " + 
					 "                                      WHERE  C.P_REFNO = B.P_REFNO), 2) = 1)  " + 
					 "       THEN 'N'  " + 
					 "         ELSE 'Y'  " + 
					 "       END reply  " + 
					 "FROM   POST A  " + 
					 "WHERE  A.P_CODE = 1  " + 
					 "       AND A.P_DEPTH = 1";
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Post qna = new Post();
				qna.setDepth(rs.getInt("p_depth"));
				qna.setpNo(rs.getInt("p_no"));
				qna.setpTitle(rs.getString("p_title"));
				qna.setReadCount(rs.getInt("p_readcount"));
				qna.setpDate(rs.getDate("p_date"));
				qna.setpId(rs.getString("p_id"));
				qna.setOriginalFileName(rs.getString("reply")); // 답변이 달린 여부를 이걸로 대체... Y면 달렸고 N 이면 안달렸어
				
				qnaList.add(qna);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
		}
		
		return qnaList;
	}

	// QnA 게시글 수
	public int qnaCount(Connection con) {
		int result = 0;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select count(*) from post where p_code = 1 and p_depth = 1";
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			rs.next();
			result = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
		}
		return result;
	}

	// QnA 상세보기
	public ArrayList<Post> qnaDetail(Connection con, int no) {
		ArrayList<Post> qnaList = new ArrayList<Post>();
		Post qna = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from post where p_refno = ? order by p_depth asc";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				qna = new Post();
				qna.setDepth(rs.getInt("p_depth"));
				qna.setOriginalFileName(rs.getString("p_originalfilename"));
				qna.setpCode(rs.getInt("p_code"));
				qna.setpContent(rs.getString("p_content"));
				qna.setpDate(rs.getDate("p_date"));
				qna.setpId(rs.getString("p_id"));
				qna.setpNo(rs.getInt("p_no"));
				qna.setpOpen(rs.getInt("p_open"));
				qna.setpTitle(rs.getString("p_title"));
				qna.setReadCount(rs.getInt("p_readcount"));
				qna.setRefNo(rs.getInt("p_refno"));
				qna.setRenameFileName(rs.getString("p_renamefilename"));
				
				qnaList.add(qna);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return qnaList;
	}

	// QnA 조회수 증가
	public int qnaRead(Connection con, int no) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = "update post set p_readcount = p_readcount + 1 where p_refno = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	// QnA 답변 등록
	public void qnaInsert(Connection con, int no, String content) {
		PreparedStatement pstmt = null;
		String sql = "insert into post values((select max(p_no) + 1 from post), 1, (select p_title from post where p_no = ?), ?, "
			       + "0, sysdate, (select p_open from post where p_no = ?), (select p_pw from post where p_no = ?), null, null, 'admin', "
			       + "(select max(p_depth) + 1 from post where p_refno = ?), ?, null)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.setString(2, content);
			pstmt.setInt(3, no);
			pstmt.setInt(4, no);
			pstmt.setInt(5, no);
			pstmt.setInt(6, no);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
	}

	// 그룹에서 진행된 투표리스트 출력
	public ArrayList<Vote> communityVoteAll(Connection con, int no) {
		ArrayList<Vote> voteList = new ArrayList<Vote>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT DISTINCT V_NO,  " + 
					 "                V_TITLE,  " + 
					 "                V_END_DATE,  " + 
					 "                V_START_DATE,  " + 
					 "                (SELECT COUNT(*)  " + 
					 "                 FROM   VOTERESULT VR  " + 
					 "                 GROUP  BY VR_NO  " + 
					 "                 HAVING V.V_NO = VR_NO) count  " + 
					 "FROM   VOTE V  " + 
					 "       JOIN VOTERESULT R  " + 
					 "         ON( V.V_NO = R.VR_NO )  " + 
					 "WHERE  V.V_C_NO = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Vote vote = new Vote();
				vote.setVoteNo(rs.getInt("v_no"));
				vote.setVoteTitle(rs.getString("v_title"));
				vote.setVoteStartDate(rs.getDate("v_start_date"));
				vote.setVoteEndDate(rs.getDate("v_end_date"));
				vote.setVoteResultNo(rs.getInt("count")); // 투표자 수 
				voteList.add(vote);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return voteList;
	}
	
	// 투표 항목별 값 차트
	public ArrayList<Vote> voteResultChart(Connection con, int no) {
		ArrayList<Vote> voteList = new ArrayList<Vote>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT VR_SELECT,  " + 
				     "       COUNT(*) count  " + 
				     "FROM   VOTERESULT  " + 
				     "WHERE  VR_NO = ?  " + 
				     "GROUP  BY VR_SELECT";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Vote vote = new Vote();
				vote.setVoteItemSelect(rs.getString("vr_select"));
				vote.setVoteResultNo(rs.getInt("count")); // 항목에 투표한 사람의 수 
				voteList.add(vote);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		System.out.println(voteList);
		System.out.println(voteList.size());
		return voteList;
	}
	
	
}


