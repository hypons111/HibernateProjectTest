package tw.hibernateproject.product.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernateproject.product.model.Product;
import tw.hibernateproject.product.model.ProductType;
import tw.hibernateproject.product.service.ProductService;
import tw.hibernateproject.product.service.ProductTypeService;
import tw.hibernateproject.util.HibernateUtil;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
		maxFileSize = 1024 * 1024 * 10, // 10 MB
		maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
@WebServlet("/admin/product/insert")
public class AdminProductInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private void processAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		ProductService productService = new ProductService(session);
		ProductTypeService productTypeService = new ProductTypeService(session);

		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter("name");
		String type = request.getParameter("type");
		int stock = Integer.parseInt(request.getParameter("stock"));
		double cost = Math.ceil(Double.parseDouble(request.getParameter("cost")) * 10.0) / 10.0;
		double price = Math.ceil(Double.parseDouble(request.getParameter("price")) * 10.0) / 10.0;
		String description = "";

		System.out.println("AdminProductInsert " + type);
		ProductType productType = new ProductType(type);
		productTypeService.insert(productType);

		
		Product product = new Product(0, name, stock, cost, price, "temp", description, productType);

		//productResult 是連接到資料庫的某一筆資料
		Product productResult = productService.insert(product);
		
		//product bean 建立成功, 有 id 後才能把 id 用作 image 名稱欴
		String image = productResult.getP_ID() + ".jpg";
		
		//productResult.productResult.getP_ID() 指定修改該筆資料的 image
		productResult.setP_Image(image);
	
		try {
			for (Part part : request.getParts()) {
				part.write("C:/DataSource/workspace/HibernateProjectTest/src/main/webapp/admin/images/product/" + image);
			}
		} catch (IOException | ServletException e) {
			e.printStackTrace();
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


//@Override
//public ProductType insert(ProductType productType) {
//	return productDao.insert(productType);
//}
//ProductType insert(ProductType productType);
//ProductType insert(ProductType roductType);