package community.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
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

		// 총 페이지 수 계산 : 목록이 최소 1개일 때는 한 페이지로 처리함
		// 페이지 1이 되려면 = 목록 0.1개 + 0.9 계산되게 함
		int maxPage = (int) ((double) listCount / limit + 0.9);

		// 현재 페이지가 13이면 화면에 보여줄 시작 페이지는 11로 지정
		// (1, 11, 21, 31, ...)
		int startPage = ((int) ((double) currentPage / limit + 0.9) - 1) * limit + 1;

		// 만약, 목록 아래에 보여질 페이지 개수가 10개이면 현재 페이지가 13이면 끝 페이지수는 20페이지가 되어야 함
		int endPage = startPage + limit - 1;

		// endPage는 maxPage보다 클 수 없다.
		if (maxPage < endPage)
			endPage = maxPage;

		RequestDispatcher view = null;
		if (list != null) {
			view = request.getRequestDispatcher("views/community/communityListView.jsp");
			request.setAttribute("list", list);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("maxPage", maxPage);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			request.setAttribute("listCount", listCount);
			view.forward(request, response);
		} else {
			view = request.getRequestDispatcher("views/community/communityError.jsp");
			request.setAttribute("message", "게시글 페이지별 조회 실패!");
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
