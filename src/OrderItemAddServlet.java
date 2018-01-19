import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ietf.jgss.Oid;

import bean.OrderItem;
import bean.Product;
import dao.ProductDao;

public class OrderItemAddServlet extends HttpServlet{
	protected void service(HttpServletRequest request,HttpServletResponse response) throws IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		int pid = Integer.parseInt(request.getParameter("pid"));
		Product product = new ProductDao().getProduct(pid);
		
		OrderItem orderItem = new OrderItem();
		orderItem.setNum(num);
		orderItem.setProduct(product);
		System.out.println(orderItem.getProduct().getName());
		
		List<OrderItem> oiItems = null;
		
		if(null == request.getSession().getAttribute("ois")) {
			System.out.println(999999);
			oiItems = new ArrayList<OrderItem>();
			request.getSession().setAttribute("ois", oiItems);
		}else {
			oiItems = (List<OrderItem>)request.getSession().getAttribute("ois");
		}
		
		oiItems.add(orderItem);
		System.out.println(98989898);
		System.out.println();
		response.sendRedirect("/j2ee/listOrderItem");
		
		
	}
}
