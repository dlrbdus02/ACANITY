package admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import History.model.vo.History;
import admin.model.service.AdminService;
import community.model.vo.Community;
import member.model.vo.Member;

/**
 * Servlet implementation class adCommunityDetailServlet
 */
@WebServlet("/admin/community/detail")
public class adCommunityDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adCommunityDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		AdminService service = new AdminService();
		
		String no = request.getParameter("no");
		
		Community community = service.communityDetail(no);
		ArrayList<History> meetingList = service.communityMeeting(no);
		int memberCount = service.communityMemberCount(no);
		int meetingCount = service.communityMeetingCount(no);
		ArrayList<Member> memberList = service.communityMemberAll(Integer.parseInt(no));
		
		
		RequestDispatcher view = request.getRequestDispatcher("/views/admin/communityDetail.jsp");
		request.setAttribute("community", community);
		request.setAttribute("meetingList", meetingList);
		request.setAttribute("memberCount", memberCount);
		request.setAttribute("meetingCount", meetingCount);
		request.setAttribute("memberList", memberList);
		System.out.println(memberList);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
