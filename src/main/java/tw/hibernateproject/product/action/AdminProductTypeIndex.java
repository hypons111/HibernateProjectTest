package tw.hibernateproject.product.action;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.google.gson.Gson;
import tw.hibernateproject.product.model.ProductType;
import tw.hibernateproject.product.service.ProductTypeService;
import tw.hibernateproject.util.HibernateUtil;

@WebServlet("/admin/product/type/index")
public class AdminProductTypeIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private void processAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		// 把 hibernate 的方法包在 DAO 裡面再包在 service 裡面
		ProductTypeService productTypeService = new ProductTypeService(session);
		List<ProductType> productTypeResultList = productTypeService.selectAll();
				
		Gson gson = new Gson();
		String jsonString = gson.toJson(productTypeResultList);
		out.print(jsonString);
		out.close();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request, response);
	}

}