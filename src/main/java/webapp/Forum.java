package webapp;

import java.io.PrintWriter;
import java.util.ArrayList;

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

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		String action, name, message, date;
		response.setContentType("text/html");
		action = request.getParameter("action");
		name = request.getParameter("userName");
		message = request.getParameter("message");
		date = request.getParameter("date");

		if (action != null && !action.isEmpty()) {
			switch (action) {
			case "submit":
				if (!name.isEmpty() && name != null && !message.isEmpty() && message != null) {
					db.addNewUser(name, message);
					printHtml(response.getWriter(), db.getUsers());
				}
				break;
			case "search":
				if (!name.isEmpty() && name != null || !message.isEmpty() && message != null
						|| !date.isEmpty() && date != null) {
					printHtml(response.getWriter(), db.search(name, message, date));
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
		out.println("<tr>\r\n" + "<th>name</th>\r\n" + "<th>message</th>\r\n" + "<th>date</th>\r\n" + "</tr>");
		for (User u : temp) {
			out.println("<tr>");
			out.println("<td>\r\n" + u.getName() + "</td>");
			out.println("<td>\r\n" + u.getMessage() + "</td>");
			out.println("<td>\r\n" + u.getCalendar() + "</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("<a href='index.html'>Back</a>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
