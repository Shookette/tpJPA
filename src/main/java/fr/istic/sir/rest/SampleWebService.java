package fr.istic.sir.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.istic.sir.domain.Heater;
import fr.istic.sir.domain.Home;
import fr.istic.sir.domain.SmartDevice;

@Path("/hello")
public class SampleWebService {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello() {
		return "Hello, how are you ?";
	}
	
	@GET
	@Path("/home")
	@Produces(MediaType.APPLICATION_JSON)
	public Home getHome() {
		Home h = new Home();
		h.setAdress("123 rue bidon");
		Heater h1 = new Heater();
		h1.setPower("500w");
		Heater h2 = new Heater();
		h2.setPower("600w");
		List<SmartDevice> devices = new ArrayList<SmartDevice>();
		devices.add(h1);
		devices.add(h2);
		h.setDevices(devices);
		return h;
	}
}
