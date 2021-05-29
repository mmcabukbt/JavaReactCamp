package newestGamersCo.Entities;

import interfaceAbstractDemo.Abstract.Entity;
import newestGamersCo.Core.EntityRepo;

public class Campaign implements Entity, EntityRepo {
	private int id;
	private int gameId;
	private String name;
	private String content;
	private double discount;
	
	public Campaign() {		
	}
	
	public Campaign(int id, int gameId, String name, String content, double discount) {
		super();
		this.id = id;
		this.gameId = gameId;
		this.name = name;
		this.content = content;
		this.discount = discount;
	}

	public int getId() {
		return id;
	}

	public int getGameId() {
		return gameId;
	}

	public String getName() {
		return name;
	}

	public String getContent() {
		return content;
	}

	public double getDiscount() {
		return discount;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}
}