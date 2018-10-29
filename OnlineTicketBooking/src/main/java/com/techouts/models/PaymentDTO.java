package com.techouts.models;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Entity;


@Entity
@Table(name = "payment")
public class PaymentDTO {

	@Id
	@Column(name = "id_num")
	private int id;

	@Column(name = "username")
	private String name;

	@Column(name = "amount")
	private double amount;

	@Column(name = "wallet")
	private double wallet;

	public PaymentDTO(int id, String name, double amount, double wallet) {
		super();
		this.id = id;
		this.name = name;
		this.amount = amount;
		this.wallet = wallet;
	}

	@Override
	public String toString() {
		return "PaymentDTO [id=" + id + ", Name=" + name + ", Amount=" + amount + ", Wallet=" + wallet + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getWallet() {
		return wallet;
	}

	public void setWallet(double wallet) {
		this.wallet = wallet;
	}

	public PaymentDTO() {

	}

}
