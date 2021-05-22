package com.example.graphql.graphqldemo.dao;

import java.util.List;
import java.util.stream.Collectors;

import com.example.graphql.graphqldemo.domain.Book;

public class BookDao {

	private List<Book> books;

	public BookDao(List<Book> books) {
		this.books = books;
	}

	public List<Book> getRecentBooks(int count, int offset) {
		return books.stream().skip(offset).limit(count).collect(Collectors.toList());
	}

	public List<Book> getAuthorBooks(String author) {
		return books.stream().filter(book -> author.equals(book.getAuthorId())).collect(Collectors.toList());
	}

	public void saveBook(Book post) {
		books.add(0, post);
	}

}
