import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import dao.UserDao;

public class LoginServlet extends HttpServlet{
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		User user = new UserDao().getUser(name, password);
		if(user != null) {
			request.getSession().setAttribute("user", user);
			response.sendRedirect("/j2ee/productList");
		}else {
			response.sendRedirect("/j2ee/login.jsp");
		}
	}
}
