package tw.hibernateproject.order.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import tw.hibernateproject.member.model.Member;


@Entity @Table(name="OrderList")
public class Order {
//	order_id int not null primary key identity(1001,1),
//	member_id int Foreign key References member(memberid),
//	orderdate datetime2(0),
//	orderpd_amount int,
//	order_totalprice int
//	);
	@Id @Column(name="order_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int order_id;
	
	@Transient
	private int memberid;
	
	@Column(name="orderdate")
	private Timestamp orderdate;
	
	@Column(name="orderpd_amount")
	private int orderpd_amount;
	
	@Column(name="order_totalprice")
	private int order_totalprice;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "memberid")
	private Member member;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "OrderList")
	private Set<OrderItem> orders = new HashSet<OrderItem>();
	
	public Order() {
		
	}
	
	public Order(int order_id, int memberid, Timestamp orderdate, int orderpd_amount, int order_totalprice) {
		
		this.order_id = order_id;
		this.memberid = memberid;
		this.orderdate = orderdate;
		this.orderpd_amount = orderpd_amount;
		this.order_totalprice = order_totalprice;
	}
	

	public Order(Timestamp orderdate, int orderpd_amount, int order_totalprice) {
		
		this.orderdate = orderdate;
		this.orderpd_amount = orderpd_amount;
		this.order_totalprice = order_totalprice;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getMemberid() {
		return memberid;
	}

	public void setMemberid(int memberid) {
		this.memberid = memberid;
	}

	public Timestamp getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(Timestamp orderdate) {
		this.orderdate = orderdate;
	}

	public int getOrderpd_amount() {
		return orderpd_amount;
	}

	public void setOrderpd_amount(int orderpd_amount) {
		this.orderpd_amount = orderpd_amount;
	}

	public int getOrder_totalprice() {
		return order_totalprice;
	}

	public void setOrder_totalprice(int order_totalprice) {
		this.order_totalprice = order_totalprice;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Set<OrderItem> getOrders() {
		return orders;
	}

	public void setOrders(Set<OrderItem> orders) {
		this.orders = orders;
	}
	
	
	
	
	
}
