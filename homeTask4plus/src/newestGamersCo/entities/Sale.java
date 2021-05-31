package newestGamersCo.entities;

import java.util.Date;

import interfaceAbstractDemo.abstracts.Entity;
import newestGamersCo.core.EntityRepo;

public class Sale implements Entity, EntityRepo {
	private int id;
	private int gamerId;
	private int gameId;
	private int campaignId;
	private Date date;
	private double price;
	private double total;
	
	public Sale() {		
	}
	
	public Sale(int id, int gamerId, int gameId, int campaignId, Date date, double price, double total) {
		this.id = id;
		this.gamerId = gamerId;
		this.gameId = gameId;
		this.campaignId = campaignId;
		this.date = date;
		this.price = price;
		this.total = total;
	}

	public int getId() {
		return id;
	}

	public int getGamerId() {
		return gamerId;
	}

	public int getGameId() {
		return gameId;
	}

	public int getCampaignId() {
		return campaignId;
	}

	public Date getDate() {
		return date;
	}

	public double getPrice() {
		return price;
	}

	public double getTotal() {
		return total;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setGamerId(int gamerId) {
		this.gamerId = gamerId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	public void setCampaignId(int campaignId) {
		this.campaignId = campaignId;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setTotal(double total) {
		this.total = total;
	}
}