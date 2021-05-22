package com.example.graphql.graphqldemo.resolver;

import java.util.List;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.graphql.graphqldemo.dao.BookDao;
import com.example.graphql.graphqldemo.domain.Book;

/**
 * 
 * @author k0d03gd 
 *         The root query needs to have special beans defined in the
 *         Spring context to handle the various fields in this root query.
 *         Unlike the schema definition, there is no restriction that there only
 *         be a single Spring bean for the root query fields.
 * 
 *         The only requirements are that the beans implement
 *         GraphQLQueryResolver and that every field in the root query from the
 *         scheme has a method in one of these classes with the same name.
 */
public class Query implements GraphQLQueryResolver {
    private BookDao postDao;

    public Query(BookDao postDao) {
        this.postDao = postDao;
    }

    public List<Book> getRecentBooks(int count, int offset) {
        return postDao.getRecentBooks(count, offset);
    }
}