package mypage.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.*;
import mypage.model.service.MypageService;
/**
 * Servlet implementation class MemberUpdate
 */
@WebServlet("/mupdate")
public class MemberUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//회원 정보 수정용 컨트롤러
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		String mname = request.getParameter("mname");
		String mtel = request.getParameter("mtel");
		String memail = request.getParameter("memail");
		String mtime = request.getParameter("mtime");
		String mclass = request.getParameter("mclass");
		
		Member member = new Member( mid, mpw, mname, mtel, memail, mtime, mclass);
		System.out.println(member+ " =");
		int result = new MypageService().updateMember(member);
		System.out.println(result+ " =");
		RequestDispatcher rd = null;
		
		if(result > 0){
			
			Member smember = new MypageService().selectMember(mid);
			HttpSession session = request.getSession(false);
			session.removeAttribute("member");
			session.setAttribute("member", smember);
			
			response.sendRedirect("/acanity/mypageMain.jsp");
			
		}else{
			
			rd = request.getRequestDispatcher("views/member/memberError.jsp");
			request.setAttribute("message", "회원 정보 수정 실패!");
			rd.forward(request, response);
		}

	}

}
