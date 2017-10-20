package community.model.dao;

import static common.JDBCTemplate.close;

import java.sql.*;
import java.util.ArrayList;

import community.model.vo.Community;

public class CommunityDao {

	public int getListCount(Connection con) {
		int result = 0;
		Statement stmt = null;
		ResultSet rset = null;

		String query = "select count(*) from community";

		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);

			if (rset.next())
				result = rset.getInt(1);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}

		return result;
	}

	public ArrayList<Community> selectList(Connection con, int currentPage, int limit) {
		ArrayList<Community> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		// currentPage 에 해당되는 목록만 조회
		String query = "select * from (" + "select rownum rnum, c_no, c_name, " + "c_class, c_title, c_category, "
				+ "c_start_date, c_end_date, c_limit, " + "c_imgurl, c_content, c_id, " + "c_readcount from community) "
				+ "where rnum >= ? and rnum <= ?";

		int startRow = (currentPage - 1) * limit + 1;
		int endRow = startRow + limit - 1;

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);

			rset = pstmt.executeQuery();

			if (rset != null) {
				list = new ArrayList<Community>();

				while (rset.next()) {
					Community c = new Community();

					c.setCommunityNo(rset.getInt("c_no"));
					c.setCommunityName(rset.getString("c_name"));
					c.setCommunityClass(rset.getString("c_class"));
					c.setCommunityName(rset.getString("c_title"));
					c.setCommunityCategory(rset.getString("c_category"));
					c.setCommunityStartDate(rset.getDate("c_start_date"));
					c.setCommunityEndDate(rset.getDate("c_end_date"));
					c.setCommunityLimit(rset.getInt("c_limit"));
					c.setCommunityImgUrl(rset.getString("c_imgurl"));
					c.setCommunityContent(rset.getString("c_content"));
					c.setCommunityId(rset.getString("c_id"));
					c.setCommunityReadCount(rset.getInt("c_readcount"));

					list.add(c);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public int insertCommunity(Connection con, Community c) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = "insert into community values "
				+ "((select max(c_no) + 1 from community), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, default)";

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, c.getCommunityName());
			pstmt.setString(2, c.getCommunityClass());
			pstmt.setString(3, c.getCommunityCategory());
			pstmt.setDate(4, c.getCommunityStartDate());
			pstmt.setDate(5, c.getCommunityEndDate());
			pstmt.setInt(6, c.getCommunityLimit());
			pstmt.setString(7, c.getCommunityImgUrl());
			pstmt.setString(8, c.getCommunityContent());
			pstmt.setString(8, c.getCommunityId());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int addReadCount(Connection con, int cnum) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = "update community set c_readcount = c_readcount + 1 where c_no = ?";

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, cnum);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public Community selectCommunity(Connection con, int cnum) {
		Community community = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * from community where c_no = ?";

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, cnum);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				community = new Community();
				community.setCommunityNo(rset.getInt("c_no"));
				community.setCommunityName(rset.getString("c_name"));
				community.setCommunityClass(rset.getString("c_class"));
				community.setCommunityName(rset.getString("c_title"));
				community.setCommunityCategory(rset.getString("c_category"));
				community.setCommunityStartDate(rset.getDate("c_start_date"));
				community.setCommunityEndDate(rset.getDate("c_end_date"));
				community.setCommunityLimit(rset.getInt("c_limit"));
				community.setCommunityImgUrl(rset.getString("c_imgurl"));
				community.setCommunityContent(rset.getString("c_content"));
				community.setCommunityId(rset.getString("c_id"));
				community.setCommunityReadCount(rset.getInt("c_readcount"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return community;
	}

	public int updateBoard(Connection con, Community c) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = "update community set c_name = ?, " + "c_class = ?, " + "c_time = ?, c_category = ?"
				+ "c_start_date = ?, c_end_date = ?, c_limit = ?, c_imgurl = ?, c_content = ?" + "where c_no = ?";

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, c.getCommunityName());
			pstmt.setString(2, c.getCommunityClass());
			pstmt.setString(3, c.getCommunityTime());
			pstmt.setString(4, c.getCommunityCategory());
			pstmt.setDate(5, c.getCommunityStartDate());
			pstmt.setDate(6, c.getCommunityEndDate());
			pstmt.setInt(7, c.getCommunityLimit());
			pstmt.setString(8, c.getCommunityImgUrl());
			pstmt.setString(9, c.getCommunityContent());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int deleteBoard(Connection con, int cnum) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = "delete from community where c_no = ?";

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, cnum);

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

}
