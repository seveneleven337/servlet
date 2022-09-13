package webapp;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Forum extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DataBase db = new DataBase();

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		
		response.setContentType("text/html");
		String action = null, name = null, message = null, date = null;
		String[] sports = null, views = null;
		
		Map<String, String[]> paramMap = request.getParameterMap();
		  if (paramMap != null) {
			  Iterator<Entry<String, String[]>> iterator = paramMap.entrySet().iterator();
			  //Set keys = paramMap.keySet();
			  while (iterator.hasNext()) {
				  Entry<String, String[]> me = iterator.next();
				  switch (me.getKey()) {
					  case "action": 
						  action = me.getValue()[0];
						  break;
					  case "userName":
						  name = me.getValue()[0];
					  case "message": 
						  message = me.getValue()[0];
						  break;
					  case "date":
						  date = me.getValue()[0];
					  case "sports":
						  sports = me.getValue();   
					  case "views":
						  views = me.getValue();   
				  }
			  }
		  }

		if (action != null && !action.isEmpty()) {
			switch (action) {
			case "submit":
				if (!name.isEmpty() && name != null && !message.isEmpty() && message != null) {
					db.addNewUser(name, message, sports, views);
					printHtml(response.getWriter(), db.getUsers());
				}
				break;
			case "search":
				if (!name.isEmpty() && name != null || !message.isEmpty() && message != null
						|| !date.isEmpty() && date != null) {
					//printHtml(response.getWriter(), db.search(name, message, date));
				} else {
					printHtml(response.getWriter(), db.getUsers());
				}
				break;
			}
		}
		
	}

	private void printHtml(PrintWriter out, ArrayList<User> temp) {
		out.println("<html>");
		out.println("<head>\r\n" + "<link rel=\"stylesheet\" href=\"styles.css\">\r\n" + "</head>");
		out.println("<body>");
		out.println("<table id='forumTable'>");
		out.println("<tr>\r\n" + "<th>name</th>\r\n" + "<th>message</th>\r\n" + "<th>date</th>\r\n" + "<th>favorite sports</th>\r\n" + "<th>favorite view</th>\r\n" + "</tr>");
		for (User u : temp) {
			out.println("<tr>");
			out.println("<td>\r\n" + u.getName() + "</td>");
			out.println("<td>\r\n" + u.getMessage() + "</td>");
			out.println("<td>\r\n" + u.getCalendar() + "</td>");
			out.println("<td><ul>\r\n");
			for(String s : u.getSports()) {
				out.println("<li>" + s + "</li>");
			}
			out.println("</ul></td>");
			out.println("<td><ul>\r\n");
			for(String v : u.getViews()) {
				out.println("<li>" + v + "</li>");
			}
			out.println("</ul></td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("<a href='index.html'>Back</a>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
