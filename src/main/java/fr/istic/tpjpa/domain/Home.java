package fr.istic.tpjpa.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Home {

	private int id;
	
	private String adress;
	
	private String ipAdress;
	
	private int area;
	
	private Person owner;
	
	private List<SmartDevice> devices = new ArrayList<SmartDevice>();
	
	public Home(String adress){
		this.adress = adress;
	}
	
	public Home(){}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getIpAdress() {
		return ipAdress;
	}

	public void setIpAdress(String ipAdress) {
		this.ipAdress = ipAdress;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}
	
	@ManyToOne
	public Person getOwner() {
		return owner;
	}

	public void setOwner(Person owner) {
		this.owner = owner;
	}

	@OneToMany
	public List<SmartDevice> getDevices() {
		return devices;
	}

	public void setDevices(List<SmartDevice> devices) {
		this.devices = devices;
	}
}
