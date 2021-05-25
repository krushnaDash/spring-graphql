package com.example.graphql.graphqldemo.resolver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.graphql.graphqldemo.dao.BookDao;
import com.example.graphql.graphqldemo.domain.Author;
import com.example.graphql.graphqldemo.domain.Book;
@Component
public class AuthorResolver implements GraphQLResolver<Author> {
	private BookDao bookDao;

	@Autowired
	public AuthorResolver(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	public List<Book> getBooks(Author author) {
		return bookDao.getAuthorBooks(author.getId());
	}
	/**
	 * This will take priority for the firstName
	 * @param author
	 * @return
	 */
	public String getFirstName(Author author) {
		return "Krushna "+ author.getFirstName();
	}
}