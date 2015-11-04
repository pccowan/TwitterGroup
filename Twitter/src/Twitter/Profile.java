package Twitter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Twitterfeed;

/**
 * Servlet implementation class Profile
 */
@WebServlet("/Profile")
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
    static String username;   
    TwitterInterface ti = new TwitterInterface();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Profile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Twitterfeed> dataset = new ArrayList<Twitterfeed>();
		
		// TODO Auto-generated method stub
		PrintWriter out  = response.getWriter();
		out.println("<!DOCTYPE html><html lang=\"en\"><head><meta charset=\"utf-8\"><meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"><title>Profile</title>");
		out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css\" integrity=\"sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ==\"crossorigin=\"anonymous\">");
		out.println("</head><body style=\'background-color:grey\'><nav class=\"navbar navbar-inverse navbar-fixed-top\"	style=\"background-color: #141452\"><div class=\"container\">");
		out.println("<div class=\"navbar-header\"><button type=\"button\" class=\"navbar-toggle collapsed\"	data-toggle=\"collapse\" data-target=\"#navbar\" aria-expanded=\"false\" aria-controls=\"navbar\"><span class=\"sr-only\">Toggle navigation</span> <span>class=\"icon-bar\"></span> <span class=\"icon-bar\"></span> <span class=\"icon-bar\"></span></button></div>");
		out.println("<div id=\"navbar\" class=\"collapse navbar-collapse\"><ul class=\"nav navbar-nav\"><li><a href=\"HomeFeed\">Home</a><li class = \"active\"><a href=\"Profile\">Profile</a></li></ul><ul class = \"nav navbar-nav navbar-right\"><li><a href=\"LogoutServlet\">Logout</a></li></ul></div></nav><div class=\"container\">");
		out.println("<br><br><br><br><form action=\"PostServlet\" method=\"POST\"><textarea class=\"form-control\" rows=\"3\" name=\"tweet\" placeholder=\"Say something\"></textarea><br><button type=\"Tweet\" class=\"btn btn-primary btn-xs\">Tweet</button></form>");
		//table
		out.println("<br><div style = \"overflow-y:scroll\"><table class = \"table table-striped\">"); //
		HttpSession session = request.getSession();
		
		
		String key = (String)session.getAttribute("key");
		
		
		dataset= ti.pullProfile1(key);
		for(int i = 0; i<dataset.size(); i++){
			out.println("<tr><td>" + dataset.get(i).getPost() + "</td><td>" + dataset.get(i).getPostDate() + "</td>");
		}
		out.println("</table>");
		out.println("</div><br/><br/><script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js\"></script><script	src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js\"	integrity=\"sha512-K1qjQ+NcF2TYO/eI3M6v8EiNYZfA95pQumfvcVrTHtwQVDG+aHRqLi/ETn2uB+1JqwYqVG3LIvdm9lj6imS/pQ==\" crossorigin=\"anonymous\"></script></body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}
	

}
