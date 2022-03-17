package tw.hibernateproject.product.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernateproject.product.model.Product;
import tw.hibernateproject.product.service.ProductService;
import tw.hibernateproject.util.HibernateUtil;

@WebServlet("/admin/product/delete")
public class AdminProductDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request, response);
	}

	private void processAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		int id = Integer.parseInt(request.getParameter("P_ID"));
		
		// 把 hibernate 的方法包在 DAO 裡面再包在 service 裡面
		ProductService service = new ProductService(session);
		service.delete(id);
		response.sendRedirect("index.jsp");
	}
}
