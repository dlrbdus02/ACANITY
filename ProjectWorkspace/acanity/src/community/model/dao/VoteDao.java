package community.model.dao;

import java.sql.Connection;

import community.model.vo.Vote;

public class VoteDao {

	public int insertVote(Connection con, Vote v) {
		return 0;
	}

	public Vote selectVote(Connection con, int vnum) {
		return null;
	}

	public int updateVote(Connection con, Vote v) {
		return 0;
	}

	public Vote resultVote(Connection con, int vnum) {
		return null;
	}

	public int deleteVote(Connection con, int vnum) {
		return 0;
	}

}
