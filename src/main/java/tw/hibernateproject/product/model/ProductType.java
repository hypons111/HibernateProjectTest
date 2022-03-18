package tw.hibernateproject.product.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity @Table(name = "ProductType")
public class ProductType implements Serializable {
    private static final long serialVersionUID = 1L;

	@Id @Column(name = "PT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int PT_ID;
	
	@Column(name = "PT_Name")
	private String PT_Name;
	
	public ProductType() {}

	public ProductType(int id, String name, String type, int stock, double cost, double price, String image) {
		this.PT_ID = id;
	    this.PT_Name = name;
	}

	public int getPT_ID() {
		return PT_ID;
	}

	public void setPT_ID(int pT_ID) {
		PT_ID = pT_ID;
	}

	public String getPT_Name() {
		return PT_Name;
	}

	public void setPT_Name(String pT_Name) {
		PT_Name = pT_Name;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
	
	