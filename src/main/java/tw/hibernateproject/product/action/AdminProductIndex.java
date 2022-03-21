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
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();

		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		// 把 hibernate 的方法包在 DAO 裡面再包在 service 裡面
		ProductService service = new ProductService(session);
		List<Product> resultList = service.selectAll();
		List<ProductJson> productList = new ArrayList<>();

		for (Product p : resultList) {
//			System.out.println(p.getProductType().getPT_Name());
//			System.out.println(p.getP_ID());
//			System.out.println(p.getP_Name());
//			System.out.println(p.getP_Stock());
//			System.out.println(p.getP_Cost());
//			System.out.println(p.getP_Price());
//			System.out.println(p.getP_Image());

			productList.add(new ProductJson(p.getProductType().getPT_Name(), p.getP_ID(), p.getP_Name(), p.getP_Stock(), p.getP_Cost(), p.getP_Price(), p.getP_Image()));
		}


		Gson gson = new Gson();
		String jsonString = gson.toJson(productList);
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