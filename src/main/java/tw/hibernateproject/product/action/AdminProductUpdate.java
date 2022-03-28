package tw.hibernateproject.product.action;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import javax.servlet.http.Part;

import tw.hibernateproject.product.model.ProductType;
import tw.hibernateproject.product.service.ProductService;
import tw.hibernateproject.product.service.ProductTypeService;
import tw.hibernateproject.util.HibernateUtil;

@WebServlet("/admin/product/update")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
		maxFileSize = 1024 * 1024 * 10, // 10 MB
		maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class AdminProductUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private void processAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("Product Update Serlvet");
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();

		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		ProductService productservice = new ProductService(session);
		ProductTypeService productTypeService = new ProductTypeService(session);

		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		int stock = Integer.parseInt(request.getParameter("stock"));
		double cost = Math.ceil(Double.parseDouble(request.getParameter("cost")) * 10.0) / 10.0;
		double price = Math.ceil(Double.parseDouble(request.getParameter("price")) * 10.0) / 10.0;

		// 判斷是不要更新圖片
		try {
			String newImageName = request.getPart("image").getSubmittedFileName();
			if (newImageName != "") {
				for (Part part : request.getParts()) {
					part.write("C:/DataSource/workspace/HibernateProjectTest/src/main/webapp/admin/images/product/" + id
							+ ".jpg");
				}
			}
		} catch (ServletException e) {
			e.printStackTrace();
		}

		productservice.update(id, name, type, stock, cost, price, "temp");

		Set<String> productTypeNameResultSet = new HashSet<>();
		for (ProductType productType : productTypeService.selectAll()) {
			productTypeNameResultSet.add(productType.getPT_Name());
		}
		if (productTypeNameResultSet.add(type)) {
			productTypeService.insert(new ProductType(type));
		}

		response.sendRedirect("index.jsp");
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
