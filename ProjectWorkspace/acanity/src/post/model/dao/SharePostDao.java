package post.model.dao;

import java.sql.*;
import java.util.*;

import post.model.vo.Post;
import static common.JDBCTemplate.*;

public class SharePostDao {
   
   //Constructor : default
   public SharePostDao(){}

   public ArrayList<Post> selectList(Connection conn) {
      // 게시글 리스트 조회
      return null;
   }

   public ArrayList<Post> selectSearch(Connection conn, String title) {
      // 게시글 제목으로 검색 조회
      return null;
   }

   public Post selectPost(Connection conn, int no) {
      // 게시글 상세 조회
      return null;
   }

   public int insertPost(Connection conn, Post post) {
      // 게시글/댓글 등록
      return 0;
   }

   public int updatePost(Connection conn, Post post) {
      // 게시글/댓글 수정
      return 0;
   }

   public int deletePost(Connection conn, int no, int depth) {
      // 게시글/댓글 삭제
      return 0;
   }

   public int addReadCount(Connection conn, int no) {
      // 게시글 조회수 1 증가
      
      return 0;
   }


}