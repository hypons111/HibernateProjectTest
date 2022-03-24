package tw.hibernateproject.order.model;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import tw.hibernateproject.product.model.Product;

@Entity @Table(name="OrderItem")
public class OrderItem {
//	item_id int not null primary key identity(1001,1),
//	order_id int Foreign Key References OrderList(order_id),
//	P_ID int Foreign Key References Product(P_ID),
//	orderitem_amount int,
//	orderitem_subtotal int
//	);
	@Id @Column(name="item_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int item_id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@Column(name="order_id")
	private int order_id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@Column(name="P_ID")
	private int P_ID;
	
	@Column(name="orderitem_amount")
	private int orderitem_amount;
	
	@Column(name="orderitem_subtotal")
	private int orderitem_subtotal;
	//FK orderlist
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id")
	private Order order;
	//Fk product
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "P_ID")
	private Product product;

	
	public OrderItem() {
		
	}

	public OrderItem(int item_id, int order_id, int p_ID, int orderitem_amount, int orderitem_subtotal) {		
		this.item_id = item_id;
		this.order_id = order_id;
		this.P_ID = p_ID;
		this.orderitem_amount = orderitem_amount;
		this.orderitem_subtotal = orderitem_subtotal;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getP_ID() {
		return P_ID;
	}

	public void setP_ID(int p_ID) {
		P_ID = p_ID;
	}

	public int getOrderitem_amount() {
		return orderitem_amount;
	}

	public void setOrderitem_amount(int orderitem_amount) {
		this.orderitem_amount = orderitem_amount;
	}

	public int getOrderitem_subtotal() {
		return orderitem_subtotal;
	}

	public void setOrderitem_subtotal(int orderitem_subtotal) {
		this.orderitem_subtotal = orderitem_subtotal;
	}
	
	
	
	
}
