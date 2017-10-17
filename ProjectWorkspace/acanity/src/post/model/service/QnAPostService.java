package post.model.service;

import java.sql.*;
import java.util.*;

import post.model.dao.QnAPostDao;
import post.model.dao.SharePostDao;
import post.model.vo.Post;
import static common.JDBCTemplate.*;

public class QnAPostService {

   //Constructor : default
   public QnAPostService(){}
   
   // QnA ��ü ����Ʈ �ҷ�����
      public ArrayList<Post> selectList(){
         Connection conn = getConnection();
         ArrayList<Post> list = new QnAPostDao().selectQnAList(conn);
         close(conn);      
         return list;
      }
      
      // QnA �������� �˻��� ����Ʈ �ҷ�����
      public ArrayList<Post> selectSearch(String title){
         Connection conn = getConnection();
         ArrayList<Post> list = new QnAPostDao().selectQnASearch(conn, title);
         close(conn);
         return list;
      }
      
      // QnA  �󼼺���
      public Post selectPost(int no){
         Connection conn = getConnection();
         Post post = new QnAPostDao().selectQnAPost(conn, no);
         close(conn);
         return post;
      }
      
      // QnA or ��� ���
      public int insertPost(Post post){
         Connection conn = getConnection();
         int result = new QnAPostDao().insertQnAPost(conn, post);
         if (result > 0)
            commit(conn);
         else
            rollback(conn);
         close(conn);
         return result;
      }
      
      // QnA or ��� ����
      public int updatePost(Post post){
         Connection conn = getConnection();
         int result = new QnAPostDao().updateQnAPost(conn, post);
         if (result > 0)
            commit(conn);
         else
            rollback(conn);
         close(conn);
         return result;
      }
      
      // QnA or ��� ����
      public int deletePost(int no, int depth){
         Connection conn = getConnection();
         int result = new QnAPostDao().deleteQnAPost(conn, no, depth);
         if (result > 0)
            commit(conn);
         else
            rollback(conn);
         close(conn);
         return result;
      }
      
      // ��ȸ�� 1 ����
      public void addReadCount(int no) {
         Connection conn = getConnection();
         int result = new QnAPostDao().addReadCount(conn, no);
         if(result > 0)
            commit(conn);
         else
            rollback(conn);
         close(conn);
      }
}