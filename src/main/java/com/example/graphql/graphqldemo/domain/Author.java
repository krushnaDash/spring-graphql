package com.example.graphql.graphqldemo.domain;
/**
 *  @author k0d03gd
 * As per the GraphQL schema we should have method or filed like below  
 *com.example.graphql.graphqldemo.domain.Author.books()
  com.example.graphql.graphqldemo.domain.Author.getBooks()
  com.example.graphql.graphqldemo.domain.Author.books
  
  If we can provide the same in a resolver then that will be used see @
  com.example.graphql.graphqldemo.resolver.AuthorResolver
  
  if same method available in both domain and resolver and then resolver one will take priority
 *
 */
public class Author {
	private String id;
	private String firstName;
	private String lastName;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
