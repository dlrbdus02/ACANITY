package post.model.vo;

import java.sql.Date;

public class Post implements java.io.Serializable {
   
   // Field
   private int pNo;      //게시글 번호
   private String pCode;   //분류 코드(QnA게시글:1, 자료공유게시글:2)
   private String pTitle;   //제목
   private String pContent;//내용
   private int readCount;   //조회수
   private Date pDate;      //작성일
   private String pOpen;   //공개여부
   private String pPw;      //비밀번호
   private String originalFileName;   //원래 파일명
   private String renameFileName;      //수정 파일명
   private String pId;      //작성자
   private int depth;      //깊이(0:자주묻는질문, 1:게시물, 2:댓글)
   private int refNo;      //참조글번호
   
   private static final long serialVersionUID = 10000L;   //직렬화 아이디
   
   // Constructor : default
   public Post(){}

   // Constructor : all
   public Post(int pNo, String pCode, String pTitle, String pContent, int readCount, Date pDate, String pOpen,
         String pPw, String originalFileName, String renameFileName, String pId, int depth, int refNo) {
      super();
      this.pNo = pNo;
      this.pCode = pCode;
      this.pTitle = pTitle;
      this.pContent = pContent;
      this.readCount = readCount;
      this.pDate = pDate;
      this.pOpen = pOpen;
      this.pPw = pPw;
      this.originalFileName = originalFileName;
      this.renameFileName = renameFileName;
      this.pId = pId;
      this.depth = depth;
      this.refNo = refNo;
   }

   // Getter & Setter
   public int getpNo() {
      return pNo;
   }

   public void setpNo(int pNo) {
      this.pNo = pNo;
   }

   public String getpCode() {
      return pCode;
   }

   public void setpCode(String pCode) {
      this.pCode = pCode;
   }

   public String getpTitle() {
      return pTitle;
   }

   public void setpTitle(String pTitle) {
      this.pTitle = pTitle;
   }

   public String getpContent() {
      return pContent;
   }

   public void setpContent(String pContent) {
      this.pContent = pContent;
   }

   public int getReadCount() {
      return readCount;
   }

   public void setReadCount(int readCount) {
      this.readCount = readCount;
   }

   public Date getpDate() {
      return pDate;
   }

   public void setpDate(Date pDate) {
      this.pDate = pDate;
   }

   public String getpOpen() {
      return pOpen;
   }

   public void setpOpen(String pOpen) {
      this.pOpen = pOpen;
   }

   public String getpPw() {
      return pPw;
   }

   public void setpPw(String pPw) {
      this.pPw = pPw;
   }

   public String getOriginalFileName() {
      return originalFileName;
   }

   public void setOriginalFileName(String originalFileName) {
      this.originalFileName = originalFileName;
   }

   public String getRenameFileName() {
      return renameFileName;
   }

   public void setRenameFileName(String renameFileName) {
      this.renameFileName = renameFileName;
   }

   public String getpId() {
      return pId;
   }

   public void setpId(String pId) {
      this.pId = pId;
   }

   public int getDepth() {
      return depth;
   }

   public void setDepth(int depth) {
      this.depth = depth;
   }

   public int getRefNo() {
      return refNo;
   }

   public void setRefNo(int refNo) {
      this.refNo = refNo;
   }
   
   @Override
   public String toString(){
      return pNo + ", " + pCode + ", " + pTitle + ", " + pContent + ", " + readCount + ", " +
            pDate + ", " + pOpen + ", " + pPw + ", " + originalFileName + ", " + renameFileName + ", " +
            pId + ", " + depth + ", " + refNo;
   }

}