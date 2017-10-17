package community.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;

import community.model.dao.VoteDao;
import community.model.vo.Vote;

public class VoteService {

	public int insertVote(Vote v) {
		Connection con = getConnection();
		int result = new VoteDao().insertVote(con, v);
		if(result > 0)
			commit(con);
		else
			rollback(con);
		close(con);
		return result;
	}

	public Vote selectVote(int vnum) {
		Connection con = getConnection();
		Vote vote = new VoteDao().selectVote(con, vnum);
		close(con);
		return vote;
	}

	public int updateVote(Vote v) {
		Connection con = getConnection();
		int result = new VoteDao().updateVote(con, v);
		if(result > 0)
			commit(con);
		else
			rollback(con);
		close(con);
		return result;
	}

	public Vote resultVote(int vnum) {
		Connection con = getConnection();
		Vote vote = new VoteDao().resultVote(con, vnum);
		close(con);
		return vote;
	}

	public int deleteVote(int vnum) {
		Connection con = getConnection();
		int result = new VoteDao().deleteVote(con, vnum);
		if(result > 0)
			commit(con);
		else
			rollback(con);
		close(con);
		return result;
	}

}
