package com.example.cuoiki;

import java.io.Serializable;

public class SerialReceipt implements Serializable {
	String name, type;
	Double price;

	public Double getPrice() {
		return price;
	}

	Integer m, l;

	public SerialReceipt(String name, String type, Double price, Integer m, Integer l) {
		this.name = name;
		this.type = type;
		this.price = price;
		this.m = m;
		this.l = l;
	}

	String display() {
		return type + " - " + name + ", " + m + "x size M, " + l + "x size L, for $" + price;
	}
}
