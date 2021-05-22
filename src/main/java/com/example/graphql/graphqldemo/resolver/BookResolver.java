package com.example.graphql.graphqldemo.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.graphql.graphqldemo.dao.AuthorDao;
import com.example.graphql.graphqldemo.domain.Author;
import com.example.graphql.graphqldemo.domain.Book;

public class BookResolver implements GraphQLResolver<Book> { 

	private AuthorDao authorDao;

    public BookResolver(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    public Author getAuthor(Book book) {
        return authorDao.getAuthor(book.getAuthorId()).orElseThrow(RuntimeException::new);
    }
    
}
