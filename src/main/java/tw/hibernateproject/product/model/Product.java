package tw.hibernateproject.product.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity @Table(name = "Product")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id @Column(name = "P_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int P_ID;
	
	@Column(name = "P_Type")
	private String P_Type;
	
	@Column(name = "P_Name")
	private String P_Name;
	
	@Column(name = "P_Stock")
	private int P_Stock;

	@Column(name = "P_Cost")
	private double P_Cost;
	
	@Column(name = "P_Price")
	private double P_Price;
	
	@Column(name = "P_Image")
	private String P_Image;
	
	@Column(name = "P_Description")
	private String P_Description;

//	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "product")
//	private Set<OrderItem> stockTransactions = new HashSet<>();

	
	public Product() {}

	
	public Product(int id, String name, String type, int stock, double cost, double price, String image, String description) {
		this.P_ID = id;
		this.P_Type = type;
	    this.P_Name = name;
	    this.P_Stock = stock;
	    this.P_Cost = cost;
	    this.P_Price = price;
	    this.P_Image = image;
	    this.P_Description =  description;
	}


	public int getP_ID() {
		return P_ID;
	}

	public void setP_ID(int p_ID) {
		P_ID = p_ID;
	}

	public String getP_Type() {
		return P_Type;
	}

	public void setP_Type(String p_Type) {
		P_Type = p_Type;
	}

	public String getP_Name() {
		return P_Name;
	}

	public void setP_Name(String p_Name) {
		P_Name = p_Name;
	}

	public int getP_Stock() {
		return P_Stock;
	}

	public void setP_Stock(int p_Stock) {
		P_Stock = p_Stock;
	}

	public double getP_Cost() {
		return P_Cost;
	}

	public void setP_Cost(double p_Cost) {
		P_Cost = p_Cost;
	}

	public double getP_Price() {
		return P_Price;
	}

	public void setP_Price(double p_Price) {
		P_Price = p_Price;
	}

	public String getP_Image() {
		return P_Image;
	}

	public void setP_Image(String p_Image) {
		P_Image = p_Image;
	}

	public String getP_Description() {
		return P_Description;
	}

	public void setP_Description(String p_Description) {
		P_Description = p_Description;
	}

//	public ProductType getProductType() {
//		return productType;
//	}
//
//	public void setProductType(ProductType productType) {
//		this.productType = productType;
//	}
	
}
	
	