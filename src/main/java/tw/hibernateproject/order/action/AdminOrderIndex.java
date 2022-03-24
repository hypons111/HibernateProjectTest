package tw.hibernateproject.order.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernateproject.order.model.OrderDao;
import tw.hibernateproject.util.HibernateUtil;

/**
 * Servlet implementation class AdminOrderIndex
 */
@WebServlet("/admin/order/index")
public class AdminOrderIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			OrderDao oDao = new OrderDao(session);
			
			List<tw.hibernateproject.order.model.Order> listUser = oDao.selectAll();
	        request.setAttribute("listOrder", listUser);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("order-list.jsp");
	        dispatcher.forward(request, response);
			
			
			session.getTransaction().commit();
		}catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			HibernateUtil.closeSessionFactory();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
