package community.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;

import community.model.dao.AttendDao;
import community.model.vo.Attend;

public class AttendService {

	public int insertAttend(Attend a) {
		Connection con = getConnection();
		int result = new AttendDao().insertAttend(con, a);
		if(result > 0)
			commit(con);
		else
			rollback(con);
		close(con);
		return result;
	}

	public Attend selectAttend(int anum) {
		Connection con = getConnection();
		Attend attend = new AttendDao().selectAttend(con, anum);
		close(con);
		return attend;
	}

	public int updateAttend(Attend a) {
		Connection con = getConnection();
		int result = new AttendDao().updateAttend(con, a);
		if(result > 0)
			commit(con);
		else
			rollback(con);
		close(con);
		return result;
	}

	public int deleteAttend(int anum) {
		Connection con = getConnection();
		int result = new AttendDao().deleteAttend(con, anum);
		if(result > 0)
			commit(con);
		else
			rollback(con);
		close(con);
		return result;
	}

}
