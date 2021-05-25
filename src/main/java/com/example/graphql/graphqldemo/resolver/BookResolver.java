package com.example.graphql.graphqldemo.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.graphql.graphqldemo.dao.AuthorDao;
import com.example.graphql.graphqldemo.domain.Author;
import com.example.graphql.graphqldemo.domain.Book;
@Component
public class BookResolver implements GraphQLResolver<Book> {
	@Autowired
	AuthorDao authorDao;
	
	public Author getAuthor(Book book) {
		return authorDao.getAuthor(book.getAuthorId()).orElse(null);
	}

}
