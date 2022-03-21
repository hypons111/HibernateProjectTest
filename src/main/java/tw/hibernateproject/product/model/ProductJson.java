package tw.hibernateproject.product.model;

import java.io.Serializable;

public class ProductJson implements Serializable {
    private static final long serialVersionUID = 1L;

    private String type;

    private int ID;
	
	private String name;
	
	private int stock;

	private double cost;
	
	private double price;
	
	private String image;
	
	public ProductJson() {}

	public ProductJson(String type, int ID, String name, int stock, double cost, double price, String image) {
		this.type = type;
		this.ID = ID;
		this.name = name;
		this.stock = stock;
		this.cost = cost;
		this.price = price;
		this.image = image;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
	
	