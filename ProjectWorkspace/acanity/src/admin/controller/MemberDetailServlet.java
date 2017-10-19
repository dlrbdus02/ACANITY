package admin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import admin.model.service.AdminService;
import community.model.vo.Community;
import member.model.vo.Member;

/**
 * Servlet implementation class MemberDetailServlet
 */
@WebServlet("/admin/member/detail")
public class MemberDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberDetailServlet() {
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
		
		String id = request.getParameter("id");
		
		Member member = service.memberDetail(id);
		ArrayList<Community> communityList = service.memberCommunity(id);
		int postCount = service.memberPostCount(id);
		int groupCount = service.memberGroupCount(id);
		int meetingCount = service.memberMeetingCount(id);
		int keyGroupRate = service.memberKeyGroupRate(id);
		
		System.out.println("타마마 : " + communityList);
		
	    JSONObject json = new JSONObject();
	    JSONArray names = new JSONArray();
	    JSONArray value = new JSONArray();
	    
		for (Community community : communityList) {
			names.add(community.getCommunityName());
			value.add(service.memberMeetingRate(id, community.getCommunityNo()));
		}
		
		json.put("names", names);
		json.put("value", value);
		
		System.out.println(value);
		System.out.println(names);
		
		RequestDispatcher view = request.getRequestDispatcher("/views/admin/memberDetail.jsp");
		request.setAttribute("member", member);
		request.setAttribute("communityList", communityList);
		request.setAttribute("postCount", postCount);
		request.setAttribute("groupCount", groupCount);
		request.setAttribute("meetingCount", meetingCount);
		request.setAttribute("keyGroupRate", keyGroupRate);
		request.setAttribute("json", json);
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
