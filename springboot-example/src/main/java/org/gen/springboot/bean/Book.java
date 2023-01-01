package org.gen.springboot.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

//@Component
//@ConfigurationProperties(prefix = "book")
//@PropertySource(value = { "classpath:book.properties" }, encoding = "utf-8")
public class Book {

	// private String name;
	//
	// private String author;
	//
	// private Float price;
	//
	// public String getName() {
	// return name;
	// }
	//
	// public void setName(String name) {
	// this.name = name;
	// }
	//
	// public String getAuthor() {
	// return author;
	// }
	//
	// public void setAuthor(String author) {
	// this.author = author;
	// }
	//
	// public Float getPrice() {
	// return price;
	// }
	//
	// public void setPrice(Float price) {
	// this.price = price;
	// }
	//
	// @Override
	// public String toString() {
	// return "Book [name=" + name + ", author=" + author + ", price=" + price +
	// "]";
	// }

	private Integer id;
	private String name;
	private String author;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
