package community.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import community.model.service.CommunityService;
import community.model.vo.Community;

/**
 * Servlet implementation class CommunityDetailServlet
 */
@WebServlet("/cdetail")
public class CommunityDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommunityDetailServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		
		int cnum = Integer.parseInt(request.getParameter("cnum"));
		int currentPage = Integer.parseInt(request.getParameter("page"));
		
		CommunityService cservice = new CommunityService();
		
		// 해당 게시글에 대한 조회수 1증가 처리
		cservice.addReadCount(cnum);
		
		// 해당 게시글 정보 결과 리턴받음
		Community community = cservice.selectCommunity(cnum);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
