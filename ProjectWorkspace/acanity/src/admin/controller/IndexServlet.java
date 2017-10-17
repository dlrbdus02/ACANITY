package admin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

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
 * Servlet implementation class IndexServlet
 */
@WebServlet("/admin/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		AdminService service = new AdminService();
	
		int memberCount = service.memberCount();
		int postCount = service.postCount();
		int communityCount = service.communityCount();
		int meetingCount = service.meetingCount();
		
	    JSONObject json = new JSONObject();
	    JSONArray date = new JSONArray();
	    JSONArray value = new JSONArray();
	    
	    Calendar cal = new GregorianCalendar();
	    
	    String checkIp = request.getRemoteAddr();
	    String checkDate = (cal.get(Calendar.YEAR) - 2000) + "/" + (cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.DATE);

	    int checkResult = service.existDate(checkIp, checkDate);
	    
	    if(checkResult == 0)
	    	service.insertDate(checkIp, checkDate);
	    
	    cal.add(Calendar.DATE, -13);
	    date.add((cal.get(Calendar.YEAR) - 2000) + "/" + (cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.DATE));
	    
	    value.add(service.visitorCount((cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.DATE)));
	    
	    for (int i = 1; i < 14; i++) {
	    	cal.add(Calendar.DATE, 1);
	    	date.add((cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.DATE));
	    	value.add(service.visitorCount((cal.get(Calendar.YEAR) - 2000) + "/" + (cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.DATE)));
		}
	    
	    System.out.println(date);
	    System.out.println(value);
	    
	    json.put("date", date);
	    json.put("value", value);
	    
	    ArrayList<Member> memberList = new AdminService().topAttendMember();
	    ArrayList<Community> communityList = new AdminService().todayRecruitCommunity();
	    
		RequestDispatcher view = request.getRequestDispatcher("/views/admin/index.jsp");
		request.setAttribute("memberCount", memberCount);
		request.setAttribute("postCount", postCount);
		request.setAttribute("communityCount", communityCount);
		request.setAttribute("meetingCount", meetingCount);
		request.setAttribute("json", json);
		request.setAttribute("memberList", memberList);
		request.setAttribute("communityList", communityList);
		
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
