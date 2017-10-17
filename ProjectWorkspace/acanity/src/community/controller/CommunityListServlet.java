package community.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import community.model.service.CommunityService;
import community.model.vo.Community;

/**
 * Servlet implementation class CommunityListServlet
 */
@WebServlet("/clist")
public class CommunityListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CommunityListServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 페이지 단위로 게시글 목록 조회 처리용 컨트롤러
		response.setContentType("text/html; charset=utf-8");

		// 페이지 처리용
		int currentPage = 1;

		// 한 페이지에 출력할 페이지 개수 지정
		int limit = 10;

		// 페이지 숫자가 전송이 왔을 경우
		if (request.getParameter("page") != null)
			currentPage = Integer.parseInt(request.getParameter("page"));

		CommunityService cservice = new CommunityService();

		// 전체 목록 개수 조회함
		int listCount = cservice.getListCount();

		// 해당 페이지용 목록 조회
		ArrayList<Community> list = cservice.selectList(currentPage, limit);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
