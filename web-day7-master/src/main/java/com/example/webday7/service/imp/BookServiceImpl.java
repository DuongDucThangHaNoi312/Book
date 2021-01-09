package com.example.webday7.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.webday7.entity.Book;
import com.example.webday7.repository.BookRepository;
import com.example.webday7.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	private BookRepository bookRepository;

	@Autowired
	public BookServiceImpl(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	public List<Book> findAll() {
		return bookRepository.findAll();
	}

	@Override
	public Book findById(long id) {
		return bookRepository.findById(id);
	}

	@Override
	@Transactional
	public void insert(Book b) {
		bookRepository.insert(b);
	}

	@Override
	@Transactional
	public void update(Book b) {
		bookRepository.update(b);
	}

	@Override
	@Transactional
	public void delete(long id) {
		Book b = bookRepository.findById(id);
		bookRepository.delete(b);
	}

}
