package com.example.graphql.graphqldemo.dao;

import java.util.List;
import java.util.Optional;

import com.example.graphql.graphqldemo.domain.Author;

public class AuthorDao {
	private List<Author> authors;

	public AuthorDao(List<Author> authors) {
		this.authors = authors;
	}

	public Optional<Author> getAuthor(String id) {
		return authors.stream().filter(author -> id.equals(author.getId())).findFirst();
	}
}
