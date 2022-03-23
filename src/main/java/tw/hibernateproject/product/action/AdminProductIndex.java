package tw.hibernateproject.product.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import tw.hibernateproject.product.model.Product;
import tw.hibernateproject.product.model.ProductJson;
import tw.hibernateproject.product.service.ProductService;
import tw.hibernateproject.util.HibernateUtil;
import com.google.gson.Gson;

@WebServlet("/admin/product/index")
public class AdminProductIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private void processAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("AdminProductIndex");

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();

		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		// 把 hibernate 的方法包在 DAO 裡面再包在 service 裡面
		ProductService ProductService = new ProductService(session);
		List<Product> resultList = ProductService.selectAll();
		
		System.out.println(resultList.size());
		
		Gson gson = new Gson();
		String jsonString = gson.toJson(resultList);
		out.print(jsonString);
		out.close();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processAction(request, response);
	}

}