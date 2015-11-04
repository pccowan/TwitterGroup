package Twitter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Process
 */
@WebServlet("/Process")
public class Process extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Process() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		String UN= request.getParameter("UserName");
		 String PWD= request.getParameter("Password") ;
		 PrintWriter out = response.getWriter();
		 TwitterInterface T = new TwitterInterface();
		 
		 boolean ExistingUser= T.isUserMatching(UN,PWD);
		 if(ExistingUser)
		 {
			
			 /* out.println("<!DOCTYPE html><html lang=\"en\"><head><meta charset=\"utf-8\"><meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"><title>Twitter Home</title>");
		 out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css\" integrity=\"sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ==\"crossorigin=\"anonymous\">");
		 out.println("</head><body><nav class=\"navbar navbar-inverse navbar-floating-top\"	style=\"background-color: #141452\"><div class=\"container\">");
		 out.println("<div class=\"navbar-header\"><button type=\"button\" class=\"navbar-toggle collapsed\"	data-toggle=\"collapse\" data-target=\"#navbar\" aria-expanded=\"false\" aria-controls=\"navbar\"><span class=\"sr-only\">Toggle navigation</span> <span>class=\"icon-bar\"></span> <span class=\"icon-bar\"></span> <span class=\"icon-bar\"></span></button></div>");
		 out.println("<div id=\"navbar\" class=\"collapse navbar-collapse\"><ul class=\"nav navbar-nav\"><li class = \"active\"><a href=\"#HomeFeed\">Home</a><li> <a href=\"Profile\">Profile</a></li><li> <a href=\"SignUp.html\">Sign-UP</a></li></ul><ul class = \"nav navbar-nav navbar-right\"><li><a href=\"LogoutServlet\">Logout</a></li></ul></nav> </div>");
		 //out.println("<textarea class=\"form-control\" rows=\"3\" name=\"tweet\" placeholder=\"Say something\"></textarea><br><button type=\"Tweet\" class=\"btn btn-primary btn-xs\">Tweet</button>");
		 //getPosts();
		 out.println("<br>");
		 out.println("<br>");
		 out.println("<a href=\"HomeFeed\">Home</a>");
		 out.println("</div></div><br/><br/><script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js\"></script><script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js\"	integrity=\"sha512-K1qjQ+NcF2TYO/eI3M6v8EiNYZfA95pQumfvcVrTHtwQVDG+aHRqLi/ETn2uB+1JqwYqVG3LIvdm9lj6imS/pQ==\" crossorigin=\"anonymous\"></script></body></html>");
		 */
		 RequestDispatcher rd = request.getRequestDispatcher("/HomeFeed");
		 rd.forward(request, response);
		 
		 }
		 else
		 {
			 boolean NewUser = T.createNewAccount(UN, PWD);
			 if(NewUser)
			 {
				 out.println("alert(\"User Created\")"); 
				
			 }
			 RequestDispatcher rd = request.getRequestDispatcher("/HomeFeed");
			 rd.forward(request, response); 
		 }
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
