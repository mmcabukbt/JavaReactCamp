package oopIntro;

public class Product {
	int id; 
	String name;
	double unitPrice;
	String detail;
	
	
	public Product() {
		System.out.println("Ben �al��t�m");
	}
	
	public Product(int id, String name, double unitPrice, String detail){
		this();	// Parametresiz constructor'� �s��rmak i�in this()
		this.id = id; 
		this.name = name;
		this.unitPrice = unitPrice;
		this.detail = detail;
	}
}