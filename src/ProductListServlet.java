import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

import bean.Product;
import dao.ProductDao;

public class ProductListServlet extends HttpServlet{
	public void service(ServletRequest request,ServletResponse response) throws ServletException, IOException{
		List<Product> products = new ProductDao().ListProduct();
		
		request.setAttribute("products", products);
		//请求转发到listProduct.jsp
		//上方传递了参数
		request.getRequestDispatcher("listProduct.jsp").forward(request, response);
		
	}
}
