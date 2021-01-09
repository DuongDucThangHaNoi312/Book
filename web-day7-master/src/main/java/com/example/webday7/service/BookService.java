package com.example.webday7.service;

import java.util.List;

import com.example.webday7.entity.Book;

public interface BookService {

	List<Book> findAll();

	Book findById(long id);

	void insert(Book b);

	void update(Book b);

	void delete(long id);
}
