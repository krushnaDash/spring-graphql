package com.example.graphql.graphqldemo.domain;

/**
 * This bean represent a type in GraphQL schema, the name class may not
 * necessary to same with type. Fields inside the Java bean will directly map
 * onto fields in the GraphQL response based on the name of the field.
 * 
 * Any fields or methods on the Java bean that do not map on to the GraphQL
 * schema will be ignored, but will not cause problems. This is important for
 * field resolvers to work.
 *
 */
public class Book {
	String id;
	String name;
	int pageCount;

	/**
	 * As per schema we should have a field author By default it will look for below
	 * in
	 * 
	 * com.example.graphql.graphqldemo.domain.Book.author()
	 * com.example.graphql.graphqldemo.domain.Book.getAuthor()
	 * com.example.graphql.graphqldemo.domain.Book.author
	 * 
	 * To solve this we can write a resolver and there we can provide a method with
	 * above signature example
	 * 
	 * @com.example.graphql.graphqldemo.resolver.BookResolver
	 * 
	 */

	String authorId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public String getAuthorId() {
		return authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

}
