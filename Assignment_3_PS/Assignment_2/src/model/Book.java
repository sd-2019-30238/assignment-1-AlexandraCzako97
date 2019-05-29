package model;

import java.util.ArrayList;

public class Book {
	private String title;
	private String author;
	private String genre;
	private String release_date;
	private String price;
	private String status;
	private String rating;
	
	
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public Book() {
		
	}
	public Book( String title, String author, String genre, String release_date,String price, String status,String rating) {
		this.title=title;
		this.author=author;
		this.genre=genre;
		this.release_date=release_date;
		this.price=price;
		this.status=status;
		this.rating=rating;
	}

	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getRelease_date() {
		return release_date;
	}
	public void setRelease_date(String release_date2) {
		this.release_date = release_date2;
	}
	public boolean check(ArrayList<String> cart, String secondBook) {
		for(String book : cart) {
			if(book.equals(secondBook))
				return true;
		}
		return false;
	}
	

}
