package dao;

import java.sql.Date;

public class Book {
	private int bookId;
	private String title;
	private String author;
	private String genre;
	private Date release_date;
	public Book(int bookId, String title, String author, String genre, Date release_date) {
		this.bookId=bookId;
		this.title=title;
		this.author=author;
		this.genre=genre;
		this.release_date=release_date;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
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
	public Date getRelease_date() {
		return release_date;
	}
	public void setRelease_date(Date release_date) {
		this.release_date = release_date;
	}
	

}
