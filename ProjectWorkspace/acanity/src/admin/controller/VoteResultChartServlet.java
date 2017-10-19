package admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.model.service.AdminService;
import community.model.vo.Vote;

/**
 * Servlet implementation class VoteResultChartServlet
 */
@WebServlet("/admin/community/chart")
public class VoteResultChartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VoteResultChartServlet() {
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
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		ArrayList<Vote> voteList = service.voteResultChart(no);
		
		String item = "";
		String value = "";
		System.out.println(voteList);
		for(Vote vote : voteList) {
			item += "\"" + vote.getVoteItemSelect() + "\""  + ",";
			value += vote.getVoteResultNo()+ ",";
		}
		
		item.substring(0, item.length() - 1);
		value.substring(0, value.length() - 1);
		
		
		System.out.println("item : " + item);
		System.out.println("value : " + value);
		
		String values = 
				"<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<meta charset=\"UTF-8\">\r\n" + 
				"    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.0/Chart.bundle.js\"></script>\r\n" + 
				"	<script src=\"/acanity/js/admin/utils.js\"></script>\r\n" + 
				"<style type=\"text/css\">\r\n" + 
				"	canvas{\r\n" + 
				"	    -moz-user-select: none;\r\n" + 
				"	    -webkit-user-select: none;\r\n" + 
				"	    -ms-user-select: none;\r\n" + 
				"	}\r\n" + 
				"</style>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"    <div id=\"canvas-holder\" style=\"width:100%\">\r\n" + 
				"        <canvas id=\"chart-area\" />\r\n" + 
				"    </div>\r\n" + 
				"    <script>\r\n" + 
				"    var randomScalingFactor = function() {\r\n" + 
				"        return Math.round(Math.random() * 100);\r\n" + 
				"    };\r\n" + 
				"\r\n" + 
				"    var config = {\r\n" + 
				"        type: 'doughnut',\r\n" + 
				"        data: {\r\n" + 
				"            datasets: [{\r\n" + 
				"                data: [\r\n" + 
				value + 
				"                ],\r\n" + 
				"                backgroundColor: [\r\n" + 
				"                    window.chartColors.red,\r\n" + 
				"                    window.chartColors.orange,\r\n" + 
				"                    window.chartColors.yellow,\r\n" + 
				"                    window.chartColors.green,\r\n" + 
				"                    window.chartColors.blue,\r\n" + 
				"                ],\r\n" + 
				"                label: 'Dataset 1'\r\n" + 
				"            }],\r\n" + 
				"            labels: [\r\n" + 
				item + 
				"            ]\r\n" + 
				"        },\r\n" + 
				"        options: {\r\n" + 
				"            responsive: true,\r\n" + 
				"            legend: {\r\n" + 
				"                position: 'top',\r\n" + 
				"            },\r\n" + 
				"            animation: {\r\n" + 
				"                animateScale: true,\r\n" + 
				"                animateRotate: true\r\n" + 
				"            }\r\n" + 
				"        }\r\n" + 
				"    };\r\n" + 
				"\r\n" + 
				"    function view() {\r\n" + 
				"        var ctx = document.getElementById(\"chart-area\").getContext(\"2d\");\r\n" + 
				"        window.myDoughnut = new Chart(ctx, config);\r\n" + 
				"    };\r\n" + 
				"\r\n" + 
				"    </script>\r\n" + 
				"</body>\r\n" + 
				"\r\n" + 
				"</html>";
		
		PrintWriter pw = response.getWriter();
		pw.print(values);
		pw.flush();
		pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
