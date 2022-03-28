package tw.hibernateproject.product.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity @Table(name = "orderitem")
public class OrderItem {

	@Id @Column(name = "temp_orderitem_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int temp_orderitem_id;
	
	@Column(name = "temp_order_id")
	private int temp_order_id;
	
	@Transient
	private int productid;
	
	@Column(name = "productquantity")
	private int productquantity;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "productid")
	private Product product;

	public OrderItem() {}

	public int getTemp_orderitem_id() {
		return temp_orderitem_id;
	}

	public void setTemp_orderitem_id(int temp_orderitem_id) {
		this.temp_orderitem_id = temp_orderitem_id;
	}

	public int getTemp_order_id() {
		return temp_order_id;
	}

	public void setTemp_order_id(int temp_order_id) {
		this.temp_order_id = temp_order_id;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public int getProductquantity() {
		return productquantity;
	}

	public void setProductquantity(int productquantity) {
		this.productquantity = productquantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}



}