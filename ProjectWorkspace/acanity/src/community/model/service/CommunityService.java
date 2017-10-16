package community.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import community.model.dao.CommunityDao;
import community.model.vo.Community;

public class CommunityService {

	public int getListCount() {
		Connection con = getConnection();
		int listCount = new CommunityDao().getListCount(con);
		close(con);
		return listCount;
	}

	public ArrayList<Community> selectList(int currentPage, int limit) {
		Connection con = getConnection();
		ArrayList<Community> list = new CommunityDao().selectList(con, currentPage, limit);
		close(con);
		return list;
	}

	public int insertCommunity(Community c) {
		Connection con = getConnection();
		int result = new CommunityDao().insertCommunity(con, c);
		if(result > 0)
			commit(con);
		else
			rollback(con);
		close(con);
		return result;
	}

	public void addReadCount(int cnum) {
		Connection con = getConnection();
		int result = new CommunityDao().addReadCount(con, cnum);
		if(result > 0)
			commit(con);
		else
			rollback(con);
		close(con);
		return;
	}

	public Community selectCommunity(int cnum) {
		Connection con = getConnection();
		Community community = new CommunityDao().selectCommunity(con, cnum);
		close(con);
		return community;
	}

	public int updateCommunity(Community c) {
		Connection con = getConnection();
		int result = new CommunityDao().updateBoard(con, c);
		if(result > 0)
			commit(con);
		else
			rollback(con);
		close(con);
		return result;
	}

	public int deleteBoard(int cnum) {
		Connection con = getConnection();
		int result = new CommunityDao().deleteBoard(con, cnum);
		if(result > 0)
			commit(con);
		else
			rollback(con);
		close(con);
		return result;
	}

}
