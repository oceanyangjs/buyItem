import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.OrderItem;

public class HelloServlet extends HttpServlet{
	protected void service(HttpServletRequest request,HttpServletResponse response) {
		try {
			//List<Integer> aaa=(List<Integer>);
			List<Integer> b = null;
			b = new ArrayList<Integer>(); 
			b.add(3);
			if(null == request.getSession().getAttribute("hello")) {
				request.getSession().setAttribute("hello",b);
			}
			//经过测试，对于list这种的session 可以加入之后添加至，其实就是内存地址的指向
			System.out.println(request.getSession().getAttribute("hello"));
			b.add(222);
			System.out.println(request.getSession().getAttribute("hello"));
		} catch (ClassCastException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}
