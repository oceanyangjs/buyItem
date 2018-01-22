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
		
		List<OrderItem> oiItems = null;
		
		if(null == request.getSession().getAttribute("ois")) {
			oiItems = new ArrayList<OrderItem>();
			//oiItems.add(orderItem);
			request.getSession().setAttribute("ois", oiItems);
		}else {
			oiItems = (List<OrderItem>)request.getSession().getAttribute("ois");
			//oiItems.add(orderItem);
		}
		boolean found = false;
		for(OrderItem item : oiItems) {
			if(item.getProduct().getId() == orderItem.getProduct().getId()) {
				item.setNum(orderItem.getNum()+item.getNum());
				found = true;
				break;
			}else {
				
			}
		}
		if(!found) {
			oiItems.add(orderItem);	
		}
		
		response.sendRedirect("/j2ee/listOrderItem");
		
		
	}
}
