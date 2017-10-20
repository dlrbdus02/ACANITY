package community.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import community.model.service.CommunityService;
import community.model.vo.Community;

/**
 * Servlet implementation class CommunityInsertServlet
 */
@WebServlet("/cinsert")
public class CommunityInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CommunityInsertServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 게시글 원글 등록 처리용 컨트롤러
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		RequestDispatcher view = null;
		
		Community c = null;

		// 처리결과에 따라 뷰 지정함
		if (new CommunityService().insertCommunity(c) > 0) {
			response.sendRedirect("/acanity/clist?page=1");
		} else {
			view = request.getRequestDispatcher("views/community/communityError.jsp");
			request.setAttribute("message", "Board 서비스 : 원글 등록 실패!");
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
