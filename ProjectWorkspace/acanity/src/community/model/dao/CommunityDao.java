package community.model.dao;

import java.sql.Connection;
import java.util.ArrayList;

import community.model.vo.Community;

public class CommunityDao {

	public int getListCount(Connection con) {
		return 0;
	}

	public ArrayList<Community> selectList(Connection con, int currentPage, int limit) {
		return null;
	}

	public int insertCommunity(Connection con, Community c) {
		return 0;
	}

	public int addReadCount(Connection con, int cnum) {
		return 0;
	}

	public Community selectCommunity(Connection con, int cnum) {
		return null;
	}

	public int updateBoard(Connection con, Community c) {
		return 0;
	}

	public int deleteBoard(Connection con, int cnum) {
		return 0;
	}

}
