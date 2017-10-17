package post.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import post.model.service.SharePostService;
import post.model.vo.Post;

@WebServlet("/splist")
public class SharePostListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SharePostListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파일 공유 게시판 : 게시글 리스트 보기 처리용 컨트롤러
		
		ArrayList<Post> list = new SharePostService().selectList();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
