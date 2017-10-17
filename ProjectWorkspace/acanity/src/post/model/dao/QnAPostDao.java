package post.model.dao;

import java.sql.*;
import java.util.*;

import post.model.vo.Post;
import static common.JDBCTemplate.*;

public class QnAPostDao {

   //Constructor : default
   public QnAPostDao(){}

   public ArrayList<Post> selectQnAList(Connection conn) {
      // QnA ����Ʈ��ȸ
      return null;
   }

   public ArrayList<Post> selectQnASearch(Connection conn, String title) {
      // QnA �˻���ȸ
      return null;
   }

   public Post selectQnAPost(Connection conn, int no) {
      // QnA ����ȸ
      return null;
   }

   public int insertQnAPost(Connection conn, Post post) {
      // QnA ��۵��
      return 0;
   }

   public int updateQnAPost(Connection conn, Post post) {
      // QnA ��ۼ���
      return 0;
   }

   public int deleteQnAPost(Connection conn, int no, int depth) {
      // QnA ��ۻ���
      return 0;
   }

   public int addReadCount(Connection conn, int no) {
      int result = 0;
      PreparedStatement pstmt = null;
      
      String query = "update post set "
            + "p_count = p_count + 1 "
            + "where p_no = ?";
      
      try {
         pstmt = conn.prepareStatement(query);
         pstmt.setInt(1, no);
         
         result = pstmt.executeUpdate();
         
      } catch (Exception e) {
         e.printStackTrace();
      }finally{
         close(pstmt);
      }
      
      return result;
   }
   

}