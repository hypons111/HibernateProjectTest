package tw.hibernateproject.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class SessionFactoryListener
 *
 */
@WebListener
public class SessionFactoryListener implements ServletContextListener {

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
        HibernateUtil.closeSessionFactory();
        System.out.println("Session Factory Destroyed");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         HibernateUtil.getSessionFactory();
         System.out.println("Session Factory Created");
    }
	
}
