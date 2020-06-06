package com.example.DemoGraphQL.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.DemoGraphQL.model.Author;
import com.example.DemoGraphQL.model.Book;
import com.example.DemoGraphQL.repository.AuthorRepository;
import com.example.DemoGraphQL.repository.BookRepository;

public class QueryTest implements GraphQLQueryResolver {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    public QueryTest(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    /*
    all queries are defined under "type query" in in schema files
    Define resolvers: query, mutation and for joins
    * */
    public Iterable<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    /*
    * This name and return type should match to the one defined in schema file.
    * */

    public Iterable<Author> findOneAuthors() {
        return authorRepository.findAll();
    }

    public long countBooks() {
        return bookRepository.count();
    }
    public long countAuthors() {
        return authorRepository.count();
    }
}
