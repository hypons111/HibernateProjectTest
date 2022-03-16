package tw.hibernateproject.member.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name="member")
public class Member {
	
	@Id @Column(name="memberid")//1
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int memberid;
	
	@Column(name="membername")//2
	private String membername;
	
	@Column(name="gender")//3
	private String gender;
	
	@Column(name="account")//4
	private String account;
	
	@Column(name="encrypt_pwd")//5
	private String encrypt_pwd;
	
	@Column(name="salt")//6
	private int salt;
	
	@Column(name="email")//7
	private String email;
	
	@Column(name="imagefilename")//8
	private String imagefilename;
	
	@Column(name="registertime")//9
	private Timestamp registertime;
	
	@Column(name="roleid")//10
	private int roleid;

	public Member() {
	}
	
	//hibernate insert專用
	public Member(int memberid, String membername, String gender, String account, String encrypt_pwd, int salt, String email,
			String imagefilename, Timestamp registertime, int roleid) {
		this.memberid = memberid;
		this.membername = membername;
		this.gender = gender;
		this.account = account;
		this.encrypt_pwd = encrypt_pwd;
		this.salt = salt;
		this.email = email;
		this.imagefilename = imagefilename;
		this.registertime = registertime;
		this.roleid = roleid;
	}
	
	public int getMemberid() {
		return memberid;
	}

	public void setMemberid(int memberid) {
		this.memberid = memberid;
	}

	public String getMembername() {
		return membername;
	}

	public void setMembername(String membername) {
		this.membername = membername;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getEncrypt_pwd() {
		return encrypt_pwd;
	}

	public void setEncrypt_pwd(String encrypt_pwd) {
		this.encrypt_pwd = encrypt_pwd;
	}

	public int getSalt() {
		return salt;
	}

	public void setSalt(int salt) {
		this.salt = salt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImagefilename() {
		return imagefilename;
	}

	public void setImagefilename(String imagefilename) {
		this.imagefilename = imagefilename;
	}

	public Timestamp getRegistertime() {
		return registertime;
	}

	public void setRegistertime(Timestamp registertime) {
		this.registertime = registertime;
	}

	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	
}
