package fr.istic.tpjpa.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.istic.tpjpa.domain.ElectronicDevice;
import fr.istic.tpjpa.domain.Heater;
import fr.istic.tpjpa.domain.Home;
import fr.istic.tpjpa.domain.Person;
import fr.istic.tpjpa.domain.SmartDevice;

public class JpaTest {

	@SuppressWarnings("unused")
	private EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("example");
		EntityManager manager = factory.createEntityManager();
		@SuppressWarnings("unused")
		JpaTest test = new JpaTest(manager);

		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		Home h1 = new Home("123 nous irons aux bois");
		Home h2 = new Home("456 cueillir des cerises");
		Home h3 = new Home("789 dans mon panier neuf");
		Home h4 = new Home("101112 elles seront toutes rouges");
		Person p1 = new Person("toto","titi");
		Person p2 = new Person("tutu","tata");
		Heater heat1 = new Heater("heatOne",5,25);
		Heater heat2 = new Heater("heatTwo",2,10);
		Heater heat3 = new Heater("heatThr",15,40);
		ElectronicDevice e1 = new ElectronicDevice("eDeviceOne","dishwasher");
		ElectronicDevice e2 = new ElectronicDevice("eDeviceTwo","microwave");
		
		List<Home> homes1 = new ArrayList<Home>();
		List<Home> homes2 = new ArrayList<Home>();
		List<Person> friends = new ArrayList<Person>();
		List<SmartDevice> devices1 = new ArrayList<SmartDevice>();
		List<SmartDevice> devices2 = new ArrayList<SmartDevice>();
		
		homes1.add(h1);
		homes1.add(h2);
		homes1.add(h3);
		homes2.add(h4);
		friends.add(p2);
		devices1.add(heat1);
		devices1.add(e2);
		devices2.add(e1);
		devices2.add(heat2);
		devices2.add(heat3);
		
		p1.setHomes(homes1);
		p2.setHomes(homes2);
		h1.setOwner(p1);
		h2.setOwner(p1);
		h3.setOwner(p1);
		h4.setOwner(p2);
		p1.setFriends(friends);
		h1.setDevices(devices1);
		h4.setDevices(devices2);
		
		manager.persist(p1);
		manager.persist(p2);
		manager.persist(heat1);
		manager.persist(heat2);
		manager.persist(heat3);
		manager.persist(e1);
		manager.persist(e2);
		
		tx.commit();

		List<Home> homesResult = manager.createQuery("SELECT h FROM Home h", Home.class).getResultList();
		System.out.println("num of homes : "+homesResult.size());
		for(Home next : homesResult) {
			System.out.println("adress : " + next.getAdress());
		}
		System.out.println(".. done");
	}

}
