package com.example.graphql.graphqldemo.resolver;

import java.util.UUID;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.graphql.graphqldemo.dao.BookDao;
import com.example.graphql.graphqldemo.domain.Author;
import com.example.graphql.graphqldemo.domain.Book;

public class Mutation implements GraphQLMutationResolver {
	private BookDao bookDao;

	public Mutation(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	public Book addBook(String name, int pageCount, String author) {
		Book book = new Book();
		book.setId(UUID.randomUUID().toString());
		book.setName(name);
		book.setPageCount(pageCount);
		book.setAuthorId(author);
		bookDao.saveBook(book);
		return book;
	}
	
	public Author addAuthor(String firstName, String lastName) {
		Author a= new Author();
		a.setFirstName(firstName);
		a.setLastName(lastName);
		a.setId(UUID.randomUUID().toString());
		return a;
	}
}