package fr.istic.sir.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.istic.sir.domain.Person;

@WebServlet(name="userinfo",
urlPatterns={"/UserInfo"})
public class UserInfo extends HttpServlet {
	
	
	private EntityManagerFactory factory;
	private EntityManager em;
	private EntityTransaction tx;
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		factory = Persistence.createEntityManagerFactory("mysql");
		em = factory.createEntityManager();
		tx = em.getTransaction();
	}
	
	@Override
	public void destroy() {
		em.close();		
		super.destroy();
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		try {
			tx.begin();
			//Envoie en base
			Person p1 = new Person();
			p1.setFirstName(req.getParameter("firstname"));
			p1.setLastName(req.getParameter("name"));
			System.out.println("param : "+req.getParameter("lastname") +" ,p1 : " +p1.getLastName());
			em.persist(p1);
			tx.commit();		
		} catch (Exception e) {}
		
		//Affichage
		PrintWriter out = resp.getWriter();
		out.println("<html>\n<body>\n" +
							"<h1>Recapitulatif des informations</h1>\n" +
							"<ul>\n" +
								"<li>Name : " +
									req.getParameter("name") + "\n" +
								"<li>Firstname : " +
									req.getParameter("firstname") + "\n" +
								"<li>Age : " +
									req.getParameter("age") + "\n" +
							"</ul>\n" +
					"</body></html>");
	}
}
