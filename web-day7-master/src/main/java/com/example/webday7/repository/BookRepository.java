package com.example.webday7.repository;

import java.util.List;

import com.example.webday7.entity.Book;

public interface BookRepository {

	List<Book> findAll();

	Book findById(long id);

	void insert(Book b);

	void update(Book b);

	void delete(Book b);

}
