package fr.istic.sir.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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

@WebServlet(name="persons",
urlPatterns={"/persons"})
public class ShowPerson extends HttpServlet{

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
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		List<Person> personsResult;
		tx.begin();
		personsResult = em.createQuery("SELECT p FROM Person p", Person.class).getResultList();
		tx.commit();
		
		out.println("<html>\n<body>\n");
		out.println("<h1>nombre de personne(s) : </h1>" + personsResult.size());
		for(Person next : personsResult) {
			out.println("<h2>Person : "+ next.getId() +"</h2><br />");
			out.println("FirstName : " + next.getFirstName()+"<br />");
			out.println("LastName : " + next.getLastName()+"<br /><br />");
		}
		out.println("</body>\n</html>");
	}
}
