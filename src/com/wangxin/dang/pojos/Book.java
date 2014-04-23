package com.wangxin.dang.pojos;

public class Book extends Product{
	private String bookName;
	private String author;
	private String publishing;
	private String publishingDate;
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublishing() {
		return publishing;
	}
	public void setPublishing(String publishing) {
		this.publishing = publishing;
	}
	public String getPublishingDate() {
		return publishingDate;
	}
	public void setPublishingDate(String publishingDate) {
		this.publishingDate = publishingDate;
	}
	@Override
	public String toString() {
		return "Book [bookName=" + bookName + ", author=" + author
				+ ", publishing=" + publishing + ", publishingDate="
				+ publishingDate + "]";
	}
}
