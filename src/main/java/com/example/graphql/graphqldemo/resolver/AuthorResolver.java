package com.example.graphql.graphqldemo.resolver;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.graphql.graphqldemo.dao.BookDao;
import com.example.graphql.graphqldemo.domain.Author;
import com.example.graphql.graphqldemo.domain.Book;

public class AuthorResolver implements GraphQLResolver<Author> {
	private BookDao bookDao;

	public AuthorResolver(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	public List<Book> getBooks(Author author) {
		return bookDao.getAuthorBooks(author.getId());
	}
}