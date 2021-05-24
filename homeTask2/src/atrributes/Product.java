package atrributes;

public class Product {
//field lar� private anahtar� ile koruyup getter ve setter ile eri�ilibiilir hale getiriyruz
	private int id;
	private String name;
	private String description;
	private double price;
	private int stockAmount;
	private String renk;

	public Product() {
	System.out.println("Yap�c� -<>Constructor<>- Blok �al��t�");
		
	}
	
	public Product(int id, String name, String description, double price, int stockAmount, String renk) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.stockAmount = stockAmount;
		this.renk = renk;
	}
	//getter
	public int getId() {
		return id;
	}
	//setter
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStockAmount() {
		return stockAmount;
	}
	public void setStockAmount(int stockAmount) {
		this.stockAmount = stockAmount;
	}
	public String getRenk() {
		return renk;
	}
	public void setRenk(String renk) {
		this.renk = renk;
	}
	public String getKod() {
		return this.name.substring(0,1) + id;
	}
	
	// SOLID Prensipleri gere�i bu k�t� kullanm�yoruz. field ve operasyonlar� ay�r�p
	// �� Yapan Metodlar� ayn� class a ASLA KOYMUYORUZ
//	public void add(Product product) {
//		System.out.println(product.name + " �r�n� veritaban�na eklendi!");
//	}
}