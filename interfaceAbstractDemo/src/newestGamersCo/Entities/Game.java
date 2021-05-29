package newestGamersCo.Entities;

import interfaceAbstractDemo.Abstract.Entity;
import newestGamersCo.Core.EntityRepo;

public class Game implements Entity, EntityRepo {
	private int id;
	private String name;
	private String content;
	private double price;
	
	public Game() {		
	}
	public Game(int id, String name, String content, double price) {
		this.id = id;
		this.name = name;
		this.content = content;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}