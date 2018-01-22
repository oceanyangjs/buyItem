import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Order;
import bean.OrderItem;
import bean.User;
import dao.OrderDao;
import dao.OrderItemDao;

public class CreateOrderServlet extends HttpServlet{
	protected void service(HttpServletRequest request,HttpServletResponse response) throws IOException {
		User user = (User) request.getSession().getAttribute("user");
		if(null == user){
			response.sendRedirect("/j2ee/login.jsp");
			return;
		}
		
		Order o = new Order();
		o.setUser(user);
		
		new OrderDao().insert(o);
		
		List<OrderItem> ois = (List<OrderItem>) request.getSession().getAttribute("ois");
		for(OrderItem oi : ois) {
			oi.setOrder(o);
			new OrderItemDao().insert(oi);
		}
		ois.clear();
		
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().println("订单创建成功");
	}
}
