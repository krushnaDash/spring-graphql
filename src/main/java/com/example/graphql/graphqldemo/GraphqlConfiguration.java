package com.example.graphql.graphqldemo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.graphql.graphqldemo.dao.AuthorDao;
import com.example.graphql.graphqldemo.dao.BookDao;
import com.example.graphql.graphqldemo.domain.Author;
import com.example.graphql.graphqldemo.domain.Book;
import com.example.graphql.graphqldemo.resolver.AuthorResolver;
import com.example.graphql.graphqldemo.resolver.BookResolver;
import com.example.graphql.graphqldemo.resolver.Mutation;
import com.example.graphql.graphqldemo.resolver.Query;

@Configuration
public class GraphqlConfiguration {
    @Bean
    public BookDao bookDao() {
        List<Book> books = new ArrayList<>();
        for (int bookId = 0; bookId < 10; ++bookId) {
            for (int authorId = 0; authorId < 10; ++authorId) {
                Book book = new Book();
                book.setId("book" + authorId + bookId);
                book.setName("Book " + authorId + ":" + bookId);
                book.setPageCount(100);
                book.setAuthorId("Author" + authorId);
                books.add(book);
            }
        }
        return new BookDao(books);
    }

    @Bean
    public AuthorDao authorDao() {
        List<Author> authors = new ArrayList<>();
        for (int authorId = 0; authorId < 10; ++authorId) {
            Author author = new Author();
            author.setId("Author" + authorId);
            author.setFirstName("Author " + authorId);
            author.setLastName("Author Last" + authorId);
            authors.add(author);
        }
        return new AuthorDao(authors);
    }

    @Bean
    public BookResolver bookResolver(AuthorDao authorDao) {
        return new BookResolver(authorDao);
    }

    @Bean
    public AuthorResolver authorResolver(BookDao bookDao) {
        return new AuthorResolver(bookDao);
    }

    @Bean
    public Query query(BookDao bookDao) {
        return new Query(bookDao);
    }

    @Bean
    public Mutation mutation(BookDao bookDao) {
        return new Mutation(bookDao);
    }
}